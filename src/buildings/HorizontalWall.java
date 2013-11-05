package buildings;
import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;

import com.jogamp.opengl.util.texture.Texture;


public class HorizontalWall {
	
	private double beginningX;
	private double beginningY;
	private double beginningZ;
	
	private double xLength;
	private double yLength;
	private double zLength;
	
	private Texture outside;
	private Texture inside;
	
	
	public HorizontalWall(double beginningX, double beginningY, double beginningZ,
			double xLength, double yLength, double zLength, Texture outside,
			Texture inside) {
		this.beginningX = beginningX;
		this.beginningY = beginningY;
		this.beginningZ = beginningZ;
		this.xLength = xLength;
		this.yLength = yLength;
		this.zLength = zLength;
		this.outside = outside;
		this.inside = inside;
	}


	public void draw(GL2 gl, GLU glu) {
		
		gl.glEnable(GL2.GL_TEXTURE_2D);
		gl.glEnable(GL2.GL_CULL_FACE);
		gl.glPushMatrix();
		
		gl.glEnable(GL2.GL_TEXTURE_GEN_S);
		gl.glEnable(GL2.GL_TEXTURE_GEN_T);
		outside.bind(gl);
		gl.glTexGeni(GL2.GL_S,GL2.GL_TEXTURE_GEN_MODE, GL2.GL_OBJECT_LINEAR);
		gl.glTexGeni(GL2.GL_T,GL2.GL_TEXTURE_GEN_MODE, GL2.GL_OBJECT_LINEAR);
		float[] coef_s = {1f,0,0,0};
		gl.glTexGenfv(GL2.GL_S,GL2.GL_OBJECT_PLANE,coef_s,0);
		float[] coef_t = {0,0,1,0};
		gl.glTexGenfv(GL2.GL_T,GL2.GL_OBJECT_PLANE,coef_t,0);
		gl.glBegin(GL2.GL_QUADS);
        gl.glVertex3d(beginningX,beginningY,beginningZ);
        gl.glVertex3d(beginningX+xLength,beginningY+yLength,beginningZ);
        gl.glVertex3d(beginningX+xLength,beginningY+yLength,beginningZ-zLength);
        gl.glVertex3d(beginningX,beginningY+yLength,beginningZ-zLength);
        gl.glEnd();
        inside.bind(gl);
        gl.glBegin(GL2.GL_QUADS);
        gl.glVertex3d(beginningX,beginningY,beginningZ);
        gl.glVertex3d(beginningX,beginningY+yLength,beginningZ-zLength);
        gl.glVertex3d(beginningX+xLength,beginningY+yLength,beginningZ-zLength);
        gl.glVertex3d(beginningX+xLength,beginningY+yLength,beginningZ);
        gl.glEnd();
        gl.glPopMatrix();
        gl.glDisable(GL2.GL_CULL_FACE);
        gl.glDisable(GL2.GL_TEXTURE_2D);
        gl.glDisable(GL2.GL_TEXTURE_GEN_S);
        gl.glDisable(GL2.GL_TEXTURE_GEN_T);
	}
}