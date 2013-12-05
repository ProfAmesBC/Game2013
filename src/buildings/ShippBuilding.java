package buildings;

import game.Building;
import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;
import java.awt.Font;
import com.jogamp.opengl.util.awt.TextRenderer;
import com.jogamp.opengl.util.texture.Texture;

public class ShippBuilding extends Building {

	private GLUquadric quadric;
	private Texture sidewalk, bruins, wood, tree, garden, bruinsWalls, ceiling, 
				sideWalls, black, red, blue, net, jumbo1, jumbo2, water, white;
	private TextRenderer renderer;
	private int fontSize = 88;
	private int frames;

	public ShippBuilding(GL2 gl, GLU glu) {
		quadric = glu.gluNewQuadric();
        glu.gluQuadricDrawStyle(quadric, GLU.GLU_FILL); // GLU_POINT, GLU_LINE, GLU_FILL, GLU_SILHOUETTE
        glu.gluQuadricNormals  (quadric, GLU.GLU_NONE); // GLU_NONE, GLU_FLAT, or GLU_SMOOTH
        glu.gluQuadricTexture  (quadric, true);        // false, or true to generate texture coordinates
        
		net			= setupTexture(gl, "ShippNet.png");
		sidewalk 	= setupTexture(gl, "ShippSidewalk.jpg");
		bruins 		= setupTexture(gl, "ShippSpokedB.png");
		bruinsWalls	= setupTexture(gl, "ShippBruins.gif");
		wood 		= setupTexture(gl, "ShippWood.jpg");
		tree 		= setupTexture(gl, "ShippTree.jpg");
		garden		= setupTexture(gl, "ShippGardenExterior.jpg");
		ceiling		= setupTexture(gl, "ShippCeiling.png");
		sideWalls	= setupTexture(gl, "ShippWallGradient.png");
		black		= setupTexture(gl, "ShippBlack.png");
		red			= setupTexture(gl, "ShippRed.png");
		blue		= setupTexture(gl, "ShippBlue.png");
		jumbo1		= setupTexture(gl, "ShippJumbotron1.png");
		jumbo2		= setupTexture(gl, "ShippJumbotron2.jpg");
		water		= setupTexture(gl, "ShippWater.jpg");
		white		= setupTexture(gl, "ShippWhite.png");
		
		frames = 0;
		
		renderer = new TextRenderer(new Font("SansSerif", Font.BOLD, fontSize));
	}
	
	@Override
	public void drawMoving(GL2 gl, GLU glu, float eyeX, float eyeY, float eyeZ) {
		drawJumbotron(gl, glu);
	}

	public void draw(GL2 gl, GLU glu) {
		drawSidewalkAndTrees(gl, glu);
		drawWalls(gl, glu);
		drawSign(gl, glu);
		drawRink(gl, glu);
		drawPool(gl, glu);
	}
	
