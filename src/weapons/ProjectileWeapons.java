package weapons;
import game.PlayerMotion;
import game.PlayerMotionWatcher;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;

public class ProjectileWeapons implements Weapon{
	
	private ArrayList<RainbowBall> bulletsList = new ArrayList<RainbowBall>();
	private float x, y, z, angle;
	private float red, green, blue, size, speed;
	
	public ProjectileWeapons(){
		PlayerMotion.registerPlayerWatcher(this);
	}
	
	//each weapon will shoot a bullet of different speed, color, size if desired
	public void setSpeed(float speed) {this.speed = speed;}
	public void setRed(float red) {this.red = red;}
	public void setGreen(float green) {this.green = green;}
	public void setBlue(float blue) {this.blue = blue;}
	public void setSize(float size) {this.size = size;}
	
	
	
	public void update(GL2 gl, GLU glu){
		
        //GO THROUGH BULLETS LIST
		for(Iterator<RainbowBall> it = bulletsList.iterator(); it.hasNext();){
			RainbowBall b = it.next();
			b.draw(gl, glu); //DRAW BULLETS
			b.updatePosition(); //UPDATE POSITION OF BULLETS
			if(b.getLifeSpan() == 0){it.remove();} else {b.updateLife();} //CHECK IF BULLET DONE	
		}
	}
	
	
	//EXAMPLE OF WHAT WOULD HAPPEN WHEN A NEW WEAPON IS CHOSEN
	//THIS FUNCTION IS CALLED, ITS PREDETERMINED VALUES ARE APPLIED
	//WE CAN CHANGE THESE VALUES, THEY'RE BASICALLY RANDOM
	public void rayGun() {
		setRed(5);
		setGreen(4);
		setBlue(9);
		setSize(2);
		setSpeed(5);
	}
	
	
	public void shootBullet(){
		RainbowBall bullet = new RainbowBall(x, y, z, angle); //CREATE NEW BULLET AT CURRENT PLAYER POSITION
		
		
		//FOR EXAMPLE
		//if(raygun picked up) {
		//	rayGun();
		// }
		//DrawBullet bullet = new DrawBullet(x,y,z,angle, getRed(), getGreen(), getBlue(), getSize(), getSpeed());
		
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

	@Override
	public void drawStationary(GL2 gl, GLU glu) {
		// TODO Auto-generated method stub
		
	}

}
