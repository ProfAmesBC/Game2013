package catsrabbits;
// Diana Cheung, CS333 Class of 2013
// Superclass for cat and rabbit classes. May also be useful for Bat class

import javax.media.opengl.GL2;import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;
import com.jogamp.opengl.util.texture.Texture;

public abstract class Critter{
	public static final String FUR_DIRECTORY="cheungcatrabbitfurs";
	
	protected float x,y,z,angle,speed,t=0,tRate;
	protected GLUquadric textureQuadric,quadric;
	protected Texture texture;
	
	protected Critter(float x,float y,float z,float a,float s,float tR, GL2 gl, GLU glu){
		this.x=x;this.y=y;this.z=z;angle=a;speed=s;tRate=tR;
		
		textureQuadric = glu.gluNewQuadric();
        glu.gluQuadricDrawStyle(textureQuadric, GLU.GLU_FILL); // GLU_POINT, GLU_LINE, GLU_FILL, GLU_SILHOUETTE
        glu.gluQuadricNormals  (textureQuadric, GLU.GLU_NONE); // GLU_NONE, GLU_FLAT, or GLU_SMOOTH
        glu.gluQuadricTexture  (textureQuadric, true);        // use true to generate texture coordinates
        
        quadric = glu.gluNewQuadric();
        glu.gluQuadricDrawStyle(quadric, GLU.GLU_FILL);
        glu.gluQuadricNormals  (quadric, GLU.GLU_NONE);
        glu.gluQuadricTexture  (quadric, false);
	}
	
	public float getX(){return x;}
	public float getY(){return y;}
	public float getZ(){return z;}
	public float getAngle(){return angle;}
	public float getSpeed(){return speed;}
	
	public void draw(GL2 gl,GLU glu){
		gl.glPushMatrix();
			gl.glTranslatef(x,y,z);
			gl.glRotatef(angle+90, 0, 1, 0);
			drawWholeBody(gl,glu);
		gl.glPopMatrix();
		move();
	}
	public abstract void drawWholeBody(GL2 gl,GLU glu);
	
	protected void drawSphere(GLUquadric quadric,float r,GLU glu){glu.gluSphere(quadric, r, 10, 10);}
	protected void drawTexturedUnitSphere(GLU glu){drawSphere(textureQuadric,1,glu);}
	protected abstract void drawBody(GL2 gl,GLU glu);
	protected abstract void drawHead(GL2 gl,GLU glu);
	protected void drawOneEye(GLU glu,float size){drawSphere(quadric,size,glu);}
	protected void drawEyes(GL2 gl,GLU glu,float xDist,float size){
		gl.glPushMatrix();
			gl.glTranslatef(xDist, 0, 0);
			drawOneEye(glu,size);
			gl.glTranslatef(-2*xDist, 0, 0);
			drawOneEye(glu,size);
		gl.glPopMatrix();
	}
	protected abstract void drawNose(GL2 gl,GLU glu);
	protected abstract void drawEar(GL2 gl,GLU glu);
	protected void drawEars(GL2 gl,GLU glu){
		gl.glEnable(GL2.GL_TEXTURE_2D);
		drawEar(gl,glu);
		gl.glScalef(-1, 1, 1);
		drawEar(gl,glu);
		gl.glDisable(GL2.GL_TEXTURE_2D);
	}
	protected abstract void drawTail(GL2 gl,GLU glu);
	protected abstract void drawFeet(GL2 gl,GLU glu);
	
	protected void move(){
		double radians=Math.toRadians(angle);
		x-=Math.cos(radians)*speed;
		z+=Math.sin(radians)*speed;
		
		if(t>=1f)t=0;
		else t+=tRate;
	}
}
