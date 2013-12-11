package Music;

import java.io.File;
import java.io.IOException;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;

public class MusicPlayer implements Runnable {
	//Midi player from JUSTIN
	private final int LOOP_FOREVER = -1;
	private File score = new File("Score Final.mid");
	private File fanfare = new File("For Boston Fanfare Final.mid");

	private File invincible = new File("invincible.mid");
	private File File = score;

	@Override
	public void run() {
		try {
			Sequence song1 = MidiSystem.getSequence(File);
			Sequencer sequencer = MidiSystem.getSequencer();
			sequencer.open();
			sequencer.setSequence(song1);
			sequencer.start();
			sequencer.setLoopCount(LOOP_FOREVER);
		} catch (IOException  |InvalidMidiDataException |MidiUnavailableException exep  ) {
		}
	}	
	public void loadScore() {
		File = score;
	}
	public void loadFanfare() {
		File = fanfare;
	}
	//	private static JOALSoundMan m=null;
	//	
	//	public void play(String fname){
	//		m	= new JOALSoundMan();
	//		String sound1 = fname;
	//		m.load(sound1, true);
	//		m.setPos(sound1, 0, 0, 1);
	//		m.setListenerPos(0, 0);
	//		m.play(sound1);
	//		//m.cleanUp();
	//	}
	//	public void playBackground(){
	//		play("Score 3");
	//	}
	//	
	//	public void playFanfare(){
	//			m.cleanUp();
	//		play("Fanfare");
	//	}
	//	@Override
	//	public void run() {
	//		
	//	}

}
