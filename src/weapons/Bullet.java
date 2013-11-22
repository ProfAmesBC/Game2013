package weapons;



public class Bullet{
	private float x, y, z, angle;
	
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
