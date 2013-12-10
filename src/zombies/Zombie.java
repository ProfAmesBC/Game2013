package zombies;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;

public abstract interface Zombie {
	
	void draw(GL2 gl,GLU glu);
	void move();
	
}