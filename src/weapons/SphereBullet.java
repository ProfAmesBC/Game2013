package weapons;

import game.PlayerMotion;
import game.PlayerStats;

import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;

import creatures.ProjectileWatcher;

public class SphereBullet extends Projectile {

	public GLUquadric sphereQuadric;
	public double red;
	public double green;
	public double blue;
	public double size;
	public int speed;
	public float angle;
	public float x;
	public float y;
	public float z;
	public double T = 0;

	public SphereBullet(float x, float y, float z, float angle, double red, double green, double blue, double size, int speed, float y_angle,PlayerStats s){
		super(s);
		setX(x);
		setY(y);
		setZ(z);
		setAngle(angle);
		setRed(red);
		setGreen(green);
		setBlue(blue);
		setSize(size);
		setSpeed(speed);
	}

	public void setRed(double red) {this.red = red;}
	public void setGreen(double green) {this.green = green;}
	public void setBlue(double blue) {this.blue = blue;}
	public void setX (float x) {this.x = x;}
	public void setY (float y) {this.y = y;}
	public void setZ (float z) {this.z = z;}
	public void setSize(double size) {this.size = size;}
	public void setSpeed(int speed) {this.speed = speed;}
	public void setAngle(float angle) {this.angle = angle;}

	public float getAngle() {
		return angle*-1;
	}
	public double getRed() {return red;}
	public double getGreen() {return green;}
	public double getBlue() {return blue;}
	public double getSize() {return size;}
	public float getX() {return x;}
	public float getY() {return y;}
	public float getZ() {return z;}

	public void drawBullet(GL2 gl, GLU glu) {
		sphereQuadric = glu.gluNewQuadric();
		glu.gluQuadricDrawStyle(sphereQuadric, GLU.GLU_FILL);
		glu.gluQuadricNormals  (sphereQuadric, GLU.GLU_NONE);
		glu.gluQuadricTexture  (sphereQuadric, false);

		gl.glPushMatrix();
		glu.gluSphere(sphereQuadric, getSize(), 10,10);
		gl.glPopMatrix();
	}	
	
	public void draw(GL2 gl, GLU glu) {
		T = T+.1;
		gl.glColor3d(getRed(),getGreen(),getBlue()); 
		System.out.println("ANGLE=       "+ getAngle());
		gl.glPushMatrix();
			gl.glTranslated((speed*T)*Math.cos(Math.toRadians(getAngle())),0,(speed*T)*Math.sin(Math.toRadians(getAngle())));
			gl.glTranslatef(getX(), getY(), getZ());
			drawBullet(gl, glu);
			
		gl.glPopMatrix();
	}

}
