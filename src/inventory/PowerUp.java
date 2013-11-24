package inventory;

import game.PlayerMotionWatcher;
import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;

public interface PowerUp extends PlayerMotionWatcher {

	public void draw(GL2 gl, GLU glu);
	public void use();
	public boolean grabbed();
	public String getType();

}