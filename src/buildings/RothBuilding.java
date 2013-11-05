package buildings;
//Steven Roth
import game.Building;

import javax.media.opengl.glu.GLU;

import com.jogamp.opengl.util.texture.*;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLUquadric;

public class RothBuilding extends Building{
	private GLUquadric quadric;
	//Textures
	private Texture brickTexture, indoorTexture, grassTexture, woodTexture, lightTexture;
	
	
	//constructor
	public RothBuilding(GL2 gl, GLU glu){
		//quadric
		quadric = glu.gluNewQuadric();
		glu.gluQuadricDrawStyle(quadric, GLU.GLU_FILL); // GLU_POINT, GLU_LINE, GLU_FILL, GLU_SILHOUETTE
        glu.gluQuadricNormals  (quadric, GLU.GLU_NONE); // GLU_NONE, GLU_FLAT, or GLU_SMOOTH
        glu.gluQuadricTexture  (quadric, true);        // true to generate texture coordinates
		
        //getTextures
		brickTexture = setupTexture(gl, "bricks.jpg"); // TODO missing
		indoorTexture = setupTexture(gl, "indoor.gif");
		grassTexture = setupTexture(gl, "grass.gif");
		woodTexture = setupTexture(gl, "wood.gif");
		lightTexture = setupTexture(gl, "light.gif");
	}
	
	//initial eye location

	@Override
	public void draw(GL2 gl, GLU glu) {
		//draw land
		drawGround(gl);
		
		gl.glEnable(GL2.GL_CULL_FACE);
			gl.glPushMatrix();
				gl.glEnable(GL2.GL_TEXTURE_2D);
		
		
		drawFrontWall(gl);
		
		drawRearWall(gl);
		
		
		drawRightWall(gl);
		
		
		drawLeftWall(gl);
		
		
		drawRoof(gl);
		
		
		drawTable(gl, glu);
		
		
		//draw light
		drawLight(gl, glu);
		
		//draw exit sign 1
		
		//draw exit sign 2
		gl.glDisable(GL2.GL_TEXTURE_2D);
		gl.glPopMatrix();
		gl.glDisable(GL2.GL_CULL_FACE);
	}
	
	public void drawGround(GL2 gl){
		//manual
		
		/*grassTexture.bind(gl);
		gl.glBegin(GL2.GL_QUADS);
			// ccw as viewed from front
			gl.glTexCoord2f(0f, 2f); gl.glVertex3f(-50,  0,   50); //left back
			gl.glTexCoord2f(3f, 2f); gl.glVertex3f(-50,  0,  -50); //left front
			gl.glTexCoord2f(3f, 0f); gl.glVertex3f( 50,  0,   50); //right back
			gl.glTexCoord2f(0f, 0f); gl.glVertex3f( 50,  0,  -50); //right front
		gl.glEnd();*/
		
		//automatic
		
		gl.glEnable(GL2.GL_TEXTURE_2D);
        grassTexture.bind(gl);
        gl.glEnable(GL2.GL_TEXTURE_GEN_S);
        gl.glEnable(GL2.GL_TEXTURE_GEN_T);
            gl.glTexGeni(GL2.GL_S, GL2.GL_TEXTURE_GEN_MODE, GL2.GL_OBJECT_LINEAR);
            gl.glTexGeni(GL2.GL_T, GL2.GL_TEXTURE_GEN_MODE, GL2.GL_OBJECT_LINEAR);
            float[] coef_s = {.5f,0,0,0};
            gl.glTexGenfv(GL2.GL_S, GL2.GL_OBJECT_PLANE, coef_s, 0);
            float[] coef_t = {0,.25f,0,0};
            gl.glTexGenfv(GL2.GL_T, GL2.GL_OBJECT_PLANE, coef_t, 0);
            gl.glBegin(GL2.GL_QUADS);
	            gl.glVertex3f(0,  0,   0); //left front
				gl.glVertex3f(0,  0,  100); //left back
				gl.glVertex3f(100,  0,   100); //right back
				gl.glVertex3f( 100,  0,  0); //right front
            gl.glEnd();
        gl.glDisable(GL2.GL_TEXTURE_2D);
        gl.glDisable(GL2.GL_TEXTURE_GEN_S);
        gl.glDisable(GL2.GL_TEXTURE_GEN_T);
	}
	
