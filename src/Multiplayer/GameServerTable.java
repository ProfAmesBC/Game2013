package Multiplayer;

import java.util.LinkedList;

public class GameServerTable {
	private LinkedList<String> id; 
	private LinkedList<Float> x;
	private LinkedList<Float> y;
	private LinkedList<Float> z; 
	private LinkedList<Float> angle; 

	public GameServerTable(){
		this.id = new LinkedList<String>(); 
		this.x = new LinkedList<Float>(); 
		this.y = new LinkedList<Float>(); 
		this.z = new LinkedList<Float>(); 
		this.angle = new LinkedList<Float>(); 
	}

	//getters & setters 
	public String getID(int index){
		return id.get(index); 
	}
	public void setID(int index, String newID){
		id.set(index, newID); 
	}

	public float getX(int index){
		return x.get(index); 
	}
	public void setX(int index, float value){
		x.set(index, value); 
	}

	public float getY(int index){
		return y.get(index); 
	}
	public void setY(int index, float value){
		y.set(index, value); 
	}

	public float getZ(int index){
		return z.get(index); 
	}
	public void setZ(int index, float value){
		z.set(index, value); 
	}

	public float getAngle(int index){
		return angle.get(index); 
	}
	public void setAngle(int index, float value){
		angle.set(index, value); 
	}

	public void addPlayer(String newID, float newX, float newY, float newZ, float newAngle){
		id.add(newID); 
		x.add(newX);
		y.add(newY); 
		z.add(newZ); 
		angle.add(newAngle); 
	}

	public void printTable(){
		for (int i=0; i<=id.size(); i++)
			System.out.println("Player: "+ i + " ID: "+ id.get(i) +" x: "+ x.get(i)+ " y: "+ y.get(i)+ " z: "+ z.get(i));	
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"); 
		System.out.println(); 
	}

}
