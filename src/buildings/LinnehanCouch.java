package buildings;
import game.Building;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.*;

import com.jogamp.opengl.util.texture.Texture;

public class LinnehanCouch extends Building{
    private GLUquadric quadric; // to control properties of quadric-based objects here
    private Texture couchTexture;
    
    public LinnehanCouch(GL2 gl, GLU glu) {
        quadric = glu.gluNewQuadric();
        glu.gluQuadricDrawStyle(quadric, GLU.GLU_FILL); // GLU_POINT, GLU_LINE, GLU_FILL, GLU_SILHOUETTE
        glu.gluQuadricNormals  (quadric, GLU.GLU_NONE); // GLU_NONE, GLU_FLAT, or GLU_SMOOTH
        glu.gluQuadricTexture  (quadric, true);        // false, or true to generate texture coordinates
        
        couchTexture = setupTexture(gl, "LinnehanCloth078.gif");
    }
    
    public void draw(GL2 gl, GLU glu) {

        // Prototypes:
        //glu.gluSphere(quadric,  radius, slices, stacks), center at origin
        //glu.gluCylinder quadric, base radius, top radius, height, slices, stacks), down +Z axis
        //glu.gluDisk(quadric, inner radius, outer radius, slices, stacks), in XY plane
        //glu.gluPartialDisk(quadric, inner radius, outer radius, slices, stacks, start angle, end angle)
        
    	//couch body
    	gl.glEnable(GL2.GL_TEXTURE_2D);
        couchTexture.bind(gl);
        
        gl.glBegin(GL2.GL_QUADS);
        	gl.glTexCoord2f(0f,0f); gl.glVertex3f( 15,  0, 83);
        	gl.glTexCoord2f(0f,1f);gl.glVertex3f(25,  0, 83);
        	gl.glTexCoord2f(1f,0f);gl.glVertex3f(25, 2, 83);
        	gl.glTexCoord2f(1f,1f);gl.glVertex3f(15, 2, 83);
	        
        	gl.glTexCoord2f(0f,0f);gl.glVertex3f( 15,  0, 88);
        	gl.glTexCoord2f(0f,1f);gl.glVertex3f(25,  0, 88);
        	gl.glTexCoord2f(1f,0f);gl.glVertex3f(25, 4, 88);
        	gl.glTexCoord2f(1f,1f);gl.glVertex3f(15, 4, 88);
	        
        	gl.glTexCoord2f(0f,0f);gl.glVertex3f( 15,  0, 83);
        	gl.glTexCoord2f(0f,1f);gl.glVertex3f(15,  0, 88);
        	gl.glTexCoord2f(1f,0f);gl.glVertex3f(15, 2, 88);
        	gl.glTexCoord2f(1f,1f);gl.glVertex3f(15, 2, 83);
	        
        	gl.glTexCoord2f(0f,0f);gl.glVertex3f( 25,  0, 83);
        	gl.glTexCoord2f(0f,1f);gl.glVertex3f(25,  0, 88);
        	gl.glTexCoord2f(1f,0f);gl.glVertex3f(25, 2, 88);
        	gl.glTexCoord2f(1f,1f);gl.glVertex3f(25, 2, 83);
	        
        	gl.glTexCoord2f(0f,0f);gl.glVertex3f( 15,  2, 83);
        	gl.glTexCoord2f(0f,1f);gl.glVertex3f(25,  2, 83);
        	gl.glTexCoord2f(1f,0f);gl.glVertex3f(25, 2, 88);
        	gl.glTexCoord2f(1f,1f);gl.glVertex3f(15, 2, 88);
	        
        	gl.glTexCoord2f(0f,0f);gl.glVertex3f( 15,  2, 87);
        	gl.glTexCoord2f(0f,1f);gl.glVertex3f(25,  2, 87);
        	gl.glTexCoord2f(1f,0f);gl.glVertex3f(25, 4, 87);
        	gl.glTexCoord2f(1f,1f);gl.glVertex3f(15, 4, 87);
	        
        	gl.glTexCoord2f(0f,0f);gl.glVertex3f( 15,  2, 87);
        	gl.glTexCoord2f(0f,1f);gl.glVertex3f(15,  2, 88);
        	gl.glTexCoord2f(1f,0f);gl.glVertex3f(15, 4, 88);
        	gl.glTexCoord2f(1f,1f);gl.glVertex3f(15, 4, 87);
	        
        	gl.glTexCoord2f(0f,0f);gl.glVertex3f( 25,  2, 87);
        	gl.glTexCoord2f(0f,1f);gl.glVertex3f(25,  2, 88);
        	gl.glTexCoord2f(1f,0f);gl.glVertex3f(25, 4, 88);
        	gl.glTexCoord2f(1f,1f);gl.glVertex3f(25, 4, 87);
	        
        	gl.glTexCoord2f(0f,0f); gl.glVertex3f( 15,  4, 87);
        	gl.glTexCoord2f(0f,1f);gl.glVertex3f(25,  4, 87);
        	gl.glTexCoord2f(1f,0f);gl.glVertex3f(25, 4, 88);
        	gl.glTexCoord2f(1f,1f);gl.glVertex3f(15, 4, 88);
	    gl.glEnd();
	    
	    //couch arms
	    gl.glPushMatrix();
    		gl.glTranslatef(16, 2, 83);
        	glu.gluCylinder(quadric, 1., 1., 5., 10, 1);

        	gl.glTranslatef(8, 0, 0);
        	glu.gluCylinder(quadric, 1., 1., 5., 10, 1);
        gl.glPopMatrix();
        gl.glDisable(GL2.GL_TEXTURE_2D);
    }
    
    
}