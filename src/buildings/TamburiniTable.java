package buildings;
import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;

import com.jogamp.opengl.util.texture.Texture;


public class TamburiniTable {

	private GLUquadric quadric;
	private GLUquadric sphere;
	private GL2 gl;
	private GLU glu;
	
	public TamburiniTable(GL2 gl, GLU glu, Texture table, Texture chair){

		this.gl = gl;
		this.glu = glu;
		
		float w = 5;
		float h = 3.5f;
		
		quadric = glu.gluNewQuadric();
		glu.gluQuadricDrawStyle(quadric, GLU.GLU_FILL);
		glu.gluQuadricNormals(quadric, GLU.GLU_NONE);
		glu.gluQuadricTexture(quadric, true);
		
		sphere = glu.gluNewQuadric();
		glu.gluQuadricDrawStyle(sphere, GLU.GLU_FILL);
		glu.gluQuadricNormals(sphere, GLU.GLU_NONE);
		glu.gluQuadricTexture(sphere, true);
		
		gl.glPushMatrix();
			gl.glTranslatef(-w/2, 0, -w/2);
				tabletop(table, h, w);
				tableStem(table, h, w);
		gl.glPopMatrix();
		
		// draw four chairs
		gl.glPushMatrix();
			gl.glTranslatef(-w * .75f, 0, 0);
			chair(chair);
			gl.glTranslatef(w * .75f, 0, -w * .75f);
			chair(chair);
			gl.glTranslatef(w * .75f, 0, w * .75f);
			chair(chair);
			gl.glTranslatef(-w * .75f, 0, 1*(w * .75f));
			chair(chair);
		gl.glPopMatrix();
	}
	
	private void chair(Texture t){
		gl.glEnable(GL2.GL_TEXTURE_2D);
			t.bind(gl);
			gl.glPushMatrix();
				gl.glTranslatef(0, 1, 0);
				glu.gluSphere(sphere, 1, 10, 10);
			gl.glPopMatrix();
		gl.glDisable(GL2.GL_TEXTURE_2D);
	}
	
	private void tableStem(Texture t, float h, float w){
		gl.glEnable(GL2.GL_TEXTURE_2D);
			t.bind(gl);
			gl.glPushMatrix();
				gl.glTranslatef(w/2, 0, w/2);
				gl.glRotatef(-90f, 1f, 0, 0);
				glu.gluCylinder(quadric, .2, .2, h, 10, 1);
			gl.glPopMatrix();
		gl.glDisable(GL2.GL_TEXTURE_2D);
		
	}
	
	private void tabletop(Texture t, float h, float w){
         
		 // tabletop
		 gl.glEnable(GL2.GL_TEXTURE_2D);
		 	t.bind(gl);
		 	gl.glBegin(GL2.GL_QUADS);
	         	gl.glTexCoord2f(0f,0f);	gl.glVertex3f(0, h, 0);
	         	gl.glTexCoord2f(1f,0f); gl.glVertex3f(0, h, w);
	         	gl.glTexCoord2f(1f,1f);	gl.glVertex3f(w, h, w);
	         	gl.glTexCoord2f(0f,1f);	gl.glVertex3f(w, h, 0);
	         gl.glEnd();
	         
	         //sides of table
	         float sideW = 0.25f;
	         gl.glBegin(GL2.GL_QUADS);
	         	gl.glTexCoord2f(0f,0f);	gl.glVertex3f(0, h-sideW, 0);
	         	gl.glTexCoord2f(1f,0f); gl.glVertex3f(0, h, 0);
	         	gl.glTexCoord2f(1f,1f);	gl.glVertex3f(w, h, 0);
	         	gl.glTexCoord2f(0f,1f);	gl.glVertex3f(w, h-sideW, 0);
	         gl.glEnd();
	         
	         gl.glBegin(GL2.GL_QUADS);
	         	gl.glTexCoord2f(0f,0f);	gl.glVertex3f(0, h-sideW, w);
	         	gl.glTexCoord2f(1f,0f); gl.glVertex3f(0, h, w);
	         	gl.glTexCoord2f(1f,1f);	gl.glVertex3f(w, h, w);
	         	gl.glTexCoord2f(0f,1f);	gl.glVertex3f(w, h-sideW, w);
	      	gl.glEnd();
	      
	      	gl.glBegin(GL2.GL_QUADS);
	      		gl.glTexCoord2f(0f,0f);	gl.glVertex3f(0, h-sideW, 0);
	      		gl.glTexCoord2f(1f,0f); gl.glVertex3f(0, h-sideW, w);
	      		gl.glTexCoord2f(1f,1f);	gl.glVertex3f(0, h, w);
	      		gl.glTexCoord2f(0f,1f);	gl.glVertex3f(0, h, 0);
	      	gl.glEnd();
	      	
	      	gl.glBegin(GL2.GL_QUADS);
	  			gl.glTexCoord2f(0f,0f);	gl.glVertex3f(w, h-sideW, 0);
	  			gl.glTexCoord2f(1f,0f); gl.glVertex3f(w, h-sideW, w);
	  			gl.glTexCoord2f(1f,1f);	gl.glVertex3f(w, h, w);
	  			gl.glTexCoord2f(0f,1f);	gl.glVertex3f(w, h, 0);
	  		gl.glEnd();
  		gl.glDisable(GL2.GL_TEXTURE_2D);
   
	}
}
