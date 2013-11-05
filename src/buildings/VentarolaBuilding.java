package buildings;

import game.Building;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;

import com.jogamp.opengl.util.texture.Texture;


public class VentarolaBuilding extends Building{
	private GLUquadric quadric;
	private Texture ventarolaGrass;
	private Texture ventarolaWood;
	private Texture ventarolaRock;
	private Texture ventarolaBrick;
	private Texture ventarolaWallPaper;
	private Texture ventarolaMarble;
	private Texture ventarolaPollock;
	
	 public VentarolaBuilding(GL2 gl, GLU glu) {
	        quadric = glu.gluNewQuadric();
	        glu.gluQuadricDrawStyle(quadric, GLU.GLU_FILL); // GLU_POINT, GLU_LINE, GLU_FILL, GLU_SILHOUETTE
	        glu.gluQuadricNormals  (quadric, GLU.GLU_NONE); // GLU_NONE, GLU_FLAT, or GLU_SMOOTH
	        glu.gluQuadricTexture  (quadric, true);        // true to generate texture coordinates
	        ventarolaWood = setupTexture(gl, "wood032.gif");
	        ventarolaGrass = setupTexture(gl, "dgren050.gif");
	        ventarolaRock = setupTexture(gl, "drock084.jpg");
	        ventarolaBrick = setupTexture(gl, "brick039.jpg");
	        ventarolaWallPaper = setupTexture(gl, "paper005.gif");
	        ventarolaMarble = setupTexture(gl, "marb076.jpg");
	        ventarolaPollock = setupTexture(gl, "pollock.jpg");
	    }

	@Override
	public void draw(GL2 gl, GLU glu) {
		
		drawFoundation(gl, glu);
		drawGarage(gl, glu);
		drawRoof(gl, glu);
		drawWalls(gl, glu);
		drawFurniture(gl, glu);
		drawWindows(gl, glu);
		
	}

	public void drawLamp(GL2 gl, GLU glu, float x, float z) {
		gl.glPushMatrix();//hanging lamp
			gl.glRotatef(-90f, 1f, 0f, 0f);
			gl.glTranslated(x, -z, 9);
			gl.glColor3f(.7f, .7f, .7f);
			glu.gluCylinder(quadric, .1, .1, 2, 10, 10);
			glu.gluSphere(quadric, .8, 10, 10);
			gl.glTranslated(0, 0, -1);
			gl.glEnable(GL2.GL_BLEND);
			gl.glBlendFunc(GL2.GL_SRC_ALPHA, GL2.GL_ONE_MINUS_SRC_ALPHA);
			gl.glColor4f(.7f,.1f,.1f, .9f); // dimmer yellow, translucent
			glu.gluCylinder(quadric, 1, 1, 2, 10, 10);
			gl.glDisable(GL2.GL_BLEND);
		gl.glPopMatrix();
	}
	
	public void drawFurniture(GL2 gl, GLU glu) {
		gl.glPushMatrix();
			gl.glColor3f(.5f, .5f, .5f);
			gl.glRotatef(-90f, 1f, 0f, 0f);
			gl.glTranslatef(80, -58, 1);

			
			gl.glColor3f(.7f, .1f, .1f); //ottoman sides
			glu.gluCylinder(quadric, 7, 7, 2, 10, 10);
			glu.gluCylinder(quadric, 4, 4, 4, 10, 10);
			
			gl.glColor3f(.8f, .8f, .8f); //ottoman cushions
			gl.glTranslatef(0, 0, 2);
			glu.gluDisk(quadric, 0, 7, 10, 10);
			gl.glTranslatef(0,0,2);
			glu.gluDisk(quadric, 0, 4, 10, 10);

		gl.glPopMatrix();

		drawLamp(gl, glu, 35, 58);
		drawLamp(gl, glu, 35, 72);
		drawLamp(gl, glu, 50, 58);
		drawLamp(gl, glu, 50, 72);
		drawLamp(gl, glu, 65, 58);
		drawLamp(gl, glu, 65, 72);
		drawLamp(gl, glu, 80, 58);
		drawLamp(gl, glu, 80, 72);
		
		gl.glEnable(GL2.GL_TEXTURE_2D);
		ventarolaPollock.bind(gl);
		gl.glBegin(GL2.GL_QUADS);
			gl.glTexCoord2f(0, 0); gl.glVertex3f(30.05f, 5, 70); //picture
			gl.glTexCoord2f(0, 1); gl.glVertex3f(30.05f, 9, 70);
			gl.glTexCoord2f(1, 1); gl.glVertex3f(30.05f, 9, 60);
			gl.glTexCoord2f(1, 0); gl.glVertex3f(30.05f, 5, 60);
		gl.glEnd();
		gl.glDisable(GL2.GL_TEXTURE_2D);
	}
	
