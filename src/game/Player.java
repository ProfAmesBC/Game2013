package game;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;

public class Player {
	private String name; 
	private float eyeX;
	private float eyeY;
	private float eyeZ; 
	private float r;
	private float g;
	private float b; 
	private float size; 
	private GLUquadric quadric; 
	private PlayerMotion playerMotion; 

	public float getX(){
		return playerMotion.getEyeX(); 
	}
	public float getY(){
		return playerMotion.getEyeY(); 
	}
	public float getZ(){
		return playerMotion.getEyeZ(); 
	}

	//we will use these to set the values for all players that are NOT the client...... right? - Tyler
	public void setX(){

	}
	public void setY(){

	}
	public void setZ(){

	}
	public Player(GLU glu, PlayerMotion playerMotion) {
		quadric = glu.gluNewQuadric();
		glu.gluQuadricDrawStyle(quadric, GLU.GLU_FILL); // GLU_POINT, GLU_LINE, GLU_FILL, GLU_SILHOUETTE
		glu.gluQuadricNormals  (quadric, GLU.GLU_NONE); // GLU_NONE, GLU_FLAT, or GLU_SMOOTH
		glu.gluQuadricTexture  (quadric, false);        // false, or true to generate texture coordinates
		this.playerMotion = playerMotion; 

		//IDK IF I NEED THESE - Tyler
		this.eyeX = 0;
		this.eyeY = 5;
		this.eyeZ = 0;
		
		//random color
		r = (float)Math.random(); //I would like to make these contingent on a hash of the player's username - Tyler
		g = (float)Math.random(); 
		b = (float)Math.random(); 
	
		//radius of the sphere 
		size = 5; 
	}

	public void playerBody(GL2 gl, GLU glu, GLUquadric quadric, float x, float y, float z, float r, float g, float b, double size){
		gl.glPushMatrix();
			gl.glTranslatef(x, y, z); // start position 
			gl.glColor3f(r, g, b); //color
			glu.gluSphere(quadric, size, 10, 10); //sphere for body  
		gl.glPopMatrix();
	}
	public void draw(GL2 gl, GLU glu) {
		//retrieve coordinates from getters (PlayerMotion getters)
		eyeX = getX(); 
		eyeY = getY(); 
		eyeZ = getZ()-10;

		playerBody(gl, glu, quadric, eyeX, eyeY, eyeZ, r, g, b, size); 
	}
}
