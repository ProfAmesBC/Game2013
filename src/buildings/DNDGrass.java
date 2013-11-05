package buildings;
// HW#5, CS333 DNDGrass class, Fall 2013
// by David D'Antona

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;
import com.jogamp.opengl.util.texture.Texture;

public class DNDGrass {

	// ccw point
	private Point3d v1 = new Point3d(100, 0, 100);
	private Point3d v2 = new Point3d(100, 0, 0);
	private Point3d v3 = new Point3d(0, 0, 0);
	private Point3d v4 = new Point3d(0, 0, 100);
	Texture grassTexture;

	public DNDGrass(GL2 gl, GLU glu, Texture grassTexture) {
		this.grassTexture = grassTexture;
	}

	public void create(GL2 gl) {
		grassTexture.bind(gl);
		gl.glBegin(GL2.GL_QUADS);
		// ccw as viewed from front
		gl.glTexCoord2f(0f, 2f);
		gl.glVertex3d(v1.getX(), v1.getY(), v1.getZ());
		gl.glTexCoord2f(3f, 2f);
		gl.glVertex3d(v2.getX(), v2.getY(), v2.getZ());
		gl.glTexCoord2f(3f, 0f);
		gl.glVertex3d(v3.getX(), v3.getY(), v3.getZ());
		gl.glTexCoord2f(0f, 0f);
		gl.glVertex3d(v4.getX(), v4.getY(), v4.getZ());
		gl.glEnd();
	}

}