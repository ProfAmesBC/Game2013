package buildings;
// William Ames Fall 2013  Texture Demo

import game.Building;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;

import com.jogamp.opengl.util.texture.Texture;

class PictureFrame {
    private GLUquadric quadric; // to control properties of quadric-based objects
    private GLUquadric sphereQuadric; // for Signorile's head
    private Texture frameTexture, photoTexture;  
    private double frameWidth, frameHeight;
    private Point3d start;
    private final double THICK=.2;

    public PictureFrame(GL2 gl, GLU glu, Point3d s) {
        quadric = glu.gluNewQuadric();
        glu.gluQuadricDrawStyle(quadric, GLU.GLU_FILL); // GLU_POINT, GLU_LINE, GLU_FILL, GLU_SILHOUETTE
        glu.gluQuadricNormals  (quadric, GLU.GLU_NONE); // GLU_NONE, GLU_FLAT, or GLU_SMOOTH
        glu.gluQuadricTexture  (quadric, false);        // use true to generate texture coordinates

        sphereQuadric = glu.gluNewQuadric();
        glu.gluQuadricDrawStyle(sphereQuadric, GLU.GLU_FILL);
        glu.gluQuadricNormals  (sphereQuadric, GLU.GLU_NONE);
        glu.gluQuadricTexture  (sphereQuadric, true); // for Signorile's head

        photoTexture     = Building.setupTexture(gl, "texturepicture.gif"); 

        frameHeight = 8;
        frameWidth = 11;
        start = new Point3d(s.getX(),s.getY(),s.getZ());
    }

    public void draw(GL2 gl, GLU glu) {

    	//portrait
    	
    	gl.glEnable(GL2.GL_TEXTURE_2D);
            photoTexture.bind(gl);
            gl.glBegin(GL2.GL_QUADS);
            gl.glTexCoord2f(0f,1f); gl.glVertex3d(start.getX(),start.getY(),start.getZ());
            gl.glTexCoord2f(1f,1f); gl.glVertex3d(start.getX()+frameWidth, start.getY(),start.getZ());
            gl.glTexCoord2f(1f,0f); gl.glVertex3d(start.getX()+frameWidth,start.getY()+frameHeight,start.getZ());
            gl.glTexCoord2f(0f,0f); gl.glVertex3d(start.getX(),start.getY()+frameHeight,start.getZ());
            gl.glEnd();
        gl.glDisable(GL2.GL_TEXTURE_2D);
        
        
    }
   }
