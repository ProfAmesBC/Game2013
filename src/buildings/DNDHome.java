package buildings;
// HW#5, CS333 DNDHome class, Fall 2013
// by David D'Antona

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;
import com.jogamp.opengl.util.texture.Texture;

public class DNDHome {

	// front points, ccw
	private Point3d v1 = new Point3d(60, 20, 75);
	private Point3d v2 = new Point3d(40, 20, 75);
	private Point3d v3 = new Point3d(40,  0, 75);
	private Point3d v4 = new Point3d(60,  0, 75);
	// door points
	private Point3d v25 = new Point3d(40, 10, 75);
	private Point3d v45 = new Point3d(60, 10, 75);

	// back points, ccw
	private Point3d v5 = new Point3d(60, 20, 25);
	private Point3d v6 = new Point3d(40, 20, 25);
	private Point3d v7 = new Point3d(40,  0, 25);
	private Point3d v8 = new Point3d(60,  0, 25);
	// door points
	private Point3d v65 = new Point3d(40, 10, 25);
	private Point3d v85 = new Point3d(60, 10, 25);

	// roof points
	private Point3d v9 = new Point3d( 50, 30, 75);
	private Point3d v10 = new Point3d(50, 30, 25);
	
	// front door points
	private Point3d v11 = new Point3d(54, 10, 75);
	private Point3d v12 = new Point3d(46, 10, 75);
	private Point3d v13 = new Point3d(46, 0, 75);
	private Point3d v14 = new Point3d(54, 0, 75);
	
	// back door points
	private Point3d v15 = new Point3d(54, 10, 25);
	private Point3d v16 = new Point3d(46, 10, 25);
	private Point3d v17 = new Point3d(46, 0, 25);
	private Point3d v18 = new Point3d(54, 0, 25);

	private Texture brickTexture, floorTexture;

	public DNDHome(GL2 gl, GLU glu, Texture brickTexture, Texture floorTexture) {
		this.brickTexture = brickTexture;
		this.floorTexture = floorTexture;
	}
	
	public void create(GL2 gl) {
    	createFrontWall(gl);
    	createFloor(gl);
    	createLeftWall(gl);
    	createRightWall(gl);
    	createBackWall(gl);
    	makeRoof(gl);
	}
	
