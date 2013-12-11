
package creatures;

import game.BatsEverywhere;
import game.Building;
import game.PlayerMotion;
import game.PlayerMotionWatcher;
import game.PlayerStats;

import java.util.Random;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;

import weapons.Projectile;

import com.jogamp.opengl.util.texture.Texture;

public class Mummy implements Creature, PlayerMotionWatcher, ProjectileWatcher{
	float spawnx, spawny, spawnz;
	float locx, locy, locz;
	float eyeAngle = 0;
	final float moveSpeed = 0.5f;
	final float runSpeed = 2f;
	final float rotateSpeed = 2f;
	final float sightRadius = 20f;
	private Texture bodyTexture;
	private GLUquadric bodyQuadric;
	boolean facingFront = true;
	boolean agro, dead,attacking=false;
	static float T = 0;
	double eyeVecX, eyeVecZ;
	private Random rand = new Random();
	private double d = rand.nextDouble();
	float playerX, playerZ, playerAngle;
	float dx, dz;
	int width, height;

	public Mummy(float x, float z, GL2 gl, GLU glu){
		eyeVecX = 0.2;
		eyeVecZ = 0.2;
		spawnx = x;
		spawny = 0;
		spawnz = z;
		locx = x;
		locy = 0;
		locz = z;
		
		bodyTexture = Building.setupTexture(gl, "liangmummy.jpg");
		bodyQuadric = glu.gluNewQuadric();
        glu.gluQuadricDrawStyle(bodyQuadric, GLU.GLU_FILL); // GLU_POINT, GLU_LINE, GLU_FILL, GLU_SILHOUETTE
        glu.gluQuadricNormals  (bodyQuadric, GLU.GLU_NONE); // GLU_NONE, GLU_FLAT, or GLU_SMOOTH
        glu.gluQuadricTexture  (bodyQuadric, true);        // false, or true to generate texture coordinates
        agro = false;
        dead = false;
        PlayerMotion.registerPlayerWatcher(this);
        Projectile.registerProjectileWatcher(this);
		
	}
	
	private void drawMoving(GL2 gl, GLU glu, float T){
		if (agro){
			
			double xV = locx-playerX;
			double zV = locz-playerZ;
			double lengthV1 = Math.sqrt((xV*xV)+(zV*zV));
			double lengthV2 = Math.sqrt(eyeVecX*eyeVecX+eyeVecZ*eyeVecZ);
			double dotProduct = xV * eyeVecX + zV * eyeVecZ;
			eyeAngle = (float) Math.acos(dotProduct / (lengthV1*lengthV2)) + 270;
			
			drawAgro(gl,glu,T);}
		else
		
		drawPassive(gl, glu, T);
	}
	
	

private void drawAgro(GL2 gl, GLU glu, float T) {
		
		T *= 2;
		gl.glEnable(GL2.GL_TEXTURE_2D);
		bodyTexture.bind(gl);
			drawHead(gl, glu);
			drawLeg(gl, glu, T);
			gl.glPushMatrix();
			gl.glTranslatef(0f,4.75f,4.5f);
			gl.glRotatef(90, -1, 0, 0);
				drawArm(gl, glu, T+.5f);
			gl.glPopMatrix();
		gl.glDisable(GL2.GL_TEXTURE_2D);
		
		drawBody(gl,glu);
	
		drawEye(gl,glu);
		
		gl.glPushMatrix();
			gl.glScalef(-1,1,1);
			gl.glEnable(GL2.GL_TEXTURE_2D);
			bodyTexture.bind(gl);
				drawLeg(gl, glu, T+.5f);
				gl.glPushMatrix();
				gl.glTranslatef(0f,4.75f,4.5f);
					gl.glRotatef(90, -1, 0, 0);
					drawArm(gl, glu, T);
				gl.glPopMatrix();
			gl.glDisable(GL2.GL_TEXTURE_2D);
			drawEye(gl, glu);
		gl.glPopMatrix();
	
		
	}
	

	private void drawPassive(GL2 gl, GLU glu, float T) {
		gl.glEnable(GL2.GL_TEXTURE_2D);
		bodyTexture.bind(gl);
			drawHead(gl, glu);
			drawLeg(gl, glu, T);
			drawArm(gl, glu, T+.5f);
		gl.glDisable(GL2.GL_TEXTURE_2D);
		
		drawBody(gl, glu);
		
		drawEye(gl,glu);
		
		gl.glPushMatrix();
			gl.glScalef(-1,1,1);
			
			gl.glEnable(GL2.GL_TEXTURE_2D);
			bodyTexture.bind(gl);
			
			drawLeg(gl, glu, T+.5f);
			drawArm(gl, glu, T);
			gl.glDisable(GL2.GL_TEXTURE_2D);
			drawEye(gl, glu);
		gl.glPopMatrix();
		
	}
	
