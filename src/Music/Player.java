package Music;
// Ames Demo Fall 2012
//
public class Player {
	private static JOALSoundMan m=null;
	
	public static void main(String args[]){
		m	= new JOALSoundMan();
		String sound1 = "Score 3.wav";
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
	}
}