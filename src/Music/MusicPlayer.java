package Music;
// Ames Demo Fall 2012
//
public class MusicPlayer {
	private static JOALSoundMan m=null;
	
	public void play(String fname){
		m	= new JOALSoundMan();
		String sound1 = fname;
		m.load(sound1, true);
		m.setPos(sound1, 0, 0, 1);
		m.setListenerPos(0, 0);
		m.play(sound1);
		//m.cleanUp();
	}
	public void playBackground(){
		play("Score 3");
	}
	
	public void playFanfare(){
			m.cleanUp();
		play("Fanfare");
	}
	
}