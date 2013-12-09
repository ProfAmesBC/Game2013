
package powerups;

import game.PlayerMotion;
import game.PlayerMotionWatcher;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PowerUpManager implements PlayerMotionWatcher {

	private List<Spawn3d> spawns, emptySpawns;
	private List<PowerUp> powerUpList;
	private List<Object> weaponsList;
	private MasterList allLists;
	private int initialSize;
	//Should be able to listen
	
	public PowerUpManager() {
		PlayerMotion.registerPlayerWatcher(this);

		allLists = new MasterList();
		//weaponsList = new ArrayList<Weapons>(); //weaponslist does not get refreshed
		powerUpList = allLists.getPowerUpList(); //boosterlist DOES get refreshed
		spawns = new ArrayList<Spawn3d>(); //list of all spawn locations possible; currently @ 0,0,0
		emptySpawns = new ArrayList<Spawn3d>();
		initialSize = spawns.size();
		populateSpawns();
		
	}
	
	private void populateSpawns() {
		for (int x = 0; x < 10; x++) {
			spawns.add(new Spawn3d(new Point3d(Math.random()*1000,Math.random()*1000,Math.random()*1000), randomPowerUp()));
		}
	}
	
	private PowerUp randomPowerUp() {
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
	
	public void collision() {
		//if collision, remove the spawn at that location and move it to the empty spawn
	}

	@Override
	public void playerMoved(float x, float y, float z, float angle, float y_angle) {
		// TODO Auto-generated method stub
		DecimalFormat formatter = new DecimalFormat("#,##0.0");
		System.out.println("Player is now at location (" + formatter.format(x) + "," +
                formatter.format(y) + "," + formatter.format(z));
		
		for (int t=0; t<spawns.size(); t++) {
			if (x == spawns.get(t).getLocation().getX() && y == spawns.get(t).getLocation().getY() && z == spawns.get(t).getLocation().getZ()) {
				System.out.println("POWER UP!");
				
				PowerUp temp = spawns.get(t).getPowerUp();
				
				emptySpawns.add(new Spawn3d(spawns.get(t).getLocation()));
				spawns.remove(t);
				
				temp.applyPowerUp();
			}
		}
	
	}
}

