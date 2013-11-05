package buildings;
// William Ames Fall 2013  Texture Demo

import game.Building;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;

import com.jogamp.opengl.util.texture.Texture;

class Chair {
    private GLUquadric quadric; // to control properties of quadric-based objects
    private GLUquadric sphereQuadric; // for Signorile's head
    private Texture chairTexture;   
    private final double LENGTH = 1.2;
    private final double WIDTH = 1.2;
    private final double THICK = .1;
    private final double LEGS = 1.7;
    

    public Chair(GL2 gl, GLU glu, Point3d placement) {
        quadric = glu.gluNewQuadric();
        glu.gluQuadricDrawStyle(quadric, GLU.GLU_FILL); // GLU_POINT, GLU_LINE, GLU_FILL, GLU_SILHOUETTE
        glu.gluQuadricNormals  (quadric, GLU.GLU_NONE); // GLU_NONE, GLU_FLAT, or GLU_SMOOTH
        glu.gluQuadricTexture  (quadric, false);        // use true to generate texture coordinates

        sphereQuadric = glu.gluNewQuadric();
        glu.gluQuadricDrawStyle(sphereQuadric, GLU.GLU_FILL);
        glu.gluQuadricNormals  (sphereQuadric, GLU.GLU_NONE);
        glu.gluQuadricTexture  (sphereQuadric, true); // for Signorile's head

        chairTexture     = Building.setupTexture(gl, "texturechair.gif"); // png's don't seem to work any more
    }

