package weapons;
import game.PlayerMotion;
import game.PlayerMotionWatcher;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;

public class ProjectileWeapons implements KeyListener, PlayerMotionWatcher{
	
	private ArrayList<FireBall> bulletsList = new ArrayList<FireBall>();
	private float x, y, z, angle;
	
	public ProjectileWeapons(){
		PlayerMotion.registerPlayerWatcher(this);
	}
	
	public void update(GL2 gl, GLU glu){
		
        //GO THROUGH BULLETS LIST
		for(Iterator<FireBall> it = bulletsList.iterator(); it.hasNext();){
			FireBall b = it.next();
			b.draw(gl, glu); //DRAW BULLETS
			b.updatePosition(); //UPDATE POSITION OF BULLETS
			if(b.getLifeSpan() == 0){it.remove();} else {b.updateLife();} //CHECK IF BULLET DONE	
		}
	}
	
	public void shootBullet(){
		FireBall bullet = new FireBall(x, y, z, angle); //CREATE NEW BULLET AT CURRENT PLAYER POSITION
		bulletsList.add(bullet); //ADD BULLET TO LIST OF BULLETS
		WeaponSounds.weaponNoise();
	}
	
	@Override
	public void keyTyped(KeyEvent e) {}
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_SPACE){shootBullet();} 	//SHOOT BULLET WHEN PRESSED
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
