package inventory;

import game.PlayerAttributes;

public class Bag {	
	private DummyItem speedBoxes;
	private DummyItem damageBoxes;
	
	public Bag() {
		speedBoxes = new DummyItem("Speed");
		damageBoxes = new DummyItem("Damage");
	}

	public void addItem(PowerUp i) {
		String checkType = i.getType();
		System.out.println("");
		if(checkType.equals("Speed"))
			speedBoxes.incrementCount();
		if(checkType.equals("Damage"))
			speedBoxes.incrementCount();
	}

	public void useItem(String i) {
		if(i.equals("Speed")) {			
			if(speedBoxes.getCount() > 0) {
				System.out.println(speedBoxes.getCount());
				speedBoxes.decrementCount();
				speedBoxes.use();
			}
		}
		
		if(i.equals("Damage")) {
			if(damageBoxes.getCount() > 0) {
				damageBoxes.decrementCount();
				damageBoxes.use();
			}
		}
		
	}

}