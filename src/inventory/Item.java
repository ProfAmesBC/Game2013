// Items differ from Power-Ups because
// they are added to the inventory
// rather than being used immediately

package inventory;

import game.PlayerMotionWatcher;
import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;

public interface Item extends PlayerMotionWatcher {

	public void draw(GL2 gl, GLU glu);
	
	public void draw(GL2 gl, GLU glu, float x, float y, float z);

	public void use();

	public boolean grabbed();

	public String getType();

}