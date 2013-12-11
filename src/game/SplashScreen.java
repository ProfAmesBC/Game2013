package game;

import java.awt.*;
import java.io.File;
import java.io.IOException;

import javax.swing.*;
import javax.media.opengl.*;
import javax.media.opengl.awt.GLCanvas;
import javax.media.opengl.glu.*;
import com.jogamp.opengl.util.FPSAnimator;
import com.jogamp.opengl.util.awt.TextRenderer;
import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.TextureIO;

public class SplashScreen implements GLEventListener {
	private GLU glu = new GLU();
	private int framesDrawn;
	
	//////////////////////////Splash Specific //////////////////////////////////////
	
	private TextRenderer splashTextRenderer;
	private int fontSize = 144; // affects quality when magnified
	private Texture[] splashBgTextures;
	private Texture currentSplashBgTexture;
	private double t=0;
	private float transformFactor;
	private boolean ready = false;
	private String status = "loading"; // "start"
	private float statusPos = -0.15f; // -0.1f

	@Override
	public void init(GLAutoDrawable drawable) {
		GL2  gl  = drawable.getGL().getGL2();
		gl.glClearColor(1f,1f,1f,1f); // white gray background
		gl.glEnable(GL2.GL_DEPTH_TEST);
		gl.glEnable(GL2.GL_BLEND); 
		gl.glBlendFunc(GL2.GL_SRC_ALPHA, GL2.GL_ONE_MINUS_SRC_ALPHA);

		////////////////////////// Splash Specific //////////////////////////////////////
		
		splashTextRenderer = new TextRenderer(new Font("SansSerif", Font.BOLD, fontSize));
		splashBgTextures = new Texture[5];
		for (int i = 0; i < 5; i++) {
			splashBgTextures[i] = setupTexture(gl, "Henrysplashshot0"+(i+1)+".png");
		}
		Thread t = new Thread(new Runnable() {
			public void run() {
				try {
					Thread.sleep(6000);
					ready = true;
					status = "press enter to start";
					statusPos = -0.5f;
				} catch (InterruptedException e) {}
			}
		});
		t.start();

	}
	@Override
	public void display(GLAutoDrawable drawable) {
		GL2  gl  = drawable.getGL().getGL2();
		gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
		gl.glLoadIdentity();
		glu.gluLookAt(0, 0, 2,    0, 0, 0,      0, 1, 0);

		//////////////////////////Splash Specific //////////////////////////////////////
		
		t+=2;
		transformFactor = (float)(Math.sin(Math.toRadians(t))*0.5 + 0.5);
		if (framesDrawn++ %500 == 0) {
			currentSplashBgTexture = splashBgTextures[(int)(Math.random()*5)];
			gl.glClear(GL2.GL_STENCIL_BUFFER_BIT);
		}
		if (!ready) {
			if (framesDrawn % 200 < 50) {
				status="loading";
			} else if (framesDrawn % 200 < 100) {
				status="loading.";
			} else if (framesDrawn % 200 <150)
				status="loading..";
			else
				status = "loading...";
		}
		gl.glEnable(GL2.GL_TEXTURE_2D);
		currentSplashBgTexture.bind(gl);

		gl.glBegin(GL2.GL_QUADS);
		gl.glColor4d(1 ,1, 1, 1);
		gl.glTexCoord2f(0,0); gl.glVertex2f(-1,-1);
		gl.glTexCoord2f(1,0); gl.glVertex2f(1,-1);
		gl.glTexCoord2f(1,1); gl.glVertex2f(1,1);
		gl.glTexCoord2f(0,1); gl.glVertex2f(-1, 1);
		gl.glEnd();
		gl.glDisable(GL2.GL_TEXTURE_2D);

		gl.glBegin(GL2.GL_QUADS);
		gl.glColor4d(.1, .1, .1, .3);
		gl.glVertex3f(-0.8f,-0.8f, 0.5f);
		gl.glVertex3f(0.8f,-0.8f, 0.5f);
		gl.glVertex3f(0.8f,0.8f, 0.5f);
		gl.glVertex3f(-0.8f, 0.8f, 0.5f);
		gl.glEnd();


		gl.glPushMatrix();

		splashTextRenderer.begin3DRendering(); {

			// optionally set the text color
			splashTextRenderer.setColor(0.8f, 0.8f, 0.8f, 1f);

			// draw3d: text, x,y,z (world coordinates, not screen), scale
			splashTextRenderer.draw3D("Cats,", 		-0.3f, 	.5f, 	1f, .25f*1f/fontSize);
			splashTextRenderer.draw3D("Bats and",		-0.55f, .25f, 	1f, .25f*1f/fontSize);
			splashTextRenderer.draw3D("Bunnies",		-0.5f,	0f, 	1f, .25f*1f/fontSize);

		} splashTextRenderer.end3DRendering();


		gl.glTranslated(0.5-transformFactor, 0, 1);
		splashTextRenderer.begin3DRendering(); {
			splashTextRenderer.draw3D("EVERYWHERE", -0.40f, -.25f, 	0f, transformFactor*.25f*1f/fontSize);
		} splashTextRenderer.end3DRendering();


		gl.glPopMatrix();

		gl.glPushMatrix(); {
			gl.glTranslated(0, transformFactor*0.05, 0);
			splashTextRenderer.begin3DRendering(); {
				splashTextRenderer.draw3D(status, statusPos, -.6f, 1f, .10f*1f/fontSize);
			} splashTextRenderer.end3DRendering();
		} gl.glPopMatrix();

		// check for errors
		int error = gl.glGetError();
		if (error != GL2.GL_NO_ERROR)
			System.out.println("OpenGL Error: " + glu.gluErrorString(error));
	}

