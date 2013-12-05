package game;

import java.net.SocketException;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;

import Multiplayer.*; 

public class Player {
	private Integer id; 
	private float eyeX;
	private float eyeY;
	private float eyeZ; 
	private double theta;
	private float r;
	private float g;
	private float b; 
	private float size; 
	private GLUquadric quadric; 
	private PlayerMotion playerMotion; 
	private int waeyo = 0;
	private boolean eotteohke;

	/*****************************
	 * 
	 * Constructor for the actual
	 * object.
	 * @throws SocketException 
	 * 
	 *****************************/
	public Player(GLU glu, PlayerMotion playerMotion) throws SocketException {
		id = 1;
		quadric = glu.gluNewQuadric();
		glu.gluQuadricDrawStyle(quadric, GLU.GLU_FILL); // GLU_POINT, GLU_LINE, GLU_FILL, GLU_SILHOUETTE
		glu.gluQuadricNormals  (quadric, GLU.GLU_NONE); // GLU_NONE, GLU_FLAT, or GLU_SMOOTH
		glu.gluQuadricTexture  (quadric, false);        // false, or true to generate texture coordinates
		this.playerMotion = playerMotion; 
		ClientSendThread cst = new ClientSendThread(this);

		this.eyeX = 0;
		this.eyeY = 5;
		this.eyeZ = 0;
		this.theta = playerMotion.getTheta();

		//random color
		r = (float)Math.random(); //I would like to make these contingent on a hash of the player's username - Tyler
		g = (float)Math.random(); 
		b = (float)Math.random(); 

		//radius of the sphere 
		//size = (float)2.8;
		eotteohke = true;

	}

	/*****************************
	 * 
	 * Construct for the other players
	 * 
	 *****************************/
	public Player(GLU glu, Integer nid) {

		id = nid;
		quadric = glu.gluNewQuadric();
		glu.gluQuadricDrawStyle(quadric, GLU.GLU_FILL); // GLU_POINT, GLU_LINE, GLU_FILL, GLU_SILHOUETTE
		glu.gluQuadricNormals  (quadric, GLU.GLU_NONE); // GLU_NONE, GLU_FLAT, or GLU_SMOOTH
		glu.gluQuadricTexture  (quadric, false);        // false, or true to generate texture coordinates

		this.eyeX = 0;
		this.eyeY = 5;
		this.eyeZ = 0;
		this.theta = playerMotion.getTheta();

		//random color
		r = (float)Math.random(); //I would like to make these contingent on a hash of the player's username - Tyler
		g = (float)Math.random(); 
		b = (float)Math.random(); 

		//radius of the sphere 
		size = (float)2.8; 
		eotteohke = true;

	}

	public float getX(){
		return playerMotion.getEyeX(); 
	}
	public float getY(){
		return playerMotion.getEyeY(); 
	}
	public float getZ(){
		return playerMotion.getEyeZ(); 
	}
	public float getTheta(){
		return playerMotion.getTheta(); 
	}
	public Integer getID() {
		return id;
	}
	//we will use these to set the values for all players that are NOT the client
	public void setX(float nx){
		eyeX = nx;
	}
	public void setY(float ny){
		eyeY = ny;
	}
	public void setZ(float nz){
		eyeZ = nz;
	}



	public void playerBody(GL2 gl, GLU glu, GLUquadric quadric, float x, float y, float z, float r, float g, float b, double size){
		gl.glPushMatrix();
		gl.glTranslatef(x, y, z); // start position 
		gl.glColor3f(r, g, b); //color

		{
			gl.glPushMatrix();
			Avatar psy = new Avatar(gl,glu);

			if (eotteohke) {gl.glScaled(1,1,-1);}
			
			gl.glTranslated(10,0,0);
			psy.draw(gl, glu);
			gl.glPopMatrix();
			waeyo++;
			
			if (waeyo > 10) {
				waeyo = 0;
				eotteohke = !eotteohke;
			}
		}


		//glu.gluSphere(quadric, size, 10, 10); //sphere for body 
		gl.glPopMatrix();




		//		gl.glPushMatrix();
		//			gl.glTranslatef(0, 0, 10);
		//			gl.glRotatef((float)theta, 0, 1, 0); //angle manipulation
		//		gl.glPopMatrix(); 

	}

	public void draw(GL2 gl, GLU glu) {
		//retrieve coordinates from getters (PlayerMotion getters)
		eyeX = getX(); 
		eyeY = getY(); 
		eyeZ = getZ();

		theta = getTheta(); //get new Theta
		float sX = eyeX - (float)Math.cos(Math.toRadians(theta));
		float floatY = eyeY;
		float sY = (float)(floatY-2.5);
		float sZ = eyeZ + (float)Math.sin(Math.toRadians(theta));
		/*System.out.println("sX is: " + sX + ", \n sY is: " + sY + ". \n sZ is: " + sZ + ", and theta is: " + theta);*/

		playerBody(gl, glu, quadric, sX, sY, sZ, r, g, b, size); 


	}
}
