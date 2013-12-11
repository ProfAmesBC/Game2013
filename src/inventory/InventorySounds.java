package inventory;

import game.BatsEverywhere;

public class InventorySounds {
	
	
	static String sound1 = "button-3";
	static String sound2 = "button-4";
	
	
	public static void pickupNoise()
	{
	
		BatsEverywhere.m.load(sound1,  0, 0, 1, false);
		BatsEverywhere.m.setListenerPos(0, 0);
		BatsEverywhere.m.play(sound1);
		//BatsEverywhere.m.cleanUp();
		
		//System.out.println("DING");
	}
	
	public static void useItemNoise()
	{
		
		BatsEverywhere.m.load(sound2,  0, 0, 1, false);
		BatsEverywhere.m.setListenerPos(0, 0);
		BatsEverywhere.m.play(sound2);
		//BatsEverywhere.m.cleanUp();
		
		
		//System.out.println("useItemNoise");
	}
	
	public static void changeItemNoise()
	{
		//System.out.println("changeItemNoise");
	}

}
