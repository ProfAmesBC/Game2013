package buildings;
// William Ames Fall 2013

import game.Building;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;

import com.jogamp.opengl.util.texture.Texture;

import javax.media.opengl.glu.*;

public class GoodeBuilding extends Building
{
	private float frames = 0;
	private Texture wallTexture;
	private Texture tntTexture;
	private Texture roofTexture1;//only texture above 64x64
	private Texture pumpkinTexture;
	private Texture diamondTexture;
	private Texture beaconTexture;
    private GLUquadric quadric; // to control properties of quadric-based objects here

    public GoodeBuilding(GL2 gl, GLU glu) {
        quadric = glu.gluNewQuadric();
        glu.gluQuadricDrawStyle(quadric, GLU.GLU_FILL); // GLU_POINT, GLU_LINE, GLU_FILL, GLU_SILHOUETTE
        glu.gluQuadricNormals  (quadric, GLU.GLU_NONE); // GLU_NONE, GLU_FLAT, or GLU_SMOOTH
        glu.gluQuadricTexture  (quadric, true);
        roofTexture1 = setupTexture(gl, "Goodeend_portal.png");
        wallTexture = setupTexture(gl, "Goodebrick.png");
        tntTexture = setupTexture(gl, "Goodetnt_bottom.png");
        pumpkinTexture = setupTexture( gl, "Goodepumpkin_face_on.png");
        diamondTexture = setupTexture(gl, "Goodediamond.png");
        beaconTexture = setupTexture(gl, "Goodebeacon.png");
        
        // false, or true to generate texture coordinates
    }
    
