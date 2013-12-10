package items;

import java.util.List;
import java.util.ArrayList;

public class AllSpawnLocations {
	
	private List<Point3d> spawns;
	private HPHeal test;
	
	public AllSpawnLocations() {
		spawns = new ArrayList<Point3d>();
		spawns.add(new Point3d(0,0,0)); //test location; populate with working locations later
		test = new HPHeal(null, null, 0, 0, 0, null, null);
		test.getLocationX();
		populate();
	}
	
	public void populate() {
		spawns.add(new Point3d(73, 0, 70));
		spawns.add(new Point3d(103, 0, 100));
		spawns.add(new Point3d(203, 0, 200));
		spawns.add(new Point3d(303, 0, 300));
		spawns.add(new Point3d(353, 0, 350));
		spawns.add(new Point3d(403, 0, 400));
		spawns.add(new Point3d(33,0,30));
		spawns.add(new Point3d(83,0,80));
		spawns.add(new Point3d(83,0,120));
		spawns.add(new Point3d(103,0,120));
	}
}
