package creatures;

import game.BatsEverywhere;

import java.util.Stack;

public class CreatureManager {
	
	private static Stack<Location> spawnLocations = new ArrayStack<Location>();
	
	public static addLocation(Location spawnLocation){
		spawnLocations.push(spawnLocation);
	}
	
	public static addRobot(){
		Location l = spawnLocations.pop();
		BatsEverywhere.creatures.add(new Robot());
	}
}