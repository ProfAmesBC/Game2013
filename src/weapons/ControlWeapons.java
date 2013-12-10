package weapons;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;

//control what weapon is being used/displayed on screen

public class ControlWeapons {
	private LaserGunWeapon gun;
	
	public ControlWeapons(GL2 gl, GLU glu){
		gun=new LaserGunWeapon(gl, glu);		
	}
	
	private void displayLaserGun(GL2 gl, GLU glu){
		gun.draw(gl, glu); //need to transform to right in front of player
	}
	
	private void removeLaserGun(GL2 gl, GLU glu){
		//could transform off screen until used again
	}
}
