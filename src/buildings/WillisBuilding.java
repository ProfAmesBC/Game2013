package buildings;

import game.Building;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import javax.media.opengl.GL2GL3;
import javax.media.opengl.glu.*;

import com.jogamp.opengl.util.texture.Texture;

public class WillisBuilding extends Building {
	private GLUquadric quadric;
	private Texture marble;
	private Texture grass;
	private Texture indoors;
	private Texture table;
	private Texture picture;
	public WillisBuilding(GL2 gl, GLU glu){
        quadric = glu.gluNewQuadric();
        glu.gluQuadricDrawStyle(quadric, GLU.GLU_FILL); // GLU_POINT, GLU_LINE, GLU_FILL, GLU_SILHOUETTE
        glu.gluQuadricNormals  (quadric, GLU.GLU_NONE); // GLU_NONE, GLU_FLAT, or GLU_SMOOTH
        glu.gluQuadricTexture  (quadric, true);        // false, or true to generate texture coordinates

        marble = Building.setupTexture(gl, "Willismarb009.jpg");
        grass = Building.setupTexture(gl, "Willisnatfl069.gif");
        indoors = Building.setupTexture(gl, "Williswood032.gif");
        table = Building.setupTexture(gl, "Williswood135.jpg");
        picture = Building.setupTexture(gl, "Willispicture.jpg");
	}
	@Override
	public void draw(GL2 gl, GLU glu) {
		gl.glEnable(GL.GL_TEXTURE_2D);
		grass.bind(gl);
		gl.glBegin(GL2GL3.GL_QUADS);
			
			//gl.glColor3d(0, 1, 0);//the green grass
			gl.glTexCoord2f(0f, 0f); gl.glVertex3f(0f, 0f, 0f);
			gl.glTexCoord2f(10f, 0f); gl.glVertex3f(100f, 0f, 0f);
			gl.glTexCoord2f(10f, 10f); gl.glVertex3f(100f, 0f, 100f);
			gl.glTexCoord2f(0f, 10f); gl.glVertex3f(0f, 0f, 100f);
			
		gl.glEnd();
		marble.bind(gl);
		gl.glEnable(GL.GL_CULL_FACE);
		gl.glBegin(GL2GL3.GL_QUADS);
			//gl.glColor3d(1, 0, 0);//red walls for now, get building 1 working with textures before doing building 2
			gl.glTexCoord2f(0f, 0f); gl.glVertex3f(25, 0, 31); // point A
			gl.glTexCoord2f(2f, 0f); gl.glVertex3f(25, 0, 61); // point B
			gl.glTexCoord2f(2f, 1f); gl.glVertex3f(25, 15, 61); // point Ba
			gl.glTexCoord2f(0f, 1f); gl.glVertex3f(25, 15, 31); // point Aa
			
			gl.glTexCoord2f(0f, 0f); gl.glVertex3f(25, 0, 61); // point B
			gl.glTexCoord2f(1.333f, 0f); gl.glVertex3f(45, 0, 61); // point C
			gl.glTexCoord2f(1.333f, 1f); gl.glVertex3f(45, 15, 61); // point Ca
			gl.glTexCoord2f(0f, 1f); gl.glVertex3f(25, 15, 61); // point Ba
			
		gl.glEnd();
		indoors.bind(gl);
		gl.glBegin(GL2GL3.GL_QUADS);
			//gl.glColor3d(1, 0, 0);//red walls for now, get building 1 working with textures before doing building 2
			gl.glTexCoord2f(0f, 0f); gl.glVertex3f(25, 0, 31); // point A
			gl.glTexCoord2f(2f, 0f); gl.glVertex3f(25, 15, 31); // point Aa
			gl.glTexCoord2f(2f, 1f); gl.glVertex3f(25, 15, 61); // point Ba
			gl.glTexCoord2f(0f, 1f); gl.glVertex3f(25, 0, 61); // point B
			
			gl.glTexCoord2f(0f, 0f); gl.glVertex3f(25, 0, 61); // point B
			gl.glTexCoord2f(1.333f, 0f); gl.glVertex3f(25, 15, 61); // point Ba
			gl.glTexCoord2f(1.333f, 1f); gl.glVertex3f(45, 15, 61); // point Ca
			gl.glTexCoord2f(0f, 1f); gl.glVertex3f(45, 0, 61); // point C
		gl.glEnd();
		marble.bind(gl);
		gl.glBegin(GL2GL3.GL_QUADS);
			gl.glTexCoord2f(0f, 0f); gl.glVertex3f(45, 0, 61); // point C right of door from outside
			gl.glTexCoord2f(6f/15f, 0f); gl.glVertex3f(45, 0, 55); // point D
			gl.glTexCoord2f(6f/15f, 7f/15f); gl.glVertex3f(45, 7, 55); // point Dd
			gl.glTexCoord2f(0f, 7f/15f); gl.glVertex3f(45, 7, 61); // point Cd
			
			gl.glTexCoord2f(0f, 7f/15f); gl.glVertex3f(45, 7, 61); // point Cd above dorway
			gl.glTexCoord2f(2f, 7f/15f); gl.glVertex3f(45, 7, 31); // point Fd
			gl.glTexCoord2f(2f, 1f); gl.glVertex3f(45, 15, 31); // point Fa
			gl.glTexCoord2f(0f, 1f); gl.glVertex3f(45, 15, 61); // point Ca
			
			gl.glTexCoord2f(10/15f, 0f); gl.glVertex3f(45, 0, 51); // point E left of door from outside
			gl.glTexCoord2f(2f, 0f); gl.glVertex3f(45, 0, 31); // point F
			gl.glTexCoord2f(2f, 7f/15f); gl.glVertex3f(45, 7, 31); // point Fd
			gl.glTexCoord2f(10f/15f, 7f/15f); gl.glVertex3f(45, 7, 51); // point Ed
		gl.glEnd();
		indoors.bind(gl);
		gl.glBegin(GL2GL3.GL_QUADS);
			gl.glTexCoord2f(0f, 0f); gl.glVertex3f(45, 0, 61); // point C right of door from outside
			gl.glTexCoord2f(6f/15f, 0f); gl.glVertex3f(45, 7, 61); // point D
			gl.glTexCoord2f(6f/15f, 7f/15f); gl.glVertex3f(45, 7, 55); // point Dd
			gl.glTexCoord2f(0f, 7f/15f); gl.glVertex3f(45, 0, 55); // point Cd
			
			gl.glTexCoord2f(0f, 7f/15f); gl.glVertex3f(45, 7, 61); // point Cd above dorway
			gl.glTexCoord2f(2f, 7f/15f); gl.glVertex3f(45, 15, 61); // point Fd
			gl.glTexCoord2f(2f, 1f); gl.glVertex3f(45, 15, 31); // point Fa
			gl.glTexCoord2f(0f, 1f); gl.glVertex3f(45, 7, 31); // point Ca
			
			gl.glTexCoord2f(10/15f, 0f); gl.glVertex3f(45, 0, 51); // point E left of door from outside
			gl.glTexCoord2f(2f, 0f); gl.glVertex3f(45, 7, 51); // point F
			gl.glTexCoord2f(2f, 7f/15f); gl.glVertex3f(45, 7, 31); // point Fd
			gl.glTexCoord2f(10f/15f, 7f/15f); gl.glVertex3f(45, 0, 31); // point Ed
		gl.glEnd();
		marble.bind(gl);
		gl.glBegin(GL2GL3.GL_QUADS);
			
			gl.glTexCoord2f(0f, 0f); gl.glVertex3f(45, 0, 31); // point F  right of door
			gl.glTexCoord2f(10f/15f, 0f); gl.glVertex3f(35, 0, 31); // point G
			gl.glTexCoord2f(10f/15f, 7f/15f); gl.glVertex3f(35, 7, 31); // point Gd
			gl.glTexCoord2f(0f, 7f/15f); gl.glVertex3f(45, 7, 31); // point Fd
			
			gl.glTexCoord2f(0f, 7/15f); gl.glVertex3f(45, 7, 31); // point Fd  above door
			gl.glTexCoord2f(20f/15f, 7/15f); gl.glVertex3f(25, 7, 31); // point Ad
			gl.glTexCoord2f(20f/15f, 1f); gl.glVertex3f(25, 15, 31); // point Aa
			gl.glTexCoord2f(0f, 1f); gl.glVertex3f(45, 15, 31); // point Fa
			
			gl.glTexCoord2f(14f/15f, 0f); gl.glVertex3f(31, 0, 31); // point H  left of door
			gl.glTexCoord2f(0f, 0f); gl.glVertex3f(25, 0, 31); // point A
			gl.glTexCoord2f(0f, 7f/15f); gl.glVertex3f(25, 7, 31); // point Ad
			gl.glTexCoord2f(14f/15f, 7f/15f); gl.glVertex3f(31, 7, 31); // point Hd
			
			//no ceiling for now, so it is easier to see everything.
		gl.glEnd();
		indoors.bind(gl);
		gl.glBegin(GL2GL3.GL_QUADS);
			
			gl.glTexCoord2f(0f, 0f); gl.glVertex3f(45, 0, 31); // point F  right of door
			gl.glTexCoord2f(10f/15f, 0f); gl.glVertex3f(45, 7, 31); // point G
			gl.glTexCoord2f(10f/15f, 7f/15f); gl.glVertex3f(35, 7, 31); // point Gd
			gl.glTexCoord2f(0f, 7f/15f); gl.glVertex3f(35, 0, 31); // point Fd
			
			gl.glTexCoord2f(0f, 7/15f); gl.glVertex3f(45, 7, 31); // point Fd  above door
			gl.glTexCoord2f(20f/15f, 7/15f); gl.glVertex3f(45, 15, 31); // point Ad
			gl.glTexCoord2f(20f/15f, 1f); gl.glVertex3f(25, 15, 31); // point Aa
			gl.glTexCoord2f(0f, 1f); gl.glVertex3f(25, 7, 31); // point Fa
			
			gl.glTexCoord2f(14f/15f, 0f); gl.glVertex3f(31, 0, 31); // point H  left of door
			gl.glTexCoord2f(0f, 0f); gl.glVertex3f(31, 7, 31); // point A
			gl.glTexCoord2f(0f, 7f/15f); gl.glVertex3f(25, 7, 31); // point Ad
			gl.glTexCoord2f(14f/15f, 7f/15f); gl.glVertex3f(25, 0, 31); // point Hd
			//no ceiling for now, so it is easier to see everything.
		gl.glEnd();
		marble.bind(gl);
		gl.glBegin(GL2GL3.GL_QUADS);;
			gl.glTexCoord2f(0f, 0f); gl.glVertex3f(25f, 15f, 31f);
			gl.glTexCoord2f(0f, 2f); gl.glVertex3f(25f, 15f, 61f);
			gl.glTexCoord2f(20f/15f, 2f); gl.glVertex3f(45f, 15f, 61f);
			gl.glTexCoord2f(20f/15f, 0f); gl.glVertex3f(45f, 15f, 31f);
		gl.glEnd();
		indoors.bind(gl);
		gl.glBegin(GL2GL3.GL_QUADS);;
			gl.glTexCoord2f(0f, 0f); gl.glVertex3f(25f, 15f, 31f);
			gl.glTexCoord2f(20f/15f, 0f); gl.glVertex3f(45f, 15f, 31f);
			gl.glTexCoord2f(20f/15f, 2f); gl.glVertex3f(45f, 15f, 61f);
			gl.glTexCoord2f(0f, 2f); gl.glVertex3f(25f, 15f, 61f);
		gl.glEnd();
		gl.glDisable(GL.GL_CULL_FACE);
		
		table.bind(gl);
		gl.glPushMatrix();
			gl.glRotatef(-90f, 1f, 0f, 0f);
			gl.glTranslatef(35.5f, -46.5f, 0f);
			glu.gluCylinder(quadric, 1f/12f, 1f/12f, 3.5, 10, 5);
		gl.glPopMatrix();
		gl.glPushMatrix();
			gl.glRotatef(-90f, 1f, 0f, 0f);
			gl.glTranslatef(35.5f, -50.5f, 0f);
			glu.gluCylinder(quadric, 1f/12f, 1f/12f, 3.5, 10, 5);
		gl.glPopMatrix();
		gl.glPushMatrix();
			gl.glRotatef(-90f, 1f, 0f, 0f);
			gl.glTranslatef(39.5f, -50.5f, 0f);
			glu.gluCylinder(quadric, 1f/12f, 1f/12f, 3.5, 10, 5);
		gl.glPopMatrix();
		gl.glPushMatrix();
			gl.glRotatef(-90f, 1f, 0f, 0f);
			gl.glTranslatef(39.5f, -46.5f, 0f);
			glu.gluCylinder(quadric, 1f/12f, 1f/12f, 3.5, 10, 5);
		gl.glPopMatrix();
		gl.glBegin(GL2GL3.GL_QUADS);
			gl.glTexCoord2f(0f, 0f); gl.glVertex3f(35f, 3.5f, 46f);
			gl.glTexCoord2f(0f, 1f); gl.glVertex3f(35f, 3.5f, 51f);
			gl.glTexCoord2f(1f, 1f); gl.glVertex3f(40f, 3.5f, 51f);
			gl.glTexCoord2f(1f, 0f); gl.glVertex3f(40f, 3.5f, 46f);
			
			gl.glTexCoord2f(0f, 0f); gl.glVertex3f(35f, 3.5f, 46f);
			gl.glTexCoord2f(0f, 1f); gl.glVertex3f(35f, 3.5f, 51f);
			gl.glTexCoord2f(0.06f, 1f); gl.glVertex3f(35f, 3.2f, 51f);
			gl.glTexCoord2f(0.06f, 0f); gl.glVertex3f(35f, 3.2f, 46f);
			
			gl.glTexCoord2f(0f, 0f); gl.glVertex3f(35f, 3.5f, 51f);
			gl.glTexCoord2f(0f, 1f); gl.glVertex3f(40f, 3.5f, 51f);
			gl.glTexCoord2f(.06f, 1f); gl.glVertex3f(40f, 3.2f, 51f);
			gl.glTexCoord2f(.06f, 0f); gl.glVertex3f(35f, 3.2f, 51f);
			
			gl.glTexCoord2f(0f, 0f); gl.glVertex3f(40f, 3.5f, 46f);
			gl.glTexCoord2f(0f, 1f); gl.glVertex3f(40f, 3.5f, 51f);
			gl.glTexCoord2f(0.06f, 1f); gl.glVertex3f(40f, 3.2f, 51f);
			gl.glTexCoord2f(0.06f, 0f); gl.glVertex3f(40f, 3.2f, 46f);
			
			gl.glTexCoord2f(0f, 0f); gl.glVertex3f(35f, 3.5f, 46f);
			gl.glTexCoord2f(0f, 1f); gl.glVertex3f(40f, 3.5f, 46f);
			gl.glTexCoord2f(0.06f, 1f); gl.glVertex3f(40f, 3.2f, 46f);
			gl.glTexCoord2f(0.06f, 0f); gl.glVertex3f(35f, 3.2f, 46f);
		gl.glEnd();
		picture.bind(gl);
		gl.glBegin(GL2GL3.GL_QUADS);
			gl.glTexCoord2f(1f, 0f); gl.glVertex3f(25.01f, 5f, 43.5f);
			gl.glTexCoord2f(0f, 0f); gl.glVertex3f(25.01f, 5f, 48.5f);
			gl.glTexCoord2f(0f, 1f); gl.glVertex3f(25.01f, 10f, 48.5f);
			gl.glTexCoord2f(1f, 1f); gl.glVertex3f(25.01f, 10f, 43.5f);
		gl.glEnd();
		gl.glDisable(GL.GL_TEXTURE_2D);
	}
}