	public void drawSidewalkAndTrees(GL2 gl, GLU glu) {
		gl.glEnable(GL2.GL_TEXTURE_2D);

		sidewalk.bind(gl); // Sidewalk surrounding the garden
		gl.glBegin(GL2.GL_QUADS);
			gl.glTexCoord2f(0f, 4f); gl.glVertex3f(0,	0,	40);
			gl.glTexCoord2f(10f,4f); gl.glVertex3f(100,	0,	40);
			gl.glTexCoord2f(10f,0f); gl.glVertex3f(100,	0,	0);
			gl.glTexCoord2f(0f, 0f); gl.glVertex3f(0,	0,	0);

			gl.glTexCoord2f(0f, 5f); gl.glVertex3f(0,	0,	100);
			gl.glTexCoord2f(1f, 5f); gl.glVertex3f(10,	0,	100);
			gl.glTexCoord2f(1f, 0f); gl.glVertex3f(10,	0,	40);
			gl.glTexCoord2f(0f, 0f); gl.glVertex3f(0,	0,	40);

			gl.glTexCoord2f(0f, 5f); gl.glVertex3f(90,	0,	100);
			gl.glTexCoord2f(1f, 5f); gl.glVertex3f(100,	0,	100);
			gl.glTexCoord2f(1f, 0f); gl.glVertex3f(100,	0,	40);
			gl.glTexCoord2f(0f, 0f); gl.glVertex3f(90,	0,	40);

			gl.glTexCoord2f(0f, 1f); gl.glVertex3f(10,	0,	100);
			gl.glTexCoord2f(8f, 1f); gl.glVertex3f(90,	0,	100);
			gl.glTexCoord2f(8f, 0f); gl.glVertex3f(90,	0,	90);
			gl.glTexCoord2f(0f, 0f); gl.glVertex3f(10,	0,	90);
		gl.glEnd();
		
		ceiling.bind(gl); // Where the garden will go
		gl.glBegin(GL2.GL_QUADS);
			gl.glTexCoord2f(0f,0f); gl.glVertex3f(10,	30,	40);
			gl.glTexCoord2f(1f,0f); gl.glVertex3f(90,	30,	40);
			gl.glTexCoord2f(1f,1f); gl.glVertex3f(90,	30,	90);
			gl.glTexCoord2f(0f,1f); gl.glVertex3f(10,	30,	90);
		gl.glEnd();
		
		bruins.bind(gl);
		gl.glBegin(GL2.GL_QUADS);
			gl.glTexCoord2f(0f,0f); gl.glVertex3f(45,	.2f,	60);
			gl.glTexCoord2f(1f,0f); gl.glVertex3f(55,	.2f,	60);
			gl.glTexCoord2f(1f,1f); gl.glVertex3f(55,	.2f,	70);
			gl.glTexCoord2f(0f,1f); gl.glVertex3f(45,	.2f,	70);
		gl.glEnd();
		
		gl.glPushMatrix();
			gl.glRotatef(90, 1, 0, 0);
			gl.glTranslatef(5f, 5f, -4f);
			drawTree(gl, glu);
			gl.glTranslatef(90f, 0f, 0f);
			drawTree(gl, glu);
			gl.glTranslatef(0f, 90f, 0f);
			drawTree(gl, glu);
			gl.glTranslatef(-90f, 0f, 0f);
			drawTree(gl, glu);
		gl.glPopMatrix();
		gl.glDisable(GL2.GL_TEXTURE_2D);
	}
	
	
	public void drawTree(GL2 gl, GLU glu) {
		wood.bind(gl);
			glu.gluCylinder(quadric, .75, .75, 4, 10, 10);
		
		gl.glTranslatef(0f, 0f, -15f);
		tree.bind(gl);
			glu.gluCylinder(quadric, 0, 3, 15, 10, 10);
		gl.glTranslatef(0f, 0f, 15f);
	}
	
	
	public void drawWalls(GL2 gl, GLU glu) {
		gl.glEnable(GL2.GL_CULL_FACE);
		gl.glEnable(GL2.GL_TEXTURE_2D);
		
			// Inside of the big walls
			bruinsWalls.bind(gl);
			gl.glBegin(GL2.GL_QUADS);
				// Inside of front wall (front face)
				gl.glTexCoord2f(0f,0f); gl.glVertex3f(10,	0,	40);
				gl.glTexCoord2f(0f,1f); gl.glVertex3f(90,	0,	40);
				gl.glTexCoord2f(1f,1f); gl.glVertex3f(90,	30,	40);
				gl.glTexCoord2f(1f,0f); gl.glVertex3f(10,	30,	40);
				// Inside of back wall (back face)
				gl.glTexCoord2f(1f,1f); gl.glVertex3f(10,	30,	90);
				gl.glTexCoord2f(1f,0f); gl.glVertex3f(90,	30,	90);
				gl.glTexCoord2f(0f,0f); gl.glVertex3f(90,	0,	90);
				gl.glTexCoord2f(0f,1f); gl.glVertex3f(10,	0,	90);
			gl.glEnd();
			
			// Inside of the side walls
			sideWalls.bind(gl);
			gl.glBegin(GL2.GL_QUADS);
				// Inside of right wall (back face)
				gl.glTexCoord2f(1f,1f); gl.glVertex3f(10,	30,	40);
				gl.glTexCoord2f(1f,0f); gl.glVertex3f(10,	30,	62);
				gl.glTexCoord2f(0f,0f); gl.glVertex3f(10,	0,	62);
				gl.glTexCoord2f(0f,1f); gl.glVertex3f(10,	0,	40);
				
				gl.glTexCoord2f(1f,1f); gl.glVertex3f(10,	30,	68);
				gl.glTexCoord2f(1f,0f); gl.glVertex3f(10,	30,	90);
				gl.glTexCoord2f(0f,0f); gl.glVertex3f(10,	0,	90);
				gl.glTexCoord2f(0f,1f); gl.glVertex3f(10,	0,	68);
				// Inside of left wall (front face)
				gl.glTexCoord2f(1f,1f); gl.glVertex3f(90,	30,	62);
				gl.glTexCoord2f(1f,0f); gl.glVertex3f(90,	30,	40);
				gl.glTexCoord2f(0f,0f); gl.glVertex3f(90,	0,	40);
				gl.glTexCoord2f(0f,1f); gl.glVertex3f(90,	0,	62);
									
				gl.glTexCoord2f(1f,1f); gl.glVertex3f(90,	30,	90);
				gl.glTexCoord2f(1f,0f); gl.glVertex3f(90,	30,	68);
				gl.glTexCoord2f(0f,0f); gl.glVertex3f(90,	0,	68);
				gl.glTexCoord2f(0f,1f); gl.glVertex3f(90,	0,	90);
			gl.glEnd();
			black.bind(gl);
			gl.glBegin(GL2.GL_QUADS);
				gl.glTexCoord2f(1f,1f); gl.glVertex3f(10,	30,	62);
				gl.glTexCoord2f(1f,0f);   gl.glVertex3f(10,	30,	68);
				gl.glTexCoord2f(0f,0f);   gl.glVertex3f(10,	10,	68);
				gl.glTexCoord2f(0f,1f); gl.glVertex3f(10,	10,	62);
				
				gl.glTexCoord2f(1f,1f); gl.glVertex3f(90,	30,	68);
				gl.glTexCoord2f(1f,0f); gl.glVertex3f(90,	30,	62);
				gl.glTexCoord2f(0f,0f); gl.glVertex3f(90,	10,	62);
				gl.glTexCoord2f(0f,1f); gl.glVertex3f(90,	10,	68);
			gl.glEnd();
			
			// Outside walls
			garden.bind(gl);
			gl.glBegin(GL2.GL_QUADS);
				// Outside of front wall (back face)
				gl.glTexCoord2f(0f,1f); gl.glVertex3f(10,	0,	40);
				gl.glTexCoord2f(0f,0f); gl.glVertex3f(10,	30,	40);
				gl.glTexCoord2f(1f,0f); gl.glVertex3f(90,	30,	40);
				gl.glTexCoord2f(1f,1f); gl.glVertex3f(90,	0,	40);
				// Outside of back wall (front face)
				gl.glTexCoord2f(0f,1f); gl.glVertex3f(10,	0,	90);
				gl.glTexCoord2f(0f,0f); gl.glVertex3f(90,	0,	90);
				gl.glTexCoord2f(1f,0f); gl.glVertex3f(90,	30,	90);
				gl.glTexCoord2f(1f,1f); gl.glVertex3f(10,	30,	90);
				// Outside of right wall (front face)
				gl.glTexCoord2f(1f,1f); gl.glVertex3f(10,	0,	40);
				gl.glTexCoord2f(1f,0f); gl.glVertex3f(10,	0,	62);
				gl.glTexCoord2f(0f,0f); gl.glVertex3f(10,	30,	62);
				gl.glTexCoord2f(0f,1f); gl.glVertex3f(10,	30,	40);
				
				gl.glTexCoord2f(1f,1f); gl.glVertex3f(10,	10,	62);
				gl.glTexCoord2f(1f,0f); gl.glVertex3f(10,	10,	68);
				gl.glTexCoord2f(0f,0f); gl.glVertex3f(10,	30,	68);
				gl.glTexCoord2f(0f,1f); gl.glVertex3f(10,	30,	62);
				
				gl.glTexCoord2f(1f,1f); gl.glVertex3f(10,	0,	68);
				gl.glTexCoord2f(1f,0f); gl.glVertex3f(10,	0,	90);
				gl.glTexCoord2f(0f,0f); gl.glVertex3f(10,	30,	90);
				gl.glTexCoord2f(0f,1f); gl.glVertex3f(10,	30,	68);
				// Outside of left wall (back face)
				gl.glTexCoord2f(1f,1f); gl.glVertex3f(90,	0,	62);
				gl.glTexCoord2f(1f,0f); gl.glVertex3f(90,	0,	40);
				gl.glTexCoord2f(0f,0f); gl.glVertex3f(90,	30,	40);
				gl.glTexCoord2f(0f,1f); gl.glVertex3f(90,	30,	62);
				
				gl.glTexCoord2f(1f,1f); gl.glVertex3f(90,	10,	68);
				gl.glTexCoord2f(1f,0f); gl.glVertex3f(90,	10,	62);
				gl.glTexCoord2f(0f,0f); gl.glVertex3f(90,	30,	62);
				gl.glTexCoord2f(0f,1f); gl.glVertex3f(90,	30,	68);
				
				gl.glTexCoord2f(1f,1f); gl.glVertex3f(90,	0,	90);
				gl.glTexCoord2f(1f,0f); gl.glVertex3f(90,	0,	68);
				gl.glTexCoord2f(0f,0f); gl.glVertex3f(90,	30,	68);
				gl.glTexCoord2f(0f,1f); gl.glVertex3f(90,	30,	90);
			gl.glEnd();
			
			// Cones on the corners
			black.bind(gl);
			gl.glPushMatrix();
				gl.glTranslated(12, 30, 42);
				gl.glRotated(-90, 1, 0, 0);
				glu.gluCylinder(quadric, .5f, 0, 20, 10, 10);
			gl.glPopMatrix();
			gl.glPushMatrix();
				gl.glTranslated(12, 30, 88);
				gl.glRotated(-90, 1, 0, 0);
				glu.gluCylinder(quadric, .5f, 0, 20, 10, 10);
			gl.glPopMatrix();
			gl.glPushMatrix();
				gl.glTranslated(88, 30, 42);
				gl.glRotated(-90, 1, 0, 0);
				glu.gluCylinder(quadric, .5f, 0, 20, 10, 10);
			gl.glPopMatrix();
			gl.glPushMatrix();
				gl.glTranslated(88, 30, 88);
				gl.glRotated(-90, 1, 0, 0);
				glu.gluCylinder(quadric, .5f, 0, 20, 10, 10);
			gl.glPopMatrix();

		gl.glDisable(GL2.GL_TEXTURE_2D);
		gl.glDisable(GL2.GL_CULL_FACE);
		
		
		gl.glEnable(GL2.GL_TEXTURE_2D);
			white.bind(gl);
			gl.glBegin(GL2.GL_QUADS);
				gl.glTexCoord2f(1f,1f); gl.glVertex3f(10,	-.1f,	90);
				gl.glTexCoord2f(1f,0f); gl.glVertex3f(10,	-.1f,	40);
				gl.glTexCoord2f(0f,0f); gl.glVertex3f(90,	-.1f,	40);
				gl.glTexCoord2f(0f,1f); gl.glVertex3f(90,	-.1f,	90);
			gl.glEnd();
		gl.glDisable(GL2.GL_TEXTURE_2D);

	}
	
	
	public void drawSign(GL2 gl, GLU glu) {		
		renderer.begin3DRendering();
			renderer.setColor(.2f, .2f, .5f, 1f);
			renderer.draw3D("NORTH STATION", 10.5f, 23f, 90.1f, .05f);
			renderer.setColor(1f, .8f, 0f, 1f);
			renderer.draw3D("BOSTON GARDEN", 50f, 23f, 90.1f, .05f);
		renderer.end3DRendering();
		gl.glPushMatrix();
			renderer.begin3DRendering();
				gl.glTranslated(89.5, 23, 39.9);
				gl.glRotated(180, 0, 1, 0);
				renderer.setColor(.2f, .2f, .5f, 1f);
				renderer.draw3D("NORTH STATION", 0, 0, 0, .05f);
				renderer.setColor(1f, .8f, 0f, 1f);
				renderer.draw3D("BOSTON GARDEN", 39.5f, 0, 0, .05f);
			renderer.end3DRendering();
		gl.glPopMatrix();
	}
	
