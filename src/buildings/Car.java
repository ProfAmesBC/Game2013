package buildings;
import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;

import com.jogamp.opengl.util.gl2.GLUT;


public class Car {
	
	private GLUT glut = new GLUT();
	private double xStart;
	private double yStart;
	private double zStart;
	private double angleOfRotation;
	private double red;
	private double green;
	private double blue;
	
	public Car(double xStart, double yStart, double zStart,
			double red, double green, double blue,
			double angleOfRotation) {
		this.xStart = xStart;
		this.yStart = yStart;
		this.zStart = zStart;
		this.red = red;
		this.green = green;
		this.blue = blue;
		this.angleOfRotation = angleOfRotation;
	}

	public void draw(GL2 gl, GLU glu){
		gl.glColor3d(red,green,blue);
		gl.glPushMatrix();
        gl.glTranslated(xStart,yStart,zStart);
        gl.glScaled(3,4,3);
        gl.glRotated(angleOfRotation,0,1,0);
        gl.glPushMatrix();
        gl.glPushMatrix();
        gl.glScaled(2,.5,1);
        glut.glutSolidCube(.5f);
        gl.glPopMatrix();
        gl.glTranslated(0,0,.25);
        gl.glPushMatrix();
        gl.glTranslated(-.4,-.2,0);
        glut.glutSolidTorus(.05,.1,8,8);
        gl.glTranslated(.8,0,0);
        glut.glutSolidTorus(.05,.1,8,8);
        gl.glPopMatrix();
        gl.glTranslated(0,0,-.5);
        gl.glPushMatrix();
        gl.glTranslated(-.4,-.2,0);
        glut.glutSolidTorus(.05,.1,8,8);
        gl.glTranslated(.8,0,0);
        glut.glutSolidTorus(.05,.1,8,8);
        gl.glPopMatrix();
        gl.glPopMatrix();
        gl.glPopMatrix();
	}
}
