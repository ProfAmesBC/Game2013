package inventory;

import game.PlayerMotion;

public class PlayerAttributes {

	private PlayerMotion p;
	private Bag b;

	public PlayerAttributes(PlayerMotion p, Bag b) {
		this.p = p;
		this.b = b;
	}

	public float getStepSize() {
		return p.getStep();
	} 

	public void setStepSize(float stepSize, int duration) {
		// calls PlayerMotion
		p.setStep(stepSize, duration);
	}

	public Bag getBag() {
		return b;
	}

	public void fly(int height, int duration) {		
		p.fly(height, duration);
	}

	public void teleport(int i) {
		p.teleport(i);
		
	}

}