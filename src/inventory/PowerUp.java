package inventory;
import javax.media.opengl.GL2;

import javax.media.opengl.glu.GLU;


public interface PowerUp {
public boolean checkPlayerLocation();
public void draw(GL2 gl, GLU glu,double T);
public boolean addToInventory();
public void use();
}
