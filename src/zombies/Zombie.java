package zombies;

import javax.media.opengl.GL;
import javax.media.opengl.glu.GLU;

public abstract interface Zombie {
	
	void draw(GL gl,GLU glu);
	void move();
	
}