package buildings;
import game.Building;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;

import com.jogamp.opengl.util.texture.Texture;


public class LeiBuilding extends Building {
	private GLUquadric quadric;
	private Texture outsideTex;
	private Texture interiorTex;
	private Texture sideExteriorTex;
	private Texture sideInteriorTex;
	private Texture landTex;
	private Texture woodTex;
	private Texture chairTex;
	private Texture floorTex;
	
	public LeiBuilding(GL2 gl, GLU glu){
		outsideTex = setupTexture(gl, "Lei-outsideTex.png");
		interiorTex = setupTexture(gl, "Lei-interiorTex.jpg");
		sideExteriorTex = setupTexture(gl, "Lei-sideExterior.jpg");
		sideInteriorTex = setupTexture(gl, "Lei-sideInterior.gif");
		landTex = setupTexture(gl,"Lei-land.jpg");
		woodTex = setupTexture(gl,"Lei-woodTex.jpg");
		chairTex = setupTexture(gl, "Lei-chair.jpg");
		floorTex = setupTexture(gl, "Lei-floor.gif");
		quadric = glu.gluNewQuadric();
		glu.gluQuadricDrawStyle(quadric,  GLU.GLU_FILL);
		glu.gluQuadricNormals(quadric,  GLU.GLU_NONE);
		glu.gluQuadricTexture(quadric,  true);
	}