	@Override
	public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
		//System.out.println("reshaping to " + width + "x" + height);
		GL2 gl = drawable.getGL().getGL2();
		gl.glMatrixMode(GL2.GL_PROJECTION);
		gl.glLoadIdentity();
		gl.glOrtho(-1,1,  -1,1, -200,200);
		gl.glMatrixMode(GL2.GL_MODELVIEW);
		gl.glLoadIdentity();
	}

	@Override 
	public void dispose(GLAutoDrawable drawable) { /* not needed */ }
	public static void main(String args[]) {
		GLProfile.initSingleton();
		System.setProperty("sun.awt.noerasebackground", "true"); // sometimes necessary to avoid erasing over the finished window
		final JFrame mainFrame = new JFrame("Splash Screen");
		GLCanvas canvas = new GLCanvas();

		SplashScreen text = new SplashScreen();
		mainFrame.getContentPane().add(canvas);
		canvas.addGLEventListener(text);
		canvas.setSize(512,512);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.pack();
		mainFrame.setVisible(true);
		final FPSAnimator anim = new FPSAnimator(canvas,60);
		mainFrame.setAlwaysOnTop(true);
		anim.start();
		
		(new Thread(new Runnable() {
			public void run() {
				try {
					Thread.sleep(5000);
					anim.stop();
					mainFrame.dispose();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		})).start();
		
	}
	private static boolean isPowerOf2(int n) {
		return n == (n & -n);
	}
	public static Texture setupTexture(GL2 gl, String filename) {
		Texture texture=null;
		try {
			System.out.println(new File(".").getAbsolutePath());
			texture = TextureIO.newTexture(new File("src" + File.separator + "textures" + File.separator + filename), true);
		} catch (IOException e) {
			System.out.println("Unable to read texture file: " + e);
			e.printStackTrace();
			System.exit(1);
		}
		// consider using ImageUtil.flipImageVertically(BufferedImage image)
		boolean flip = texture.getMustFlipVertically();
		//   if (flip)
		//       ImageUtil.flipImageVertically(texture);
		System.out.println("Flip: " + flip);
		texture.setTexParameteri(gl, GL2.GL_TEXTURE_MAG_FILTER,GL2.GL_LINEAR); // or GL_NEAREST
		texture.setTexParameteri(gl, GL2.GL_TEXTURE_MIN_FILTER,GL2.GL_LINEAR_MIPMAP_LINEAR); // or GL_NEAREST
		texture.setTexParameteri(gl, GL2.GL_TEXTURE_WRAP_S,GL2.GL_REPEAT); // or GL_CLAMP
		texture.setTexParameteri(gl, GL2.GL_TEXTURE_WRAP_T,GL2.GL_REPEAT); // or GL_CLAMP

		if (!isPowerOf2(texture.getImageWidth()) || !isPowerOf2(texture.getImageHeight())) {
			System.out.println(filename + " texture is not power of 2! Size is "
					+ texture.getImageWidth() + "x" + texture.getImageHeight());
			System.exit(1);
		} else {
			System.out.println(filename + " texture loaded, size is "
					+ texture.getImageWidth() + "x" + texture.getImageHeight());
		}
		return texture;
	}

}