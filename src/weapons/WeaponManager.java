package weapons;

import game.PlayerMotion;
import game.PlayerMotionWatcher;
import game.PlayerStats;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;


// populates game with weapons and tracks the current bludgeoining weapon the player is holding
public class WeaponManager implements KeyListener, PlayerMotionWatcher{

	// WeaponManager must also implements PlayerMotionWatcher so it can tell which weapon to pick up
	
	private LinkedList<DisplayedWeapon> weapons;
	private BludgeoningWeapon w;
	private float x, z;
	
	public WeaponManager(){
		weapons = new LinkedList<DisplayedWeapon>();
		PlayerMotion.registerPlayerWatcher(this);
	}
	
	public BludgeoningWeapon getWeapon(){
		return w;
	}
	
	public void setWeapon(BludgeoningWeapon w){
		this.w = w;
	}
	
	public void init(GL2 gl, GLU glu){
		BludgeoningWeapon pw = new PipeWeapon();
		BludgeoningWeapon ow = new OarWeapon();
		
		pw.init(gl, glu);
		ow.init(gl, glu);
		
		w = pw;

		for (int i=0; i<20; i++){
			weapons.add(new DisplayedWeapon(pw, (float) Math.random()*600, (float) Math.random()*600));
			weapons.add(new DisplayedWeapon(ow, (float) Math.random()*600, (float) Math.random()*600));
		}
	}
	
	public void draw(GL2 gl, GLU glu){
		for (DisplayedWeapon dw: weapons)
			dw.draw(gl, glu);
	}
	
	public BludgeoningWeapon scanWeapons(){
		for (DisplayedWeapon dw: weapons){
			if (Math.abs(dw.getX() - x) < 3 && Math.abs(dw.getZ() - z) < 3)	// if close enough
				return (BludgeoningWeapon) dw.getWeapon();
		}
		return null;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_P){	// add functionality later to toggle between weapons or to have a "current weapon"
			try{ setWeapon(scanWeapons());
//			System.out.println("weapon changed");
			}
			catch (NullPointerException exception){}
			}
		}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void playerMoved(float x, float y, float z, float angle,
			float y_angle, PlayerStats s) {
		this.x = x;
		this.z = z;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
