package buildings;
import game.Building;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;

import com.jogamp.opengl.util.texture.Texture;


public class MeuseBuilding extends Building{

	
	private GLUquadric quadric;
	private GLUquadric textureQuadric;
	private Texture grassTexture;
	private Texture wallTexture;
	private Texture sidingTexture;
	private Texture floorTexture;
	private Texture posterTexture;
	private Texture tableTexture;
	
	
    public MeuseBuilding(GL2 gl, GLU glu) {
        quadric = glu.gluNewQuadric();
        glu.gluQuadricDrawStyle(quadric, GLU.GLU_FILL); // GLU_POINT, GLU_LINE, GLU_FILL, GLU_SILHOUETTE
        glu.gluQuadricNormals  (quadric, GLU.GLU_NONE); // GLU_NONE, GLU_FLAT, or GLU_SMOOTH
        glu.gluQuadricTexture  (quadric, false);        // use true to generate texture coordinates

        textureQuadric = glu.gluNewQuadric();
        glu.gluQuadricDrawStyle(textureQuadric, GLU.GLU_FILL);
        glu.gluQuadricNormals  (textureQuadric, GLU.GLU_NONE);
        glu.gluQuadricTexture  (textureQuadric, true); // for textured quadrics

        wallTexture = setupTexture(gl, "MeuseWall.jpg");
        sidingTexture = setupTexture(gl, "MeuseSiding.jpg"); // png's don't seem to work any more
        grassTexture=setupTexture(gl, "MeuseGrass.jpg");
        floorTexture=setupTexture(gl, "MeuseFloor.gif");
        posterTexture=setupTexture(gl, "MeusePoster.jpg");
        tableTexture=setupTexture(gl, "MeuseTable.gif");
    }





