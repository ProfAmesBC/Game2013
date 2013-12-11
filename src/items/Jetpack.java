package items;

import inventory.Bag;
import inventory.Item;
import inventory.PlayerAttributes;
import game.Building;
import game.PlayerMotion;
import game.PlayerStats;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;

import sketchupModels.JetpackDrawing;

import com.jogamp.opengl.util.texture.Texture;

public class Jetpack implements Item {
	private Texture textureItem;
	private float itemX, itemY, itemZ;
	private float playerX, playerY, playerZ;
	private float angle;
	private boolean grabbed;
	private double T;
	private Bag bag;
	private static PlayerAttributes p;
	private int frames;
	private JetpackDrawing jp;

	public Jetpack(GL2 gl, GLU glu, float x, float y, float z, Bag bag,
			PlayerAttributes p) {
		textureItem = Building.setupTexture(gl, "textureItem.png");
		this.itemX = x;
		this.itemY = y;
		this.itemZ = z;
		PlayerMotion.registerPlayerWatcher(this);
		this.bag = bag;
		Jetpack.p = p;
		grabbed = false;
		frames = 0;
		jp = new sketchupModels.JetpackDrawing(gl, glu);
	}

	public Jetpack() {
		// dummy constructor for DummyItem
	}

	public void draw(GL2 gl, GLU glu) {
		frames++;
		T = T + 0.5;
		if (grabConditions()) {
			grabbed = true;
			bag.addItem(this);
		}

		if (!grabbed) {
			drawItem(gl, glu);
		}
	}

	private boolean grabConditions() {
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

	public double getLocationX() {
		return itemX;
	}

	public double getLocationY() {
		return itemY;
	}

	public double getLocationZ() {
		return itemZ;
	}

	public void SetLocation(int x, int y, int z) {
		this.itemX = x;
		this.itemY = y;
		this.itemZ = z;
	}

	public void setAngle(int angle) {
		this.angle = angle;
	}

	public double getAngle() {
		return angle;
	}

	public void use() {
		int height = 100;
		int duration = 200;
		// calls PlayerAttributes
		p.fly(height, duration);
	}

	public String getType() {
		return "Jetpack";
	}

	public void drawItem(GL2 gl, GLU glu) {
		gl.glPushMatrix();
		
		gl.glTranslated(itemX, Math.sin(Math.toRadians(T * 360 + 180)),
				itemZ);
		gl.glRotated(5*T,1,5*T,1);  
		jp.draw(gl, glu);
		gl.glPopMatrix();


		/*gl.glEnable(GL2.GL_CULL_FACE);
		gl.glEnable(GL2.GL_TEXTURE_2D);
		gl.glPushMatrix();
		gl.glTranslated(itemX, Math.sin(Math.toRadians(T * 360 + 180)) + 2,
				itemZ);
		// gl.glRotated(Math.toRadians(15*frames), Math.toRadians(15*frames),
		// Math.toRadians(15*frames), 1);
		// gl.glTranslated(-itemX, -(Math.sin(Math.toRadians(T*360+180 ))+2),
		// -itemZ);
		textureItem.bind(gl);
		gl.glRotated(5*T,1,5*T,1);

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
		*/
	}

	@Override
	public void playerMoved(float x, float y, float z, float angle, float y_angle,PlayerStats s) {		// GET CURRENT POSITION OF PLAYER
		this.playerX = x;
		this.playerY = y;
		this.playerZ = z;
		this.angle = angle;
	}

	@Override
	public void draw(GL2 gl, GLU glu, float x, float y, float z) {
		// TODO Auto-generated method stub

	}

}