package buildings;
import javax.media.opengl.GL2;

import com.jogamp.opengl.util.texture.Texture;


public class TamburiniWall {

	public TamburiniWall(GL2 gl, float width, float height, Texture front, Texture back){
		
		 gl.glEnable(GL2.GL_CULL_FACE);
             gl.glEnable(GL2.GL_TEXTURE_2D);
                 front.bind(gl);
                 gl.glBegin(GL2.GL_QUADS);
                     // ccw as viewed from front
                 	gl.glTexCoord2f(0f,5f);	gl.glVertex3f(0, 0, 0);
                 	gl.glTexCoord2f(2f,5f);	gl.glVertex3f(0, height, 0);
                 	gl.glTexCoord2f(2f,0f); gl.glVertex3f(width, height, 0);
                 	gl.glTexCoord2f(0f,0f);	gl.glVertex3f(width, 0, 0);
                 gl.glEnd();
                 back.bind(gl);
                 gl.glBegin(GL2.GL_QUADS);
                     // cw as viewed from front, so can be seen as ccw from back
                 	gl.glTexCoord2f(0f,0f);	gl.glVertex3f(width, 0, 0);
                 	gl.glTexCoord2f(2f,0f); gl.glVertex3f(width, height, 0);
                 	gl.glTexCoord2f(2f,5f);	gl.glVertex3f(0, height, 0);
                 	gl.glTexCoord2f(0f,5f);	gl.glVertex3f(0, 0, 0);
                 gl.glEnd();
                 gl.glBegin(GL2.GL_QUADS);
                 // cw as viewed from front, so can be seen as ccw from back
             	gl.glTexCoord2f(0f,0f);	gl.glVertex3f(width, 0, 0);
             	gl.glTexCoord2f(2f,0f); gl.glVertex3f(width, height, 0);
             	gl.glTexCoord2f(2f,5f);	gl.glVertex3f(0, height, 0);
             	gl.glTexCoord2f(0f,5f);	gl.glVertex3f(0, 0, 0);
             gl.glEnd();
             gl.glDisable(GL2.GL_TEXTURE_2D);
     gl.glDisable(GL2.GL_CULL_FACE);

	}
	
}
