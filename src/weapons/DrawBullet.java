package weapons;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;
/*
public class DrawBullet extends Projectile
{
	private GLUquadric sphereQuadric; // for the bullet
	
	public DrawBullet(float x, float y, float z, float angle, float red, float green, float blue, float size, float speed){
		setProjX(x);
		setProjY(y);
		setProjZ(z);
		setProjAngle(angle);
	}
	
	public float getRed() {return ProjectileWeapons.getRed();}			//IS THERE A WAY TO MAKE THESE NOT STATIC??
	public float getGreen() {return ProjectileWeapons.getGreen();}
	public float getBlue() {return ProjectileWeapons.getBlue();}
	public float getSize() {return ProjectileWeapons.getSize();}
	
	
	public void draw(GL2 gl, GLU glu) {
		gl.glColor3d(getRed(), getGreen(), getBlue());
		gl.glPushMatrix();
		gl.glTranslatef(getProjX(), getProjY(), getProjZ());
		gl.glScaled(0.3, 0.3, 0.3);
		glu.gluSphere(sphereQuadric,getSize(),10,10);
		gl.glPopMatrix();
	}
	
}
*/