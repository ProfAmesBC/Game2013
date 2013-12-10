package weapons;

import game.PlayerMotionWatcher;
import java.awt.event.KeyListener;
import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;

public interface Weapon extends KeyListener, PlayerMotionWatcher{

	public void update(GL2 gl, GLU glu); // per frame
	public void draw(GL2 gl, GLU glu);	// for drawing on the ground to pick up
	public void init(GL2 gl, GLU glu);

}
