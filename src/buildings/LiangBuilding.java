package buildings;
import game.Building;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;

import com.jogamp.opengl.util.texture.Texture;


public class LiangBuilding extends Building{
	
	private GLUquadric quadric;
	private GLUquadric sphereQuadric;
	private Texture brickTexture, insideTexture, floorTexture, worldTexture, grassTexture;

	
	private float angles = 0;
	@Override
	public void draw(GL2 gl, GLU glu) {
	  gl.glPushMatrix();
	  gl.glTranslatef(50,0,50);
		
		gl.glEnable(GL2.GL_CULL_FACE);
		gl.glEnable(GL2.GL_TEXTURE_2D);
	     
	        gl.glEnable(GL2.GL_TEXTURE_GEN_S);
	        gl.glEnable(GL2.GL_TEXTURE_GEN_T);
	            gl.glTexGeni(GL2.GL_S, GL2.GL_TEXTURE_GEN_MODE, GL2.GL_OBJECT_LINEAR);
	            gl.glTexGeni(GL2.GL_T, GL2.GL_TEXTURE_GEN_MODE, GL2.GL_OBJECT_LINEAR);
	            float[] coef_s = {.2f,0f,.2f,0};
	            gl.glTexGenfv(GL2.GL_S, GL2.GL_OBJECT_PLANE, coef_s, 0);
	            float[] coef_t = {0f,.25f,0f,0};
	            gl.glTexGenfv(GL2.GL_T, GL2.GL_OBJECT_PLANE, coef_t, 0);
	            
	            //OUTSIDE WALLS TEXTURE - CCW
	            brickTexture.bind(gl);
	            //FRONT WALL
	            gl.glBegin(GL2.GL_QUADS);
	                gl.glVertex3f(-30,  0, 30);
	                gl.glVertex3f( -2, 	0, 30);
	                gl.glVertex3f( -2, 30, 30);
	                gl.glVertex3f(-30, 30, 30);
	                
	                gl.glVertex3f(	2,  0, 30);
	                gl.glVertex3f( 30, 	0, 30);
	                gl.glVertex3f( 30, 30, 30);
	                gl.glVertex3f(	2, 30, 30);
	                
	                gl.glVertex3f(-2, 10, 30);
	                gl.glVertex3f( 2, 10, 30);
	                gl.glVertex3f( 2, 30, 30);
	                gl.glVertex3f(-2, 30, 30);
	            gl.glEnd();
	            
	            //Left
	            gl.glBegin(GL2.GL_QUADS);
	            	gl.glVertex3f(-30,  0,  30);
	            	gl.glVertex3f(-30, 30,  30);
	            	gl.glVertex3f(-30, 30, -30);
	            	gl.glVertex3f(-30,  0, -30);
                gl.glEnd();
              
                //Right
                gl.glBegin(GL2.GL_QUADS);
                	gl.glVertex3f( 30,  0,  30);
                	gl.glVertex3f( 30,  0, -30);
                	gl.glVertex3f( 30, 30, -30);
                	gl.glVertex3f( 30, 30,  30);
                gl.glEnd();
            
                //Back
                gl.glBegin(GL2.GL_QUADS);
                	gl.glVertex3f(-30,  0, -30);
        			gl.glVertex3f(-30, 30, -30);
        			gl.glVertex3f( -2, 30, -30);
        			gl.glVertex3f( -2,  0, -30);
        			

                	gl.glVertex3f(  2,  0, -30);
        			gl.glVertex3f(  2, 30, -30);
        			gl.glVertex3f( 30, 30, -30);
        			gl.glVertex3f( 30,  0, -30);
        			

                	gl.glVertex3f( -2, 10, -30);
        			gl.glVertex3f( -2, 30, -30);
        			gl.glVertex3f(  2, 30, -30);
        			gl.glVertex3f(  2, 10, -30);
                gl.glEnd();
                
                
                //ROOF
                gl.glBegin(GL2.GL_QUADS);
        			gl.glVertex3f(-30, 30, 30);
        			gl.glVertex3f( 30, 30, 30);
        			gl.glVertex3f( 30, 30,-30);
        			gl.glVertex3f(-30, 30,-30);
        		gl.glEnd();
        
	            //INSIDE WALLS OF BUILDINGS - CW
	            insideTexture.bind(gl);
	            //Front Wall
	            gl.glBegin(GL2.GL_QUADS);
	            	gl.glVertex3f(-30,  0, 30);
	            	gl.glVertex3f(-30, 30, 30);
	            	gl.glVertex3f( -2, 30, 30);
	            	gl.glVertex3f( -2,  0, 30);
	            	
	            	gl.glVertex3f(	2,  0, 30);
	            	gl.glVertex3f(	2, 30, 30);
	            	gl.glVertex3f( 30, 30, 30);
	            	gl.glVertex3f( 30,  0, 30);
	            	
	            	gl.glVertex3f( -2, 10, 30);
	            	gl.glVertex3f( -2, 30, 30);
	            	gl.glVertex3f(  2, 30, 30);
	            	gl.glVertex3f(  2, 10, 30);
	            gl.glEnd();
	            
	            //Left
	            gl.glBegin(GL2.GL_QUADS);
	        		gl.glVertex3f(-30,  0, 30);
	        		gl.glVertex3f(-30, 	0,-30);
	        		gl.glVertex3f(-30, 30,-30);
            		gl.glVertex3f(-30, 30, 30);
            	gl.glEnd();
            	
            	//Right
            	gl.glBegin(GL2.GL_QUADS);
            		gl.glVertex3f( 30,  0, 30);
            		gl.glVertex3f( 30, 30, 30);
            		gl.glVertex3f( 30, 30,-30);
            		gl.glVertex3f( 30,  0,-30);
            	gl.glEnd();
       
            	//Back
            	gl.glBegin(GL2.GL_QUADS);
            		gl.glVertex3f(-30,  0, -30);
            		gl.glVertex3f( -2,  0, -30);
            		gl.glVertex3f( -2, 30, -30);
            		gl.glVertex3f(-30, 30, -30);
            		
            		gl.glVertex3f(	2,  0, -30);
            		gl.glVertex3f( 30,  0, -30);
            		gl.glVertex3f( 30, 30, -30);
            		gl.glVertex3f(	2, 30, -30);
            		
            		gl.glVertex3f( -2, 10, -30);
            		gl.glVertex3f(  2, 10, -30);
            		gl.glVertex3f(  2, 30, -30);
            		gl.glVertex3f( -2, 30, -30);
            	gl.glEnd();
            	
            	float[] coef_rs = {.25f,0f,0f,0};
	            gl.glTexGenfv(GL2.GL_S, GL2.GL_OBJECT_PLANE, coef_rs, 0);
	            float[] coef_rt = {0f,0f,.2f,0};
	            gl.glTexGenfv(GL2.GL_T, GL2.GL_OBJECT_PLANE, coef_rt, 0);
	           
            	
            	//ROOF
            	gl.glBegin(GL2.GL_QUADS);
            		gl.glVertex3f(-30, 30, 30);
            		gl.glVertex3f(-30, 30,-30);
            		gl.glVertex3f( 30, 30,-30);
            		gl.glVertex3f( 30, 30, 30);
            	gl.glEnd();
            	
            	gl.glDisable(GL2.GL_CULL_FACE);
            	
            	//Floor
            	floorTexture.bind(gl);
            	gl.glBegin(GL2.GL_QUADS);
            		gl.glVertex3f(-30, 0.01f, 30);
            		gl.glVertex3f( 30, 0.01f, 30);
            		gl.glVertex3f( 30, 0.01f,-30);
            		gl.glVertex3f(-30, 0.01f,-30);
            	gl.glEnd();
            	
	        gl.glDisable(GL2.GL_TEXTURE_2D);
	        gl.glDisable(GL2.GL_TEXTURE_GEN_S);
	        gl.glDisable(GL2.GL_TEXTURE_GEN_T);
	    	
	        
	        //LAND GRASS
	        //MANUAL TEXTURE EXAMPLE
	        gl.glEnable(GL2.GL_TEXTURE_2D);
	        	grassTexture.bind(gl);
	        	gl.glBegin(GL2.GL_QUADS);
	        		gl.glTexCoord2f( 0f,10f); gl.glVertex3f(-50.0f, 0.0f, -50.0f);
	        		gl.glTexCoord2f(15f,10f); gl.glVertex3f(-50.0f, 0.0f,  50.0f);
	        		gl.glTexCoord2f(15f, 0f); gl.glVertex3f( 50.0f, 0.0f,  50.0f);
	        		gl.glTexCoord2f( 0f, 0f); gl.glVertex3f( 50.0f, 0.0f, -50.0f);
	        	gl.glEnd();
	        gl.glDisable(GL2.GL_TEXTURE_2D);
    		
    		//GLODE HOLDER/CONSOLE?
    		gl.glColor3f(1f, 0.843f, 0f); 		
    		gl.glPushMatrix();
    			gl.glRotatef(-90f, 1f, 0f, 0f); // stand upright (Y)
    			gl.glTranslatef(0f,0f,0.02f);
    		
    			glu.gluCylinder(quadric, 15f, 12f, 5f, 20, 10);
    			glu.gluDisk(quadric, 14f, 16f, 20, 5); // also to be flipped
    		
    		gl.glPopMatrix();
    		
    		//OBJECTS
    		gl.glColor3f(0f, 0f, 0f);
    		gl.glPushMatrix();
    			gl.glBegin(GL2.GL_QUADS);
    				gl.glVertex3f(-25,  0, 25);
    				gl.glVertex3f(-25, 	0,  5);
    				gl.glVertex3f(-25, 10,  5);
    				gl.glVertex3f(-25, 10, 25);
    				
    				gl.glVertex3f(-30,  0, 5);
	            	gl.glVertex3f(-30, 10, 5);
	            	gl.glVertex3f(-25, 10, 5);
	            	gl.glVertex3f(-25,  0, 5);
	            	
	            	gl.glVertex3f(-30,  0, 25);
	            	gl.glVertex3f(-30, 10, 25);
	            	gl.glVertex3f(-25, 10, 25);
	            	gl.glVertex3f(-25,  0, 25);
	            	
	            	gl.glVertex3f(-30, 10, 25);
	            	gl.glVertex3f(-30, 10, 	5);
	            	gl.glVertex3f(-25, 10, 	5);
	            	gl.glVertex3f(-25, 10, 25);
	            	
	            	
	            	//
	            	gl.glVertex3f( 25,  0, 25);
    				gl.glVertex3f( 25, 	0,  5);
    				gl.glVertex3f( 25, 10,  5);
    				gl.glVertex3f( 25, 10, 25);
    				
    				gl.glVertex3f( 30,  0, 5);
	            	gl.glVertex3f( 30, 10, 5);
	            	gl.glVertex3f( 25, 10, 5);
	            	gl.glVertex3f( 25,  0, 5);
	            	
	            	gl.glVertex3f( 30,  0, 25);
	            	gl.glVertex3f( 30, 10, 25);
	            	gl.glVertex3f( 25, 10, 25);
	            	gl.glVertex3f( 25,  0, 25);
	            	
	            	gl.glVertex3f( 30, 10, 25);
	            	gl.glVertex3f( 30, 10, 	5);
	            	gl.glVertex3f( 25, 10, 	5);
	            	gl.glVertex3f( 25, 10, 25);
	            	
	            	//
	            	gl.glVertex3f( 25,  0, -25);
    				gl.glVertex3f( 25, 	0,  -5);
    				gl.glVertex3f( 25, 10,  -5);
    				gl.glVertex3f( 25, 10, -25);
    				
    				gl.glVertex3f( 30,  0, -5);
	            	gl.glVertex3f( 30, 10, -5);
	            	gl.glVertex3f( 25, 10, -5);
	            	gl.glVertex3f( 25,  0, -5);
	            	
	            	gl.glVertex3f( 30,  0, -25);
	            	gl.glVertex3f( 30, 10, -25);
	            	gl.glVertex3f( 25, 10, -25);
	            	gl.glVertex3f( 25,  0, -25);
	            	
	            	gl.glVertex3f( 30, 10, -25);
	            	gl.glVertex3f( 30, 10, 	-5);
	            	gl.glVertex3f( 25, 10, 	-5);
	            	gl.glVertex3f( 25, 10, -25);
	            	
	            	//
	            	gl.glVertex3f(-25,  0, -25);
    				gl.glVertex3f(-25, 	0,  -5);
    				gl.glVertex3f(-25, 10,  -5);
    				gl.glVertex3f(-25, 10, -25);
    				
    				gl.glVertex3f(-30,  0, -5);
	            	gl.glVertex3f(-30, 10, -5);
	            	gl.glVertex3f(-25, 10, -5);
	            	gl.glVertex3f(-25,  0, -5);
	            	
	            	gl.glVertex3f(-30,  0, -25);
	            	gl.glVertex3f(-30, 10, -25);
	            	gl.glVertex3f(-25, 10, -25);
	            	gl.glVertex3f(-25,  0, -25);
	            	
	            	gl.glVertex3f(-30, 10, -25);
	            	gl.glVertex3f(-30, 10, 	-5);
	            	gl.glVertex3f(-25, 10, 	-5);
	            	gl.glVertex3f(-25, 10, -25);
    			gl.glEnd();
    		gl.glPopMatrix();
    		
    		// GLODE IT IS NOT ORIENTED RIGHT. IS IT BECAUSE THE IMAGE FILE IS NOT ORIENTED CORRECTLY?
    		// WAIT... PERHAPS IT IS NOT EARTH...
    		gl.glEnable(GL2.GL_TEXTURE_2D);
    			worldTexture.bind(gl);
    			gl.glPushMatrix();
    				gl.glTranslatef(0f,15f,0f);
    				angles+=2;
    				gl.glRotatef(angles, 0, 1,0);
    				glu.gluSphere(sphereQuadric, 10f, 20, 10);
    			gl.glPopMatrix();
			 gl.glDisable(GL2.GL_TEXTURE_2D);
		  gl.glPopMatrix();
			 
		}
	
	public LiangBuilding(GL2 gl, GLU glu){
		
		quadric = glu.gluNewQuadric();
        glu.gluQuadricDrawStyle(quadric, GLU.GLU_FILL); // GLU_POINT, GLU_LINE, GLU_FILL, GLU_SILHOUETTE
        glu.gluQuadricNormals  (quadric, GLU.GLU_NONE); // GLU_NONE, GLU_FLAT, or GLU_SMOOTH
        glu.gluQuadricTexture  (quadric, false);        // false, or true to generate texture coordinates
		
        sphereQuadric = glu.gluNewQuadric();
        glu.gluQuadricDrawStyle(sphereQuadric, GLU.GLU_FILL);
        glu.gluQuadricNormals  (sphereQuadric, GLU.GLU_NONE); 
        glu.gluQuadricTexture  (sphereQuadric, true);        
        
        
        worldTexture = setupTexture(gl, "liangworld.jpg");
		brickTexture = setupTexture(gl, "liangbrick.jpg");
		insideTexture = setupTexture(gl,"liangwood.jpg");
		floorTexture = setupTexture(gl,"liangfloor.jpg");
		grassTexture = setupTexture(gl,"lianggrass.jpg");
	}

}
