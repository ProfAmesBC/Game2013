package buildings;
import game.Building;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;

import com.jogamp.opengl.util.texture.Texture;

public class LinnehanBuilding extends Building{
    private Texture exteriorTexture, interiorTexture, floorTexture, grassTexture;

    public LinnehanBuilding(GL2 gl, GLU glu) {
        interiorTexture = setupTexture(gl, "LinnehanRed024.jpg");
        exteriorTexture     = setupTexture(gl, "LinnehanBlue056.gif");
        floorTexture     = setupTexture(gl, "LinnehanWood058.jpg");
        grassTexture    = setupTexture(gl, "LinnehanGreen019.jpg");
    }

    public void draw(GL2 gl, GLU glu) {
    	gl.glEnable(GL2.GL_TEXTURE_2D);
    	grassTexture.bind(gl);
        gl.glBegin(GL2.GL_QUADS); //grass around building
            // ccw as viewed from front (counter-clockwise)
            gl.glTexCoord2f(0f,0f); gl.glVertex3f(0,  0, 0);
        	gl.glTexCoord2f(0f,10f); gl.glVertex3f(10, 0, 0);
        	gl.glTexCoord2f(9f,10f); gl.glVertex3f(10, 0, 100);
        	gl.glTexCoord2f(9f,0f); gl.glVertex3f( 0,  0, 100);
        	
        	gl.glTexCoord2f(0f,0f); gl.glVertex3f(10,  0, 0);
        	gl.glTexCoord2f(0f,10f); gl.glVertex3f(10, 0, 10);
        	gl.glTexCoord2f(9f,10f); gl.glVertex3f(90, 0, 10);
        	gl.glTexCoord2f(9f,0f); gl.glVertex3f( 90,  0, 0);
        	
        	gl.glTexCoord2f(0f,0f); gl.glVertex3f(90,  0, 0);
        	gl.glTexCoord2f(0f,10f); gl.glVertex3f(100, 0, 0);
        	gl.glTexCoord2f(9f,10f); gl.glVertex3f(100, 0, 100);
        	gl.glTexCoord2f(9f,0f); gl.glVertex3f( 90,  0, 100);
        	
        	gl.glTexCoord2f(0f,0f); gl.glVertex3f(10,  0, 90);
        	gl.glTexCoord2f(0f,10f); gl.glVertex3f(10, 0, 100);
        	gl.glTexCoord2f(9f,10f); gl.glVertex3f(90, 0, 100);
        	gl.glTexCoord2f(9f,0f); gl.glVertex3f( 90,  0, 90);
        gl.glEnd();
        gl.glDisable(GL2.GL_TEXTURE_2D);
        
    	gl.glEnable(GL2.GL_CULL_FACE); //front wall
                gl.glEnable(GL2.GL_TEXTURE_2D);
                	exteriorTexture.bind(gl);
                	gl.glEnable(GL2.GL_TEXTURE_GEN_S);
                    gl.glEnable(GL2.GL_TEXTURE_GEN_T);
                        gl.glTexGeni(GL2.GL_S, GL2.GL_TEXTURE_GEN_MODE, GL2.GL_OBJECT_LINEAR);
                        gl.glTexGeni(GL2.GL_T, GL2.GL_TEXTURE_GEN_MODE, GL2.GL_OBJECT_LINEAR);
                        float[] coef_s = {.5f,0,0,0};
                        gl.glTexGenfv(GL2.GL_S, GL2.GL_OBJECT_PLANE, coef_s, 0);
                        float[] coef_t = {0,.25f,0,0};
                        gl.glTexGenfv(GL2.GL_T, GL2.GL_OBJECT_PLANE, coef_t, 0);
                    gl.glBegin(GL2.GL_QUADS);
                        // ccw as viewed from front (counter-clockwise)
	                    gl.glVertex3f(10,  0, 10);
	                	gl.glVertex3f(73, 0, 10);
	                	gl.glVertex3f(73, 10, 10);
	                	gl.glVertex3f( 10,  10, 10);
	                	
	                	gl.glVertex3f(77,  7, 10);
		                gl.glVertex3f( 77,  10, 10);
		                gl.glVertex3f(73, 10, 10);
		                gl.glVertex3f(73, 7, 10);
		                
		                gl.glVertex3f(77,  0, 10);
	                	gl.glVertex3f(90, 0, 10);
	                	gl.glVertex3f(90, 10, 10);
	                	gl.glVertex3f(77,  10, 10);
                    gl.glEnd();
                    interiorTexture.bind(gl);
                    gl.glBegin(GL2.GL_QUADS);
                        // cw as viewed from front, so can be seen as ccw from back (clockwise)                   	
	                    gl.glVertex3f(10,  0, 10);
	                	gl.glVertex3f( 10,  10, 10);
	                	gl.glVertex3f(73, 10, 10);
	                	gl.glVertex3f(73, 0, 10);
	                	
	                	gl.glVertex3f(77,  7, 10);
		                gl.glVertex3f(73, 7, 10);
		                gl.glVertex3f(73, 10, 10);
		                gl.glVertex3f( 77,  10, 10);
		                
		                gl.glVertex3f(77,  0, 10);
	                	gl.glVertex3f(77,  10, 10);
	                	gl.glVertex3f(90, 10, 10);
	                	gl.glVertex3f(90, 0, 10);
                    gl.glEnd();
                gl.glDisable(GL2.GL_TEXTURE_2D);
                
             gl.glEnable(GL2.GL_CULL_FACE); //back wall
                gl.glEnable(GL2.GL_TEXTURE_2D);
                	interiorTexture.bind(gl);
                	gl.glBegin(GL2.GL_QUADS);
                        // ccw as viewed from front (counter-clockwise)
        	            gl.glVertex3f(10,  0, 90);
        	        	gl.glVertex3f(73, 0, 90);
        	        	gl.glVertex3f(73, 10, 90);
        	        	gl.glVertex3f( 10,  10, 90);
        	        	
        	        	gl.glVertex3f(77,  7, 90);
        	            gl.glVertex3f( 77,  10, 90);
        	            gl.glVertex3f(73, 10, 90);
        	            gl.glVertex3f(73, 7, 90);
        	            
        	            gl.glVertex3f(77,  0, 90);
        	        	gl.glVertex3f(90, 0, 90);
        	        	gl.glVertex3f(90, 10, 90);
        	        	gl.glVertex3f(77,  10, 90);
                    gl.glEnd();
                	exteriorTexture.bind(gl);
                    gl.glBegin(GL2.GL_QUADS);
                        // cw as viewed from front, so can be seen as ccw from back (clockwise)
        	            gl.glVertex3f(10,  0, 90);
        	            gl.glVertex3f( 10,  10, 90);
        	        	gl.glVertex3f(73, 10, 90);
        	        	gl.glVertex3f(73, 0, 90);
        	        		        	
        	        	gl.glVertex3f(77,  7, 90);
        	            gl.glVertex3f(73, 7, 90);
        	            gl.glVertex3f(73, 10, 90);
        	            gl.glVertex3f( 77,  10, 90);
        	            
        	            gl.glVertex3f(77,  0, 90);
        	        	gl.glVertex3f(77,  10, 90);
        	        	gl.glVertex3f(90, 10, 90);
        	        	gl.glVertex3f(90, 0, 90);
                    gl.glEnd();
                gl.glDisable(GL2.GL_TEXTURE_2D);
                gl.glDisable(GL2.GL_TEXTURE_GEN_S);
                gl.glDisable(GL2.GL_TEXTURE_GEN_T);
        gl.glDisable(GL2.GL_CULL_FACE);
        
        gl.glEnable(GL2.GL_CULL_FACE); //left wall
            gl.glEnable(GL2.GL_TEXTURE_2D);
            	interiorTexture.bind(gl);
                gl.glBegin(GL2.GL_QUADS);
                    // ccw as viewed from front (counter-clockwise)
                    gl.glTexCoord2f(0f,0f); gl.glVertex3f(10,  0, 10);
                    gl.glTexCoord2f(0f,10f); gl.glVertex3f( 10,  0, 90);
                    gl.glTexCoord2f(9f,10f); gl.glVertex3f(10, 10, 90);
                    gl.glTexCoord2f(9f,0f); gl.glVertex3f(10, 10, 10);
                gl.glEnd();
                exteriorTexture.bind(gl);
                gl.glBegin(GL2.GL_QUADS);
                    // cw as viewed from front, so can be seen as ccw from back (clockwise)
                	gl.glTexCoord2f(0f,0f); gl.glVertex3f(10,  0, 10);
                	gl.glTexCoord2f(0f,10f); gl.glVertex3f(10, 10, 10);
                	gl.glTexCoord2f(9f,10f); gl.glVertex3f(10, 10, 90);
                	gl.glTexCoord2f(9f,0f); gl.glVertex3f( 10,  0, 90);
                gl.glEnd();
            gl.glDisable(GL2.GL_TEXTURE_2D);
    gl.glDisable(GL2.GL_CULL_FACE);

       
    gl.glEnable(GL2.GL_CULL_FACE); //right wall
        gl.glEnable(GL2.GL_TEXTURE_2D);
        	exteriorTexture.bind(gl);
            gl.glBegin(GL2.GL_QUADS);
                // ccw as viewed from front (counter-clockwise)
                gl.glTexCoord2f(0f,0f); gl.glVertex3f(90,  0, 90);
                gl.glTexCoord2f(0f,10f); gl.glVertex3f( 90,  10, 90);
                gl.glTexCoord2f(9f,10f); gl.glVertex3f(90, 10, 10);
                gl.glTexCoord2f(9f,0f); gl.glVertex3f(90, 0, 10);
            gl.glEnd();
            interiorTexture.bind(gl);
            gl.glBegin(GL2.GL_QUADS);
                // cw as viewed from front, so can be seen as ccw from back (clockwise)
            	gl.glTexCoord2f(0f,0f); gl.glVertex3f(90,  0, 90);
            	gl.glTexCoord2f(0f,10f); gl.glVertex3f(90, 0, 10);
            	gl.glTexCoord2f(9f,10f); gl.glVertex3f(90, 10, 10);
            	gl.glTexCoord2f(9f,0f); gl.glVertex3f( 90,  10, 90);
            gl.glEnd();
        gl.glDisable(GL2.GL_TEXTURE_2D);
    gl.glDisable(GL2.GL_CULL_FACE);
    
    
    gl.glEnable(GL2.GL_CULL_FACE); //ceiling 
        gl.glEnable(GL2.GL_TEXTURE_2D);
        	exteriorTexture.bind(gl);
            gl.glBegin(GL2.GL_QUADS);
                // ccw as viewed from front (counter-clockwise)
                gl.glTexCoord2f(0f,0f); gl.glVertex3f(10,  10, 10);
                gl.glTexCoord2f(0f,9f); gl.glVertex3f( 90,  10, 10);
                gl.glTexCoord2f(9f,9f); gl.glVertex3f(90, 10, 90);
                gl.glTexCoord2f(9f,0f); gl.glVertex3f(10, 10, 90);
            gl.glEnd();
            interiorTexture.bind(gl);
            gl.glBegin(GL2.GL_QUADS);
                // cw as viewed from front, so can be seen as ccw from back (clockwise)
            	gl.glTexCoord2f(0f,0f); gl.glVertex3f(10,  10, 10);
            	gl.glTexCoord2f(0f,9f); gl.glVertex3f(10, 10, 90);
            	gl.glTexCoord2f(9f,9f); gl.glVertex3f(90, 10, 90);
            	gl.glTexCoord2f(9f,0f); gl.glVertex3f( 90,  10, 10);
            gl.glEnd();
        gl.glDisable(GL2.GL_TEXTURE_2D);
    gl.glDisable(GL2.GL_CULL_FACE);
    
    
    gl.glEnable(GL2.GL_TEXTURE_2D); //floor
	floorTexture.bind(gl);
    	gl.glBegin(GL2.GL_QUADS);
        // ccw as viewed from front (counter-clockwise)
        gl.glTexCoord2f(0f,0f); gl.glVertex3f(10,  0, 10);
        gl.glTexCoord2f(0f,9f); gl.glVertex3f(10,  0, 90);
        gl.glTexCoord2f(9f,9f); gl.glVertex3f(90, 0, 90);
        gl.glTexCoord2f(9f,0f); gl.glVertex3f(90, 0, 10);
    gl.glEnd();
    gl.glDisable(GL2.GL_TEXTURE_2D);
    
    }
}