	@Override
	public void draw(GL2 gl, GLU glu) {
		
		gl.glEnable(GL2.GL_TEXTURE_2D);
		landTex.bind(gl);
		//left land
		gl.glBegin(GL2.GL_QUADS);
			gl.glTexCoord2f(0f, 30f);gl.glVertex3f(0, 0, 0);
			gl.glTexCoord2f(40f, 30f);gl.glVertex3f(10, 0, 0);
			gl.glTexCoord2f(40f, 0f);gl.glVertex3f(10, 0, 100);
			gl.glTexCoord2f(0f, 0f);gl.glVertex3f(0, 0, 100);
		gl.glEnd();
		//back land
		gl.glBegin(GL2.GL_QUADS);
			gl.glTexCoord2f(0f, 30f);gl.glVertex3f(10, 0, 0);
			gl.glTexCoord2f(40f, 30f);gl.glVertex3f(100, 0, 0);
			gl.glTexCoord2f(40f, 0f);gl.glVertex3f(100, 0, 30);
			gl.glTexCoord2f(0f, 0f);gl.glVertex3f(0, 0, 30);	
		gl.glEnd();
		//right land
		gl.glBegin(GL2.GL_QUADS);
			gl.glTexCoord2f(0f, 30f);gl.glVertex3f(60, 0, 30);
			gl.glTexCoord2f(40f, 30f);gl.glVertex3f(100, 0, 30);
			gl.glTexCoord2f(40f, 0f);gl.glVertex3f(100, 0, 70);
			gl.glTexCoord2f(0f, 0f);gl.glVertex3f(60, 0, 70);	
		gl.glEnd();
		//front land
		gl.glBegin(GL2.GL_QUADS);
			gl.glTexCoord2f(0f, 30f);gl.glVertex3f(10, 0, 70);
			gl.glTexCoord2f(40f, 30f);gl.glVertex3f(100, 0, 70);
			gl.glTexCoord2f(40f, 0f);gl.glVertex3f(100, 0, 100);
			gl.glTexCoord2f(0f, 0f);gl.glVertex3f(10, 0, 100);	
		gl.glEnd();
		gl.glDisable(GL2.GL_TEXTURE_2D);
		
		gl.glEnable(GL2.GL_TEXTURE_2D);
		floorTex.bind(gl);
		//land
		gl.glBegin(GL2.GL_QUADS);
			gl.glTexCoord2f(0f, 30f);gl.glVertex3f(10, 0, 30);
			gl.glTexCoord2f(40f, 30f);gl.glVertex3f(60, 0, 30);
			gl.glTexCoord2f(40f, 0f);gl.glVertex3f(60, 0, 70);
			gl.glTexCoord2f(0f, 0f);gl.glVertex3f(10, 0, 70);
		gl.glEnd();
		gl.glDisable(GL2.GL_TEXTURE_2D);
		
		gl.glEnable(GL2.GL_CULL_FACE);
		gl.glEnable(GL2.GL_TEXTURE_2D);
		sideExteriorTex.bind(gl);
		//Exterior left, whole wall
		gl.glBegin(GL2.GL_QUADS);
			gl.glTexCoord2f(0f, 15f);gl.glVertex3f(10, 0, 70);
			gl.glTexCoord2f(20f, 15f);gl.glVertex3f(10, 40, 70);
			gl.glTexCoord2f(20f, 0f);gl.glVertex3f(10, 40, 30);
			gl.glTexCoord2f(0f, 0f);gl.glVertex3f(10, 0, 30);
		gl.glEnd();
		//Exterior right, whole wall
		gl.glBegin(GL2.GL_QUADS);
			gl.glTexCoord2f(0f, 15f);gl.glVertex3f(60, 0, 30);
			gl.glTexCoord2f(20f, 15f);gl.glVertex3f(60, 40, 30);
			gl.glTexCoord2f(20f, 0f);gl.glVertex3f(60, 40, 70);
			gl.glTexCoord2f(0f, 0f);gl.glVertex3f(60, 0, 70);
		gl.glEnd();
		//Exterior top
		gl.glBegin(GL2.GL_QUADS);
			gl.glTexCoord2f(0f, 15f);gl.glVertex3f(10, 40, 30);
			gl.glTexCoord2f(20f, 15f);gl.glVertex3f(60, 40, 30);
			gl.glTexCoord2f(20f, 0f);gl.glVertex3f(60, 40, 70);
			gl.glTexCoord2f(0f, 0f);gl.glVertex3f(10, 40, 70);
		gl.glEnd();
		sideInteriorTex.bind(gl);
		//Interior left, whole wall
		gl.glBegin(GL2.GL_QUADS);
			gl.glTexCoord2f(0f, 15f);gl.glVertex3f(10, 0, 30);
			gl.glTexCoord2f(20f, 15f);gl.glVertex3f(10, 40, 30);
			gl.glTexCoord2f(20f, 0f);gl.glVertex3f(10, 40, 70);
			gl.glTexCoord2f(0f, 0f);gl.glVertex3f(10, 0, 70);
		gl.glEnd();
		//Interior right, whole wall
		gl.glBegin(GL2.GL_QUADS);
			gl.glTexCoord2f(0f, 15f);gl.glVertex3f(60, 0, 70);
			gl.glTexCoord2f(20f, 15f);gl.glVertex3f(60, 40, 70);
			gl.glTexCoord2f(20f, 0f);gl.glVertex3f(60, 40, 30);
			gl.glTexCoord2f(0f, 0f);gl.glVertex3f(60, 0, 30);
		gl.glEnd();
		//Interior top
		gl.glBegin(GL2.GL_QUADS);
			gl.glTexCoord2f(0f, 15f);gl.glVertex3f(10, 40, 30);
			gl.glTexCoord2f(20f, 15f);gl.glVertex3f(10, 40, 70);
			gl.glTexCoord2f(20f, 0f);gl.glVertex3f(60, 40, 70);
			gl.glTexCoord2f(0f, 0f);gl.glVertex3f(60, 40, 30);
		gl.glEnd();
		gl.glDisable(GL2.GL_TEXTURE_2D);		
		gl.glDisable(GL2.GL_CULL_FACE);
		
		gl.glEnable(GL2.GL_CULL_FACE);
		gl.glEnable(GL2.GL_TEXTURE_2D);
		outsideTex.bind(gl);
		gl.glEnable(GL2.GL_TEXTURE_GEN_S);
		gl.glEnable(GL2.GL_TEXTURE_GEN_T);
			gl.glTexGeni(GL2.GL_S, GL2.GL_TEXTURE_GEN_MODE, GL2.GL_OBJECT_LINEAR);
			gl.glTexGeni(GL2.GL_T, GL2.GL_TEXTURE_GEN_MODE, GL2.GL_OBJECT_LINEAR);
			float[] coef_s = {0.5f, 0, 0.5f, 0};
			gl.glTexGenfv(GL2.GL_S, GL2.GL_OBJECT_PLANE, coef_s, 0);
			float[] coef_t = {0, 0.5f, 0, 0};
			gl.glTexGenfv(GL2.GL_T, GL2.GL_OBJECT_PLANE, coef_t, 0);
			//front, left to door
			gl.glBegin(GL2.GL_QUADS);
				gl.glVertex3f(30, 0, 70);
				gl.glVertex3f(30, 40, 70);
				gl.glVertex3f(10, 40, 70);
				gl.glVertex3f(10, 0, 70);
			gl.glEnd();
			//front, middle, above door
			gl.glBegin(GL2.GL_QUADS);
				gl.glVertex3f(34, 7, 70);
				gl.glVertex3f(34, 40, 70);
				gl.glVertex3f(30, 40, 70);
				gl.glVertex3f(30, 7, 70);	
			gl.glEnd();
			//front, right to door
			gl.glBegin(GL2.GL_QUADS);
				gl.glVertex3f(60, 0, 70);
				gl.glVertex3f(60, 40, 70);
				gl.glVertex3f(34, 40, 70);
				gl.glVertex3f(34, 0, 70);	
			gl.glEnd();
			//back exterior, left to door
			gl.glBegin(GL2.GL_QUADS);
				gl.glVertex3f(10, 0, 30);
				gl.glVertex3f(10, 40, 30);
				gl.glVertex3f(15, 40, 30);
				gl.glVertex3f(15, 0, 30);
			gl.glEnd();	
			//back exterior, top of door
			gl.glBegin(GL2.GL_QUADS);
				gl.glVertex3f(15, 7, 30);
				gl.glVertex3f(15, 40, 30);
				gl.glVertex3f(19, 40, 30);
				gl.glVertex3f(19, 7, 30);
			gl.glEnd();	
			//back exterior, right to door
			gl.glBegin(GL2.GL_QUADS);
				gl.glVertex3f(19, 0, 30);
				gl.glVertex3f(19, 40, 30);
				gl.glVertex3f(60, 40, 30);
				gl.glVertex3f(60, 0, 30);
			gl.glEnd();

		interiorTex.bind(gl);
		gl.glEnable(GL2.GL_TEXTURE_GEN_S);	
			//interior front, left to door
			gl.glBegin(GL2.GL_QUADS);
				gl.glVertex3f(10, 0, 70);
				gl.glVertex3f(10, 40, 70);
				gl.glVertex3f(30, 40, 70);
				gl.glVertex3f(30, 0, 70);
			gl.glEnd();
			//interior front, middle, above door
			gl.glBegin(GL2.GL_QUADS);
				gl.glVertex3f(30, 7, 70);
				gl.glVertex3f(30, 40, 70);
				gl.glVertex3f(34, 40, 70);
				gl.glVertex3f(34, 7, 70);
			gl.glEnd();
			//interior front, right to door
			gl.glBegin(GL2.GL_QUADS);
				gl.glVertex3f(34, 0, 70);
				gl.glVertex3f(34, 40, 70);
				gl.glVertex3f(60, 40, 70);
				gl.glVertex3f(60, 0, 70);
			gl.glEnd();		
			//back interior, left to door
			gl.glBegin(GL2.GL_QUADS);
				gl.glVertex3f(15, 0, 30);
				gl.glVertex3f(15, 40, 30);
				gl.glVertex3f(10, 40, 30);
				gl.glVertex3f(10, 0, 30);
			gl.glEnd();	
			//back interior, top of door
			gl.glBegin(GL2.GL_QUADS);
				gl.glVertex3f(19, 7, 30);
				gl.glVertex3f(19, 40, 30);
				gl.glVertex3f(15, 40, 30);
				gl.glVertex3f(15, 7, 30);
			gl.glEnd();	
			//back interior, right to door
			gl.glBegin(GL2.GL_QUADS);
				gl.glVertex3f(60, 0, 30);
				gl.glVertex3f(60, 40, 30);
				gl.glVertex3f(19, 40, 30);
				gl.glVertex3f(19, 0, 30);
			gl.glEnd();
		gl.glDisable(GL2.GL_TEXTURE_GEN_S);
		gl.glDisable(GL2.GL_TEXTURE_GEN_T);
		gl.glDisable(GL2.GL_TEXTURE_2D);		
		gl.glDisable(GL2.GL_CULL_FACE);
		
		drawTable(gl, glu);
		drawChair(gl, glu, 42f, 45f);
		drawChair(gl, glu, 42f, 48f);
		drawChair(gl, glu, 52f, 45f);
		drawChair(gl, glu, 52f, 48f);
		drawSofa(gl, glu);
	}

