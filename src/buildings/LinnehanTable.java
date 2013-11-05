package buildings;
import game.Building;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.*;

import com.jogamp.opengl.util.texture.Texture;

public class LinnehanTable extends Building{
    private GLUquadric quadric; // to control properties of quadric-based objects here
    private Texture metalTexture;
    
    public LinnehanTable(GL2 gl, GLU glu) {
        quadric = glu.gluNewQuadric();
        glu.gluQuadricDrawStyle(quadric, GLU.GLU_FILL); // GLU_POINT, GLU_LINE, GLU_FILL, GLU_SILHOUETTE
        glu.gluQuadricNormals  (quadric, GLU.GLU_NONE); // GLU_NONE, GLU_FLAT, or GLU_SMOOTH
        glu.gluQuadricTexture  (quadric, true);        // false, or true to generate texture coordinates
        
        metalTexture = setupTexture(gl, "LinnehanMetal047.jpg");
    }
    
    public void draw(GL2 gl, GLU glu) {

        // Prototypes:
        //glu.gluSphere(quadric,  radius, slices, stacks), center at origin
        //glu.gluCylinder quadric, base radius, top radius, height, slices, stacks), down +Z axis
        //glu.gluDisk(quadric, inner radius, outer radius, slices, stacks), in XY plane
        //glu.gluPartialDisk(quadric, inner radius, outer radius, slices, stacks, start angle, end angle)

        // legs

        gl.glColor3f(0f,0f,0f);
        gl.glPushMatrix();
        	gl.glTranslatef(40, 0, 40);
            gl.glRotatef(-90f, 1f, 0f, 0f); // stand upright (Y)
            glu.gluCylinder(quadric, 1., 1., 3., 10, 1);

            gl.glTranslatef(0, -20, 0);
            glu.gluCylinder(quadric, 1., 1., 3., 10, 1);
            
            gl.glTranslatef(20, 0, 0);
            glu.gluCylinder(quadric, 1., 1., 3., 10, 1);
            
            gl.glTranslatef(0, 20, 0);
            glu.gluCylinder(quadric, 1., 1., 3., 10, 1);
        gl.glPopMatrix();

        // top
        gl.glEnable(GL2.GL_TEXTURE_2D);
        metalTexture.bind(gl);
        gl.glEnable(GL2.GL_TEXTURE_GEN_S);
        gl.glEnable(GL2.GL_TEXTURE_GEN_T);
            gl.glTexGeni(GL2.GL_S, GL2.GL_TEXTURE_GEN_MODE, GL2.GL_OBJECT_LINEAR);
            gl.glTexGeni(GL2.GL_T, GL2.GL_TEXTURE_GEN_MODE, GL2.GL_OBJECT_LINEAR);
            float[] coef_s = {.5f,0,0,0};
            gl.glTexGenfv(GL2.GL_S, GL2.GL_OBJECT_PLANE, coef_s, 0);
            float[] coef_t = {0,.25f,0,0};
            gl.glTexGenfv(GL2.GL_T, GL2.GL_OBJECT_PLANE, coef_t, 0);
            gl.glBegin(GL2.GL_QUADS);
                gl.glVertex3f( 35,  3, 35);
                gl.glVertex3f(65,  3, 35);
                gl.glVertex3f(65, 3, 65);
                gl.glVertex3f(35, 3, 65);
                
                gl.glVertex3f( 35,  4, 35);
                gl.glVertex3f(65,  4, 35);
                gl.glVertex3f(65, 4, 65);
                gl.glVertex3f(35, 4, 65);
                
                gl.glVertex3f( 35,  3, 35);
                gl.glVertex3f(35,  4, 35);
                gl.glVertex3f(65, 4, 35);
                gl.glVertex3f(65, 3, 35);
                
                gl.glVertex3f( 35,  3, 65);
                gl.glVertex3f(35,  4, 65);
                gl.glVertex3f(65, 4, 65);
                gl.glVertex3f(65, 3, 65);
                
                gl.glVertex3f(35,  3, 35);
                gl.glVertex3f(35,  4, 35);
                gl.glVertex3f(35, 4, 65);
                gl.glVertex3f(35, 3, 65);
                
                gl.glVertex3f(65,  3, 35);
                gl.glVertex3f(65,  4, 35);
                gl.glVertex3f(65, 4, 65);
                gl.glVertex3f(65, 3, 65);
                
                gl.glVertex3f( 35,  3, 35);
                gl.glVertex3f(65,  3, 35);
                gl.glVertex3f(65, 3, 65);
                gl.glVertex3f(35, 3, 65);
            gl.glEnd();
        gl.glDisable(GL2.GL_TEXTURE_2D);
        gl.glDisable(GL2.GL_TEXTURE_GEN_S);
        gl.glDisable(GL2.GL_TEXTURE_GEN_T);
    }
    
    
}