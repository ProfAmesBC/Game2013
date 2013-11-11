package game;

// For demonstration only, should not go in the final game


public class PlayerLogger implements PlayerMotionWatcher {
	
	public PlayerLogger() {
		PlayerMotion.registerPlayerWatcher(this);
	}

	@Override
	public void playerMoved(float x, float y, float z) {
		System.out.println("Player is now at location " + x + "," + y + "," + z);
	}
}
