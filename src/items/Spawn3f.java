package items;

import items.Point3f;
import items.AbstractPowerUp;

public class Spawn3f {
	Point3f spawnLocation;
	AbstractPowerUp power;
	
	public Spawn3f(Point3f l, AbstractPowerUp p) {
		spawnLocation = l;
		power = p;
	}
	
	public Spawn3f(Point3f l) {
		power = null;
		spawnLocation = l;
	}
	
	public Spawn3f() {
		this(new Point3f(0,0,0));
	}
	
	public Point3f getLocation() {
		return spawnLocation;
	}
	
	public AbstractPowerUp getPowerUp() {
		return power;
	}
}
