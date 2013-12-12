package weapons;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;

//control what weapon is being used/displayed on screen

public class ControlProjectileWeapons {
	private LaserGunWeapon gun;
	private FlamethrowerWeapon flamethrower;
	
	public ControlProjectileWeapons(GL2 gl, GLU glu){
		gun=new LaserGunWeapon(gl, glu);	
		flamethrower=new FlamethrowerWeapon(gl, glu);
		
		
	}
	
	private void displayLaserGun(GL2 gl, GLU glu){
		gun.draw(gl, glu); //need to transform to right in front of player
	}
	
	private void removeLaserGun(GL2 gl, GLU glu){
		//could transform off screen until used again
	}
	
	private void displayFlamethrower(GL2 gl, GLU glu){
		flamethrower.draw(gl, glu); //need to transform to right in front of player
	}
	
	private void removeFlameThrower(GL2 gl, GLU glu){
		//could transform off screen until used again
	}
}
