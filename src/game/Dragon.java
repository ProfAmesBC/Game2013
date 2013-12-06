package game;
//Compiled from Dragon by SketchupModelJAXB

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import com.jogamp.opengl.util.GLBuffers;
import java.util.HashMap;
import java.util.Map;
public class Dragon
{
private int displayList = -1;
private Map<String, com.jogamp.opengl.util.texture.Texture> imageMap = new HashMap<String, com.jogamp.opengl.util.texture.Texture>(); // map of ID's to textures
public Dragon(GL2 gl, GLU glu) {
    generate(gl, glu);
}
public void draw(GL2 gl, GLU glu) {
  gl.glCallList(displayList);
}
private void generate(GL2 gl, GLU glu){

displayList = gl.glGenLists(1);
gl.glNewList(displayList, GL2.GL_COMPILE);
  gl.glPushAttrib(GL2.GL_POLYGON_BIT);
    gl.glFrontFace(GL2.GL_CCW);
    gl.glCullFace(GL2.GL_BACK);
    gl.glEnable(GL2.GL_CULL_FACE);
gl.glPushMatrix();
gl.glScaled(0.08333333232623386, 0.08333333232623386, 0.08333333232623386);
gl.glRotatef(-90,1,0,0);
{gl.glPushMatrix();
double[] darr = {1.0, 0.0, 0.0,  0.0,
        0.0, 1.0, 0.0, 0.0,
        0.0, 0.0, 1.0, 0.0,
        17.8063998723876, 19.84152215682008, 0.6931005145587079, 1.0 };
gl.glMultMatrixd(darr, 0);}
gl.glPopMatrix();
       gl.glPopMatrix();
   gl.glPopAttrib();
gl.glEndList();
}
//Trailer


}
