
package weapons;

import game.BatsEverywhere;

public class WeaponSounds {
			
	static String sound1 = "gun-shot copy";

	public static void projectileNoise()
	{
		
		BatsEverywhere.m.load(sound1,  0, 0, 1, false);
		BatsEverywhere.m.setListenerPos(0, 0);

		BatsEverywhere.m.play(sound1);
		//BatsEverywhere.m.cleanUp();
		
	}
	
	public static void nonProjectileNoise()
	{
		//System.out.println("THUMP");
	}
	
	public static void changeWeaponNoise()
	{
		//System.out.println("changeWeaponNoise");
	}
	
	// test commit 2  VM
}

