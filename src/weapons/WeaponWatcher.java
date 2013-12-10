package weapons;
import game.PlayerStats;

public interface WeaponWatcher{
	public void checkShot(Projectile p,PlayerStats s);
	public float size();
}
