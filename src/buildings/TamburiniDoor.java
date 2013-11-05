package buildings;
import javax.media.opengl.GL2;

import com.jogamp.opengl.util.texture.Texture;


public class TamburiniDoor {

	public TamburiniDoor(GL2 gl, Texture t){
		 gl.glEnable(GL2.GL_TEXTURE_2D);
	         t.bind(gl);
	         gl.glBegin(GL2.GL_QUADS);
				gl.glTexCoord2f(0f,0f);	gl.glVertex3f(0, 0, 0);
				gl.glTexCoord2f(0f,2f);	gl.glVertex3f(0, 10, 0);
				gl.glTexCoord2f(1f,2f);	gl.glVertex3f(5, 10, 0);
				gl.glTexCoord2f(1f,0f);	gl.glVertex3f(5, 0, 0);
			gl.glEnd();
	     gl.glDisable(GL2.GL_TEXTURE_2D);
	}
}
