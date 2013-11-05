package buildings;
// William Ames Fall 2013  Texture Demo

import game.Building;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;

import com.jogamp.opengl.util.texture.Texture;

public class MendolaBuilding extends Building {
    private GLUquadric quadric; // to control properties of quadric-based objects
    private Texture brownTexture;    
    private Texture greenTexture;
    private Texture grayTexture;
    private Texture metalTexture;

    public MendolaBuilding(GL2 gl, GLU glu) {
        quadric = glu.gluNewQuadric();
        glu.gluQuadricDrawStyle(quadric, GLU.GLU_FILL); // GLU_POINT, GLU_LINE, GLU_FILL, GLU_SILHOUETTE
        glu.gluQuadricNormals  (quadric, GLU.GLU_NONE); // GLU_NONE, GLU_FLAT, or GLU_SMOOTH
        glu.gluQuadricTexture  (quadric, false);        // use true to generate texture coordinates

        brownTexture     = setupTexture(gl, "mendolaBrown.jpg"); // png's don't seem to work any more
        greenTexture     = setupTexture(gl, "mendolaGreen.jpg"); 
        grayTexture     = setupTexture(gl, "mendolaGray.gif");
        metalTexture     = setupTexture(gl, "mendolaMetal.jpg");
    }


    public void draw(GL2 gl, GLU glu) {

    	
        // Oil Drum
        gl.glColor3f(.2f, .2f, .2f);
        gl.glPushMatrix();
            gl.glRotatef(-90f, 1f, 0f, 0f); // stand upright (Y)
            gl.glTranslatef(55f, -30f, 0f);
            glu.gluCylinder(quadric, 1., 1., 5., 10, 10);
        gl.glPopMatrix();
        
        // Oil Drum 2
        gl.glColor3f(.2f, .2f, .2f);
        gl.glPushMatrix();
            gl.glRotatef(-90f, 1f, 0f, 0f); // stand upright (Y)
            gl.glTranslatef(55f, -40f, 0f);
            glu.gluCylinder(quadric, 1., 1., 5., 10, 10);
        gl.glPopMatrix();
        
        // Plane Body
        gl.glColor3f(.8f, 0, .1f);
        gl.glPushMatrix();
            gl.glTranslatef(40f, 10f, 50f);
            glu.gluCylinder(quadric, .5, 5., 15., 10, 10);
        gl.glPopMatrix();
        
        // Wings
        gl.glEnable(GL2.GL_TEXTURE_2D);
        grayTexture.bind(gl);
        gl.glEnable(GL2.GL_TEXTURE_GEN_S);
        gl.glEnable(GL2.GL_TEXTURE_GEN_T);
            gl.glTexGeni(GL2.GL_S, GL2.GL_TEXTURE_GEN_MODE, GL2.GL_OBJECT_LINEAR);
            gl.glTexGeni(GL2.GL_T, GL2.GL_TEXTURE_GEN_MODE, GL2.GL_OBJECT_LINEAR);
            float[] coef_sW = {.8f,0,0,0};
            gl.glTexGenfv(GL2.GL_S, GL2.GL_OBJECT_PLANE, coef_sW, 0);
            float[] coef_tW = {0,0,.7f,0};
            gl.glTexGenfv(GL2.GL_T, GL2.GL_OBJECT_PLANE, coef_tW, 0);
            gl.glBegin(GL2.GL_QUADS);
                gl.glVertex3f(50, 10, 50);
                gl.glVertex3f(30, 10, 50);
                gl.glVertex3f(30, 10, 60);
                gl.glVertex3f(50, 10, 60);
            gl.glEnd();
        gl.glDisable(GL2.GL_TEXTURE_2D);
        gl.glDisable(GL2.GL_TEXTURE_GEN_S);
        gl.glDisable(GL2.GL_TEXTURE_GEN_T);
            
	      // Wings
	      gl.glEnable(GL2.GL_TEXTURE_2D);
	      grayTexture.bind(gl);
	      gl.glEnable(GL2.GL_TEXTURE_GEN_S);
	      gl.glEnable(GL2.GL_TEXTURE_GEN_T);
	          gl.glTexGeni(GL2.GL_S, GL2.GL_TEXTURE_GEN_MODE, GL2.GL_OBJECT_LINEAR);
	          gl.glTexGeni(GL2.GL_T, GL2.GL_TEXTURE_GEN_MODE, GL2.GL_OBJECT_LINEAR);
	          gl.glTexGenfv(GL2.GL_S, GL2.GL_OBJECT_PLANE, coef_sW, 0);
	          gl.glTexGenfv(GL2.GL_T, GL2.GL_OBJECT_PLANE, coef_tW, 0);
	          gl.glBegin(GL2.GL_QUADS);
	              gl.glVertex3f(50, 6, 50);
	              gl.glVertex3f(30, 6, 50);
	              gl.glVertex3f(30, 6, 60);
	              gl.glVertex3f(50, 6, 60);
	          gl.glEnd();
            

        // flat land
        gl.glEnable(GL2.GL_TEXTURE_2D);
        greenTexture.bind(gl);
        gl.glEnable(GL2.GL_TEXTURE_GEN_S);
        gl.glEnable(GL2.GL_TEXTURE_GEN_T);
            gl.glTexGeni(GL2.GL_S, GL2.GL_TEXTURE_GEN_MODE, GL2.GL_OBJECT_LINEAR);
            gl.glTexGeni(GL2.GL_T, GL2.GL_TEXTURE_GEN_MODE, GL2.GL_OBJECT_LINEAR);
            float[] coef_s = {.5f,0,0,0};
            gl.glTexGenfv(GL2.GL_S, GL2.GL_OBJECT_PLANE, coef_s, 0);
            float[] coef_t = {0,0,.25f,0};
            gl.glTexGenfv(GL2.GL_T, GL2.GL_OBJECT_PLANE, coef_t, 0);
            gl.glBegin(GL2.GL_QUADS);
                gl.glVertex3f(0, 0, 0);
                gl.glVertex3f(100, 0, 0);
                gl.glVertex3f(100, 0, 100);
                gl.glVertex3f(0, 0, 100);
            gl.glEnd();
        gl.glDisable(GL2.GL_TEXTURE_2D);
        gl.glDisable(GL2.GL_TEXTURE_GEN_S);
        gl.glDisable(GL2.GL_TEXTURE_GEN_T);
        

        // Side Wall Right
        gl.glEnable(GL2.GL_CULL_FACE);
        gl.glPushMatrix();
           // gl.glRotatef(frames*2, 0,1,0);
            gl.glEnable(GL2.GL_TEXTURE_2D);
                brownTexture.bind(gl);
                gl.glBegin(GL2.GL_QUADS);
                    // ccw as viewed from front
	                gl.glTexCoord2f(0f,5f); gl.glVertex3f(20, 0, 20);
	                gl.glTexCoord2f(2f,5f); gl.glVertex3f(20, 0, 70);
	                gl.glTexCoord2f(2f,0f); gl.glVertex3f(20, 30, 70);
	                gl.glTexCoord2f(0f,0f); gl.glVertex3f(20, 30, 20);
                gl.glEnd();
                metalTexture.bind(gl);
                gl.glBegin(GL2.GL_QUADS);
                    // cw as viewed from front, so can be seen as ccw from back
	                gl.glTexCoord2f(0f,5f); gl.glVertex3f(20, 0, 20);
	                gl.glTexCoord2f(2f,5f); gl.glVertex3f(20, 30, 20);
	                gl.glTexCoord2f(2f,0f); gl.glVertex3f(20, 30, 70);
	                gl.glTexCoord2f(0f,0f); gl.glVertex3f(20, 0, 70);
                gl.glEnd();
            gl.glDisable(GL2.GL_TEXTURE_2D);
        gl.glPopMatrix();
        gl.glDisable(GL2.GL_CULL_FACE);
          
        
        // Side Wall Left
        gl.glEnable(GL2.GL_CULL_FACE);
        gl.glPushMatrix();
           // gl.glRotatef(frames*2, 0,1,0);
            gl.glEnable(GL2.GL_TEXTURE_2D);
                metalTexture.bind(gl);
                gl.glBegin(GL2.GL_QUADS);
                    // ccw as viewed from front
	                gl.glTexCoord2f(0f,0f); gl.glVertex3f(60, 0, 20);
	                gl.glTexCoord2f(5f,0f); gl.glVertex3f(60, 0, 70);
	                gl.glTexCoord2f(5f,2f); gl.glVertex3f(60, 30, 70);
	                gl.glTexCoord2f(0f,2f); gl.glVertex3f(60, 30, 20);
                gl.glEnd();
                brownTexture.bind(gl);
                gl.glBegin(GL2.GL_QUADS);
                    // cw as viewed from front, so can be seen as ccw from back
	                gl.glTexCoord2f(0f,5f); gl.glVertex3f(60, 0, 70);
	                gl.glTexCoord2f(2f,5f); gl.glVertex3f(60, 0, 20);
	                gl.glTexCoord2f(2f,0f); gl.glVertex3f(60, 30, 20);
	                gl.glTexCoord2f(0f,0f); gl.glVertex3f(60, 30, 70);
                gl.glEnd();
            gl.glDisable(GL2.GL_TEXTURE_2D);
        gl.glPopMatrix();
        gl.glDisable(GL2.GL_CULL_FACE);
        
        
        //Roof 1
        gl.glEnable(GL2.GL_TEXTURE_2D);
        grayTexture.bind(gl);
        gl.glEnable(GL2.GL_TEXTURE_GEN_S);
        gl.glEnable(GL2.GL_TEXTURE_GEN_T);
            gl.glTexGeni(GL2.GL_S, GL2.GL_TEXTURE_GEN_MODE, GL2.GL_OBJECT_LINEAR);
            gl.glTexGeni(GL2.GL_T, GL2.GL_TEXTURE_GEN_MODE, GL2.GL_OBJECT_LINEAR);
            //float[] coef_s = {.5f,0,0,0};
            gl.glTexGenfv(GL2.GL_S, GL2.GL_OBJECT_PLANE, coef_s, 0);
            //float[] coef_t = {0,.25f,0,0};
            gl.glTexGenfv(GL2.GL_T, GL2.GL_OBJECT_PLANE, coef_t, 0);
            gl.glBegin(GL2.GL_QUADS);
                gl.glVertex3f(50, 35, 20);
                gl.glVertex3f(60, 30, 20);
                gl.glVertex3f(60, 30, 70);
                gl.glVertex3f(50, 35, 70);
            gl.glEnd();
        gl.glDisable(GL2.GL_TEXTURE_2D);
        gl.glDisable(GL2.GL_TEXTURE_GEN_S);
        gl.glDisable(GL2.GL_TEXTURE_GEN_T);
        
      //Roof 2
      gl.glEnable(GL2.GL_TEXTURE_2D);
      grayTexture.bind(gl);
      gl.glEnable(GL2.GL_TEXTURE_GEN_S);
      gl.glEnable(GL2.GL_TEXTURE_GEN_T);
          gl.glTexGeni(GL2.GL_S, GL2.GL_TEXTURE_GEN_MODE, GL2.GL_OBJECT_LINEAR);
          gl.glTexGeni(GL2.GL_T, GL2.GL_TEXTURE_GEN_MODE, GL2.GL_OBJECT_LINEAR);
          //float[] coef_s = {.5f,0,0,0};
          gl.glTexGenfv(GL2.GL_S, GL2.GL_OBJECT_PLANE, coef_s, 0);
          //float[] coef_t = {0,.25f,0,0};
          gl.glTexGenfv(GL2.GL_T, GL2.GL_OBJECT_PLANE, coef_t, 0);
          gl.glBegin(GL2.GL_QUADS);
              gl.glVertex3f(20, 30, 20);
              gl.glVertex3f(30, 35, 20);
              gl.glVertex3f(30, 35, 70);
              gl.glVertex3f(20, 30, 70);
          gl.glEnd();
      gl.glDisable(GL2.GL_TEXTURE_2D);
      gl.glDisable(GL2.GL_TEXTURE_GEN_S);
      gl.glDisable(GL2.GL_TEXTURE_GEN_T);
      
      
      //Roof 3
      gl.glEnable(GL2.GL_TEXTURE_2D);
      grayTexture.bind(gl);
      gl.glEnable(GL2.GL_TEXTURE_GEN_S);
      gl.glEnable(GL2.GL_TEXTURE_GEN_T);
          gl.glTexGeni(GL2.GL_S, GL2.GL_TEXTURE_GEN_MODE, GL2.GL_OBJECT_LINEAR);
          gl.glTexGeni(GL2.GL_T, GL2.GL_TEXTURE_GEN_MODE, GL2.GL_OBJECT_LINEAR);
          //float[] coef_s = {.5f,0,0,0};
          gl.glTexGenfv(GL2.GL_S, GL2.GL_OBJECT_PLANE, coef_s, 0);
          //float[] coef_t = {0,.25f,0,0};
          gl.glTexGenfv(GL2.GL_T, GL2.GL_OBJECT_PLANE, coef_t, 0);
          gl.glBegin(GL2.GL_QUADS);
              gl.glVertex3f(50, 35, 20);
              gl.glVertex3f(30, 35, 20);
              gl.glVertex3f(30, 35, 70);
              gl.glVertex3f(50, 35, 70);
          gl.glEnd();
      gl.glDisable(GL2.GL_TEXTURE_2D);
      gl.glDisable(GL2.GL_TEXTURE_GEN_S);
      gl.glDisable(GL2.GL_TEXTURE_GEN_T);
      
        
        
        
        //Front wall left
        gl.glEnable(GL2.GL_TEXTURE_2D);
        brownTexture.bind(gl);
        gl.glEnable(GL2.GL_TEXTURE_GEN_S);
        gl.glEnable(GL2.GL_TEXTURE_GEN_T);
            gl.glTexGeni(GL2.GL_S, GL2.GL_TEXTURE_GEN_MODE, GL2.GL_OBJECT_LINEAR);
            gl.glTexGeni(GL2.GL_T, GL2.GL_TEXTURE_GEN_MODE, GL2.GL_OBJECT_LINEAR);
            float[] coef_sF = {.5f,0,0,0};
            gl.glTexGenfv(GL2.GL_S, GL2.GL_OBJECT_PLANE, coef_sF, 0);
            float[] coef_tF = {0,.25f,0,0};
            gl.glTexGenfv(GL2.GL_T, GL2.GL_OBJECT_PLANE, coef_tF, 0);
            gl.glBegin(GL2.GL_QUADS);
                gl.glVertex3f(20, 0, 20);
                gl.glVertex3f(30, 0, 20);
                gl.glVertex3f(30, 30, 20);
                gl.glVertex3f(20, 30, 20);
            gl.glEnd();
        gl.glDisable(GL2.GL_TEXTURE_2D);
        gl.glDisable(GL2.GL_TEXTURE_GEN_S);
        gl.glDisable(GL2.GL_TEXTURE_GEN_T);
        
        
        //Front wall right
        gl.glEnable(GL2.GL_TEXTURE_2D);
        brownTexture.bind(gl);
        gl.glEnable(GL2.GL_TEXTURE_GEN_S);
        gl.glEnable(GL2.GL_TEXTURE_GEN_T);
            gl.glTexGeni(GL2.GL_S, GL2.GL_TEXTURE_GEN_MODE, GL2.GL_OBJECT_LINEAR);
            gl.glTexGeni(GL2.GL_T, GL2.GL_TEXTURE_GEN_MODE, GL2.GL_OBJECT_LINEAR);
            //float[] coef_s = {.5f,0,0,0};
            gl.glTexGenfv(GL2.GL_S, GL2.GL_OBJECT_PLANE, coef_sF, 0);
            //float[] coef_t = {0,.25f,0,0};
            gl.glTexGenfv(GL2.GL_T, GL2.GL_OBJECT_PLANE, coef_tF, 0);
            gl.glBegin(GL2.GL_QUADS);
                gl.glVertex3f(50, 0, 20);
                gl.glVertex3f(60, 0, 20);
                gl.glVertex3f(60, 30, 20);
                gl.glVertex3f(50, 30, 20);
            gl.glEnd();
        gl.glDisable(GL2.GL_TEXTURE_2D);
        gl.glDisable(GL2.GL_TEXTURE_GEN_S);
        gl.glDisable(GL2.GL_TEXTURE_GEN_T);
        
        
        //Front wall top
        gl.glEnable(GL2.GL_TEXTURE_2D);
        brownTexture.bind(gl);
        gl.glEnable(GL2.GL_TEXTURE_GEN_S);
        gl.glEnable(GL2.GL_TEXTURE_GEN_T);
            gl.glTexGeni(GL2.GL_S, GL2.GL_TEXTURE_GEN_MODE, GL2.GL_OBJECT_LINEAR);
            gl.glTexGeni(GL2.GL_T, GL2.GL_TEXTURE_GEN_MODE, GL2.GL_OBJECT_LINEAR);
            //float[] coef_s = {.5f,0,0,0};
            gl.glTexGenfv(GL2.GL_S, GL2.GL_OBJECT_PLANE, coef_sF, 0);
            //float[] coef_t = {0,.25f,0,0};
            gl.glTexGenfv(GL2.GL_T, GL2.GL_OBJECT_PLANE, coef_tF, 0);
            gl.glBegin(GL2.GL_QUADS);
                gl.glVertex3f(30, 10, 20);
                gl.glVertex3f(50, 10, 20);
                gl.glVertex3f(50, 30, 20);
                gl.glVertex3f(30, 30, 20);
            gl.glEnd();
        gl.glDisable(GL2.GL_TEXTURE_2D);
        gl.glDisable(GL2.GL_TEXTURE_GEN_S);
        gl.glDisable(GL2.GL_TEXTURE_GEN_T);
        
        
        //Back wall left
        gl.glEnable(GL2.GL_TEXTURE_2D);
        brownTexture.bind(gl);
        gl.glEnable(GL2.GL_TEXTURE_GEN_S);
        gl.glEnable(GL2.GL_TEXTURE_GEN_T);
            gl.glTexGeni(GL2.GL_S, GL2.GL_TEXTURE_GEN_MODE, GL2.GL_OBJECT_LINEAR);
            gl.glTexGeni(GL2.GL_T, GL2.GL_TEXTURE_GEN_MODE, GL2.GL_OBJECT_LINEAR);
            //float[] coef_sF = {.5f,0,0,0};
            gl.glTexGenfv(GL2.GL_S, GL2.GL_OBJECT_PLANE, coef_sF, 0);
            //float[] coef_tF = {0,.25f,0,0};
            gl.glTexGenfv(GL2.GL_T, GL2.GL_OBJECT_PLANE, coef_tF, 0);
            gl.glBegin(GL2.GL_QUADS);
                gl.glVertex3f(20, 0, 70);
                gl.glVertex3f(30, 0, 70);
                gl.glVertex3f(30, 30, 70);
                gl.glVertex3f(20, 30, 70);
            gl.glEnd();
        gl.glDisable(GL2.GL_TEXTURE_2D);
        gl.glDisable(GL2.GL_TEXTURE_GEN_S);
        gl.glDisable(GL2.GL_TEXTURE_GEN_T);
        
        
        //Back wall right
        gl.glEnable(GL2.GL_TEXTURE_2D);
        brownTexture.bind(gl);
        gl.glEnable(GL2.GL_TEXTURE_GEN_S);
        gl.glEnable(GL2.GL_TEXTURE_GEN_T);
            gl.glTexGeni(GL2.GL_S, GL2.GL_TEXTURE_GEN_MODE, GL2.GL_OBJECT_LINEAR);
            gl.glTexGeni(GL2.GL_T, GL2.GL_TEXTURE_GEN_MODE, GL2.GL_OBJECT_LINEAR);
            //float[] coef_s = {.5f,0,0,0};
            gl.glTexGenfv(GL2.GL_S, GL2.GL_OBJECT_PLANE, coef_sF, 0);
            //float[] coef_t = {0,.25f,0,0};
            gl.glTexGenfv(GL2.GL_T, GL2.GL_OBJECT_PLANE, coef_tF, 0);
            gl.glBegin(GL2.GL_QUADS);
                gl.glVertex3f(50, 0, 70);
                gl.glVertex3f(60, 0, 70);
                gl.glVertex3f(60, 30, 70);
                gl.glVertex3f(50, 30, 70);
            gl.glEnd();
        gl.glDisable(GL2.GL_TEXTURE_2D);
        gl.glDisable(GL2.GL_TEXTURE_GEN_S);
        gl.glDisable(GL2.GL_TEXTURE_GEN_T);
        
        
        //Back wall top
        gl.glEnable(GL2.GL_TEXTURE_2D);
        brownTexture.bind(gl);
        gl.glEnable(GL2.GL_TEXTURE_GEN_S);
        gl.glEnable(GL2.GL_TEXTURE_GEN_T);
            gl.glTexGeni(GL2.GL_S, GL2.GL_TEXTURE_GEN_MODE, GL2.GL_OBJECT_LINEAR);
            gl.glTexGeni(GL2.GL_T, GL2.GL_TEXTURE_GEN_MODE, GL2.GL_OBJECT_LINEAR);
            //float[] coef_s = {.5f,0,0,0};
            gl.glTexGenfv(GL2.GL_S, GL2.GL_OBJECT_PLANE, coef_sF, 0);
            //float[] coef_t = {0,.25f,0,0};
            gl.glTexGenfv(GL2.GL_T, GL2.GL_OBJECT_PLANE, coef_tF, 0);
            gl.glBegin(GL2.GL_QUADS);
                gl.glVertex3f(30, 10, 70);
                gl.glVertex3f(50, 10, 70);
                gl.glVertex3f(50, 30, 70);
                gl.glVertex3f(30, 30, 70);
            gl.glEnd();
        gl.glDisable(GL2.GL_TEXTURE_2D);
        gl.glDisable(GL2.GL_TEXTURE_GEN_S);
        gl.glDisable(GL2.GL_TEXTURE_GEN_T);
        
        
        
   }
}