	private void drawHead(GL2 gl, GLU glu){
	
		gl.glColor3f(.8007f, .7539f, .7695f);  			
		gl.glPushMatrix();
			gl.glTranslatef(0f,6.5f,0f);
			//gl.glRotated(90,1f,0f,0f);
			glu.gluSphere(bodyQuadric, 1.5f, 20, 10);
		gl.glPopMatrix();
		
	}
	
	private void drawBody(GL2 gl, GLU glu){
		gl.glColor3f(.8007f, .7539f, .7695f);  	
		gl.glEnable(GL2.GL_TEXTURE_2D);
	     
        gl.glEnable(GL2.GL_TEXTURE_GEN_S);
        gl.glEnable(GL2.GL_TEXTURE_GEN_T);
            gl.glTexGeni(GL2.GL_S, GL2.GL_TEXTURE_GEN_MODE, GL2.GL_OBJECT_LINEAR);
            gl.glTexGeni(GL2.GL_T, GL2.GL_TEXTURE_GEN_MODE, GL2.GL_OBJECT_LINEAR);
            float[] coef_s = {.2f,0f,.5f,0};
            gl.glTexGenfv(GL2.GL_S, GL2.GL_OBJECT_PLANE, coef_s, 0);
            float[] coef_t = {0f,1f,0f,0};
            gl.glTexGenfv(GL2.GL_T, GL2.GL_OBJECT_PLANE, coef_t, 0);
            
            bodyTexture.bind(gl);
		gl.glPushMatrix();
			gl.glTranslatef(0f,.6f,-2.5f);
			gl.glRotatef(25f, 1f, 0f, 0f); 
			gl.glBegin(GL2.GL_QUADS);
				gl.glVertex3f(1.75f, 3, 0.5f);
				gl.glVertex3f(1.75f, 3,  -0.5f);
				gl.glVertex3f(2.f, 5, -0.75f);
				gl.glVertex3f(2.f, 5, 0.75f);
				
				gl.glVertex3f(-1.75f, 3, 0.5f);
				gl.glVertex3f(-1.75f, 3,  -0.5f);
				gl.glVertex3f(-2.f, 5, -0.75f);
				gl.glVertex3f(-2.f, 5, 0.75f);
				
				
				gl.glVertex3f(-1.75f,  3, 0.5f);
            	gl.glVertex3f(-2f, 5, 0.75f);
            	gl.glVertex3f(2f, 5, 0.75f);
            	gl.glVertex3f(1.75f,  3, 0.5f);
            	
				gl.glVertex3f(-1.75f,  3, -0.5f);
            	gl.glVertex3f(-2.f, 5, -0.75f);
            	gl.glVertex3f(2.f, 5, -0.75f);
            	gl.glVertex3f(1.75f,  3, -0.5f);

            	gl.glVertex3f(-2.f, 5, 0.75f);
            	gl.glVertex3f(-2.f, 5, -0.75f);
            	gl.glVertex3f(2.f, 5, -0.75f);
            	gl.glVertex3f(2.f, 5, 0.75f);
        
            	gl.glColor3f(0f, 0f, 0f);             	
            	
				gl.glVertex3f(1.75f, 3, 0.5f);
				gl.glVertex3f(1.75f, 3,  -0.5f);
				gl.glVertex3f(.75f, 2, -0.2f);
				gl.glVertex3f(.75f, 2, 0.2f);
				
				gl.glVertex3f(-1.75f, 3, 0.5f);
				gl.glVertex3f(-1.75f, 3,  -0.5f);
				gl.glVertex3f(-.75f, 2, -0.2f);
				gl.glVertex3f(-.75f, 2, 0.2f);

				gl.glVertex3f(-1.75f,  3, 0.5f);
            	gl.glVertex3f(-.75f, 2, 0.2f);
            	gl.glVertex3f(.75f, 2, 0.2f);
            	gl.glVertex3f(1.75f,  3, 0.5f);
            	
				gl.glVertex3f(-1.75f,  3, -0.5f);
            	gl.glVertex3f(-.75f, 2, -0.2f);
            	gl.glVertex3f(.75f, 2, -0.2f);
            	gl.glVertex3f(1.75f,  3, -0.5f);
		    	
            	
			gl.glEnd();
			gl.glColor3f(.8007f, .7539f, .7695f);  		
				gl.glTranslatef(0f,5.5f,0.1f);
				gl.glRotatef(90f, 1f, 0f, 0f); 
				glu.gluCylinder(bodyQuadric, .5f, .6f, 1f, 20, 10);
		gl.glPopMatrix();
		
        gl.glDisable(GL2.GL_TEXTURE_2D);
	}
	
