package creatures;

import java.io.File;
import java.io.IOException;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;

import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.TextureIO;

import game.PlayerMotionWatcher;
import game.PlayerStats;

public class Mummy implements Creature, PlayerMotionWatcher, ProjectileWatcher{
	
	float locx, locy, locz;
	float eyeAngle = 0;
	final float moveSpeed = 0.1f;
	final float runSpeed = 0.2f;
	final float rotateSpeed = 2f;
	final float sightRadius = 20;
	private Texture bodyTexture;
	private GLUquadric bodyQuadric;
	boolean facingFront = true;
	boolean agro, dead;
	static float T = 0;
	

	public Mummy(GL2 gl, GLU glu){
		locx = 0;
		locy = 0;
		locz = 0;
		bodyTexture = setupTexture(gl, "liangmummy.jpg");
		bodyQuadric = glu.gluNewQuadric();
        glu.gluQuadricDrawStyle(bodyQuadric, GLU.GLU_FILL); // GLU_POINT, GLU_LINE, GLU_FILL, GLU_SILHOUETTE
        glu.gluQuadricNormals  (bodyQuadric, GLU.GLU_NONE); // GLU_NONE, GLU_FLAT, or GLU_SMOOTH
        glu.gluQuadricTexture  (bodyQuadric, true);        // false, or true to generate texture coordinates
        agro = true;
        dead = false;
		
	}
	
	private void drawMoving(GL2 gl, GLU glu, float T){
		
		if (agro){drawAgro(gl,glu,T);}
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
		
		//Head
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
		if (agro) {speed = runSpeed;
		
		
		if (eyeAngle == 360) eyeAngle = 0;
		
	    if (locz < -10 ) {
	    	if (!facingFront)eyeAngle-=rotateSpeed;
	    	if (eyeAngle == 0) {facingFront = true;
	    	 locz +=speed*Math.cos(Math.toRadians(eyeAngle));
	    	locx -=speed*Math.sin(Math.toRadians(eyeAngle));
	    	}
	    }
	    	
	    else if (locz > 10){
	    	if (facingFront) eyeAngle+=rotateSpeed;
	    	if (eyeAngle == 180) {facingFront = false;
	    	
	    			locz +=speed*Math.cos(Math.toRadians(eyeAngle));
	    			locx -=speed*Math.sin(Math.toRadians(eyeAngle));
	    	
	    	}
	    }
	    else {
	    	locz +=speed*Math.cos(Math.toRadians(eyeAngle));
	    	locx -=speed*Math.sin(Math.toRadians(eyeAngle));
	    	}
		}
	    
	    else {speed = moveSpeed;
	    	//if player within range, turn and face player
	    	locz +=speed*Math.cos(Math.toRadians(eyeAngle));
    		locx -=speed*Math.sin(Math.toRadians(eyeAngle));
	
	    	}
	    }
	
	
		
	    
    
	
	public void draw(GL2 gl, GLU glu) {
		
		//move();
		
		
		gl.glTranslatef(locx, (float) (locy + 0.1*Math.sin(Math.toRadians((T/60)*360))), locz);
		gl.glRotatef(eyeAngle, 0, 1, 0);
		drawMoving(gl, glu, T/60);
		
		System.out.println("Position: " + locx + " " + locz);
		
		 T+=0.5f;
		 if (T > 60) T = 0;
		
		
	}
	
	
	
	@Override
	public void projectileMoved(double x, double z) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void playerMoved(float x, float y, float z, float angle,
			float y_angle, PlayerStats s) {
		// TODO Auto-generated method stub
		
	}

	
	public static Texture setupTexture(GL2 gl, String filename) {
        Texture texture=null;
        try {
            texture = TextureIO.newTexture(new File(filename), false);
        } catch (IOException e) {
            System.out.println("Unable to read texture file: " + e);
            e.printStackTrace();
            System.exit(1);
        }
        // consider using ImageUtil.flipImageVertically(BufferedImage image)
        boolean flip = texture.getMustFlipVertically();
//      if (flip)
//          ImageUtil.flipImageVertically(texture);
        System.out.println("Flip: " + flip);
        texture.setTexParameteri(gl, GL2.GL_TEXTURE_MAG_FILTER,GL2.GL_LINEAR); // or GL_NEAREST
        texture.setTexParameteri(gl, GL2.GL_TEXTURE_MIN_FILTER,GL2.GL_LINEAR); // or GL_NEAREST
        texture.setTexParameteri(gl, GL2.GL_TEXTURE_WRAP_S,GL2.GL_REPEAT); // or GL_CLAMP
        texture.setTexParameteri(gl, GL2.GL_TEXTURE_WRAP_T,GL2.GL_REPEAT); // or GL_CLAMP

        if (!isPowerOf2(texture.getImageWidth()) || !isPowerOf2(texture.getImageHeight())) {
            System.out.println(filename + " texture is not power of 2! Size is "
                               + texture.getImageWidth() + "x" + texture.getImageHeight());
            System.exit(1);
        } else {
            System.out.println(filename + " texture loaded, size is "
                               + texture.getImageWidth() + "," + texture.getImageHeight());
        }
        return texture;
    }
    private static boolean isPowerOf2(int n) {
        return n == (n & -n);
    }


}
