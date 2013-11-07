package buildings;

public class JossickEye {
	private double x;
	private double y;
	private double z;
	private double angle;
	
	public JossickEye(double xpos, double ypos, double zpos) {
		x = xpos;
		y = ypos;
		z = zpos;
		angle = 0;
	}
	public double getX() { return x;}
	public double getY() { return y;}
	public double getZ() { return z;}
	public double getAngle() {return angle;}
	
	public void setX(double nx) { x = nx;}
	public void setY(double ny) { y = ny;}
	public void setZ(double nz) { z = nz;}
	public void setAngle(double nangle){ angle = nangle;}
}
