package weapons;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;

// this class wraps weapons with coordinates
// used for displaying weapons on the ground in the game
public class DisplayedWeapon {

	private Weapon w;
	private float x, z, theta;
	private GLUquadric quadric;
	
	public DisplayedWeapon(Weapon w, float x, float z){
		this.w = w;
		this.x = x;
		this.z = z;
	}
	
	public float getX(){ return x; }
	public float getZ(){ return z; }
	public Weapon getWeapon(){ return w; }
	
	public void draw(GL2 gl, GLU glu){
		// quadric to draw cylindrical pedestal
		quadric = glu.gluNewQuadric();
        glu.gluQuadricDrawStyle(quadric, GLU.GLU_FILL); // GLU_POINT, GLU_LINE, GLU_FILL, GLU_SILHOUETTE
        glu.gluQuadricNormals  (quadric, GLU.GLU_NONE); // GLU_NONE, GLU_FLAT, or GLU_SMOOTH
        glu.gluQuadricTexture  (quadric, false); 
		
        gl.glPushMatrix();
//        	gl.glRotatef(-90, 1, 0, 0);
        	gl.glTranslatef(x, 0.1f, z);
        	gl.glRotatef(-90, 1, 0, 0);
        	gl.glColor3f(1, 0, 0);
        	glu.gluDisk(quadric, 3, 0, 10, 10);
        gl.glPopMatrix();
        
		gl.glPushMatrix();
			gl.glTranslatef(x, 5, z);
			gl.glRotatef(theta, 0, 1, 0);
//			System.out.println("okokok");
			w.draw(gl, glu);
		gl.glPopMatrix();
		
		theta += 2;
	}
}
