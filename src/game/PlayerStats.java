package game;

public class PlayerStats{
	public static final int MAX_HEALTH=10;
	
	private int health=MAX_HEALTH,honor=8;
	private PlayerMotion motion;
	
	public PlayerStats(PlayerMotion m){
		motion=m;
		motion.setStats(this);
	}
	
	public boolean alive(){return health>0;}
	public boolean noHonor(){return honor<1;}
	
	public void changeHealth(int i){
		health+=i;
		if(health<=0){
			health=0;
			motion.setMobile(false);
		}
		if(health>MAX_HEALTH)health=MAX_HEALTH;
	}
	public void changeHonor(int i){honor+=i;}
	
	public String healthString(){
		String s="Health: "+health+"/"+MAX_HEALTH;
		if(health<=0)s+=" - you died";
		return s;
	}
	public String honorString(){
		String s="Honor: "+honor;
		if(honor<1)s+=" - can't shoot";
		return s;
	}
	
	public int checkHealth() {return health;}
}
