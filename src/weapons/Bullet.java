package weapons;



public class Bullet{
	private float x, y, z, angle;
	private int speed = 3;
	public int getSpeed() {return speed;}
	public void setX(float x) {this.x = x;}
	public void setY(float y) {	this.y = y;}
	public void setZ(float z) {this.z = z;}
	public float getX() {return x;}
	public float getY() {return y;}
	public float getZ() {return z;}
	public float getAngle() {return angle;}

	public Bullet(float x, float y, float z, float angle){
		this.x = x;
		this.y = y;
		this.z = z;
		this.angle = angle;
	}



}
