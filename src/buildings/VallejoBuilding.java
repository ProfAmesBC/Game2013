package buildings;

import game.Building;
import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;
import com.jogamp.opengl.util.texture.Texture;

public class VallejoBuilding extends Building {
	
	private Texture brickTexture;
	private Texture grassTexture;
	private Texture insideWall;
	private Texture floorTexture;
	private Texture ceilingTexture;
	private Texture ballTexture;
	private Texture goalTexture;
	private Texture doorTexture;

	
	private GLUquadric quadric;
	
	private float angle=0;
	public VallejoBuilding(GL2 gl, GLU glu){
		quadric = glu.gluNewQuadric();
        glu.gluQuadricDrawStyle(quadric, GLU.GLU_FILL); // GLU_POINT, GLU_LINE, GLU_FILL, GLU_SILHOUETTE
        glu.gluQuadricNormals  (quadric, GLU.GLU_NONE); // GLU_NONE, GLU_FLAT, or GLU_SMOOTH
        glu.gluQuadricTexture  (quadric, true);        // false, or true to generate texture coordinates
    
        ballTexture = setupTexture(gl, "Vallejoball.jpg");
        grassTexture = setupTexture(gl, "Vallejorock.gif");
        brickTexture = setupTexture(gl, "Vallejobrick041.jpg");
        insideWall = setupTexture(gl, "Vallejobeige005.jpg");
        floorTexture = setupTexture(gl, "Vallejofield.jpg");
        ceilingTexture = setupTexture(gl, "Vallejobeige015.jpg");
        goalTexture = setupTexture(gl, "Vallejogoal.gif");
        doorTexture = setupTexture(gl, "Vallejodoor.jpg");
        ceilingTexture = setupTexture(gl, "Vallejoroof.jpg");
	}
	
