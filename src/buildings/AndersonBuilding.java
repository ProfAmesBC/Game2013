package buildings;
import game.Building;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;
import com.jogamp.opengl.util.texture.Texture;

public class AndersonBuilding extends Building {
    private Texture andersonYoshi, andersonExterior, andersonBlue, andersonPanel, andersonWood, andersonGrass, andersonCarpet;
    
    public AndersonBuilding(GL2 gl, GLU glu) {
        andersonYoshi = setupTexture(gl,"AndersonYoshi.jpg"); // texture for picture in frame
        andersonExterior = setupTexture(gl,"AndersonExterior.jpg");// texture for exterior walls
        andersonBlue = setupTexture(gl,"AndersonBlue.gif");//wall texture for inside of house
        andersonPanel = setupTexture(gl,"Andersonpanel.jpg");//texture for roof
        andersonWood = setupTexture(gl,"AndersonWood.gif");
        andersonGrass = setupTexture(gl,"Andersongrass.gif");//texture for grass outside
        andersonCarpet = setupTexture(gl,"AndersonCarpet.jpg");//texture for carpet inside house
    }
	
	public void draw(GL2 gl, GLU glu) {
	    gl.glPushMatrix();
	    gl.glTranslatef(0,0,100);
		//chair
		GLUquadric quadric = glu.gluNewQuadric();
		glu.gluQuadricDrawStyle(quadric,  GLU.GLU_FILL);
		glu.gluQuadricNormals(quadric, GLU.GLU_NONE);
		glu.gluQuadricTexture(quadric, false);

		gl.glColor3f(.7f, 0.5f, .5f);//table color
		
		gl.glPushMatrix();
		gl.glTranslatef(50, 0, -50);
		gl.glPushMatrix();
		gl.glRotatef(-90f,1f,0f,0f);
		glu.gluCylinder(quadric, .05, .5, 3., 10,10);//one table leg
		gl.glPopMatrix();
		gl.glPopMatrix();

		gl.glPushMatrix();
		gl.glTranslatef(53, 0, -50);
		gl.glPushMatrix();
		gl.glRotatef(-90f,1f,0f,0f);
		glu.gluCylinder(quadric, .05, .5, 3., 10,10);//two table leg
		gl.glPopMatrix();
		gl.glPopMatrix();

		gl.glPushMatrix();
		gl.glTranslatef(50, 0, -53);
		gl.glPushMatrix();
		gl.glRotatef(-90f,1f,0f,0f);
		glu.gluCylinder(quadric, .05, .5, 3., 10,10);//three table leg
		gl.glPopMatrix();
		gl.glPopMatrix();

		gl.glPushMatrix();
		gl.glTranslatef(53, 0, -53);
		gl.glPushMatrix();
		gl.glRotatef(-90f,1f,0f,0f);
		glu.gluCylinder(quadric, .05, .5, 3., 10,10);//four table leg
		gl.glPopMatrix();
		gl.glPopMatrix();
		
		gl.glBegin(GL2.GL_QUADS);// top of the table 
			gl.glVertex3f(49,3,-49);
			gl.glVertex3f(54,3,-49);
			gl.glVertex3f(54,3,-54);
			gl.glVertex3f(49,3,-54);
		gl.glEnd();
	
		
		gl.glColor3f(0f, 0f, 0f);//black picture frame for picture on back wall
		gl.glBegin(GL2.GL_QUADS);
			gl.glVertex3f(40,10,-79);
			gl.glVertex3f(60,10, -79);
			gl.glVertex3f(60,20,-79);
			gl.glVertex3f(40,20,-79);
		gl.glEnd();
		
		gl.glColor3f(1f,1f,1f);
		//picture for picture frame
		gl.glEnable(GL2.GL_TEXTURE_2D);
        andersonYoshi.bind(gl); // texture for picture in frame

		gl.glBegin(GL2.GL_QUADS);
			gl.glTexCoord2f(0,0);gl.glVertex3f(44,12,-78);
			gl.glTexCoord2f(0,1);gl.glVertex3f(56, 12, -78);
			gl.glTexCoord2f(1,1);gl.glVertex3f(56,18,-78);
			gl.glTexCoord2f(1,0);gl.glVertex3f(44,18,-78);
		gl.glEnd();
		gl.glDisable(GL2.GL_TEXTURE_2D);
		
		
		
		//gl.glColor3f(1f, 1f,1f);
		
		gl.glEnable(GL2.GL_CULL_FACE);
				gl.glEnable(GL2.GL_TEXTURE_2D);
				andersonExterior.bind(gl);// texture for exterior walls
			gl.glBegin(GL2.GL_QUADS);//counterclockwise "front view"
				//front wall
				gl.glTexCoord2f(0f,4f); gl.glVertex3f(20f,12f,-20f);//top
				gl.glTexCoord2f(0f,0f); gl.glVertex3f(80f,12f,-20f);
				gl.glTexCoord2f(4f,0f); gl.glVertex3f(80f,30f,-20f);
				gl.glTexCoord2f(4f,4f); gl.glVertex3f(20f,30f,-20f);
				
				gl.glTexCoord2f(0f,2f); gl.glVertex3f(20f,1f,-20f);//quad left of door(front wall)
				gl.glTexCoord2f(0f,0f); gl.glVertex3f(46f,1f,-20f);
				gl.glTexCoord2f(2f,0f); gl.glVertex3f(46f,12f,-20f);
				gl.glTexCoord2f(2f,2f); gl.glVertex3f(20f,12f,-20f);
				
				gl.glTexCoord2f(0f,2f); gl.glVertex3f(54f,1f,-20f);//quad right of door(front wall)
				gl.glTexCoord2f(0f,0f); gl.glVertex3f(80f,1f,-20f);
				gl.glTexCoord2f(2f,0f); gl.glVertex3f(80f,12f,-20f);
				gl.glTexCoord2f(2f,2f); gl.glVertex3f(54f,12f,-20f);
				
				//Side wall with door
				gl.glTexCoord2f(0f,2f); gl.glVertex3f(20f,12f,-80f); //top quads
				gl.glTexCoord2f(4f,2f); gl.glVertex3f(20f,12f,-20f);
				gl.glTexCoord2f(4f,0f); gl.glVertex3f(20f,30f,-20f);
				gl.glTexCoord2f(0f,0f); gl.glVertex3f(20f,30f,-80f);
				
				gl.glTexCoord2f(0f,2f); gl.glVertex3f(20f,1f,-80f); //left of door
				gl.glTexCoord2f(4f,2f); gl.glVertex3f(20f,1f,-54f);
				gl.glTexCoord2f(4f,0f); gl.glVertex3f(20f,12f,-54f);
				gl.glTexCoord2f(0f,0f); gl.glVertex3f(20f,12f,-80f);
				
				gl.glTexCoord2f(0f,2f); gl.glVertex3f(20f,1f,-46f); //right of door
				gl.glTexCoord2f(4f,2f); gl.glVertex3f(20f,1f,-20f);
				gl.glTexCoord2f(4f,0f); gl.glVertex3f(20f,12f,-20f);
				gl.glTexCoord2f(0f,0f); gl.glVertex3f(20f,12f,-46f);
				
				//Side wall other
				gl.glTexCoord2f(0f,2f); gl.glVertex3f(80f,1f,-20f);
				gl.glTexCoord2f(4f,2f); gl.glVertex3f(80f,1f,-80f);
				gl.glTexCoord2f(4f,0f); gl.glVertex3f(80f,30f,-80f);
				gl.glTexCoord2f(0f,0f); gl.glVertex3f(80f,30f,-20f);
			
				//back wall
				gl.glTexCoord2f(0f,0f); gl.glVertex3f(80f,1f,-80f);//top
				gl.glTexCoord2f(0f,2f); gl.glVertex3f(20f,1f,-80f);
				gl.glTexCoord2f(4f,2f); gl.glVertex3f(20f,30f,-80f);
				gl.glTexCoord2f(4f,0f); gl.glVertex3f(80f,30f,-80f);

				
			gl.glEnd();
				andersonBlue.bind(gl);//wall texture for inside of house
				gl.glBegin(GL2.GL_QUADS);//clockwise "back view"
				// front wall
				gl.glTexCoord2f(0f,2f); gl.glVertex3f(20f,12f,-20f);//top
				gl.glTexCoord2f(4f,2f); gl.glVertex3f(20f,30f,-20f);
				gl.glTexCoord2f(4f,0f); gl.glVertex3f(80f,30f,-20f);
				gl.glTexCoord2f(0f,0f); gl.glVertex3f(80f,12f,-20f);
			
				gl.glTexCoord2f(0f,2f); gl.glVertex3f(20f,1f,-20f);//quad left of door(front wall)
				gl.glTexCoord2f(2f,2f); gl.glVertex3f(20f,12f,-20f);
				gl.glTexCoord2f(2f,0f); gl.glVertex3f(46f,12f,-20f);
				gl.glTexCoord2f(0f,0f); gl.glVertex3f(46f,1f,-20f);
		
				gl.glTexCoord2f(0f,2f); gl.glVertex3f(54f,1f,-20f);//quad right of door(front wall)
				gl.glTexCoord2f(2f,2f); gl.glVertex3f(54f,12f,-20f);
				gl.glTexCoord2f(2f,0f); gl.glVertex3f(80f,12f,-20f);
				gl.glTexCoord2f(0f,0f); gl.glVertex3f(80f,1f,-20f);
				
				//Side wall with door
				gl.glTexCoord2f(0f,2f); gl.glVertex3f(20f,12f,-80f); //top quads
				gl.glTexCoord2f(0f,0f); gl.glVertex3f(20f,30f,-80f);
				gl.glTexCoord2f(4f,0f); gl.glVertex3f(20f,30f,-20f);
				gl.glTexCoord2f(4f,2f); gl.glVertex3f(20f,12f,-20f);
				
				gl.glTexCoord2f(0f,2f); gl.glVertex3f(20f,1f,-80f); //left of door
				gl.glTexCoord2f(0f,0f); gl.glVertex3f(20f,12f,-80f);
				gl.glTexCoord2f(4f,0f); gl.glVertex3f(20f,12f,-54f);
				gl.glTexCoord2f(4f,2f); gl.glVertex3f(20f,1f,-54f);
				
				gl.glTexCoord2f(0f,2f); gl.glVertex3f(20f,1f,-46f); //right of door
				gl.glTexCoord2f(0f,0f); gl.glVertex3f(20f,12f,-46f);
				gl.glTexCoord2f(4f,0f); gl.glVertex3f(20f,12f,-20f);
				gl.glTexCoord2f(4f,2f); gl.glVertex3f(20f,1f,-20f);
				
				//Side wall other
				gl.glTexCoord2f(0f,2f); gl.glVertex3f(80f,1f,-20f);
				gl.glTexCoord2f(0f,0f); gl.glVertex3f(80f,30f,-20f);
				gl.glTexCoord2f(4f,0f); gl.glVertex3f(80f,30f,-80f);
				gl.glTexCoord2f(4f,2f); gl.glVertex3f(80f,1f,-80f);
				
				//back wall
				gl.glTexCoord2f(0f,0f); gl.glVertex3f(80f,1f,-80f);
				gl.glTexCoord2f(4f,0f); gl.glVertex3f(80f,30f,-80f);
				gl.glTexCoord2f(4f,4f); gl.glVertex3f(20f,30f,-80f);
				gl.glTexCoord2f(0f,4f); gl.glVertex3f(20f,1f,-80f);
			gl.glEnd();	
			
				gl.glDisable(GL2.GL_TEXTURE_2D);
				gl.glDisable(GL2.GL_CULL_FACE);
		
				andersonPanel.bind(gl);//texture for roof
				gl.glEnable(GL2.GL_TEXTURE_2D);
		gl.glBegin(GL2.GL_TRIANGLES);//triangle for roof front and back
		
			gl.glTexCoord2f(2f,0f); gl.glVertex3f(20f,30f,-20f);//roof triangles
			gl.glTexCoord2f(0f,0f); gl.glVertex3f(80f,30f,-20f);
			gl.glTexCoord2f(0f,2f); gl.glVertex3f(50f,50f,-20f);
			
			gl.glTexCoord2f(0f,2f); gl.glVertex3f(50f,50f,-80f);
			gl.glTexCoord2f(0f,0f); gl.glVertex3f(80f,30f,-80f);
			gl.glTexCoord2f(2f,0f); gl.glVertex3f(20f,30f,-80f);
			
		gl.glEnd();
				andersonWood.bind(gl);
		gl.glBegin(GL2.GL_QUADS);
			gl.glTexCoord2f(0f,0f); gl.glVertex3f(20f,30f,-20f);//quads for roof
			gl.glTexCoord2f(0f,0f); gl.glVertex3f(20f,30f,-80f);
			gl.glTexCoord2f(5f,5f); gl.glVertex3f(50f,50f,-80f);
			gl.glTexCoord2f(5f,5f); gl.glVertex3f(50f,50f,-20f);
		
			gl.glTexCoord2f(0f,0f); gl.glVertex3f(80f,30f,-20f);
			gl.glTexCoord2f(0f,0f); gl.glVertex3f(80f,30f,-80f);
			gl.glTexCoord2f(5f,5f); gl.glVertex3f(50f,50f,-80f);
			gl.glTexCoord2f(5f,5f); gl.glVertex3f(50f,50f,-20f);
			
			gl.glTexCoord2f(0f,0f); gl.glVertex3f(20f,30f,-20f);
			gl.glTexCoord2f(0f,0f); gl.glVertex3f(80f,30f,-20f);
			gl.glTexCoord2f(5f,5f); gl.glVertex3f(80f,30f,-80f);
			gl.glTexCoord2f(5f,5f); gl.glVertex3f(20f,30f,-80f);
			
		gl.glEnd();
			gl.glDisable(GL2.GL_TEXTURE_2D);
		
			andersonGrass.bind(gl);//texture for grass outside
			gl.glEnable(GL2.GL_TEXTURE_2D);
		gl.glBegin(GL2.GL_QUADS);
			gl.glTexCoord2f(0f,0f); gl.glVertex3f(0f,0f,0f);//grass
			gl.glTexCoord2f(10f,0f); gl.glVertex3f(100f,0f,0f);
			gl.glTexCoord2f(10f,10f); gl.glVertex3f(100f,0f,-100f);
			gl.glTexCoord2f(0f,10f); gl.glVertex3f(0f,0f,-100f);
		gl.glEnd();
	
			andersonCarpet.bind(gl);//texture for carpet inside house
		gl.glBegin(GL2.GL_QUADS);
			gl.glTexCoord2f(0f,0f); gl.glVertex3f(20,1f,-20f);//tile
			gl.glTexCoord2f(30f,0f); gl.glVertex3f(80f,1f,-20f);
			gl.glTexCoord2f(30f,30f); gl.glVertex3f(80f,1f,-80f);
			gl.glTexCoord2f(0f,30f); gl.glVertex3f(20f,1f,-80f);
		gl.glEnd();
			gl.glDisable(GL2.GL_TEXTURE_2D);
		
			
			
		gl.glPopMatrix();
		
		
	}
	 public void drawMoving(GL2 gl, GLU glu, float eyeX, float eyeY, float eyeZ) {
	        // some buildings might need this
	    }

}
