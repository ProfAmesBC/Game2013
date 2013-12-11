package creatures;

import game.BatsEverywhere;

import java.util.Stack;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;

public class CreatureManager {
	
	private static Stack<Location> spawnLocations = new Stack<Location>();
	private static GL2 gl;
	private static GLU glu;
	
	public CreatureManager(GL2 gl,GLU glu){
		this.gl = gl;
		this.glu = glu;
	}
	
	public static void addLocation(Location spawnLocation){
		spawnLocations.push(spawnLocation);
	}
	
	public static void addRobot(){
		Location l = spawnLocations.pop();
		BatsEverywhere.creatures.add(new Robot((double)l.getX(),(double)l.getZ(),gl,glu));
	}
}