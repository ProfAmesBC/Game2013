package creatures;
import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;

public interface Creature {
	
	void draw(GL2 gl,GLU glu);
	void move();
}