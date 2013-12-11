package game;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;

public class ReadZBuffer {
    // from NeHe demo,  find the world coordinates of the point corresponding
    // to screen coordinates (x, y)
    public static double[] getOGLPos(GL2 gl, GLU glu, int x, int y) {
        int[] viewport = new int[4];
        double[] modelview  = {1,0,0,0, 0,1,0,0, 0,0,1,0, 0,0,0,1};
        double[] projection = {1,0,0,0, 0,1,0,0, 0,0,1,0, 0,0,0,1};
        double winX, winY;
        float[] winZ = new float[1];
        Buffer winZBuf = FloatBuffer.wrap(winZ);
     
        gl.glGetDoublev( GL2.GL_MODELVIEW_MATRIX, modelview, 0 ); // Kevin Watts stackoverflow said use identity.  Not likely.
        gl.glGetDoublev( GL2.GL_PROJECTION_MATRIX, projection, 0 );
        gl.glGetIntegerv( GL2.GL_VIEWPORT, viewport, 0 );
     
        winX = (double)x;
        winY = (double)viewport[3] - (double)y;
        gl.glReadPixels( x, (int)winY, 1, 1, GL2.GL_DEPTH_COMPONENT, GL2.GL_FLOAT, winZBuf );
     
        double[] objPos = new double[3];
        glu.gluUnProject(winX, winY, winZ[0], modelview, 0, projection, 0, viewport, 0, objPos, 0);
        
        // Draw sphere at objPos
//        gl.glPushMatrix();
//            gl.glTranslated(objPos[0], objPos[1], objPos[2]);
//            gl.glColor3f(1,0,0);
//            GLUquadric quadric = glu.gluNewQuadric();
//            glu.gluQuadricDrawStyle(quadric, GLU.GLU_LINE);
//            glu.gluQuadricNormals  (quadric, GLU.GLU_NONE);
//            glu.gluSphere(quadric, 1.0, 10, 10);
//        gl.glPopMatrix();
     
        return objPos;
    }
}