package game;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;

import Multiplayer.Avatar;

public class Foreigner extends Player{
	float x, y, z, r,g,b,angle;
	private Avatar a;
	//int id;
	
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
			id = nid;
			r = (float)Math.random(); //I would like to make these contingent on a hash of the player's username - Tyler
			g = (float)Math.random(); 
			b = (float)Math.random(); 
			
	} 
	
	public void playerBody(GL2 gl, GLU glu, GLUquadric quadric, float x, float y, float z, float r, float g, float b, double size){
		gl.glPushMatrix();
			gl.glTranslatef(x, y, z); // start position 
			gl.glColor3f(r, g, b); //color
			glu.gluSphere(quadric, size, 10, 10); //sphere for body 
		gl.glPopMatrix();
		
//		gl.glPushMatrix();
//			gl.glTranslatef(0, 0, 10);
//			gl.glRotatef((float)theta, 0, 1, 0); //angle manipulation
//		gl.glPopMatrix(); 

	}
	
	public void draw(GL2 gl, GLU glu) {
		playerBody(gl, glu, quadric, x,y,z,r,g,b,10);
	//	a =  new Avatar(gl, glu,x,y,z);
	//	a.draw(gl, glu);
	}

}