	public void drawWalls(GL2 gl, GLU glu) {
		gl.glEnable(GL2.GL_TEXTURE_2D);
		ventarolaWallPaper.bind(gl);
		gl.glBegin(GL2.GL_QUADS);
			gl.glTexCoord2f(0,0); gl.glVertex3f(30, 8, 30); //right
			gl.glTexCoord2f(0,2); gl.glVertex3f(30, 11, 30);
			gl.glTexCoord2f(8,2); gl.glVertex3f(30, 11, 50);
			gl.glTexCoord2f(8,0); gl.glVertex3f(30, 8, 50);
			
			gl.glTexCoord2f(0,0); gl.glVertex3f(30, 8, 98); //back left
			gl.glTexCoord2f(0,2); gl.glVertex3f(30, 11, 98);
			gl.glTexCoord2f(8,2); gl.glVertex3f(55, 11, 98);
			gl.glTexCoord2f(8,0); gl.glVertex3f(55, 8, 98);
			
			gl.glTexCoord2f(0,0); gl.glVertex3f(55, 4, 98); //back
			gl.glTexCoord2f(0,8); gl.glVertex3f(55, 11, 98);
			gl.glTexCoord2f(8,8); gl.glVertex3f(80, 11, 98);
			gl.glTexCoord2f(8,0); gl.glVertex3f(80, 4, 98);
			
			gl.glTexCoord2f(0,0); gl.glVertex3f(30, 4, 30); //front right
			gl.glTexCoord2f(0,8); gl.glVertex3f(30, 11, 30);
			gl.glTexCoord2f(8,8); gl.glVertex3f(45, 11, 30);
			gl.glTexCoord2f(8,0); gl.glVertex3f(45, 4, 30);
			
			gl.glTexCoord2f(0,0); gl.glVertex3f(45, 8, 30); //front mid
			gl.glTexCoord2f(0,2); gl.glVertex3f(45, 11, 30);
			gl.glTexCoord2f(8,2); gl.glVertex3f(60, 11, 30);
			gl.glTexCoord2f(8,0); gl.glVertex3f(60, 8, 30);
		gl.glEnd();
		gl.glEnable(GL2.GL_CULL_FACE);
		gl.glBegin(GL2.GL_QUADS);
			gl.glTexCoord2f(0,0); gl.glVertex3f(30, 1, 30); //right
			gl.glTexCoord2f(0,2); gl.glVertex3f(30, 1, 50);
			gl.glTexCoord2f(8,2); gl.glVertex3f(30, 4, 50);
			gl.glTexCoord2f(8,0); gl.glVertex3f(30, 4, 30);
		
			gl.glTexCoord2f(0,0); gl.glVertex3f(30, 1, 98); //back
			gl.glTexCoord2f(0,2); gl.glVertex3f(80, 1, 98);
			gl.glTexCoord2f(8,2); gl.glVertex3f(80, 4, 98);
			gl.glTexCoord2f(8,0); gl.glVertex3f(30, 4, 98);
		
			gl.glTexCoord2f(0,0); gl.glVertex3f(30, 1, 30); //front
			gl.glTexCoord2f(0,8); gl.glVertex3f(30, 4, 30);
			gl.glTexCoord2f(8,8); gl.glVertex3f(60, 4, 30);
			gl.glTexCoord2f(8,0); gl.glVertex3f(60, 1, 30);
		gl.glEnd();
		ventarolaMarble.bind(gl);
		gl.glBegin(GL2.GL_QUADS);
			gl.glTexCoord2f(0,0); gl.glVertex3f(30, 1, 30); //right
			gl.glTexCoord2f(0,2); gl.glVertex3f(30, 4, 30);
			gl.glTexCoord2f(8,2); gl.glVertex3f(30, 4, 50);
			gl.glTexCoord2f(8,0); gl.glVertex3f(30, 1, 50);
	
			gl.glTexCoord2f(0,0); gl.glVertex3f(30, 1, 98); //back
			gl.glTexCoord2f(0,2); gl.glVertex3f(30, 4, 98);
			gl.glTexCoord2f(16,2); gl.glVertex3f(80, 4, 98);
			gl.glTexCoord2f(16,0); gl.glVertex3f(80, 1, 98);
	
			gl.glTexCoord2f(0,0); gl.glVertex3f(30, 1, 30); //front
			gl.glTexCoord2f(0,16); gl.glVertex3f(60, 1, 30);
			gl.glTexCoord2f(2,16); gl.glVertex3f(60, 4, 30);
			gl.glTexCoord2f(2,0); gl.glVertex3f(30, 4, 30);
		gl.glEnd();
		gl.glDisable(GL2.GL_CULL_FACE);
		gl.glDisable(GL2.GL_TEXTURE_2D);
	}
	
