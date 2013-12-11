package creatures;

import game.BatsEverywhere;
import java.util.LinkedList;
import java.util.Queue;
import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;

public class CreatureManager {
	
	private static Queue<Location> spawnLocations = new LinkedList<Location>();
	private static GL2 gl;
	private static GLU glu;
	
	public CreatureManager(GL2 gl,GLU glu){
		this.gl = gl;
		this.glu = glu;
	}
	
	public static void addLocation(Location spawnLocation){
		spawnLocations.add(spawnLocation);
	}
	
	public static void addRobot(){
		Location l = spawnLocations.remove();
		Robot.addRobot(new Robot((double)l.getX(),(double)l.getZ(),gl,glu));
	}
}