package items;

import java.applet.AudioClip;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import game.BatsEverywhere;
import game.Building;
import game.PlayerMotion;
import game.PlayerStats;
import inventory.Bag;
import inventory.Item;
import inventory.PlayerAttributes;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.*;

import com.jogamp.opengl.util.awt.TextRenderer;
import com.jogamp.opengl.util.texture.Texture;

public class Invincible extends AbstractPowerUp {
	//Instant Honor increase
	private static PlayerAttributes p;
	private AudioClip invinc;
	
	public Invincible(GL2 gl, GLU glu, Point3f p3d, PlayerStats s) {		
		texture = Building.setupTexture(gl, "yanginvincible.png");//change this later
		PlayerMotion.registerPlayerWatcher(this);
		grabbed = false;
		stats=  s;
		pX = (float)p3d.getX();
		pY = (float)p3d.getY();
		pZ = (float)p3d.getZ();
		frames = 0;		
		type = "Invincible";
	}

	public Invincible(GL2 gl, GLU glu, Point3f p3d, PlayerStats s, PlayerAttributes p) {		
		texture = Building.setupTexture(gl, "yanginvincible.png");//change this later
		PlayerMotion.registerPlayerWatcher(this);
		grabbed = false;
		stats=  s;
		this.p = p;
		pX = (float)p3d.getX();
		pY = (float)p3d.getY();
		pZ = (float)p3d.getZ();
		frames = 0;		
		type = "Invincibility";
		
	}
	
	public Invincible(GL2 gl, GLU glu, PlayerStats s) {
		texture = Building.setupTexture(gl, "yanginvincible.png");//change this later
		PlayerMotion.registerPlayerWatcher(this);
		grabbed = false;
		stats=  s;	
		frames = 0;		
		type = "Invincible";
		
	}
	public Invincible(GL2 gl, GLU glu, PlayerStats ps, PlayerAttributes pa) {
		texture = Building.setupTexture(gl, "yanginvincible.png");//change this later
		PlayerMotion.registerPlayerWatcher(this);
		grabbed = false;
		stats=  ps;	
		frames = 0;		
		p = pa;
		type = "Invincible";	}
	

	@Override
	public void draw(GL2 gl, GLU glu, float x, float y, float z) {
		frames++;
		T = T + 0.05;
		if (grabConditions()) {
			grabbed = true;
		}

		if (!grabbed) {
			drawItem(gl, glu);
		}
	}

	@Override
	public boolean grabbed() {
		// TODO Auto-generated method stub
		return grabbed;
	}

	public void use() {
		grabbed=true;

		//plays music; commented out b/c don't yet know how to cut off background sound so it sounds muddled
		/*
		BatsEverywhere.m.load("invincible",  0, 0, 1, false);
		BatsEverywhere.m.setListenerPos(0, 0);
		BatsEverywhere.m.play("invincible");
		*/
		
		int time = 5000;
		int originalHealth = stats.checkHealth();
		//float currentSpeed = p.getStepSize();
		//p.setStepSize(currentSpeed *2, time);
		float newSpeed = p.getStepSize();
		//while (newSpeed!=currentSpeed) {
		while(time>0) {
			
			if (stats.checkHealth()<8) {
				stats.changeHealth(1);
				
			}
			time-=.01;
		}
		
		//cut invincible music here

		stats.changeHealth(originalHealth-stats.checkHealth());
		//p.setStepSize(currentSpeed, time+10000);
		
		System.out.println("ACTIVATED");
	}
	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return type;
	}

	@Override
	public void draw(GL2 gl, GLU glu) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void linkLocation(Point3f f) {
		// TODO Auto-generated method stub
		pX = f.getX();
		pY = f.getY();
		pZ = f.getZ();
		location = f;
	}
	
	public void drawItem(GL2 gl, GLU glu) {

		gl.glEnable(GL2.GL_CULL_FACE);
		gl.glEnable(GL2.GL_TEXTURE_2D);
		gl.glPushMatrix();
		gl.glTranslated(0, Math.sin(Math.toRadians(T * 360 + 180)) + 2,0);
		// gl.glRotated(Math.toRadians(15*frames), Math.toRadians(15*frames),
		// Math.toRadians(15*frames), 1);
		// gl.glTranslated(-itemX, -(Math.sin(Math.toRadians(T*360+180 ))+2),
		// -itemZ);
		//gl.glRotated(5*T,1,5*T,1);
		texture.bind(gl);

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
	
}
