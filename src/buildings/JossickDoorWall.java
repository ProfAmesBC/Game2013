package buildings;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;

public class JossickDoorWall  {
	private JossickWall top;
	private JossickWall right;
	private JossickWall left;

	public JossickDoorWall(JossickWall t, JossickWall r, JossickWall l) {
		top = t;
		right = r;
		left = l;
	}
	public void draw(GL2 gl, GLU glu) {
		top.draw(gl, glu);
		right.draw(gl, glu);
		left.draw(gl, glu);
	}
	public void drawr(GL2 gl, GLU glu) {
		top.drawr(gl, glu);
		right.drawr(gl, glu);
		left.drawr(gl, glu);
	}
}