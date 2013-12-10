package weapons;

import game.PlayerStats;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;

public class SphereBullet extends Projectile {

	private GLUquadric sphereQuadric;
	private float red, green, blue, size;
	
	public SphereBullet(float x, float y, float z, float angle, int red, int green, int blue, int size, float y_angle,PlayerStats s){
		super(s);
		setProjX(x);
		setProjY(y);
		setProjZ(z);
		setProjAngle(angle);
		setBulletRed(red);
		setBulletGreen(green);
		setBulletBlue(blue);
		setBulletSize(size);
	}
	
	@Override
	public void draw(GL2 gl, GLU glu) {
		gl.glColor3f(red, green, blue);
		gl.glPushMatrix();
		gl.glTranslatef(getProjX(), getProjY(), getProjZ());
		glu.gluSphere(sphereQuadric, size, 10,10);
		gl.glPopMatrix();
	}

}
