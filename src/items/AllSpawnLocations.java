package items;

import java.util.List;
import java.util.ArrayList;

public class AllSpawnLocations {
	
	private List<Point3f> spawns;
	
	public AllSpawnLocations() {
		for (int x =0; x<600; x+=100) {
			for (int z =0; z<500; z+=100) {
				spawns = new ArrayList<Point3f>();
				spawns.add(new Point3f(x,2,z));
			}
				
		}
	}
	
	public List<Point3f> getAllSpawnsPossible() {
		return spawns;
	}
}
