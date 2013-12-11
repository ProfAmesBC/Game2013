package game;


public class GameSounds {
	
	//TODO Clean up, location, footsteps
	
	static String sound1 = "Footsteps2";

	public static void footstepNoise()
	{
		
		BatsEverywhere.m.load(sound1,  0, 0, 1, false);
		BatsEverywhere.m.setListenerPos(0, 0);
		BatsEverywhere.m.play(sound1);
		//BatsEverywhere.m.cleanUp();
		
	}
	
}