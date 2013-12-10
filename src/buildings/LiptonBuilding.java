package buildings;

import game.Building;
import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;
import com.jogamp.opengl.util.texture.Texture;

public class LiptonBuilding extends Building {
	private Texture brickTexture, brick2Texture, wallTexture, floorTexture, grassTexture, doorTexture, waterTexture, bridgeTexture;
	private GLUquadric quadric;  // to control properties of quadric-based objects here
	private LiptonFurniture furniture;
	
	public LiptonBuilding(GL2 gl, GLU glu) {
		wallTexture = setupTexture(gl, "LiptonWall.gif");
        brickTexture = setupTexture(gl, "LiptonBrick.jpg"); 
        floorTexture = setupTexture(gl, "LiptonFloor.jpg"); 
		grassTexture = setupTexture(gl, "LiptonGrass.jpg");
		brick2Texture = setupTexture(gl, "LiptonBrickBack.jpg"); 
		doorTexture = setupTexture(gl, "LiptonTable.gif"); 
		waterTexture = setupTexture(gl, "LiptonWater.gif"); 
		bridgeTexture = setupTexture(gl, "LiptonBridge.jpg"); 
		
		furniture = new LiptonFurniture(gl, glu);
        
		quadric = glu.gluNewQuadric();
        glu.gluQuadricDrawStyle(quadric, GLU.GLU_FILL); // GLU_POINT, GLU_LINE, GLU_FILL, GLU_SILHOUETTE
        glu.gluQuadricNormals  (quadric, GLU.GLU_NONE); // GLU_NONE, GLU_FLAT, or GLU_SMOOTH
        glu.gluQuadricTexture  (quadric, true);        // false, or true to generate texture coordinates
	}
	
	
    private float frames = 0;
    
