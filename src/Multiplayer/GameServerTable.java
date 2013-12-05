package Multiplayer;

public class GameServerTable {
	private double[] x;
	private double[] y;
	private double[] z; 
	private String[] id; 
	private int playerIndex; 
	
	public GameServerTable(int playerNumber){
		this.playerIndex = 0;
		this.x = new double[playerNumber]; 
		this.y = new double[playerNumber]; 
		this.z = new double[playerNumber]; 
		this.id = new String[playerNumber]; 
	}
	
	//getters & setters 
	public double getX(int index){
		return x[index]; 
	}
	public void setX(int index, double value){
		x[index] = value; 
	}
	
	public double getY(int index){
		return y[index]; 
	}
	public void setY(int index, double value){
		y[index] = value; 
	}
	
	public double getZ(int index){
		return z[index]; 
	}
	public void setZ(int index, double value){
		z[index] = value; 
	}
	public String getID(int index){
		return id[index]; 
	}
	public void setID(int index, String newID){
		id[index] = newID; 
	}
	
	
	public void addPlayer(String newID, double newX, double newY, double newZ){
		double[] temp; 
		String[] temp2;
		playerIndex++;
		
		temp = new double[playerIndex+1]; 
		System.arraycopy(x, 0, temp, 0, x.length); 
		temp[playerIndex] = newX; 
		x = temp; 
		
		temp = new double[playerIndex+1]; 
		System.arraycopy(y, 0, temp, 0, y.length); 
		temp[playerIndex] = newY; 
		y = temp; 
		
		temp = new double[playerIndex+1]; 
		System.arraycopy(z, 0, temp, 0, z.length); 
		temp[playerIndex] = newZ; 
		z = temp; 
		
		temp2 = new String[playerIndex+1];
		System.arraycopy(id, 0, temp2, 0, id.length);
		temp2[playerIndex] = newID; 
		id = temp2; 
	}
	
	public void printTable(){
		for (int i=0; i<=playerIndex; i++)
			System.out.println("Player: "+ i + " ID: "+ id[i] +" x: "+ x[i]+ " y: "+ y[i]+ " z: "+ z[i]);	
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"); 
		System.out.println(); 
	}
	
}
