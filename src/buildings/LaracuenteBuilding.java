package buildings;
import game.Building;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;

public class LaracuenteBuilding extends Building{

	public LaracuenteBuilding(GL2 gl, GLU glu){
	}
	// bricks
	@Override
	public void draw(GL2 gl, GLU glu) {
	  gl.glPushMatrix();
	  gl.glTranslatef(50,0,50);
	  gl.glScalef(1,-1,1);
		//floor
		gl.glColor3f(0.9f, 0.5f, 0.2f);
		gl.glBegin(GL2.GL_QUADS);
		gl.glTexCoord2f(0f,2f); gl.glVertex3f(-50,  0, 50);
		gl.glTexCoord2f(3f,2f); gl.glVertex3f( 50,  0, 50);
		gl.glTexCoord2f(3f,0f); gl.glVertex3f( 50, 0, -50);
		gl.glTexCoord2f(0f,0f); gl.glVertex3f(-50, 0, -50);
		gl.glEnd();

		//wall
		gl.glPushMatrix();
		gl.glRotatef(90f, 1f, 0f, 0f);
		gl.glColor3f(0f, 0f, 0f);
		gl.glBegin(GL2.GL_QUADS);
		gl.glTexCoord2f(0f,2f); gl.glVertex3f(-30,  30, 0);
		gl.glTexCoord2f(3f,2f); gl.glVertex3f( -30,  -30, 0);
		gl.glTexCoord2f(3f,0f); gl.glVertex3f( -30,  -30, 125);
		gl.glTexCoord2f(0f,0f); gl.glVertex3f(-30,  30, 125);
		gl.glEnd();

		//wall with a door
		gl.glPushMatrix();
		gl.glRotatef(90f, 0f, 0f, 1f);
		gl.glColor3f(0f, 0f, 0f);
		gl.glBegin(GL2.GL_QUADS);
		gl.glTexCoord2f(0f,2f); gl.glVertex3f(-30,  30, 0);
		gl.glTexCoord2f(3f,2f); gl.glVertex3f( -30,  0, 0);
		gl.glTexCoord2f(3f,0f); gl.glVertex3f( -30,  0, 15);
		gl.glTexCoord2f(0f,0f); gl.glVertex3f(-30,  30, 15);
		gl.glEnd();
		gl.glPushMatrix();
		gl.glColor3f(0f, 0f, 0f);
		gl.glBegin(GL2.GL_QUADS);
		gl.glTexCoord2f(0f,2f); gl.glVertex3f(-30,  -10, 0);
		gl.glTexCoord2f(3f,2f); gl.glVertex3f( -30,  -30, 0);
		gl.glTexCoord2f(3f,0f); gl.glVertex3f( -30,  -30, 15);
		gl.glTexCoord2f(0f,0f); gl.glVertex3f(-30,  -10, 15);
		gl.glEnd();
		gl.glPushMatrix();
		gl.glColor3f(0f, 0f, 0f);
		gl.glBegin(GL2.GL_QUADS);
		gl.glTexCoord2f(0f,2f); gl.glVertex3f(-30,  30, 15);
		gl.glTexCoord2f(3f,2f); gl.glVertex3f( -30,  -30, 15);
		gl.glTexCoord2f(3f,0f); gl.glVertex3f( -30,  -30, 125);
		gl.glTexCoord2f(0f,0f); gl.glVertex3f(-30,  30, 125);
		gl.glEnd();

		//next wall with a door
		gl.glPushMatrix();
		gl.glRotatef(90f, 0f, 0f, 1f);
		gl.glColor3f(0f, 0f, 0f);
		gl.glBegin(GL2.GL_QUADS);
		gl.glTexCoord2f(0f,2f); gl.glVertex3f(-30,  30, 0);
		gl.glTexCoord2f(3f,2f); gl.glVertex3f( -30,  0, 0);
		gl.glTexCoord2f(3f,0f); gl.glVertex3f( -30,  0, 15);
		gl.glTexCoord2f(0f,0f); gl.glVertex3f(-30,  30, 15);
		gl.glEnd();
		gl.glPushMatrix();
		gl.glColor3f(0f, 0f, 0f);
		gl.glBegin(GL2.GL_QUADS);
		gl.glTexCoord2f(0f,2f); gl.glVertex3f(-30,  -10, 0);
		gl.glTexCoord2f(3f,2f); gl.glVertex3f( -30,  -30, 0);
		gl.glTexCoord2f(3f,0f); gl.glVertex3f( -30,  -30, 15);
		gl.glTexCoord2f(0f,0f); gl.glVertex3f(-30,  -10, 15);
		gl.glEnd();
		gl.glPushMatrix();
		gl.glColor3f(0f, 0f, 0f);
		gl.glBegin(GL2.GL_QUADS);
		gl.glTexCoord2f(0f,2f); gl.glVertex3f(-30,  30, 15);
		gl.glTexCoord2f(3f,2f); gl.glVertex3f( -30,  -30, 15);
		gl.glTexCoord2f(3f,0f); gl.glVertex3f( -30,  -30, 125);
		gl.glTexCoord2f(0f,0f); gl.glVertex3f(-30,  30, 125);
		gl.glEnd();

		//final wall
		gl.glPushMatrix();
		gl.glRotatef(90f, 0f, 0f, 1f);
		gl.glColor3f(0f, 0f, 0f);
		gl.glBegin(GL2.GL_QUADS);
		gl.glTexCoord2f(0f,2f); gl.glVertex3f(-30,  30, 0);
		gl.glTexCoord2f(3f,2f); gl.glVertex3f( -30,  -30, 0);
		gl.glTexCoord2f(3f,0f); gl.glVertex3f( -30,  -30, 125);
		gl.glTexCoord2f(0f,0f); gl.glVertex3f(-30,  30, 125);
		gl.glEnd();

		//Chair
		gl.glBegin(GL2.GL_QUADS);
		gl.glVertex3f(-16, 10, 0);
		gl.glVertex3f(-16, 13, 0);
		gl.glVertex3f(-16, 13, 12);
		gl.glVertex3f(-16, 10, 12);
		gl.glEnd();
		gl.glBegin(GL2.GL_QUADS);
		gl.glVertex3f(-8, 10, 0);
		gl.glVertex3f(-8, 13, 0);
		gl.glVertex3f(-8, 13, 12);
		gl.glVertex3f(-8, 10, 12);
		gl.glEnd();
		gl.glBegin(GL2.GL_QUADS);
		gl.glVertex3f(-8, 2, 0);
		gl.glVertex3f(-8, 5, 0);
		gl.glVertex3f(-8, 5, 12); 
		gl.glVertex3f(-8, 2, 12);
		gl.glEnd();
		gl.glBegin(GL2.GL_QUADS);
		gl.glVertex3f(-16, 2, 0);
		gl.glVertex3f(-16, 5, 0);
		gl.glVertex3f(-16, 5, 12);
		gl.glVertex3f(-16, 2, 12);
		gl.glEnd();
	
		gl.glPushMatrix();
		gl.glRotatef(-90f, 1f, 0f, 0f);
		gl.glBegin(GL2.GL_QUADS);
		gl.glTexCoord2f(0f,2f); gl.glVertex3f(-8,  -12, 2);
		gl.glTexCoord2f(3f,2f); gl.glVertex3f( -8,  -12, 13);
		gl.glTexCoord2f(3f,0f); gl.glVertex3f( -16, -12, 13);
		gl.glTexCoord2f(0f,0f); gl.glVertex3f(-16, -12, 2);
		gl.glEnd();
		gl.glPopMatrix();
	

		gl.glPopMatrix();
		gl.glPopMatrix();
		gl.glPopMatrix();
		gl.glPopMatrix();
		gl.glPopMatrix();
		gl.glPopMatrix(); 
		gl.glPopMatrix();
		gl.glPopMatrix(); 
	  gl.glPopMatrix();
	}
}