	public void drawLight(GL2 gl, GLU glu){
		lightTexture.bind(gl);
		gl.glPushMatrix();
        	gl.glTranslatef(50, 9, 50); // 9 feet off of ground
        	gl.glColor3f(1,1,0); // yellow
        	glu.gluSphere(quadric, 1., 10, 10); // bulb
        gl.glPopMatrix();
	}
	
	
	public void drawFrontWall(GL2 gl){
		
		//brick texture
		
		
		//all labels if facing house from exterior
		
				//left panel
				brickTexture.bind(gl);
				
				gl.glBegin(GL2.GL_QUADS);
					// ccw as viewed from front
					gl.glTexCoord2f(0f, 2f); gl.glVertex3f(40,  0,  40);
					gl.glTexCoord2f(3f, 2f); gl.glVertex3f(40,  10,  40);
					gl.glTexCoord2f(3f, 0f); gl.glVertex3f(48,  10,  40);
					gl.glTexCoord2f(0f, 0f); gl.glVertex3f(48,  0,  40);
				gl.glEnd();
				
				indoorTexture.bind(gl);
				gl.glBegin(GL2.GL_QUADS);
					// ccw as viewed from front
					gl.glTexCoord2f(0f, 0f); gl.glVertex3f(40,  0,  40);
					gl.glTexCoord2f(0f, 1f); gl.glVertex3f(48,  0,  40);
					gl.glTexCoord2f(1f, 1f); gl.glVertex3f(48,  10, 40);
					gl.glTexCoord2f(1f, 0f); gl.glVertex3f(40,  10,  40);
				gl.glEnd();
				
				//top panel (above door)
				brickTexture.bind(gl);
				
				gl.glBegin(GL2.GL_QUADS);
					// ccw as viewed from front
					gl.glTexCoord2f(0f, 2f); gl.glVertex3f(48,   7,  40);
					gl.glTexCoord2f(3f, 2f); gl.glVertex3f(48,   10, 40);
					gl.glTexCoord2f(3f, 0f); gl.glVertex3f(52,  10,  40);
					gl.glTexCoord2f(0f, 0f); gl.glVertex3f(52,  7,  40);
				gl.glEnd();
				
				indoorTexture.bind(gl);
				gl.glBegin(GL2.GL_QUADS);
					// ccw as viewed from front
					gl.glTexCoord2f(0f, 0f); gl.glVertex3f(48,   7,  40);
					gl.glTexCoord2f(0f, 1f); gl.glVertex3f(52,  7,  40);
					gl.glTexCoord2f(1f, 1f); gl.glVertex3f(52,  10,  40);
					gl.glTexCoord2f(1f, 0f); gl.glVertex3f(48,   10,  40);
				gl.glEnd();
				
				//right panel
				brickTexture.bind(gl);
				
				gl.glBegin(GL2.GL_QUADS);
				// ccw as viewed from front
					gl.glTexCoord2f(0f, 2f); gl.glVertex3f(52,   0,  40);
					gl.glTexCoord2f(3f, 2f); gl.glVertex3f(52,   10,  40);
					gl.glTexCoord2f(3f, 0f); gl.glVertex3f(60,  10,  40);
					gl.glTexCoord2f(0f, 0f); gl.glVertex3f(60,  0,  40);
				gl.glEnd();
				
				indoorTexture.bind(gl);
				gl.glBegin(GL2.GL_QUADS);
					// ccw as viewed from front
					gl.glTexCoord2f(0f, 0f); gl.glVertex3f(52,   0,  40);
					gl.glTexCoord2f(0f, 1f); gl.glVertex3f(60,  0,  40);
					gl.glTexCoord2f(1f, 1f); gl.glVertex3f(60,  10,  40);
					gl.glTexCoord2f(1f, 0f); gl.glVertex3f(52,   10,  40);
				gl.glEnd();
		
	}
	
