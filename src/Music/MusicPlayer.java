package Music;
// Ames Demo Fall 2012
//
public class MusicPlayer {
	private static JOALSoundMan m=null;
	
	public void play(){
		m	= new JOALSoundMan();
		String sound1 = "Score 3";
		m.load(sound1, true);
		m.setPos(sound1, 0, 0, 1);
		m.setListenerPos(0, 0);
		m.play(sound1);
		//m.cleanUp();
	}
}