	public void drawRoof(GL2 gl, GLU glu) {
		gl.glColor3f(.9f, .8f, .8f);
		gl.glBegin(GL2.GL_QUADS);
			gl.glVertex3f(99, 11, 50); //front of garage
			gl.glVertex3f(3, 11, 50);
			gl.glVertex3f(24, 11, 24);
			gl.glVertex3f(99, 11, 24);
			
			gl.glVertex3f(99, 11, 100);//next to garage
			gl.glVertex3f(3, 11, 100);
			gl.glVertex3f(3, 11, 50);
			gl.glVertex3f(99, 11, 50);
			
			gl.glVertex3f(99, 11, 100); //back
			gl.glVertex3f(99, 12, 100);
			gl.glVertex3f(1, 12, 100);
			gl.glVertex3f(3, 11, 100);
			
			gl.glVertex3f(3, 11, 100);//right side
			gl.glVertex3f(1, 12, 100);
			gl.glVertex3f(1, 12, 48);
			gl.glVertex3f(3, 11, 50);
			
			gl.glVertex3f(3, 11, 50);//garage overhang
			gl.glVertex3f(1, 12, 48);
			gl.glVertex3f(22, 12, 22);
			gl.glVertex3f(24, 11, 24);
			
			gl.glVertex3f(24, 11, 24);//front
			gl.glVertex3f(22, 12, 22);
			gl.glVertex3f(99, 12, 22);
			gl.glVertex3f(99, 11, 24);
			
			gl.glVertex3f(99, 11, 24);//left
			gl.glVertex3f(99, 12, 22);
			gl.glVertex3f(99, 12, 100);
			gl.glVertex3f(99, 11, 100);
			
			gl.glVertex3f(99, 12, 100);//top left
			gl.glVertex3f(99, 12, 22);
			gl.glVertex3f(24, 12, 22);
			gl.glVertex3f(24, 12, 100);
			
			gl.glVertex3f(24, 12, 100);//top right
			gl.glVertex3f(24, 12, 22);
			gl.glVertex3f(3, 12, 48);
			gl.glVertex3f(3, 12, 100);
		gl.glEnd();
	}
	