	public void draw(GL2 gl, GLU glu) {	//draw all stationary stuff: walls, floors, etc.
	
	// Floor
	gl.glEnable(GL2.GL_TEXTURE_2D);
        floorTexture.bind(gl);
        gl.glBegin(GL2.GL_QUADS);
            gl.glTexCoord2f(0f,5f); gl.glVertex3f(20,  0, 20);
            gl.glTexCoord2f(8f,5f); gl.glVertex3f( 80,  0, 20);
            gl.glTexCoord2f(8f,0f); gl.glVertex3f( 80, 0, 80);
            gl.glTexCoord2f(0f,0f); gl.glVertex3f(20, 0, 80);
        gl.glEnd();
    gl.glDisable(GL2.GL_TEXTURE_2D); 
    
    //Grass
    gl.glEnable(GL2.GL_TEXTURE_2D);
    grassTexture.bind(gl);
    gl.glEnable(GL2.GL_TEXTURE_GEN_S);
    gl.glEnable(GL2.GL_TEXTURE_GEN_T);
        gl.glTexGeni(GL2.GL_S, GL2.GL_TEXTURE_GEN_MODE, GL2.GL_OBJECT_LINEAR);
        gl.glTexGeni(GL2.GL_T, GL2.GL_TEXTURE_GEN_MODE, GL2.GL_OBJECT_LINEAR);
        float[] coef_s = {.5f,0,0,0};
        gl.glTexGenfv(GL2.GL_S, GL2.GL_OBJECT_PLANE, coef_s, 0);
        float[] coef_t = {0,0,.25f,0};
        gl.glTexGenfv(GL2.GL_T, GL2.GL_OBJECT_PLANE, coef_t, 0);
        gl.glBegin(GL2.GL_QUADS);
            gl.glVertex3f( 0,  0, 0);
            gl.glVertex3f(20,  0, 0);
            gl.glVertex3f(20, 0, 100);
            gl.glVertex3f( 0, 0, 100);
        gl.glEnd();
        gl.glBegin(GL2.GL_QUADS);
        	gl.glVertex3f( 20,  0, 0);
        	gl.glVertex3f(80,  0, 0);
        	gl.glVertex3f(80, 0, 20);
        	gl.glVertex3f( 20, 0, 20);
        gl.glEnd();
        gl.glBegin(GL2.GL_QUADS);
    		gl.glVertex3f( 20,  0, 80);
    		gl.glVertex3f(80,  0, 80);
    		gl.glVertex3f(80, 0, 100);
    		gl.glVertex3f( 20, 0, 100);
    	gl.glEnd();
        gl.glBegin(GL2.GL_QUADS);
    		gl.glVertex3f( 80,  0, 0);
    		gl.glVertex3f(100,  0, 0);
    		gl.glVertex3f(100, 0, 100);
    		gl.glVertex3f( 80, 0, 100);
    	gl.glEnd();
    gl.glDisable(GL2.GL_TEXTURE_2D);
    gl.glDisable(GL2.GL_TEXTURE_GEN_S);
    gl.glDisable(GL2.GL_TEXTURE_GEN_T);

    
    gl.glEnable(GL2.GL_CULL_FACE);
    gl.glPushMatrix();
        gl.glEnable(GL2.GL_TEXTURE_2D);
        //right side
            wallTexture.bind(gl);
            gl.glBegin(GL2.GL_QUADS);
                // ccw as viewed from front
                gl.glTexCoord2f(0f,2f); gl.glVertex3f( 80,  0, 20);
                gl.glTexCoord2f(3f,2f); gl.glVertex3f(80,  0, 80);
                gl.glTexCoord2f(3f,0f);  gl.glVertex3f(80, 20, 80);
                gl.glTexCoord2f(0f,0f); gl.glVertex3f( 80, 20, 20);
            gl.glEnd();
            sidingTexture.bind(gl);
            gl.glBegin(GL2.GL_QUADS);
                // cw as viewed from front, so can be seen as ccw from back
                gl.glTexCoord2f(0f,2f); gl.glVertex3f(80,  0, 20);
                gl.glTexCoord2f(3f,2f); gl.glVertex3f(80, 20, 20);
                gl.glTexCoord2f(3f,0f); gl.glVertex3f(80, 20, 80);
                gl.glTexCoord2f(0f,0f); gl.glVertex3f( 80,  0, 80);
            gl.glEnd();
            
        //front with door   
        wallTexture.bind(gl);
            gl.glBegin(GL2.GL_QUADS);			//front with door
            	gl.glTexCoord2f(0f,2f); gl.glVertex3f( 20,  0, 20);
            	gl.glTexCoord2f(3f,2f); gl.glVertex3f(48,  0, 20);
            	gl.glTexCoord2f(3f,0f); gl.glVertex3f(48, 20, 20);
            	gl.glTexCoord2f(0f,0f); gl.glVertex3f( 20, 20, 20);
            gl.glEnd();
        sidingTexture.bind(gl);
            gl.glBegin(GL2.GL_QUADS);
            	gl.glTexCoord2f(0f,2f); gl.glVertex3f( 20,  0, 20);
            	gl.glTexCoord2f(3f,2f); gl.glVertex3f(20,  20, 20);
            	gl.glTexCoord2f(3f,0f); gl.glVertex3f(48, 20, 20);
            	gl.glTexCoord2f(0f,0f); gl.glVertex3f( 48, 0, 20);
            gl.glEnd(); 
            
        wallTexture.bind(gl);
            gl.glBegin(GL2.GL_QUADS);			
        		gl.glTexCoord2f(0f,1.25f); gl.glVertex3f( 48,  7, 20);
        		gl.glTexCoord2f(1.25f,1.25f); gl.glVertex3f(52,  7, 20);
        		gl.glTexCoord2f(1.25f,0f); gl.glVertex3f(52, 20, 20);
        		gl.glTexCoord2f(0f,0f); gl.glVertex3f( 48, 20, 20);
        	gl.glEnd();
        sidingTexture.bind(gl);
        	gl.glBegin(GL2.GL_QUADS);
        		gl.glTexCoord2f(1.25f,1.25f); gl.glVertex3f( 48,  7, 20);
        		gl.glTexCoord2f(1.25f,2f); gl.glVertex3f(48,  20, 20);
        		gl.glTexCoord2f(2f,2f); gl.glVertex3f(52, 20, 20);
        		gl.glTexCoord2f(2f,1.25f); gl.glVertex3f( 52, 7, 20);
        	gl.glEnd();
        	
        wallTexture.bind(gl);
            gl.glBegin(GL2.GL_QUADS);			
        		gl.glTexCoord2f(0f,2f); gl.glVertex3f( 52,  0, 20);
        		gl.glTexCoord2f(3f,2f); gl.glVertex3f(80,  0, 20);
        		gl.glTexCoord2f(3f,0f); gl.glVertex3f(80, 20, 20);
        		gl.glTexCoord2f(0f,0f); gl.glVertex3f( 52, 20, 20);
        	gl.glEnd();
        sidingTexture.bind(gl);
        	gl.glBegin(GL2.GL_QUADS);
        		gl.glTexCoord2f(0f,2f); gl.glVertex3f( 52,  0, 20);
        		gl.glTexCoord2f(3f,2f); gl.glVertex3f(52,  20, 20);
        		gl.glTexCoord2f(3f,0f); gl.glVertex3f(80, 20, 20);
        		gl.glTexCoord2f(0f,0f); gl.glVertex3f( 80, 0, 20);
        	gl.glEnd(); 
        	
        	//left side	
          wallTexture.bind(gl);
    		gl.glBegin(GL2.GL_QUADS);
    			gl.glTexCoord2f(0f,2f); gl.glVertex3f( 20,  0, 20);
    			gl.glTexCoord2f(3f,2f); gl.glVertex3f(20,  20, 20);
    			gl.glTexCoord2f(3f,0f); gl.glVertex3f(20, 20, 80);
    			gl.glTexCoord2f(0f,0f); gl.glVertex3f(20, 0, 80);
    		gl.glEnd(); 
          sidingTexture.bind(gl);
         	gl.glBegin(GL2.GL_QUADS);
         		gl.glTexCoord2f(0f,2f); gl.glVertex3f( 20,  0, 20);
         		gl.glTexCoord2f(3f,2f); gl.glVertex3f(20,  0, 80);
    			gl.glTexCoord2f(3f,0f); gl.glVertex3f(20, 20, 80);
    			gl.glTexCoord2f(0f,0f); gl.glVertex3f( 20, 20, 20);
    		gl.glEnd();
        	
    		//back side with door
    		sidingTexture.bind(gl);
            gl.glBegin(GL2.GL_QUADS);			
            	gl.glTexCoord2f(0f,2f); gl.glVertex3f( 20,  0, 80);
         		gl.glTexCoord2f(3f,2f); gl.glVertex3f(50,  0, 80);
    			gl.glTexCoord2f(3f,0f); gl.glVertex3f(50, 20, 80);
    			gl.glTexCoord2f(0f,0f); gl.glVertex3f( 20, 20, 80);
        	gl.glEnd();
            wallTexture.bind(gl);          
           	gl.glBegin(GL2.GL_QUADS);
           		gl.glTexCoord2f(0f,2f); gl.glVertex3f( 20,  0, 80);
           		gl.glTexCoord2f(3f,2f); gl.glVertex3f(20,  20, 80);
      			gl.glTexCoord2f(3f,0f); gl.glVertex3f(50, 20, 80);
      			gl.glTexCoord2f(0f,0f); gl.glVertex3f( 50, 0, 80);
      		gl.glEnd();

            wallTexture.bind(gl);
           	gl.glBegin(GL2.GL_QUADS);
           		gl.glTexCoord2f(0f,2f); gl.glVertex3f( 50,  7, 80);
           		gl.glTexCoord2f(3f,2f); gl.glVertex3f(50,  20, 80);
      			gl.glTexCoord2f(3f,0f); gl.glVertex3f(54, 20, 80);
      			gl.glTexCoord2f(0f,0f); gl.glVertex3f( 54, 7, 80);
      		gl.glEnd();
            sidingTexture.bind(gl);
        	gl.glBegin(GL2.GL_QUADS);
        		gl.glTexCoord2f(0f,2f); gl.glVertex3f( 50,  7, 80);
         		gl.glTexCoord2f(3f,2f); gl.glVertex3f(54,  7, 80);
    			gl.glTexCoord2f(3f,0f); gl.glVertex3f(54, 20, 80);
    			gl.glTexCoord2f(0f,0f); gl.glVertex3f( 50, 20, 80);
    		gl.glEnd();

            wallTexture.bind(gl);
           	gl.glBegin(GL2.GL_QUADS);
           		gl.glTexCoord2f(0f,2f); gl.glVertex3f( 54,  0, 80);
           		gl.glTexCoord2f(3f,2f); gl.glVertex3f(54,  20, 80);
      			gl.glTexCoord2f(3f,0f); gl.glVertex3f(80, 20, 80);
      			gl.glTexCoord2f(0f,0f); gl.glVertex3f( 80, 0, 80);
      		gl.glEnd();  
            sidingTexture.bind(gl);
    		gl.glBegin(GL2.GL_QUADS);
    			gl.glTexCoord2f(0f,2f); gl.glVertex3f( 54,  0, 80);
         		gl.glTexCoord2f(3f,2f); gl.glVertex3f(80,  0, 80);
    			gl.glTexCoord2f(3f,0f); gl.glVertex3f(80, 20, 80);
    			gl.glTexCoord2f(0f,0f); gl.glVertex3f( 54, 20, 80);
    		gl.glEnd();
        gl.glDisable(GL2.GL_TEXTURE_2D);
    gl.glPopMatrix();
gl.glDisable(GL2.GL_CULL_FACE);
    
    
   
//draw table
gl.glPushMatrix();
	gl.glTranslatef(70, 0, 50);
	gl.glColor3f(1,1,0); // yellow
	gl.glRotatef(-90f, 1f, 0f, 0f); // stand upright (Y)
	glu.gluCylinder(quadric, .5, .5, 3., 10, 1);
gl.glPopMatrix();
gl.glPushMatrix();
	gl.glTranslatef(70, 0, 55); 
	gl.glColor3f(1,1,0); // yellow
	gl.glRotatef(-90f, 1f, 0f, 0f); // stand upright (Y)
	glu.gluCylinder(quadric, .5, .5, 3., 10, 1);
gl.glPopMatrix();	
gl.glPushMatrix();
	gl.glTranslatef(74, 0, 50);
	gl.glColor3f(1,1,0); // yellow
	gl.glRotatef(-90f, 1f, 0f, 0f); // stand upright (Y)
	glu.gluCylinder(quadric, .5, .5, 3., 10, 1);
gl.glPopMatrix();
gl.glPushMatrix();
	gl.glTranslatef(74, 0, 55); 
	gl.glColor3f(1,1,0); // yellow
	gl.glRotatef(-90f, 1f, 0f, 0f); // stand upright (Y)
	glu.gluCylinder(quadric, .5, .5, 3., 10, 1);
gl.glPopMatrix();
gl.glEnable(GL2.GL_TEXTURE_2D);
tableTexture.bind(gl);
gl.glPushMatrix();
	gl.glTranslatef(72, 3, 52); 
	//gl.glColor3f(1,1,0); // yellow
	gl.glRotatef(-90f, 0f, 0f, 0f); // stand upright (Y)
	glu.gluDisk(textureQuadric, 0, 5, 10, 1);
gl.glPopMatrix();
gl.glDisable(GL2.GL_TEXTURE_2D);


//draw poster on wall
gl.glEnable(GL2.GL_TEXTURE_2D);
posterTexture.bind(gl);
gl.glBegin(GL2.GL_QUADS);
    gl.glTexCoord2f(0f,0f); gl.glVertex3f( 21,  6, 30);
    gl.glTexCoord2f(0f,1f); gl.glVertex3f(21,  6, 34);
    gl.glTexCoord2f(1f,1f); gl.glVertex3f(21, 10, 34);
    gl.glTexCoord2f(1f,0f); gl.glVertex3f(21, 10, 30);
gl.glEnd();
gl.glDisable(GL2.GL_TEXTURE_2D);
	}
	
	
	
	
}
