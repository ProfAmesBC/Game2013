package game;


public class GameSounds {

	private static GameSoundMan m=null;
	
//		m	= new GameSoundMan();
//		String sound1 = "fire";
//		m.load(sound1, true);
//		m.setPos(sound1, 0, 0, 1);
//		// or: m.load("fire",  0, 0, 1, true);
//		m.setListenerPos(0, 0);
//		m.play(sound1);
//		for (int i=0; i<120; i++) {
//    		try {
//                Thread.sleep(500);
//                m.turnListener(10); // spin the listener
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//		}
//		m.cleanUp();


	public static void footstepNoise()
	{
		
//		String sound1 = "fire";
//		m.load(sound1, true);
//		m.setPos(sound1, 0, 0, 1);
//		// or: m.load("fire",  0, 0, 1, true);
//		m.setListenerPos(0, 0);
//		m.play(sound1);
//
//		m.cleanUp();
		
		
		m	= new GameSoundMan();
		String sound1 = "footsteps-5 edited";
		m.load(sound1, true);
		m.setPos(sound1, 0, 0, 1);
		// or: m.load("fire",  0, 0, 1, true);
		m.setListenerPos(0, 0);
		m.play(sound1);
		for (int i=0; i<120; i++) {
    		try {
                Thread.sleep(500);
                m.turnListener(10); // spin the listener
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
		}
		m.cleanUp();

		
		
		
		
		System.out.println("Footstep");
	}
	
}
