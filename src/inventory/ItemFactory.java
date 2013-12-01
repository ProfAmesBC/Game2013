package inventory;

import game.PlayerAttributes;

import java.util.ArrayList;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;

import Usables.SpeedBox;

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

	public void update() {
		for (Item item : list) {
			item.draw(gl, glu);
			if (item.grabbed())
				list.remove(this);
		}
	}
}