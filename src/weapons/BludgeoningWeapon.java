package weapons;

import game.PlayerMotion;
import game.PlayerMotionWatcher;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;

// make a class that holds list of all projectiles and iter thru to update - called once from main game

public class BludgeoningWeapon implements KeyListener, PlayerMotionWatcher{
	
	private float x, y, z;
	private GLUquadric quadric;
	private int frames, lengthOfHit; // the counter to determine how long the weapon is being swung for
	private float reach = 5; 
	private GL2 gl;
	private GLU glu;
	private boolean hit;
	
	public BludgeoningWeapon(){
//		this.gl = gl;
//		this.glu = glu;
		hit = false;
				
		PlayerMotion.registerPlayerWatcher(this);
		
//		quadric = glu.gluNewQuadric();
//        glu.gluQuadricDrawStyle(quadric, GLU.GLU_FILL); // GLU_POINT, GLU_LINE, GLU_FILL, GLU_SILHOUETTE
//        glu.gluQuadricNormals  (quadric, GLU.GLU_NONE); // GLU_NONE, GLU_FLAT, or GLU_SMOOTH
//        glu.gluQuadricTexture  (quadric, false);
	}
	
	// fix this with keylistener stuff...
	public void init(GL2 gl, GLU glu){
		this.gl = gl;
		this.glu = glu;
		lengthOfHit = 60;	// 60 frames
		
		quadric = glu.gluNewQuadric();
        glu.gluQuadricDrawStyle(quadric, GLU.GLU_FILL); // GLU_POINT, GLU_LINE, GLU_FILL, GLU_SILHOUETTE
        glu.gluQuadricNormals  (quadric, GLU.GLU_NONE); // GLU_NONE, GLU_FLAT, or GLU_SMOOTH
        glu.gluQuadricTexture  (quadric, false);
	}
	
	public void update(GL2 gl, GLU glu){
		if (hit){
			
			if (frames < lengthOfHit/2){
				gl.glColor3f(1f,0f,.25f);
				gl.glPushMatrix();
					gl.glTranslatef(x+10, y, z);	// draw at person
					glu.gluSphere(quadric, 1, 10, 10);
				gl.glPopMatrix();
				frames++;
			}
			else { hit = false; }
		}
	}
	
	@Override
	public void playerMoved(float x, float y, float z, float angle) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	@Override
	public void keyTyped(KeyEvent e) {}

	// this seems like a convoluted way to do things
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_O){	// add functionality later to toggle between weapons or to have a "current weapon"
			System.out.println("!!!!");
			hit = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {}
}
