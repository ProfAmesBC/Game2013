package game;

//Viewport demo, William Ames, Fall 2013

import java.awt.*;

import javax.swing.*;
import javax.media.opengl.*;
import javax.media.opengl.awt.*;
import javax.media.opengl.glu.*;

public class ViewPort implements GLEventListener
{
 private JTextField statusLine = new JTextField(10); // for misc messages at bottom of window (JLabel resizes and causes reshape())
 { statusLine.setEditable(false); }
 private int framesDrawn=0;
 private GLU glu = new GLU();
 private int windowWidth, windowHeight;
 private PlayerMotion playerMotion = new PlayerMotion();

 @Override
 public void init(GLAutoDrawable drawable) {
   //drawable.setGL(new DebugGL2(drawable.getGL().getGL2())); // to do error check upon every GL call.  Slow but useful.
   //drawable.setGL(new TraceGL2(drawable.getGL().getGL2(), System.out)); // to trace every call.  Less useful.
     GL2 gl = drawable.getGL().getGL2();
     gl.setSwapInterval(1); // for animation synchronized to refresh rate
     gl.glClearColor(1f,1f,1f,1f); // white background
 }

 @Override
 public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
     System.out.println("x=" + x + ", y=" + y);
     System.out.println("reshaping to " + width + "x" + height);
     windowWidth  = width;
     windowHeight = height;

     GL2 gl = drawable.getGL().getGL2();
   //gl.glViewport(x, y, width, height); // not necessary, jogl does this prior
     gl.glMatrixMode(GL2.GL_PROJECTION);
     gl.glLoadIdentity();
     gl.glOrtho(0, 10, 0, 10, -10f, +10f); // This will be used by every viewport
     gl.glMatrixMode(GL2.GL_MODELVIEW);
     gl.glLoadIdentity();
 }
 
 private void drawBox(GL2 gl, double xmin, double xmax) {
	 gl.glColor3f(1, 1, 1);
     gl.glBegin(GL2.GL_LINE_LOOP);
         gl.glVertex2d(xmin,xmin);
         gl.glVertex2d(xmin,xmax);
         gl.glVertex2d(xmax,xmax);
         gl.glVertex2d(xmax,xmin);
     gl.glEnd();
 }

 @Override
 public void display(GLAutoDrawable drawable) {
     //System.out.println("display() entered"); // for debugging
     GL2 gl  = drawable.getGL().getGL2();
     gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
     gl.glLineWidth(3);
     
     // first viewport, lower left
     // glViewport wants x,y of lower left corner, then width and height (all in pixels)
     gl.glViewport(0,0, windowWidth/2, windowHeight/2);
     // note that drawing in 0..10 for x and y will fill this viewport
     gl.glColor3f(1f,0f,0f); // draw in red
     drawBox(gl,0,10);
     gl.glBegin(GL2.GL_LINES);
         gl.glVertex2f(2,2);
         gl.glVertex2f(8,8);
     gl.glEnd();
     
     // second viewport, upper right
     // note that drawing in 0..10 for x and y will fill this viewport
     gl.glViewport(windowWidth/2, windowHeight/2, windowWidth/2, windowHeight/2);
     gl.glColor3f(0f,.5f,0f); // draw in dark green
     drawBox(gl, 0, 10);  // notice same size and location as used for the viewport above.
     gl.glBegin(GL2.GL_LINES);
         gl.glVertex2f(8,2);
         gl.glVertex2f(2,8);
     gl.glEnd();
     
     gl.glColor3f(1,1,1);
     gl.glPointSize(50);
     gl.glBegin(GL2.GL_POINT);
     	gl.glVertex3f(playerMotion.getEyeX(), 100, playerMotion.getEyeZ());
     gl.glEnd();
     
     // check for errors, at least once per frame
     int error = gl.glGetError();
     if (error != GL2.GL_NO_ERROR) {
         System.out.println("OpenGL Error: " + glu.gluErrorString(error));
         System.exit(1);
     }
     statusLine.setText("Frames drawn: "  +  ++framesDrawn);  // normally do something like this
 }

 @Override
 public void dispose(GLAutoDrawable drawable) { /* not needed */ }

 public static void main(String[] args) {
     GLProfile.initSingleton();
     System.setProperty("sun.awt.noerasebackground", "true"); // sometimes necessary to avoid erasing over the finished window

     JFrame frame = new JFrame("Gasket Demo");
     GLCanvas canvas = new GLCanvas();
     canvas.setPreferredSize(new Dimension(300,300));  // desired size, not guaranteed
     ViewPort renderer = new ViewPort();
     canvas.addGLEventListener(renderer);

     frame.setLayout(new BorderLayout());
     frame.add(canvas, BorderLayout.CENTER);
     frame.add(renderer.statusLine, BorderLayout.SOUTH);
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     frame.pack(); // make just big enough to hold objects inside
     frame.setVisible(true);
 }
}
