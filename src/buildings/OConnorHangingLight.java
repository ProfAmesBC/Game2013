package buildings;
import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;


public class OConnorHangingLight implements OConnorScenery {

	private GLUquadric quadric;
	private float size, length, bobChange, x, y, z, r, g, b;
	private int colorChange;
	
	public OConnorHangingLight(float x, float yCeiling, float z, float size, float length, GL2 gl, GLU glu) {
		GLUquadric quadric = glu.gluNewQuadric();
		glu.gluQuadricDrawStyle(quadric, GLU.GLU_FILL);
		glu.gluQuadricNormals(quadric, GLU.GLU_FLAT);
		glu.gluQuadricTexture  (quadric, false);
		this.quadric = quadric;
		this.x = x;
		this.y = yCeiling;
		this.z = z;
		this.length = length;
		this.size = size;
		this.colorChange = (int)(Math.random()*100);
		this.bobChange = (float)(Math.random()*100);
		this.r = (float)Math.random();
		this.g = (float)Math.random();
		this.b = (float)Math.random();
	}

	@Override
	public void draw(GL2 gl, GLU glu) {

		// For bobbing up and down
        double bobFactor = (size/8)*Math.sin(bobChange);

        gl.glPushMatrix();
        	gl.glRotatef(-90f, 1f, 0f, 0f);
        	gl.glColor3d(1.0f,1.0f,1.0f);
    		gl.glTranslated(x, -z, y - length + bobFactor);
        	glu.gluCylinder(quadric, .1, .1, length, 10, 10);
        gl.glPopMatrix();

        // Change color randomly
        if (colorChange % 10 == 0) {
        	double colorToChange = Math.random();
        	if (colorToChange < 1/3)
        		r = (float)Math.random();
        	else if (colorToChange > 2/3)
        		g = (float)Math.random();
        	else
        		b = (float)Math.random();
        }
        
        gl.glPushMatrix();
        	gl.glRotatef(-90f, 1f, 0f, 0f);
    		gl.glColor3d(r, g, b);
    		gl.glTranslated(x, -z, y - length + bobFactor);
    		glu.gluSphere(quadric, size, 10, 10);
    		gl.glEnable(GL2.GL_BLEND);
				gl.glBlendFunc(GL2.GL_SRC_ALPHA, GL2.GL_ONE_MINUS_SRC_ALPHA);
				gl.glColor4d(r, g, b, .25);
				glu.gluSphere(quadric, 2*size, 10, 10);
			gl.glDisable(GL2.GL_BLEND);
    	gl.glPopMatrix();
    	
    	bobChange = bobChange + 0.1f;
    	colorChange++;
	}

}
