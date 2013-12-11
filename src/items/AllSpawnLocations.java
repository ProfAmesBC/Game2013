package items;

import java.util.List;
import java.util.ArrayList;

public class AllSpawnLocations {
	
	private List<Point3f> spawns;
	
	public AllSpawnLocations() {
		spawns = new ArrayList<Point3f>();

		for (int x =50; x<600; x+=50) {
			for (int z =50; z<550; z+=50) {
				spawns.add(new Point3f(x,2,z));
			}	
		}
		
		/*
		 * Manual point insertion; for bug testing
		spawns.add(new Point3f(3,5,75));
		spawns.add(new Point3f(5,5,75));
		spawns.add(new Point3f(7,5,75));
		spawns.add(new Point3f(9,5,75));
		spawns.add(new Point3f(11,5,75));
		spawns.add(new Point3f(13,5,75));
		spawns.add(new Point3f(15,5,75));
		spawns.add(new Point3f(17,5,75));
		spawns.add(new Point3f(19,5,75));
		spawns.add(new Point3f(21,5,75));
		spawns.add(new Point3f(23,5,75));
		spawns.add(new Point3f(25,5,75));
		spawns.add(new Point3f(27,5,75));
		spawns.add(new Point3f(29,5,75));
		spawns.add(new Point3f(31,5,75));
		spawns.add(new Point3f(33,5,75));
		spawns.add(new Point3f(35,5,75));
		spawns.add(new Point3f(37,5,75));
		spawns.add(new Point3f(39,5,75));
		spawns.add(new Point3f(41,5,75));
		spawns.add(new Point3f(43,5,75));
		spawns.add(new Point3f(45,5,75));
		spawns.add(new Point3f(47,5,75));
		*/

	}
	
	public List<Point3f> getAllSpawnsPossible() {
		return spawns;
	}
}
