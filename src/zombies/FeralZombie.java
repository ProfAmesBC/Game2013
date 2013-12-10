package zombies;

import game.PlayerMotion;
import game.PlayerMotionWatcher;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;

import com.jogamp.opengl.util.texture.Texture;

public class FeralZombie implements Zombie, PlayerMotionWatcher{
	float locx, locy, locz;
	float eyeangle = 0;
	final float moveSpeed = 1;
	final float rotateSpeed = 2;
	final float sightRange = 5;
	boolean agro, die;
	private Texture bodyTexture;
	private GLUquadric bodyQuadric;
	
	public FeralZombie(GL gl, GLU glu, float x, float y, float z){
		locx = 16;
		locy = 0;
		locz = 100;
		die = false;
		agro = false;
	
		bodyQuadric = glu.gluNewQuadric();
        glu.gluQuadricDrawStyle(bodyQuadric, GLU.GLU_FILL); 
        glu.gluQuadricNormals  (bodyQuadric, GLU.GLU_NONE); 
        glu.gluQuadricTexture  (bodyQuadric, false);        
				
		 PlayerMotion.registerPlayerWatcher(this);
	}
	
	
	public void draw(GL2 gl,GLU glu){
		drawBody(gl, glu);
	}
	
	public void move(){
		if (agro){
			
		}
		else{
			
		}
	}

	private void drawBody(GL2 gl,GLU glu){

		gl.glPushMatrix();
			gl.glTranslatef(0f,5f,0f);
			glu.gluSphere(bodyQuadric, 1f, 20, 10);
		gl.glPopMatrix();
	}


	@Override
	public void playerMoved(float x, float y, float z, float angle) {
		if (playerInSight(x, z, sightRange)){
			agro = true;
		}
		
	}


	private boolean playerInSight(float x, float z, float sightRange2) {
		float ax = locx - (sightRange/2);
		float az = locz + sightRange;
		
		float bx = locx + (sightRange/2);
		float bz = locz + sightRange;
		
		return false;
	}
	
	private boolean SameSide(float playerx, float playerz, float knownx, float knownz, float ax, float az, float bx, float bz ){
//		float cpx1 = crossProduct (bx-ax, bz - az, playerx - ax, playerz - az);
//		float cpz1 = crossProduct (bx-ax, bz - az, playerx - ax, playerz - az);
//		float cpx2 = crossProduct (bx-ax, bz - az, knownx - ax, knownz - az);
//		float cpz2 = crossProduct (bx-ax, bz - az, knownx - ax, knownz - az);
//		if dotProduct(cp1, cp2)
	return false;
				
	}
	

	public void drawMoving(GL2 gl, GLU glu) {
		move();
		gl.glTranslatef(locx, locy, locz);
		//gl.glRotatef(eyeAngle+90, 0, 1, 0);
		draw(gl, glu);
	}

}
