// Diana Cheung, CS333 Class of 2013
// Superclass for cat and rabbit classes. May also be useful for Bat class
package catsrabbits;
import game.PlayerStats;

import javax.media.opengl.GL2;import javax.media.opengl.glu.GLU;import javax.media.opengl.glu.GLUquadric;

import com.jogamp.opengl.util.texture.Texture;

import weapons.Projectile;import weapons.WeaponWatcher;

public abstract class Critter implements WeaponWatcher{
	public static final float WHISKER_THICKNESS=.01f;
	public static final String FUR_DIRECTORY="cheungcatrabbitfurs";
	
	protected float x,y,z,angle,tAngle,angleRate=0,speed,t=0,tRate;
	private boolean shot=false;
	protected GLUquadric textureQuadric,quadric;
	protected Texture texture;
	
	protected Critter(float x,float y,float z,float a,float s,float tR, GL2 gl, GLU glu){
		this.x=x;this.y=y;this.z=z;
		a=a%360;
		if(a<0)a+=360;
		tAngle=angle=a;
		speed=s;tRate=tR;
		
		textureQuadric = glu.gluNewQuadric();
        glu.gluQuadricDrawStyle(textureQuadric, GLU.GLU_FILL); // GLU_POINT, GLU_LINE, GLU_FILL, GLU_SILHOUETTE
        glu.gluQuadricNormals  (textureQuadric, GLU.GLU_NONE); // GLU_NONE, GLU_FLAT, or GLU_SMOOTH
        glu.gluQuadricTexture  (textureQuadric, true);        // use true to generate texture coordinates
        
        quadric = glu.gluNewQuadric();
        glu.gluQuadricDrawStyle(quadric, GLU.GLU_FILL);
        glu.gluQuadricNormals  (quadric, GLU.GLU_NONE);
        glu.gluQuadricTexture  (quadric, false);
        
        Projectile.registerWeaponWatcher(this);
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
	protected void drawOneEye(GL2 gl,GLU glu,float size,float xDist){
		gl.glPushMatrix();
			gl.glTranslatef(xDist, 0, 0);
			drawSphere(quadric,size,glu);
		gl.glPopMatrix();
	}
	protected void drawEyes(GL2 gl,GLU glu,float xDist,float size){
		gl.glPushMatrix();
			drawOneEye(gl,glu,size,xDist);
			gl.glScalef(-1,1,1);
			drawOneEye(gl,glu,size,xDist);
		gl.glPopMatrix();
	}
	protected abstract void drawNose(GL2 gl,GLU glu);
	private void drawWhisker(GLU glu){
		glu.gluCylinder(quadric, WHISKER_THICKNESS, WHISKER_THICKNESS, 1, 10, 10);
	}
	private void draw3Whiskers(GL2 gl,GLU glu){
		gl.glPushMatrix();
			gl.glRotatef(60, 0, 1, 0);
			drawWhisker(glu);
			gl.glRotatef(30, 0, 1, 0);
			drawWhisker(glu);
			gl.glRotatef(30, 0, 1, 0);
			drawWhisker(glu);
		gl.glPopMatrix();
	}
	protected void draw6Whiskers(GL2 gl,GLU glu){
		gl.glPushMatrix();
			gl.glRotatef(90,-1,0,0);
			draw3Whiskers(gl,glu);
			gl.glScalef(-1,1,1);
			draw3Whiskers(gl,glu);
		gl.glPopMatrix();
	}
	protected abstract void drawOneEar(GL2 gl,GLU glu);
	protected void drawEars(GL2 gl,GLU glu){
		gl.glPushMatrix();
			drawOneEar(gl,glu);
			gl.glScalef(-1, 1, 1);
			drawOneEar(gl,glu);
		gl.glPopMatrix();
	}
	protected abstract void drawTail(GL2 gl,GLU glu);
	protected abstract void drawLegs(GL2 gl,GLU glu);
	
	protected void move(){
		if(Math.abs(tAngle-angle)<.01){
			float radians=(float)Math.toRadians(angle),
						dx=(float)-Math.cos(radians)*speed,dz=(float)Math.sin(radians)*speed;
			if(x+dx>0 && z+dz>0 && x+dx<600 && z+dz<600 && (x+dx<300 || z+dz<500)){
				x+=dx;
				z+=dz;
			}else{	// reached out of bounds
				tAngle=(float)(360f*Math.random());	// pick random angle to turn
				angleRate=(tAngle-angle)/30f;	// turn in .5 second
			}
		}else angle+=angleRate;
		
		if(t>=1f)t=0;
		else t+=tRate;
	}
	
	public abstract float size();
	public abstract void playNoise();
	
	public void checkShot(Projectile p,PlayerStats s){
		float dist=(float)Math.sqrt(Math.pow(p.getProjX()-x, 2)+Math.pow(p.getProjY()-y, 2)+Math.pow(p.getProjZ()-z, 2));
		if(dist<size()&&!shot){
			shot=true;

			s.changeHonor(-1);
			playNoise();
		}else if(dist>size()*8f)shot=false;
	}
}
