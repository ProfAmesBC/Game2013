package weapons;

import java.util.LinkedList;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;

public class PopulateWeapons {

	private LinkedList<DisplayedWeapon> weapons;
	
	public PopulateWeapons(){
		weapons = new LinkedList<DisplayedWeapon>();
	}
	
	public void init(GL2 gl, GLU glu){
		Weapon w = new PipeWeapon();
		w.init(gl, glu);

//		DisplayedWeapon dw = new DisplayedWeapon(w, Math.random()*600, Math.random()*600);
//		w.init(gl, glu);
		for (int i=0; i<100; i++)
			weapons.add(new DisplayedWeapon(w, (float) Math.random()*600, (float) Math.random()*600));
//		System.out.println(weapons.size());
	}
	
	public void draw(GL2 gl, GLU glu){
		for (DisplayedWeapon dw: weapons)
			dw.draw(gl, glu);
	}
}
