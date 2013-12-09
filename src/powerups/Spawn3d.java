package powerups;

public class Spawn3d {
	Point3d spawnLocation;
	PowerUp power;
	
	public Spawn3d(Point3d l, PowerUp p) {
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
	
	public PowerUp getPowerUp() {
		return power;
	}
}
