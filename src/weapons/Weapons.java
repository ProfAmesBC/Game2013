package weapons;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Weapons implements KeyListener{
	
	private Bullet[] bulletsList;
	
	public void shootBullet(){
		
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_SPACE){
			shootBullet();
		}
	}
	@Override
	public void keyPressed(KeyEvent e) {		
	}
	@Override
	public void keyReleased(KeyEvent e) {		
	}

}
