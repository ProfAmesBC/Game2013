package items;

import items.Point3d;
import items.AbstractPowerUp;

public class Spawn3d {
	Point3d spawnLocation;
	AbstractPowerUp power;
	
	public Spawn3d(Point3d l, AbstractPowerUp p) {
		spawnLocation = l;
		
	}
	
	public Spawn3d(Point3d l) {
		power = null;
		spawnLocation = l;
	}
	
	public Spawn3d() {
		this(new Point3d(0,0,0));
	}
	
	public Point3d getLocation() {
		return spawnLocation;
	}
	
	public AbstractPowerUp getPowerUp() {
		return power;
	}
}
