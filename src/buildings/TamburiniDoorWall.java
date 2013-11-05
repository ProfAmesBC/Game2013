package buildings;
import javax.media.opengl.GL2;

import com.jogamp.opengl.util.texture.Texture;


public class TamburiniDoorWall {

	public TamburiniDoorWall(GL2 gl, float width, float height, Texture front, Texture back){
		
		
		gl.glEnable(GL2.GL_CULL_FACE);
		gl.glEnable(GL2.GL_TEXTURE_2D);

		// draw front
		front.bind(gl);
        gl.glEnable(GL2.GL_TEXTURE_GEN_S);
        gl.glEnable(GL2.GL_TEXTURE_GEN_T);
            gl.glTexGeni(GL2.GL_S, GL2.GL_TEXTURE_GEN_MODE, GL2.GL_OBJECT_LINEAR);
            gl.glTexGeni(GL2.GL_T, GL2.GL_TEXTURE_GEN_MODE, GL2.GL_OBJECT_LINEAR);
            float[] coef_s = {.1f,0,0,0};
            float[] coef_t = {0,.1f,0,0};
            gl.glTexGenfv(GL2.GL_S, GL2.GL_OBJECT_PLANE, coef_t, 0);
            gl.glTexGenfv(GL2.GL_T, GL2.GL_OBJECT_PLANE, coef_s, 0);
            gl.glBegin(GL2.GL_QUADS);
                gl.glVertex3f( 0,  0, 0);
                gl.glVertex3f(0, height, 0);
                gl.glVertex3f(width/2 - 5, height, 0);
                gl.glVertex3f(width/2 - 5, 0, 0);
            gl.glEnd();
            gl.glBegin(GL2.GL_QUADS);
        		gl.glVertex3f(width/2 - 5, height - 10, 0);
        		gl.glVertex3f(width/2 - 5, height, 0);
        		gl.glVertex3f(width/2 + 5, height, 0);
        		gl.glVertex3f(width/2 + 5, height - 10, 0);
        	gl.glEnd();
        	gl.glBegin(GL2.GL_QUADS);
        		gl.glVertex3f(width/2 + 5, 0, 0);
        		gl.glVertex3f(width/2 + 5, height, 0);
        		gl.glVertex3f(width, height, 0);
        		gl.glVertex3f(width, 0, 0);
        	gl.glEnd();
        	
        	// draw back
        	float[] coef_t2 = {.2f,0,0,0};
        	float[] coef_s2 = {0,.1f,0,0};
            gl.glTexGenfv(GL2.GL_S, GL2.GL_OBJECT_PLANE, coef_s2, 0);
            gl.glTexGenfv(GL2.GL_T, GL2.GL_OBJECT_PLANE, coef_t2, 0);
        	back.bind(gl);
        	gl.glBegin(GL2.GL_QUADS);
        		gl.glVertex3f(width/2 - 5, 0, 0);
        		gl.glVertex3f(width/2 - 5, height, 0);
        		gl.glVertex3f(0, height, 0);
        		gl.glVertex3f( 0,  0, 0);
        	gl.glEnd();
        	gl.glBegin(GL2.GL_QUADS);
        		gl.glVertex3f(width/2 + 5, height-10, 0);
        		gl.glVertex3f(width/2 + 5, height, 0);
        		gl.glVertex3f(width/2 - 5, height, 0);
        		gl.glVertex3f(width/2 - 5, height - 10, 0);
    		gl.glEnd();
    	gl.glBegin(GL2.GL_QUADS);
    		gl.glVertex3f(width, 0, 0);
    		gl.glVertex3f(width, height, 0);
    		gl.glVertex3f(width/2 + 5, height, 0);
    		gl.glVertex3f(width/2 + 5, 0, 0);

    	gl.glEnd();
        gl.glDisable(GL2.GL_TEXTURE_2D);
        gl.glDisable(GL2.GL_TEXTURE_GEN_S);
        gl.glDisable(GL2.GL_TEXTURE_GEN_T);
        gl.glDisable(GL2.GL_CULL_FACE);
		
	}
	
}