	public void draw(GL2 gl, GLU glu) {
		++frames;
		furniture.draw(gl, glu);
// _ _ _ _ _ _ _ _ _ _ _ _ _ _ GROUND _ _ _ _ _ _ _ _ _ _ _ _ _ _
    gl.glEnable(GL2.GL_TEXTURE_2D);
      grassTexture.bind(gl);
        gl.glBegin(GL2.GL_QUADS);
            gl.glTexCoord2f(0f,2f); gl.glVertex3f( 0,  0, 0);
            gl.glTexCoord2f(3f,2f); gl.glVertex3f( 100,  0, 0);
            gl.glTexCoord2f(3f,0f); gl.glVertex3f( 100, 0, 35);
            gl.glTexCoord2f(0f,0f); gl.glVertex3f( 0, 0, 35);
        gl.glEnd();
    gl.glDisable(GL2.GL_TEXTURE_2D);
    
    gl.glEnable(GL2.GL_TEXTURE_2D);
     grassTexture.bind(gl);
    	gl.glBegin(GL2.GL_QUADS);
        	gl.glTexCoord2f(0f,2f); gl.glVertex3f( 65,  0, 35);
        	gl.glTexCoord2f(3f,2f); gl.glVertex3f( 100,  0, 35);
        	gl.glTexCoord2f(3f,0f); gl.glVertex3f( 100, 0, 100);
        	gl.glTexCoord2f(0f,0f); gl.glVertex3f( 65, 0, 100);
        gl.glEnd();
    gl.glDisable(GL2.GL_TEXTURE_2D);
    
    gl.glEnable(GL2.GL_TEXTURE_2D);
    grassTexture.bind(gl);
    	gl.glBegin(GL2.GL_QUADS);
        	gl.glTexCoord2f(0f,2f); gl.glVertex3f( 0,  0, 65);
        	gl.glTexCoord2f(3f,2f); gl.glVertex3f( 65,  0, 65);
        	gl.glTexCoord2f(3f,0f); gl.glVertex3f( 65, 0, 100);
        	gl.glTexCoord2f(0f,0f); gl.glVertex3f( 0, 0, 100);
        gl.glEnd();
    gl.glDisable(GL2.GL_TEXTURE_2D);

    gl.glEnable(GL2.GL_TEXTURE_2D);
    grassTexture.bind(gl);
    	gl.glBegin(GL2.GL_QUADS);
    		gl.glTexCoord2f(0f,2f); gl.glVertex3f( 0,  0, 35);
    		gl.glTexCoord2f(3f,2f); gl.glVertex3f( 35,  0, 35);
    		gl.glTexCoord2f(3f,0f); gl.glVertex3f( 35, 0, 65);
    		gl.glTexCoord2f(0f,0f); gl.glVertex3f( 0, 0, 65);
    	gl.glEnd();
    gl.glDisable(GL2.GL_TEXTURE_2D);

 // _ _ _ _ _ _ _ _ _ _ _ _ _ _ FLOOR _ _ _ _ _ _ _ _ _ _ _ _ _ _
    gl.glEnable(GL2.GL_TEXTURE_2D);
    floorTexture.bind(gl);
    	gl.glBegin(GL2.GL_QUADS);
        	gl.glTexCoord2f(0f,2f); gl.glVertex3f(35, 0, 35);
        	gl.glTexCoord2f(3f,2f); gl.glVertex3f(65, 0, 35);
        	gl.glTexCoord2f(3f,0f); gl.glVertex3f(65, 0, 65);
        	gl.glTexCoord2f(0f,0f); gl.glVertex3f(35, 0, 65);
        gl.glEnd();
    gl.glDisable(GL2.GL_TEXTURE_2D);

// _ _ _ _ _ _ _ _ _ _ _ _ _ _ FRONT OF CASTLE _ _ _ _ _ _ _ _ _ _ _ _ _ _
    gl.glEnable(GL2.GL_CULL_FACE);
    gl.glPushMatrix();
//        gl.glRotatef(frames*2, 0,1,0);
        gl.glEnable(GL2.GL_TEXTURE_2D);
            wallTexture.bind(gl);
            gl.glBegin(GL2.GL_QUADS);
                // ccw as viewed from front
            	gl.glTexCoord2f(0f,2f); gl.glVertex3f(35, 12, 35);
            	gl.glTexCoord2f(3f,2f); gl.glVertex3f(65, 12, 35);
            	gl.glTexCoord2f(3f,0f); gl.glVertex3f(65, 28, 35);
            	gl.glTexCoord2f(0f,0f); gl.glVertex3f(35, 28, 35);
            gl.glEnd();
            brickTexture.bind(gl);
            gl.glBegin(GL2.GL_QUADS);
                // cw as viewed from back
            	gl.glTexCoord2f(0f,2f); gl.glVertex3f(35, 12, 35);
            	gl.glTexCoord2f(3f,2f); gl.glVertex3f(35, 28, 35);
            	gl.glTexCoord2f(3f,0f); gl.glVertex3f(65, 28, 35);
            	gl.glTexCoord2f(0f,0f); gl.glVertex3f(65, 12, 35);
            gl.glEnd();
        gl.glDisable(GL2.GL_TEXTURE_2D);
    gl.glPopMatrix();
gl.glDisable(GL2.GL_CULL_FACE);

// - - - Left of Door
gl.glEnable(GL2.GL_CULL_FACE);
gl.glPushMatrix();
//    gl.glRotatef(frames*2, 0,1,0);
    gl.glEnable(GL2.GL_TEXTURE_2D);
        wallTexture.bind(gl);
        gl.glBegin(GL2.GL_QUADS);
            // ccw as viewed from front
        	gl.glTexCoord2f(0f,2f); gl.glVertex3f(35, 0, 35);
        	gl.glTexCoord2f(3f,2f); gl.glVertex3f(45, 0, 35);
        	gl.glTexCoord2f(3f,0f); gl.glVertex3f(45, 12, 35);
        	gl.glTexCoord2f(0f,0f); gl.glVertex3f(35, 12, 35);
        gl.glEnd();
        brickTexture.bind(gl);
        gl.glBegin(GL2.GL_QUADS);
     // cw as viewed from front, so can be seen as ccw from back
        	gl.glTexCoord2f(0f,0f); gl.glVertex3f(35, 12, 35);
        	gl.glTexCoord2f(0f,2f); gl.glVertex3f(45, 12, 35);
        	gl.glTexCoord2f(3f,0f); gl.glVertex3f(45, 0, 35);
        	gl.glTexCoord2f(3f,2f); gl.glVertex3f(35, 0, 35);
        gl.glEnd();
    gl.glDisable(GL2.GL_TEXTURE_2D);
gl.glPopMatrix();
gl.glDisable(GL2.GL_CULL_FACE);

//- - - Right of Door
gl.glEnable(GL2.GL_CULL_FACE);
gl.glPushMatrix();
//    gl.glRotatef(frames*2, 0,1,0);
    gl.glEnable(GL2.GL_TEXTURE_2D);
        wallTexture.bind(gl);
        gl.glBegin(GL2.GL_QUADS);
            // ccw as viewed from front
        	gl.glTexCoord2f(0f,2f); gl.glVertex3f(55, 0, 35);
        	gl.glTexCoord2f(3f,2f); gl.glVertex3f(65, 0, 35);
        	gl.glTexCoord2f(3f,0f); gl.glVertex3f(65, 12, 35);
        	gl.glTexCoord2f(0f,0f); gl.glVertex3f(55, 12, 35);
        gl.glEnd();
        brickTexture.bind(gl);
        gl.glBegin(GL2.GL_QUADS);
     // cw as viewed from front, so can be seen as ccw from back
        	gl.glTexCoord2f(0f,0f); gl.glVertex3f(55, 12, 35);
        	gl.glTexCoord2f(0f,2f); gl.glVertex3f(65, 12, 35);
        	gl.glTexCoord2f(3f,0f); gl.glVertex3f(65, 0, 35);
        	gl.glTexCoord2f(3f,2f); gl.glVertex3f(55, 0, 35);
        gl.glEnd();
    gl.glDisable(GL2.GL_TEXTURE_2D);
gl.glPopMatrix();
gl.glDisable(GL2.GL_CULL_FACE);

//_ _ _ _ _ _ _ _ _ _ _ _ _ _ BACK OF CASTLE _ _ _ _ _ _ _ _ _ _ _ _ _ _
gl.glEnable(GL2.GL_CULL_FACE);
gl.glPushMatrix();
//    gl.glRotatef(frames*2, 0,1,0);
    gl.glEnable(GL2.GL_TEXTURE_2D);
        wallTexture.bind(gl);
        gl.glBegin(GL2.GL_QUADS);
            // ccw as viewed from front
        	gl.glTexCoord2f(0f,0f); gl.glVertex3f(65, 12, 65);
        	gl.glTexCoord2f(0f,2f); gl.glVertex3f(35, 12, 65);
        	gl.glTexCoord2f(3f,2f); gl.glVertex3f(35, 28, 65);
        	gl.glTexCoord2f(3f,0f); gl.glVertex3f(65, 28, 65);
        gl.glEnd();
        brick2Texture.bind(gl);
        gl.glBegin(GL2.GL_QUADS);
     // cw as viewed from front, so can be seen as ccw from back
        	gl.glTexCoord2f(0f,2f); gl.glVertex3f(35, 12, 65);
        	gl.glTexCoord2f(3f,2f); gl.glVertex3f(65, 12, 65);
        	gl.glTexCoord2f(3f,0f); gl.glVertex3f(65, 28, 65);
        	gl.glTexCoord2f(0f,0f); gl.glVertex3f(35, 28, 65);
        gl.glEnd();
    gl.glDisable(GL2.GL_TEXTURE_2D);
gl.glPopMatrix();
gl.glDisable(GL2.GL_CULL_FACE);

//- - - Left of Door
gl.glEnable(GL2.GL_CULL_FACE);
gl.glPushMatrix();
//gl.glRotatef(frames*2, 0,1,0);
gl.glEnable(GL2.GL_TEXTURE_2D);
    wallTexture.bind(gl);
    gl.glBegin(GL2.GL_QUADS);
        // ccw as viewed from front
    	gl.glTexCoord2f(0f,0f); gl.glVertex3f(35, 12, 65);
    	gl.glTexCoord2f(0f,2f); gl.glVertex3f(45, 12, 65);
    	gl.glTexCoord2f(3f,0f); gl.glVertex3f(45, 0, 65);
    	gl.glTexCoord2f(3f,2f); gl.glVertex3f(35, 0, 65);	
    gl.glEnd();
    brick2Texture.bind(gl);
    gl.glBegin(GL2.GL_QUADS);
 // cw as viewed from front, so can be seen as ccw from back
    	gl.glTexCoord2f(0f,2f); gl.glVertex3f(35, 0, 65);
    	gl.glTexCoord2f(3f,2f); gl.glVertex3f(45, 0, 65);
    	gl.glTexCoord2f(3f,0f); gl.glVertex3f(45, 12, 65);
    	gl.glTexCoord2f(0f,0f); gl.glVertex3f(35, 12, 65);
    gl.glEnd();
gl.glDisable(GL2.GL_TEXTURE_2D);
gl.glPopMatrix();
gl.glDisable(GL2.GL_CULL_FACE);

//- - - Right of Door
gl.glEnable(GL2.GL_CULL_FACE);
gl.glPushMatrix();
//gl.glRotatef(frames*2, 0,1,0);
gl.glEnable(GL2.GL_TEXTURE_2D);
    wallTexture.bind(gl);
    gl.glBegin(GL2.GL_QUADS);
        // ccw as viewed from front
    	gl.glTexCoord2f(0f,0f); gl.glVertex3f(55, 12, 65);
    	gl.glTexCoord2f(0f,2f); gl.glVertex3f(65, 12, 65);
    	gl.glTexCoord2f(3f,0f); gl.glVertex3f(65, 0, 65);
    	gl.glTexCoord2f(3f,2f); gl.glVertex3f(55, 0, 65);
    gl.glEnd();
    brick2Texture.bind(gl);
    gl.glBegin(GL2.GL_QUADS);
 // cw as viewed from front, so can be seen as ccw from back
    	gl.glTexCoord2f(0f,2f); gl.glVertex3f(55, 0, 65);
    	gl.glTexCoord2f(3f,2f); gl.glVertex3f(65, 0, 65);
    	gl.glTexCoord2f(3f,0f); gl.glVertex3f(65, 12, 65);
    	gl.glTexCoord2f(0f,0f); gl.glVertex3f(55, 12, 65);	
    gl.glEnd();
gl.glDisable(GL2.GL_TEXTURE_2D);
gl.glPopMatrix();
gl.glDisable(GL2.GL_CULL_FACE);

//_ _ _ _ _ _ _ _ _ _ _ _ _ _ RIGHT SIDE OF CASTLE _ _ _ _ _ _ _ _ _ _ _ _ _ _
gl.glEnable(GL2.GL_CULL_FACE);

//gl.glRotatef(frames*2, 0,1,0);
gl.glEnable(GL2.GL_TEXTURE_2D);
    wallTexture.bind(gl);
    gl.glBegin(GL2.GL_QUADS);
        // ccw as viewed from front
    	gl.glTexCoord2f(0f,2f); gl.glVertex3f(65, 0, 65);
    	gl.glTexCoord2f(3f,2f); gl.glVertex3f(65, 28, 65);
    	gl.glTexCoord2f(3f,0f); gl.glVertex3f(65, 28, 35);
    	gl.glTexCoord2f(0f,0f); gl.glVertex3f(65, 0, 35);
    gl.glEnd();
    brickTexture.bind(gl);
    gl.glBegin(GL2.GL_QUADS);
 // cw as viewed from front, so can be seen as ccw from back
    	gl.glTexCoord2f(0f,2f); gl.glVertex3f(65, 28, 65);
    	gl.glTexCoord2f(3f,2f); gl.glVertex3f(65, 0, 65);
    	gl.glTexCoord2f(3f,0f); gl.glVertex3f(65, 0, 35);
    	gl.glTexCoord2f(0f,0f); gl.glVertex3f(65, 28, 35);
    gl.glEnd();
gl.glDisable(GL2.GL_TEXTURE_2D);

gl.glDisable(GL2.GL_CULL_FACE);

//_ _ _ _ _ _ _ _ _ _ _ _ _ _ LEFT SIDE OF CASTLE _ _ _ _ _ _ _ _ _ _ _ _ _ _
gl.glEnable(GL2.GL_CULL_FACE);
gl.glPushMatrix();
//  gl.glRotatef(frames*2, 0,1,0);
  gl.glEnable(GL2.GL_TEXTURE_2D);
      wallTexture.bind(gl);
      gl.glBegin(GL2.GL_QUADS);
          // ccw as viewed from front
      	gl.glTexCoord2f(0f,2f); gl.glVertex3f(35, 0, 35);
      	gl.glTexCoord2f(3f,2f); gl.glVertex3f(35, 28, 35);
      	gl.glTexCoord2f(3f,0f); gl.glVertex3f(35, 28, 65);
      	gl.glTexCoord2f(0f,0f); gl.glVertex3f(35, 0, 65);
      gl.glEnd();
      brickTexture.bind(gl);
      gl.glBegin(GL2.GL_QUADS);
   // cw as viewed from front, so can be seen as ccw from back
      	gl.glTexCoord2f(0f,2f); gl.glVertex3f(35, 28, 35);
      	gl.glTexCoord2f(3f,2f); gl.glVertex3f(35, 0, 35);
      	gl.glTexCoord2f(3f,0f); gl.glVertex3f(35, 0, 65);
      	gl.glTexCoord2f(0f,0f); gl.glVertex3f(35, 28, 65);
      gl.glEnd();
  gl.glDisable(GL2.GL_TEXTURE_2D);
gl.glPopMatrix();
gl.glDisable(GL2.GL_CULL_FACE);

//_ _ _ _ _ _ _ _ _ _ _ _ _ _ ROOF OF CASTLE _ _ _ _ _ _ _ _ _ _ _ _ _ _
gl.glEnable(GL2.GL_CULL_FACE);
gl.glPushMatrix();
//gl.glRotatef(frames*2, 0,1,0);
gl.glEnable(GL2.GL_TEXTURE_2D);
    brickTexture.bind(gl);
    gl.glBegin(GL2.GL_QUADS);
        // ccw as viewed from front
    	gl.glTexCoord2f(0f,2f); gl.glVertex3f(65, 28, 65);
    	gl.glTexCoord2f(3f,2f); gl.glVertex3f(65, 28, 35);
    	gl.glTexCoord2f(3f,0f); gl.glVertex3f(35, 28, 35);
    	gl.glTexCoord2f(0f,0f); gl.glVertex3f(35, 28, 65);
    gl.glEnd();
    wallTexture.bind(gl);
    gl.glBegin(GL2.GL_QUADS);
 // cw as viewed from front, so can be seen as ccw from back
    	gl.glTexCoord2f(0f,2f); gl.glVertex3f(65, 28, 65);
    	gl.glTexCoord2f(3f,2f); gl.glVertex3f(35, 28, 65);
    	gl.glTexCoord2f(3f,0f); gl.glVertex3f(35, 28, 35);
    	gl.glTexCoord2f(0f,0f); gl.glVertex3f(65, 28, 35);
    gl.glEnd();
gl.glDisable(GL2.GL_TEXTURE_2D);
gl.glPopMatrix();
gl.glDisable(GL2.GL_CULL_FACE);

//_ _ _ _ _ _ _ _ _ _ _ _ _ _ Crenellations Roof Front _ _ _ _ _ _ _ _ _ _ _ _ _ _

	gl.glEnable(GL2.GL_TEXTURE_2D);
	brickTexture.bind(gl);
	gl.glBegin(GL2.GL_QUADS);
		gl.glTexCoord2f(0f,2f); gl.glVertex3f( 43,  28,  35);
		gl.glTexCoord2f(3f,2f); gl.glVertex3f( 43,  30,  35);
		gl.glTexCoord2f(3f,0f); gl.glVertex3f( 40,  30,  35);
		gl.glTexCoord2f(0f,0f); gl.glVertex3f( 40,  28,  35);
	gl.glEnd();
gl.glDisable(GL2.GL_TEXTURE_2D);

	gl.glEnable(GL2.GL_TEXTURE_2D);
	brickTexture.bind(gl);
	gl.glBegin(GL2.GL_QUADS);
		gl.glTexCoord2f(0f,2f); gl.glVertex3f( 45,  28,  35);
		gl.glTexCoord2f(3f,2f); gl.glVertex3f( 45,  30,  35);
		gl.glTexCoord2f(3f,0f); gl.glVertex3f( 49,  30,  35);
		gl.glTexCoord2f(0f,0f); gl.glVertex3f( 49,  28,  35);
	gl.glEnd();
gl.glDisable(GL2.GL_TEXTURE_2D);

	gl.glEnable(GL2.GL_TEXTURE_2D);
	brickTexture.bind(gl);
	gl.glBegin(GL2.GL_QUADS);
		gl.glTexCoord2f(0f,2f); gl.glVertex3f( 51,  28,  35);
		gl.glTexCoord2f(3f,2f); gl.glVertex3f( 51,  30,  35);
		gl.glTexCoord2f(3f,0f); gl.glVertex3f( 55,  30,  35);
		gl.glTexCoord2f(0f,0f); gl.glVertex3f( 55,  28,  35);
	gl.glEnd();
gl.glDisable(GL2.GL_TEXTURE_2D);

	gl.glEnable(GL2.GL_TEXTURE_2D);
	brickTexture.bind(gl);
	gl.glBegin(GL2.GL_QUADS);
		gl.glTexCoord2f(0f,2f); gl.glVertex3f( 57,  28,  35);
		gl.glTexCoord2f(3f,2f); gl.glVertex3f( 57,  30,  35);
		gl.glTexCoord2f(3f,0f); gl.glVertex3f( 60,  30,  35);
		gl.glTexCoord2f(0f,0f); gl.glVertex3f( 60,  28,  35);
	gl.glEnd();
gl.glDisable(GL2.GL_TEXTURE_2D);

//_ _ _ _ _ _ _ _ _ _ _ _ _ _ Crenellations Roof Back _ _ _ _ _ _ _ _ _ _ _ _ _ _

	gl.glEnable(GL2.GL_TEXTURE_2D);
	brickTexture.bind(gl);
	gl.glBegin(GL2.GL_QUADS);
		gl.glTexCoord2f(0f,2f); gl.glVertex3f( 43,  28,  65);
		gl.glTexCoord2f(3f,2f); gl.glVertex3f( 43,  30,  65);
		gl.glTexCoord2f(3f,0f); gl.glVertex3f( 40,  30,  65);
		gl.glTexCoord2f(0f,0f); gl.glVertex3f( 40,  28,  65);
	gl.glEnd();
gl.glDisable(GL2.GL_TEXTURE_2D);

	gl.glEnable(GL2.GL_TEXTURE_2D);
	brickTexture.bind(gl);
	gl.glBegin(GL2.GL_QUADS);
		gl.glTexCoord2f(0f,2f); gl.glVertex3f( 45,  28,  65);
		gl.glTexCoord2f(3f,2f); gl.glVertex3f( 45,  30,  65);
		gl.glTexCoord2f(3f,0f); gl.glVertex3f( 49,  30,  65);
		gl.glTexCoord2f(0f,0f); gl.glVertex3f( 49,  28,  65);
	gl.glEnd();
gl.glDisable(GL2.GL_TEXTURE_2D);

	gl.glEnable(GL2.GL_TEXTURE_2D);
	brickTexture.bind(gl);
	gl.glBegin(GL2.GL_QUADS);
		gl.glTexCoord2f(0f,2f); gl.glVertex3f( 51,  28,  65);
		gl.glTexCoord2f(3f,2f); gl.glVertex3f( 51,  30,  65);
		gl.glTexCoord2f(3f,0f); gl.glVertex3f( 55,  30,  65);
		gl.glTexCoord2f(0f,0f); gl.glVertex3f( 55,  28,  65);
	gl.glEnd();
gl.glDisable(GL2.GL_TEXTURE_2D);

	gl.glEnable(GL2.GL_TEXTURE_2D);
	brickTexture.bind(gl);
	gl.glBegin(GL2.GL_QUADS);
		gl.glTexCoord2f(0f,2f); gl.glVertex3f( 57,  28,  65);
		gl.glTexCoord2f(3f,2f); gl.glVertex3f( 57,  30,  65);
		gl.glTexCoord2f(3f,0f); gl.glVertex3f( 60,  30,  65);
		gl.glTexCoord2f(0f,0f); gl.glVertex3f( 60,  28,  65);
	gl.glEnd();
gl.glDisable(GL2.GL_TEXTURE_2D);

//_ _ _ _ _ _ _ _ _ _ _ _ _ _ Crenellations Roof Right _ _ _ _ _ _ _ _ _ _ _ _ _ _

	gl.glEnable(GL2.GL_TEXTURE_2D);
	brickTexture.bind(gl);
	gl.glBegin(GL2.GL_QUADS);
		gl.glTexCoord2f(0f,2f); gl.glVertex3f( 35,  28,  43);
		gl.glTexCoord2f(3f,2f); gl.glVertex3f( 35,  30,  43);
		gl.glTexCoord2f(3f,0f); gl.glVertex3f( 35,  30,  40);
		gl.glTexCoord2f(0f,0f); gl.glVertex3f( 35,  28,  40);
	gl.glEnd();
gl.glDisable(GL2.GL_TEXTURE_2D);

	gl.glEnable(GL2.GL_TEXTURE_2D);
	brickTexture.bind(gl);
	gl.glBegin(GL2.GL_QUADS);
		gl.glTexCoord2f(0f,2f); gl.glVertex3f( 35,  28,  45);
		gl.glTexCoord2f(3f,2f); gl.glVertex3f( 35,  30,  45);
		gl.glTexCoord2f(3f,0f); gl.glVertex3f( 35,  30,  49);
		gl.glTexCoord2f(0f,0f); gl.glVertex3f( 35,  28,  49);
	gl.glEnd();
gl.glDisable(GL2.GL_TEXTURE_2D);

	gl.glEnable(GL2.GL_TEXTURE_2D);
	brickTexture.bind(gl);
	gl.glBegin(GL2.GL_QUADS);
		gl.glTexCoord2f(0f,2f); gl.glVertex3f( 35,  28,  51);
		gl.glTexCoord2f(3f,2f); gl.glVertex3f( 35,  30,  51);
		gl.glTexCoord2f(3f,0f); gl.glVertex3f( 35,  30,  55);
		gl.glTexCoord2f(0f,0f); gl.glVertex3f( 35,  28,  55);
	gl.glEnd();
gl.glDisable(GL2.GL_TEXTURE_2D);

	gl.glEnable(GL2.GL_TEXTURE_2D);
	brickTexture.bind(gl);
	gl.glBegin(GL2.GL_QUADS);
		gl.glTexCoord2f(0f,2f); gl.glVertex3f( 35,  28,  57);
		gl.glTexCoord2f(3f,2f); gl.glVertex3f( 35,  30,  57);
		gl.glTexCoord2f(3f,0f); gl.glVertex3f( 35,  30,  60);
		gl.glTexCoord2f(0f,0f); gl.glVertex3f( 35,  28,  60);
	gl.glEnd();
gl.glDisable(GL2.GL_TEXTURE_2D);

//_ _ _ _ _ _ _ _ _ _ _ _ _ _ Crenellations Roof Left _ _ _ _ _ _ _ _ _ _ _ _ _ _

	gl.glEnable(GL2.GL_TEXTURE_2D);
	brickTexture.bind(gl);
	gl.glBegin(GL2.GL_QUADS);
		gl.glTexCoord2f(0f,2f); gl.glVertex3f( 65,  28,  43);
		gl.glTexCoord2f(3f,2f); gl.glVertex3f( 65,  30,  43);
		gl.glTexCoord2f(3f,0f); gl.glVertex3f( 65,  30,  40);
		gl.glTexCoord2f(0f,0f); gl.glVertex3f( 65,  28,  40);
	gl.glEnd();
gl.glDisable(GL2.GL_TEXTURE_2D);

	gl.glEnable(GL2.GL_TEXTURE_2D);
	brickTexture.bind(gl);
	gl.glBegin(GL2.GL_QUADS);
		gl.glTexCoord2f(0f,2f); gl.glVertex3f( 65,  28,  45);
		gl.glTexCoord2f(3f,2f); gl.glVertex3f( 65,  30,  45);
		gl.glTexCoord2f(3f,0f); gl.glVertex3f( 65,  30,  49);
		gl.glTexCoord2f(0f,0f); gl.glVertex3f( 65,  28,  49);
	gl.glEnd();
gl.glDisable(GL2.GL_TEXTURE_2D);

	gl.glEnable(GL2.GL_TEXTURE_2D);
	brickTexture.bind(gl);
	gl.glBegin(GL2.GL_QUADS);
		gl.glTexCoord2f(0f,2f); gl.glVertex3f( 65,  28,  51);
		gl.glTexCoord2f(3f,2f); gl.glVertex3f( 65,  30,  51);
		gl.glTexCoord2f(3f,0f); gl.glVertex3f( 65,  30,  55);
		gl.glTexCoord2f(0f,0f); gl.glVertex3f( 65,  28,  55);
	gl.glEnd();
gl.glDisable(GL2.GL_TEXTURE_2D);

	gl.glEnable(GL2.GL_TEXTURE_2D);
	brickTexture.bind(gl);
	gl.glBegin(GL2.GL_QUADS);
		gl.glTexCoord2f(0f,2f); gl.glVertex3f( 65,  28,  57);
		gl.glTexCoord2f(3f,2f); gl.glVertex3f( 65,  30,  57);
		gl.glTexCoord2f(3f,0f); gl.glVertex3f( 65,  30,  60);
		gl.glTexCoord2f(0f,0f); gl.glVertex3f( 65,  28,  60);
	gl.glEnd();
gl.glDisable(GL2.GL_TEXTURE_2D);

//_ _ _ _ _ _ _ _ _ _ _ _ _ _ BOTTOM RIGHT COLUMN OF CASTLE _ _ _ _ _ _ _ _ _ _ _ _ _ _

gl.glEnable(GL2.GL_TEXTURE_2D);
  brickTexture.bind(gl);
  gl.glPushMatrix();
  		gl.glTranslatef(65, 0, 35);
  		gl.glRotatef(-90f, 1f, 0f, 0f); // stand upright (Y)
  		glu.gluCylinder(quadric, 5, 5, 32, 20, 1);
  gl.glPopMatrix();		
gl.glDisable(GL2.GL_TEXTURE_2D);

gl.glEnable(GL2.GL_TEXTURE_2D);
brickTexture.bind(gl);
	gl.glPushMatrix();
		gl.glTranslatef(65, 32, 35);
		gl.glRotatef(-90f, 1f, 0f, 0f); // stand upright (Y)
		glu.gluCylinder(quadric, 5.5, .5, 6, 20, 1);	
	gl.glPopMatrix();		
gl.glDisable(GL2.GL_TEXTURE_2D);

//_ _ _ _ _ _ _ _ _ _ _ _ _ _ BOTTOM LEFT COLUMN OF CASTLE _ _ _ _ _ _ _ _ _ _ _ _ _ _

gl.glEnable(GL2.GL_TEXTURE_2D);
brickTexture.bind(gl);
	gl.glPushMatrix();
		gl.glTranslatef(35, 0, 35);
		gl.glRotatef(-90f, 1f, 0f, 0f); // stand upright (Y)
		glu.gluCylinder(quadric, 5, 5, 32, 20, 1);	
	gl.glPopMatrix();		
gl.glDisable(GL2.GL_TEXTURE_2D);

gl.glEnable(GL2.GL_TEXTURE_2D);
brickTexture.bind(gl);
	gl.glPushMatrix();
		gl.glTranslatef(35, 32, 35);
		gl.glRotatef(-90f, 1f, 0f, 0f); // stand upright (Y)
		glu.gluCylinder(quadric, 5.5, .5, 6, 20, 1);	
	gl.glPopMatrix();		
gl.glDisable(GL2.GL_TEXTURE_2D);
		
//_ _ _ _ _ _ _ _ _ _ _ _ _ _ TOP RIGHT COLUMN OF CASTLE _ _ _ _ _ _ _ _ _ _ _ _ _ _

gl.glEnable(GL2.GL_TEXTURE_2D);
brickTexture.bind(gl);
	gl.glPushMatrix();
		gl.glTranslatef(65, 0, 65);
		gl.glRotatef(-90f, 1f, 0f, 0f); // stand upright (Y)
		glu.gluCylinder(quadric, 5, 5, 32, 20, 1);	
	gl.glPopMatrix();		
gl.glDisable(GL2.GL_TEXTURE_2D);

gl.glEnable(GL2.GL_TEXTURE_2D);
brickTexture.bind(gl);
	gl.glPushMatrix();
		gl.glTranslatef(65, 32, 65);
		gl.glRotatef(-90f, 1f, 0f, 0f); // stand upright (Y)
		glu.gluCylinder(quadric, 5.5, .5, 6, 20, 1);	
	gl.glPopMatrix();		
gl.glDisable(GL2.GL_TEXTURE_2D);

//_ _ _ _ _ _ _ _ _ _ _ _ _ _ TOP LEFT COLUMN OF CASTLE _ _ _ _ _ _ _ _ _ _ _ _ _ _

gl.glEnable(GL2.GL_TEXTURE_2D);
brickTexture.bind(gl);
	gl.glPushMatrix();
		gl.glTranslatef(35, 0, 65);
		gl.glRotatef(-90f, 1f, 0f, 0f); // stand upright (Y)
		glu.gluCylinder(quadric, 5, 5, 32, 20, 1);	
	gl.glPopMatrix();		
gl.glDisable(GL2.GL_TEXTURE_2D);

gl.glEnable(GL2.GL_TEXTURE_2D);
brickTexture.bind(gl);
	gl.glPushMatrix();
		gl.glTranslatef(35, 32, 65);
		gl.glRotatef(-90f, 1f, 0f, 0f); // stand upright (Y)
		glu.gluCylinder(quadric, 5.5, .5, 6, 20, 1);	
	gl.glPopMatrix();		
gl.glDisable(GL2.GL_TEXTURE_2D);

//_ _ _ _ _ _ _ _ _ _ _ _ _ _ MOAT AROUND CASTLE _ _ _ _ _ _ _ _ _ _ _ _ _ _
gl.glEnable(GL2.GL_TEXTURE_2D);
	waterTexture.bind(gl);
	gl.glPushMatrix();
		gl.glColor3f(0,1,1);
		gl.glTranslatef(50, .01f, 50);
		gl.glRotatef(-90f, 1f, 0f, 0f); // stand upright (Y)
		glu.gluDisk(quadric, 27, 33, 25, 1); // also to be flipped
	gl.glPopMatrix();
gl.glDisable(GL2.GL_TEXTURE_2D);
//_ _ _ _ _ _ _ _ _ _ _ _ _ _ Draw Bridge _ _ _ _ _ _ _ _ _ _ _ _ _ _

	gl.glEnable(GL2.GL_TEXTURE_2D);
	bridgeTexture.bind(gl);
	gl.glBegin(GL2.GL_QUADS);
		gl.glTexCoord2f(0f,2f); gl.glVertex3f( 55,  .02f,  15);
		gl.glTexCoord2f(3f,2f); gl.glVertex3f( 55, 	.02f,  35);
		gl.glTexCoord2f(3f,0f); gl.glVertex3f( 45,  .02f,  35);
		gl.glTexCoord2f(0f,0f); gl.glVertex3f( 45,  .02f,  15);
	gl.glEnd();
gl.glDisable(GL2.GL_TEXTURE_2D);


	}
}