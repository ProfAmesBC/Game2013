package buildings;
// William Ames Fall 2013  Texture Demo

import game.Building;

import java.io.File;
import java.io.IOException;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;

import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.TextureIO;

class Land {
    private GLUquadric quadric; // to control properties of quadric-based objects
    private GLUquadric sphereQuadric; // for Signorile's head
    private Texture landTexture;

    public Land(GL2 gl, GLU glu) {
        quadric = glu.gluNewQuadric();
        glu.gluQuadricDrawStyle(quadric, GLU.GLU_FILL); // GLU_POINT, GLU_LINE, GLU_FILL, GLU_SILHOUETTE
        glu.gluQuadricNormals  (quadric, GLU.GLU_NONE); // GLU_NONE, GLU_FLAT, or GLU_SMOOTH
        glu.gluQuadricTexture  (quadric, true);        // use true to generate texture coordinates

        sphereQuadric = glu.gluNewQuadric();
        glu.gluQuadricDrawStyle(sphereQuadric, GLU.GLU_FILL);
        glu.gluQuadricNormals  (sphereQuadric, GLU.GLU_NONE);
        glu.gluQuadricTexture  (sphereQuadric, true); // for Signorile's head

        landTexture = Building.setupTexture(gl, "textureland.gif"); // png's don't seem to work any more
    }

    public void draw(GL2 gl, GLU glu) {

        // dirt land plot
        gl.glEnable(GL2.GL_TEXTURE_2D);
            landTexture.bind(gl);
            gl.glBegin(GL2.GL_QUADS);
            gl.glColor3d(0, 1, 0);
                gl.glTexCoord2f(0f,2f); 
                gl.glVertex3d(0,  0, 0);
                gl.glTexCoord2f(3f,2f); 
                gl.glVertex3d( 100,  0, 0);
                gl.glTexCoord2f(3f,0f); 
                gl.glVertex3d( 100, 0, -100);
                gl.glTexCoord2f(0f,0f); 
                gl.glVertex3d(0, 0, -100);
            gl.glEnd();
        gl.glDisable(GL2.GL_TEXTURE_2D);
 
   }
}
