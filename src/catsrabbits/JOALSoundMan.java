package catsrabbits;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import com.jogamp.openal.*;
import com.jogamp.openal.sound3d.Buffer;
import com.jogamp.openal.util.ALut;

// global stores for the sounds

public class JOALSoundMan{
	private HashMap<String, int[]> buffersMap; // (name, buffer) pairs 
	private HashMap<String, int[]> sourcesMap; // (name, source) pairs
	private AL al;
	private float xLis, yLis, zLis;	// current position
	float[] oriLis;	// orientation
	int angleLis = 0;

	public JOALSoundMan() {
		buffersMap = new HashMap<String, int[]>(); 
		sourcesMap = new HashMap<String, int[]>();
		initOpenAL();
		initListener(); 


	} // end of JOALSoundMan()

	private void initOpenAL()
	{
		try { 
			ALut.alutInit();	// creates an OpenAL context
			al = ALFactory.getAL();	// used to access OpenAL
			al.alGetError();	// clears any error bits
			// System.out.println("JOAL version: " + Version.getVersion());
		} catch (ALException e) {
			e.printStackTrace(); 
			System.exit(1);
		} 
	} // end of initOpenAL()

	private void initListener(){ // position and orientate the listener 
		xLis = 0.0f; 
		yLis = 0.0f; 
		zLis = 0.0f; 
		al.alListener3f(AL.AL_POSITION, xLis, yLis, zLis); // position the listener at the origin 
		al.alListener3i(AL.AL_VELOCITY, 0, 0, 0);	// no velocity
		oriLis = new float[] {xLis, yLis, zLis-1.0f, 0.0f, 1.0f, 0.0f}; /* the first 3 elements are the "look at" point, the second 3 are the "up direction" */ 
		al.alListenerfv(AL.AL_ORIENTATION, oriLis, 0);
	} // end of initListener()

	public void cleanUp() {
		Set<String> keys = sourcesMap.keySet(); 
		Iterator<String> iter = keys.iterator();
		String nm; 
		int[] buffer, source; 
		while(iter.hasNext()){
			nm = iter.next();
			source = sourcesMap.get(nm); 
			System.out.println("Stopping " + nm); 
			al.alSourceStop(source[0]); 
			al.alDeleteSources(1, source, 0);
			buffer = buffersMap.get(nm); 
			al.alDeleteBuffers(1, buffer, 0);

		}
		ALut.alutExit();
	}

	public boolean load(String nm, boolean toLoop) {
		if (sourcesMap.get(nm) != null) { 
			System.out.println(nm + " already loaded");
			return true;
		}
		int[] buffer = initBuffer(nm); 
		if (buffer == null)
			return false;
		int[] source = initSource(nm, buffer, toLoop); 
		if (source == null) {
			al.alDeleteBuffers(1, buffer, 0); // no need for the buffer anymore
			return false;
		}
		if (toLoop) 
			System.out.println("Looping source created for " + nm);
		else 
			System.out.println("Source created for " + nm);
		buffersMap.put(nm, buffer); 
		sourcesMap.put(nm, source); 
		return true;
	} // end of loadSource()

	private int[] initBuffer(String nm) {
		// create arrays for holding various WAV file info 
		int[] format = new int[1]; 
		ByteBuffer[] data = new ByteBuffer[1]; 
		int[] size = new int[1];
		int[] freq = new int[1]; 
		int[] loop = new int[1];
		// load WAV file into the data arrays 
		String fnm = nm + ".wav"; 
		try {
			ALut.alutLoadWAVFile(fnm, format, data, size, freq, loop);
		} catch(ALException e) {
			System.out.println("Error loading WAV file: " + fnm); return null;
		} 
		System.out.println("Sound size = " + size[0]); 
		System.out.println("Sound freq = " + freq[0]);
		System.out.println("Sound format = " + format[0]
                + "; mono8 is "    + Buffer.FORMAT_MONO8
                + "; mono16 is "   + Buffer.FORMAT_MONO16
                + "; stereo8 is "  + Buffer.FORMAT_STEREO8
                + "; stereo16 is " + Buffer.FORMAT_STEREO16);
		
		
		
		// create an empty buffer to hold the sound data 
		int[] buffer = new int[1]; 
		al.alGenBuffers(1, buffer, 0); 
		if (al.alGetError() != AL.AL_NO_ERROR) {
			System.out.println("Could not create a buffer for " + nm); 
			return null;
		}
		// store data in the buffer 
		al.alBufferData(buffer[0], format[0], data[0], size[0], freq[0]);
		// ALut.alutUnloadWAV(format[0], data[0], size[0], freq[0]); // not in API anymore
		return buffer; 
	} // end of initBuffer()

