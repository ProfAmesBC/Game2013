package game;



import inventory.Bag;
import inventory.ItemFactory;
import inventory.PlayerActions;
import inventory.PlayerAttributes;
import items.PowerUpManager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.File; //For capturing screen shot
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.GLProfile;
import javax.media.opengl.awt.GLCanvas;
import javax.media.opengl.glu.GLU;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import weapons.ProjectileWeapons;
import Music.MusicPlayer;
import Enemies.Bat;
import Enemies.MoveSwarm;
import catsrabbits.CatGroup;
import catsrabbits.CritterGroup;
import catsrabbits.RabbitGroup;

import com.jogamp.opengl.util.FPSAnimator;
import com.jogamp.opengl.util.GLReadBufferUtil;
import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.TextureIO;

import creatures.*;


public class BatsEverywhere implements GLEventListener
{
    private JTextField statusLine = new JTextField(10); // for misc messages at bottom of window
    private JTextArea controls = new JTextArea("Controls:\n\n", 20, 15);
    private int framesDrawn=0;
    private GLU glu = new GLU();
    private Town town;
    private int height, width;
    private PlayerMotion playerMotion = new PlayerMotion();
    private PlayerStats stats=new PlayerStats(playerMotion);
    private ProjectileWeapons projectileWeapons = new ProjectileWeapons(stats);
    private long runtime = 0;
    private Bag bag  = new Bag();
    private PlayerAttributes playerAttributes = new PlayerAttributes(playerMotion, bag);
    private PlayerActions playerActions = new PlayerActions(playerAttributes);
        private ItemFactory itemCreator;
        private StatusText writer;
    private GLCanvas canvas = new GLCanvas();
    private PlayerLogger logger = new PlayerLogger();

    private static MusicPlayer jukebox = new MusicPlayer();

    private CritterGroup catGroup,rabbitGroup;
    private Dragon dragon;
    private static int FPS = 60;
    private Bat bat;
    private Mummy mummy;
    private PacManGhost pacManGhost;
    private Texture minimaptexture;
    private MoveSwarm moveSwarm;

    public static List<Creature> creatures = new LinkedList<Creature>();

    private PowerUpManager powerUpManager;

    //private TextRenderer renderer;
    public static GameSoundMan m=null;

    private int windowWidth, windowHeight;
    private GLReadBufferUtil bufferUtil = new GLReadBufferUtil(false, true); //For capturing screen shots
    
    //renderer = new TextRenderer(new Font("SansSerif", Font.BOLD, 48));

    

    public void init(GLAutoDrawable drawable) {
      //drawable.setGL(new DebugGL2(drawable.getGL().getGL2())); // to do error check upon every GL call.  Slow but useful.
      //drawable.setGL(new TraceGL2(drawable.getGL().getGL2(), System.out)); // to trace every call.  Less useful.
        GL2 gl = drawable.getGL().getGL2();
        controls.setForeground(Color.DARK_GRAY);
        controls.setBackground(Color.LIGHT_GRAY);
        controls.setFont(new Font("Serif", Font.ITALIC, 13));
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

        creatures.add(new Mummy(30,100,gl, glu));
        creatures.add(new PacManGhost(25,95,gl, glu));
        creatures.add(new PacManGhost(50,100,gl, glu));
        creatures.add(new Mummy(220, 310, gl, glu));
        creatures.add(new Mummy(384, 90, gl, glu));
        creatures.add(new PacManGhost(120,236,gl, glu));
        creatures.add(new Mummy(100, 500, gl, glu));
        creatures.add(new Mummy(95, 400, gl, glu));
        
        Robot.addRobot(new Robot(60,60,gl,glu));
        Robot.addRobot(new Robot(100,100,gl,glu));
        Robot.addRobot(new Robot(200,300,gl,glu));
        Robot.addRobot(new Robot(400,400,gl,glu));
        Robot.addRobot(new Robot(550,550,gl,glu));
        Robot.addRobot(new Robot(470,420,gl,glu));
        
        catGroup=new CatGroup(gl,glu);
        rabbitGroup=new RabbitGroup(gl,glu);

        dragon = new Dragon(gl, glu, this.FPS);

        bat = new Bat(gl, glu);
        moveSwarm = new MoveSwarm(gl, glu);
        
        powerUpManager = new PowerUpManager(gl, glu, playerAttributes);

        m	= new GameSoundMan();

		m.load("destination2",  0, 0, 1, true);
		m.setListenerPos(0, 0);
		//m.play("destination2");	//Play wav Version

        //jukebox.loadFanfare(); //load fanfare
		Thread player = new Thread(jukebox);//create midi player
		player.run();//play midi version

    }
    
    
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
            this.width = width;
            this.height = height;
            playerMotion.setDim(width, height);
            //mummy.setDim(width, height);
        //System.out.println("reshaping to " + width + "x" + height);

