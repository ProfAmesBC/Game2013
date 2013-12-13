package game;

import java.io.File;
import java.io.IOException;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;

import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.TextureIO;

import javax.media.opengl.*;
import javax.media.opengl.awt.*;
import javax.media.opengl.glu.*;

public class Bats {
	
	public float batX,batY,batZ;
	private int batT = -100;
	private int direction = 1;
	public float batSpeed = (float) .02;
	public float batAngle = 180; 
	private Texture batTexture;
	private Texture batEyeTexture;
	private GLUquadric quadric;

	
	public Bats(GL2 gl, GLU glu)
	{
		quadric = glu.gluNewQuadric();
        glu.gluQuadricDrawStyle(quadric, GLU.GLU_FILL); // GLU_POINT, GLU_LINE, GLU_FILL, GLU_SILHOUETTE
        glu.gluQuadricNormals  (quadric, GLU.GLU_NONE); // GLU_NONE, GLU_FLAT, or GLU_SMOOTH
        glu.gluQuadricTexture  (quadric, true);        // false, or true to generate texture coordinates
        
        batTexture = Building.setupTexture(gl, "GoodeBat.jpg");
        batEyeTexture = Building.setupTexture(gl,"GoodeRadarBat.jpg");
       
	}
	
	public void draw(GL2 gl, GLU glu)
	{
    int error = gl.glGetError();
    if (error != GL2.GL_NO_ERROR) {
        System.out.println("OpenGL Error, probably no bats.");
        System.out.println(glu.gluErrorString(error));
        System.exit(1); }
        
	gl.glEnable(GL2.GL_TEXTURE_2D);
    batTexture.bind(gl);
    gl.glPushMatrix(); 
    	gl.glTranslatef(10f,10f,10f); //ORIGINAL LOCATION TRANSLATE
        glu.gluSphere(quadric, 2.5, 10, 10);//body
        gl.glTranslatef(-1f,2.28f,-1f);
        batEyeTexture.bind(gl);
        glu.gluSphere(quadric, .3, 10, 10);//eye1
        gl.glTranslatef(2f,0f,0f);
        glu.gluSphere(quadric, .3, 10, 10);//eye2
        
    gl.glPopMatrix();
        
    
    gl.glPushMatrix();
    	batTexture.bind(gl);
    	gl.glTranslatef(10f,10f,10f); //ORIGINAL LOCATION TRANSLATE 
    	gl.glTranslatef( -1f,0f,-2f);
        gl.glRotatef(180f, 0f, 90f, 90f);
        glu.gluPartialDisk(quadric, 1, 5, 10, 10, 0, 90); //wing 1 part 1
        
        
        gl.glTranslated(-2f, 0f, 0f);
        gl.glRotatef(180f, 0f, 180f, 0f); 
        glu.gluPartialDisk(quadric, 1, 5, 10, 10, 0, 90); //wing 2 part 1
        gl.glTranslatef(2f, 2f, 0f);
        
        
         
        glu.gluPartialDisk(quadric, .5, 3, 10, 10, 0, 90); //wing 2 part 2
        gl.glTranslatef(-7f,0f,0f);
        gl.glRotatef(180f,0f,0f,0f);
        glu.gluPartialDisk(quadric, .5, 3, 10, 10, 90, 90); //wing 1 part 2
        
    
        
       
        
    gl.glPopMatrix();
    gl.glDisable(GL2.GL_TEXTURE_2D);    
        
    }
	
	public void drawMoving(GL2 gl, GLU glu)
	{
		
		if(batT > -200)
		{
			if(batT == 90) direction = -3;
			if(batT == -90) direction = 3;
		}
		batT += direction;
		
		
		int error = gl.glGetError();
		if (error != GL2.GL_NO_ERROR) {
			System.out.println("OpenGL Error, probably no bats.");
			System.out.println(glu.gluErrorString(error));
			System.exit(1); }

		

		
		batX = (float) (batX + batSpeed * Math.toRadians(batAngle));
		batZ = (float) (batZ + batSpeed * -Math.toRadians(batAngle));

		
		gl.glEnable(GL2.GL_TEXTURE_2D);
		batTexture.bind(gl);
		gl.glPushMatrix();
		//IF STATEMENT TO MAKE IT TURN
		
		//gl.glRotatef(90, 1, 0, 0); // Turn bat at a barrier
		gl.glTranslatef(5 + batX,5 + batY,5 + batZ); //ORIGINAL LOCATION TRANSLATE
		glu.gluSphere(quadric, 2.5, 10, 10);//body
		gl.glTranslatef(-1f,2.28f,-1f);
		batEyeTexture.bind(gl);
		glu.gluSphere(quadric, .3, 10, 10);//eye1
		gl.glTranslatef(2f,0f,0f);
		glu.gluSphere(quadric, .3, 10, 10);//eye2
		gl.glPopMatrix();


		gl.glPushMatrix();
		batTexture.bind(gl);
		//IF STATEMENT TO MAKE IT TURN
		gl.glRotatef(0, 0, batAngle, 0); // Turn bat at a barrier
		gl.glTranslatef(5 + batX,5 + batY,5 + batZ); //ORIGINAL LOCATION TRANSLATE 
    	gl.glTranslatef( -1f,0f,-2f);
        gl.glRotatef(180f, 0f, 90f, 90f);
        

        	gl.glRotatef(batT*.2f, 5f, 0f, 0f);
            glu.gluPartialDisk(quadric, 1, 5, 10, 10, 0, 90); //wing 1 part 1
            gl.glRotatef(batT*.2f, 5f, 0f, 0f);
        
        	
             
        gl.glTranslated(-2f, 0f, 0f);
        gl.glRotatef(180f, 0f, 180f, 0f); 
        

        	gl.glRotatef(batT*.2f, 5f, 0f, 0f);
        	glu.gluPartialDisk(quadric, 1, 5, 10, 10, 0, 90); //wing 2 part 1
        	gl.glRotatef(batT*.2f, 5f, 0f, 0f);
        
        	
        gl.glTranslatef(2f, 2f, -.45f);
        
        	gl.glTranslatef(0f,0f,batT/500f);
            gl.glRotatef(batT*.1f, 5f, 0f, 0f);
            glu.gluPartialDisk(quadric, .6, 4, 10, 10, 0, 90); //wing 2 part 2
            gl.glRotatef(batT*.1f, 5f, 0f, 0f);

        
        gl.glTranslatef(-6f,0f,0f);
        gl.glRotatef(180f,0f,90f,0f);
        

        	  gl.glTranslatef(0f,0f,batT/200f);
        	  gl.glRotatef(batT*.1f, 5f, 0f, 0f);
              glu.gluPartialDisk(quadric, .6, 4, 10, 10, 0, 90); //wing 1 part 2
              gl.glRotatef(batT*.1f, 5f, 0f, 0f);

		
		gl.glPopMatrix();
		gl.glDisable(GL2.GL_TEXTURE_2D);    

	}
	public float getBatX() {
		return batX;
	}

	public void setBatX(int batX) {
		this.batX = batX;
	}
	

	public float getBatY() {
		return batY;
	}

	public void setBatY(int batY) {
		this.batY = batY;
	}

	public float getBatZ() {
		return batZ;
	}

	public void setBatZ(int batZ) {
		this.batZ = batZ;
	}
}

    
