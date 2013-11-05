package buildings;
import javax.media.opengl.GL2;
import javax.media.opengl.glu.*;

public class BaconTable
{
    private GLUquadric quadric; // to control properties of quadric-based objects here

    public BaconTable(GLU glu) {
        quadric = glu.gluNewQuadric();
        glu.gluQuadricDrawStyle(quadric, GLU.GLU_FILL); // GLU_POINT, GLU_LINE, GLU_FILL, GLU_SILHOUETTE
        glu.gluQuadricNormals  (quadric, GLU.GLU_NONE); // GLU_NONE, GLU_FLAT, or GLU_SMOOTH
        glu.gluQuadricTexture  (quadric, true);        // false, or true to generate texture coordinates
    }
    
    public void draw(GL2 gl, GLU glu) {
        gl.glColor3f(1f,0f,.25f);
        
        // Lamp Stem, cylindrical, a little smaller at the top.
        gl.glPushMatrix();
            gl.glRotatef(-90f, 1f, 0f, 0f); // stand upright (Y)
            glu.gluCylinder(quadric, 1., 1, 3., 10, 1);
            gl.glPopMatrix();
            
            //Table Top
            gl.glPushMatrix();
            gl.glTranslated(0, 3, 0);
              gl.glRotatef(-90f, 100f, 0f, 0f); // stand upright (Y)
              glu.gluDisk(quadric, 0, 4., 15, 5); // also to be flipped
              gl.glPopMatrix();
    }
}