	private void createFrontWall(GL2 gl) {
		
		brickTexture.bind(gl);
		gl.glBegin(GL2.GL_QUADS);
		// ccw as viewed from front
		gl.glTexCoord2f(0f, 2f);
		gl.glVertex3d(v1.getX(), v1.getY(), v1.getZ());
		gl.glTexCoord2f(3f, 2f);
		gl.glVertex3d(v2.getX(), v2.getY(), v2.getZ());
		gl.glTexCoord2f(3f, 0f);
		gl.glVertex3d(v25.getX(), v25.getY(), v25.getZ());
		gl.glTexCoord2f(0f, 0f);
		gl.glVertex3d(v45.getX(), v45.getY(), v45.getZ());
		gl.glEnd();
		brickTexture.bind(gl);
		gl.glBegin(GL2.GL_QUADS);
		// cw as viewed from front, so can be seen as ccw from back
		gl.glTexCoord2f(0f, 2f);
		gl.glVertex3d(v45.getX(), v45.getY(), v45.getZ());
		gl.glTexCoord2f(3f, 2f);
		gl.glVertex3d(v25.getX(), v25.getY(), v25.getZ());
		gl.glTexCoord2f(3f, 0f);
		gl.glVertex3d(v2.getX(), v2.getY(), v2.getZ());
		gl.glTexCoord2f(0f, 0f);
		gl.glVertex3d(v1.getX(), v1.getY(), v1.getZ());
		gl.glEnd();
		
		brickTexture.bind(gl);
		gl.glBegin(GL2.GL_QUADS);
		// ccw as viewed from front
		gl.glTexCoord2f(0f, 2f);
		gl.glVertex3d(v12.getX(), v12.getY(), v12.getZ());
		gl.glTexCoord2f(3f, 2f);
		gl.glVertex3d(v25.getX(), v25.getY(), v25.getZ());
		gl.glTexCoord2f(3f, 0f);
		gl.glVertex3d(v3.getX(), v3.getY(), v3.getZ());
		gl.glTexCoord2f(0f, 0f);
		gl.glVertex3d(v13.getX(), v13.getY(), v13.getZ());
		gl.glEnd();
		brickTexture.bind(gl);
		gl.glBegin(GL2.GL_QUADS);
		// cw as viewed from front, so can be seen as ccw from back
		gl.glTexCoord2f(0f, 2f);
		gl.glVertex3d(v13.getX(), v13.getY(), v13.getZ());
		gl.glTexCoord2f(3f, 2f);
		gl.glVertex3d(v3.getX(), v3.getY(), v3.getZ());
		gl.glTexCoord2f(3f, 0f);
		gl.glVertex3d(v25.getX(), v25.getY(), v25.getZ());
		gl.glTexCoord2f(0f, 0f);
		gl.glVertex3d(v12.getX(), v12.getY(), v12.getZ());
		gl.glEnd();
		
		brickTexture.bind(gl);
		gl.glBegin(GL2.GL_QUADS);
		// ccw as viewed from front
		gl.glTexCoord2f(0f, 2f);
		gl.glVertex3d(v45.getX(), v45.getY(), v45.getZ());
		gl.glTexCoord2f(3f, 2f);
		gl.glVertex3d(v11.getX(), v11.getY(), v11.getZ());
		gl.glTexCoord2f(3f, 0f);
		gl.glVertex3d(v14.getX(), v14.getY(), v14.getZ());
		gl.glTexCoord2f(0f, 0f);
		gl.glVertex3d(v4.getX(), v4.getY(), v4.getZ());
		gl.glEnd();
		brickTexture.bind(gl);
		gl.glBegin(GL2.GL_QUADS);
		// cw as viewed from front, so can be seen as ccw from back
		gl.glTexCoord2f(0f, 2f);
		gl.glVertex3d(v4.getX(), v4.getY(), v4.getZ());
		gl.glTexCoord2f(3f, 2f);
		gl.glVertex3d(v14.getX(), v14.getY(), v14.getZ());
		gl.glTexCoord2f(3f, 0f);
		gl.glVertex3d(v11.getX(), v11.getY(), v11.getZ());
		gl.glTexCoord2f(0f, 0f);
		gl.glVertex3d(v45.getX(), v45.getY(), v45.getZ());
		gl.glEnd();
	}
	
