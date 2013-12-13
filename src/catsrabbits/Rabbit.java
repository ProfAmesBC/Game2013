// Diana Cheung, CS333 Class of 2013
package catsrabbits;
import javax.media.opengl.GL2;import javax.media.opengl.glu.GLU;

import weapons.Projectile;
import game.Building;
import game.PlayerStats;

public class Rabbit extends Critter{
	private static final float BODY_RADIUS=1,BODY_HEIGHT_WIDTH_RATIO=1.7f,EYE_CENTER_HEIGHT=.245f,EYE_ZDIST=-.355f,
			WHISKER_COLOR=.87f,FOOT_CENTER_DISTANCE=.355f;
	
	public Rabbit(float x,float y,float z,float a,float s,float tR, GL2 gl,GLU glu){
		super(x,y,z,a,s,tR,gl,glu);
		tRate=.01f;
        texture=Building.setupTexture(gl,"cheungrabbitfur"+(int)(Math.random()*5)+".jpg", FUR_DIRECTORY);
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
			
			gl.glTranslatef(0, -BODY_RADIUS, .86f);
			drawTail(gl,glu);

			gl.glTranslatef(FOOT_CENTER_DISTANCE, -.38f, -1.545f);
			gl.glRotatef(32.86f,1,0,0);
			gl.glEnable(GL2.GL_TEXTURE_2D);
			drawLegs(gl,glu);
			gl.glDisable(GL2.GL_TEXTURE_2D);
		gl.glPopMatrix();
	}
	
	protected void drawBody(GL2 gl, GLU glu){
		gl.glPushMatrix();
			gl.glScalef(1, BODY_HEIGHT_WIDTH_RATIO, 1);
			drawTexturedUnitSphere(glu);
		gl.glPopMatrix();
	}
	protected void drawHead(GL2 gl,GLU glu){
		gl.glPushMatrix();
			gl.glTranslatef(0, BODY_HEIGHT_WIDTH_RATIO, -.3f);
			gl.glEnable(GL2.GL_TEXTURE_2D);
			drawSphere(textureQuadric,.65f,glu);
			gl.glDisable(GL2.GL_TEXTURE_2D);
			
			gl.glColor3f(0, 0, 0);
			gl.glTranslatef(0, EYE_CENTER_HEIGHT, EYE_ZDIST);
			drawEyes(gl,glu,.23f,.185f);
			
			gl.glTranslatef(0, -EYE_CENTER_HEIGHT, -.65f-EYE_ZDIST);
			drawNose(gl,glu);
			// draw ears
			gl.glTranslatef(0, .335f, .8f);
			gl.glEnable(GL2.GL_TEXTURE_2D);
			drawEars(gl,glu);
			gl.glDisable(GL2.GL_TEXTURE_2D);
		gl.glPopMatrix();
	}
	protected void drawNose(GL2 gl,GLU glu){
		// draw nose
		gl.glColor3f(1, .77f, 1);
		drawSphere(quadric, .13f, glu);
		// draw whiskers
		gl.glColor3f(WHISKER_COLOR,WHISKER_COLOR,WHISKER_COLOR);
		draw6Whiskers(gl,glu);
	}
	protected void drawOneEar(GL2 gl,GLU glu){
		int rotate=(int)(32f*Math.cos(Math.toRadians(t*360)))-10;
		gl.glPushMatrix();
			gl.glRotatef(rotate, 0, 0, -1);
			gl.glTranslatef(1.285f,0,0);
			gl.glScalef(1.5f, .1f, .2f);
			drawTexturedUnitSphere(glu);
		gl.glPopMatrix();
	}
	private void drawArm(GL2 gl,GLU glu){
		int rotate=(int)(8f*Math.sin(Math.toRadians(t*360-45)));
		gl.glPushMatrix();
			gl.glRotatef(rotate, 0, 0, -1);
			gl.glTranslatef(.695f,.58f,0);
			gl.glScalef(.82f, .3f, .3f);
			drawTexturedUnitSphere(glu);
		gl.glPopMatrix();
	}
	protected void drawTail(GL2 gl, GLU glu) {
		gl.glColor3f(1, 1, 1);
		drawSphere(quadric, .46f, glu);
	}
	protected void drawLegs(GL2 gl,GLU glu){
		gl.glPushMatrix();
			float xR=.3f;
			gl.glScalef(xR*.5f, xR*2.1f, xR);
			drawTexturedUnitSphere(glu);	// draw foot
			gl.glTranslatef(-2/xR*FOOT_CENTER_DISTANCE,0,0);
			drawTexturedUnitSphere(glu);	// draw foot
		gl.glPopMatrix();
	}
	protected void move(){
		super.move();
		y+=.07*(float)Math.cos(Math.toRadians(t*360));
	}

	public float size(){return 3*BODY_HEIGHT_WIDTH_RATIO;}

	public void playNoise(){}
}
