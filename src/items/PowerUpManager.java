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

	private GL2 gl;
	private GLU glu;
	private List<Spawn3f> spawns, emptySpawns;
	private List<Point3f> spawnSelectionList;
	private List<Point3f> allAvailableSpawns;
	private List<AbstractPowerUp> powerUpList;
	private List<Object> weaponsList;
	private int initialSize;
	private PlayerStats ps;
	
	AllSpawnLocations poss = new AllSpawnLocations();
	//Should be able to listen
	
	public PowerUpManager() {

		//weaponsList = new ArrayList<Weapons>(); //weaponslist does not get refreshed
		powerUpList = new ArrayList<AbstractPowerUp>();
		spawnSelectionList = poss.getAllSpawnsPossible();
		spawns = new ArrayList<Spawn3f>(); //list of all spawn locations possible; currently @ 0,0,0
		emptySpawns = new ArrayList<Spawn3f>();
		initialSize = spawns.size();
		populateSpawns();
		
		powerUpList.add(new HPHeal(gl, glu, new Point3f(0,0,0), ps));
	}
	
	
	private void populateSpawns() {
		for (int x = 0; x < 10; x++) { //entering 10 spawns into the spawnList
			Point3f temp = new Point3f(0,0,0); //arbitrary point
			boolean mark = false;
			
			/*for each new spawn:
			 * 1) Generate a random location from the spawnsPosible list
			 * 2) Go through EACH spawn3d corresponding in the Spawn list
			 * 3) If the location is FOUND, rerandomize.
			 * 4) If location is NOT found, add a new spawn point using that location.
			 */
			
			while (mark!=true) {	
				if (spawns.contains(temp)) { //if location already was selected
					temp = spawnSelectionList.get((int)(Math.random())*spawnSelectionList.size());
				} else {
					mark = true;
				}
			}		
			Spawn3f newSpawn = new Spawn3f(temp,randomPowerUp());
			newSpawn.getPowerUp().linkLocation(temp);
			spawns.add(new Spawn3f(temp, randomPowerUp()));
			
		}
	}
	
	private AbstractPowerUp randomPowerUp() {
		int factor = (int) (Math.random() * powerUpList.size());
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
	
	public void draw() { //runs every frame
		updateLists();
		for (int t=0; t<spawns.size(); t++) {
			spawns.get(t).getPowerUp().draw(gl, glu);
			}
	}
	
	
	public void updateLists() {
		for (int t=0; t<spawns.size(); t++) {
			if (spawns.get(t).getPowerUp().grabbed()) {
				emptySpawns.add(new Spawn3f(spawns.get(t).getLocation()));
				spawns.remove(t);
				System.out.println("POWERUP!");
			}
		}
	}
	
}