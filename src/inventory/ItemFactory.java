package inventory;

import items.BlindItem;
import items.SpeedBox;

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

	public void update() {
		for (Item item : list) {
			item.draw(gl, glu);
			if (item.grabbed())
				list.remove(this);
		}
	}

	public void testCreate() {
		addSpeedItem(70, 0, 70);
		addSpeedItem(100, 0, 100);
		addSpeedItem(200, 0, 200);
		addSpeedItem(300, 0, 300);
		addSpeedItem(350, 0, 350);
		addSpeedItem(400, 0, 400);
		addBlindItem(30,0,30);
		addBlindItem(80,0,80);
	}
}