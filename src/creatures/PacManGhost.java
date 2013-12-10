package creatures;

import game.Building;
import java.util.Random;
import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;
import com.jogamp.opengl.util.texture.Texture;
import game.PlayerMotionWatcher;
import game.PlayerStats;

public class PacManGhost implements Creature, PlayerMotionWatcher, ProjectileWatcher {
	
	private Texture parkGhost;
	private Texture parkGhostColor;
	private GLUquadric quadric;
	private float X = 0f;
	private float Y = 2.5f;
	private float Z = 0f;
	private float playerX;
	private float playerZ;
	private float bulletX;
	private float bulletY;
	private float playerAngle;
	private float T = 0;
	private int count = 0;
	private float directionAngle = 0;
	private boolean seesPlayer = false;
	private boolean shotByBullet = false;
	private boolean visible = true;
	private float detectionRadius = 5f;
	private Random random = new Random();
	private double k = random.nextDouble();
	
	public PacManGhost(GL2 gl, GLU glu) {
		parkGhost = Building.setupTexture(gl, "ParkGhost.jpg");
		parkGhostColor = Building.setupTexture(gl, "ParkGhostColor.jpg");
		quadric = glu.gluNewQuadric();
		glu.gluQuadricDrawStyle(quadric, GLU.GLU_FILL);		// GLU_POINT, GLU_LINE, GLU_FILL, GLU_SILHOUETTE
        glu.gluQuadricNormals  (quadric, GLU.GLU_NONE); 	// GLU_NONE, GLU_FLAT, or GLU_SMOOTH
        glu.gluQuadricTexture  (quadric, true);        		// false, or true to generate texture coordinates
	}

	@Override
	public void projectileMoved(double x, double z) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(GL2 gl, GLU glu) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void move() {
		
	}

	@Override
	public void playerMoved(float x, float y, float z, float angle, float y_angle, PlayerStats s) {
		// TODO Auto-generated method stub
		
	}

}
