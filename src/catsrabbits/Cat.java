// Diana Cheung, CS333 Class of 2013
package catsrabbits;
import javax.media.opengl.GL2;import javax.media.opengl.glu.GLU;import game.*;

public class Cat extends Critter implements PlayerMotionWatcher{
	private static final float BODY_LENGTH=1.8f,HEAD_HEIGHT=.56f,HEAD_DIST=BODY_LENGTH*.7f,
			EYE_CENTER_DIST=.52f,EYE_HEIGHT=.35f,
			WHISKER_COLOR=.82f,TOP_WHISKER_LENGTH=1f,TOP_WHISKER_HEIGHT=.5f,MID_WHISKER_LENGTH=1.25f;
	private int furColor,timeAfterSteppedOn=0;
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
			// TODO gl.glTranslatef(0,-HEAD_HEIGHT,HEAD_DIST);

			// TODO draw legs
			
			// TODO draw tail
			
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
		gl.glBegin(GL2.GL_LINES);
			gl.glVertex3f(TOP_WHISKER_LENGTH, TOP_WHISKER_HEIGHT, 0);
			gl.glVertex3f(-TOP_WHISKER_LENGTH, -TOP_WHISKER_HEIGHT, 0);
			gl.glVertex3f(MID_WHISKER_LENGTH, 0, 0);
			gl.glVertex3f(-MID_WHISKER_LENGTH, 0, 0);
			gl.glVertex3f(TOP_WHISKER_LENGTH, -TOP_WHISKER_HEIGHT, 0);
			gl.glVertex3f(-TOP_WHISKER_LENGTH, TOP_WHISKER_HEIGHT, 0);
		gl.glEnd();
	}
	protected void drawOneEar(GL2 gl, GLU glu){
		gl.glPushMatrix();
			gl.glTranslatef(.3f, 0, 0);
			gl.glRotatef(90, -1, .59f, 0);
			glu.gluCylinder(textureQuadric, .4, 0, .5, 10, 10);
		gl.glPopMatrix();
	}
	protected void drawFeet(GL2 gl, GLU glu) {
		// TODO Auto-generated method stub
		
	}
	protected void drawTail(GL2 gl, GLU glu) {
		// TODO Auto-generated method stub
		
	}

	public void playerMoved(float x, float y, float z, float angle){
		float dist=(float)Math.sqrt(Math.pow(x-this.x, 2)+Math.pow(z-this.z, 2));
		if(dist<BODY_LENGTH){	// stepped on cat
			if(steppedOn)
				if(timeAfterSteppedOn==180){
					steppedOn=false;
					timeAfterSteppedOn=0;
				}else timeAfterSteppedOn++;
			else{
				steppedOn=true;
				// TODO meow, damage player
				
			}
		}
	}
}