	// Counterclockwise is frontfacing
	public void drawRink(GL2 gl, GLU glu) {
		gl.glEnable(GL2.GL_TEXTURE_2D);
		// 8 Faceoff points
			red.bind(gl);
        	gl.glBegin(GL2.GL_QUADS);
        	// 4 in the middle of the ice
    			gl.glVertex3d(38.5,	.1,	53.5);
    			gl.glVertex3d(38.5,	.1,	54.5);
    			gl.glVertex3d(39.5,	.1,	54.5);
    			gl.glVertex3d(39.5,	.1,	53.5);
    			
    			gl.glVertex3d(38.5,	.1,	75.5);
				gl.glVertex3d(38.5,	.1,	76.5);
				gl.glVertex3d(39.5,	.1,	76.5);
				gl.glVertex3d(39.5,	.1,	75.5);

    			gl.glVertex3d(60.5,	.1,	53.5);
    			gl.glVertex3d(60.5,	.1,	54.5);
    			gl.glVertex3d(61.5,	.1,	54.5);
    			gl.glVertex3d(61.5,	.1,	53.5);

				gl.glVertex3d(60.5,	.1,	75.5);
				gl.glVertex3d(60.5,	.1,	76.5);
				gl.glVertex3d(61.5,	.1,	76.5);
				gl.glVertex3d(61.5,	.1,	75.5);
			// 4 near the nets
    			gl.glVertex3d(24.5,	.1,	49.5);
    			gl.glVertex3d(24.5,	.1,	50.5);
    			gl.glVertex3d(25.5,	.1,	50.5);
    			gl.glVertex3d(25.5,	.1,	49.5);

				gl.glVertex3d(24.5,	.1,	79.5);
				gl.glVertex3d(24.5,	.1,	80.5);
				gl.glVertex3d(25.5,	.1,	80.5);
				gl.glVertex3d(25.5,	.1,	79.5);

    			gl.glVertex3d(74.5,	.1,	79.5);
    			gl.glVertex3d(74.5,	.1,	80.5);
    			gl.glVertex3d(75.5,	.1,	80.5);
    			gl.glVertex3d(75.5,	.1,	79.5);

				gl.glVertex3d(74.5,	.1,	49.5);
				gl.glVertex3d(74.5,	.1,	50.5);
				gl.glVertex3d(75.5,	.1,	50.5);
				gl.glVertex3d(75.5,	.1,	49.5);
				
				// Center line
        		gl.glVertex3d(49.5,	.1,	40);
        		gl.glVertex3d(49.5,	.1,	90);
        		gl.glVertex3d(51.5,	.1,	90);
        		gl.glVertex3d(51.5,	.1,	40);
        	gl.glEnd();
        	
        	// Faceoff circles
        	double x = 0, z = 0, sides = 30;
        	for (int i = 0; i < 4; i++) {
        			 if (i == 0) {x = 25; z = 50;}
        		else if (i == 1) {x = 25; z = 80;}
        		else if (i == 2) {x = 75; z = 50;}
        		else 			 {x = 75; z = 80;}
        			 
        		gl.glPushMatrix();
        			gl.glTranslated(x, .2, z);
        			gl.glRotated(90, 1, 0, 0);
        			gl.glScaled(7, 7, 7);
        			gl.glLineWidth(1.5f);
        			
        			gl.glBegin(GL2.GL_LINE_LOOP );
        				for (int j = 0; j < sides; j++)
        					gl.glVertex2d(Math.sin(2 * Math.PI * (j/sides)), Math.cos(2 * Math.PI * (j/sides)));
        			gl.glEnd();
    			gl.glPopMatrix();
        	}
        	
        	// Goal Posts
        	gl.glLineWidth(5f);
        	gl.glBegin(GL2.GL_LINES);
        	// Left net
    			gl.glVertex3d(15,	0,	68);
    			gl.glVertex3d(15,	4,	68);
    			
    			gl.glVertex3d(15,	4,	68);
    			gl.glVertex3d(15,	4,	62);
    			
    			gl.glVertex3d(15,	4,	62);
    			gl.glVertex3d(15,	0,	62);
    			
    			gl.glVertex3d(15,	0,	62);
    			gl.glVertex3d(13,	0,	63);

    			gl.glVertex3d(13,	0,	63);
    			gl.glVertex3d(13,	0,	67);

    			gl.glVertex3d(13,	0,	67);
    			gl.glVertex3d(15,	0,	68);
    		// Right net
    			gl.glVertex3d(85,	0,	68);
    			gl.glVertex3d(85,	4,	68);
    			
    			gl.glVertex3d(85,	4,	68);
    			gl.glVertex3d(85,	4,	62);
    			
    			gl.glVertex3d(85,	4,	62);
    			gl.glVertex3d(85,	0,	62);
    			
    			gl.glVertex3d(85,	0,	62);
    			gl.glVertex3d(87,	0,	63);

    			gl.glVertex3d(87,	0,	63);
    			gl.glVertex3d(87,	0,	67);

    			gl.glVertex3d(87,	0,	67);
    			gl.glVertex3d(85,	0,	68);
    		gl.glEnd();
        	
        	// 2 Blue lines and endlines
        	blue.bind(gl);
        	gl.glBegin(GL2.GL_QUADS);
    			gl.glVertex3d(34,	.1,	40);
    			gl.glVertex3d(34,	.1,	90);
    			gl.glVertex3d(36,	.1,	90);
    			gl.glVertex3d(36,	.1,	40);

    			gl.glVertex3d(64,	.1,	40);
    			gl.glVertex3d(64,	.1,	90);
    			gl.glVertex3d(66,	.1,	90);
    			gl.glVertex3d(66,	.1,	40);

				gl.glVertex3d(14.75,	.1,	40);
				gl.glVertex3d(14.75,	.1,	90);
				gl.glVertex3d(15.25,	.1,	90);
				gl.glVertex3d(15.25,	.1,	40);

				gl.glVertex3d(84.75,	.1,	40);
				gl.glVertex3d(84.75,	.1,	90);
				gl.glVertex3d(85.25,	.1,	90);
				gl.glVertex3d(85.25,	.1,	40);
			gl.glEnd();
			
			// Creases
			gl.glPushMatrix();
				gl.glTranslated(15, .2, 65);
				gl.glScaled(5, 5, 5);
				gl.glRotated(90, 1, 0, 0);
				
				gl.glBegin(GL2.GL_POLYGON);
					for (int i = 0; i < sides; i++)
						gl.glVertex2d(Math.sin(Math.PI * (i/sides)), Math.cos(Math.PI * (i/sides)));
				gl.glEnd();
			gl.glPopMatrix();
			
			gl.glPushMatrix();
				gl.glTranslated(85, .2, 65);
				gl.glScaled(5, 5, 5);
				gl.glRotated(180, 0, 1, 0);
				gl.glRotated(90, 1, 0, 0);
				
				gl.glBegin(GL2.GL_POLYGON);
					for (int i = 0; i < sides; i++)
						gl.glVertex2d(Math.sin(Math.PI * (i/sides)), Math.cos(Math.PI * (i/sides)));
				gl.glEnd();
			gl.glPopMatrix();
			
			// Nets
			net.bind(gl);
			gl.glBegin(GL2.GL_POLYGON);
				gl.glTexCoord2d(5, 0); gl.glVertex3d(13, 0, 63);
				gl.glTexCoord2d(5, 5); gl.glVertex3d(15, 4, 62);
				gl.glTexCoord2d(0, 5); gl.glVertex3d(15, 0, 62);
			gl.glEnd();
			gl.glBegin(GL2.GL_POLYGON);
				gl.glTexCoord2d(5, 0); gl.glVertex3d(13, 0, 67);
				gl.glTexCoord2d(5, 5); gl.glVertex3d(15, 4, 68);
				gl.glTexCoord2d(0, 5); gl.glVertex3d(15, 0, 68);
			gl.glEnd();
			gl.glBegin(GL2.GL_POLYGON);
				gl.glTexCoord2d(5, 0); gl.glVertex3d(13, 0, 67);
				gl.glTexCoord2d(5, 5); gl.glVertex3d(13, 0, 63);
				gl.glTexCoord2d(0, 5); gl.glVertex3d(15, 4, 62);
				gl.glTexCoord2d(0, 0); gl.glVertex3d(15, 4, 68);
			gl.glEnd();
			
			gl.glBegin(GL2.GL_POLYGON);
				gl.glTexCoord2d(5, 0); gl.glVertex3d(87, 0, 63);
				gl.glTexCoord2d(5, 5); gl.glVertex3d(85, 4, 62);
				gl.glTexCoord2d(0, 5); gl.glVertex3d(85, 0, 62);
			gl.glEnd();
			gl.glBegin(GL2.GL_POLYGON);
				gl.glTexCoord2d(5, 0); gl.glVertex3d(87, 0, 67);
				gl.glTexCoord2d(5, 5); gl.glVertex3d(85, 4, 68);
				gl.glTexCoord2d(0, 5); gl.glVertex3d(85, 0, 68);
			gl.glEnd();
			gl.glBegin(GL2.GL_POLYGON);
				gl.glTexCoord2d(5, 0); gl.glVertex3d(87, 0, 67);
				gl.glTexCoord2d(5, 5); gl.glVertex3d(87, 0, 63);
				gl.glTexCoord2d(0, 5); gl.glVertex3d(85, 4, 62);
				gl.glTexCoord2d(0, 0); gl.glVertex3d(85, 4, 68);
			gl.glEnd();
			
		gl.glDisable(GL2.GL_TEXTURE_2D);
	}
	
