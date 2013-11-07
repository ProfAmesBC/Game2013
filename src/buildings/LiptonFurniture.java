package buildings;

import game.Building;
import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;
import com.jogamp.opengl.util.texture.Texture;

public class LiptonFurniture extends Building{
	private Texture carpetTexture, tableTexture, hatTexture, paintingTexture, painting2Texture, painting3Texture, painting4Texture, chessTexture, bookTexture;
	private GLUquadric quadric;  // to control properties of quadric-based objects here
	
	public LiptonFurniture(GL2 gl, GLU glu){
		carpetTexture = setupTexture(gl, "LiptonCarpet.jpg");
		tableTexture = setupTexture(gl, "LiptonTable.gif");
		hatTexture = setupTexture(gl, "LiptonPink.jpg");
		paintingTexture = setupTexture(gl, "LiptonPaint1.jpg");
		painting2Texture = setupTexture(gl, "LiptonPaint2.jpg");
		painting3Texture = setupTexture(gl, "LiptonPaint3.jpg");
		painting4Texture = setupTexture(gl, "LiptonPaint4.jpg");
		chessTexture = setupTexture(gl, "LiptonChess.jpg");
		bookTexture = setupTexture(gl, "LiptonBooks.jpg");
		
		quadric = glu.gluNewQuadric();
        glu.gluQuadricDrawStyle(quadric, GLU.GLU_FILL); // GLU_POINT, GLU_LINE, GLU_FILL, GLU_SILHOUETTE
        glu.gluQuadricNormals  (quadric, GLU.GLU_NONE); // GLU_NONE, GLU_FLAT, or GLU_SMOOTH
        glu.gluQuadricTexture  (quadric, true);        // false, or true to generate texture coordinates
	}
	
    private float frames = 0;
    
