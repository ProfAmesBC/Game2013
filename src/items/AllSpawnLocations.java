package items;

import java.util.List;
import java.util.ArrayList;

public class AllSpawnLocations {
	
	private List<Point3d> spawns;
	private HPHeal test;
	
	public AllSpawnLocations() {
		spawns = new ArrayList<Point3d>();
		spawns.add(new Point3d(0,0,0)); //test location; populate with working locations later
		test = new HPHeal();
		test.getLocationX();
	}
}
