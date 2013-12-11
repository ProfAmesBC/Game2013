package items;

import java.awt.Font;

import game.Building;
import game.PlayerMotion;
import game.PlayerStats;
import inventory.Bag;

import inventory.Item;
import inventory.PlayerAttributes;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;

import com.jogamp.opengl.util.awt.TextRenderer;
import com.jogamp.opengl.util.texture.Texture;

public class HPHeal extends AbstractPowerUp {
	//Instant HP Heal
	
	public HPHeal(GL2 gl, GLU glu, Point3f p3d, PlayerStats s) {
		texture = Building.setupTexture(gl, "FMPskull.png");//change this later
		PlayerMotion.registerPlayerWatcher(this);
		grabbed = false;
		stats=  s;
		pX = (float)p3d.getX();
		pY = (float)p3d.getY();
		pZ = (float)p3d.getZ();
		frames = 0;		
		type = "HP Heal";
	}

	@Override
	public void draw(GL2 gl, GLU glu) {
		// TODO Auto-generated method stub
		gl.glEnable(GL2.GL_CULL_FACE);
		gl.glEnable(GL2.GL_TEXTURE_2D);
		gl.glPushMatrix();
		gl.glTranslated(pX, Math.sin(Math.toRadians(T * 360 + 180)) + 2,
				pZ);
		gl.glRotated(5*T,1,5*T,1);
		// gl.glRotated(Math.toRadians(15*frames), Math.toRadians(15*frames),
		// Math.toRadians(15*frames), 1);
		// gl.glTranslated(-itemX, -(Math.sin(Math.toRadians(T*360+180 ))+2),
		// -itemZ);
		//texture.bind(gl);

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

	@Override
	public boolean grabbed() {
		// TODO Auto-generated method stub
		return grabbed;
	}

	public void use() {
		stats.changeHealth(1);
		grabbed=true;
	}
	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return type;
	}
}