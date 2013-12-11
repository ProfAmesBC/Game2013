package weapons;

import game.PlayerMotion;
import game.PlayerStats;

import java.awt.event.KeyEvent;
import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;


// this class no longer utilizes the keylistener but other classes are using the Weapon interface so I can't change,
// and other code relies on BludgeoningWeapons implementing Weapon

public abstract class BludgeoningWeapon implements Weapon{
	
	private float x, y, z, angle;	// where player is
	private float weaponX, weaponZ;	// position of weapon
	private int frames, lengthOfHit; // the counter to determine how long the weapon is being swung for
	private float dist = 0;
	public boolean hit;
	
	public BludgeoningWeapon(){
		hit = false;
		lengthOfHit = 25;	// duration of hit in frames
		PlayerMotion.registerPlayerWatcher(this);
	}
	
	public abstract void draw(GL2 gl, GLU glu);
	
	public void update(GL2 gl, GLU glu){

		if (hit){
			weaponX =  (float) (2*Math.cos(Math.toRadians(angle)));
			weaponZ = -(float) (2*Math.sin(Math.toRadians(angle)));
			
			if (frames < lengthOfHit/2){
				
				gl.glPushMatrix();
					gl.glTranslatef(x+weaponX * dist/5, y, z+ weaponZ * dist/5);	// draw at person
					draw(gl, glu);
				gl.glPopMatrix();

				dist++;
				frames++;
		}
			else if (frames >= lengthOfHit/2 && frames < lengthOfHit){
				gl.glPushMatrix();
					gl.glTranslatef(x+weaponX * dist/5, y, z+ weaponZ * dist/5);	// draw at person
					draw(gl, glu);
				gl.glPopMatrix();
				
				dist --;
				frames++;
			}
			else { 
				System.out.println("DONE HITTING");
				weaponX = weaponZ = 0;
				frames = 0;
				dist = 0;
				
				hit = false;
				return;
				}
		}
	}
	
	@Override
	public void playerMoved(float x, float y, float z, float angle, float y_angle, PlayerStats s) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.angle = angle;
	}

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {}

	@Override
	public void keyReleased(KeyEvent e) {}
}
