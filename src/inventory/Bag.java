package inventory;

public class Bag {
	private DummyItem speedBoxes;
	private DummyItem damageBoxes;
	private DummyItem jetpackBoxes;

	public Bag() {
		speedBoxes = new DummyItem("Speed");
		damageBoxes = new DummyItem("Damage");
		jetpackBoxes = new DummyItem("Jetpack");
	}

	public void addItem(Item i) {
		String checkType = i.getType();
		
		InventorySounds.pickupNoise();
		
		if (checkType.equals("Speed"))
			speedBoxes.incrementCount();
		if (checkType.equals("Jetpack"))
			jetpackBoxes.incrementCount();
	}

	public void useItem(String i) {
		
		InventorySounds.useItemNoise();
		
		if (i.equals("Speed")) {
			if (speedBoxes.getCount() > 0) {
				speedBoxes.decrementCount();
				speedBoxes.use();
			}
		}
		if (i.equals("Jetpack")) {
			if (jetpackBoxes.getCount() > 0) {
				jetpackBoxes.decrementCount();
				jetpackBoxes.use();
			}
		}

		if (i.equals("Damage")) {
			if (damageBoxes.getCount() > 0) {
				damageBoxes.decrementCount();
				damageBoxes.use();
			}
		}
	}

	public String toString() {
		String listOfItems = "";
		listOfItems = "S:" + speedBoxes.getCount();
		listOfItems = listOfItems + " D:" + damageBoxes.getCount();
		listOfItems = listOfItems + "J:" + jetpackBoxes.getCount();
		return listOfItems;
	}
}
