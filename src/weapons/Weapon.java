package weapons;

import game.PlayerMotionWatcher;
import java.awt.event.KeyListener;
import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;

public interface Weapon extends KeyListener, PlayerMotionWatcher{

	public void update(GL2 gl, GLU glu);

	public void draw();

	public void init(GL2 gl, GLU glu);

}
