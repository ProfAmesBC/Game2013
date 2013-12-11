<<<<<<< HEAD
package weapons;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;

//control what weapon is being used/displayed on screen

public class ControlWeapons {
	private BaseballBatWeapon bat;
	private LaserGunWeapon gun;
	
	public ControlWeapons(GL2 gl, GLU glu){
		bat=new BaseballBatWeapon(gl, glu);
		gun=new LaserGunWeapon(gl, glu);		
	}
	
	private void displayBaseballBat(GL2 gl, GLU glu){
		bat.setPresent(true);
		bat.draw(gl, glu); //need to transform to right in front of player
		WeaponSounds.changeWeaponNoise();
	}
	
	private void displayLaserGun(GL2 gl, GLU glu){
		gun.setPresent(true);
		gun.draw(gl, glu); //need to transform to right in front of player
		WeaponSounds.changeWeaponNoise();
	}
	
	private void removeBaseballBat(GL2 gl, GLU glu){
		bat.setPresent(false);
		//could transform off screen until used again
	}
	
	private void removeLaserGun(GL2 gl, GLU glu){
		gun.setPresent(false);
		//could transform off screen until used again
	}
}
=======
//package weapons;
//
//import javax.media.opengl.GL2;
//import javax.media.opengl.glu.GLU;
//
////control what weapon is being used/displayed on screen
//
//public class ControlWeapons {
//	//private BaseballBatWeapon bat;
//	private LaserGunWeapon gun;
//	
//	public ControlWeapons(GL2 gl, GLU glu){
//		//bat=new BaseballBatWeapon(gl, glu);
//		gun=new LaserGunWeapon(gl, glu);		
//	}
//
//// SEE Fiona if you want to change anything to do with baseball bats
////	private void displayBaseballBat(GL2 gl, GLU glu){
////		bat.setPresent(true);
////		bat.draw(gl, glu); //need to transform to right in front of player
////	}
//	
//	private void displayLaserGun(GL2 gl, GLU glu){
//		gun.setPresent(true);
//		gun.draw(gl, glu); //need to transform to right in front of player
//	}
//	
////	private void removeBaseballBat(GL2 gl, GLU glu){
////		bat.setPresent(false);
////		//could transform off screen until used again
////	}
//	
//	private void removeLaserGun(GL2 gl, GLU glu){
//		gun.setPresent(false);
//		//could transform off screen until used again
//	}
//}
>>>>>>> refs/remotes/origin/master
