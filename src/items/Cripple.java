package items;

import java.awt.Font;

import inventory.Bag;
import inventory.Item;
import inventory.PlayerAttributes;
import game.Building;
import game.PlayerMotion;
import game.PlayerStats;

import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.glu.GLU;

import com.jogamp.opengl.util.awt.TextRenderer;
import com.jogamp.opengl.util.texture.Texture;

public class Cripple extends AbstractPowerUp {
	private Texture textureItem;
	private float itemX, itemY, itemZ;
	private float playerX, playerY, playerZ;
	private float angle;
	private boolean grabbed;
	private double T;
	private Bag bag;
	private static PlayerAttributes p;
	private int frames; 
	private int respawn = 500;
	private int counter;
	private boolean used;	
	private TextRenderer renderer;

	public Cripple(GL2 gl, GLU glu, float x, float y, float z, Bag bag,
			PlayerAttributes p) {
		textureItem = Building.setupTexture(gl, "FMPskull.png");
		this.itemX = x;
		this.itemY = y;
		this.itemZ = z;
		PlayerMotion.registerPlayerWatcher(this);
		this.bag = bag;
		Cripple.p = p;
		grabbed = false;
		used=false;
		frames = 0;		
		renderer = new TextRenderer(new Font("SansSerif", Font.BOLD, 150));
	}

	public Cripple() {
		// dummy constructor for DummyItem
	}

	public void draw(GL2 gl, GLU glu) {
		int timer = 0;
		counter++;
		frames++;
		T = T + 0.5;
		if (grabConditions()) {
			grabbed = true;
			counter = 0;
		}
		if (!grabbed) {
			drawItem(gl, glu);
		}		
		else if(!used){	
			timer = frames; 			
			use();
			used=true;
		}		
	}

	public boolean grabConditions() {
		if ((itemX - 3 < playerX && itemZ - 3 < playerZ)
				&& (itemX + 5 > playerX) && (itemZ + 5 > playerZ)
				&& (grabbed == false)&& (playerY<7))
			return true;
		else
			return false;
	}

	public boolean grabbed() {
		return grabbed;
	}


	public void SetLocation(int x, int y, int z) {
		this.itemX = x;
		this.itemY = y;
		this.itemZ = z;
	}

	public void setAngle(int angle) {
		this.angle = angle;
	}


	public void use() {
		float currentSpeed = p.getStepSize();
		int duration = 90;
		// calls PlayerAttributes
		p.setStepSize(currentSpeed - currentSpeed/2, duration);
	}

	public String getType() {
		return "Blind";
	}

