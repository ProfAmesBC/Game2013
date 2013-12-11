package items;

import game.PlayerMotion;
import game.PlayerMotionWatcher;
import game.PlayerStats;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;

public class PowerUpManager {

	private List<Spawn3f> spawns, emptySpawns;
	private List<Point3f> spawnSelectionList;
	private List<Point3f> allAvailableSpawns;
	private List<AbstractPowerUp> powerUpList;
	private List<Object> weaponsList;
	private int initialSize;
	private PlayerStats ps;
	private HPHeal hp = null;
	private static int DESIRED_SPAWNS = 3;
	
	AllSpawnLocations poss = new AllSpawnLocations();
	//Should be able to listen
	
	public PowerUpManager(GL2 gl, GLU glu) {
		//weaponsList = new ArrayList<Weapons>(); //weaponslist does not get refreshed
		
		powerUpList = new ArrayList<AbstractPowerUp>();
		spawnSelectionList = poss.getAllSpawnsPossible();
		spawns = new ArrayList<Spawn3f>(); //list of all spawn locations possible; currently @ 0,0,0
		emptySpawns = new ArrayList<Spawn3f>();
		initialSize = spawns.size();
		hp = new HPHeal(gl, glu, ps);
		powerUpList.add(hp);
		powerUpList.add(hp);
		powerUpList.add(hp);
		/*
		for(int x=0; x<powerUpList.size();x++ ) {
			System.out.println("00 type: " + powerUpList.get(x).getType());
		}
		*/
		
		populateSpawns();

	}
	
	private boolean checkDuplicate(Point3f p, List<Point3f> r) {
		for (int j=0; j<r.size(); j++) {
			if(r.get(j).equals(p)) {
				return false;
		}
		}
		
		return true;
	}
	
	private void populateSpawns() {
		List<Point3f> repeats = new ArrayList<Point3f>();
		
		for (int x = 0; x < DESIRED_SPAWNS; x++) { //entering 10 spawns into the spawnList
			Point3f temp = new Point3f(0,0,0); //arbitrary point
			boolean mark = false;
			/*for each new spawn:
			 * 1) Generate a random location from the spawnsPosible list
			 * 2) Go through EACH spawn3d corresponding in the Spawn list
			 * 3) If the location is FOUND, rerandomize.
			 * 4) If location is NOT found, add a new spawn point using that location.
			 */
			
			while (!mark) {
				//repeat prevention
				//int tracking1 = (int)(((1000*Math.random())/1000)*spawnSelectionList.size());
				temp = spawnSelectionList.get((int)(((1000*Math.random())/1000)*spawnSelectionList.size()));
				
				mark = checkDuplicate(temp, repeats);
			}

			repeats.add(temp);
			//Spawn3f newSpawn = new Spawn3f(temp,randomPowerUp());
			AbstractPowerUp temp2 = randomPowerUp();
			temp2.linkLocation(temp);
			spawns.add(new Spawn3f(temp, temp2));
			
		}
	}
	
	private AbstractPowerUp randomPowerUp() {

		/*
		for(int x=0; x<powerUpList.size();x++ ) {
			System.out.println("11 type: " + powerUpList.get(x).getType());
		}
		*/
		int factor = (int) (((1000*Math.random())/1000) * powerUpList.size());
		//System.out.println("List size: " + powerUpList.size() + " " + "Factor: " + factor);
		return powerUpList.get(factor);
	}
	
	public void checkList() {
		//every 90 seconds, if there is room in the array, put random powerup
		if (emptySpawns.size()>0) {
			for (int x = 0; x < emptySpawns.size(); x++) {
				spawns.add(new Spawn3f(emptySpawns.get(x).getLocation(),randomPowerUp())); //bug: not registering that .get(x).getLocation() is a Point3f
			}
			
			emptySpawns.clear();
		}
				
	}
	
	public void draw(GL2 gl, GLU glu) { //runs every frame
		//updateLists();
		for (int t=0; t<spawns.size(); t++) {
			
			gl.glPushMatrix();
			
			AbstractPowerUp temp = spawns.get(t).getPowerUp();

			gl.glTranslatef(spawns.get(t).getLocation().getX(), spawns.get(t).getLocation().getY()-2, spawns.get(t).getLocation().getZ());
			gl.glScaled(.2,.2,.2);
			//System.out.println("Spawn Location: " + spawns.get(t).getPowerUp().getLocation());
			//System.out.println("Translating by: " + spawns.get(t).getLocation().getX() + " " +  spawns.get(t).getLocation().getY() + " " +  spawns.get(t).getLocation().getZ());
			temp.draw(gl, glu, spawns.get(t).getLocation().getX(), spawns.get(t).getLocation().getY(), spawns.get(t).getLocation().getZ());
			gl.glPopMatrix();
		}
	}
	
	
	public void updateLists() {
		checkList();

		for (int t=0; t<spawns.size(); t++) {
			if (spawns.get(t).getPowerUp().grabbed()) {
				emptySpawns.add(new Spawn3f(spawns.get(t).getLocation()));
				spawns.remove(t);
				//System.out.println("POWERUP!");
			}
		}
		
	}
	
}