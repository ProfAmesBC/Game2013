package game;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;

public class Foreigner extends Player{
	private float x=0, y=0, z=0, r,g,b,angle =0;
	private GL2 gl;
	private GLU glu;
	private Avatar psy;
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

	public Foreigner(GL2 gl, GLU glu, Integer nid) {
		
		//this.gl = gl;
		//this.glu = glu;
		
		//random color
			id = nid;
			/*
			r = (float)Math.random(); //I would like to make these contingent on a hash of the player's username - Tyler
			g = (float)Math.random(); 
			b = (float)Math.random(); 
			*/
			
	
		
	} 
	
	public void playerBody(GL2 gl, GLU glu, GLUquadric quadric, float x, float y, float z, float theta, float r, float g, float b, double size){
		psy = new Avatar(gl,glu);
		gl.glPushMatrix();
			gl.glTranslatef(x, 0, z); // start position 
			gl.glRotatef(theta, 0, 1, 0);
			gl.glColor3f(r, g, b); //color
			psy.draw(gl, glu);
			
		//	glu.gluSphere(quadric, size, 10, 10); //sphere for body 
		gl.glPopMatrix();
		
//		gl.glPushMatrix();
//			gl.glTranslatef(0, 0, 10);
//			gl.glRotatef((float)theta, 0, 1, 0); //angle manipulation
//		gl.glPopMatrix(); 

	}
	
	public void draw(GL2 gl, GLU glu) {
		playerBody(gl, glu, quadric, x,y,z,angle,r,g,b,10);
	//	a =  new Avatar(gl, glu,x,y,z);
	//	a.draw(gl, glu);
	}

}