	public void drawTable(GL2 gl, GLU glu){
	
		gl.glEnable(GL2.GL_TEXTURE_2D);
			woodTex.bind(gl);
			gl.glPushMatrix();
				gl.glTranslatef(50f, 0, 50f);
				gl.glRotatef(-90f, 1f, 0f, 0f);
				glu.gluCylinder(quadric, 0.2f, 0.2f, 3.5f, 10, 10);
			gl.glPopMatrix();
			gl.glPushMatrix();
				gl.glTranslatef(50f, 0, 46f);
				gl.glRotatef(-90f, 1f, 0f, 0f);
				glu.gluCylinder(quadric, 0.2f, 0.2f, 3.5f, 10, 10);
			gl.glPopMatrix();
			gl.glPushMatrix();
				gl.glTranslatef(46f, 0, 46f);
				gl.glRotatef(-90f, 1f, 0f, 0f);
				glu.gluCylinder(quadric, 0.2f, 0.2f, 3.5f, 10, 10);
			gl.glPopMatrix();
			gl.glPushMatrix();
				gl.glTranslatef(46f, 0, 50f);
				gl.glRotatef(-90f, 1f, 0f, 0f);
				glu.gluCylinder(quadric, 0.2f, 0.2f, 3.5f, 10, 10);
			gl.glPopMatrix();
			gl.glPushMatrix();
				gl.glTranslatef(48f, 3.5f, 48f);
				gl.glRotatef(-90f, 1f, 0f, 0f);
				glu.gluDisk(quadric, 5f, 0f, 10, 10);
			gl.glPopMatrix();
		gl.glDisable(GL2.GL_TEXTURE_2D);	
	}
	
