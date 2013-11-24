package game;

import inventory.Bag;

public class PlayerAttributes {
	
	private float stepSize;
	private Bag b;
	public PlayerAttributes(float steps, Bag b){
		this.b = b;
		this.stepSize = steps;		
	}
	public float getStepSize() {
		return stepSize;
	}
	public void setStepSize(float stepSize) {
		this.stepSize = stepSize;
	}
	public Bag getBag() {		
		return b;
	}
		
}