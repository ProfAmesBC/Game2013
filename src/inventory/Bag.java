package inventory;
public class Bag {
	private int speedUp; 
	private int damageUp;
	
	public Bag(){
		speedUp = 0;
		damageUp = 0;				
	}
	public void addSpeedItem(){
		speedUp++;
	}
	public void addDamageItem(){
		damageUp++;
	}
	public void useSpeedUp(){
		speedUp--;
	}
	public void useDoubleDamage(){
		damageUp--;
	}
	public int getSpeedUp(){
		return speedUp;
	}
}
