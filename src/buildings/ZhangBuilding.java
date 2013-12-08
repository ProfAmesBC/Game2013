package buildings;

import game.Building;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;

import sketchupModels.Avatar;

import com.jogamp.opengl.util.texture.Texture;

public class ZhangBuilding extends Building {

	private GLUquadric quadric;
	private Texture cylinderTexture;
	private Texture rockPavementTexture;
	private Texture tiledRoofTexture;
	private Texture woodTexture;
	private Texture woodWallTexture;
	
    private Avatar psy;

	public ZhangBuilding (GL2 gl, GLU glu) {
		//rammedEarthTexture = setupTexture(gl, "rammedEarth.jpg");
		cylinderTexture = setupTexture(gl, "beige1.gif");        
		rockPavementTexture = setupTexture(gl, "rock162.jpg");
		tiledRoofTexture = setupTexture(gl, "tiledRoof.jpg");
		woodTexture = setupTexture(gl, "wood003.jpg");
		woodWallTexture = setupTexture(gl, "wood033.gif");
		
		//JIANG NAN STYLE
        psy = new Avatar(gl, glu);
	}

	//some constants
	private double cylinderTopRadius = 35;
	private double cylinderBaseRadius = 40;
	private double cylinderHeight = 30;

	private int slices = 30;
	private int floors = 4;
	private int rooms = 20;
	private int calculatedDegrees = 360/20;

	private double diskInnerRadius = 20;
	private double diskOuterRadius = 38;
	private double xFloor = cylinderHeight/floors;


	@Override
	public void draw(GL2 gl, GLU glu) {
		gl.glEnable(GL2.GL_TEXTURE_2D); //enable textures

		//Draws the patch of land
		rockPavementTexture.bind(gl);

		gl.glBegin(GL2.GL_QUADS);
		gl.glColor3f(1f,0f,0f);

		gl.glTexCoord2f(0,0);
		gl.glVertex3f(0f,0f,0f); //bottom left corner
		gl.glTexCoord2f(20,0);
		gl.glVertex3f(100f,0f,0f);
		gl.glTexCoord2f(20,20); //for the distortion
		gl.glVertex3f(100,0f,100f);
		gl.glTexCoord2f(0,20);
		gl.glVertex3f(0f,0f,100f);

		gl.glEnd();

		//Drawing the cylinder
		gl.glTexEnvf(GL2.GL_TEXTURE_ENV, GL2.GL_TEXTURE_ENV_MODE, GL2.GL_REPLACE); // or GL_MODULATE
		quadric = glu.gluNewQuadric();
		glu.gluQuadricDrawStyle(quadric, GLU.GLU_FILL); // GLU_POINT, GLU_LINE, GLU_FILL, GLU_SILHOUETTE
		glu.gluQuadricNormals  (quadric, GLU.GLU_NONE); // GLU_NONE, GLU_FLAT, or GLU_SMOOTH
		glu.gluQuadricTexture  (quadric, true);        // true to generate texture coordinates



		cylinderTexture.bind(gl); //bind textures 

		{
			gl.glMatrixMode(GL2.GL_TEXTURE); 
			{
				gl.glPushMatrix(); //texture matrix

				gl.glScalef(100f,20f,1f); //scale texture
				gl.glMatrixMode(GL2.GL_MODELVIEW); //working with models
				{
					gl.glPushMatrix(); //modelview matrix
					gl.glTranslatef(50,0,50);
					gl.glRotatef(-90, 1, 0, 0); //-90 is because of x perspective
					glu.gluCylinder(quadric, cylinderBaseRadius, cylinderTopRadius, cylinderHeight, slices, 1);
					
					woodTexture.bind(gl);
					gl.glTranslated(0,0,xFloor); //in preparation for rotating
					glu.gluDisk(quadric, diskInnerRadius, diskOuterRadius-1, slices, 10);
					gl.glTranslated(0,0,xFloor); //in preparation for rotating
					glu.gluDisk(quadric, diskInnerRadius, diskOuterRadius-2, slices, 10);
					gl.glTranslated(0,0,xFloor); //in preparation for rotating
					glu.gluDisk(quadric, diskInnerRadius, diskOuterRadius-3, slices, 10);
					gl.glTranslated(0,0,xFloor); //in preparation for rotating

					tiledRoofTexture.bind(gl);
					glu.gluCylinder(quadric, diskOuterRadius*1.08, diskInnerRadius*0.85, 5, slices, 1);
					glu.gluDisk(quadric, diskInnerRadius, diskOuterRadius*1.15, slices, 10);


					//new stuff
					gl.glPopMatrix(); //modelview matrix
				}

			}
			gl.glMatrixMode(GL2.GL_TEXTURE);
			gl.glPopMatrix(); //texture matrix

			gl.glMatrixMode(GL2.GL_MODELVIEW); //reset to modelview

			{
				woodWallTexture.bind(gl);
				for (int angle = 0; angle < 360; angle+=calculatedDegrees)
				{
					{
						gl.glPushMatrix();
						gl.glTranslated(50,0,50);
						gl.glRotatef(angle, 0,1,0);

						gl.glBegin(GL2.GL_QUADS);
						gl.glTexCoord2f(0,0);
						gl.glVertex3d(diskInnerRadius,0,0); //bottom left corner
						gl.glTexCoord2f(20,0);
						gl.glVertex3d(diskOuterRadius,0,0);
						gl.glTexCoord2f(18,10); //for the distortion
						gl.glVertex3d(cylinderTopRadius,cylinderHeight,0);
						gl.glTexCoord2f(0,10);
						gl.glVertex3d(diskInnerRadius,cylinderHeight,0); 
						gl.glEnd();

						gl.glPopMatrix();
					}
				}
			}
		}
		gl.glDisable(GL2.GL_TEXTURE_2D); //disable textures
	
        psy.draw(gl, glu);
	}
}

