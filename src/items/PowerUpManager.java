package items;

import game.PlayerMotion;
import game.PlayerMotionWatcher;
import game.PlayerStats;
import inventory.PlayerAttributes;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;

public class PowerUpManager implements PlayerMotionWatcher {

	private GL2 gl;
	private GLU glu;
	private List<Spawn3f> spawns, emptySpawns;
	private List<Point3f> spawnSelectionList;
	private List<AbstractPowerUp> powerUpList;
	private List<Object> weaponsList;
	private int initialSize;
	private PlayerStats ps;
	private static PlayerAttributes pa;
	private HPHeal hp = null;
	private PlusHonor ph = null;
	private Invincible invincible = null;
	private static int DESIRED_SPAWNS = 20;
	private int z; //variable to count frames / track time
	
	AllSpawnLocations poss = new AllSpawnLocations();
	//Should be able to listen
	
	public PowerUpManager(GL2 gl, GLU glu, PlayerAttributes pa) {
		//weaponsList = new ArrayList<Weapons>(); //weaponslist does not get refreshed
		this.gl = gl;
		this.glu = glu;
		powerUpList = new ArrayList<AbstractPowerUp>();
		spawnSelectionList = poss.getAllSpawnsPossible();
		spawns = new ArrayList<Spawn3f>(); //list of all spawn locations possible; currently @ 0,0,0
		emptySpawns = new ArrayList<Spawn3f>();
		initialSize = spawns.size();
		this.pa = pa;
		hp = new HPHeal(gl, glu, ps);
		ph = new PlusHonor(gl, glu, ps);
		invincible = new Invincible(gl, glu, ps, pa);
		
		
		powerUpList.add(hp);
		powerUpList.add(ph);
		powerUpList.add(invincible);
		powerUpList.add(invincible);
		powerUpList.add(hp);
		powerUpList.add(ph);		powerUpList.add(hp);
		powerUpList.add(ph);		powerUpList.add(hp);
		powerUpList.add(ph);		powerUpList.add(hp);
		powerUpList.add(ph);		powerUpList.add(hp);
		powerUpList.add(ph);		powerUpList.add(hp);
		powerUpList.add(ph);		powerUpList.add(hp);
		powerUpList.add(ph);		powerUpList.add(hp);
		powerUpList.add(ph);		powerUpList.add(hp);
		powerUpList.add(ph);		powerUpList.add(hp);
		powerUpList.add(ph);
		
		
		powerUpList.add(invincible);

		
		

		/*
		for(int x=0; x<powerUpList.size();x++ ) {
			System.out.println("00 type: " + powerUpList.get(x).getType());
		}
		*/
		
		populateSpawns();

	}
	
	private boolean checkDuplicate(Point3f p, List<Point3f> r) {
		for (int j=0; j<r.size(); j++) {
			if(r.get(j).equals(p)) {
				return false;
		}
		}
		
		return true;
	}
	
	private void populateSpawns() {
		List<Point3f> repeats = new ArrayList<Point3f>();
		
		for (int x = 0; x < DESIRED_SPAWNS; x++) { //entering 10 spawns into the spawnList
			Point3f temp = new Point3f(0,0,0); //arbitrary point
			boolean mark = false;
			/*for each new spawn:
			 * 1) Generate a random location from the spawnsPosible list
			 * 2) Go through EACH spawn3d corresponding in the Spawn list
			 * 3) If the location is FOUND, rerandomize.
			 * 4) If location is NOT found, add a new spawn point using that location.
			 */
			
			while (!mark) {
				//repeat prevention
				//int tracking1 = (int)(((1000*Math.random())/1000)*spawnSelectionList.size());
				temp = spawnSelectionList.get((int)(((1000*Math.random())/1000)*spawnSelectionList.size()));
				
				mark = checkDuplicate(temp, repeats);
			}

			repeats.add(temp);
			//Spawn3f newSpawn = new Spawn3f(temp,randomPowerUp());
			AbstractPowerUp temp2 = randomPowerUp();
			temp2.linkLocation(temp);
			spawns.add(new Spawn3f(temp, temp2));
			
		}
	}
	
	private AbstractPowerUp randomPowerUp() {

		/*
		for(int x=0; x<powerUpList.size();x++ ) {
			System.out.println("11 type: " + powerUpList.get(x).getType());
		}
		*/
		int factor = (int) (((1000*Math.random())/1000) * powerUpList.size());
		if (powerUpList.get(factor).getType().equals("HPHeal")) {
			return new HPHeal(gl, glu, ps);

		} else if (powerUpList.get(factor).getType().equals("HonorUp")) {
			return new PlusHonor(gl, glu, ps);
		} else if (powerUpList.get(factor).getType().equals("Invincible")) {
			return new Invincible(gl,glu,ps, pa);
		} else {
			System.out.println("POWERUP ERROR");
			return null;
		}
		//System.out.println("List size: " + powerUpList.size() + " " + "Factor: " + factor);
		//return powerUpList.get(factor);
	}
	
	public void checkList(int time) {
		
		if (time>=30) {
			z = 0;
		//every 90 seconds, if there is room in the array, put random powerup
		if (emptySpawns.size()>0) {
			for (int x = 0; x < emptySpawns.size(); x++) {
				spawns.add(new Spawn3f(emptySpawns.get(x).getLocation(),randomPowerUp())); //bug: not registering that .get(x).getLocation() is a Point3f
			}
			
			emptySpawns.clear();
		}
		}
	}
	
	public void draw(GL2 gl, GLU glu) { //runs every frame
		updateLists();
		for (int t=0; t<spawns.size(); t++) {
			
			gl.glPushMatrix();
			
			AbstractPowerUp temp = spawns.get(t).getPowerUp();

			gl.glTranslatef(spawns.get(t).getLocation().getX(), spawns.get(t).getLocation().getY()-2, spawns.get(t).getLocation().getZ());
			gl.glScaled(.5,.5,.5);
			//System.out.println("Spawn Location: " + spawns.get(t).getPowerUp().getLocation());
			//System.out.println("Translating by: " + spawns.get(t).getLocation().getX() + " " +  spawns.get(t).getLocation().getY() + " " +  spawns.get(t).getLocation().getZ());
			temp.draw(gl, glu, spawns.get(t).getLocation().getX(), spawns.get(t).getLocation().getY(), spawns.get(t).getLocation().getZ());
			gl.glPopMatrix();
		}
	}
	
	
	public void updateLists() {
		checkList(z);

		for (int t=0; t<spawns.size(); t++) {
			if (spawns.get(t).getPowerUp().grabbed() == true) {
				emptySpawns.add(new Spawn3f(spawns.get(t).getLocation()));
				spawns.remove(t);
				System.out.println("Removed from spawn list. Empty Spawns: " + emptySpawns.size() + " Spawns filled: " + spawns.size());
			}
		}
		
		z+=1;
	}

	@Override
	public void playerMoved(float x, float y, float z, float angle,
			float y_angle, PlayerStats s) {
		
		for (int t=0; t<spawns.size(); t++) {
		float distance  = (float) Math.sqrt(Math.pow((spawns.get(t).getLocation().getX()-x),2) + Math.pow((spawns.get(t).getLocation().getZ()-z),2));

		if (distance<5) {
			spawns.get(t).getPowerUp().use();
			updateLists();
		}
		z+=1;
		}
		
		
	}
	
}