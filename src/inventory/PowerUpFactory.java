
package inventory;
import game.PlayerAttributes;

import java.util.ArrayList;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;


public class PowerUpFactory {
	private GL2 gl; 
	private GLU glu;	
	private PlayerAttributes p;
	private ArrayList<PowerUp> list = new ArrayList<PowerUp>();
    public PowerUpFactory(GL2 gl, GLU glu,PlayerAttributes p){
		this.gl = gl;
		this.glu = glu;
		this.p = p;
	}
	public void addSpeedPowerUp(int x, int y, int z){
		PowerUp boost = new SpeedBox(gl,glu,x,y,z,p.getBag(),p);	
		list.add(boost);
	}
	
	public void update(){			
		for(PowerUp item : list){						
			item.draw(gl, glu);			
			if(item.grabbed()) list.remove(this);
		}
	}
}
