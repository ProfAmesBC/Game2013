package buildings;
// HW#5, CS333 DNDBuilding class, Fall 2013
// by David D'Antona

import game.Building;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;

import com.jogamp.opengl.util.texture.Texture;

public class DNDBuilding extends Building {

	private DNDHome uchi;
	private DNDGrass ground;
	private DNDMachine machine1, machine2, machine3, machine4;
	private DNDSpecialItem specialItem;
	
	public DNDBuilding(GL2 gl, GLU glu) {
		// for home
		Texture brickTexture = setupTexture(gl, "DantonaBricks.jpg");
		Texture floorTexture = setupTexture(gl, "DantonaFloor.jpg");
		// for grass
		Texture grassTexture = setupTexture(gl, "DantonaGrass.gif");
		// for machine
		Texture compTexture1 = setupTexture(gl, "DantonaComp1.gif");
		Texture compTexture2 = setupTexture(gl, "DantonaComp2.gif");
		// for ball
		Texture blueTexture = setupTexture(gl, "DantonaBlue.jpg");
		
		// objects
		uchi = new DNDHome(gl, glu, brickTexture, floorTexture);
		ground = new DNDGrass(gl, glu, grassTexture);
		machine1 = new DNDMachine(gl, glu, compTexture1, compTexture2);
		machine2 = new DNDMachine(gl, glu, compTexture1, compTexture2);
		machine3 = new DNDMachine(gl, glu, compTexture1, compTexture2);
		machine4 = new DNDMachine(gl, glu, compTexture1, compTexture2);
		specialItem = new DNDSpecialItem(gl, glu, blueTexture);
	}

	public void draw(GL2 gl, GLU glu) {
        gl.glEnable(GL2.GL_CULL_FACE);
            gl.glPushMatrix();
                gl.glEnable(GL2.GL_TEXTURE_2D);
                
                uchi.create(gl);
                ground.create(gl);
                specialItem.create(gl, glu);
                
                gl.glDisable(GL2.GL_TEXTURE_2D);
            gl.glPopMatrix();
        gl.glDisable(GL2.GL_CULL_FACE);
	}
	
	@Override
	public void drawMoving(GL2 gl, GLU glu, float eyeX, float eyeY, float eyeZ) {
        gl.glEnable(GL2.GL_CULL_FACE);
        gl.glPushMatrix();
            gl.glEnable(GL2.GL_TEXTURE_2D);
            
            uchi.create(gl);
            ground.create(gl);
            specialItem.create(gl, glu);
            
            machine1.create(gl);
            gl.glTranslated(16, 0, 0);
            machine2.create(gl);
            gl.glTranslated(0, 0, -36);
            machine3.create(gl);
            gl.glTranslated(-16, 0, 0);
            machine4.create(gl);
            
            gl.glDisable(GL2.GL_TEXTURE_2D);
        gl.glPopMatrix();
    gl.glDisable(GL2.GL_CULL_FACE);
	}

}