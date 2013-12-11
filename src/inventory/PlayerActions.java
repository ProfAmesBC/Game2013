package inventory;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PlayerActions extends KeyAdapter {

	private PlayerAttributes p;
	private Bag b;

	public PlayerActions(PlayerAttributes p) {
		this.p = p;
		b = p.getBag();
	}

	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_1:
			// calls the DummyItem from the Bag
			b.useItem("Speed");
			
			break;
		case KeyEvent.VK_2:
			// calls the DummyItem from the Bag
			b.useItem("Jetpack");
			break;
		case KeyEvent.VK_3:
			// calls the DummyItem from the Bag
			b.useItem("Teleporter");
			break;

		}
		
	}

}
