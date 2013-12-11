package weapons;
import game.PlayerMotion;
import game.PlayerMotionWatcher;
import game.PlayerStats;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;

public class ProjectileWeapons implements KeyListener, PlayerMotionWatcher, MouseListener {
	private ArrayList<RainbowBall> bulletsList = new ArrayList<RainbowBall>();
	private float x, y, z, angle, y_angle;
	private PlayerStats stats;
	
	public ProjectileWeapons(PlayerStats s){
		PlayerMotion.registerPlayerWatcher(this);
		stats=s;
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
		if(stats.noHonor())return;
		RainbowBall bullet = new RainbowBall(x, y, z, angle, y_angle,stats); //CREATE NEW BULLET AT CURRENT PLAYER POSITION
		bulletsList.add(bullet); //ADD BULLET TO LIST OF BULLETS
	}
	
	@Override
	public void keyTyped(KeyEvent e) {}
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_SPACE){shootBullet();}
		//SHOOT BULLET WHEN PRESSED
		//using space --->jump+fire
	}
	@Override
	public void keyReleased(KeyEvent e) {}

	@Override
	public void playerMoved(float x, float y, float z, float angle, float y_angle,PlayerStats s) {
		//GET CURRENT POSITION OF PLAYER TO USE TO MAKE BULLET
		this.x = x;
		this.y = y;
		this.z = z;
		this.angle = angle;
        this.y_angle = y_angle;
	}

    @Override
    public void mouseClicked(MouseEvent e) {
        shootBullet();
    }

    @Override
    public void mousePressed(MouseEvent e) { }

    @Override
    public void mouseReleased(MouseEvent e) { }

    @Override
    public void mouseEntered(MouseEvent e) { }

    @Override
    public void mouseExited(MouseEvent e) { }
}
