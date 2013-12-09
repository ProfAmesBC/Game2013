package inventory;

public class Bag {
	private DummyItem speedBoxes;
	private DummyItem damageBoxes;

	public Bag() {
		speedBoxes = new DummyItem("Speed");
		damageBoxes = new DummyItem("Damage");
	}

	public void addItem(Item i) {
		String checkType = i.getType();
		
		InventorySounds.pickupNoise();
		
		if (checkType.equals("Speed"))
			speedBoxes.incrementCount();
		if (checkType.equals("Damage"))
			speedBoxes.incrementCount();
	}

	public void useItem(String i) {
		
		InventorySounds.useItemNoise();
		
		if (i.equals("Speed")) {
			if (speedBoxes.getCount() > 0) {
				speedBoxes.decrementCount();
				speedBoxes.use();
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
		return listOfItems;
	}
}