    public void draw(GL2 gl, GLU glu) {
        // glu.gluSphere(quadric,  radius, slices, stacks)
        // glu.gluCylinder quadric, base, top, height, slices, stacks)
        // glu.gluDisk(quadric, inner radius, outer radius, slices, stacks)

        gl.glEnable(GL2.GL_TEXTURE_2D);
            chairTexture.bind(gl);
            gl.glBegin(GL2.GL_QUADS);
            gl.glTexCoord2f(0f,2f); gl.glVertex3d(0,  LEGS-.1, 0);
            gl.glTexCoord2f(3f,2f); gl.glVertex3d(LENGTH,  LEGS-.1, 0);
            gl.glTexCoord2f(3f,0f); gl.glVertex3d(LENGTH, LEGS-.1, -WIDTH);
            gl.glTexCoord2f(0f,0f); gl.glVertex3d(0, LEGS-.1, -WIDTH);
            gl.glEnd();
        gl.glDisable(GL2.GL_TEXTURE_2D);
        
        gl.glEnable(GL2.GL_TEXTURE_2D);
        chairTexture.bind(gl);
        gl.glBegin(GL2.GL_QUADS);
        gl.glTexCoord2f(0f,2f); gl.glVertex3d(0,  LEGS-THICK-.1, 0);
        gl.glTexCoord2f(3f,2f); gl.glVertex3d(LENGTH,  LEGS-.1-THICK, 0);
        gl.glTexCoord2f(3f,0f); gl.glVertex3d(LENGTH, LEGS-.1-THICK, -WIDTH);
        gl.glTexCoord2f(0f,0f); gl.glVertex3d(0, LEGS-THICK-.1, -WIDTH);
        gl.glEnd();
        gl.glDisable(GL2.GL_TEXTURE_2D);
        

       
        //Chairsides
        gl.glEnable(GL2.GL_TEXTURE_2D);
        chairTexture.bind(gl);
        gl.glBegin(GL2.GL_QUADS);
        gl.glTexCoord2f(0f,2f); gl.glVertex3d(0,  LEGS-THICK-.1, 0);
        gl.glTexCoord2f(3f,2f); gl.glVertex3d(LENGTH,  LEGS-THICK-.1, 0);
        gl.glTexCoord2f(3f,0f); gl.glVertex3d(LENGTH, LEGS-.1, 0);
        gl.glTexCoord2f(0f,0f); gl.glVertex3d(0, LEGS-.1, 0);
        gl.glEnd();
        gl.glDisable(GL2.GL_TEXTURE_2D);
        
        
        gl.glEnable(GL2.GL_TEXTURE_2D);
        chairTexture.bind(gl);
        gl.glBegin(GL2.GL_QUADS);
        gl.glTexCoord2f(0f,2f); gl.glVertex3d(0,  LEGS-THICK-.1, -WIDTH);
        gl.glTexCoord2f(3f,2f); gl.glVertex3d(LENGTH,  LEGS-THICK-.1, -WIDTH);
        gl.glTexCoord2f(3f,0f); gl.glVertex3d(LENGTH, LEGS-.1, -WIDTH);
        gl.glTexCoord2f(0f,0f); gl.glVertex3d(0, LEGS-.1, -WIDTH);
        gl.glEnd();
        gl.glDisable(GL2.GL_TEXTURE_2D);

        gl.glEnable(GL2.GL_TEXTURE_2D);
        chairTexture.bind(gl);
        gl.glBegin(GL2.GL_QUADS);
        gl.glTexCoord2f(0f,2f); gl.glVertex3d(0,  LEGS-.1, 0);
        gl.glTexCoord2f(3f,2f); gl.glVertex3d(0,  LEGS-.1, -WIDTH);
        gl.glTexCoord2f(3f,0f); gl.glVertex3d(0, LEGS-THICK-.1, -WIDTH);
        gl.glTexCoord2f(0f,0f); gl.glVertex3d(0, LEGS-THICK-.1, 0);
        gl.glEnd();
        gl.glDisable(GL2.GL_TEXTURE_2D);

        
        gl.glEnable(GL2.GL_TEXTURE_2D);
        chairTexture.bind(gl);
        gl.glBegin(GL2.GL_QUADS);
        gl.glTexCoord2f(0f,2f); gl.glVertex3d(LENGTH,  LEGS-THICK-.1, 0);
        gl.glTexCoord2f(3f,2f); gl.glVertex3d(LENGTH,  LEGS-THICK-.1, -WIDTH);
        gl.glTexCoord2f(3f,0f); gl.glVertex3d(LENGTH, LEGS-.1, -WIDTH);
        gl.glTexCoord2f(0f,0f); gl.glVertex3d(LENGTH, LEGS-.1, 0);
        gl.glEnd();
        gl.glDisable(GL2.GL_TEXTURE_2D);
        
        
 
        //legs

        gl.glEnable(GL2.GL_TEXTURE_2D);
        chairTexture.bind(gl);
        gl.glPushMatrix();
       		gl.glRotatef(-90f, 1f, 0f, 0f); // stand upright (Y)

    		gl.glTranslated(.1*LENGTH, .1*WIDTH, -1.75*THICK);
            glu.gluCylinder(sphereQuadric, .1, .1, LEGS, 3, 3);
        gl.glPopMatrix();
        gl.glDisable(GL2.GL_TEXTURE_2D);
        
        gl.glEnable(GL2.GL_TEXTURE_2D);
        chairTexture.bind(gl);
        gl.glPushMatrix();     
        	gl.glRotatef(-90f, 1f, 0f, 0f); // stand upright (Y)

        	gl.glTranslated(.9*LENGTH, .1*WIDTH, -1.75*THICK);
            glu.gluCylinder(sphereQuadric, .1, .1, LEGS, 3, 3);
        gl.glPopMatrix();
        gl.glDisable(GL2.GL_TEXTURE_2D);
        
        gl.glEnable(GL2.GL_TEXTURE_2D);
        chairTexture.bind(gl);
        gl.glPushMatrix();
        gl.glRotatef(-90f, 1f, 0f, 0f); // stand upright (Y)
        	gl.glTranslated(.9*LENGTH, .9*WIDTH, -1.75*THICK);
            
            glu.gluCylinder(sphereQuadric, .1, .1, 2*LEGS, 3, 3);
        gl.glPopMatrix();
        gl.glDisable(GL2.GL_TEXTURE_2D);
        
        gl.glEnable(GL2.GL_TEXTURE_2D);
        chairTexture.bind(gl);
        gl.glPushMatrix();
        	gl.glRotatef(-90f, 1f, 0f, 0f); // stand upright (Y)

        	gl.glTranslated(.1*LENGTH, .9*WIDTH, -1.75*THICK);
            glu.gluCylinder(sphereQuadric, .1, .1, 2*LEGS, 3, 3);
        gl.glPopMatrix();
        gl.glDisable(GL2.GL_TEXTURE_2D);
        
        //backrest
        gl.glPushMatrix();
        gl.glScaled(1,1.3,.7);
        gl.glRotatef(90,1,0,0);
        gl.glTranslated(0,-2.53*WIDTH,-LEGS);
        
        gl.glEnable(GL2.GL_TEXTURE_2D);
        chairTexture.bind(gl);
        gl.glBegin(GL2.GL_QUADS);
        gl.glTexCoord2f(0f,2f); gl.glVertex3d(0,  LEGS-.1, 0);
        gl.glTexCoord2f(3f,2f); gl.glVertex3d(LENGTH,  LEGS-.1, 0);
        gl.glTexCoord2f(3f,0f); gl.glVertex3d(LENGTH, LEGS-.1, -WIDTH);
        gl.glTexCoord2f(0f,0f); gl.glVertex3d(0, LEGS-.1, -WIDTH);
        gl.glEnd();
        gl.glDisable(GL2.GL_TEXTURE_2D);

        gl.glEnable(GL2.GL_TEXTURE_2D);
        chairTexture.bind(gl);
        gl.glBegin(GL2.GL_QUADS);
        gl.glTexCoord2f(0f,2f); gl.glVertex3d(0,  LEGS-THICK-.1, 0);
        gl.glTexCoord2f(3f,2f); gl.glVertex3d(LENGTH,  LEGS-.1-THICK, 0);
        gl.glTexCoord2f(3f,0f); gl.glVertex3d(LENGTH, LEGS-.1-THICK, -WIDTH);
        gl.glTexCoord2f(0f,0f); gl.glVertex3d(0, LEGS-THICK-.1, -WIDTH);
        gl.glEnd();
        gl.glDisable(GL2.GL_TEXTURE_2D);
        
        gl.glEnable(GL2.GL_TEXTURE_2D);
        chairTexture.bind(gl);
        gl.glBegin(GL2.GL_QUADS);
        gl.glTexCoord2f(0f,2f); gl.glVertex3d(0,  LEGS-THICK-.1, 0);
        gl.glTexCoord2f(3f,2f); gl.glVertex3d(LENGTH,  LEGS-THICK-.1, 0);
        gl.glTexCoord2f(3f,0f); gl.glVertex3d(LENGTH, LEGS-.1, 0);
        gl.glTexCoord2f(0f,0f); gl.glVertex3d(0, LEGS-.1, 0);
        gl.glEnd();
        gl.glDisable(GL2.GL_TEXTURE_2D);
        
        
        gl.glEnable(GL2.GL_TEXTURE_2D);
        chairTexture.bind(gl);
        gl.glBegin(GL2.GL_QUADS);
        gl.glTexCoord2f(0f,2f); gl.glVertex3d(0,  LEGS-THICK-.1, -WIDTH);
        gl.glTexCoord2f(3f,2f); gl.glVertex3d(LENGTH,  LEGS-THICK-.1, -WIDTH);
        gl.glTexCoord2f(3f,0f); gl.glVertex3d(LENGTH, LEGS-.1, -WIDTH);
        gl.glTexCoord2f(0f,0f); gl.glVertex3d(0, LEGS-.1, -WIDTH);
        gl.glEnd();
        gl.glDisable(GL2.GL_TEXTURE_2D);

        gl.glEnable(GL2.GL_TEXTURE_2D);
        chairTexture.bind(gl);
        gl.glBegin(GL2.GL_QUADS);
        gl.glTexCoord2f(0f,2f); gl.glVertex3d(0,  LEGS-.1, 0);
        gl.glTexCoord2f(3f,2f); gl.glVertex3d(0,  LEGS-.1, -WIDTH);
        gl.glTexCoord2f(3f,0f); gl.glVertex3d(0, LEGS-THICK-.1, -WIDTH);
        gl.glTexCoord2f(0f,0f); gl.glVertex3d(0, LEGS-THICK-.1, 0);
        gl.glEnd();
        gl.glDisable(GL2.GL_TEXTURE_2D);

        
        gl.glEnable(GL2.GL_TEXTURE_2D);
        chairTexture.bind(gl);
        gl.glBegin(GL2.GL_QUADS);
        gl.glTexCoord2f(0f,2f); gl.glVertex3d(LENGTH,  LEGS-THICK-.1, 0);
        gl.glTexCoord2f(3f,2f); gl.glVertex3d(LENGTH,  LEGS-THICK-.1, -WIDTH);
        gl.glTexCoord2f(3f,0f); gl.glVertex3d(LENGTH, LEGS-.1, -WIDTH);
        gl.glTexCoord2f(0f,0f); gl.glVertex3d(LENGTH, LEGS-.1, 0);
        gl.glEnd();
        gl.glDisable(GL2.GL_TEXTURE_2D);
        gl.glPopMatrix();
        
    }
   }
