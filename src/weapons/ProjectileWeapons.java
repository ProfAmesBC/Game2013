package weapons;
import game.PlayerMotion;
import game.PlayerMotionWatcher;
import game.PlayerStats;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;


public class ProjectileWeapons implements MouseListener, Weapon{
	private ArrayList<Projectile> bulletsList = new ArrayList<Projectile>();
	private float x, y, z, angle, y_angle;
	private int speed = 5;
	private PlayerStats stats;
	private int weapon = 0;
	private GLUquadric sphereQuadric;
	private GLU glu = new GLU();
	private SphereBullet ball;

	
	public ProjectileWeapons(PlayerStats s){
		PlayerMotion.registerPlayerWatcher(this);
		stats=s;
	}
	
	public ProjectileWeapons() {
		PlayerMotion.registerPlayerWatcher(this);
		stats = null; // This needs to be fixed some day TODO
	}
	
	public void update(GL2 gl, GLU glu){
		
        //GO THROUGH BULLETS LIST
		for(Iterator<Projectile> it = bulletsList.iterator(); it.hasNext();){
			Projectile b = it.next();
			b.draw(gl, glu); //DRAW BULLETS
			b.updatePosition(); //UPDATE POSITION OF BULLETS
			if(b.getLifeSpan() == 0){it.remove();} else {b.updateLife();} //CHECK IF BULLET DONE	
		}
	}
	
	public void shootBullet(){

		if(stats.noHonor())return;

		if (weapon == 0) {
		RainbowBall bullet = new RainbowBall(x, y, z, angle, y_angle,stats);//CREATE NEW BULLET AT CURRENT PLAYER POSITION
		bulletsList.add(bullet);
		}
		if (weapon == 1){
		SphereBullet ball = new SphereBullet(x, y, z, angle, 0.2, 0.3, 0.4, 0.5, 10, y_angle,stats); //creates bullets of different guns - ie. not rainbow ball
		bulletsList.add(ball); //ADD BULLET TO LIST OF BULLETS
		}
		if (weapon == 2) {
			SphereBullet ball = new SphereBullet(x, y, z, angle, 0.4, 0.2, 0.3, 0.2, 15, y_angle, stats);
			bulletsList.add(ball);
		}
		if (weapon == 3) {
			SphereBullet ball = new SphereBullet(x, y, z, angle, 0.1, 0.9, 0.2, 0.8, 6, y_angle, stats);
			bulletsList.add(ball);
		}
		WeaponSounds.projectileNoise();
		

	}
	
	@Override
	public void keyTyped(KeyEvent e) {}	// not used
	
	@Override
	public void keyPressed(KeyEvent e) {

		if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
			weapon += 1;
			if (weapon > 3) {
				weapon = 0;
			}
		}

		if(e.getKeyCode() == KeyEvent.VK_SPACE){


			shootBullet(); 	//SHOOT BULLET WHEN PRESSED 
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {}	// not used

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


	@Override
	public void draw(GL2 gl, GLU glu) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(GL2 gl, GLU glu) {
		// TODO Auto-generated method stub
		
	}

}
