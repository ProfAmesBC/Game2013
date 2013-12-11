package inventory;

public class Bag {
	private DummyItem speedBoxes;
	private DummyItem damageBoxes;
	private DummyItem jetpackBoxes;
	private DummyItem teleportBoxes;

	public Bag() {
		speedBoxes = new DummyItem("Speed");
		damageBoxes = new DummyItem("Damage");
		teleportBoxes = new DummyItem("Teleporter");
		jetpackBoxes = new DummyItem("Jetpack");
	}

	public void addItem(Item i) {
		String checkType = i.getType();
		
		InventorySounds.pickupNoise();
		
		if (checkType.equals("Speed"))
			speedBoxes.incrementCount();
		if (checkType.equals("Jetpack"))
			jetpackBoxes.incrementCount();
		if (checkType.equals("Teleporter"))
			teleportBoxes.incrementCount();
	}

	public void useItem(String i) {
		
		
		
		if (i.equals("Speed")) {
			if (speedBoxes.getCount() > 0) {
				InventorySounds.useItemNoise();
				speedBoxes.decrementCount();
				speedBoxes.use();
			}
		}
		if (i.equals("Jetpack")) {
			if (jetpackBoxes.getCount() > 0) {
				InventorySounds.useItemNoise();
				jetpackBoxes.decrementCount();
				jetpackBoxes.use();
			}
		}

		if (i.equals("Damage")) {
			if (damageBoxes.getCount() > 0) {
				InventorySounds.useItemNoise();
				damageBoxes.decrementCount();
				damageBoxes.use();
			}
		}
		if (i.equals("Teleporter")) {
			if (teleportBoxes.getCount() > 0) {
				InventorySounds.useItemNoise();
				teleportBoxes.decrementCount();				
				teleportBoxes.use();
			}
		}
	}

	public String toString() {
		String listOfItems = "";
		listOfItems = "S:" + speedBoxes.getCount();
		listOfItems = listOfItems + " J:" + jetpackBoxes.getCount();
		listOfItems = listOfItems + " T:" + teleportBoxes.getCount();
		return listOfItems;
	}
}
