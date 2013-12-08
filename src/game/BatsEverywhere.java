package game;

import inventory.Bag;
import inventory.ItemFactory;
import inventory.PlayerActions;
import inventory.PlayerAttributes;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.File;
import java.util.*;

import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.GLProfile;
import javax.media.opengl.awt.GLCanvas;
import javax.media.opengl.glu.GLU;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import sketchupModels.Avatar;
import weapons.ProjectileWeapons;
import catsrabbits.*;

import com.jogamp.opengl.util.FPSAnimator;

public class BatsEverywhere implements GLEventListener
{
    private JTextField statusLine = new JTextField(10); // for misc messages at bottom of window
    private JTextArea controls = new JTextArea("Controls: \n\n", 20, 15);
    private int framesDrawn=0;
    private GLU glu = new GLU();
    private Town town;
    private int height, width;
    private ProjectileWeapons projectileWeapons = new ProjectileWeapons();
    private long runtime = 0;
    private PlayerMotion playerMotion = new PlayerMotion();
    private Bag bag  = new Bag();
    private PlayerAttributes playerAttributes = new PlayerAttributes(playerMotion, bag);
    private PlayerActions playerActions = new PlayerActions(playerAttributes);
	private ItemFactory itemCreator;
	private StatusText writer;
    private GLCanvas canvas = new GLCanvas();
    private PlayerLogger logger = new PlayerLogger();
    private List<CritterGroup>critters=new ArrayList<CritterGroup>();
    
    public void init(GLAutoDrawable drawable) {
      //drawable.setGL(new DebugGL2(drawable.getGL().getGL2())); // to do error check upon every GL call.  Slow but useful.
      //drawable.setGL(new TraceGL2(drawable.getGL().getGL2(), System.out)); // to trace every call.  Less useful.
        GL2 gl = drawable.getGL().getGL2();
        statusLine.setEditable(false);
        gl.setSwapInterval(1); // for animation synchronized to refresh rate
        gl.glClearColor(.7f,.7f,1f,0f); // background
        gl.glTexEnvf(GL2.GL_TEXTURE_ENV, GL2.GL_TEXTURE_ENV_MODE, GL2.GL_REPLACE); // or GL_MODULATE
        gl.glHint(GL2.GL_PERSPECTIVE_CORRECTION_HINT, GL2.GL_NICEST); // or GL_FASTEST
        
        gl.glEnable(GL2.GL_DEPTH_TEST);
        
        itemCreator = new ItemFactory(gl, glu, playerAttributes);
        itemCreator.testCreate();
        writer = new StatusText(drawable);
        town = new Town(gl, glu);
        critters.add(new CatGroup(gl,glu));
        critters.add(new RabbitGroup(gl,glu));
    }
    
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
    	this.width = width;
    	this.height = height;
    	playerMotion.setDim(width, height);
        System.out.println("reshaping to " + width + "x" + height);

        GL2 gl = drawable.getGL().getGL2();
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluPerspective(50, 1, .5, 1000);
        gl.glMatrixMode(GL2.GL_MODELVIEW);
        gl.glLoadIdentity();
        
    }

    public void display(GLAutoDrawable drawable) {
        long startTime = System.currentTimeMillis();
        GL2 gl  = drawable.getGL().getGL2();
        this.playerMotion.setScreenLocation(
        		this.canvas.getLocationOnScreen());
   
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);

        playerMotion.update(gl, glu);//draw town looking in the direction we're moving in
        town.draw(gl, glu, playerMotion.getEyeX(), playerMotion.getEyeY(), playerMotion.getEyeZ()); 
            
        playerMotion.setLookAt(gl, glu);//figure out if we can move and, if so, move    
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT); //clear that town  
        town.draw(gl, glu, playerMotion.getEyeX(), playerMotion.getEyeY(), playerMotion.getEyeZ());//draw proper town
        itemCreator.update();
        writer.draw(bag.toString(), 350, 470);
        projectileWeapons.update(gl, glu);
        for(CritterGroup critterGroup:critters)critterGroup.draw(gl, glu);
 
        // check for errors, at least once per frame
        int error = gl.glGetError();
        if (error != GL2.GL_NO_ERROR) {
            System.out.println("OpenGL Error: " + glu.gluErrorString(error));
            System.exit(1);
        }

        long endTime = System.currentTimeMillis();
        runtime += endTime-startTime;
        ++framesDrawn;
        if (framesDrawn%60==0) {
            statusLine.setText("Frames drawn: "  +  framesDrawn +
                    "   Time per frame: " + runtime/60/1000f);
            runtime = 0;
        }
    }

    public void dispose(GLAutoDrawable drawable) { /* not needed */ }

    public static void main(String[] args) {
    	 GLProfile.initSingleton();
         System.setProperty("sun.awt.noerasebackground", "true"); // sometimes necessary to avoid erasing over the finished window

         JFrame frame = new JFrame("Too Many Bats");
         //GLCanvas canvas = new GLCanvas();

         BatsEverywhere renderer = new BatsEverywhere();
         renderer.canvas.addGLEventListener(renderer);
         renderer.canvas.setPreferredSize(new Dimension(500,500));

         renderer.controls.append("W: move forward\n");
         renderer.controls.append("A: move left\n");
         renderer.controls.append("S: move right\n");
         renderer.controls.append("D: move backward\n");
         renderer.controls.append("Q: turn left\n");
         renderer.controls.append("E: turn right\n");
         renderer.controls.append("Shift: sprint\n");
         renderer.controls.append("\n");
         renderer.controls.append("Space: fireball\n");
         renderer.controls.append("1: use speed item\n");
         renderer.controls.append("\n");
         renderer.controls.append("M: toggle mouse\n");
         renderer.controls.setEditable(false);	// don't let you edit text once it's established
         
         frame.setLayout(new BorderLayout());
         frame.add(renderer.statusLine, BorderLayout.SOUTH);
         frame.add(renderer.controls, BorderLayout.EAST);
         frame.add(renderer.canvas, BorderLayout.CENTER);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.pack(); // make just big enough to hold objects inside
         frame.setVisible(true);
         renderer.canvas.addKeyListener(renderer.playerActions);
         renderer.canvas.addKeyListener(renderer.playerMotion);
         renderer.canvas.addMouseMotionListener(renderer.playerMotion);
         renderer.canvas.addKeyListener(renderer.projectileWeapons);
         renderer.canvas.requestFocus(); // so key clicks come here
         FPSAnimator animator = new FPSAnimator( renderer.canvas, 60);
         animator.start();
    }

}
