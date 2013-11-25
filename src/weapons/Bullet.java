package weapons;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;



public class Bullet{
	private float x, y, z, angle;
	private int speed = 5;
	private int lifeSpan = 100;
	public int getLifeSpan() {return lifeSpan;}
	public void setLifeSpan(int lifeSpan) {this.lifeSpan = lifeSpan;}
	public int getSpeed() {return speed;}
	public void setX(float x) {this.x = x;}
	public void setY(float y) {	this.y = y;}
	public void setZ(float z) {this.z = z;}
	public float getX() {return x;}
	public float getY() {return y;}
	public float getZ() {return z;}
	public float getAngle() {return angle;}
	private GLUquadric quadric;


	public Bullet(float x, float y, float z, float angle){
		this.x = x;
		this.y = y;
		this.z = z;
		this.angle = angle;
		
	}
	
	public void draw(GL2 gl, GLU glu){
		quadric = glu.gluNewQuadric();
        glu.gluQuadricDrawStyle(quadric, GLU.GLU_FILL); // GLU_POINT, GLU_LINE, GLU_FILL, GLU_SILHOUETTE
        glu.gluQuadricNormals  (quadric, GLU.GLU_SMOOTH); // GLU_NONE, GLU_FLAT, or GLU_SMOOTH
        glu.gluQuadricTexture  (quadric, true);        // false, or true to generate texture coordinates
		
		gl.glPushMatrix();
			gl.glTranslatef(this.x, this.y, this.z);
			glu.gluSphere(quadric, 0.2, 10, 10);
		gl.glPopMatrix();
	}
	
	public void updatePosition(){
		this.x = ((float) (this.x + this.speed*Math.cos(Math.toRadians(this.angle))));
		this.z = ((float) (this.z - this.speed*Math.sin(Math.toRadians(this.angle))));
	}
	
	public void updateLife(){
		this.lifeSpan--;
	}



}
