package items;

import javax.media.opengl.*;

//Immutable
public class Point3f
{
private final float x, y, z; // the public coordinates

public Point3f() {
    this(0,0,0);
}

public Point3f(float x, float y, float z) {
    this.x = x;
    this.y = y;
    this.z = z;
}

// Getters
public float getX() { return x; }
public float getY() { return y; }
public float getZ() { return z; }

// Draw the point; assumes we're inside of glBegin(GL_POINTS)/glEnd()
public void draw(GL2 gl) {
    gl.glVertex3d(x,y,z);
}

public String toString() {
    return "(" + x + "," + y + "," + z + ")";
}
}
