package game;

import javax.media.opengl.glu.GLU;

public class Foreigner extends Player{
	float x, y, z, r,g,b,angle; 
	
	@Override 
	public float getX() {
		return x;
	}

	@Override
	public void setX(float x) {
		this.x = x;
	}

	@Override
	public float getY() {
		return y;
	}

	@Override
	public void setY(float y) {
		this.y = y;
	}

	@Override
	public float getZ() {
		return z;
	}

	@Override
	public void setZ(float z) {
		this.z = z;
	}

	@Override
	public float getAngle() {
		return angle;
	}

	@Override
	public void setAngle(float angle) {
		this.angle = angle;
	}

	public Foreigner(GLU glu, Integer nid) {
		
		//random color
				r = (float)Math.random(); //I would like to make these contingent on a hash of the player's username - Tyler
				g = (float)Math.random(); 
				b = (float)Math.random(); 
			
		
	} 

}
