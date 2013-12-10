package game;


// Immutable
public class Point {
	
    private final double x, y, z; // the public coordinates


    public Point(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    public Point() {
        this(0,0,0);
    }

    // Getters
    public double x() { return x; }
    public double y() { return y; }
    public double z() { return z; }

    public String toString() {
        return "(" + x + "," + y + "," + z + ")";
    }
}