	public void drawWindows(GL2 gl, GLU glu) {
		gl.glPushMatrix();
			gl.glColor3f(.1f, .1f, .1f);
    		gl.glRotatef(-90f, 1f, 0f, 0f);
    		
    		//front pillars
    		gl.glTranslatef(96, -31, 0);
    		glu.gluCylinder(quadric, 2, 3, 11., 10, 10);
    		gl.glTranslatef(-10, 0, 0);
    		glu.gluCylinder(quadric, 2, 3, 11., 10, 10);
    		gl.glTranslatef(-10, 0, 0);
    		glu.gluCylinder(quadric, 2, 3, 11., 10, 10);
    		gl.glTranslatef(-16, 0, 0);
    		glu.gluCylinder(quadric, 2, 3, 11., 10, 10);
    		gl.glTranslatef(-15, 0, 0);
    		glu.gluCylinder(quadric, 2, 3, 11., 10, 10);
    		gl.glTranslatef(-14, 0, 0);
    		glu.gluCylinder(quadric, 2, 3, 11., 10, 10);
    		//right pillars
    		gl.glTranslatef(0, -19, 0);
    		glu.gluCylinder(quadric, 2, 3, 11., 10, 10);
    		gl.glTranslatef(0, -47, 0);
    		glu.gluCylinder(quadric, 2, 3, 11., 10, 10);
    		//back pillars
    		gl.glTranslatef(25, 0, 0);
    		glu.gluCylinder(quadric, 2, 3, 11., 10, 10);
    		gl.glTranslatef(25, 0, 0);
    		glu.gluCylinder(quadric, 2, 3, 11., 10, 10);
    		gl.glTranslatef(15, 0, 0);
    		glu.gluCylinder(quadric, 2, 3, 11., 10, 10);
    		//left pillars
    		gl.glTranslatef(0, 22, 0);
    		glu.gluCylinder(quadric, 2, 3, 11., 10, 10);
    		gl.glTranslatef(0, 22, 0);
    		glu.gluCylinder(quadric, 2, 3, 11., 10, 10);
    	gl.glPopMatrix();
    	gl.glBegin(GL2.GL_QUADS);
    	
    		gl.glVertex3f(66, 1, 30);//right of door
    		gl.glVertex3f(66, 10, 30);
    		gl.glVertex3f(65, 10, 30);
    		gl.glVertex3f(65, 1, 30);
	
    		gl.glVertex3f(70, 1, 30);//left of door
    		gl.glVertex3f(70, 10, 30);
			gl.glVertex3f(71, 10, 30);
			gl.glVertex3f(71, 1, 30);
			
			gl.glVertex3f(75, 10, 30);//above door
			gl.glVertex3f(75, 11, 30);
			gl.glVertex3f(60, 11, 30);
			gl.glVertex3f(60, 10, 30);
    	
    	gl.glEnd();
		gl.glEnable(GL2.GL_BLEND);
        	gl.glBlendFunc(GL2.GL_SRC_ALPHA, GL2.GL_ONE_MINUS_SRC_ALPHA);
        	gl.glColor4f(.9f,.9f,.7f, .3f); // dimmer yellow, translucent
        	gl.glBegin(GL2.GL_QUADS);	
        	
        		gl.glVertex3f(65, 1, 30);//right of door
        		gl.glVertex3f(65, 10, 30);
        		gl.glVertex3f(60, 10, 30);
        		gl.glVertex3f(60, 1, 30);
    		
        		gl.glVertex3f(75, 1, 30);//left of door
        		gl.glVertex3f(75, 10, 30);
        		gl.glVertex3f(71, 10, 30);
        		gl.glVertex3f(71, 1, 30);
        	
        		gl.glVertex3f(30, 8, 98); //back right
        		gl.glVertex3f(55, 8, 98);
        		gl.glVertex3f(55, 4, 98);
        		gl.glVertex3f(30, 4, 98);
        		
        		gl.glVertex3f(30, 4, 32); //right
        		gl.glVertex3f(30, 4, 48);
        		gl.glVertex3f(30, 8, 48);
        		gl.glVertex3f(30, 8, 32);
        		
        		gl.glVertex3f(45, 8, 30); //front right
        		gl.glVertex3f(60, 8, 30);
        		gl.glVertex3f(60, 4, 30);
        		gl.glVertex3f(45, 4, 30);
        		
        		gl.glVertex3f(65, 1, 30);//right of door
        		gl.glVertex3f(65, 8, 30);
        		gl.glVertex3f(60, 8, 30);
        		gl.glVertex3f(60, 1, 30);
        		
        		gl.glVertex3f(75, 1, 30);//left of door
        		gl.glVertex3f(75, 8, 30);
        		gl.glVertex3f(71, 8, 30);
        		gl.glVertex3f(71, 1, 30);
        		
        		gl.glVertex3f(80, 1, 98); //back left
        		gl.glVertex3f(95, 1, 98);
        		gl.glVertex3f(95, 11, 98);
        		gl.glVertex3f(80, 11, 98);
    		
        		gl.glVertex3f(97, 1, 32); //left
        		gl.glVertex3f(97, 1, 96);
        		gl.glVertex3f(97, 11, 96);
        		gl.glVertex3f(97, 11, 32);
        		
        		gl.glVertex3f(75, 11, 30); //front left
        		gl.glVertex3f(95, 11, 30);
        		gl.glVertex3f(95, 1, 30);
        		gl.glVertex3f(75, 1, 30);
        		
        	gl.glEnd();
        gl.glDisable(GL2.GL_BLEND);
	}
	
