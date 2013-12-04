package weapons;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;

public abstract class Projectile{
	private float projX, projY, projZ, projAngle;
	private float speed = 5;
	private float lifeSpan = 50;
	public int size = 0;
	public int red = 0;
	public int green = 0;
	public int blue = 0;
	
	
	public float getLifeSpan() {
		return lifeSpan;
	}
	public float getProjX() {return projX;}
	public void setProjX(float projX) {this.projX = projX;}
	public float getProjY() {return projY;}
	public void setProjY(float projY) {this.projY = projY;}
	public float getProjZ() {return projZ;}
	public void setProjZ(float projZ) {	this.projZ = projZ;}
	public void setProjAngle(float projAngle) {this.projAngle = projAngle;}

	
	//These would be different for each gun
	
	public int getBulletSize(){return size;}
	public void setBulletSize(int size) {this.size = size;}
	public int getBulletRed() {return red;}
	public void setBulletRed(int red) {this.red = red;}
	public int getBulletGreen() {return green;}
	public void setBulletGreen(int green) {this.green = green;}
	public int getBulletBlue() {return blue;}
	public void setBulletBlue(int blue) {this.blue = blue;}
	
	
	
	public abstract void draw(GL2 gl, GLU glu);
	
	
	public void updateLife(){
		lifeSpan--;
	}
	
	public void updatePosition(){
		projX = (float) (projX + speed*Math.cos(Math.toRadians(projAngle)));
		projZ = (float) (projZ - speed*Math.sin(Math.toRadians(projAngle)));
	}
	


}
