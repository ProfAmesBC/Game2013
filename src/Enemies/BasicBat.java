package Enemies;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;


public class BasicBat implements Enemies {
	
	//initialize graphics variables
	private float x, y, z, dx, dz, speed, scale;
	private float direction; //angle from X axis
	private double T;
	private GLUquadric quadric; 
	private float bodyRadius = 1;
	private float lowerWingLength = 1.5f;
	private float upperWingLength = 2;
	
	//display lists
	private static int displayListWing1 = 4, displayListWing2 = 4,
			displayListWing3 = 4, displayListWing4 = 4, displayListWing5 = 4;
	
	//initialize status variables
	private boolean dead = false;
	private float maxHP = 10;
	private float currentHP = maxHP;
	
	//constructors
	public BasicBat(){}
	
	public BasicBat(GL2 gl, GLU glu, float x, float z) {
		
		//quadric set-up
		quadric = glu.gluNewQuadric();
		glu.gluQuadricDrawStyle(quadric, GLU.GLU_FILL); // GLU_POINT, GLU_LINE, GLU_FILL, GLU_SILHOUETTE
        glu.gluQuadricNormals  (quadric, GLU.GLU_NONE); // GLU_NONE, GLU_FLAT, or GLU_SMOOTH
        glu.gluQuadricTexture  (quadric, false);        // use true to generate texture coordinates
        
        scale = (float) 0.25;
        speed = 10;
		bodyRadius*=scale;
        lowerWingLength*=scale;
        upperWingLength*=scale;
        this.x = x;
        y = 6;
        this.z = z;
        T= Math.random()*5;
        direction=90;
        dead = false;
        dx = 0;
        dz = 0;
        
        //create display lists
        if (displayListWing1 == 4) {
        	displayListWing1 = gl.glGenLists(1);
        	gl.glNewList(displayListWing1, GL2.GL_COMPILE);
        	draw1(gl, glu);
        	gl.glEndList();
        }
	}
	
	//Drawing methods
	public void drawWing(GL2 gl, boolean rightWing){
		
		float flip = 1;
		if(rightWing){flip = -1;}
		
		//upper wing
		float upperDegree = flip*(float)(45 * Math.cos(T*2*Math.PI));
		float moveCos = flip*upperWingLength*(float)Math.cos(Math.toRadians(upperDegree));
		float moveSin = -flip*upperWingLength*(float)Math.sin(Math.toRadians(upperDegree));
		
		gl.glPushMatrix();
			//gl.glRotatef(upperDegree, -1f, 0f, 0f);
			gl.glColor3f(0f, 0f, 0f); //black color
			gl.glBegin(GL2.GL_QUADS);
				gl.glVertex3f(0, 0, -bodyRadius*2/3); //bottom back	
				gl.glVertex3f(0, 0, +bodyRadius*2/3); // bottom front
				gl.glVertex3f(0 + moveCos, moveSin, +bodyRadius*2/3);  //top front
				gl.glVertex3f(0 + moveCos, moveSin, -bodyRadius*2/3); //top back				
			gl.glEnd();
		gl.glPopMatrix();
		
		//lower wing
		float lowerDegree = flip*(float)(45+45*Math.sin(Math.toRadians(T*360)));
		float moveCosLow = flip*lowerWingLength*(float)Math.cos(Math.toRadians(lowerDegree));
		float moveSinLow = -flip*lowerWingLength*(float)Math.sin(Math.toRadians(lowerDegree));
		
		gl.glPushMatrix();
			//gl.glRotatef(lowerDegree, 1f, 0f, 0f);
			gl.glColor3f(0f, 0f, 0f); //black color
			gl.glBegin(GL2.GL_QUADS);
				gl.glVertex3f(moveCos, moveSin, - bodyRadius*2/3); //bottom back
				gl.glVertex3f(moveCos, moveSin, bodyRadius*2/3); //bottom front
				gl.glVertex3f(moveCos + moveCosLow, moveSin + moveSinLow, bodyRadius/10); //top front
				gl.glVertex3f(moveCos + moveCosLow, moveSin + moveSinLow, - bodyRadius/10); //top back	
			gl.glEnd();
		gl.glPopMatrix();
	}
	
	public void drawBody(GL2 gl, GLU glu){
		
		float scaledEyeDistance = scale*(float) Math.sin(45)/2 ;
		
		//body of the bat 
		gl.glPushMatrix();
			//gl.glTranslatef(x, y, z);
			gl.glColor3f(0f, 0f, 0f); //black color
			glu.gluSphere(quadric, bodyRadius, 10, 10); //body
		gl.glPopMatrix();
			
		// right eye
		gl.glPushMatrix();
			gl.glTranslatef(scaledEyeDistance, scaledEyeDistance, scaledEyeDistance + bodyRadius/8);
			gl.glColor3f(1f, 0, 0); // red color
			glu.gluSphere(quadric, bodyRadius/4, 10, 10); //right eye
		gl.glPopMatrix();
		
    	// left eye
		gl.glPushMatrix();
			gl.glTranslatef(-scaledEyeDistance, scaledEyeDistance, scaledEyeDistance + bodyRadius/8);
			gl.glColor3f(1f, 0f, 0f); // red color
			glu.gluSphere(quadric, bodyRadius/4, 10, 10); //left eye
		gl.glPopMatrix();
		
		//snout
		gl.glPushMatrix();
			gl.glTranslated(0, 0, (bodyRadius*3/4));
			gl.glColor3f(0f, 0f, 0f);
			glu.gluCylinder(quadric, bodyRadius/2, bodyRadius/2 + bodyRadius/10, bodyRadius/2, 10, 10);
		gl.glPopMatrix();
	}
	
	public void draw1(GL2 gl, GLU glu) {
		drawBody(gl, glu);
		drawWing(gl, false);
		drawWing(gl, true);
	}
	
	public void draw2(GL2 gl, GLU glu){
		
		float bodyMoveSin = lowerWingLength*(float)Math.sin(Math.toRadians((float)(45+45*Math.sin(Math.toRadians(T*360)))));
		
		gl.glPushMatrix();
			gl.glTranslatef(x, y+bodyMoveSin/2, z);
			gl.glRotated(direction, 0, 1, 0);
			draw1(gl, glu);
		gl.glPopMatrix();
		
		//increment T
		T +=.01*speed;
	}
	
	//graphics getters
	public float getX() {return x;}
	public float getY() {return y;}
	public float getZ() {return z;}
	public float getDirection() {return direction;}
	public float getDX(){return dx;}
	public float getDZ(){return dz;}
	public float getSpeed() {return speed;}
	public float getScale(){return scale;}
	public boolean isDead(){return dead;}
	
	//status getters
	public float getCurrentHealth(){return currentHP;}
	public float getMaxHealth(){return maxHP;}

	//graphics setters
	public void setX(float x) {this.x = x;}
	public void setY(float y) {this.y = y;}
	public void setZ(float z) {this.z = z;}
	public void setDirection(float direction) {this.direction = direction;}
	public void setDX(float dx){this.dx=dx;}
	public void setDZ(float dz){this.dz=dz;}
	public void setSpeed(float speed) {this.speed = speed;}
	public void setScale(float scale) {this.scale = scale;}
	public void kill(){dead = true;}
	
	//status setters
	public void setCurrentHealth(float currentHP){this.currentHP = currentHP;}
	public void setMaxHealth(float maxHP){this.maxHP = maxHP;}
	public void receiveDamage(float damage){
		currentHP-=damage;
		if(currentHP<=0){
			kill();
		}
	}
}
