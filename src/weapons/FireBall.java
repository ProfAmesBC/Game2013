package weapons;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;


public class FireBall extends Projectile{
	private GLUquadric quadric;


	public FireBall(float x, float y, float z, float angle){
		setProjX(x);
		setProjY(y);
		setProjZ(z);
		setProjAngle(angle);
	}
	
	public void draw(GL2 gl, GLU glu){
		quadric = glu.gluNewQuadric();
        glu.gluQuadricDrawStyle(quadric, GLU.GLU_FILL); // GLU_POINT, GLU_LINE, GLU_FILL, GLU_SILHOUETTE
        glu.gluQuadricNormals  (quadric, GLU.GLU_SMOOTH); // GLU_NONE, GLU_FLAT, or GLU_SMOOTH
        glu.gluQuadricTexture  (quadric, true);        // false, or true to generate texture coordinates
		
        //add get Bullet Color
        gl.glColor3f(1, 0, 0);
        
		gl.glPushMatrix();
			gl.glTranslatef(getProjX(), getProjY(), getProjZ());
			
			//add get Bullet Size
			glu.gluSphere(quadric, 0.2, 10, 10);
		gl.glPopMatrix();
	}
}