	private void createBackWall(GL2 gl) {
		brickTexture.bind(gl);
		gl.glBegin(GL2.GL_QUADS);
		// cw as viewed from front, so can be seen as ccw from back
		gl.glTexCoord2f(0f, 2f);
		gl.glVertex3d(v85.getX(), v85.getY(), v85.getZ());
		gl.glTexCoord2f(3f, 2f);
		gl.glVertex3d(v65.getX(), v65.getY(), v65.getZ());
		gl.glTexCoord2f(3f, 0f);
		gl.glVertex3d(v6.getX(), v6.getY(), v6.getZ());
		gl.glTexCoord2f(0f, 0f);
		gl.glVertex3d(v5.getX(), v5.getY(), v5.getZ());
		gl.glEnd();
		brickTexture.bind(gl);
		gl.glBegin(GL2.GL_QUADS);
		// ccw as viewed from front
		gl.glTexCoord2f(0f, 2f);
		gl.glVertex3d(v5.getX(), v5.getY(), v5.getZ());
		gl.glTexCoord2f(3f, 2f);
		gl.glVertex3d(v6.getX(), v6.getY(), v6.getZ());
		gl.glTexCoord2f(3f, 0f);
		gl.glVertex3d(v65.getX(), v65.getY(), v65.getZ());
		gl.glTexCoord2f(0f, 0f);
		gl.glVertex3d(v85.getX(), v85.getY(), v85.getZ());
		gl.glEnd();

		brickTexture.bind(gl);
		gl.glBegin(GL2.GL_QUADS);
		// cw as viewed from front, so can be seen as ccw from back
		gl.glTexCoord2f(0f, 2f);
		gl.glVertex3d(v17.getX(), v17.getY(), v17.getZ());
		gl.glTexCoord2f(3f, 2f);
		gl.glVertex3d(v7.getX(), v7.getY(), v7.getZ());
		gl.glTexCoord2f(3f, 0f);
		gl.glVertex3d(v65.getX(), v65.getY(), v65.getZ());
		gl.glTexCoord2f(0f, 0f);
		gl.glVertex3d(v16.getX(), v16.getY(), v16.getZ());
		gl.glEnd();
		brickTexture.bind(gl);
		gl.glBegin(GL2.GL_QUADS);
		// ccw as viewed from front
		gl.glTexCoord2f(0f, 2f);
		gl.glVertex3d(v16.getX(), v16.getY(), v16.getZ());
		gl.glTexCoord2f(3f, 2f);
		gl.glVertex3d(v65.getX(), v65.getY(), v65.getZ());
		gl.glTexCoord2f(3f, 0f);
		gl.glVertex3d(v7.getX(), v7.getY(), v7.getZ());
		gl.glTexCoord2f(0f, 0f);
		gl.glVertex3d(v17.getX(), v17.getY(), v17.getZ());
		gl.glEnd();
		
		brickTexture.bind(gl);
		gl.glBegin(GL2.GL_QUADS);
		// cw as viewed from front, so can be seen as ccw from back
		gl.glTexCoord2f(0f, 2f);
		gl.glVertex3d(v8.getX(), v8.getY(), v8.getZ());
		gl.glTexCoord2f(3f, 2f);
		gl.glVertex3d(v18.getX(), v18.getY(), v18.getZ());
		gl.glTexCoord2f(3f, 0f);
		gl.glVertex3d(v15.getX(), v15.getY(), v15.getZ());
		gl.glTexCoord2f(0f, 0f);
		gl.glVertex3d(v85.getX(), v85.getY(), v85.getZ());
		gl.glEnd();
		brickTexture.bind(gl);
		gl.glBegin(GL2.GL_QUADS);
		// ccw as viewed from front
		gl.glTexCoord2f(0f, 2f);
		gl.glVertex3d(v85.getX(), v85.getY(), v85.getZ());
		gl.glTexCoord2f(3f, 2f);
		gl.glVertex3d(v15.getX(), v15.getY(), v15.getZ());
		gl.glTexCoord2f(3f, 0f);
		gl.glVertex3d(v18.getX(), v18.getY(), v18.getZ());
		gl.glTexCoord2f(0f, 0f);
		gl.glVertex3d(v8.getX(), v8.getY(), v8.getZ());
		gl.glEnd();

	}

