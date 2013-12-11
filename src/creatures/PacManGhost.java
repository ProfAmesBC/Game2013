
package creatures;

import game.Building;

import java.util.Random;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;

import weapons.Projectile;

import com.jogamp.opengl.util.texture.Texture;

import game.PlayerMotion;
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
	private float detectionRadius = 25f;
	private Random random = new Random();
	private double k = random.nextDouble();
	
	public PacManGhost(float x, float z, GL2 gl, GLU glu) {
		X = x;
		Z = z;
		parkGhost = Building.setupTexture(gl, "ParkGhost.jpg");
		parkGhostColor = Building.setupTexture(gl, "ParkGhostColor.jpg");
		quadric = glu.gluNewQuadric();
		glu.gluQuadricDrawStyle(quadric, GLU.GLU_FILL);		// GLU_POINT, GLU_LINE, GLU_FILL, GLU_SILHOUETTE
        glu.gluQuadricNormals  (quadric, GLU.GLU_NONE); 	// GLU_NONE, GLU_FLAT, or GLU_SMOOTH
        glu.gluQuadricTexture  (quadric, true);        		// false, or true to generate texture coordinates
        PlayerMotion.registerPlayerWatcher(this);
        Projectile.registerProjectileWatcher(this);
	}
	
	public void drawTail(GL2 gl, GLU glu, float x, float y, float z) {
		gl.glPushMatrix();
			gl.glTranslatef(x, y, z);
			float angle = (float) (10*Math.cos(Math.toRadians(T*360)));
			gl.glRotatef(angle, 0, 0, 1);
			gl.glRotatef(-90f, 1f, 0f, 0f); // stand upright (Y)
			gl.glTranslatef(0, 0, -0.75f);
			glu.gluCylinder(quadric, 0, 0.3, 0.75, 20, 20);
		gl.glPopMatrix();
	}
	
	public void drawTail2(GL2 gl, GLU glu, float x, float y, float z) {
		gl.glPushMatrix();
			gl.glTranslatef(x, y, z);
			float angle = (float) (10*Math.sin(Math.toRadians(T*360-90))); 
			gl.glRotatef(angle, 0, 0, 1);
			gl.glRotatef(-90f, 1f, 0f, 0f); // stand upright (Y)
			gl.glTranslatef(0, 0, -0.75f);
			glu.gluCylinder(quadric, 0, 0.3, 0.75, 20, 20);
		gl.glPopMatrix();
	}
	
	public void drawOuterCircle(GL2 gl, GLU glu, float x, float y, float z) {
		gl.glPushMatrix();
			gl.glTranslatef(x, y, z);
			gl.glRotatef(directionAngle, 0f, 1f, 0f);
			drawTail(gl, glu, 0.7f, 1f, 0);
			drawTail(gl, glu, -0.7f, 1f, 0);
			drawTail(gl,glu, 0, 1f, 0.7f);
			drawTail(gl,glu, 0, 1f, -0.7f);
			drawTail(gl,glu, 0.494f, 1f, 0.494f);
			drawTail(gl,glu, -0.494f, 1f, -0.494f);
			drawTail(gl,glu, 0.494f, 1f, -0.494f);
			drawTail(gl,glu, -0.494f, 1f, 0.494f);
		gl.glPopMatrix();
	}
	
	public void drawInnerCircle(GL2 gl, GLU glu, float x, float y, float z) {
		gl.glPushMatrix();
			gl.glTranslatef(x, y, z);
			gl.glRotatef(directionAngle, 0f, 1f, 0f);
			drawTail2(gl, glu, 0.4f, 1f, 0);
			drawTail2(gl, glu, -0.4f, 1f, 0);
			drawTail2(gl,glu, 0, 1f, 0.4f);
			drawTail2(gl,glu, 0, 1f, -0.4f);
			drawTail2(gl,glu, 0.282f, 1f, 0.282f);
			drawTail2(gl,glu, -0.282f, 1f, -0.282f);
			drawTail2(gl,glu, 0.282f, 1f, -0.282f);
			drawTail2(gl,glu, -0.282f, 1f, 0.282f);
		gl.glPopMatrix();
	}
	
	public void drawAllTails (GL2 gl, GLU glu, float x, float y, float z) {
		gl.glEnable(GL2.GL_TEXTURE_2D);
		parkGhostColor.bind(gl);;
		gl.glPushMatrix();
			drawOuterCircle(gl,glu, x, y, z);
			drawInnerCircle(gl,glu, x, y, z);
		gl.glPopMatrix();
		gl.glDisable(GL2.GL_TEXTURE_2D);
	}
	
	public void drawBody(GL2 gl, GLU glu, float x, float y, float z) {
		gl.glEnable(GL2.GL_TEXTURE_2D);
		parkGhostColor.bind(gl);
		gl.glPushMatrix();
			gl.glTranslatef(x, y + 2.25f, z);
			glu.gluSphere(quadric, 1, 40, 40);
		gl.glPopMatrix();
		
        parkGhost.bind(gl);
		gl.glPushMatrix();
			gl.glTranslatef(x, y + 1f, z);
			gl.glRotatef(directionAngle, 0f, 1f, 0f);
			gl.glRotatef(-90f, 1f, 0f, 0f); // stand upright (Y)
			glu.gluCylinder(quadric, 1, 1, 1.25, 40, 40);
		gl.glPopMatrix();
		gl.glDisable(GL2.GL_TEXTURE_2D);
	}
	
	public void drawGhost(GL2 gl, GLU glu, float x, float y, float z) {
		if (visible) {
			drawAllTails(gl,glu, x, y, z);
			drawBody(gl, glu, x, y, z);
		}
	}
	
	public void checkT() {
		if (T > 300) {
			T = 0f;
		}
	}
	
	public void draw(GL2 gl, GLU glu) {
		gl.glPushMatrix();
		drawGhost(gl, glu, X, Y, Z);
		move();
		gl.glPopMatrix();
	}
	
	public void drawStillMotion() {
		T = T + 0.99f;
		checkT();
		hoverHeight();
	}
	
	public void hoverHeight() {
		if (count < 50) {
			Y = Y + 0.015f;
			count = count + 1;
		} else if (count < 100) {
			Y = Y - 0.015f;
			count = count + 1;
		} if (count == 100) {
			count = 0;
			k = random.nextDouble();
		}
	}
	
	public void move() {
		if (seesPlayer && !shotByBullet) {
			moveTowardsPlayer();
		} else if (shotByBullet) {
			animateDeath();
		}
		drawStillMotion();
		moveIdle();
	}
	
	public void playerMoved(float x, float y, float z, float angle, float yAngle,PlayerStats s) {
		playerX = x;
		playerZ = z;
		playerAngle = angle;
		double distance = Math.sqrt(Math.pow(X-x,2) + Math.pow(Z-z,2));
		if(distance <= detectionRadius){
			seesPlayer = true;
		}
		else{
			seesPlayer = false;
		}
	}
	
	public void projectileMoved(double x, double z) {
		if ( x > X - 2 && x < X + 2) {
			if ( z > Z - 2 && z < Z + 2) {
				shotByBullet = true;
			}
		}
		
	}
	
	public void moveTowardsPlayer() {	
		directionAngle = playerAngle - 180;
		double xV = playerX-X;
    	double zV = playerZ-Z;
    	double dotProduct = xV * 0.2 + zV * 0.2;
    	double lengthV1 = Math.sqrt((xV*xV)+(zV*zV));
    	lengthV1 = lengthV1 * lengthV1;
    	double constant = dotProduct / lengthV1;
    	double dx = constant * xV*1.5;
    	double dz = constant * zV*1.5;
    	dx = Math.abs(dx);
    	dz = Math.abs(dz);
    	if(playerZ<Z){ Z-=dz; }
    	else{ Z+=dz; }
    	if(playerX<X){X-=dx;}
    	else{	X+=dx;}
	}
	
	public void animateDeath() {
		if (Y <= 0) {
			visible = false;
		} else {
			Y = Y - 0.4f;
		}
	}
	
	public void moveIdle() {
		if (!seesPlayer) {
			if (k <= 0.25) { 					//go left, directionAngle = 90
				directionAngle = 90;
				X = X + 0.05f;
			} else if (k <= 0.5) { 				//go up, directionAngle = 0
				directionAngle = 0;
				Z = Z + 0.05f;
			} else if (k <= 0.75) { 			//go right, directionAngle = 270
				directionAngle = 270;
				X = X - 0.05f;
			} else { 							//go down, directionAngle = 180
				directionAngle = 180;
				Z = Z - 0.05f;
			}
		}
	}
	
}
