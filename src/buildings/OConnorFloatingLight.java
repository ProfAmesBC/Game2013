package buildings;
import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;


public class OConnorFloatingLight implements OConnorScenery {

	private GLUquadric quadric;
	private float size, speed, flightRadiusX, flightRadiusY, flightRadiusZ, posChange, x, y, z, r, g, b;
	private int colorChange;
	
	public OConnorFloatingLight(float x, float y, float z, float size, float speed, float radX, float radY, float radZ, GL2 gl, GLU glu) {
		GLUquadric quadric = glu.gluNewQuadric();
		glu.gluQuadricDrawStyle(quadric, GLU.GLU_FILL);
		glu.gluQuadricNormals(quadric, GLU.GLU_FLAT);
		glu.gluQuadricTexture  (quadric, false);
		this.quadric = quadric;
		this.x = x;
		this.y = y;
		this.z = z;
		this.size = size;
		this.flightRadiusX = radX;
		this.flightRadiusY = radY;
		this.flightRadiusZ = radZ;
		this.speed = speed;
		this.colorChange = (int)(Math.random()*100);
		this.posChange = (float)(Math.random()*100);
		this.r = (float)Math.random();
		this.g = (float)Math.random();
		this.b = (float)Math.random();
	}

	@Override
	public void draw(GL2 gl, GLU glu) {

		float rOld = r, gOld = g, bOld = b;

        // Change color randomly
        if (colorChange % 10 == 0) {
        	double colorToChange = Math.random();
        	if (colorToChange < 1/3) {
        		r = (float)Math.random();
        	}
        	else if (colorToChange > 2/3) {
        		g = (float)Math.random();
        	}
        	else {
        		b = (float)Math.random();
        	}
        }
        
        gl.glPushMatrix();
    		gl.glColor3d(r, g, b);
    		gl.glTranslated(x + flightRadiusX*Math.cos(posChange), y + flightRadiusY*Math.sin(posChange), z + flightRadiusZ*Math.sin(posChange));
    		glu.gluSphere(quadric, size, 10, 10);
    		gl.glEnable(GL2.GL_BLEND);
				gl.glBlendFunc(GL2.GL_SRC_ALPHA, GL2.GL_ONE_MINUS_SRC_ALPHA);
				gl.glColor4d(rOld, gOld, bOld, .25);
				glu.gluSphere(quadric, 2*size, 10, 10);
			gl.glDisable(GL2.GL_BLEND);
    	gl.glPopMatrix();
    	
    	posChange = posChange + speed*0.01f;
    	colorChange++;
	}

}