	@Override
	public void draw(GL2 gl, GLU glu) {
	
// Draw ground
		gl.glPushMatrix();
			gl.glEnable(GL2.GL_TEXTURE_2D);
			grassTexture.bind(gl);	
			gl.glBegin(GL2.GL_QUADS);
			gl.glTexCoord2f(0f,10f);     gl.glVertex3f(0.0f, 0.0f, 0.0f);
			gl.glTexCoord2f(10f,10f); 	gl.glVertex3f(0.0f, 0.0f,  100.0f);
			gl.glTexCoord2f(10f,0f); 	gl.glVertex3f( 100.0f, 0.0f,  100.0f);
			gl.glTexCoord2f(0f,0f); 	gl.glVertex3f( 100.0f, 0.0f, 0.0f);
			gl.glEnd();
			gl.glDisable(GL2.GL_TEXTURE_2D);
		gl.glPopMatrix();
	
		
//draw walls
		
		gl.glEnable(GL2.GL_CULL_FACE);		
			gl.glPushMatrix();
				gl.glEnable(GL2.GL_TEXTURE_2D);
				insideWall.bind(gl);	
		        gl.glBegin(GL2.GL_QUADS);
		            gl.glTexCoord2f(0f,2f); gl.glVertex3f(80,  30, 90);
		            gl.glTexCoord2f(3f,2f); gl.glVertex3f( 80,  0, 90);
		            gl.glTexCoord2f(3f,0f); gl.glVertex3f( 20, 0, 90);
		            gl.glTexCoord2f(0f,0f); gl.glVertex3f(20, 30, 90);
		            
		            gl.glTexCoord2f(0f,2f); gl.glVertex3f(80,  0, 20);
		            gl.glTexCoord2f(3f,2f); gl.glVertex3f( 80,  0, 90);
		            gl.glTexCoord2f(3f,0f); gl.glVertex3f( 80, 30, 90);
		            gl.glTexCoord2f(0f,0f); gl.glVertex3f(80, 30, 20);
		            
		            gl.glTexCoord2f(0f,2f); gl.glVertex3f(20,  0, 20);
		            gl.glTexCoord2f(3f,2f); gl.glVertex3f( 80,  0, 20);
		            gl.glTexCoord2f(3f,0f); gl.glVertex3f( 80, 30, 20);
		            gl.glTexCoord2f(0f,0f); gl.glVertex3f(20, 30, 20);
		            
		            gl.glTexCoord2f(0f,2f); gl.glVertex3f(20,  0, 20);
		            gl.glTexCoord2f(3f,2f); gl.glVertex3f( 20,  30, 20);
		            gl.glTexCoord2f(3f,0f); gl.glVertex3f( 20, 30, 90);
		            gl.glTexCoord2f(0f,0f); gl.glVertex3f(20, 0, 90);
		        gl.glEnd();
		        
		        brickTexture.bind(gl);
		        gl.glBegin(GL2.GL_QUADS);
		        gl.glTexCoord2f(0f,10f); gl.glVertex3f(80,  30, 90);
		        gl.glTexCoord2f(0f,0f); gl.glVertex3f(20, 30, 90);
		        gl.glTexCoord2f(10f,0f); gl.glVertex3f( 20, 0, 90);
		        gl.glTexCoord2f(10f,10f); gl.glVertex3f( 80,  0, 90);
		        
		        
		        gl.glTexCoord2f(0f,10f); gl.glVertex3f(80,  0, 20);
		        gl.glTexCoord2f(0f,0f); gl.glVertex3f(80, 30, 20);
		        gl.glTexCoord2f(10f,0f); gl.glVertex3f( 80, 30, 90);
		        gl.glTexCoord2f(10f,10f); gl.glVertex3f( 80,  0, 90);
		        
		        gl.glTexCoord2f(0f,10f); gl.glVertex3f(20,  0, 20);
		        gl.glTexCoord2f(0f,0f); gl.glVertex3f(20, 30, 20);      
		        gl.glTexCoord2f(10f,0f); gl.glVertex3f( 80, 30, 20);
		        gl.glTexCoord2f(10f,10f); gl.glVertex3f( 80,  0, 20);
		        
		        gl.glTexCoord2f(0f,10f); gl.glVertex3f(20,  0, 20);
		        gl.glTexCoord2f(0f,0f); gl.glVertex3f(20, 0, 90);      
		        gl.glTexCoord2f(10f,0f); gl.glVertex3f( 20, 30, 90);
		        gl.glTexCoord2f(10f,10f); gl.glVertex3f( 20,  30, 20);
		
		        gl.glEnd();
		        gl.glDisable(GL2.GL_TEXTURE_2D);
		     gl.glPopMatrix();
		gl.glDisable(GL2.GL_CULL_FACE);
		
		//floor
		gl.glPushMatrix();
			gl.glEnable(GL2.GL_TEXTURE_2D);
			floorTexture.bind(gl);	
	        gl.glBegin(GL2.GL_QUADS);
	            gl.glTexCoord2f(0f,2f); gl.glVertex3f(20, 1, 20);
	            gl.glTexCoord2f(3f,2f); gl.glVertex3f( 20,  1, 90);
	            gl.glTexCoord2f(3f,0f); gl.glVertex3f( 80, 1, 90);
	            gl.glTexCoord2f(0f,0f); gl.glVertex3f(80, 1, 20);
	
	            
	        gl.glEnd();
	        gl.glDisable(GL2.GL_TEXTURE_2D);
        gl.glPopMatrix();
        
        //ceiling
		gl.glPushMatrix();
			gl.glEnable(GL2.GL_TEXTURE_2D);
			ceilingTexture.bind(gl);	
	        gl.glBegin(GL2.GL_QUADS);
	
	            gl.glTexCoord2f(0f,2f); gl.glVertex3f(20, 30, 20);
	            gl.glTexCoord2f(3f,2f); gl.glVertex3f( 20, 30, 90);
	            gl.glTexCoord2f(3f,0f); gl.glVertex3f( 80, 30, 90);
	            gl.glTexCoord2f(0f,0f); gl.glVertex3f(80, 30, 20);
	            
	        gl.glEnd();
	        gl.glDisable(GL2.GL_TEXTURE_2D);
        gl.glPopMatrix();
        
        
      //goal
		gl.glPushMatrix();
			gl.glEnable(GL2.GL_TEXTURE_2D);
			goalTexture.bind(gl);	
	        gl.glBegin(GL2.GL_QUADS);
	
	            gl.glTexCoord2f(0f,2f); gl.glVertex3d(40, 0, 89.9);
	            gl.glTexCoord2f(2f,2f); gl.glVertex3d( 40, 10, 89.9);
	            gl.glTexCoord2f(2f,0f); gl.glVertex3d( 60, 10, 89.9);
	            gl.glTexCoord2f(0f,0f); gl.glVertex3d(60, 0, 89.0);
	            
	            
	            gl.glTexCoord2f(0f,2f); gl.glVertex3d(40, 0, 20.1);
	            gl.glTexCoord2f(2f,2f); gl.glVertex3d( 40, 10, 20.1);
	            gl.glTexCoord2f(2f,0f); gl.glVertex3d( 60, 10, 20.1);
	            gl.glTexCoord2f(0f,0f); gl.glVertex3d(60, 0, 20.1);
	            
	        gl.glEnd();
	        gl.glDisable(GL2.GL_TEXTURE_2D);
        gl.glPopMatrix();
        
     //door
		gl.glPushMatrix();
			gl.glEnable(GL2.GL_TEXTURE_2D);
			doorTexture.bind(gl);	
	        gl.glBegin(GL2.GL_QUADS);
	
	            
	            gl.glTexCoord2f(0f,2f); gl.glVertex3d(65, 0, 19.9);
	            gl.glTexCoord2f(2f,2f); gl.glVertex3d( 65, 15, 19.9);
	            gl.glTexCoord2f(2f,0f); gl.glVertex3d( 75, 15, 19.9);
	            gl.glTexCoord2f(0f,0f); gl.glVertex3d(75, 0, 19.9);
	            
	        gl.glEnd();
	        gl.glDisable(GL2.GL_TEXTURE_2D);
        gl.glPopMatrix();
      
      
        
        
        //roof
		gl.glPushMatrix();
			gl.glEnable(GL2.GL_TEXTURE_2D);
			ceilingTexture.bind(gl);	
			//gl.glColor3f(0, 0, 1);
	        gl.glBegin(GL2.GL_TRIANGLES);
	
	            gl.glVertex3f(20, 30, 20);
	            gl.glVertex3f( 50, 80, 55);
	            gl.glVertex3f( 80, 30, 20);
	            
	            gl.glVertex3f(80, 30, 20);
	            gl.glVertex3f(50, 80, 55);
	            gl.glVertex3f(80, 30, 90);
	            
	            gl.glVertex3f(20, 30, 90);
	            gl.glVertex3f(80, 30, 90);
	            gl.glVertex3f(50, 80, 55);
	            
	            gl.glVertex3f(20, 30, 20);
	            gl.glVertex3f(50, 80, 55);
	            gl.glVertex3f(20, 30, 90);
	            
	        gl.glEnd();
	        gl.glDisable(GL2.GL_TEXTURE_2D);
        gl.glPopMatrix();
	}
	
	
	// don't have to make it, unless we use it
	public void drawMoving(GL2 gl, GLU glu, float eyeX, float eyeY, float eyeZ) {
        // some buildings might need this
		//soccer ball   
        gl.glPushMatrix();
	
	        gl.glEnable(GL2.GL_TEXTURE_2D);
	            ballTexture.bind(gl);
	            gl.glPushMatrix();
	                gl.glTranslatef(50, 2, 50); 
	                angle += 1;
	                gl.glRotatef(angle, 0,1,0); // spin the ball
	                glu.gluSphere(quadric, 1., 10, 10);
	            gl.glPopMatrix();
	        gl.glDisable(GL2.GL_TEXTURE_2D);
        
        gl.glPopMatrix();
    }

	

}
