package buildings;
// William Ames Fall 2013  Texture Demo

import game.Building;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;

import com.jogamp.opengl.util.texture.Texture;

class Table {
    private GLUquadric quadric; // to control properties of quadric-based objects
    private GLUquadric sphereQuadric; // for Signorile's head
    private Texture tableTexture;   
    private final double LENGTH = 5;
    private final double WIDTH = 4;
    private final double THICK = .25;
    private final double LEGS = 3;
    

    public Table(GL2 gl, GLU glu, Point3d placement) {
        quadric = glu.gluNewQuadric();
        glu.gluQuadricDrawStyle(quadric, GLU.GLU_FILL); // GLU_POINT, GLU_LINE, GLU_FILL, GLU_SILHOUETTE
        glu.gluQuadricNormals  (quadric, GLU.GLU_NONE); // GLU_NONE, GLU_FLAT, or GLU_SMOOTH
        glu.gluQuadricTexture  (quadric, false);        // use true to generate texture coordinates

        sphereQuadric = glu.gluNewQuadric();
        glu.gluQuadricDrawStyle(sphereQuadric, GLU.GLU_FILL);
        glu.gluQuadricNormals  (sphereQuadric, GLU.GLU_NONE);
        glu.gluQuadricTexture  (sphereQuadric, true); // for Signorile's head


        tableTexture     = Building.setupTexture(gl, "texturetable.gif"); // png's don't seem to work any more
    }

    public void draw(GL2 gl, GLU glu) {
        // glu.gluSphere(quadric,  radius, slices, stacks)
        // glu.gluCylinder quadric, base, top, height, slices, stacks)
        // glu.gluDisk(quadric, inner radius, outer radius, slices, stacks)
    	
        //granite tabletop
        gl.glEnable(GL2.GL_TEXTURE_2D);
            tableTexture.bind(gl);
            gl.glBegin(GL2.GL_QUADS);
            gl.glTexCoord2f(0f,2f); gl.glVertex3d(0,  LEGS-.4, 0);
            gl.glTexCoord2f(3f,2f); gl.glVertex3d(LENGTH,  LEGS-.4, 0);
            gl.glTexCoord2f(3f,0f); gl.glVertex3d(LENGTH, LEGS-.4, -WIDTH);
            gl.glTexCoord2f(0f,0f); gl.glVertex3d(0, LEGS-.4, -WIDTH);
            gl.glEnd();
        gl.glDisable(GL2.GL_TEXTURE_2D);
        
        gl.glEnable(GL2.GL_TEXTURE_2D);
        tableTexture.bind(gl);
        gl.glBegin(GL2.GL_QUADS);
        gl.glTexCoord2f(0f,2f); gl.glVertex3d(0,  LEGS-THICK-.4, 0);
        gl.glTexCoord2f(3f,2f); gl.glVertex3d(LENGTH,  LEGS-.4-THICK, 0);
        gl.glTexCoord2f(3f,0f); gl.glVertex3d(LENGTH, LEGS-.4-THICK, -WIDTH);
        gl.glTexCoord2f(0f,0f); gl.glVertex3d(0, LEGS-THICK-.4, -WIDTH);
        gl.glEnd();
        gl.glDisable(GL2.GL_TEXTURE_2D);
        

       
        //tablesides
        gl.glEnable(GL2.GL_TEXTURE_2D);
        tableTexture.bind(gl);
        gl.glBegin(GL2.GL_QUADS);
        gl.glTexCoord2f(0f,2f); gl.glVertex3d(0,  LEGS-THICK-.4, 0);
        gl.glTexCoord2f(3f,2f); gl.glVertex3d(LENGTH,  LEGS-THICK-.4, 0);
        gl.glTexCoord2f(3f,0f); gl.glVertex3d(LENGTH, LEGS-.4, 0);
        gl.glTexCoord2f(0f,0f); gl.glVertex3d(0, LEGS-.4, 0);
        gl.glEnd();
        gl.glDisable(GL2.GL_TEXTURE_2D);
        
        
        gl.glEnable(GL2.GL_TEXTURE_2D);
        tableTexture.bind(gl);
        gl.glBegin(GL2.GL_QUADS);
        gl.glTexCoord2f(0f,2f); gl.glVertex3d(0,  LEGS-THICK-.4, -WIDTH);
        gl.glTexCoord2f(3f,2f); gl.glVertex3d(LENGTH,  LEGS-THICK-.4, -WIDTH);
        gl.glTexCoord2f(3f,0f); gl.glVertex3d(LENGTH, LEGS-.4, -WIDTH);
        gl.glTexCoord2f(0f,0f); gl.glVertex3d(0, LEGS-.4, -WIDTH);
        gl.glEnd();
        gl.glDisable(GL2.GL_TEXTURE_2D);

        gl.glEnable(GL2.GL_TEXTURE_2D);
        tableTexture.bind(gl);
        gl.glBegin(GL2.GL_QUADS);
        gl.glTexCoord2f(0f,2f); gl.glVertex3d(0,  LEGS-.4, 0);
        gl.glTexCoord2f(3f,2f); gl.glVertex3d(0,  LEGS-.4, -WIDTH);
        gl.glTexCoord2f(3f,0f); gl.glVertex3d(0, LEGS-THICK-.4, -WIDTH);
        gl.glTexCoord2f(0f,0f); gl.glVertex3d(0, LEGS-THICK-.4, 0);
        gl.glEnd();
        gl.glDisable(GL2.GL_TEXTURE_2D);

        
        gl.glEnable(GL2.GL_TEXTURE_2D);
        tableTexture.bind(gl);
        gl.glBegin(GL2.GL_QUADS);
        gl.glTexCoord2f(0f,2f); gl.glVertex3d(LENGTH,  LEGS-THICK-.4, 0);
        gl.glTexCoord2f(3f,2f); gl.glVertex3d(LENGTH,  LEGS-THICK-.4, -WIDTH);
        gl.glTexCoord2f(3f,0f); gl.glVertex3d(LENGTH, LEGS-.4, -WIDTH);
        gl.glTexCoord2f(0f,0f); gl.glVertex3d(LENGTH, LEGS-.4, 0);
        gl.glEnd();
        gl.glDisable(GL2.GL_TEXTURE_2D);
        
        

        //legs
        gl.glPushMatrix();
            gl.glRotatef(-90f, 1f, 0f, 0f);
            gl.glColor3d(.2,.2,.2);
        	gl.glTranslated(.2*LENGTH, .2*WIDTH, -1.75*THICK);
            glu.gluCylinder(quadric, .1, .1, LEGS, 10, 10);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glRotatef(-90f, 1f, 0f, 0f); 
        gl.glColor3d(.2,.2,.2);
        gl.glTranslated(.8*LENGTH, .2*WIDTH, -1.75*THICK);
        glu.gluCylinder(quadric, .1, .1, LEGS, 10, 10);
        gl.glPopMatrix();

        
        gl.glPushMatrix();
        gl.glRotatef(-90f, 1f, 0f, 0f); 
        gl.glColor3d(.2,.2,.2);
        gl.glTranslated(.8*LENGTH, .8*WIDTH, -1.75*THICK);
        glu.gluCylinder(quadric, .1, .1, LEGS, 10, 10);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glRotatef(-90f, 1f, 0f, 0f); 
        gl.glColor3d(.2,.2,.2);
        gl.glTranslated(.2*LENGTH, .8*WIDTH, -1.75*THICK);
        glu.gluCylinder(quadric, .1, .1, LEGS, 10, 10);
        gl.glPopMatrix();
    }
   }
