package buildings;
// HW#5, CS333 DNDMachine class, Fall 2013
// by David D'Antona

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;
import com.jogamp.opengl.util.texture.Texture;

public class DNDMachine {
	
	private Texture compTexture1, compTexture2;
	private Point3d v1 = new Point3d(44,  7, 70);
	private Point3d v2 = new Point3d(40,  7, 70);
	private Point3d v3 = new Point3d(40,  0, 70);
	private Point3d v4 = new Point3d(44,  0, 70);
	
	private Point3d v5 = new Point3d(44,  7, 66);
	private Point3d v6 = new Point3d(40,  7, 66);
	private Point3d v7 = new Point3d(40,  0, 66);
	private Point3d v8 = new Point3d(44,  0, 66);

	public DNDMachine(GL2 gl, GLU glu, Texture compTexture1, Texture compTexture2) {
		this.compTexture1 = compTexture1;
		this.compTexture2 = compTexture2;
	}

	public void create(GL2 gl) {
		makeMachine(gl);
	}
	
	private void makeMachine(GL2 gl) {
		double rand = Math.random();
        gl.glEnable(GL2.GL_TEXTURE_2D);
        if(rand > 0.5)
        	compTexture1.bind(gl);
        else
        	compTexture2.bind(gl);

        gl.glEnable(GL2.GL_TEXTURE_GEN_S);
        gl.glEnable(GL2.GL_TEXTURE_GEN_T);
            gl.glTexGeni(GL2.GL_S, GL2.GL_TEXTURE_GEN_MODE, GL2.GL_OBJECT_LINEAR);
            gl.glTexGeni(GL2.GL_T, GL2.GL_TEXTURE_GEN_MODE, GL2.GL_OBJECT_LINEAR);
            float[] coef_s = {.5f,0,0,0};
            gl.glTexGenfv(GL2.GL_S, GL2.GL_OBJECT_PLANE, coef_s, 0);
            float[] coef_t = {0,.25f,0,0};
            gl.glTexGenfv(GL2.GL_T, GL2.GL_OBJECT_PLANE, coef_t, 0);
            gl.glBegin(GL2.GL_QUADS);
            	// front wall
                gl.glVertex3d(v1.getX(), v1.getY(), v1.getZ());
                gl.glVertex3d(v2.getX(), v2.getY(), v2.getZ());
                gl.glVertex3d(v3.getX(), v3.getY(), v3.getZ());
                gl.glVertex3d(v4.getX(), v4.getY(), v4.getZ());
                
                gl.glVertex3d(v4.getX(), v4.getY(), v4.getZ());
                gl.glVertex3d(v3.getX(), v3.getY(), v3.getZ());
                gl.glVertex3d(v2.getX(), v2.getY(), v2.getZ());
                gl.glVertex3d(v1.getX(), v1.getY(), v1.getZ());

                // back wall
                gl.glVertex3d(v5.getX(), v5.getY(), v5.getZ());
                gl.glVertex3d(v6.getX(), v6.getY(), v6.getZ());
                gl.glVertex3d(v7.getX(), v7.getY(), v7.getZ());
                gl.glVertex3d(v8.getX(), v8.getY(), v8.getZ());
                
                gl.glVertex3d(v8.getX(), v8.getY(), v8.getZ());
                gl.glVertex3d(v7.getX(), v7.getY(), v7.getZ());
                gl.glVertex3d(v6.getX(), v6.getY(), v6.getZ());
                gl.glVertex3d(v5.getX(), v5.getY(), v5.getZ());
                
                // left side
                gl.glVertex3d(v7.getX(), v7.getY(), v7.getZ());
                gl.glVertex3d(v3.getX(), v3.getY(), v3.getZ());
                gl.glVertex3d(v2.getX(), v2.getY(), v2.getZ());
                gl.glVertex3d(v6.getX(), v6.getY(), v6.getZ());
                
                gl.glVertex3d(v6.getX(), v6.getY(), v6.getZ());
                gl.glVertex3d(v2.getX(), v2.getY(), v2.getZ());
                gl.glVertex3d(v3.getX(), v3.getY(), v3.getZ());
                gl.glVertex3d(v7.getX(), v7.getY(), v7.getZ());
                
                // right side
                gl.glVertex3d(v5.getX(), v5.getY(), v5.getZ());
                gl.glVertex3d(v1.getX(), v1.getY(), v1.getZ());
                gl.glVertex3d(v4.getX(), v4.getY(), v4.getZ());
                gl.glVertex3d(v8.getX(), v8.getY(), v8.getZ());
                
                gl.glVertex3d(v8.getX(), v8.getY(), v8.getZ());
                gl.glVertex3d(v4.getX(), v4.getY(), v4.getZ());
                gl.glVertex3d(v1.getX(), v1.getY(), v1.getZ());
                gl.glVertex3d(v5.getX(), v5.getY(), v5.getZ());
                
                // top
                gl.glVertex3d(v5.getX(), v5.getY(), v5.getZ());
                gl.glVertex3d(v6.getX(), v6.getY(), v6.getZ());
                gl.glVertex3d(v2.getX(), v2.getY(), v2.getZ());
                gl.glVertex3d(v1.getX(), v1.getY(), v1.getZ());
                
                gl.glVertex3d(v1.getX(), v1.getY(), v1.getZ());
                gl.glVertex3d(v2.getX(), v2.getY(), v2.getZ());
                gl.glVertex3d(v6.getX(), v6.getY(), v6.getZ());
                gl.glVertex3d(v5.getX(), v5.getY(), v5.getZ());
                
        gl.glEnd();
        gl.glDisable(GL2.GL_TEXTURE_2D);
        gl.glDisable(GL2.GL_TEXTURE_GEN_S);
        gl.glDisable(GL2.GL_TEXTURE_GEN_T);
	}
	
}