	public void drawGarage(GL2 gl, GLU glu) {
		gl.glColor3f(0, .2f, .3f);
		gl.glPushMatrix();
			gl.glRotatef(-90f, 1f, 0f, 0f); // stand upright (Y)
			gl.glTranslatef(27, -95, 0);
			gl.glColor3f(.3f, .2f, .3f);
			glu.gluCylinder(quadric, 3., 3, 11., 10, 10); //boiler
			gl.glColor3f(.5f, .3f, .1f);
			gl.glTranslatef(-4, -1.5f, 0);
			glu.gluCylinder(quadric, .25, .25, 4., 6, 10); //table legs
			gl.glTranslatef(-8, 0, 0);
			glu.gluCylinder(quadric, .25, .25, 4., 6, 10);
			gl.glTranslated(0, 3, 0);
			glu.gluCylinder(quadric, .25, .25, 4., 6, 10);
			gl.glTranslated(8, 0, 0);
			glu.gluCylinder(quadric, .25, .25, 4., 6, 10);
		gl.glPopMatrix();
		
		gl.glEnable(GL2.GL_TEXTURE_2D);
		ventarolaBrick.bind(gl);
		gl.glBegin(GL2.GL_QUADS);
			gl.glTexCoord2f(0,0); gl.glVertex3f(5,0,98); //right wall
			gl.glTexCoord2f(8,0); gl.glVertex3f(5,11,98);
			gl.glTexCoord2f(8,32); gl.glVertex3f(5,11,50);
			gl.glTexCoord2f(0,32); gl.glVertex3f(5,0,50);
			
			gl.glTexCoord2f(0,0); gl.glVertex3f(30,0,98); //back wall
			gl.glTexCoord2f(8,0); gl.glVertex3f(30,11,98);
			gl.glTexCoord2f(8,16); gl.glVertex3f(5,11,98);
			gl.glTexCoord2f(0,16); gl.glVertex3f(5,0,98);
		gl.glEnd();
		
		gl.glEnable(GL2.GL_CULL_FACE);
		gl.glBegin(GL2.GL_QUADS);	
			gl.glTexCoord2f(0,0); gl.glVertex3f(30,0,90); //house wall 1 back
			gl.glTexCoord2f(0,6); gl.glVertex3f(30,0,98);
			gl.glTexCoord2f(8,6); gl.glVertex3f(30,11,98);
			gl.glTexCoord2f(8,0); gl.glVertex3f(30,11,90);
			
			gl.glTexCoord2f(0,0); gl.glVertex3f(30,8,86); //house wall 2 back
			gl.glTexCoord2f(0,4); gl.glVertex3f(30,8,90);
			gl.glTexCoord2f(2.2f,4); gl.glVertex3f(30,11,90);
			gl.glTexCoord2f(2.2f,0); gl.glVertex3f(30,11,86);
		
			gl.glTexCoord2f(0,0); gl.glVertex3f(30,0,50); //house wall 3 back
			gl.glTexCoord2f(0,32); gl.glVertex3f(30,0,86);
			gl.glTexCoord2f(8,32); gl.glVertex3f(30,11,86);
			gl.glTexCoord2f(8,0); gl.glVertex3f(30,11,50);
			
			gl.glTexCoord2f(0,0); gl.glVertex3f(5,10.95f,50); //garage roof
			gl.glTexCoord2f(0,16); gl.glVertex3f(30,10.95f,50);
			gl.glTexCoord2f(32,16); gl.glVertex3f(30,10.95f,98);
			gl.glTexCoord2f(32,0); gl.glVertex3f(5,10.95f,98);
		gl.glEnd();
		ventarolaWallPaper.bind(gl);
		gl.glBegin(GL2.GL_QUADS);	
			gl.glTexCoord2f(0,8); gl.glVertex3f(30,4,90); //house wall 1 top
			gl.glTexCoord2f(6,8); gl.glVertex3f(30,11,90);
			gl.glTexCoord2f(6,0); gl.glVertex3f(30,11,98);
			gl.glTexCoord2f(0,0); gl.glVertex3f(30,4,98);
			
			gl.glTexCoord2f(0,2.2f); gl.glVertex3f(30,8,86); //house wall 2
			gl.glTexCoord2f(4,2.2f); gl.glVertex3f(30,11,86);
			gl.glTexCoord2f(4,0); gl.glVertex3f(30,11,90);
			gl.glTexCoord2f(0,0); gl.glVertex3f(30,8,90);
			
			gl.glTexCoord2f(0,32); gl.glVertex3f(30,4,50); //house wall 3 top
			gl.glTexCoord2f(8,32); gl.glVertex3f(30,11,50);
			gl.glTexCoord2f(8,0); gl.glVertex3f(30,11,86);
			gl.glTexCoord2f(0,0); gl.glVertex3f(30,4,86);
		gl.glEnd();
		ventarolaMarble.bind(gl);
		gl.glBegin(GL2.GL_QUADS);
			gl.glTexCoord2f(0,4); gl.glVertex3f(30,1,90); //house wall 1 bottom
			gl.glTexCoord2f(2,4); gl.glVertex3f(30,4,90);
			gl.glTexCoord2f(2,0); gl.glVertex3f(30,4,98);
			gl.glTexCoord2f(0,0); gl.glVertex3f(30,1,98);
			
			gl.glTexCoord2f(0,16); gl.glVertex3f(30,1,50); //house wall 3 bottom
			gl.glTexCoord2f(2,16); gl.glVertex3f(30,4,50);
			gl.glTexCoord2f(2,0); gl.glVertex3f(30,4,86);
			gl.glTexCoord2f(0,0); gl.glVertex3f(30,1,86);
		gl.glEnd();
		ventarolaWood.bind(gl);
		gl.glBegin(GL2.GL_QUADS);
			gl.glTexCoord2f(0,0); gl.glVertex3f(5,11,50); //garage roof
			gl.glTexCoord2f(0,32); gl.glVertex3f(5,11,98);
			gl.glTexCoord2f(8,32); gl.glVertex3f(30,11,98);
			gl.glTexCoord2f(8,0); gl.glVertex3f(30,11,50);
			
			gl.glTexCoord2f(0,0); gl.glVertex3f(14.5f,4,93f); //table
			gl.glTexCoord2f(0,8); gl.glVertex3f(14.5f,4,97f);
			gl.glTexCoord2f(4,8); gl.glVertex3f(23.5f,4,97f);
			gl.glTexCoord2f(4,0); gl.glVertex3f(23.5f, 4, 93f);
		gl.glEnd();
		gl.glDisable(GL2.GL_CULL_FACE);
		gl.glDisable(GL2.GL_TEXTURE_2D);
	}
	
