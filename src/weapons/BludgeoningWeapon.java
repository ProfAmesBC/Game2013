package weapons;

import game.PlayerMotion;
import game.PlayerMotionWatcher;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Iterator;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;

// make a class that holds list of all projectiles and iter thru to update - called once from main game

public class BludgeoningWeapon implements KeyListener, PlayerMotionWatcher{
	
	private float x, y, z;
	private GLUquadric quadric;
	
	public BludgeoningWeapon(GLU glu){
		PlayerMotion.registerPlayerWatcher(this);
		
		quadric = glu.gluNewQuadric();
        glu.gluQuadricDrawStyle(quadric, GLU.GLU_FILL); // GLU_POINT, GLU_LINE, GLU_FILL, GLU_SILHOUETTE
        glu.gluQuadricNormals  (quadric, GLU.GLU_NONE); // GLU_NONE, GLU_FLAT, or GLU_SMOOTH
        glu.gluQuadricTexture  (quadric, false);
	}
	
	public void update(GL2 gl, GLU glu){
		
		gl.glPushMatrix();
        	gl.glRotatef(-90f, 1f, 0f, 0f); // stand upright (Y)
        	gl.glTranslatef()
        	glu.gluCylinder(quadric, 1., .5, 5., 10, 1);
//        glu.gluDisk(quadric, 1.5, 2., 10, 5); // also to be flipped
        gl.glPopMatrix();
		
//        //GO THROUGH BULLETS LIST
//		for(Iterator<RainbowBall> it = bulletsList.iterator(); it.hasNext();){
//			RainbowBall b = it.next();
//			b.draw(gl, glu); //DRAW BULLETS
//			b.updatePosition(); //UPDATE POSITION OF BULLETS
//			if(b.getLifeSpan() == 0){it.remove();} else {b.updateLife();} //CHECK IF BULLET DONE	
//		}
	}
	
	public void hit(){
		
	}

	@Override
	public void playerMoved(float x, float y, float z, float angle) {
		
	}

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_SPACE){
//			shootBullet();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {}
}
