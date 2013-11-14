package buildings;
import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;

import com.jogamp.opengl.util.texture.Texture;

public class OConnorQuad {

	private Texture front, back;
	private Point3d tl, tr, bl, br;
	private float texturingFrontX, texturingFrontY, texturingBackX, texturingBackY;

	public OConnorQuad(Point3d bottomLeft, Point3d bottomRight, Point3d topRight, Point3d topLeft, boolean stretch, Texture frontTexture, Texture backTexture, GL2 gl, GLU glu) {
		this.bl = bottomLeft;
		this.br = bottomRight;
		this.tr = topRight;
		this.tl = topLeft;
		this.front = frontTexture;
		this.back = backTexture;
		this.texturingFrontX = stretch ? 1 : (float) (Math.sqrt((bottomRight.getX() - bottomLeft.getX())*(bottomRight.getX() - bottomLeft.getX()) +
				(bottomRight.getY() - bottomLeft.getY())*(bottomRight.getY() - bottomLeft.getY()) +
				(bottomRight.getZ() - bottomLeft.getZ())*(bottomRight.getZ() - bottomLeft.getZ()))/(32 - Integer.numberOfLeadingZeros(frontTexture.getImageWidth())));
		this.texturingFrontY = stretch ? 1 :(float) (frontTexture.getAspectRatio()*(Math.sqrt((topLeft.getX() - bottomLeft.getX())*(topLeft.getX() - bottomLeft.getX()) +
				(topLeft.getY() - bottomLeft.getY())*(topLeft.getY() - bottomLeft.getY()) +
				(topLeft.getZ() - bottomLeft.getZ())*(topLeft.getZ() - bottomLeft.getZ()))/(32 - Integer.numberOfLeadingZeros(frontTexture.getImageHeight()))));
		this.texturingBackX = stretch ? 1: (float) (Math.sqrt((bottomRight.getX() - bottomLeft.getX())*(bottomRight.getX() - bottomLeft.getX()) +
				(bottomRight.getY() - bottomLeft.getY())*(bottomRight.getY() - bottomLeft.getY()) +
				(bottomRight.getZ() - bottomLeft.getZ())*(bottomRight.getZ() - bottomLeft.getZ()))/(32 - Integer.numberOfLeadingZeros(backTexture.getImageWidth())));
		this.texturingBackY = stretch ? 1 : (float) (backTexture.getAspectRatio()*(Math.sqrt((topLeft.getX() - bottomLeft.getX())*(topLeft.getX() - bottomLeft.getX()) +
				(topLeft.getY() - bottomLeft.getY())*(topLeft.getY() - bottomLeft.getY()) +
				(topLeft.getZ() - bottomLeft.getZ())*(topLeft.getZ() - bottomLeft.getZ()))/(32 - Integer.numberOfLeadingZeros(backTexture.getImageHeight()))));
	}

	public void drawFront(GL2 gl, GLU glu) {
		gl.glEnable(GL2.GL_CULL_FACE);
	    gl.glPushMatrix();
	    gl.glEnable(GL2.GL_TEXTURE_2D);

	    	front.bind(gl);
	    	gl.glBegin(GL2.GL_QUADS);
	    		gl.glTexCoord2f(0f,0f); gl.glVertex3d(bl.getX(), bl.getY(), bl.getZ());
	    		gl.glTexCoord2f(0f,texturingFrontY); gl.glVertex3d(tl.getX(), tl.getY(), tl.getZ());
	    		gl.glTexCoord2f(texturingFrontX,texturingFrontY); gl.glVertex3d(tr.getX(), tr.getY(), tr.getZ());
	    		gl.glTexCoord2f(texturingFrontX,0f); gl.glVertex3d(br.getX(), br.getY(), br.getZ());
	    	gl.glEnd();

	    gl.glDisable(GL2.GL_TEXTURE_2D);
	    gl.glPopMatrix();
	    gl.glDisable(GL2.GL_CULL_FACE);
	}
	
	public void drawBack(GL2 gl, GLU glu) {
		gl.glEnable(GL2.GL_CULL_FACE);
	    gl.glPushMatrix();
	    gl.glEnable(GL2.GL_TEXTURE_2D);
	    	
	    	back.bind(gl);
	    	gl.glBegin(GL2.GL_QUADS);
	    		gl.glTexCoord2f(0f,texturingBackY); gl.glVertex3d(bl.getX(), bl.getY(), bl.getZ());
	    		gl.glTexCoord2f(texturingBackX,texturingBackY); gl.glVertex3d(br.getX(), br.getY(), br.getZ());
	    		gl.glTexCoord2f(texturingBackX,0f); gl.glVertex3d(tr.getX(), tr.getY(), tr.getZ());
	    		gl.glTexCoord2f(0f,0f); gl.glVertex3d(tl.getX(), tl.getY(), tl.getZ());
	    	gl.glEnd();

	    gl.glDisable(GL2.GL_TEXTURE_2D);
	    gl.glPopMatrix();
	    gl.glDisable(GL2.GL_CULL_FACE);
	}
}