	public void drawChair(GL2 gl, GLU glu, float lx, float lz){
		gl.glEnable(GL2.GL_TEXTURE_2D);
			chairTex.bind(gl);
			gl.glPushMatrix();
				gl.glTranslatef(lx, 0, lz);
				gl.glRotatef(-90f, 1f, 0f, 0f);
				glu.gluCylinder(quadric, 0.5f, 0f, 2f, 10, 10);
			gl.glPopMatrix();
			gl.glPushMatrix();
				gl.glTranslatef(lx, 2f, lz);
				gl.glRotatef(-90f, 1f, 0f, 0f);
				glu.gluDisk(quadric, 1f, 0f, 10, 10);
			gl.glPopMatrix();
		gl.glDisable(GL2.GL_TEXTURE_2D);
		
	}
	
	public void drawSofa(GL2 gl, GLU glu){
		gl.glEnable(GL2.GL_TEXTURE_2D);
		woodTex.bind(gl);
			//sofa back
			gl.glBegin(GL2.GL_QUADS);
				gl.glTexCoord2f(0, 3f); gl.glVertex3f(11f, 0f, 40f);
				gl.glTexCoord2f(4f, 3f); gl.glVertex3f(11f, 2f, 40f);
				gl.glTexCoord2f(4f, 0f); gl.glVertex3f(11f, 2f, 34f);
				gl.glTexCoord2f(0, 0f); gl.glVertex3f(11f, 0, 34f);
			gl.glEnd();
			gl.glBegin(GL2.GL_QUADS);
				gl.glTexCoord2f(0, 3f); gl.glVertex3f(11.5f, 0f, 40f);
				gl.glTexCoord2f(4f, 3f); gl.glVertex3f(11.5f, 2f, 40f);
				gl.glTexCoord2f(4f, 0f); gl.glVertex3f(11.5f, 2f, 34f);
				gl.glTexCoord2f(0, 0f); gl.glVertex3f(11.5f, 0, 34f);
			gl.glEnd();
			gl.glBegin(GL2.GL_QUADS);
				gl.glTexCoord2f(0, 1f); gl.glVertex3f(11f, 0f, 40f);	
				gl.glTexCoord2f(.5f, 1f); gl.glVertex3f(11f, 2f, 40f);
				gl.glTexCoord2f(.5f, 0f); gl.glVertex3f(11.5f, 2f, 40f);
				gl.glTexCoord2f(0, 0f); gl.glVertex3f(11.5f, 0, 40f);
			gl.glEnd();
			gl.glBegin(GL2.GL_QUADS);
				gl.glTexCoord2f(0, 1f); gl.glVertex3f(11f, 0f, 34f);	
				gl.glTexCoord2f(0.5f, 1f); gl.glVertex3f(11f, 2f, 34f);
				gl.glTexCoord2f(0.5f, 0f); gl.glVertex3f(11.5f, 2f, 34f);
				gl.glTexCoord2f(0, 0f); gl.glVertex3f(11.5f, 0, 34f);
			gl.glEnd();
			gl.glBegin(GL2.GL_QUADS);
				gl.glTexCoord2f(0, 1f); gl.glVertex3f(11.5f, 2f, 40f);	
				gl.glTexCoord2f(4f, 1f); gl.glVertex3f(11f, 2f, 40f);
				gl.glTexCoord2f(4f, 0f); gl.glVertex3f(11f, 2f, 34f);
				gl.glTexCoord2f(0, 0f); gl.glVertex3f(11.5f, 2f, 34f);
			gl.glEnd();
			
			//sofa seat
			//front
			gl.glBegin(GL2.GL_QUADS);
				gl.glTexCoord2f(0, 3f); gl.glVertex3f(13f, 0f, 40f);
				gl.glTexCoord2f(4f, 3f); gl.glVertex3f(13f, 1f, 40f);
				gl.glTexCoord2f(4f, 0f); gl.glVertex3f(13f, 1f, 34f);
				gl.glTexCoord2f(0, 0f); gl.glVertex3f(13f, 0, 34f);
			gl.glEnd();
			//top
			gl.glBegin(GL2.GL_QUADS);
				gl.glTexCoord2f(0, 3f); gl.glVertex3f(13f, 1f, 40f);
				gl.glTexCoord2f(4f, 3f); gl.glVertex3f(11.5f, 1f, 40f);
				gl.glTexCoord2f(4f, 0f); gl.glVertex3f(11.5f, 1f, 34f);
				gl.glTexCoord2f(0, 0f); gl.glVertex3f(13f, 1f, 34f);
			gl.glEnd();
			//left
			gl.glBegin(GL2.GL_QUADS);
				gl.glTexCoord2f(0, 1f); gl.glVertex3f(11.5f, 0f, 40f);	
				gl.glTexCoord2f(.5f, 1f); gl.glVertex3f(11.5f, 1f, 40f);
				gl.glTexCoord2f(.5f, 0f); gl.glVertex3f(13f, 1f, 40f);
				gl.glTexCoord2f(0, 0f); gl.glVertex3f(13f, 0, 40f);
			gl.glEnd();
			//right
			gl.glBegin(GL2.GL_QUADS);	
				gl.glTexCoord2f(0, 1f); gl.glVertex3f(11.5f, 0f, 34f);	
				gl.glTexCoord2f(0.5f, 1f); gl.glVertex3f(11.5f, 1f, 34f);
				gl.glTexCoord2f(0.5f, 0f); gl.glVertex3f(13f, 1f, 34f);
				gl.glTexCoord2f(0, 0f); gl.glVertex3f(13f, 0, 34f);
			gl.glEnd();
			
		gl.glDisable(GL2.GL_TEXTURE_2D);
	}
	
}
