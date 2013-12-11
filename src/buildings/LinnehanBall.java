package buildings;
import game.Building;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.*;

import com.jogamp.opengl.util.texture.Texture;

public class LinnehanBall extends Building{
    private GLUquadric quadric; // to control properties of quadric-based objects here
    private Texture flagTexture;
  
    public LinnehanBall(GL2 gl, GLU glu) {
        quadric = glu.gluNewQuadric();
        glu.gluQuadricDrawStyle(quadric, GLU.GLU_FILL); // GLU_POINT, GLU_LINE, GLU_FILL, GLU_SILHOUETTE
        glu.gluQuadricNormals  (quadric, GLU.GLU_NONE); // GLU_NONE, GLU_FLAT, or GLU_SMOOTH
        glu.gluQuadricTexture  (quadric, true);        // false, or true to generate texture coordinates
        
        flagTexture = setupTexture(gl, "LinnehanFLag366a.jpg");
    }
    
    public void draw(GL2 gl, GLU glu) {

        // Prototypes:
        //glu.gluSphere(quadric,  radius, slices, stacks), center at origin
        //glu.gluCylinder quadric, base radius, top radius, height, slices, stacks), down +Z axis
        //glu.gluDisk(quadric, inner radius, outer radius, slices, stacks), in XY plane
        //glu.gluPartialDisk(quadric, inner radius, outer radius, slices, stacks, start angle, end angle)
        
    	//flag
    	gl.glEnable(GL2.GL_TEXTURE_2D);
        flagTexture.bind(gl);
        gl.glPushMatrix();
            gl.glTranslatef(20, 2, 15); 
            glu.gluSphere(quadric, 2., 10, 10);
        gl.glPopMatrix();
        gl.glDisable(GL2.GL_TEXTURE_2D);
    }
    
    
}