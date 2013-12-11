package inventory;

import items.BlindItem;
import items.Cripple;
import items.Jetpack;
import items.SpeedBox;
import items.Teleporter;

import java.util.ArrayList;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;
public class ItemFactory {
	private GL2 gl;
	private GLU glu;
	private PlayerAttributes p;
	private ArrayList<Item> list = new ArrayList<Item>();

	public ItemFactory(GL2 gl, GLU glu, PlayerAttributes p) {
		this.gl = gl;
		this.glu = glu;
		this.p = p;
	}

	public void addSpeedItem(int x, int y, int z) {
		Item boost = new SpeedBox(gl, glu, x, y, z, p.getBag(), p);
		list.add(boost);
	}
	public void addBlindItem(int x, int y, int z) {
		Item flash = new BlindItem(gl, glu, x, y, z, p.getBag(), p);
		list.add(flash);
	}
	public void addJetpackItem(int x, int y, int z) {
		Item fly = new Jetpack(gl, glu, x, y, z, p.getBag(), p);
		list.add(fly);
	}
	public void addCrippleItem(int x, int y, int z) {
		Item oldMan = new Cripple(gl, glu, x, y, z, p.getBag(), p);
		list.add(oldMan);
	}
	public void addTeleportItem(int x, int y, int z) {
		Item blink = new Teleporter(gl, glu, x, y, z, p.getBag(), p);
		list.add(blink);
	}

	public void update() {
		for (Item item : list) {
			item.draw(gl, glu);
			if (item.grabbed())
				list.remove(this); 
		} 
	} 

	public void testCreate() {
		addSpeedItem(100, 0, 100);	
		addTeleportItem(50, 0, 100);	
		addTeleportItem(50, 0, 200);	
		addBlindItem(100,0,200);		
		addJetpackItem(100,0,500);
		addJetpackItem(100,0,70);
		addJetpackItem(100,0,300);
		addCrippleItem(100,0,150);
		addTeleportItem(100, 0, 200);	
		addBlindItem(150,0,200);
		addSpeedItem(150, 0, 100);
		addCrippleItem(150,0,400);
		addSpeedItem(150, 0, 550);
		addJetpackItem(200,0,100);
		addTeleportItem(200, 0, 450);	
		addJetpackItem(200,0,200);
		addSpeedItem(200, 0, 400);
		addJetpackItem(200,0,500);
		addCrippleItem(300,0,100);
		addCrippleItem(300,0,300);
		addTeleportItem(300, 0, 200);	

		addSpeedItem(400, 0, 100);		
		addTeleportItem(400, 0, 150);	
		addBlindItem(400,0,200);		
		addJetpackItem(400,0,500);
		addJetpackItem(400,0,300);
		addCrippleItem(400,0,150);
		addBlindItem(450,0,200);
		addTeleportItem(450, 0, 300);	
		addSpeedItem(450, 0, 100);
		addCrippleItem(450,0,400);
		addSpeedItem(450, 0, 550);
		addJetpackItem(500,0,100);
		addTeleportItem(500, 0, 450);	
		addJetpackItem(500,0,200);
		addSpeedItem(500, 0, 400);
		addJetpackItem(500,0,500);
		addCrippleItem(550,0,100);
		addCrippleItem(600,0,100);
		addCrippleItem(600,0,300);
	}
}