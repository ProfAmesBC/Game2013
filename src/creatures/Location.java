package creatures;

public class Location {

private final float x, y, z; // the public coordinates

public Location() {
    this(0,0,0);
}

public Location(float x, float y, float z) {
    this.x = x;
    this.y = y;
    this.z = z;
}

public float getX() { return x; }
public float getY() { return y; }
public float getZ() { return z; }


}
