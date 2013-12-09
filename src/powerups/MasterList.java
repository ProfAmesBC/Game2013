package powerups;

import java.util.List;
import java.util.ArrayList;

public class MasterList {
	
	private List<PowerUp> allPowerUps;
	
	public MasterList() {
		allPowerUps = new ArrayList<PowerUp>();
		//allPowerUps.add(new HPHeal());
	}
	
	public List getPowerUpList() {
		return allPowerUps;
	}
}
