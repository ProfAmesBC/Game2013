package weapons;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;

public abstract class Projectile{
	private float projX, projY, projZ, projAngle;
	private float speed = 5;
	private float lifeSpan = 20;
	private float red, green, blue, size;
	
	
	public float getLifeSpan() {return lifeSpan;}
	public float getProjX() {return projX;}
	public void setProjX(float projX) {this.projX = projX;}
	public float getProjY() {return projY;}
	public void setProjY(float projY) {this.projY = projY;}
	public float getProjZ() {return projZ;}
	public void setProjZ(float projZ) {	this.projZ = projZ;}
	public void setProjAngle(float projAngle) {this.projAngle = projAngle;}

	//these would be different for each new weapon
	//each weapon will shoot a bullet of different speed, color, size if desired
	public void setSpeed(float speed) {this.speed = speed;}
	public float getSpeed() {return speed;}
	public void setRed(float red) {this.red = red;}
	public float getRed() {return red;}
	public void setGreen(float green) {this.green = green;}
	public float getGreen() {return green;}
	public void setBlue(float blue) {this.blue = blue;}
	public float getBlue() {return blue;}
	public void setSize(float size) {this.size = size;}
	public float getSize() {return size;}
	
	public abstract void draw(GL2 gl, GLU glu);
	
	
	public void updateLife(){
		lifeSpan--;
	}
	
	public void updatePosition(){
		projX = (float) (projX + speed*Math.cos(Math.toRadians(projAngle)));
		projZ = (float) (projZ - speed*Math.sin(Math.toRadians(projAngle)));
	}
	


}
