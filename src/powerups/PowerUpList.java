package powerups;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PowerUpList {

	private HashMap weaponsList, boosterList; //Map of the Point3d and the powerup at that location
	private AllSpawnLocations spawns;
	
	public PowerUpList() {
		weaponsList = new HashMap(); //weaponslist does not get refreshed
		boosterList = new HashMap(); //boosterlist DOES get refreshed
		spawns = new AllSpawnLocations(); //list of all spawn locations possible; currently @ 0,0,0
	}
	
	public void refreshList() {
		//every 90 seconds, if there is room in the array, put random powerup
	}
}