	private int[] initSource(String nm, int[] buf, boolean toLoop){

		// create a source (a point in space that emits a sound) 
		int[] source = new int[1]; 
		al.alGenSources(1, source, 0); 
		if (al.alGetError() != AL.AL_NO_ERROR) {

			System.out.println("Error creating source for " + nm); 
			return null;
		}
		// configure the source 
		al.alSourcei(source[0], AL.AL_BUFFER, buf[0]); // bind buffer 
		al.alSourcef(source[0], AL.AL_PITCH, 1.0f); 
		al.alSourcef(source[0], AL.AL_GAIN, 1.0f); 
		al.alSource3f(source[0], AL.AL_POSITION, 0.0f, 0.0f, 0.0f);
		// position the source at the origin al.alSource3i(source[0], AL.AL_VELOCITY, 0, 0, 0); // no velocity
		if (toLoop) 
			al.alSourcei(source[0], AL.AL_LOOPING, AL.AL_TRUE); // looping
		else 
			al.alSourcei(source[0], AL.AL_LOOPING, AL.AL_FALSE); //play once
		if (al.alGetError() != AL.AL_NO_ERROR) { 
			System.out.println("Error configuring source for " + nm); 
			return null;
		}
		return source; 
	} // end of initSource()

	public boolean setPos(String nm, float x, float y, float z) // move the nm sound to (x,y,z) 
	{
		int[] source = (int[]) sourcesMap.get(nm); 
		if (source == null) {
			System.out.println("No source found for " + nm); 
			return false;
		}
		al.alSource3f(source[0], AL.AL_POSITION, x, y, z);
		return true; 
	} // end of setPos()

	public boolean load(String nm, float x, float y, float z, boolean toLoop)
	{ 
		if (load(nm, toLoop)) 
			return setPos(nm, x, y, z);
		else 
			return false;
	}
	public boolean play(String nm) {
		int[] source = (int[]) sourcesMap.get(nm); 
		if (source == null) {
			System.out.println("No source found for " + nm); 
			return false;
		}
		System.out.println("Playing " + nm); 
		al.alSourcePlay(source[0]); 
		return true;
	} // end of play()


	public void moveListener(float xStep, float zStep) // move the listener by a (x,z) step 
	{
		float x = xLis + xStep; 
		float z = zLis + zStep; 
		setListenerPos(x, z);
	} // end of moveListener()

	public void setListenerPos(float xNew, float zNew) // position the listener at (xNew,zNew) GOING TO ADD yNEW
	{
		float xOffset = xNew-xLis; 
		float zOffset = zNew-zLis;
		xLis = xNew; 
		zLis = zNew; 
		al.alListener3f(AL.AL_POSITION, xLis, yLis, zLis);
		/* keep the listener facing the same direction by moving the "look at" point by the (x,z) offset */
		oriLis[0] += xOffset; 
		oriLis[2] += zOffset;
		// no change needed to y-coord in oriLis[1] 
		al.alListenerfv(AL.AL_ORIENTATION, oriLis, 0);
	} // end of setListenerPos()

	public void turnListener(int degrees) // turn the listener anti-clockwise by degrees amount 
	{
		angleLis += degrees;
		System.out.println("Angle Listener: " + angleLis%360);
		double angle = Math.toRadians(angleLis); 
        //float xLen = -1.0f * (float) Math.sin(angle); // original
        //float zLen = -1.0f * (float) Math.cos(angle); // original
        float xLen =  1.0f * (float) Math.cos(angle); // ames change
        float zLen = -1.0f * (float) Math.sin(angle); // ames change
		/* face in the (xLen, zLen) direction by adding the values to the listener position */
		oriLis[0] = xLis+xLen; 
		oriLis[2] = zLis+zLen;
		al.alListenerfv(AL.AL_ORIENTATION, oriLis, 0); 
	} // end of turnListener()

}