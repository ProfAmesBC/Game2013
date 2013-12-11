package weapons;

import game.PlayerStats;

import java.util.LinkedList;
import java.util.List;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;

import creatures.ProjectileWatcher;

import java.util.ArrayList;
import java.util.List;

public abstract class Projectile {

	private static List<WeaponWatcher>watchers=new ArrayList<WeaponWatcher>();
	
	private float projX, projY, projZ, projAngle, projYAngle;
	private float speed = 5;
	private float lifeSpan = 50;
	public int size = 0;
	public int red = 0;
	public int green = 0;
	public int blue = 0;
	private static List<ProjectileWatcher> projectileWatchers = new LinkedList<ProjectileWatcher>();
	private PlayerStats source;
	
	public Projectile(PlayerStats s){
		source=s;
	}
	
	public static void registerWeaponWatcher(WeaponWatcher w){watchers.add(w);}
	public float getLifeSpan() {return lifeSpan;}


	public float getProjX() {return projX;}
	public void setProjX(float projX) {this.projX = projX;}
	public float getProjY() {return projY;}
	public void setProjY(float projY) {this.projY = projY;}
	public float getProjZ() {return projZ;}
	public void setProjZ(float projZ) {	this.projZ = projZ;}
	public float getProjAngle() {return projAngle;}
	public void setProjAngle(float projAngle) {this.projAngle = projAngle;}

    public float getProjYAngle() {
        return projYAngle;
    }
    public void setProjYAngle(float projYAngle) {
        this.projYAngle = projYAngle;
    }

    //These would be different for each gun
	public int getBulletSize(){return size;}
	public void setBulletSize(int size) {this.size = size;}
	public int getBulletRed() {return red;}
	public void setBulletRed(int red) {this.red = red;}
	public int getBulletGreen() {return green;}
	public void setBulletGreen(int green) {this.green = green;}
	public int getBulletBlue() {return blue;}
	public void setBulletBlue(int blue) {this.blue = blue;}
	public float getBulletSpeed() {return speed;}
	public void setBulletSpeed(float speed) {this.speed = speed;}
	
	//Call every time there is a new gun picked up, pass it each gun's characteristics
	public void newGun(int size, int red, int green, int blue, float speed) {
		setBulletSize(size);
		setBulletRed(red);
		setBulletGreen(green);
		setBulletBlue(blue);
		setBulletSpeed(speed);
	}

	
	public abstract void draw(GL2 gl, GLU glu);
	
	
	public void updateLife(){
		lifeSpan--;
	}
	
	// USE THIS
	public void updatePosition(){
		
		projX = (float) (projX + speed*Math.cos(Math.toRadians(projAngle)));
		projZ = (float) (projZ - speed*Math.sin(Math.toRadians(projAngle)));
		for(ProjectileWatcher watcher:projectileWatchers){
			watcher.projectileMoved(projX,projZ);
		}
        projY = (float) (projY + speed*Math.sin(Math.toRadians(projYAngle)));
		for(WeaponWatcher watcher:watchers)
			watcher.checkShot(this,source);
	}
	
	public static void registerProjectileWatcher(ProjectileWatcher watcher){
		projectileWatchers.add(watcher);
	}
}
