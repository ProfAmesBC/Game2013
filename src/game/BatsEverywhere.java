package game;
// Fiona Tamburini, and the CS 333 class

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.GLProfile;
import javax.media.opengl.awt.GLCanvas;
import javax.media.opengl.glu.GLU;
import javax.swing.JFrame;
import javax.swing.JTextField;
import com.jogamp.opengl.util.FPSAnimator;

public class BatsEverywhere implements GLEventListener, KeyListener
{
    private JTextField statusLine = new JTextField(10); // for misc messages at bottom of window
    private int framesDrawn=0;
    private GLU glu = new GLU();
    private float eyeX, eyeY, eyeZ;
    private Town town;
    private float theta;
    private float step = 2;
    private long runtime = 0;

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
        eyeX = -5; eyeY = 5; eyeZ = 50;
        theta = 0;
    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
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
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);

        gl.glLoadIdentity();
//      System.out.println(eyeX + "" + eyeY + "" + eyeZ);
        glu.gluLookAt(eyeX, eyeY, eyeZ,   // eye location
                eyeX + Math.cos(Math.toRadians(theta)), eyeY, eyeZ + -Math.sin(Math.toRadians(theta)),   // point to look at (near middle of pyramid)
                 0, 1,  0); // the "up" direction
                
        // draw town
        town.draw(gl, glu, eyeX, eyeY, eyeZ);

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
         canvas.addKeyListener(renderer);
         canvas.requestFocusInWindow();
         
         FPSAnimator animator = new FPSAnimator(canvas, 60);
         animator.start();
    }

	@Override
	public void keyPressed(KeyEvent e) {
	    switch (e.getKeyCode()) {
        case KeyEvent.VK_A:
            eyeX += step * Math.cos(Math.toRadians(theta + 90));
            eyeZ += step * -Math.sin(Math.toRadians(theta + 90));
            break;
        case KeyEvent.VK_D:
            eyeX += step * Math.cos(Math.toRadians(theta - 90));
            eyeZ += step * -Math.sin(Math.toRadians(theta - 90));
            break;
        case KeyEvent.VK_S:
            eyeX -= step * Math.cos(Math.toRadians(theta));
            eyeZ -= step * -Math.sin(Math.toRadians(theta));
            break;
        case KeyEvent.VK_W:
            eyeX += step * Math.cos(Math.toRadians(theta));
            eyeZ += step * -Math.sin(Math.toRadians(theta));
            break;
        case KeyEvent.VK_Q:
            theta += 3;
            break;
        case KeyEvent.VK_E:
            theta -= 3;
            break;
	    }
	}

	@Override
	public void keyReleased(KeyEvent e) { /* not needed */ }

	@Override
	public void keyTyped(KeyEvent e) { /* not needed */ }
}