	public void draw(GL2 gl, GLU glu) {
		
// - - - - - - - - - - - Carpet - - - - - 
		gl.glEnable(GL2.GL_TEXTURE_2D);
        carpetTexture.bind(gl);
        gl.glBegin(GL2.GL_QUADS);
            gl.glTexCoord2f(0f,2f); gl.glVertex3f( 60,  .01f, 45);
            gl.glTexCoord2f(3f,2f); gl.glVertex3f( 60,  .01f, 55);
            gl.glTexCoord2f(3f,0f); gl.glVertex3f( 40,  .01f, 55);
            gl.glTexCoord2f(0f,0f); gl.glVertex3f( 40,  .01f, 45);
        gl.glEnd();
    gl.glDisable(GL2.GL_TEXTURE_2D);
  
 // - - - - - - - - - - - Table - - - - - 
 		gl.glEnable(GL2.GL_TEXTURE_2D);
         tableTexture.bind(gl);
         gl.glBegin(GL2.GL_QUADS);
             gl.glTexCoord2f(0f,2f); gl.glVertex3f( 65,  3, 47);
             gl.glTexCoord2f(3f,2f); gl.glVertex3f( 65,  3, 53);
             gl.glTexCoord2f(3f,0f); gl.glVertex3f( 60,  3, 53);
             gl.glTexCoord2f(0f,0f); gl.glVertex3f( 60,  3, 47);
         gl.glEnd();
     gl.glDisable(GL2.GL_TEXTURE_2D);
     
		gl.glEnable(GL2.GL_TEXTURE_2D);
        tableTexture.bind(gl);
        gl.glBegin(GL2.GL_QUADS);
            gl.glTexCoord2f(0f,2f); gl.glVertex3f( 65,  2, 47);
            gl.glTexCoord2f(3f,2f); gl.glVertex3f( 65,  3, 47);
            gl.glTexCoord2f(3f,0f); gl.glVertex3f( 60,  3, 47);
            gl.glTexCoord2f(0f,0f); gl.glVertex3f( 60,  2, 47);
        gl.glEnd();
    gl.glDisable(GL2.GL_TEXTURE_2D);
    
		gl.glEnable(GL2.GL_TEXTURE_2D);
        tableTexture.bind(gl);
        gl.glBegin(GL2.GL_QUADS);
            gl.glTexCoord2f(0f,2f); gl.glVertex3f( 60,  2, 47);
            gl.glTexCoord2f(3f,2f); gl.glVertex3f( 60,  3, 47);
            gl.glTexCoord2f(3f,0f); gl.glVertex3f( 60,  3, 53);
            gl.glTexCoord2f(0f,0f); gl.glVertex3f( 60,  2, 53);
        gl.glEnd();
    gl.glDisable(GL2.GL_TEXTURE_2D);
    
		gl.glEnable(GL2.GL_TEXTURE_2D);
        tableTexture.bind(gl);
        gl.glBegin(GL2.GL_QUADS);
            gl.glTexCoord2f(0f,2f); gl.glVertex3f( 60,  2, 53);
            gl.glTexCoord2f(3f,2f); gl.glVertex3f( 60,  3, 53);
            gl.glTexCoord2f(3f,0f); gl.glVertex3f( 65,  3, 53);
            gl.glTexCoord2f(0f,0f); gl.glVertex3f( 65,  2, 53);
        gl.glEnd();
    gl.glDisable(GL2.GL_TEXTURE_2D);
    
    // Table Leg
    	gl.glEnable(GL2.GL_TEXTURE_2D);
    	tableTexture.bind(gl);
    	gl.glBegin(GL2.GL_QUADS);
    		gl.glTexCoord2f(0f,2f); gl.glVertex3f( 63,  0, 49);
    		gl.glTexCoord2f(3f,2f); gl.glVertex3f( 63,  3, 49);
    		gl.glTexCoord2f(3f,0f); gl.glVertex3f( 62,  3, 49);
    		gl.glTexCoord2f(0f,0f); gl.glVertex3f( 62,  0, 49);
    	gl.glEnd();
    gl.glDisable(GL2.GL_TEXTURE_2D);

	gl.glEnable(GL2.GL_TEXTURE_2D);
		tableTexture.bind(gl);
		gl.glBegin(GL2.GL_QUADS);
			gl.glTexCoord2f(0f,2f); gl.glVertex3f( 63,  0, 51);
			gl.glTexCoord2f(3f,2f); gl.glVertex3f( 63,  3, 51);
			gl.glTexCoord2f(3f,0f); gl.glVertex3f( 63,  3, 49);
			gl.glTexCoord2f(0f,0f); gl.glVertex3f( 63,  0, 49);
		gl.glEnd();
	gl.glDisable(GL2.GL_TEXTURE_2D);

	gl.glEnable(GL2.GL_TEXTURE_2D);
		tableTexture.bind(gl);
		gl.glBegin(GL2.GL_QUADS);
			gl.glTexCoord2f(0f,2f); gl.glVertex3f( 62,  0, 51);
			gl.glTexCoord2f(3f,2f); gl.glVertex3f( 62,  3, 51);
			gl.glTexCoord2f(3f,0f); gl.glVertex3f( 63,  3, 51);
			gl.glTexCoord2f(0f,0f); gl.glVertex3f( 63,  0, 51);
		gl.glEnd();
	gl.glDisable(GL2.GL_TEXTURE_2D);

	gl.glEnable(GL2.GL_TEXTURE_2D);
		tableTexture.bind(gl);
		gl.glBegin(GL2.GL_QUADS);
			gl.glTexCoord2f(0f,2f); gl.glVertex3f( 62,  0, 51);
			gl.glTexCoord2f(3f,2f); gl.glVertex3f( 62,  3, 51);
			gl.glTexCoord2f(3f,0f); gl.glVertex3f( 62,  3, 49);
			gl.glTexCoord2f(0f,0f); gl.glVertex3f( 62,  0, 49);
		gl.glEnd();
	gl.glDisable(GL2.GL_TEXTURE_2D);

// - - - - - - - - - - - Princess Hat - - - - - 
	gl.glEnable(GL2.GL_TEXTURE_2D);
	hatTexture.bind(gl);
		gl.glPushMatrix();
			gl.glTranslatef(63, 3, 48);
			gl.glRotatef(-90f, 1f, 0f, 0f); // stand upright (Y)
			glu.gluCylinder(quadric, .5, .1, 3, 15, 1);	
		gl.glPopMatrix();		
	gl.glDisable(GL2.GL_TEXTURE_2D);
	
// - - - - - - - - - - - Chess Board  - - - - - 
		gl.glEnable(GL2.GL_TEXTURE_2D);
		chessTexture.bind(gl);
		gl.glBegin(GL2.GL_QUADS);
			gl.glTexCoord2f(0f,2f); gl.glVertex3f( 62,  3.1f, 49);
			gl.glTexCoord2f(3f,2f); gl.glVertex3f( 62,  3.1f, 51);
			gl.glTexCoord2f(3f,0f); gl.glVertex3f( 60,  3.1f, 51);
			gl.glTexCoord2f(0f,0f); gl.glVertex3f( 60,  3.1f, 49);
		gl.glEnd();
	gl.glDisable(GL2.GL_TEXTURE_2D);

// - - - - - - - - - - - Paintings  - - - - - 
	gl.glEnable(GL2.GL_TEXTURE_2D);
	paintingTexture.bind(gl);
	gl.glBegin(GL2.GL_QUADS);
		gl.glTexCoord2f(0f,2f); gl.glVertex3f( 64,  10, 40);
		gl.glTexCoord2f(3f,2f); gl.glVertex3f( 64,  17, 40);
		gl.glTexCoord2f(3f,0f); gl.glVertex3f( 64,  17, 45);
		gl.glTexCoord2f(0f,0f); gl.glVertex3f( 64,  10, 45);
	gl.glEnd();
gl.glDisable(GL2.GL_TEXTURE_2D);

	gl.glEnable(GL2.GL_TEXTURE_2D);
	painting2Texture.bind(gl);
	gl.glBegin(GL2.GL_QUADS);
		gl.glTexCoord2f(0f,2f); gl.glVertex3f( 64,  10, 50);
		gl.glTexCoord2f(3f,2f); gl.glVertex3f( 64,  17, 50);
		gl.glTexCoord2f(3f,0f); gl.glVertex3f( 64,  17, 55);
		gl.glTexCoord2f(0f,0f); gl.glVertex3f( 64,  10, 55);
	gl.glEnd();
gl.glDisable(GL2.GL_TEXTURE_2D);

	gl.glEnable(GL2.GL_TEXTURE_2D);
	painting3Texture.bind(gl);
	gl.glBegin(GL2.GL_QUADS);
		gl.glTexCoord2f(0f,2f); gl.glVertex3f( 36,  9,  42);
		gl.glTexCoord2f(3f,2f); gl.glVertex3f( 36,  17, 42);
		gl.glTexCoord2f(3f,0f); gl.glVertex3f( 36,  17, 47);
		gl.glTexCoord2f(0f,0f); gl.glVertex3f( 36,  9,  47);
	gl.glEnd();
gl.glDisable(GL2.GL_TEXTURE_2D);

	gl.glEnable(GL2.GL_TEXTURE_2D);
	painting4Texture.bind(gl);
	gl.glBegin(GL2.GL_QUADS);
		gl.glTexCoord2f(0f,2f); gl.glVertex3f( 36,  9,  52);
		gl.glTexCoord2f(3f,2f); gl.glVertex3f( 36,  17, 52);
		gl.glTexCoord2f(3f,0f); gl.glVertex3f( 36,  17, 57);
		gl.glTexCoord2f(0f,0f); gl.glVertex3f( 36,  9,  57);
	gl.glEnd();
gl.glDisable(GL2.GL_TEXTURE_2D);

//- - - - - - - - - - - Book Case  - - - - - 

	// Top
	gl.glEnable(GL2.GL_TEXTURE_2D);
	tableTexture.bind(gl);
	gl.glBegin(GL2.GL_QUADS);
		gl.glTexCoord2f(0f,2f); gl.glVertex3f( 35,  9, 45);
		gl.glTexCoord2f(3f,2f); gl.glVertex3f( 35,  9, 51);
		gl.glTexCoord2f(3f,0f); gl.glVertex3f( 36,  9, 51);
		gl.glTexCoord2f(0f,0f); gl.glVertex3f( 36,  9, 45);
	gl.glEnd();
gl.glDisable(GL2.GL_TEXTURE_2D);

	// Top Front
	gl.glEnable(GL2.GL_TEXTURE_2D);
	tableTexture.bind(gl);
	gl.glBegin(GL2.GL_QUADS);
		gl.glTexCoord2f(0f,2f); gl.glVertex3f( 36,  9,  45);
		gl.glTexCoord2f(3f,2f); gl.glVertex3f( 36,  9,  51);
		gl.glTexCoord2f(3f,0f); gl.glVertex3f( 36,  8.5f,  51);
		gl.glTexCoord2f(0f,0f); gl.glVertex3f( 36,  8.5f,  45);
	gl.glEnd();
gl.glDisable(GL2.GL_TEXTURE_2D);

	// Far Side
	gl.glEnable(GL2.GL_TEXTURE_2D);
	tableTexture.bind(gl);
	gl.glBegin(GL2.GL_QUADS);
		gl.glTexCoord2f(0f,2f); gl.glVertex3f( 35,  0, 51);
		gl.glTexCoord2f(3f,2f); gl.glVertex3f( 35,  9, 51);
		gl.glTexCoord2f(3f,0f); gl.glVertex3f( 36,  9, 51);
		gl.glTexCoord2f(0f,0f); gl.glVertex3f( 36,  0, 51);
	gl.glEnd();
gl.glDisable(GL2.GL_TEXTURE_2D);

	// Near Side
	gl.glEnable(GL2.GL_TEXTURE_2D);
	tableTexture.bind(gl);
	gl.glBegin(GL2.GL_QUADS);
		gl.glTexCoord2f(0f,2f); gl.glVertex3f( 35,  0,  45);
		gl.glTexCoord2f(3f,2f); gl.glVertex3f( 35,  9,  45);
		gl.glTexCoord2f(3f,0f); gl.glVertex3f( 36,  9,  45);
		gl.glTexCoord2f(0f,0f); gl.glVertex3f( 36,  0,  45);
	gl.glEnd();
gl.glDisable(GL2.GL_TEXTURE_2D);

	// Shelf
	gl.glEnable(GL2.GL_TEXTURE_2D);
	tableTexture.bind(gl);
	gl.glBegin(GL2.GL_QUADS);
		gl.glTexCoord2f(0f,2f); gl.glVertex3f( 35,  7,  45);
		gl.glTexCoord2f(3f,2f); gl.glVertex3f( 35,  7,  51);
		gl.glTexCoord2f(3f,0f); gl.glVertex3f( 36,  7,  51);
		gl.glTexCoord2f(0f,0f); gl.glVertex3f( 36,  7,  45);
	gl.glEnd();
gl.glDisable(GL2.GL_TEXTURE_2D);
	
	// Shelf Front
	gl.glEnable(GL2.GL_TEXTURE_2D);
	tableTexture.bind(gl);
	gl.glBegin(GL2.GL_QUADS);
		gl.glTexCoord2f(0f,2f); gl.glVertex3f( 36,  7,  45);
		gl.glTexCoord2f(3f,2f); gl.glVertex3f( 36,  7,  51);
		gl.glTexCoord2f(3f,0f); gl.glVertex3f( 36,  6.5f,  51);
		gl.glTexCoord2f(0f,0f); gl.glVertex3f( 36,  6.5f,  45);
	gl.glEnd();
gl.glDisable(GL2.GL_TEXTURE_2D);

	// Shelf
	gl.glEnable(GL2.GL_TEXTURE_2D);
	tableTexture.bind(gl);
	gl.glBegin(GL2.GL_QUADS);
		gl.glTexCoord2f(0f,2f); gl.glVertex3f( 35,  4,  45);
		gl.glTexCoord2f(3f,2f); gl.glVertex3f( 35,  4,  51);
		gl.glTexCoord2f(3f,0f); gl.glVertex3f( 36,  4,  51);
		gl.glTexCoord2f(0f,0f); gl.glVertex3f( 36,  4,  45);
	gl.glEnd();
gl.glDisable(GL2.GL_TEXTURE_2D);

	// Shelf Front
	gl.glEnable(GL2.GL_TEXTURE_2D);
	tableTexture.bind(gl);
	gl.glBegin(GL2.GL_QUADS);
		gl.glTexCoord2f(0f,2f); gl.glVertex3f( 36,  4,  45);
		gl.glTexCoord2f(3f,2f); gl.glVertex3f( 36,  4,  51);
		gl.glTexCoord2f(3f,0f); gl.glVertex3f( 36,  3.5f,  51);
		gl.glTexCoord2f(0f,0f); gl.glVertex3f( 36,  3.5f,  45);
	gl.glEnd();
gl.glDisable(GL2.GL_TEXTURE_2D);

	// Shelf
	gl.glEnable(GL2.GL_TEXTURE_2D);
	tableTexture.bind(gl);
	gl.glBegin(GL2.GL_QUADS);
		gl.glTexCoord2f(0f,2f); gl.glVertex3f( 35,  1,  45);
		gl.glTexCoord2f(3f,2f); gl.glVertex3f( 35,  1,  51);
		gl.glTexCoord2f(3f,0f); gl.glVertex3f( 36,  1,  51);
		gl.glTexCoord2f(0f,0f); gl.glVertex3f( 36,  1,  45);
	gl.glEnd();
gl.glDisable(GL2.GL_TEXTURE_2D);

	// Shelf Front
	gl.glEnable(GL2.GL_TEXTURE_2D);
	tableTexture.bind(gl);
	gl.glBegin(GL2.GL_QUADS);
		gl.glTexCoord2f(0f,2f); gl.glVertex3f( 35,  1,  45);
		gl.glTexCoord2f(3f,2f); gl.glVertex3f( 35,  1,  51);
		gl.glTexCoord2f(3f,0f); gl.glVertex3f( 36,  .5f,  51);
		gl.glTexCoord2f(0f,0f); gl.glVertex3f( 36,  .5f,  45);
	gl.glEnd();
gl.glDisable(GL2.GL_TEXTURE_2D);

	// Books Shelf 1
	gl.glEnable(GL2.GL_TEXTURE_2D);
	bookTexture.bind(gl);
	gl.glBegin(GL2.GL_QUADS);
		gl.glTexCoord2f(0f,2f); gl.glVertex3f( 35.8f,  1,  51);
		gl.glTexCoord2f(3f,2f); gl.glVertex3f( 35.8f,  4,  51);
		gl.glTexCoord2f(3f,0f); gl.glVertex3f( 35.8f,  4,  45);
		gl.glTexCoord2f(0f,0f); gl.glVertex3f( 35.8f,  1,  45);
	gl.glEnd();
gl.glDisable(GL2.GL_TEXTURE_2D);

	// Books Shelf 2
	gl.glEnable(GL2.GL_TEXTURE_2D);
	bookTexture.bind(gl);
	gl.glBegin(GL2.GL_QUADS);
		gl.glTexCoord2f(0f,2f); gl.glVertex3f( 35.8f,  4,  51);
		gl.glTexCoord2f(3f,2f); gl.glVertex3f( 35.8f,  7,  51);
		gl.glTexCoord2f(3f,0f); gl.glVertex3f( 35.8f,  7,  45);
		gl.glTexCoord2f(0f,0f); gl.glVertex3f( 35.8f,  4,  45);
	gl.glEnd();
gl.glDisable(GL2.GL_TEXTURE_2D);

	// Books Shelf 3 (don't actually know which shelf these correspond to)
	gl.glEnable(GL2.GL_TEXTURE_2D);
	bookTexture.bind(gl);
	gl.glBegin(GL2.GL_QUADS);
		gl.glTexCoord2f(0f,2f); gl.glVertex3f( 35.8f,  7,  51);
		gl.glTexCoord2f(3f,2f); gl.glVertex3f( 35.8f,  9,  51);
		gl.glTexCoord2f(3f,0f); gl.glVertex3f( 35.8f,  9,  45);
		gl.glTexCoord2f(0f,0f); gl.glVertex3f( 35.8f,  7,  45);
	gl.glEnd();
gl.glDisable(GL2.GL_TEXTURE_2D);

    
	}

}
