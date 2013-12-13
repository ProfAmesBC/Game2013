// Diana Cheung, CS333 Class of 2013
package catsrabbits;
import javax.media.opengl.GL2;import javax.media.opengl.glu.GLU;

import weapons.Projectile;
import game.*;

public class Cat extends Critter implements PlayerMotionWatcher{
	public static final String soundFilename="cat";
	private static final float BODY_LENGTH=1.8f,HEAD_HEIGHT=.56f,HEAD_DIST=BODY_LENGTH*.7f,
			EYE_CENTER_DIST=.52f,EYE_HEIGHT=.35f,WHISKER_COLOR=.82f,SWIM_ANGLE=26.74f,TAIL_LENGTH=1.83f,TAIL_DIAM=.15f;
	
	private int furColor;
	private float eyeGreen=0;
	private boolean steppedOn=false;
	
	public Cat(float x,float y,float z,float a,float s,float tR, GL2 gl,GLU glu){
		super(x,y,z,a,s,tR,gl,glu);
		tRate=.025f;
		furColor=(int)(Math.random()*5);
		if(furColor==3)eyeGreen=1;	// green eyes for black fur cats
        texture=Building.setupTexture(gl,"cheungcatfur"+furColor+".jpg", FUR_DIRECTORY);
        PlayerMotion.registerPlayerWatcher(this);
	}
	
	public void drawWholeBody(GL2 gl, GLU glu){
		gl.glPushMatrix();
			gl.glEnable(GL2.GL_TEXTURE_2D);
			texture.bind(gl);
			drawBody(gl,glu);
			gl.glDisable(GL2.GL_TEXTURE_2D);
			
			gl.glTranslatef(0,HEAD_HEIGHT,-HEAD_DIST);
			drawHead(gl,glu);
			gl.glTranslatef(0,-.4f,HEAD_DIST+1.62f);
			
			gl.glEnable(GL2.GL_TEXTURE_2D);
			drawTail(gl,glu);
			drawLegs(gl,glu);
			gl.glDisable(GL2.GL_TEXTURE_2D);
		gl.glPopMatrix();
	}
	
	protected void drawBody(GL2 gl, GLU glu){
		gl.glPushMatrix();
			gl.glScalef(1, 1, BODY_LENGTH);
			drawTexturedUnitSphere(glu);
		gl.glPopMatrix();
	}
	protected void drawHead(GL2 gl, GLU glu){
		gl.glEnable(GL2.GL_TEXTURE_2D);
		gl.glPushMatrix();
			gl.glScalef(1.1f,1,.9f);
			drawSphere(textureQuadric,.8f,glu);
		gl.glPopMatrix();
		gl.glDisable(GL2.GL_TEXTURE_2D);
		gl.glPushMatrix();
			// draw eyes
			gl.glColor3f(0,eyeGreen,0);
			gl.glTranslatef(0,EYE_HEIGHT,-EYE_CENTER_DIST);
			drawEyes(gl, glu, .27f, .16f);
			// draw nose
			gl.glTranslatef(0, -EYE_HEIGHT, -.74f+EYE_CENTER_DIST);
			drawNose(gl,glu);
			// draw ears
			gl.glTranslatef(0, .5f, .64f);
			gl.glEnable(GL2.GL_TEXTURE_2D);
			drawEars(gl,glu);
			gl.glDisable(GL2.GL_TEXTURE_2D);
		gl.glPopMatrix();
	}
	protected void drawNose(GL2 gl,GLU glu){
		// draw nose
		gl.glColor3f(1, .77f, 1);
		drawSphere(quadric, .14f, glu);
		// draw whiskers
		gl.glColor3f(WHISKER_COLOR,WHISKER_COLOR,WHISKER_COLOR);
		draw6Whiskers(gl,glu);
	}
	protected void drawOneEar(GL2 gl, GLU glu){
		gl.glPushMatrix();
			gl.glTranslatef(.3f, 0, 0);
			gl.glRotatef(90, -1, .59f, 0);
			glu.gluCylinder(textureQuadric, .4, 0, .5, 10, 10);
		gl.glPopMatrix();
	}
	private void drawOneLeg(GL2 gl,GLU glu,float rotate){
		gl.glPushMatrix();
			gl.glRotatef(rotate, 0, 1, 0);
			gl.glTranslatef(1, 0, 0);
			gl.glScalef(3, 1, 1);
			drawSphere(textureQuadric,.2f,glu);
		gl.glPopMatrix();
	}
	protected void drawLegs(GL2 gl, GLU glu){
		int rotate=(int)(SWIM_ANGLE*Math.sin(Math.toRadians(t*360-45)));
		gl.glPushMatrix();
			// front legs
			gl.glTranslatef(0,-.43f,-2.47f);
			drawOneLeg(gl,glu,rotate);
			gl.glScalef(-1, 1, 1);
			drawOneLeg(gl,glu,rotate);
			// back legs
			gl.glTranslatef(0, 0, 1.88f);
			drawOneLeg(gl,glu,-rotate);
			gl.glScalef(-1, 1, 1);
			drawOneLeg(gl,glu,-rotate);
		gl.glPopMatrix();
	}
	protected void drawTail(GL2 gl, GLU glu){
		gl.glPushMatrix();
			gl.glRotatef(86,-1,0,0);
			glu.gluCylinder(textureQuadric, TAIL_DIAM, TAIL_DIAM, TAIL_LENGTH, 10, 10);
			gl.glTranslatef(0, 0, TAIL_LENGTH);
			drawSphere(textureQuadric,TAIL_DIAM,glu);
		gl.glPopMatrix();
	}
	public float size(){return BODY_LENGTH*2f;}
	
	public void playerMoved(float x, float y, float z, float angle){}

	public void playNoise(){
		BatsEverywhere.m.load(soundFilename,  0, 0, 1, false);
		BatsEverywhere.m.setListenerPos(0, 0);
		BatsEverywhere.m.play(soundFilename);
	}
	public void playerMoved(float x, float y, float z, float angle, float y_angle,PlayerStats s){

		float dist=(float)Math.sqrt(Math.pow(x-this.x, 2)+Math.pow(z-this.z, 2));
		// will NOT happen if you're just standing still. you have to move to trigger this
		if(dist<size()&&!steppedOn){	// stepped on cat
			steppedOn=true;

			s.changeHealth(-1);s.changeHonor(-1);

			playNoise();
		}else if(dist>size()*6f)steppedOn=false;
	}
}
