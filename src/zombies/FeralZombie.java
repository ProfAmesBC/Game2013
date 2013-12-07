package zombies;

import game.PlayerMotion;
import game.PlayerMotionWatcher;

import javax.media.opengl.GL;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;

import com.jogamp.opengl.util.texture.Texture;

public class FeralZombie implements Zombie, PlayerMotionWatcher{
	float locx, locy, locz;
	final float moveSpeed = 1;
	final float rotateSpeed = 2;
	final float sightRange = 5;
	boolean agro, die;
	private Texture bodyTexture;
	private GLUquadric bodyQuadric;
	
	public FeralZombie(GL gl, GLU glu, float x, float y, float z){
		locx = 0;
		locy = 0;
		locz = 0;
		die = false;
		agro = false;
		 PlayerMotion.registerPlayerWatcher(this);
	}
	
	
	public void draw(GL gl,GLU glu){
		drawBody();
	}
	
	public void move(){
		if (agro){
			
		}
		else{
			
		}
	}

	private void drawBody(){
		
	}


	@Override
	public void playerMoved(float x, float y, float z, float angle) {
		if (playerInSight(x,y,z, sightRange)){
			
		}
		
	}


	private boolean playerInSight(float x, float y, float z, float sightRange2) {
		//if (Side )
		return false;
	}
	
	//private boolean
	

	

}
