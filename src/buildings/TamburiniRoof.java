package buildings;
import javax.media.opengl.GL2;

import com.jogamp.opengl.util.texture.Texture;


public class TamburiniRoof {

	private GL2 gl;
	private float width, height;
	
	// roof for a square building
	public TamburiniRoof(GL2 gl, float width, float height, Texture side, Texture roof){
		this.gl = gl;
		this.width = width;
		this.height = height;
		
            gl.glEnable(GL2.GL_TEXTURE_2D);
                side.bind(gl);
                triangles();
                
                gl.glPushMatrix();
                	gl.glTranslatef(0, 0, width);
                	triangles();
                gl.glPopMatrix();
                
                roof.bind(gl);
                rooftop();
                
                gl.glPushMatrix();
            		gl.glRotatef(180, 0, 1, 0);
            		gl.glTranslatef(-width, 0, -width);
            		rooftop();
            	gl.glPopMatrix();
                
            gl.glDisable(GL2.GL_TEXTURE_2D);
	}
	
	private void rooftop(){
		gl.glBegin(GL2.GL_QUADS);
			gl.glTexCoord2f(0f,0f);	gl.glVertex3f(0, 0, 0);
			gl.glTexCoord2f(0f,5f);	gl.glVertex3f(width/2, height, 0);
			gl.glTexCoord2f(5f,5f);	gl.glVertex3f(width/2, height, width);
			gl.glTexCoord2f(5f,0f);	gl.glVertex3f(0, 0, width);
		gl.glEnd();
	}
	
    private void triangles(){
    	gl.glBegin(GL2.GL_TRIANGLES);
    		gl.glTexCoord2f(1f,0f);	gl.glVertex3f(0, 0, 0);
    		gl.glTexCoord2f(1f,1f);	gl.glVertex3f(width, 0, 0);
    		gl.glTexCoord2f(0f,0f);	gl.glVertex3f(width/2, height, 0);
    	gl.glEnd();
	}
}