	private void makeRoof(GL2 gl) {
		// left side roof begin
		brickTexture.bind(gl);
		gl.glBegin(GL2.GL_QUADS);
		// cw
		gl.glTexCoord2f(0f, 2f);
		gl.glVertex3d(v10.getX(), v10.getY(), v10.getZ());
		gl.glTexCoord2f(3f, 2f);
		gl.glVertex3d(v6.getX(), v6.getY(), v6.getZ());
		gl.glTexCoord2f(3f, 0f);
		gl.glVertex3d(v2.getX(), v2.getY(), v2.getZ());
		gl.glTexCoord2f(0f, 0f);
		gl.glVertex3d(v9.getX(), v9.getY(), v9.getZ());
		gl.glEnd();
		brickTexture.bind(gl);
		gl.glBegin(GL2.GL_QUADS);
		// ccw
		gl.glTexCoord2f(0f, 2f);
		gl.glVertex3d(v9.getX(), v9.getY(), v9.getZ());
		gl.glTexCoord2f(3f, 2f);
		gl.glVertex3d(v2.getX(), v2.getY(), v2.getZ());
		gl.glTexCoord2f(3f, 0f);
		gl.glVertex3d(v6.getX(), v6.getY(), v6.getZ());
		gl.glTexCoord2f(0f, 0f);
		gl.glVertex3d(v10.getX(), v10.getY(), v10.getZ());
		gl.glEnd();
		// left side roof end

		// right side roof begin
		brickTexture.bind(gl);
		gl.glBegin(GL2.GL_QUADS);
		// ccw
		gl.glTexCoord2f(0f, 2f);
		gl.glVertex3d(v9.getX(), v9.getY(), v9.getZ());
		gl.glTexCoord2f(3f, 2f);
		gl.glVertex3d(v1.getX(), v1.getY(), v1.getZ());
		gl.glTexCoord2f(3f, 0f);
		gl.glVertex3d(v5.getX(), v5.getY(), v5.getZ());
		gl.glTexCoord2f(0f, 0f);
		gl.glVertex3d(v10.getX(), v10.getY(), v10.getZ());
		gl.glEnd();
		brickTexture.bind(gl);
		gl.glBegin(GL2.GL_QUADS);
		// cw
		gl.glTexCoord2f(0f, 2f);
		gl.glVertex3d(v10.getX(), v10.getY(), v10.getZ());
		gl.glTexCoord2f(3f, 2f);
		gl.glVertex3d(v5.getX(), v5.getY(), v5.getZ());
		gl.glTexCoord2f(3f, 0f);
		gl.glVertex3d(v1.getX(), v1.getY(), v1.getZ());
		gl.glTexCoord2f(0f, 0f);
		gl.glVertex3d(v9.getX(), v9.getY(), v9.getZ());
		gl.glEnd();
		// right side roof end

		// front side roof begin
		brickTexture.bind(gl);
		gl.glBegin(GL2.GL_TRIANGLES);
		// ccw
		gl.glTexCoord2f(0f, 0f);
		gl.glVertex3d(v2.getX(), v2.getY(), v2.getZ());
		gl.glTexCoord2f(.5f, 5f);
		gl.glVertex3d(v1.getX(), v1.getY(), v1.getZ());
		gl.glTexCoord2f(5f, 0f);
		gl.glVertex3d(v9.getX(), v9.getY(), v9.getZ());
		gl.glEnd();
		brickTexture.bind(gl);
		gl.glBegin(GL2.GL_TRIANGLES);
		// cw
		gl.glTexCoord2f(0f, 0f);
		gl.glVertex3d(v9.getX(), v9.getY(), v9.getZ());
		gl.glTexCoord2f(.5f, 5f);
		gl.glVertex3d(v1.getX(), v1.getY(), v1.getZ());
		gl.glTexCoord2f(5f, 0f);
		gl.glVertex3d(v2.getX(), v2.getY(), v2.getZ());
		gl.glEnd();
		// front side roof end

		// back side roof begin
		brickTexture.bind(gl);
		gl.glBegin(GL2.GL_TRIANGLES);
		// cw
		gl.glTexCoord2f(5f, 0f);
		gl.glVertex3d(v10.getX(), v10.getY(), v10.getZ());
		gl.glTexCoord2f(.5f, 5f);
		gl.glVertex3d(v5.getX(), v5.getY(), v5.getZ());
		gl.glTexCoord2f(0f, 0f);
		gl.glVertex3d(v6.getX(), v6.getY(), v6.getZ());
		gl.glEnd();
		brickTexture.bind(gl);
		gl.glBegin(GL2.GL_TRIANGLES);
		// ccw
		gl.glTexCoord2f(5f, 0f);
		gl.glVertex3d(v6.getX(), v6.getY(), v6.getZ());
		gl.glTexCoord2f(.5f, 5f);
		gl.glVertex3d(v5.getX(), v5.getY(), v5.getZ());
		gl.glTexCoord2f(0f, 0f);
		gl.glVertex3d(v10.getX(), v10.getY(), v10.getZ());
		gl.glEnd();
		// back side roof end

	}

