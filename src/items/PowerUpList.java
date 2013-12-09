package items;

import inventory.Item;

import java.util.HashMap;
import java.util.Map;

public class PowerUpList {

	private Map<Point3d, Item> weaponsList, boosterList; //Map of the Point3d and the item at that location
	private AllSpawnLocations spawns;
	
	public PowerUpList() {
		// not sure why you're using a HashMap, but I fixed your declaration
		// try to use our bag class if you can, Nikola and team
		weaponsList = new HashMap<Point3d, Item>(); //weaponslist does not get refreshed
		boosterList = new HashMap<Point3d, Item>(); //boosterlist DOES get refreshed
		spawns = new AllSpawnLocations(); //list of all spawn locations possible; currently @ 0,0,0
	}
	
	public void refreshList() {
		//every 90 seconds, if there is room in the array, put random powerup
	}
}