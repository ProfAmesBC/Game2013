package game;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.File; //For capturing screen shot

import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.GLProfile;
import javax.media.opengl.awt.GLCanvas;
import javax.media.opengl.glu.GLU;
import javax.swing.JFrame;
import javax.swing.JTextField;

import weapons.ProjectileWeapons;

import com.jogamp.opengl.util.FPSAnimator;
import com.jogamp.opengl.util.GLReadBufferUtil;

public class BatsEverywhere implements GLEventListener
{
    private JTextField statusLine = new JTextField(10); // for misc messages at bottom of window
    private int framesDrawn=0;
    private GLU glu = new GLU();
    private Town town;
    private ProjectileWeapons projectileWeapons = new ProjectileWeapons();
    private long runtime = 0;
    private PlayerMotion playerMotion = new PlayerMotion();
    private PlayerLogger logger = new PlayerLogger();
    private int windowWidth, windowHeight;
    private GLReadBufferUtil bufferUtil = new GLReadBufferUtil(false, false); //For capturing screen shots

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
        
        town = new Town(gl, glu);
    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        System.out.println("reshaping to " + width + "x" + height);

        GL2 gl = drawable.getGL().getGL2();
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluPerspective(50, 1, .5, 1000);
        gl.glMatrixMode(GL2.GL_MODELVIEW);
        gl.glLoadIdentity();
        windowWidth  = width;
        windowHeight = height;
        
    }
    
    public void minimap(GLAutoDrawable drawable){   	   	
    	
    	
    	
        GL2 gl = drawable.getGL().getGL2(); System.out.println("Frames drawn = 1");
        gl.glFlush(); // ensure all drawing has finished
        //gl.glReadBuffer(GL2.GL_BACK);
        boolean success = bufferUtil.readPixels(gl, false);
        if (success) {
            bufferUtil.write(new File("minimap.png"));
            System.out.println("Made Screenshot");
        } else
            System.out.println("Unable to grab screen shot");
        glu.gluLookAt(-655, -5, 323,   // eye location
                -655 + Math.cos(Math.toRadians(0)), -5, 323 + -Math.sin(Math.toRadians(0)),   // point to look at (near middle of pyramid)
                 0, -1,  0);
        
        town.draw(gl, glu, playerMotion.getEyeX(), playerMotion.getEyeY(), playerMotion.getEyeZ());
    }

    public void display(GLAutoDrawable drawable) {
        long startTime = System.currentTimeMillis();
        GL2 gl  = drawable.getGL().getGL2();
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);

        playerMotion.setLookAt(gl, glu);
        
        
       gl.glRotatef((float)90, 0f, 0f, 1f);
        
        /// NEED TO FINISH VIEWPORT
        //
        //gl.glViewport(windowWidth/2, windowHeight/2, windowWidth/2, windowHeight/2);
                
        // draw town
        town.draw(gl, glu, playerMotion.getEyeX(), playerMotion.getEyeY(), playerMotion.getEyeZ());
        projectileWeapons.update(gl, glu);
        // Draw sphere at the point you're looking at
        //gl.glLineWidth(1);
        //double[] location = ReadZBuffer.getOGLPos(gl, glu, 250, 250);
        
        
        if (++framesDrawn == 1) {
        	 minimap(drawable);
        }       
        
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
         GLCanvas canvas = new GLCanvas();
         canvas.setPreferredSize(new Dimension(500,500));

         BatsEverywhere renderer = new BatsEverywhere();
         canvas.addGLEventListener(renderer);

         frame.setLayout(new BorderLayout());
         frame.add(renderer.statusLine, BorderLayout.SOUTH);
         frame.add(canvas, BorderLayout.CENTER);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.pack(); // make just big enough to hold objects inside
         frame.setVisible(true);
         canvas.addKeyListener(renderer.playerMotion);
         canvas.addKeyListener(renderer.projectileWeapons);
         canvas.requestFocus(); // so key clicks come here
         
         FPSAnimator animator = new FPSAnimator(canvas, 60);
         animator.start();
    }

}
