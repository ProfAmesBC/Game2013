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
	
	private ArrayList<RainbowBall> bulletsList = new ArrayList<RainbowBall>();
	private float x, y, z, angle;
	
	public ProjectileWeapons(){
		PlayerMotion.registerPlayerWatcher(this);
	}
	
	public void update(GL2 gl, GLU glu){
		
        //GO THROUGH BULLETS LIST
		for(Iterator<RainbowBall> it = bulletsList.iterator(); it.hasNext();){
			RainbowBall b = it.next();
			b.draw(gl, glu); //DRAW BULLETS
			b.updatePosition(); //UPDATE POSITION OF BULLETS
			if(b.getLifeSpan() == 0){it.remove();} else {b.updateLife();} //CHECK IF BULLET DONE	
		}
	}
	
	public void shootBullet(){
		RainbowBall bullet = new RainbowBall(x, y, z, angle); //CREATE NEW BULLET AT CURRENT PLAYER POSITION
		
		//if(another gun was picked up)
		//DrawBullet generalBullet = new DrawBullet(x,y,z,angle, red, green, blue, size, speed);
		
		bulletsList.add(bullet); //ADD BULLET TO LIST OF BULLETS
	}
	
	@Override
	public void keyTyped(KeyEvent e) {}
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_SPACE){
			shootBullet();} 	//SHOOT BULLET WHEN PRESSED
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
