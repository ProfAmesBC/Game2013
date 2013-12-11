package Enemies;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;

public class Bat {
	private static double SPEED = 1;
	private GLUquadric quadric;
	private float x, y, z;
	private float angle;
	private float vert_rotate = 50;
	private double t = 0;
	private double ANIMATION_SPEED = .7;

	public Bat(GL2 gl, GLU glu) {
		 quadric = glu.gluNewQuadric();
		 glu.gluQuadricDrawStyle(quadric, GLU.GLU_FILL); // GLU_POINT, GLU_LINE, GLU_FILL, GLU_SILHOUETTE
	     glu.gluQuadricNormals  (quadric, GLU.GLU_NONE); // GLU_NONE, GLU_FLAT, or GLU_SMOOTH
	     glu.gluQuadricTexture  (quadric, true);        // true to generate texture coordinates
	     x = 50;
	     y = 6;
	     z = 50;
	     angle = 0;
	}

	public void draw(GL2 gl, GLU glu) {
		gl.glEnable(GL2.GL_MAP2_VERTEX_3);
		gl.glEnable(GL2.GL_AUTO_NORMAL);
		gl.glPushMatrix();
			gl.glTranslatef(x, y, z);
			gl.glRotatef(angle, 0, 1, 0);
			gl.glRotatef(vert_rotate, 1, 0, 0);
			drawBody(gl, glu);
			drawWings(gl,glu);
			drawHead(gl, glu);
		gl.glPopMatrix();
		move();
		gl.glDisable(GL2.GL_MAP2_VERTEX_3);
		gl.glDisable(GL2.GL_AUTO_NORMAL);
	}

	private void drawHead(GL2 gl, GLU glu) {
		gl.glPushMatrix();
			gl.glTranslatef(0,.5f,0);
			drawHeadHalf(gl,glu, 1);
			drawHeadHalf(gl, glu, -1);
		gl.glPopMatrix();
	}

	private void drawHeadHalf(GL2 gl, GLU glu, int direction) {
		gl.glPushMatrix();
			gl.glRotatef(-direction*30, 0,1,1);
			gl.glScaled(3, 2, 7);
			gl.glTranslated(.1*direction, 0, 0);
			gl.glPushMatrix();
				gl.glColor3f(.7f, 0, 0);
				gl.glTranslatef(0, .1f, .04f);
				gl.glRotated(90, 0, 0, 1);
				gl.glEnable(GL2.GL_BLEND);
				gl.glBlendFunc(GL2.GL_SRC_ALPHA, GL2.GL_ONE_MINUS_SRC_ALPHA);
				gl.glColor4f((float) (Math.sin(t)/5+.25), 0, 0, .9f); // dimmer yellow, translucent
				glu.gluSphere(quadric, .02, 10, 10);
				gl.glDisable(GL2.GL_BLEND);
			gl.glPopMatrix();
			gl.glColor3f(.1f, .1f, .07f);
			glu.gluSphere(quadric, .1, 10,10);
		gl.glPopMatrix();
	}

	private void move() {
		t+=.1;
		angle+=SPEED/2;
		vert_rotate -= (float) 1*Math.sin(t/ANIMATION_SPEED+3.14)/ANIMATION_SPEED;
		z+=.1*SPEED*Math.cos(Math.toRadians(angle));
		// z += (float) (.1*SPEED*Math.random() * 10);
		x+=.1*SPEED*Math.sin(Math.toRadians(angle));
		// x += (float) (.1*SPEED*Math.random() * 10);
		y+= (float) .1*Math.sin(t/ANIMATION_SPEED+4.5)/ANIMATION_SPEED;
		if(angle>360) angle-=360;
	}

	private void drawWings(GL2 gl, GLU glu) {
		gl.glMapGrid2f(20, 0.0f, 1.0f, 20, 0.0f, 1.0f);
		gl.glPushMatrix();
			drawWing(gl, glu, 1);
			drawWing(gl, glu, -1);
		gl.glPopMatrix();
		
	}

