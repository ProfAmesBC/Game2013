package game;

import javax.media.opengl.GL2;
import javax.media.opengl.GL3;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;

import com.jogamp.opengl.util.texture.Texture;

public class Fire {
	private double lx, ly, lz;					// has location
	private double dx, dy, dz;					// has direction
	private Texture[] fire = new Texture[23];	// has texture
	private double eyeAngle;
	private double fireAngle;
	private GLUquadric quadric;
	private int frame = 0; 
	
	public Fire(double x, double y, double z, double angle, GL2 gl, GLU glu){

		quadric = glu.gluNewQuadric();
		
		glu.gluQuadricDrawStyle(quadric, GLU.GLU_FILL); // GLU_POINT, GLU_LINE, GLU_FILL, GLU_SILHOUETTE
		glu.gluQuadricNormals  (quadric, GLU.GLU_NONE); // GLU_NONE, GLU_FLAT, or GLU_SMOOTH
		glu.gluQuadricTexture  (quadric, true);        // false, or true to generate texture coordinates

		// Load in Textures Below
		fire[0] = Building.setupTexture(gl, "DragonTextures/fire1.png");
		for(int i=1; i< 23; i++){
			fire[i] = Building.setupTexture(gl, "DragonTextures/fire" + (i+1) + ".png");
		}
		
		this.lx = x;
		this.ly = y;
		this.lz = z;
		
		fireAngle = (-1 * Math.random() * 70) - 10;
		eyeAngle = angle;
		
		dx = Math.cos(eyeAngle);
		dy = Math.sin(Math.toRadians(fireAngle));
		dz = Math.sin(eyeAngle);
	}
	
	public void drawBall(GL2 gl, GLU glu){
		
		gl.glEnable(GL2.GL_CULL_FACE);
			gl.glEnable(GL2.GL_TEXTURE_2D);	
			
			fire[frame++].bind(gl);
			gl.glPushMatrix();
//				gl.glRotated(angle, x, y, z);
				gl.glTranslated(lx, ly, lz);
				glu.gluSphere(quadric, 5, 25, 10);
			gl.glPopMatrix();
			
			gl.glDisable(GL2.GL_TEXTURE_2D);
		gl.glDisable(GL2.GL_CULL_FACE);
		
		if (frame == 23) { 
			frame = 0; 
		}
				
	}
	
	public void draw(GL2 gl, GLU glu){
		
		drawBall(gl, glu);
		
		this.lx += this.dx*2;
		this.ly += this.dy*2;
		this.lz += this.dz*2;
	}
	
}
