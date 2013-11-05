package buildings;
// HW#5, CS333 DNDSpecialItem class, Fall 2013
// by David D'Antona

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;
import com.jogamp.opengl.util.texture.Texture;

public class DNDSpecialItem {

	private GLUquadric sphereQuadric;
	private Texture blueTexture;
	private double x = 50;
	private double y = 2;
	private double z = 50;

	public DNDSpecialItem(GL2 gl, GLU glu, Texture blueTexture) {
		this.blueTexture = blueTexture;
		sphereQuadric = glu.gluNewQuadric();
		glu.gluQuadricDrawStyle(sphereQuadric, GLU.GLU_FILL);
		glu.gluQuadricNormals(sphereQuadric, GLU.GLU_NONE);
		glu.gluQuadricTexture(sphereQuadric, true);
	}
	
	public void create(GL2 gl, GLU glu) {
		makeItem(gl, glu);
	}

	private void makeItem(GL2 gl, GLU glu) {
        gl.glEnable(GL2.GL_TEXTURE_2D);
        blueTexture.bind(gl);
        gl.glEnable(GL2.GL_TEXTURE_GEN_S);
        gl.glEnable(GL2.GL_TEXTURE_GEN_T);
            gl.glTexGeni(GL2.GL_S, GL2.GL_TEXTURE_GEN_MODE, GL2.GL_OBJECT_LINEAR);
            gl.glTexGeni(GL2.GL_T, GL2.GL_TEXTURE_GEN_MODE, GL2.GL_OBJECT_LINEAR);
            float[] coef_s = {.5f,0,0,0};
            gl.glTexGenfv(GL2.GL_S, GL2.GL_OBJECT_PLANE, coef_s, 0);
            float[] coef_t = {0,.25f,0,0};
            gl.glTexGenfv(GL2.GL_T, GL2.GL_OBJECT_PLANE, coef_t, 0);
            	
            gl.glPushMatrix();
            	gl.glTranslated(x, y, z);
            	glu.gluSphere(sphereQuadric, 1., 10, 10);
            gl.glPopMatrix();
            
            gl.glPushMatrix();
        		gl.glTranslated(x + 1.5, y - 1, z);
        		glu.gluSphere(sphereQuadric, 1., 10, 10);
        	gl.glPopMatrix();
        	
            gl.glPushMatrix();
        		gl.glTranslated(x - 1.5, y - 1, z);
        		glu.gluSphere(sphereQuadric, 1., 10, 10);
        	gl.glPopMatrix();
        	
            gl.glPushMatrix();
        		gl.glTranslated(x + 1.5, y + 1, z);
        		glu.gluSphere(sphereQuadric, 1., 10, 10);
        	gl.glPopMatrix();
        	
            gl.glPushMatrix();
        		gl.glTranslated(x - 1.5, y + 1, z);
        		glu.gluSphere(sphereQuadric, 1., 10, 10);
        	gl.glPopMatrix();
            
        gl.glDisable(GL2.GL_TEXTURE_2D);
        gl.glDisable(GL2.GL_TEXTURE_GEN_S);
        gl.glDisable(GL2.GL_TEXTURE_GEN_T);
	}

}