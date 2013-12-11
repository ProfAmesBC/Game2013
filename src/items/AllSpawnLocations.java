package items;

import java.util.List;
import java.util.ArrayList;

public class AllSpawnLocations {
	
	private List<Point3f> spawns;
	
	public AllSpawnLocations() {
		spawns = new ArrayList<Point3f>();

		//for (int x =0; x<600; x+=100) {
			//for (int z =0; z<500; z+=100) {
				//spawns.add(new Point3f(x,2,z));
		//	}	
		//}
		spawns.add(new Point3f(3,5,50));
		spawns.add(new Point3f(5,5,50));
		spawns.add(new Point3f(7,5,50));
		spawns.add(new Point3f(9,5,50));
		spawns.add(new Point3f(11,5,50));
		spawns.add(new Point3f(13,5,50));
		spawns.add(new Point3f(15,5,50));
		spawns.add(new Point3f(17,5,50));
		spawns.add(new Point3f(19,5,50));
		spawns.add(new Point3f(21,5,50));
		spawns.add(new Point3f(23,5,50));
		spawns.add(new Point3f(25,5,50));

	}
	
	public List<Point3f> getAllSpawnsPossible() {
		return spawns;
	}
}