	private void drawWing(GL2 gl, GLU glu, int direction) {
		float scale = .75f*(float)Math.sin(t/ANIMATION_SPEED);
//		System.out.println(scale);
		
        gl.glPushMatrix();
        	gl.glColor3f(.07f, .07f, .04f);
        	gl.glTranslatef(direction/2f, 0, 0);
        	gl.glRotated(30*direction*scale, 0, 1, 0);
        	
        	float[] closeSec = {
        			0, 0, 0,
        			.7f*(scale/2+1)*direction, .5f+scale/4, 0,
        			(scale/2+1)*direction, 1, 0,
        			
       		        .1f*(scale/2+1)*direction, -.5f, 0,
       		        (scale/2+1)*direction, 0, (scale-1)/3,
       		        (scale/2+1)*1.5f*direction,  0, 0,

       		        0, -1, 0,
       		        (scale/2+1)*direction, -.75f,(scale-1)/2,
       		        (scale/2+1)*1.5f*direction, -1, 0,
        	};

        	gl.glMap2f(GL2.GL_MAP2_VERTEX_3, 0.0f, 1.0f, 3, 3, 0.0f, 1.0f, 9, 3, closeSec, 0);
        	gl.glEvalMesh2(GL2.GL_FILL, 0, 20, 0, 20);
        	
        	gl.glTranslated((scale/2+1)*direction, 1, 0);
        	gl.glRotated(45*direction*scale-direction*15,  (-.5*(scale/2+1)*direction), 2, 0);

        	drawMid(gl, glu, direction, scale);
        gl.glPopMatrix();
	}

	private void drawMid(GL2 gl, GLU glu, int direction, float scale) {		
		float[] midSec = {
				0, 0, 0,
				0, 0, 0,
		        0, 0, 0,

		        .5f*(scale/2+1)*direction,  -1, 0,
		        (scale/2+1)*direction, -.75f, (scale-1)/4,
		        1.5f*(scale/2+1)*direction,  -.5f, 0,

		        .5f*(scale/2+1)*direction, -2, 0,
		        (scale/2+1)*direction, -1, (scale-1)/2,
		        2.5f*(scale/2+1)*direction, -1.5f, 0,
		};
		
		
		gl.glPushMatrix();
			gl.glColor3f(.1f, .1f, .07f);
			gl.glMap2f(GL2.GL_MAP2_VERTEX_3, 0.0f, 1.0f, 3, 3, 0.0f, 1.0f, 9, 3, midSec, 0);
			gl.glEvalMesh2(GL2.GL_FILL, 0, 20, 0, 20);
			gl.glRotated(45*direction*scale-direction*15, -2.5*(scale/2+1)*direction, 1.5, 0);
			drawFar(gl, glu, direction, scale);
		gl.glPopMatrix();
	}

	private void drawFar(GL2 gl, GLU glu, int direction, float scale) {
		float[] farSec = {
				0, 0, 0,
				0, 0, 0,
		        0, 0, 0,

		        1.5f*(scale/2+1)*direction,  -.5f, 0,
		        1.75f*(scale/2+1)*direction, -.3f, (scale-1)/4,
		        2*(scale/2+1)*direction,  -.25f, 0,

		        2.5f*(scale/2+1)*direction, -1.5f, 0,
		        3*(scale/2+1)*direction, -.9f, (scale-1)/2,
		        3.5f*(scale/2+1)*direction, -1, 0,
		    };
		gl.glPushMatrix();
			gl.glColor3f(.15f, .15f, .15f);
			gl.glMap2f(GL2.GL_MAP2_VERTEX_3, 0.0f, 1.0f, 3, 3, 0.0f, 1.0f, 9, 3, farSec, 0);
			gl.glEvalMesh2(GL2.GL_FILL, 0, 20, 0, 20);
		gl.glPopMatrix();
	}

	private void drawBody(GL2 gl, GLU glu) {
		gl.glPushMatrix();
			gl.glTranslatef(0, -.5f, 0);
			gl.glScalef(.75f, 1, .5f);
			drawFeet(gl, glu);
			gl.glColor3f(.25f, .25f, .2f);
			glu.gluSphere(quadric, 1, 20, 20);
		gl.glPopMatrix();
	}

	private void drawFeet(GL2 gl, GLU glu) {
		gl.glPushMatrix();
			gl.glRotatef(-30, 1, 0, 0);
			drawFoot(gl, glu);
			gl.glScaled(-1, 1, 1);
			drawFoot(gl, glu);
		gl.glPopMatrix();
	}

	private void drawFoot(GL2 gl, GLU glu) {
		gl.glPushMatrix();
			gl.glColor3f(.4f, .35f, .2f);
			gl.glRotatef(30, 0, 0, 1);
			gl.glTranslated(0, -.5f, 0);
			gl.glScaled(.3, .7, .3);
			glu.gluSphere(quadric, 1, 10, 10);
		gl.glPopMatrix();
	}
	public static double getSpeed() {return SPEED;}
	public static void setSpeed(double speed) {SPEED = speed;}
	public float getX() {return x;}
	public void setX(float x) {this.x = x;}
	public float getY() {return y;}
	public void setY(float y) {this.y = y;}
	public float getZ() {return z;}
	public void setZ(float z) {this.z = z;}
	public float getAngle() {return angle;}
	public void setAngle(float angle) {this.angle = angle;}
}