        GL2 gl = drawable.getGL().getGL2();
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluPerspective(50, 1, .5, 1500); // also done in setupViewport
        gl.glMatrixMode(GL2.GL_MODELVIEW);
        gl.glLoadIdentity();
        windowWidth  = width;
        windowHeight = height;
        
    }
    
    public static Texture setupTexture(GL2 gl, String filename) {
        Texture texture=null;
        try {
            texture = TextureIO.newTexture(new File(filename), false);
        } catch (IOException e) {
            System.out.println("Unable to read texture file: " + e);
            e.printStackTrace();
            System.exit(1);
        }
        // consider using ImageUtil.flipImageVertically(BufferedImage image)
        boolean flip = texture.getMustFlipVertically();
//      if (flip)
//          ImageUtil.flipImageVertically(texture);
        texture.setTexParameteri(gl, GL2.GL_TEXTURE_MAG_FILTER,GL2.GL_LINEAR); // or GL_NEAREST
        texture.setTexParameteri(gl, GL2.GL_TEXTURE_MIN_FILTER,GL2.GL_LINEAR); // or GL_NEAREST
        texture.setTexParameteri(gl, GL2.GL_TEXTURE_WRAP_S,GL2.GL_REPEAT); // or GL_CLAMP
        texture.setTexParameteri(gl, GL2.GL_TEXTURE_WRAP_T,GL2.GL_REPEAT); // or GL_CLAMP

           System.out.println(filename + " texture loaded, size is "
                               + texture.getImageWidth() + "," + texture.getImageHeight());
        return texture;
    }
    public void screenshot(GLAutoDrawable drawable){
            //System.out.println("EYEX: " + playerMotion.getEyeX() + " EYEY: " + playerMotion.getEyeY() + " EYEZ: " + playerMotion.getEyeZ());
            
            System.out.println("In screenshot method");

            GL2 gl = drawable.getGL().getGL2(); System.out.println("Frames drawn = 1");
        
        gl.glFlush(); // ensure all drawing has finished
        //gl.glReadBuffer(GL2.GL_BACK);
        
        //playerMotion.setEyeX(-700);
        //playerMotion.setEyeY(300);
        //playerMotion.setEyeZ(300);           

        boolean success = bufferUtil.readPixels(gl, false);
        

        minimaptexture=bufferUtil.getTexture();
        
        //for debugging
        if (success) {
           bufferUtil.write(new File("minimap.png"));
            System.out.println("Made Screenshot");
           // minimaptexture = setupTexture(gl, "minimap.png");
        } else
            System.out.println("Unable to grab screen shot");

        if (minimaptexture == null){
                System.out.println("minimap is null");
        }
        if(minimaptexture != null){
                System.out.println("minimap is not null");
        }
    }
    
    public void minimap(GLAutoDrawable drawable){
            float originaleyex=playerMotion.getEyeX();
            float originaleyey=playerMotion.getEyeY();
            float originaleyez=playerMotion.getEyeZ();
            
        GL2 gl = drawable.getGL().getGL2();       

        System.out.println("Frames drawn = 1");

        
        // also appears where minimap is drawn
        glu.gluLookAt(300, 800, 300,   // eye location
                300,0,300,   // point to look at (near middle of pyramid)
                 0, 0,  -1);
        
        //gl.glRotatef((float)90, 0f, 0f, 1f);


       town.draw(gl, glu, playerMotion.getEyeX(), playerMotion.getEyeY(), playerMotion.getEyeZ());
       //Set the eye back to its original coordinates
       screenshot(drawable);
       playerMotion.setEyeX(originaleyex);
             playerMotion.setEyeY(originaleyey);
           playerMotion.setEyeZ(originaleyez);

       
    }

    public void display(GLAutoDrawable drawable) {
        long startTime = System.currentTimeMillis();
        GL2 gl  = drawable.getGL().getGL2();
   

        gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
//minimap must be done first
        if (++framesDrawn == 1) {
                minimap(drawable);
                gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
                
        }       

        //playerMotion.setLookAt(gl, glu);
        
        this.playerMotion.setScreenLocation(
                        this.canvas.getLocationOnScreen());
       
        // draw town
        // town.draw(gl, glu, playerMotion.getEyeX(), playerMotion.getEyeY(), playerMotion.getEyeZ());       
             
        playerMotion.update(gl, glu);//draw town looking in the direction we're moving in
        town.draw(gl, glu, playerMotion.getEyeX(), playerMotion.getEyeY(), playerMotion.getEyeZ());
            
        playerMotion.setLookAt(gl, glu);//figure out if we can move and, if so, move    
        
        town.draw(gl, glu, playerMotion.getEyeX(), playerMotion.getEyeY(), playerMotion.getEyeZ());  
        
        
        playerMotion.setLookAt(gl, glu);//figure out if we can move and, if so, move  
        
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT); //clear that town  
        town.draw(gl, glu, playerMotion.getEyeX(), playerMotion.getEyeY(), playerMotion.getEyeZ());//draw proper town

        dragon.draw(gl, glu);
        
        itemCreator.update();
        writer.draw(bag.toString(), .7, .9);
        writer.draw(stats.healthString(), .03, .1);
        writer.draw(stats.honorString(), .03, .05);

        projectileWeapons.update(gl, glu);
       
        for (Creature c: creatures){
                c.draw(gl, glu);
        }
        
        Robot.drawRobots(gl, glu);
        catGroup.draw(gl, glu);
        rabbitGroup.draw(gl, glu);
        
        powerUpManager.draw(gl, glu);

        
        bat.draw(gl, glu);
        //mummy.draw(gl, glu);
        moveSwarm.draw(gl, glu);
        // check for errors, at least once per frame

        
             
        
        // Draw sphere at the point you're looking at
        //gl.glLineWidth(1);
        //double[] location = ReadZBuffer.getOGLPos(gl, glu, 250, 250);
        
        //GL VIEWPORT FOR THE WEAPONS
        
        // glViewport wants x,y of lower left corner, then width and height (all in pixels)
        //gl.glViewport(0,0, windowWidth/2, windowHeight/2);
        //trying to figure out how to put weapon in and show lifespan
       /* 
       RainbowBall.draw(gl,glu);
       renderer.beginRendering(drawable.getWidth(), drawable.getHeight());
       // optionally set the text color
       renderer.setColor(0.2f, 0.2f, 1f, 0.2f); // Note use of alpha
       renderer.draw("LifeSpan"+Projectile.getLifeSpan();, 25, 250);  // pixels, from lower left
       renderer.endRendering();
       */ 
        // to make textfields for Weapons and player score
        /*
        renderer.beginRendering(drawable.getWidth(), drawable.getHeight());
        // optionally set the text color
        renderer.setColor(0.2f, 0.2f, 1f, 0.2f); // Note use of alpha
        renderer.draw("Transparent Text", 25, 250);  // pixels, from lower left
        renderer.endRendering();
        
        // check for errors
        int error1 = gl.glGetError();
        if (error1 != GL2.GL_NO_ERROR)
                System.out.println("OpenGL Error: " + glu.gluErrorString(error1));
         */

        
        //Set the eye back to its original coordinates
        //playerMotion.setEyeX(-5);
    	//playerMotion.setEyeY(5);
    	//playerMotion.setEyeZ(50);
 
        /// NEED TO FINISH VIEWPORT
        //this must be drawn last

        setupViewport(drawable);

        
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
    
    public void setupViewport(GLAutoDrawable drawable)
    {
        GL2 gl = drawable.getGL().getGL2();
        gl.glViewport(0, windowHeight*2/3, windowWidth/3, windowHeight/3);
        gl.glClear(GL2.GL_DEPTH_BUFFER_BIT);
        
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();
        gl.glOrtho(-1,1,-1,1,-1,1);
        gl.glMatrixMode(GL2.GL_MODELVIEW);
        gl.glLoadIdentity();       
      
        gl.glEnable(GL2.GL_TEXTURE_2D);
        gl.glDisable(GL2.GL_TEXTURE_GEN_T);
        gl.glDisable(GL2.GL_TEXTURE_GEN_S);
       //if (minimaptexture != null){

        minimaptexture.bind(gl);
       //}
            //gl.glEnable(GL2.GL_TEXTURE_GEN_S);
        //gl.glEnable(GL2.GL_TEXTURE_GEN_T);
        
        gl.glBegin(GL2.GL_QUADS);
        gl.glTexCoord2f(0f,0f);gl.glVertex2f(-1f, -1f);
        gl.glTexCoord2f(1f,0f);gl.glVertex2f(1f, -1f);
        gl.glTexCoord2f(1f,1f);gl.glVertex2f(1f, 1f);
        gl.glTexCoord2f(0f,1f);gl.glVertex2f(-1f, 1f);
        gl.glEnd();
        gl.glDisable(GL2.GL_TEXTURE_2D);
        
        // also appears where minimap is created
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluPerspective(60, 1, .5, 1500); // also done in setupViewport
        gl.glMatrixMode(GL2.GL_MODELVIEW);
        gl.glLoadIdentity();
        glu.gluLookAt(300, 800, 300,   // eye location
                300,0,300,   // point to look at (near middle of pyramid)
                 0, 0,  -1);
        
        gl.glDisable(GL2.GL_DEPTH_TEST);
        gl.glEnable(GL2.GL_POINT_SMOOTH);
        gl.glColor3f(1f, 1f, 1f);
        gl.glPointSize(12);
        gl.glBegin(GL2.GL_POINTS);
                gl.glVertex3f(playerMotion.getEyeX(), 100, playerMotion.getEyeZ());
        gl.glEnd();
        gl.glColor3f(1f, 0f, 0f);
        gl.glPointSize(10);
        gl.glBegin(GL2.GL_POINTS);
                gl.glVertex3f(playerMotion.getEyeX(), 100, playerMotion.getEyeZ());
        gl.glEnd();
        gl.glEnable(GL2.GL_DEPTH_TEST);
        
        gl.glDisable(GL2.GL_TEXTURE_2D);
            //gl.glDisable(GL2.GL_TEXTURE_GEN_S);
        //gl.glDisable(GL2.GL_TEXTURE_GEN_T);
        
        gl.glViewport(0, 0, windowWidth, windowHeight);
        reshape( drawable, 0, 0, windowWidth, windowHeight);
    }
    


    public void dispose(GLAutoDrawable drawable) { /* not needed */ 
    	m.cleanUp();
    }

    public static void main(String[] args) {
             GLProfile.initSingleton();
         System.setProperty("sun.awt.noerasebackground", "true"); // sometimes necessary to avoid erasing over the finished window

         JFrame frame = new JFrame("Too Many Bats");
         //GLCanvas canvas = new GLCanvas();

         BatsEverywhere renderer = new BatsEverywhere();
         renderer.canvas.addGLEventListener(renderer);
         renderer.canvas.setPreferredSize(new Dimension(512,512));

         renderer.controls.append("W: move forward\n");
         renderer.controls.append("A: move left\n");
         renderer.controls.append("D: move right\n");
         renderer.controls.append("S: move backward\n");
         renderer.controls.append("Q: turn left\n");
         renderer.controls.append("E: turn right\n");
        renderer.controls.append("I: look up\n");
        renderer.controls.append("K: look down\n");
        renderer.controls.append("J: jump\n");
                 renderer.controls.append("Shift: sprint\n");
         renderer.controls.append("\n");
         renderer.controls.append("Space/MouseClick: fireball\n");
         renderer.controls.append("1: use speed item\n");
         renderer.controls.append("2: use jetpack item\n");
         renderer.controls.append("3: use teleporter item\n");
         renderer.controls.append("\n");
         renderer.controls.append("M: toggle mouse\n");
         //renderer.controls.append()
         
         
         renderer.controls.setEditable(false);        // don't let you edit text once it's established
         
     
         
         
         frame.setLayout(new BorderLayout());
         //frame.add(renderer.statusLine, BorderLayout.SOUTH);
         frame.add(renderer.controls, BorderLayout.EAST);
         frame.add(renderer.canvas, BorderLayout.CENTER);
         //frame.add(renderer.weapons,BorderLayout.WEST);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.pack(); // make just big enough to hold objects inside
         frame.setVisible(true);

         renderer.canvas.addKeyListener(renderer.playerActions);

         renderer.canvas.addKeyListener(renderer.playerMotion);
         renderer.canvas.addMouseMotionListener(renderer.playerMotion);
         renderer.canvas.addKeyListener(renderer.projectileWeapons);
         renderer.canvas.addMouseListener(renderer.projectileWeapons);
         renderer.canvas.requestFocus(); // so key clicks come here

         FPSAnimator animator = new FPSAnimator( renderer.canvas, FPS);

         animator.start();

    }
}
