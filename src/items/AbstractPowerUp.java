package items;

import game.PlayerStats;
import inventory.Item;
import inventory.PlayerAttributes;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;

import com.jogamp.opengl.util.texture.Texture;

public abstract class AbstractPowerUp implements Item {
	protected float pX;
	protected float pY;
	protected float pZ;
	//coordinates of corresponding Point3f; default @ 0
	protected Point3f location;
	protected float angle;
	protected Texture texture;
	protected float playerX, playerY, playerZ;
	protected boolean grabbed;
	protected double T;
	protected static PlayerAttributes playerA;
	protected int frames;
	protected int counter;
	protected PlayerStats stats;
	protected String type;
	
	@Override
	public void playerMoved(float x, float y, float z, float angle, float y_angle,PlayerStats s) {
		float distance  = (float) Math.sqrt(Math.pow((x-pX),2) + Math.pow((z-pZ),2));
		
		this.playerX = x;
		this.playerY = y;
		this.playerZ = z;
		this.angle = angle;		
		stats = s;

		if (distance<5) {
			use();
			grabbed = true;
		}

		
	}
	

	@Override
	public abstract void draw(GL2 gl, GLU glu, float x, float y, float z);

	@Override
	public abstract void use();

	public boolean grabConditions() {
		if ((pX - 3 < playerX && pZ - 3 < playerZ)
				&& (pX + 5 > playerX) && (pZ + 5 > playerZ)
				&& (grabbed == false))
			return true;
		else
			return false;
	}
	
	
	@Override
	public abstract boolean grabbed();
	@Override
	public String getType() {return type;};
			
	public float getLocationX() {
		return pX;
	}
	public float getLocationY() {
		return pY;
	}
	public float getLocationZ() {
		return pZ;
	}
	public Point3f getLocation() {
		return location;
	}
	public float getAngle() {
		return angle;
	}
	
	public abstract void linkLocation(Point3f f);
	
	public void bugtest() {
		System.out.println(type);
	}
	
	
}