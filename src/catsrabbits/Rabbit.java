package catsrabbits;
// Diana Cheung, CS333 Class of 2013

import javax.media.opengl.GL2;import javax.media.opengl.glu.GLU;
import game.Building;import java.io.File;

public class Rabbit extends Critter{
	private static final float BODY_RADIUS=2,BODY_HEIGHT_WIDTH_RATIO=1.7f,EYE_CENTER_DISTANCE=.46f,EYE_CENTER_HEIGHT=.49f,
			WHISKER_COLOR=.87f,TOP_WHISKER_LENGTH=2,TOP_WHISKER_HEIGHT=.5f,MID_WHISKER_LENGTH=2.5f,
			FOOT_CENTER_DISTANCE=.71f;
	
	public Rabbit(float x,float y,float z,float a,float s,float tR, GL2 gl,GLU glu){
		super(x,y,z,a,s,tR,gl,glu);
		tRate=.01f;
        texture=Building.setupTexture(gl, FUR_DIRECTORY+File.separator+"cheungrabbitfur"+(int)(Math.random()*5)+".jpg");
	}
	
	public void drawWholeBody(GL2 gl, GLU glu){
		gl.glPushMatrix();
			gl.glEnable(GL2.GL_TEXTURE_2D);
			texture.bind(gl);
			gl.glRotatef(-13.4f,1,0,0);
			drawBody(gl,glu);
			gl.glDisable(GL2.GL_TEXTURE_2D);
			
			drawHead(gl,glu);
			
			gl.glEnable(GL2.GL_TEXTURE_2D);
			drawArm(gl,glu);
			gl.glScalef(-1, 1, 1);
			drawArm(gl,glu);
			gl.glDisable(GL2.GL_TEXTURE_2D);
			
			gl.glTranslatef(0, -BODY_RADIUS, 1.72f);
			drawTail(gl,glu);

			gl.glTranslatef(FOOT_CENTER_DISTANCE, -.76f, -3.09f);
			gl.glRotatef(32.86f,1,0,0);
			gl.glEnable(GL2.GL_TEXTURE_2D);
			drawFeet(gl,glu);
			gl.glDisable(GL2.GL_TEXTURE_2D);
		gl.glPopMatrix();
	}
	
	protected void drawBody(GL2 gl, GLU glu){
		gl.glPushMatrix();
			gl.glScalef(1, BODY_HEIGHT_WIDTH_RATIO, 1);
			drawSphere(textureQuadric,BODY_RADIUS,glu);
		gl.glPopMatrix();
	}
	protected void drawHead(GL2 gl,GLU glu){
		gl.glPushMatrix();
			gl.glTranslatef(0, 2*BODY_HEIGHT_WIDTH_RATIO, -.6f);
			gl.glEnable(GL2.GL_TEXTURE_2D);
			drawSphere(textureQuadric,1.3f,glu);
			gl.glDisable(GL2.GL_TEXTURE_2D);
			
			gl.glColor3f(0, 0, 0);
			float eyeZdist=-.71f;
			gl.glTranslatef(0, EYE_CENTER_HEIGHT, eyeZdist);
			drawEyes(gl,glu,EYE_CENTER_DISTANCE,.37f);
			
			gl.glTranslatef(0, -EYE_CENTER_HEIGHT, -1.3f-eyeZdist);
			drawNose(gl,glu);
			// draw ears
			gl.glTranslatef(0, .67f, 1.6f);
			drawEars(gl,glu);
		gl.glPopMatrix();
	}
	protected void drawNose(GL2 gl,GLU glu){
		// draw nose
		gl.glColor3f(1, .77f, 1);
		drawSphere(quadric, .26f, glu);
		// draw whiskers
		gl.glColor3f(WHISKER_COLOR,WHISKER_COLOR,WHISKER_COLOR);
		gl.glBegin(GL2.GL_LINES);
			gl.glVertex3f(TOP_WHISKER_LENGTH, TOP_WHISKER_HEIGHT, 0);
			gl.glVertex3f(-TOP_WHISKER_LENGTH, -TOP_WHISKER_HEIGHT, 0);
			gl.glVertex3f(MID_WHISKER_LENGTH, 0, 0);
			gl.glVertex3f(-MID_WHISKER_LENGTH, 0, 0);
			gl.glVertex3f(TOP_WHISKER_LENGTH, -TOP_WHISKER_HEIGHT, 0);
			gl.glVertex3f(-TOP_WHISKER_LENGTH, TOP_WHISKER_HEIGHT, 0);
		gl.glEnd();
	}
	protected void drawEar(GL2 gl,GLU glu){
		int rotate=(int)(32f*Math.cos(Math.toRadians(t*360)))-10;
		gl.glPushMatrix();
			gl.glRotatef(rotate, 0, 0, -1);
			gl.glTranslatef(2.55f,0,0);
			gl.glScalef(3, .2f, .4f);
			drawTexturedUnitSphere(glu);
		gl.glPopMatrix();
	}
	private void drawArm(GL2 gl,GLU glu){
		int rotate=(int)(8f*Math.sin(Math.toRadians(t*360-45)));
		gl.glPushMatrix();
			gl.glRotatef(rotate, 0, 0, -1);
			gl.glTranslatef(1.39f,1.16f,0);
			gl.glScalef(1.64f, .6f, .6f);
			drawTexturedUnitSphere(glu);
		gl.glPopMatrix();
	}
	protected void drawTail(GL2 gl, GLU glu) {
		gl.glColor3f(1, 1, 1);
		drawSphere(quadric, .92f, glu);
	}
	protected void drawFeet(GL2 gl,GLU glu){
		gl.glPushMatrix();
			float xR=.3f;
			gl.glScalef(xR, xR*4.2f, xR*2);
			drawTexturedUnitSphere(glu);	// draw foot
			gl.glTranslatef(-2/xR*FOOT_CENTER_DISTANCE,0,0);
			drawTexturedUnitSphere(glu);	// draw foot
		gl.glPopMatrix();
	}
}