	public void drawJumbotron(GL2 gl, GLU glu) {
		
		gl.glEnable(GL2.GL_TEXTURE_2D);
			jumbo1.bind(gl);
			gl.glPushMatrix();
				gl.glTranslated(50, 30, 65);
				gl.glRotated(frames++, 0, 1, 0);
				gl.glTranslated(-50, -30, -65);

				gl.glBegin(GL2.GL_QUADS);
					gl.glTexCoord2d(0, 0);	gl.glVertex3d(43, 30, 58);
					gl.glTexCoord2d(1, 0);	gl.glVertex3d(57, 30, 58);
					gl.glTexCoord2d(1, 1);	gl.glVertex3d(55, 15, 60);
					gl.glTexCoord2d(0, 1);	gl.glVertex3d(45, 15, 60);
					
					gl.glTexCoord2d(1, 0);	gl.glVertex3d(43, 30, 72);
					gl.glTexCoord2d(0, 0);	gl.glVertex3d(57, 30, 72);
					gl.glTexCoord2d(0, 1);	gl.glVertex3d(55, 15, 70);
					gl.glTexCoord2d(1, 1);	gl.glVertex3d(45, 15, 70);
				gl.glEnd();
				
				jumbo2.bind(gl);
				gl.glBegin(GL2.GL_QUADS);
					gl.glTexCoord2d(0, 0);	gl.glVertex3d(43, 30, 72);
					gl.glTexCoord2d(1, 0);	gl.glVertex3d(43, 30, 58);
					gl.glTexCoord2d(1, 1);	gl.glVertex3d(45, 15, 60);
					gl.glTexCoord2d(0, 1);	gl.glVertex3d(45, 15, 70);
					
					gl.glTexCoord2d(0, 0);	gl.glVertex3d(57, 30, 58);
					gl.glTexCoord2d(1, 0);	gl.glVertex3d(57, 30, 72);
					gl.glTexCoord2d(1, 1);	gl.glVertex3d(55, 15, 70);
					gl.glTexCoord2d(0, 1);	gl.glVertex3d(55, 15, 60);
				gl.glEnd();
				
				black.bind(gl);
				gl.glBegin(GL2.GL_QUADS);
					gl.glTexCoord2d(0, 0);	gl.glVertex3d(55, 15, 60);
					gl.glTexCoord2d(1, 0);	gl.glVertex3d(55, 15, 70);
					gl.glTexCoord2d(1, 1);	gl.glVertex3d(45, 15, 70);
					gl.glTexCoord2d(0, 1);	gl.glVertex3d(45, 15, 60);
				gl.glEnd();
			
			gl.glPopMatrix();
		gl.glDisable(GL2.GL_TEXTURE_2D);
	}
	
	private void drawPool(GL2 gl, GLU glu) {
		gl.glEnable(GL2.GL_TEXTURE_2D);
			water.bind(gl);
			gl.glBegin(GL2.GL_QUADS);
				gl.glTexCoord2d(0, 0);	gl.glVertex3d(25, .1, 10);
				gl.glTexCoord2d(1, 0);	gl.glVertex3d(25, .1, 30);
				gl.glTexCoord2d(1, 3);	gl.glVertex3d(75, .1, 30);
				gl.glTexCoord2d(0, 3);	gl.glVertex3d(75, .1, 10);
			gl.glEnd();
			
			white.bind(gl);
			gl.glColor3d(1, 1, 1);
        	gl.glBegin(GL2.GL_QUADS);
				gl.glVertex3d(23,  2, 19);
				gl.glVertex3d(23,  2, 21);
				gl.glVertex3d(23,  0, 21);
				gl.glVertex3d(23,  0, 19);
				
				gl.glVertex3d(23,  2, 19);
				gl.glVertex3d(23,  2, 21);
				gl.glVertex3d(30,  2, 21);
				gl.glVertex3d(30,  2, 19);
			gl.glEnd();
		gl.glDisable(GL2.GL_TEXTURE_2D);
	}

}
