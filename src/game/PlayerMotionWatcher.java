package game;

public interface PlayerMotionWatcher {
	public void playerMoved(float x, float y, float z, float angle, float y_angle,PlayerStats s); // angle in degree
}
