package weapons;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;

public class DrawBullet extends Projectile
{
	public DrawBullet(float x, float y, float z, float angle, float red, float green, float blue, float size, float speed){
		setProjX(x);
		setProjY(y);
		setProjZ(z);
		setProjAngle(angle);
		setRed(red);
		setGreen(green);
		setBlue(blue);
		setSize(size);
		setSpeed(speed);
	}
	
	
	public void draw(GL2 gl, GLU glu) {
		gl.glColor3d(getRed(), getGreen(), getBlue());
		
		
		gl.glPushMatrix();
		gl.glTranslatef(getProjX(), getProjY(), getProjZ());
		gl.glScaled(getSize(), getSize(), getSize());
		gl.glPopMatrix();
	}
}