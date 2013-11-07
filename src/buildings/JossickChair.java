package buildings;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;

public class JossickChair {
	private GLUquadric q;

	public JossickChair(GL2 gl, GLU glu) {
		q =glu.gluNewQuadric();
	}

	public void draw(GL2 gl, GLU glu, double xpos, double zpos) {
		gl.glColor3d(.55, .2, .2);
		gl.glPushMatrix();
		  gl.glTranslated(xpos,0,zpos);
		  gl.glRotated(-90,1,0,0);
		  glu.gluCylinder(q, .25,.25,2,5,5);
		gl.glPopMatrix();

		gl.glPushMatrix();
		  gl.glTranslated(xpos+2,0,zpos);
		  gl.glRotated(-90,1,0,0);
		  glu.gluCylinder(q, .25,.25,2,5,5);
		gl.glPopMatrix();

		gl.glPushMatrix();
		  gl.glTranslated(xpos+2,0,zpos+2);
		  gl.glRotated(-90,1,0,0);
		  glu.gluCylinder(q, .25,.25,6,5,6);
		gl.glPopMatrix();

		gl.glPushMatrix();
		  gl.glTranslated(xpos,0,zpos+2);
		  gl.glRotated(-90,1,0,0);
		  glu.gluCylinder(q, .25,.25,6,5,5);
		gl.glPopMatrix();
		
		gl.glColor3d(0, 0, 1);
		gl.glPushMatrix();
		  gl.glTranslated(xpos+1,2,zpos+2);
		  gl.glRotated(-90,1,0,0);
		  glu.gluPartialDisk(q, .01, 2.5, 10, 10, -90, 180);
		  gl.glPopMatrix();
		  
		  gl.glColor3d(0, .5, .5);
			gl.glPushMatrix();
			  gl.glTranslated(xpos+1,5,zpos+2);
			  //gl.glRotated(-90,1,0,0);
			  glu.gluPartialDisk(q, .01, 1.2, 10, 10, -90, 180);
	       gl.glPopMatrix();
	}
}