	private void createLeftWall(GL2 gl) {
		// left side wall
		brickTexture.bind(gl);
		gl.glBegin(GL2.GL_QUADS);
		// cw
		gl.glTexCoord2f(0f, 2f);
		gl.glVertex3d(v7.getX(), v7.getY(), v7.getZ());
		gl.glTexCoord2f(3f, 2f);
		gl.glVertex3d(v3.getX(), v3.getY(), v3.getZ());
		gl.glTexCoord2f(3f, 0f);
		gl.glVertex3d(v2.getX(), v2.getY(), v2.getZ());
		gl.glTexCoord2f(0f, 0f);
		gl.glVertex3d(v6.getX(), v6.getY(), v6.getZ());
		gl.glEnd();
		brickTexture.bind(gl);
		gl.glBegin(GL2.GL_QUADS);
		// ccw
		gl.glTexCoord2f(0f, 2f);
		gl.glVertex3d(v6.getX(), v6.getY(), v6.getZ());
		gl.glTexCoord2f(3f, 2f);
		gl.glVertex3d(v2.getX(), v2.getY(), v2.getZ());
		gl.glTexCoord2f(3f, 0f);
		gl.glVertex3d(v3.getX(), v3.getY(), v3.getZ());
		gl.glTexCoord2f(0f, 0f);
		gl.glVertex3d(v7.getX(), v7.getY(), v7.getZ());
		gl.glEnd();
		// left wall end
	}

	private void createRightWall(GL2 gl) {
		// right side wall
		brickTexture.bind(gl);
		gl.glBegin(GL2.GL_QUADS);
		// ccw
		gl.glTexCoord2f(0f, 2f);
		gl.glVertex3d(v5.getX(), v5.getY(), v5.getZ());
		gl.glTexCoord2f(3f, 2f);
		gl.glVertex3d(v1.getX(), v1.getY(), v1.getZ());
		gl.glTexCoord2f(3f, 0f);
		gl.glVertex3d(v4.getX(), v4.getY(), v4.getZ());
		gl.glTexCoord2f(0f, 0f);
		gl.glVertex3d(v8.getX(), v8.getY(), v8.getZ());
		gl.glEnd();
		brickTexture.bind(gl);
		gl.glBegin(GL2.GL_QUADS);
		// cw
		gl.glTexCoord2f(0f, 2f);
		gl.glVertex3d(v8.getX(), v8.getY(), v8.getZ());
		gl.glTexCoord2f(3f, 2f);
		gl.glVertex3d(v4.getX(), v4.getY(), v4.getZ());
		gl.glTexCoord2f(3f, 0f);
		gl.glVertex3d(v1.getX(), v1.getY(), v1.getZ());
		gl.glTexCoord2f(0f, 0f);
		gl.glVertex3d(v5.getX(), v5.getY(), v5.getZ());
		gl.glEnd();
		// right wall end
	}

	private void createFloor(GL2 gl) {
		// floor begin
		floorTexture.bind(gl);
		gl.glBegin(GL2.GL_QUADS);
		// ccw
		gl.glTexCoord2f(0f, 2f);
		gl.glVertex3d(v8.getX(), v8.getY(), v8.getZ());
		gl.glTexCoord2f(3f, 2f);
		gl.glVertex3d(v7.getX(), v7.getY(), v7.getZ());
		gl.glTexCoord2f(3f, 0f);
		gl.glVertex3d(v3.getX(), v3.getY(), v3.getZ());
		gl.glTexCoord2f(0f, 0f);
		gl.glVertex3d(v4.getX(), v4.getY(), v4.getZ());
		gl.glEnd();
		brickTexture.bind(gl);
		gl.glBegin(GL2.GL_QUADS);
		// cw
		gl.glTexCoord2f(0f, 2f);
		gl.glVertex3d(v4.getX(), v4.getY(), v4.getZ());
		gl.glTexCoord2f(3f, 2f);
		gl.glVertex3d(v3.getX(), v3.getY(), v3.getZ());
		gl.glTexCoord2f(3f, 0f);
		gl.glVertex3d(v7.getX(), v7.getY(), v7.getZ());
		gl.glTexCoord2f(0f, 0f);
		gl.glVertex3d(v8.getX(), v8.getY(), v8.getZ());
		gl.glEnd();
		// floor end
	}
}