    public void draw(GL2 gl, GLU glu) {
        gl.glColor3f(.4f,.5f,.3f);

        //Floor
        diamondTexture.bind(gl);
        gl.glEnable(GL2.GL_TEXTURE_2D);
        gl.glBegin(GL2.GL_QUADS);
        	gl.glTexCoord2f(0f, 0f);gl.glVertex3f(0, 0, 0);
        	gl.glTexCoord2f(0f, 1f);gl.glVertex3f(0, 0, 100);
        	gl.glTexCoord2f(1f, 1f);gl.glVertex3f(100, 0, 100);
        	gl.glTexCoord2f(1f, 0f);gl.glVertex3f(100, 0, 0);
        gl.glEnd();
        gl.glDisable(GL2.GL_TEXTURE_2D);
       
        //Wall 1 with door and manual texturing  (wall 2 is door with auto texturing)   
        gl.glEnable(GL2.GL_CULL_FACE);
                gl.glEnable(GL2.GL_TEXTURE_2D);
                    pumpkinTexture.bind(gl);
                    gl.glBegin(GL2.GL_QUADS);
                        // ccw as viewed from front
                        gl.glTexCoord2f(0f,2f); gl.glVertex3f(5,  8, 5);
                        gl.glTexCoord2f(3f,2f); gl.glVertex3f( 95,  8, 5);
                        gl.glTexCoord2f(3f,0f); gl.glVertex3f(95, 50, 5);
                        gl.glTexCoord2f(0f,0f); gl.glVertex3f(5, 50, 5);
                        
                        gl.glTexCoord2f(0f,2f); gl.glVertex3f(5,  0, 5);
                        gl.glTexCoord2f(3f,2f); gl.glVertex3f( 42,  0, 5);
                        gl.glTexCoord2f(3f,0f); gl.glVertex3f(42, 8, 5);
                        gl.glTexCoord2f(0f,0f); gl.glVertex3f(5, 8, 5);
                        
                        gl.glTexCoord2f(0f,2f); gl.glVertex3f(95,  8, 5);
                        gl.glTexCoord2f(3f,2f); gl.glVertex3f( 48,  8, 5);
                        gl.glTexCoord2f(3f,0f); gl.glVertex3f(48, 0, 5);
                        gl.glTexCoord2f(0f,0f); gl.glVertex3f(95, 0, 5);
                        
                    gl.glEnd();
                    wallTexture.bind(gl);
                    gl.glBegin(GL2.GL_QUADS);
                        // cw as viewed from front, so can be seen as ccw from back
                        gl.glTexCoord2f(0f,2f); gl.glVertex3f(5,  50, 5);
                        gl.glTexCoord2f(3f,2f); gl.glVertex3f(95, 50, 5);
                        gl.glTexCoord2f(3f,0f); gl.glVertex3f( 95, 8, 5);
                        gl.glTexCoord2f(0f,0f); gl.glVertex3f( 5,  8, 5);
                        
                        gl.glTexCoord2f(0f,.75f); gl.glVertex3f(5,  8, 5);
                        gl.glTexCoord2f(.75f,.75f); gl.glVertex3f( 42,  8, 5);
                        gl.glTexCoord2f(.75f,0f); gl.glVertex3f(42, 0, 5);
                        gl.glTexCoord2f(0f,0f); gl.glVertex3f(5, 0, 5);
                        
                        gl.glTexCoord2f(0f,.75f); gl.glVertex3f(48,  8, 5);
                        gl.glTexCoord2f(.75f,.75f); gl.glVertex3f( 95,  8, 5);
                        gl.glTexCoord2f(.75f,0f); gl.glVertex3f(95, 0, 5);
                        gl.glTexCoord2f(0f,0f); gl.glVertex3f(48, 0, 5);
                        
                    gl.glEnd();
                gl.glDisable(GL2.GL_TEXTURE_2D);
        gl.glDisable(GL2.GL_CULL_FACE);
      
        
        //Wall3
        gl.glEnable(GL2.GL_CULL_FACE);
    	gl.glEnable(GL2.GL_TEXTURE_2D);
        	pumpkinTexture.bind(gl);
        	gl.glBegin(GL2.GL_QUADS);
        	gl.glTexCoord2f(0f,2f); gl.glVertex3f(5,  50, 5);
            gl.glTexCoord2f(3f,2f); gl.glVertex3f(5, 50, 95);
            gl.glTexCoord2f(3f,0f); gl.glVertex3f( 5, 0, 95);
            gl.glTexCoord2f(0f,0f); gl.glVertex3f( 5,  0, 5);
            gl.glEnd();
        	wallTexture.bind(gl);
        	gl.glBegin(GL2.GL_QUADS);
            gl.glTexCoord2f(0f,2f); gl.glVertex3f(5,  0, 5);
            gl.glTexCoord2f(3f,2f); gl.glVertex3f( 5,  0, 95);
            gl.glTexCoord2f(3f,0f); gl.glVertex3f(5, 50, 95);
            gl.glTexCoord2f(0f,0f); gl.glVertex3f(5, 50, 5);
            gl.glEnd();
        gl.glDisable(GL2.GL_TEXTURE_2D);
        gl.glDisable(GL2.GL_CULL_FACE);
        
        //Wall4
	    gl.glEnable(GL2.GL_CULL_FACE);
		gl.glEnable(GL2.GL_TEXTURE_2D);
	    	wallTexture.bind(gl);
	    	gl.glBegin(GL2.GL_QUADS);
	    	gl.glTexCoord2f(0f,2f); gl.glVertex3f(95,  50, 5);
	        gl.glTexCoord2f(3f,2f); gl.glVertex3f(95, 50, 95);
	        gl.glTexCoord2f(3f,0f); gl.glVertex3f( 95, 0, 95);
	        gl.glTexCoord2f(0f,0f); gl.glVertex3f( 95,  0, 5);
	        gl.glEnd();
	    	pumpkinTexture.bind(gl);
	    	gl.glBegin(GL2.GL_QUADS);
	        gl.glTexCoord2f(0f,2f); gl.glVertex3f(95,  0, 5);
	        gl.glTexCoord2f(3f,2f); gl.glVertex3f( 95,  0, 95);
	        gl.glTexCoord2f(3f,0f); gl.glVertex3f(95, 50, 95);
	        gl.glTexCoord2f(0f,0f); gl.glVertex3f(95, 50, 5);
	        gl.glEnd();
	    gl.glDisable(GL2.GL_TEXTURE_2D);
	    gl.glDisable(GL2.GL_CULL_FACE);
       
	//Wall Ceiling
		gl.glEnable(GL2.GL_CULL_FACE);
		gl.glEnable(GL2.GL_TEXTURE_2D);
			wallTexture.bind(gl);
			gl.glBegin(GL2.GL_QUADS);
			gl.glTexCoord2f(0f,0f); gl.glVertex3f(5,  50, 5);
		    gl.glTexCoord2f(0f,1f); gl.glVertex3f(5, 50, 95);
		    gl.glTexCoord2f(1f,1f); gl.glVertex3f( 95, 50, 95);
		    gl.glTexCoord2f(1f,0f); gl.glVertex3f( 95,  50, 5);
		    gl.glEnd();
			roofTexture1.bind(gl);
			gl.glBegin(GL2.GL_QUADS);
		    gl.glTexCoord2f(0f,2f); gl.glVertex3f(95,  50, 5);
		    gl.glTexCoord2f(3f,2f); gl.glVertex3f( 95,  50, 95);
		    gl.glTexCoord2f(3f,0f); gl.glVertex3f(5, 50, 95);
		    gl.glTexCoord2f(0f,0f); gl.glVertex3f(5, 50, 5);
		    gl.glEnd();
		gl.glDisable(GL2.GL_TEXTURE_2D);
		gl.glDisable(GL2.GL_CULL_FACE);
	        
	
	

      
        //Table in the middle
        gl.glPushMatrix();
        gl.glTranslatef(50f, 0f, 50f);
        gl.glRotatef(-90f, 1f, 0f, 0f);
        glu.gluCylinder(quadric, 1.5, .5, 3., 10, 10);
        gl.glColor3f(0,1,1);
        gl.glPopMatrix();
        gl.glEnable(GL2.GL_TEXTURE_2D);
    	tntTexture.bind(gl);
        gl.glBegin(GL2.GL_QUADS);
        gl.glTexCoord2f(0f,1f);gl.glVertex3f(45, 3, 45);
        gl.glTexCoord2f(1f,1f);gl.glVertex3f(45, 3, 55);
        gl.glTexCoord2f(1f,0f);gl.glVertex3f(55, 3, 55);
        gl.glTexCoord2f(0f,0f);gl.glVertex3f(55, 3, 45);
    	gl.glEnd();
    	gl.glDisable(GL2.GL_TEXTURE_2D);
        gl.glBegin(GL2.GL_QUADS);
    	gl.glVertex3f(45, 2, 45);
    	gl.glVertex3f(45, 2, 55);
    	gl.glVertex3f(55, 2, 55);
    	gl.glVertex3f(55, 2, 45);
    	gl.glEnd();
        gl.glBegin(GL2.GL_QUADS);
    	gl.glVertex3f(45, 3, 55);
    	gl.glVertex3f(55, 3, 55);
    	gl.glVertex3f(55, 2, 55);
    	gl.glVertex3f(45, 2, 55);
    	gl.glEnd();
        gl.glBegin(GL2.GL_QUADS);
    	gl.glVertex3f(45, 3, 45);
    	gl.glVertex3f(55, 3, 45);
    	gl.glVertex3f(55, 2, 45);
    	gl.glVertex3f(45, 2, 45);
    	gl.glEnd();
        gl.glBegin(GL2.GL_QUADS);
    	gl.glVertex3f(45, 3, 55);
    	gl.glVertex3f(45, 3, 45);
    	gl.glVertex3f(45, 2, 45);
    	gl.glVertex3f(45, 2, 55);
    	gl.glEnd();
        gl.glBegin(GL2.GL_QUADS);
    	gl.glVertex3f(55, 3, 55);
    	gl.glVertex3f(55, 3, 45);
    	gl.glVertex3f(55, 2, 45);
    	gl.glVertex3f(55, 2, 55);
    	gl.glEnd();
    	 
    	//Telescope in the corner
    	
        gl.glPushMatrix();
        gl.glTranslatef(85f, 0f, 85f);
        gl.glRotatef(-90f, 1f, 0f, 0f);
        glu.gluCylinder(quadric, .5, .5, 3., 10, 10);
        gl.glColor3f(.1f,.1f,.1f);
        beaconTexture.bind(gl);
        gl.glEnable(GL2.GL_TEXTURE_2D);
        gl.glRotatef(-40f,50f,0f,0f);
        gl.glTranslatef(0f, -2f, 1.8f);
        glu.gluCylinder(quadric, .7, .7, 4., 10, 10);
        gl.glDisable(GL2.GL_TEXTURE_2D);
        gl.glColor3f(0,0,1);
        gl.glTranslatef(.0f, .2f, .0f);
        diamondTexture.bind(gl);
        gl.glEnable(GL2.GL_TEXTURE_2D);
        glu.gluSphere(quadric,.8, 10, 10);
        gl.glDisable(GL2.GL_TEXTURE_2D);
        gl.glPopMatrix();
        
    	
    	//Wall2 with auto Texturing on each side.    	
        gl.glColor3f(0.5f,.4f,.5f);
    	gl.glEnable(GL2.GL_CULL_FACE);
        gl.glEnable(GL2.GL_TEXTURE_2D);
        wallTexture.bind(gl);
        gl.glEnable(GL2.GL_TEXTURE_GEN_S);
        gl.glEnable(GL2.GL_TEXTURE_GEN_T);
            gl.glTexGeni(GL2.GL_S, GL2.GL_TEXTURE_GEN_MODE, GL2.GL_OBJECT_LINEAR);
            gl.glTexGeni(GL2.GL_T, GL2.GL_TEXTURE_GEN_MODE, GL2.GL_OBJECT_LINEAR);
            float[] coef_s = {1f,0,0,0};
            gl.glTexGenfv(GL2.GL_S, GL2.GL_OBJECT_PLANE, coef_s, 0);
            float[] coef_t = {0,1f,0,0};
            gl.glTexGenfv(GL2.GL_T, GL2.GL_OBJECT_PLANE, coef_t, 0);
            gl.glBegin(GL2.GL_QUADS);
			 gl.glVertex3f(95,  50, 95);
			 gl.glVertex3f(5, 50, 95);
			 gl.glVertex3f( 5, 8, 95);
			 gl.glVertex3f(95,  8, 95);
			            
			 gl.glVertex3f(42,  8, 95);
			 gl.glVertex3f( 5,  8, 95);
			 gl.glVertex3f(5, 0, 95);
			 gl.glVertex3f(42, 0, 95);
			            
			  gl.glVertex3f(95,  8, 95);
			  gl.glVertex3f( 48,  8, 95);
			  gl.glVertex3f(48, 0, 95);
			  gl.glVertex3f(95, 0, 95);
            gl.glEnd();
        gl.glDisable(GL2.GL_TEXTURE_2D);
        gl.glDisable(GL2.GL_TEXTURE_GEN_S);
        gl.glDisable(GL2.GL_TEXTURE_GEN_T);
    	gl.glDisable(GL2.GL_CULL_FACE);
        gl.glColor3f(0,1,1);

    	gl.glEnable(GL2.GL_CULL_FACE);
        gl.glEnable(GL2.GL_TEXTURE_2D);
        pumpkinTexture.bind(gl);
        gl.glEnable(GL2.GL_TEXTURE_GEN_S);
        gl.glEnable(GL2.GL_TEXTURE_GEN_T);
            gl.glTexGeni(GL2.GL_S, GL2.GL_TEXTURE_GEN_MODE, GL2.GL_OBJECT_LINEAR);
            gl.glTexGeni(GL2.GL_T, GL2.GL_TEXTURE_GEN_MODE, GL2.GL_OBJECT_LINEAR);
            float[] coef_s1 = {.1f,0,0,0};
            gl.glTexGenfv(GL2.GL_S, GL2.GL_OBJECT_PLANE, coef_s1, 0);
            float[] coef_t1 = {0,.1f,0,0};
            gl.glTexGenfv(GL2.GL_T, GL2.GL_OBJECT_PLANE, coef_t1, 0);
            gl.glBegin(GL2.GL_QUADS);
			 gl.glVertex3f(5,  50, 95);
			 gl.glVertex3f(95, 50, 95);
			 gl.glVertex3f( 95, 8, 95);
			 gl.glVertex3f(5,  8, 95);
			            
			 gl.glVertex3f(5,  8, 95);
			 gl.glVertex3f(42,  8, 95);
			 gl.glVertex3f(42, 0, 95);
			 gl.glVertex3f(5, 0, 95);
			            
			  gl.glVertex3f(48,  8, 95);
			  gl.glVertex3f( 95,  8, 95);
			  gl.glVertex3f(95, 0, 95);
			  gl.glVertex3f(48, 0, 95);
            gl.glEnd();
        gl.glDisable(GL2.GL_TEXTURE_2D);
        gl.glDisable(GL2.GL_TEXTURE_GEN_S);
        gl.glDisable(GL2.GL_TEXTURE_GEN_T);
    	gl.glDisable(GL2.GL_CULL_FACE);
    }
}