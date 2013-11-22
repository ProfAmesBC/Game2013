package weapons;


import game.PlayerMotion;
import game.PlayerMotionWatcher;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;

public class Weapons implements KeyListener, PlayerMotionWatcher{
	
	private ArrayList<Bullet> bulletsList = new ArrayList<Bullet>();
	private GLUquadric quadric;
	private float x, y, z, angle;
	
	public Weapons(){
		PlayerMotion.registerPlayerWatcher(this);
	}
	
	public void update(GL2 gl, GLU glu){
		quadric = glu.gluNewQuadric();
        glu.gluQuadricDrawStyle(quadric, GLU.GLU_FILL); // GLU_POINT, GLU_LINE, GLU_FILL, GLU_SILHOUETTE
        glu.gluQuadricNormals  (quadric, GLU.GLU_SMOOTH); // GLU_NONE, GLU_FLAT, or GLU_SMOOTH
        glu.gluQuadricTexture  (quadric, true);        // false, or true to generate texture coordinates
		
        //GO THROUGH BULLETS LIST, DRAW BULLETS
		for(Bullet b: bulletsList){
			gl.glPushMatrix();
				gl.glTranslatef(b.getX(), b.getY(), b.getZ());
				glu.gluSphere(quadric, 0.5, 10, 10);
			gl.glPopMatrix();
			
			//UPDATE POSITION OF BULLETS
			b.setX((float) (b.getX() + b.getSpeed()*Math.cos(Math.toRadians(angle))));
			b.setZ((float) (b.getZ() - b.getSpeed()*Math.sin(Math.toRadians(angle))));
		}
        
        
        
	}
	
	public void shootBullet(){
		//CREATE NEW BULLET AT CURRENT PLAYER POSITION
		Bullet bullet = new Bullet(x, y, z, angle);
		//ADD BULLET TO LIST OF BULLETS
		bulletsList.add(bullet);
	}
	
	@Override
	public void keyTyped(KeyEvent e) {}
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_SPACE){
			shootBullet();
			System.out.println("HI");
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {}

	@Override
	public void playerMoved(float x, float y, float z, float angle) {
		//GET CURRENT POSITION OF PLAYER TO USE TO MAKE BULLET
		this.x = x;
		this.y = y;
		this.z = z;
		this.angle = angle;
	}

}