	public void drawRearWall(GL2 gl){
		
		//brick texture
		
		//all labels if facing house from exterior
		
		//left panel
		brickTexture.bind(gl);
		
		gl.glBegin(GL2.GL_QUADS);
			// ccw as viewed from front
			gl.glTexCoord2f(0f, 0f); gl.glVertex3f(40,  0,  60);
			gl.glTexCoord2f(0f, 1f); gl.glVertex3f(48,  0,  60);
			gl.glTexCoord2f(1f, 1f); gl.glVertex3f(48,  10,  60);
			gl.glTexCoord2f(1f, 0f); gl.glVertex3f(40,  10,  60);
		gl.glEnd();
		
		indoorTexture.bind(gl);
		gl.glBegin(GL2.GL_QUADS);
			// ccw as viewed from front
			
			gl.glTexCoord2f(0f, 2f); gl.glVertex3f(40,  0,  60);
			gl.glTexCoord2f(3f, 2f); gl.glVertex3f(40,  10,  60);
			gl.glTexCoord2f(3f, 0f); gl.glVertex3f(48,  10,  60);
			gl.glTexCoord2f(0f, 0f); gl.glVertex3f(48,  0,  60);
		gl.glEnd();
		
		//top panel (above door)
		brickTexture.bind(gl);
		
		gl.glBegin(GL2.GL_QUADS);
			// ccw as viewed from front
			gl.glTexCoord2f(0f, 0f); gl.glVertex3f(48,   7,  60);
			gl.glTexCoord2f(0f, 1f); gl.glVertex3f(52,  7,  60);
			gl.glTexCoord2f(1f, 1f); gl.glVertex3f(52,  10,  60);
			gl.glTexCoord2f(1f, 0f); gl.glVertex3f(48,   10,  60);
		gl.glEnd();
		
		indoorTexture.bind(gl);
		gl.glBegin(GL2.GL_QUADS);
			// ccw as viewed from front
			gl.glTexCoord2f(0f, 2f); gl.glVertex3f(48,   7,  60);
			gl.glTexCoord2f(3f, 2f); gl.glVertex3f(48,   10, 60);
			gl.glTexCoord2f(3f, 0f); gl.glVertex3f(52,  10,  60);
			gl.glTexCoord2f(0f, 0f); gl.glVertex3f(52,  7,  60);
		
		
		gl.glEnd();
		
		//right panel
		brickTexture.bind(gl);
		
		gl.glBegin(GL2.GL_QUADS);
		// ccw as viewed from front
			gl.glTexCoord2f(0f, 0f); gl.glVertex3f(52,   0,  60);
			gl.glTexCoord2f(0f, 1f); gl.glVertex3f(60,  0,  60);
			gl.glTexCoord2f(1f, 1f); gl.glVertex3f(60,  10,  60);
			gl.glTexCoord2f(1f, 0f); gl.glVertex3f(52,   10,  60);
		gl.glEnd();
		
		indoorTexture.bind(gl);
		gl.glBegin(GL2.GL_QUADS);
			// ccw as viewed from front
			
			
			gl.glTexCoord2f(0f, 2f); gl.glVertex3f(52,   0,  60);
			gl.glTexCoord2f(3f, 2f); gl.glVertex3f(52,   10,  60);
			gl.glTexCoord2f(3f, 0f); gl.glVertex3f(60,  10,  60);
			gl.glTexCoord2f(0f, 0f); gl.glVertex3f(60,  0,  60);
		gl.glEnd();
		
	}
	
public void drawLeftWall(GL2 gl){
	
	brickTexture.bind(gl);
	
	gl.glBegin(GL2.GL_QUADS);
		// ccw as viewed from front
		
		gl.glTexCoord2f(0f, 2f); gl.glVertex3f(60,  0,  40);
		gl.glTexCoord2f(3f, 2f); gl.glVertex3f(60,  10,  40);
		gl.glTexCoord2f(3f, 0f); gl.glVertex3f(60,  10,  60);
		gl.glTexCoord2f(0f, 0f); gl.glVertex3f(60,  0,  60);
	gl.glEnd();
	
	indoorTexture.bind(gl);
	gl.glBegin(GL2.GL_QUADS);
		// ccw as viewed from front
	gl.glTexCoord2f(0f, 2f); gl.glVertex3f(60,  0,  40);
	gl.glTexCoord2f(0f, 0f); gl.glVertex3f(60,  0,  60);
	gl.glTexCoord2f(3f, 2f); gl.glVertex3f(60,  10,  60);
	gl.glTexCoord2f(3f, 0f); gl.glVertex3f(60,  10,  40);
		
		
	gl.glEnd();
		
	}

public void drawRightWall(GL2 gl){

	//left wall
	brickTexture.bind(gl);
	
	gl.glBegin(GL2.GL_QUADS);
		// ccw as viewed from front
		gl.glTexCoord2f(0f, 2f); gl.glVertex3f(40,  0,  40);
		gl.glTexCoord2f(0f, 0f); gl.glVertex3f(40,  0,  60);
		gl.glTexCoord2f(3f, 2f); gl.glVertex3f(40,  10,  60);
		gl.glTexCoord2f(3f, 0f); gl.glVertex3f(40,  10,  40);
	gl.glEnd();
	
	indoorTexture.bind(gl);
	gl.glBegin(GL2.GL_QUADS);
		// ccw as viewed from front
		
		gl.glTexCoord2f(0f, 2f); gl.glVertex3f(40,  0,  40);
		gl.glTexCoord2f(3f, 2f); gl.glVertex3f(40,  10,  40);
		gl.glTexCoord2f(3f, 0f); gl.glVertex3f(40,  10,  60);
		gl.glTexCoord2f(0f, 0f); gl.glVertex3f(40,  0,  60);
		
	gl.glEnd();
	
}

public void drawRoof(GL2 gl){
	
	
	
	//roof
	brickTexture.bind(gl);
	
	gl.glBegin(GL2.GL_QUADS);
		// ccw as viewed from front
		gl.glTexCoord2f(0f, 2f); gl.glVertex3f(40,  10,  40);
		gl.glTexCoord2f(3f, 2f); gl.glVertex3f(40,  10,  60);
		gl.glTexCoord2f(3f, 0f); gl.glVertex3f(60,  10,  60);
		gl.glTexCoord2f(0f, 0f); gl.glVertex3f(60,  10,  40);
	gl.glEnd();
	
	indoorTexture.bind(gl);
	gl.glBegin(GL2.GL_QUADS);
		// ccw as viewed from front
		gl.glTexCoord2f(0f, 0f); gl.glVertex3f(60,  10,  40);
		gl.glTexCoord2f(0f, 1f); gl.glVertex3f(60,  10,  60);
		gl.glTexCoord2f(1f, 1f); gl.glVertex3f(40,  10,  60);
		gl.glTexCoord2f(1f, 0f); gl.glVertex3f(40,  10,  40);
	gl.glEnd();
}

public void drawTable(GL2 gl, GLU glu){
	
	woodTexture.bind(gl);
	gl.glBegin(GL2.GL_QUADS);
		// ccw as viewed from front
		gl.glTexCoord2f(0f, 2f); gl.glVertex3f(48,  3,  48);
		gl.glTexCoord2f(3f, 2f); gl.glVertex3f(48,  3,  52);
		gl.glTexCoord2f(3f, 0f); gl.glVertex3f(52,  3,  52);
		gl.glTexCoord2f(0f, 0f); gl.glVertex3f(52,  3,  48);
	gl.glEnd();
	
	gl.glPushMatrix();
		gl.glTranslatef(50, 0, 50); // 9 feet off of ground
		gl.glRotatef(-90f, 1f, 0f, 0f); // stand upright (Y)
		gl.glColor3f(1,1,1);
		glu.gluCylinder(quadric, 1.5, .3, .5, 10, 10); // table
	gl.glPopMatrix();
	
	gl.glPushMatrix();
		gl.glTranslatef(50, 0, 50); // 9 feet off of ground
		gl.glRotatef(-90f, 1f, 0f, 0f); // stand upright (Y)
		gl.glColor3f(1,1,1);
		glu.gluCylinder(quadric, .3, .3, 3, 10, 10); // table
	gl.glPopMatrix();
	
	
	
}
	
}