	public void drawItem(GL2 gl, GLU glu) {

		gl.glEnable(GL2.GL_CULL_FACE);
		gl.glEnable(GL2.GL_TEXTURE_2D);
		gl.glPushMatrix();
		gl.glTranslated(itemX, Math.sin(Math.toRadians(T * 360 + 180)) + 2,
				itemZ);
		gl.glRotated(5*T,1,5*T,1);
		// gl.glRotated(Math.toRadians(15*frames), Math.toRadians(15*frames),
		// Math.toRadians(15*frames), 1);
		// gl.glTranslated(-itemX, -(Math.sin(Math.toRadians(T*360+180 ))+2),
		// -itemZ);
		textureItem.bind(gl);

		gl.glBegin(GL2.GL_QUADS);
		gl.glTexCoord2f(0f, 2f);
		gl.glVertex3f(-2.5f, 0, 0);
		gl.glTexCoord2f(3f, 2f);
		gl.glVertex3f(2.5f, 0, 0);
		gl.glTexCoord2f(3f, 0f);
		gl.glVertex3f(2.5f, 5, 0);
		gl.glTexCoord2f(0f, 0f);
		gl.glVertex3f(-2.5f, 5, 0);
		gl.glEnd();

		gl.glBegin(GL2.GL_QUADS);
		// cw as viewed from front, so can be seen as ccw from back
		gl.glTexCoord2f(0f, 2f);
		gl.glVertex3f(-2.5f, 0, 0);
		gl.glTexCoord2f(0f, 0f);
		gl.glVertex3f(-2.5f, 5, 0);
		gl.glTexCoord2f(3f, 0f);
		gl.glVertex3f(2.5f, 5, 0);
		gl.glTexCoord2f(3f, 2f);
		gl.glVertex3f(2.5f, 0, 0);
		gl.glEnd();

		// backwall
		gl.glBegin(GL2.GL_QUADS);
		gl.glTexCoord2f(0f, 2f);
		gl.glVertex3f(-2.5f, 0, -5);
		gl.glTexCoord2f(3f, 2f);
		gl.glVertex3f(2.5f, 0, -5);
		gl.glTexCoord2f(3f, 0f);
		gl.glVertex3f(2.5f, 5, -5);
		gl.glTexCoord2f(0f, 0f);
		gl.glVertex3f(-2.5f, 5, -5);
		gl.glEnd();
		gl.glBegin(GL2.GL_QUADS);// good side of quesiton mark
		// cw as viewed from front, so can be seen as ccw from back
		gl.glTexCoord2f(0f, 0f);
		gl.glVertex3f(-2.5f, 0, -5);
		gl.glTexCoord2f(0f, 1f);
		gl.glVertex3f(-2.5f, 5, -5);
		gl.glTexCoord2f(1f, 1f);
		gl.glVertex3f(2.5f, 5, -5);
		gl.glTexCoord2f(1f, 0f);
		gl.glVertex3f(2.5f, 0, -5);
		gl.glEnd();

		// leftwall
		gl.glBegin(GL2.GL_QUADS);
		gl.glTexCoord2f(0f, 2f);
		gl.glVertex3f(-2.5f, 0, 0);
		gl.glTexCoord2f(3f, 2f);
		gl.glVertex3f(-2.5f, 5, 0);
		gl.glTexCoord2f(3f, 0f);
		gl.glVertex3f(-2.5f, 5, -5);
		gl.glTexCoord2f(0f, 0f);
		gl.glVertex3f(-2.5f, 0, -5);
		gl.glEnd();
		gl.glBegin(GL2.GL_QUADS);
		gl.glTexCoord2f(0f, 2f);
		gl.glVertex3f(-2.5f, 0, 0);
		gl.glTexCoord2f(0f, 0f);
		gl.glVertex3f(-2.5f, 0, -5);
		gl.glTexCoord2f(3f, 0f);
		gl.glVertex3f(-2.5f, 5, -5);
		gl.glTexCoord2f(3f, 2f);
		gl.glVertex3f(-2.5f, 5, 0);
		gl.glEnd();

		// Rightwall
		gl.glBegin(GL2.GL_QUADS);
		gl.glTexCoord2f(0f, 2f);
		gl.glVertex3f(2.5f, 0, 0);
		gl.glTexCoord2f(3f, 2f);
		gl.glVertex3f(2.5f, 5, 0);
		gl.glTexCoord2f(3f, 0f);
		gl.glVertex3f(2.5f, 5, -5);
		gl.glTexCoord2f(0f, 0f);
		gl.glVertex3f(2.5f, 0, -5);
		gl.glEnd();
		gl.glBegin(GL2.GL_QUADS);
		gl.glTexCoord2f(0f, 2f);
		gl.glVertex3f(2.5f, 0, 0);
		gl.glTexCoord2f(0f, 0f);
		gl.glVertex3f(2.5f, 0, -5);
		gl.glTexCoord2f(3f, 0f);
		gl.glVertex3f(2.5f, 5, -5);
		gl.glTexCoord2f(3f, 2f);
		gl.glVertex3f(2.5f, 5, 0);
		gl.glEnd();

		// floor
		gl.glBegin(GL2.GL_QUADS);
		gl.glTexCoord2f(0f, 2f);
		gl.glVertex3f(2.5f, 0, 0);
		gl.glTexCoord2f(3f, 2f);
		gl.glVertex3f(2.5f, 0, -5);
		gl.glTexCoord2f(3f, 0f);
		gl.glVertex3f(-2.5f, 0, -5);
		gl.glTexCoord2f(0f, 0f);
		gl.glVertex3f(-2.5f, 0, 0);
		gl.glEnd();
		gl.glBegin(GL2.GL_QUADS);
		gl.glTexCoord2f(0f, 2f);
		gl.glVertex3f(2.5f, 0, 0);
		gl.glTexCoord2f(0f, 0f);
		gl.glVertex3f(-2.5f, 0, 0);
		gl.glTexCoord2f(3f, 0f);
		gl.glVertex3f(-2.5f, 0, -5);
		gl.glTexCoord2f(3f, 2f);
		gl.glVertex3f(2.5f, 0, -5);
		gl.glEnd();

		// ceiling
		gl.glBegin(GL2.GL_QUADS);
		gl.glTexCoord2f(0f, 2f);
		gl.glVertex3f(2.5f, 5, 0);
		gl.glTexCoord2f(3f, 2f);
		gl.glVertex3f(2.5f, 5, -5);
		gl.glTexCoord2f(3f, 0f);
		gl.glVertex3f(-2.5f, 5, -5);
		gl.glTexCoord2f(0f, 0f);
		gl.glVertex3f(-2.5f, 5, 0);
		gl.glEnd();
		gl.glBegin(GL2.GL_QUADS);
		gl.glTexCoord2f(0f, 2f);
		gl.glVertex3f(2.5f, 5, 0);
		gl.glTexCoord2f(0f, 0f);
		gl.glVertex3f(0f, 5, 0);
		gl.glTexCoord2f(3f, 0f);
		gl.glVertex3f(0f, 5, -5);
		gl.glTexCoord2f(3f, 2f);
		gl.glVertex3f(2.5f, 5, -5);
		gl.glEnd();

		gl.glPopMatrix();

		gl.glDisable(GL2.GL_CULL_FACE);
		gl.glDisable(GL2.GL_TEXTURE_2D);
	}

	@Override
	public void playerMoved(float x, float y, float z, float angle,
			float y_angle, PlayerStats s) {
		// GET CURRENT POSITION OF PLAYER
		this.playerX = x;
		this.playerY = y;
		this.playerZ = z;
		this.angle = angle;
	}

	@Override
	public void draw(GL2 gl, GLU glu, float x, float y, float z) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void linkLocation(Point3f f) {
		// TODO Auto-generated method stub
		
	}


}