	public void drawFoundation(GL2 gl, GLU glu) {
		
		gl.glEnable(GL2.GL_TEXTURE_2D);
		ventarolaGrass.bind(gl);             
        gl.glBegin(GL2.GL_QUADS); //ground
        	gl.glTexCoord2f(0, 0); gl.glVertex3f(0,  0, 100);
            gl.glTexCoord2f(32, 0); gl.glVertex3f(100,  0, 100);
            gl.glTexCoord2f(32, 32); gl.glVertex3f(100, 0, 0);
            gl.glTexCoord2f(0, 32); gl.glVertex3f(0, 0, 0);
        gl.glEnd();
        
        ventarolaWood.bind(gl);
        gl.glBegin(GL2.GL_QUADS); //1st floor
    		gl.glTexCoord2f(0, 0); gl.glVertex3f(30,  1, 98);
    		gl.glTexCoord2f(32, 0); gl.glVertex3f(97,  1, 98);
    		gl.glTexCoord2f(32, 8); gl.glVertex3f(97, 1, 30);
    		gl.glTexCoord2f(0, 8); gl.glVertex3f(30, 1, 30);
    	gl.glEnd();
    	
    	gl.glBegin(GL2.GL_QUADS); //stairs to house (top)		
			gl.glTexCoord2f(0, 0); gl.glVertex3f(66, 1, 30); //front
			gl.glTexCoord2f(2, 0); gl.glVertex3f(66, 0, 25);
			gl.glTexCoord2f(2, 1); gl.glVertex3f(70, 0, 25);
			gl.glTexCoord2f(0, 1); gl.glVertex3f(70, 1, 30);    
			
			gl.glTexCoord2f(0, 0); gl.glVertex3f(25, 0, 90); //garage
			gl.glTexCoord2f(0, 1); gl.glVertex3f(25, 0, 86);
			gl.glTexCoord2f(2, 1); gl.glVertex3f(30, 1, 86);
			gl.glTexCoord2f(2, 0); gl.glVertex3f(30, 1, 90); 
		gl.glEnd();
    	
    	ventarolaRock.bind(gl);
        gl.glBegin(GL2.GL_QUADS); //foundation
    		gl.glTexCoord2f(0, 0); gl.glVertex3f(30,  1, 30);
    		gl.glTexCoord2f(32, 0); gl.glVertex3f(97,  1, 30);
    		gl.glTexCoord2f(32, 1); gl.glVertex3f(97, 0, 30);
    		gl.glTexCoord2f(0, 1); gl.glVertex3f(30, 0, 30);
    		
    		gl.glTexCoord2f(0, 0); gl.glVertex3f(97,  0, 98);
    		gl.glTexCoord2f(1, 0); gl.glVertex3f(97,  1, 98);
    		gl.glTexCoord2f(1, 16); gl.glVertex3f(97, 1, 30);
    		gl.glTexCoord2f(0, 16); gl.glVertex3f(97, 0, 30);
    		
    		gl.glTexCoord2f(0, 0); gl.glVertex3f(30,  0, 50);
    		gl.glTexCoord2f(1, 0); gl.glVertex3f(30,  1, 50);
    		gl.glTexCoord2f(1, 16); gl.glVertex3f(30, 1, 30);
    		gl.glTexCoord2f(0, 16); gl.glVertex3f(30, 0, 30);
    		
    		gl.glTexCoord2f(0, 0); gl.glVertex3f(30,  1, 98);
    		gl.glTexCoord2f(32, 0); gl.glVertex3f(97,  1, 98);
    		gl.glTexCoord2f(32, 1); gl.glVertex3f(97, 0, 98);
    		gl.glTexCoord2f(0, 1); gl.glVertex3f(30, 0, 98);
    	gl.glEnd();
    	
    	gl.glBegin(GL2.GL_TRIANGLES); //stairs to house (sides)
    		gl.glVertex3f(70, 0, 30);
    		gl.glVertex3f(70, 0, 25);
    		gl.glVertex3f(70, 1, 30);
    		
    		gl.glVertex3f(66, 0, 30);
    		gl.glVertex3f(66, 0, 25);
    		gl.glVertex3f(66, 1, 30);
    		
    		gl.glVertex3f(30, 0, 90);
    		gl.glVertex3f(25, 0, 90);
    		gl.glVertex3f(30, 1, 90);
    		
    		gl.glVertex3f(30, 0, 86);
    		gl.glVertex3f(25, 0, 86);
    		gl.glVertex3f(30, 1, 86);
    	gl.glEnd();
    	gl.glDisable(GL2.GL_TEXTURE_2D);
	}

}
