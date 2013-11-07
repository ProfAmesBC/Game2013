package buildings;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;

public class JossickTable {

	private GLUquadric q;

	public JossickTable(GL2 gl, GLU glu) {
		q =glu.gluNewQuadric();
	}

	public void draw(GL2 gl, GLU glu, double xpos, double zpos) {
		gl.glColor3d(.5, .2, .2);
		gl.glPushMatrix();
		  gl.glTranslated(xpos,0,zpos);
		  gl.glRotated(-90,1,0,0);
		  glu.gluCylinder(q, .25,.25,3,5,5);
		gl.glPopMatrix();

		gl.glPushMatrix();
		  gl.glTranslated(xpos+4,0,zpos);
		  gl.glRotated(-90,1,0,0);
		  glu.gluCylinder(q, .25,.25,3,5,5);
		gl.glPopMatrix();

		gl.glPushMatrix();
		  gl.glTranslated(xpos+4,0,zpos+4);
		  gl.glRotated(-90,1,0,0);
		  glu.gluCylinder(q, .25,.25,3,5,6);
		gl.glPopMatrix();

		gl.glPushMatrix();
		  gl.glTranslated(xpos,0,zpos+4);
		  gl.glRotated(-90,1,0,0);
		  glu.gluCylinder(q, .25,.25,3,5,5);
		gl.glPopMatrix();
		
		gl.glColor3d(.7, .4, .4);
		gl.glPushMatrix();
		  gl.glTranslated(xpos+2.5,3,zpos+2.5);
		  gl.glRotated(-90,1,0,0);
		  glu.gluDisk(q, .001, 5, 10, 10);
		  gl.glPopMatrix();
	}

}
