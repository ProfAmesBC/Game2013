package inventory;
import java.util.ArrayList;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;


public class PowerUpFactory {
	GL2 gl; GLU glu;
	ArrayList<PowerUp> list = new ArrayList<PowerUp>();
	public PowerUpFactory(GL2 gl, GLU glu){
		this.gl = gl;
		this.glu = glu;
	}
	public void addSpeedPowerUp(float a, float c, int x, int y, int z){
		PowerUp boost = new SpeedBox(gl,glu,a,c,x,y,z);	
		list.add(boost);
	}
	public ArrayList<PowerUp> getList(){
		return list;
	}
	public void update(GL2 gl2, GLU glu2){
		for(PowerUp item : list){
			item.draw(gl2, glu2, 0);
		}
	}
}
