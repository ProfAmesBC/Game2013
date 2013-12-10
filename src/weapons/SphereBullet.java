package weapons;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;

public class SphereBullet extends Projectile {

	public SphereBullet(float x, float y, float z, float angle, float red, float green, float blue, float size, float speed){
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
	
	@Override
	public void draw(GL2 gl, GLU glu) {
		// TODO Auto-generated method stub
		
	}

}
