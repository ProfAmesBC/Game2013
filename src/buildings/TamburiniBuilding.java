package buildings;
import game.Building;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;

import com.jogamp.opengl.util.texture.Texture;


public class TamburiniBuilding extends Building {

	private float wallHeight;
	private float wallWidth;
	private Texture pavementTexture, polkaDotTexture, sidingTexture, ceilingTexture,
			froyoSign, wood, roof, door, plastic, purple;
	private GL2 gl;
	
	public TamburiniBuilding(GL2 gl, GLU glu){
		this.gl = gl;
		
		pavementTexture = setupTexture(gl, "TamburiniPavement.jpg");	// how to change?
		polkaDotTexture = setupTexture(gl, "TamburiniPolkadots.gif");
		sidingTexture = setupTexture(gl, "TamburiniSiding.jpg");
		ceilingTexture = setupTexture(gl, "TamburiniCeiling.jpg");
		froyoSign = setupTexture(gl, "TamburiniFroyo.jpg");
		wood = setupTexture(gl, "TamburiniWood.jpg");
		roof = setupTexture(gl, "TamburiniRoof.jpg");
		door =  setupTexture(gl, "TamburiniDoor.jpg");
		plastic =  setupTexture(gl, "TamburiniPlastic.jpg");
		purple =  setupTexture(gl, "TamburiniPurple.jpg");
		
		wallHeight = 20;
		wallWidth = 50;
	}
	
	@Override
	public void draw(GL2 gl, GLU glu) {
		base();
		floor();
		walls();
		ceiling();
		sign();
		doors();
		tables(glu);
		
		// draw roof
		gl.glPushMatrix();
			gl.glTranslatef(25, wallHeight, 25);
			new TamburiniRoof(gl, 50, 10, sidingTexture, roof);
		gl.glPopMatrix();
		
		// draw walls with doors
		gl.glPushMatrix();
			gl.glTranslatef(25, 0, 25);
			gl.glRotatef(270, 0, 1, 0);
			new TamburiniDoorWall(gl, wallWidth, wallHeight, polkaDotTexture, sidingTexture);
		gl.glPopMatrix();
		
		gl.glPushMatrix();
			gl.glRotatef(90, 0, 1, 0);
			gl.glTranslatef(-75, 0, 75);
			new TamburiniDoorWall(gl, wallWidth, wallHeight, polkaDotTexture, sidingTexture);
		gl.glPopMatrix();
		
	}
	
	private void tables(GLU glu){
		
		gl.glPushMatrix();
			gl.glTranslatef(35, 0, 35);
			new TamburiniTable(gl, glu, plastic, purple);
			gl.glTranslatef(15, 0, 0);
			new TamburiniTable(gl, glu, plastic, purple);
			gl.glTranslatef(15, 0, 0);
			new TamburiniTable(gl, glu, plastic, purple);
		gl.glPopMatrix();
	}
	
	private void doors(){
		gl.glPushMatrix();
			gl.glTranslatef(25, 0, 45);
			gl.glRotatef(135, 0, 1, 0);
			new TamburiniDoor(gl, door);
			gl.glPopMatrix();
	
		gl.glPushMatrix();
			gl.glTranslatef(25, 0, 55);
			gl.glRotatef(215, 0, 1, 0);
			new TamburiniDoor(gl, door);
		gl.glPopMatrix();
	
		gl.glPushMatrix();
			gl.glRotatef(270, 0, 1, 0);
			gl.glTranslatef(45, 0, -75);
			new TamburiniDoor(gl, door);
		gl.glPopMatrix();
		
		gl.glPushMatrix();
			gl.glTranslatef(75, 0, 55);
			new TamburiniDoor(gl, door);
		gl.glPopMatrix();
	}
	
	private void base(){
		gl.glEnable(GL2.GL_TEXTURE_2D);
			pavementTexture.bind(gl);
			gl.glBegin(GL2.GL_QUADS);
        		gl.glTexCoord2f(0f, 2f); gl.glVertex3f(0, 0, 0);
        		gl.glTexCoord2f(3f, 2f); gl.glVertex3f(0, 0, 100);
        		gl.glTexCoord2f(3f, 0f); gl.glVertex3f(100, 0, 100);
        		gl.glTexCoord2f(0f, 0f); gl.glVertex3f(100, 0, 0);
        	gl.glEnd();
        gl.glDisable(GL2.GL_TEXTURE_2D);
	}
	
	private void floor(){
		gl.glEnable(GL2.GL_TEXTURE_2D);
			wood.bind(gl);
			gl.glBegin(GL2.GL_QUADS);
        		gl.glTexCoord2f(0f, 0f); gl.glVertex3f(25, .01f, 25);
        		gl.glTexCoord2f(0f, 10f); gl.glVertex3f(25, .01f, 75);
        		gl.glTexCoord2f(10f, 10f); gl.glVertex3f(75, .01f, 75);
        		gl.glTexCoord2f(10f, 0f); gl.glVertex3f(75, .01f, 25);
        	gl.glEnd();
        gl.glDisable(GL2.GL_TEXTURE_2D);
	}

	private void ceiling(){
		gl.glEnable(GL2.GL_TEXTURE_2D);
			ceilingTexture.bind(gl);
			gl.glBegin(GL2.GL_QUADS);
        		gl.glTexCoord2f(0f, 2f); gl.glVertex3f(25, wallHeight, 25);
        		gl.glTexCoord2f(3f, 2f); gl.glVertex3f(25, wallHeight, 75);
        		gl.glTexCoord2f(3f, 0f); gl.glVertex3f(75, wallHeight, 75);
        		gl.glTexCoord2f(0f, 0f); gl.glVertex3f(75, wallHeight, 25);
        	gl.glEnd();
        gl.glDisable(GL2.GL_TEXTURE_2D);
	}
	
	private void sign(){
		float side = 15;
		gl.glEnable(GL2.GL_TEXTURE_2D);
		froyoSign.bind(gl);
		gl.glBegin(GL2.GL_QUADS);
    		gl.glTexCoord2f(1f, 1f); gl.glVertex3f(42.5f, wallHeight - 3, 24.5f);
    		gl.glTexCoord2f(1f, 0f); gl.glVertex3f(42.5f, wallHeight - side, 24.5f);
    		gl.glTexCoord2f(0f, 0f); gl.glVertex3f(57.5f, wallHeight - side, 24.5f);
    		gl.glTexCoord2f(0f, 1f); gl.glVertex3f(57.5f, wallHeight - 3, 24.5f);
    	gl.glEnd();
    gl.glDisable(GL2.GL_TEXTURE_2D);
	}
	
	private void walls(){
		gl.glPushMatrix();
			gl.glTranslatef(25, 0, 25);
			new TamburiniWall(gl, wallWidth, wallHeight, sidingTexture, polkaDotTexture);
		gl.glPopMatrix();
		
		gl.glPushMatrix();
			gl.glRotatef(180, 0, 1, 0);
			gl.glTranslatef(-75, 0, -75);
			new TamburiniWall(gl, wallWidth, wallHeight, sidingTexture, polkaDotTexture);
		gl.glPopMatrix();
		
		gl.glPushMatrix();
			gl.glTranslatef(25, 0, 25);
			new TamburiniWall(gl, wallWidth, wallHeight, sidingTexture, polkaDotTexture);
			gl.glPopMatrix();
	
		gl.glPushMatrix();
			gl.glTranslatef(25, 0, 25);
			new TamburiniWall(gl, wallWidth, wallHeight, sidingTexture, polkaDotTexture);
		gl.glPopMatrix();

	}
}
