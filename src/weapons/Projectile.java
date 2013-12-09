package weapons;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;

public abstract class Projectile{
	private float projX, projY, projZ, projAngle;
	private float speed = 5;
	private float lifeSpan = 20;

	
	
	public float getLifeSpan() {return lifeSpan;}
	public float getProjX() {return projX;}
	public void setProjX(float projX) {this.projX = projX;}
	public float getProjY() {return projY;}
	public void setProjY(float projY) {this.projY = projY;}
	public float getProjZ() {return projZ;}
	public void setProjZ(float projZ) {	this.projZ = projZ;}
	public void setProjAngle(float projAngle) {this.projAngle = projAngle;}
	
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