	private void drawLeg(GL2 gl, GLU glu,float T){
		
		gl.glColor3f(.8007f, .7539f, .7695f);  			
		gl.glPushMatrix();
		float angle = (float) (15*Math.cos(Math.toRadians(T*360))); 
			gl.glTranslatef(-1.2f, 3f,-1.3f);
			gl.glRotated(90, 1, 0, 0);
			gl.glRotated(angle, 3f, 0,0);
			glu.gluCylinder(bodyQuadric, .4f, .3f, 2.5f, 20, 10);
		gl.glPopMatrix();
	}
	
	private void drawArm(GL2 gl, GLU glu,float  T){
		gl.glColor3f(.8007f, .7539f, .7695f);  				
		gl.glPushMatrix();
		float angle = (float) (15*Math.cos(Math.toRadians(T*360)));
			gl.glTranslatef(-2f, 4.75f,-0.5f);
			gl.glRotated(90, 1, 0, 0);
			gl.glRotated(angle, 5f, 0,0);
			glu.gluSphere(bodyQuadric, .4f, 20, 10);
			glu.gluCylinder(bodyQuadric, .4f, .3f, 2.5f, 20, 10);
		gl.glPopMatrix();
	}
	
	private void drawEye(GL2 gl, GLU glu) {
		gl.glColor3f(1f, 1f, 1f); 		
		gl.glPushMatrix();
			gl.glTranslatef(-0.5f,6.3f,1.1f);
			glu.gluSphere(bodyQuadric, .3f, 20, 10);
		gl.glPopMatrix();
	}
	
	public void move(){
		float speed;
		if (T==0){
		d = rand.nextDouble();}
		
		if (!agro) {
			speed = moveSpeed;
			if (d <= 0.25){eyeAngle = 0;
			
			locx +=  (float) ( speed*Math.cos(Math.toRadians(eyeAngle)));
			locz -=  (float) ( speed*Math.sin(Math.toRadians(eyeAngle)));
			
			}
			else if (d <= 0.5) {eyeAngle = 90;
			locx -=  (float) ( speed*Math.cos(Math.toRadians(eyeAngle)));
			locz +=  (float) ( speed*Math.sin(Math.toRadians(eyeAngle)));
			}
			else if (d <= 0.75) {eyeAngle = 180;
			locx +=  (float) ( speed*Math.cos(Math.toRadians(eyeAngle)));
			locz -=  (float) ( speed*Math.sin(Math.toRadians(eyeAngle)));
			}
			else {eyeAngle = 270;
			locx -=  (float) ( speed*Math.cos(Math.toRadians(eyeAngle)));
			locz +=  (float) ( speed*Math.sin(Math.toRadians(eyeAngle)));
			}
		}
	    
	    else {speed = runSpeed;
	    	//runtowards
	    	double xV = playerX-locx;
	    	double zV = playerZ-locz;
	    	double dotProduct = xV * eyeVecX + zV * eyeVecZ;
	    	double lengthV1 = Math.sqrt((xV*xV)+(zV*zV));
	    	lengthV1 = lengthV1 * lengthV1;
	    	double constant = dotProduct / lengthV1;
	    	double dx = constant * xV*speed;
	    	double dz = constant * zV*speed;
	    	dx = Math.abs(dx);
	    	dz = Math.abs(dz);
	    	if(playerZ<locz){ locz-=dz; }
	    	else{ locz+=dz; }
	    	if(playerX<locx){locx-=dx;}
	    	else{	locx+=dx;}
	    	}
	        
	    }
    
	
	public void draw(GL2 gl, GLU glu) {
		
	
		gl.glPushMatrix();
		gl.glTranslatef(locx, (float) (locy + 0.1*Math.sin(Math.toRadians((T/60)*360))), locz);
		gl.glRotatef(eyeAngle+270, 0, -1, 0);
		drawMoving(gl, glu, T/60);
	
		// unsure how to resolve this change!! -Fiona
//<<<<<<< HEAD
		
		gl.glPopMatrix();
		move();
//=======
//		System.out.println("Position: " + locx + " " + locz);
//>>>>>>> refs/heads/weapons
		
		 T+=1f;
		 if (T > 60) T = 0;
	}
	
	
	
	@Override
	public void projectileMoved(double x, double z) {
		if((Math.abs(locx-x) < 2) && (Math.abs(locz-z) < 2)){
			BatsEverywhere.creatures.remove(this);
		}
	}

	@Override
	public void playerMoved(float x, float y, float z, float angle, float y_angle, PlayerStats s) {

		playerX = x;
		playerZ = z;
		playerAngle = angle;
		float distance  = (float) Math.sqrt(Math.pow((locx-x),2) + Math.pow((locy-y),2));
		if (distance < sightRadius) {agro = true;}
		if(distance < 3&&!attacking){
			attacking=true;
			s.changeHealth(-1);
			new Thread(new Runnable(){
				public void run(){
					try {
						Thread.sleep(2000);
					}catch(InterruptedException e){}
					attacking=false;
				}
			}).start();
		};
		
	}
	
	


}
