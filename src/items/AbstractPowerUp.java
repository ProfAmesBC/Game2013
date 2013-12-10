package items;

import inventory.Item;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;

public abstract class AbstractPowerUp implements Item {

	@Override
	public abstract void playerMoved(float x, float y, float z, float angle, float y_angle);
	

	@Override
	public abstract void draw(GL2 gl, GLU glu);

	@Override
	public abstract void use();

	@Override
	public abstract boolean grabbed();
	@Override
	public abstract String getType();
}