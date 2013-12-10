package weapons;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;

public abstract class Projectile{
	private float projX, projY, projZ, projAngle;
	private float red, green, blue;
	private float size;
	private float speed = 5;
	private float lifeSpan = 20;

	
	
	public float getLifeSpan() {return lifeSpan;}
	public float getProjX() {return projX;}
	public void setProjX(float projX) {this.projX = projX;}
	public float getProjY() {return projY;}
	public void setProjY(float projY) {this.projY = projY;}
	public float getProjZ() {return projZ;}
	public void setProjZ(float projZ) {	this.projZ = projZ;}
	public float getProjAngle() {return projAngle;}
	public void setProjAngle(float projAngle) {this.projAngle = projAngle;}
	public float getRed() {return red;}
	public void setRed(float red) {this.red = red;}
	public float getGreen() {return green;}
	public void setGreen(float green) {this.green = green;}
	public float getBlue() {return blue;}
	public void setBlue(float blue) {this.blue = blue;}
	public float getSpeed() {return speed;}
	public void setSpeed(float speed) {this.speed = speed;}
	public float getSize() {return size;}
	public void setSize(float size) {this.size = size;}
	
	
	
	
	
	
	public abstract void draw(GL2 gl, GLU glu);
	
	
	public void updateLife(){
		lifeSpan--;
	}
	
	// USE THIS
	public void updatePosition(){
		
		projX = (float) (projX + speed*Math.cos(Math.toRadians(projAngle)));
		projZ = (float) (projZ - speed*Math.sin(Math.toRadians(projAngle)));
	}
	


}
