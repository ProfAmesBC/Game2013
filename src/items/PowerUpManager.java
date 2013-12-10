package items;

import game.PlayerMotion;
import game.PlayerMotionWatcher;
import game.PlayerStats;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PowerUpManager implements PlayerMotionWatcher {

	private List<Spawn3d> spawns, emptySpawns;
	private List<Point3d> spawnSelectionList;
	private List<AbstractPowerUp> powerUpList;
	private List<Object> weaponsList;
	private int initialSize;
	//Should be able to listen
	
	public PowerUpManager() {
		PlayerMotion.registerPlayerWatcher(this);

		//weaponsList = new ArrayList<Weapons>(); //weaponslist does not get refreshed
		powerUpList = new ArrayList<AbstractPowerUp>();
		spawnSelectionList = new ArrayList<Point3d>();
		initializeSelectionList();
		spawns = new ArrayList<Spawn3d>(); //list of all spawn locations possible; currently @ 0,0,0
		emptySpawns = new ArrayList<Spawn3d>();
		initialSize = spawns.size();
		populateSpawns();
		
	}
	
	private void initializeSelectionList() {
		spawnSelectionList.add(new Point3d(0,0,0));
	}
	
	private void populateSpawns() {
		for (int x = 0; x < 10; x++) { //entering 10 spawns into the spawnList
			Point3d temp = new Point3d(0,0,0); //arbitrary point
			boolean mark = false;
			
			/*for each new spawn:
			 * 1) Generate a random location from the spawnsPosible list
			 * 2) Go through EACH spawn3d corresponding in the Spawn list
			 * 3) If the location is FOUND, rerandomize.
			 * 4) If location is NOT found, add a new spawn point using that location.
			 */
			
			while (mark!=true) {
				temp = spawnSelectionList.get((int)(1000*Math.random())*spawnSelectionList.size());//random position within spawnSelectionList
	
				if (spawns.contains(temp)) {
					temp = spawnSelectionList.get((int)(1000*Math.random())*spawnSelectionList.size());
				} else {
					mark = true;
				}
			}		
			
			spawns.add(new Spawn3d(temp, randomPowerUp()));
			
		}
	}
	
	private AbstractPowerUp randomPowerUp() {
		int factor = (int) Math.random() * powerUpList.size();
		return powerUpList.get(factor);
	}
	
	public void checkList() {
		//every 90 seconds, if there is room in the array, put random powerup
		if (emptySpawns.size()>0) {
			for (int x = 0; x < emptySpawns.size(); x++) {
				spawns.add(new Spawn3d(emptySpawns.get(x).getLocation(),randomPowerUp())); //bug: not registering that .get(x).getLocation() is a Point3d
			}
			
			emptySpawns.clear();
		}
				
	}
	

	@Override
	public void playerMoved(float x, float y, float z, float angle, float y_angle,PlayerStats s) {
		// TODO Auto-generated method stub
		DecimalFormat formatter = new DecimalFormat("#,##0.0");
		System.out.println("Player is now at location (" + formatter.format(x) + "," +
                formatter.format(y) + "," + formatter.format(z));
		
		for (int t=0; t<spawns.size(); t++) {
			if (Math.abs(spawns.get(t).getLocation().getX()-x)<1 && Math.abs(spawns.get(t).getLocation().getY()-y)<1 && Math.abs(spawns.get(t).getLocation().getZ()-z)<1) {
				//has collision
				System.out.println("POWER UP!");
				
				//store corresponding powerup
				AbstractPowerUp temp = spawns.get(t).getPowerUp();
				
				//move used location to used list
				emptySpawns.add(new Spawn3d(spawns.get(t).getLocation()));
				
				//remove from active list
				spawns.remove(t);
				
				//implement
				temp.activate();
			}
		}
	}
}
