package items;

import game.PlayerStats;
import inventory.Item;
import inventory.PlayerAttributes;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;

import com.jogamp.opengl.util.texture.Texture;

public abstract class AbstractPowerUp implements Item {
	protected float itemX;
	protected float itemY;
	protected float itemZ;
	protected Point3d location;
	protected float angle;
	protected Texture texture;
	protected float playerX, playerY, playerZ;
	protected boolean grabbed;
	protected double T;
	protected static PlayerAttributes p;
	protected int frames;
	protected int counter;
	protected PlayerStats stats;
	
	@Override
	public void playerMoved(float x, float y, float z, float angle, float y_angle,PlayerStats s) {
			this.playerX = x;
			this.playerY = y;
			this.playerZ = z;
			this.angle = angle;		
			stats = s;
	}
	

	@Override
	public abstract void draw(GL2 gl, GLU glu);

	@Override
	public void use(){ //not used
		}

	private boolean grabConditions() {
		if ((itemX - 3 < playerX && itemZ - 3 < playerZ)
				&& (itemX + 5 > playerX) && (itemZ + 5 > playerZ)
				&& (grabbed == false))
			return true;
		else
			return false;
	}
	
	@Override
	public abstract boolean grabbed();
	@Override
	public abstract String getType();
	
	public abstract void activate();
		
	public float getLocationX() {
		return itemX;
	}
	public float getLocationY() {
		return itemY;
	}
	public float getLocationZ() {
		return itemZ;
	}
	public Point3d getLocation() {
		return location;
	}
	public float getAngle() {
		return angle;
	}
	
	
}