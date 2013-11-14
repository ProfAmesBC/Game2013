package buildings;

/*
 * Diana Tran
 * Computer Graphics
 * Homework 5: Game Scene
 * November 1, 2013
 */

import game.Building;
import javax.media.opengl.GL2;
import javax.media.opengl.glu.*;
import com.jogamp.opengl.util.texture.Texture;

public class TranBuilding extends Building {
    private GLUquadric quadric; // to control properties of quadric-based objects here
    private Texture TranExterior;
    private Texture TranInterior;
    private Texture TranLand;
    private Texture TranMario;

    public TranBuilding(GL2 gl, GLU glu) {
        quadric = glu.gluNewQuadric();
        glu.gluQuadricDrawStyle(quadric, GLU.GLU_FILL); // GLU_POINT, GLU_LINE, GLU_FILL, GLU_SILHOUETTE
        glu.gluQuadricNormals  (quadric, GLU.GLU_NONE); // GLU_NONE, GLU_FLAT, or GLU_SMOOTH
        glu.gluQuadricTexture  (quadric, false);        // false, or true to generate texture coordinates
        
        TranExterior = setupTexture(gl, "TranExterior.jpg");
        TranInterior = setupTexture(gl, "TranInterior.jpg");
        TranLand =     setupTexture(gl, "TranLand.jpg");
        TranMario =    setupTexture(gl, "TranMario.jpg");
    }
    
    public void draw(GL2 gl, GLU glu) {
        gl.glColor3f(1f,1f,1f);

        // Prototypes:
        //glu.gluSphere(quadric,  radius, slices, stacks), center at origin
        //glu.gluCylinder quadric, base radius, top radius, height, slices, stacks), down +Z axis
        //glu.gluDisk(quadric, inner radius, outer radius, slices, stacks), in XY plane
        //glu.gluPartialDisk(quadric, inner radius, outer radius, slices, stacks, start angle, end angle)

        // Land
        gl.glEnable(GL2.GL_TEXTURE_2D);
            TranLand.bind(gl);
            gl.glBegin(GL2.GL_QUADS);
                gl.glTexCoord2f(0f,50f); gl.glVertex3f(  0, 0,   0);
                gl.glTexCoord2f(50f,50f); gl.glVertex3f(100, 0,   0);
                gl.glTexCoord2f(50f,0f); gl.glVertex3f(100, 0, 100);
                gl.glTexCoord2f(0f,0f); gl.glVertex3f(  0, 0, 100);
            gl.glEnd();
        gl.glDisable(GL2.GL_TEXTURE_2D);
        
        // Back wall
        //++frames;
        gl.glEnable(GL2.GL_TEXTURE_2D);
        //TranExterior.bind(gl);
        gl.glEnable(GL2.GL_TEXTURE_GEN_S);
        gl.glEnable(GL2.GL_TEXTURE_GEN_T);
            gl.glTexGeni(GL2.GL_S, GL2.GL_TEXTURE_GEN_MODE, GL2.GL_OBJECT_LINEAR);
            gl.glTexGeni(GL2.GL_T, GL2.GL_TEXTURE_GEN_MODE, GL2.GL_OBJECT_LINEAR);
            float[] coef_s = {.5f,0,0,0};
            gl.glTexGenfv(GL2.GL_S, GL2.GL_OBJECT_PLANE, coef_s, 0);
            float[] coef_t = {0,.5f,0,0};
            gl.glTexGenfv(GL2.GL_T, GL2.GL_OBJECT_PLANE, coef_t, 0);
            gl.glEnable(GL2.GL_CULL_FACE);
        	gl.glPushMatrix(); // Back wall A
            	//gl.glRotatef(frames*2, 0,1,0);
            	gl.glEnable(GL2.GL_TEXTURE_2D);
                	TranInterior.bind(gl);
                	gl.glBegin(GL2.GL_QUADS);
                    	// ccw as viewed from front
                    	gl.glVertex3f(25, 14, 25);
                    	gl.glVertex3f(25, 7, 25);
                    	gl.glVertex3f(75, 7, 25);
                    	gl.glVertex3f(75, 14, 25);
                    gl.glEnd();
                	TranExterior.bind(gl);
                	gl.glBegin(GL2.GL_QUADS);
                    	// cw as viewed from front, so can be seen as ccw from back
                    	gl.glVertex3f(25, 14, 25);
                    	gl.glVertex3f(75, 14, 25);
                    	gl.glVertex3f(75, 7, 25);
                    	gl.glVertex3f(25, 7, 25);
                    gl.glEnd();
                gl.glDisable(GL2.GL_TEXTURE_2D);
            gl.glPopMatrix();
        	gl.glPushMatrix(); // Back wall B
        	//gl.glRotatef(frames*2, 0,1,0);
        		gl.glEnable(GL2.GL_TEXTURE_2D);
            		TranInterior.bind(gl);
            		gl.glBegin(GL2.GL_QUADS);
            			// ccw as viewed from front
                		gl.glVertex3f(25, 7, 25);
                		gl.glVertex3f(25, 0, 25);
                		gl.glVertex3f(50, 0, 25);
                		gl.glVertex3f(50, 7, 25);
                		gl.glEnd();
                	TranExterior.bind(gl);
            		gl.glBegin(GL2.GL_QUADS);
                		// cw as viewed from front, so can be seen as ccw from back
                		gl.glVertex3f(25, 7, 25);
                		gl.glVertex3f(50, 7, 25);
                		gl.glVertex3f(50, 0, 25);
                		gl.glVertex3f(25, 0, 25);
                	gl.glEnd();
                gl.glDisable(GL2.GL_TEXTURE_2D);
            gl.glPopMatrix();
        	gl.glPushMatrix(); // Back wall C
        	//gl.glRotatef(frames*2, 0,1,0);
        		gl.glEnable(GL2.GL_TEXTURE_2D);
            		TranInterior.bind(gl);
            		gl.glBegin(GL2.GL_QUADS);
                		// ccw as viewed from front
                		gl.glVertex3f(54, 7, 25);
                		gl.glVertex3f(54, 0, 25);
                		gl.glVertex3f(75, 0, 25);
                		gl.glVertex3f(75, 7, 25);
                	gl.glEnd();
                	TranExterior.bind(gl);
            		gl.glBegin(GL2.GL_QUADS);
                		// cw as viewed from front, so can be seen as ccw from back
                		gl.glVertex3f(54, 7, 25);
                		gl.glVertex3f(75, 7, 25);
                		gl.glVertex3f(75, 0, 25);
                		gl.glVertex3f(54, 0, 25);
                	gl.glEnd();
                gl.glDisable(GL2.GL_TEXTURE_2D);
            gl.glPopMatrix();            
        gl.glDisable(GL2.GL_CULL_FACE);
        gl.glDisable(GL2.GL_TEXTURE_2D);
        gl.glDisable(GL2.GL_TEXTURE_GEN_S);
        gl.glDisable(GL2.GL_TEXTURE_GEN_T);
        
        // Front wall
        //++frames;
        gl.glEnable(GL2.GL_TEXTURE_2D);
        //TranExterior.bind(gl);
        gl.glEnable(GL2.GL_TEXTURE_GEN_S);
        gl.glEnable(GL2.GL_TEXTURE_GEN_T);
            gl.glTexGeni(GL2.GL_S, GL2.GL_TEXTURE_GEN_MODE, GL2.GL_OBJECT_LINEAR);
            gl.glTexGeni(GL2.GL_T, GL2.GL_TEXTURE_GEN_MODE, GL2.GL_OBJECT_LINEAR);
            float[] coef_u = {.5f,0,0,0};
            gl.glTexGenfv(GL2.GL_S, GL2.GL_OBJECT_PLANE, coef_u, 0);
            float[] coef_v = {0,.5f,0,0};
            gl.glTexGenfv(GL2.GL_T, GL2.GL_OBJECT_PLANE, coef_v, 0);
            gl.glEnable(GL2.GL_CULL_FACE);
        	gl.glPushMatrix(); // Front wall D
            	//gl.glRotatef(frames*2, 0,1,0);
            	gl.glEnable(GL2.GL_TEXTURE_2D);
                	TranExterior.bind(gl);
                	gl.glBegin(GL2.GL_QUADS);
                    	// ccw as viewed from front
                    	gl.glVertex3f(25, 14, 75);
                    	gl.glVertex3f(25, 7, 75);
                    	gl.glVertex3f(75, 7, 75);
                    	gl.glVertex3f(75, 14, 75);
                    gl.glEnd();
                	TranInterior.bind(gl);
                	gl.glBegin(GL2.GL_QUADS);
                    	// cw as viewed from front, so can be seen as ccw from back
                    	gl.glVertex3f(25, 14, 75);
                    	gl.glVertex3f(75, 14, 75);
                    	gl.glVertex3f(75, 7, 75);
                    	gl.glVertex3f(25, 7, 75);
                    gl.glEnd();
                gl.glDisable(GL2.GL_TEXTURE_2D);
            gl.glPopMatrix();
        	gl.glPushMatrix(); // Front wall E
        	//gl.glRotatef(frames*2, 0,1,0);
        		gl.glEnable(GL2.GL_TEXTURE_2D);
            		TranExterior.bind(gl);
            		gl.glBegin(GL2.GL_QUADS);
            			// ccw as viewed from front
                		gl.glVertex3f(25, 7, 75);
                		gl.glVertex3f(25, 0, 75);
                		gl.glVertex3f(50, 0, 75);
                		gl.glVertex3f(50, 7, 75);
                		gl.glEnd();
                	TranInterior.bind(gl);
            		gl.glBegin(GL2.GL_QUADS);
                		// cw as viewed from front, so can be seen as ccw from back
                		gl.glVertex3f(25, 7, 75);
                		gl.glVertex3f(50, 7, 75);
                		gl.glVertex3f(50, 0, 75);
                		gl.glVertex3f(25, 0, 75);
                	gl.glEnd();
                gl.glDisable(GL2.GL_TEXTURE_2D);
            gl.glPopMatrix();
        	gl.glPushMatrix(); // Front wall F
        	//gl.glRotatef(frames*2, 0,1,0);
        		gl.glEnable(GL2.GL_TEXTURE_2D);
            		TranExterior.bind(gl);
            		gl.glBegin(GL2.GL_QUADS);
                		// ccw as viewed from front
                		gl.glVertex3f(54, 7, 75);
                		gl.glVertex3f(54, 0, 75);
                		gl.glVertex3f(75, 0, 75);
                		gl.glVertex3f(75, 7, 75);
                		gl.glEnd();
                	TranInterior.bind(gl);
            		gl.glBegin(GL2.GL_QUADS);
                		// cw as viewed from front, so can be seen as ccw from back
                		gl.glVertex3f(54, 7, 75);
                		gl.glVertex3f(75, 7, 75);
                		gl.glVertex3f(75, 0, 75);
                		gl.glVertex3f(54, 0, 75);
                	gl.glEnd();
                gl.glDisable(GL2.GL_TEXTURE_2D);
            gl.glPopMatrix();            
        gl.glDisable(GL2.GL_CULL_FACE);
        gl.glDisable(GL2.GL_TEXTURE_2D);
        gl.glDisable(GL2.GL_TEXTURE_GEN_S);
        gl.glDisable(GL2.GL_TEXTURE_GEN_T);      
        
        // Left wall
        //++frames;
        gl.glEnable(GL2.GL_CULL_FACE);
        	gl.glPushMatrix();
            	//gl.glRotatef(frames*2, 0,1,0);
            	gl.glEnable(GL2.GL_TEXTURE_2D);
                	TranInterior.bind(gl);
                	gl.glBegin(GL2.GL_QUADS);
                    	// ccw as viewed from front
                    	gl.glTexCoord2f(0f,7f); gl.glVertex3f(25, 14, 25);
                    	gl.glTexCoord2f(14f,7f); gl.glVertex3f(25, 14, 75);
                    	gl.glTexCoord2f(14f,0f); gl.glVertex3f(25, 0, 75);
                    	gl.glTexCoord2f(0f,0f); gl.glVertex3f(25, 0, 25);
                    gl.glEnd();
                	TranExterior.bind(gl);
                	gl.glBegin(GL2.GL_QUADS);
                    	// cw as viewed from front, so can be seen as ccw from back
                    	gl.glTexCoord2f(14f,0f); gl.glVertex3f(25, 14, 25);
                    	gl.glTexCoord2f(14f,7f); gl.glVertex3f(25, 0, 25);
                    	gl.glTexCoord2f(0f,7f); gl.glVertex3f(25, 0, 75);
                    	gl.glTexCoord2f(0f,0f); gl.glVertex3f(25, 14, 75);
                    gl.glEnd();
                gl.glDisable(GL2.GL_TEXTURE_2D);
            gl.glPopMatrix();
        gl.glDisable(GL2.GL_CULL_FACE);
        
        // Right wall
        //++frames;
        gl.glEnable(GL2.GL_CULL_FACE);
        	gl.glPushMatrix();
            	//gl.glRotatef(frames*2, 0,1,0);
            	gl.glEnable(GL2.GL_TEXTURE_2D);
                	TranInterior.bind(gl);
                	gl.glBegin(GL2.GL_QUADS);
                    	// ccw as viewed from front
                    	gl.glTexCoord2f(0f,7f); gl.glVertex3f(75, 14, 25);
                    	gl.glTexCoord2f(14f,7f); gl.glVertex3f(75, 0, 25);
                    	gl.glTexCoord2f(14f,0f); gl.glVertex3f(75, 0, 75);
                    	gl.glTexCoord2f(0f,0f); gl.glVertex3f(75, 14, 75);
                    gl.glEnd();
                	TranExterior.bind(gl);
                	gl.glBegin(GL2.GL_QUADS);
                    	// cw as viewed from front, so can be seen as ccw from back
                    	gl.glTexCoord2f(0f,7f); gl.glVertex3f(75, 14, 25);
                    	gl.glTexCoord2f(14f,7f); gl.glVertex3f(75, 14, 75);
                    	gl.glTexCoord2f(14f,0f); gl.glVertex3f(75, 0, 75);
                    	gl.glTexCoord2f(0f,0f); gl.glVertex3f(75, 0, 25);
                    gl.glEnd();
                gl.glDisable(GL2.GL_TEXTURE_2D);
            gl.glPopMatrix();
        gl.glDisable(GL2.GL_CULL_FACE);

        // Roof/ceiling
        //++frames;
        gl.glEnable(GL2.GL_CULL_FACE);
        	gl.glPushMatrix();
            	//gl.glRotatef(frames*2, 0,1,0);
            	gl.glEnable(GL2.GL_TEXTURE_2D);
                	TranExterior.bind(gl);
                	gl.glBegin(GL2.GL_QUADS);
                    	// ccw as viewed from front
                    	gl.glTexCoord2f(0f,7f); gl.glVertex3f(25, 14, 25);
                    	gl.glTexCoord2f(14f,7f); gl.glVertex3f(25, 14, 75);
                    	gl.glTexCoord2f(14f,0f); gl.glVertex3f(75, 14, 75);
                    	gl.glTexCoord2f(0f,0f); gl.glVertex3f(75, 14, 25);
                    gl.glEnd();
                	TranInterior.bind(gl);
                	gl.glBegin(GL2.GL_QUADS);
                    	// cw as viewed from front, so can be seen as ccw from back
                    	gl.glTexCoord2f(0f,7f); gl.glVertex3f(25, 14, 25);
                    	gl.glTexCoord2f(14f,7f); gl.glVertex3f(75, 14, 25);
                    	gl.glTexCoord2f(14f,0f); gl.glVertex3f(75, 14, 75);
                    	gl.glTexCoord2f(0f,0f); gl.glVertex3f(25, 14, 75);
                    gl.glEnd();
                gl.glDisable(GL2.GL_TEXTURE_2D);
            gl.glPopMatrix();
        gl.glDisable(GL2.GL_CULL_FACE);
        
        gl.glPushMatrix(); // Lower part of pipe
        	gl.glColor3f(0.2f, .8f, .2f);
        	gl.glTranslatef(45f, 0f, 50f);
        	gl.glRotatef(-90f, 1f, 0f, 0f);
        	glu.gluCylinder(quadric, 1.75, 1.75, 4, 10, 10);
        gl.glPopMatrix();
        
        gl.glPushMatrix(); // Upper part of pipe
    		gl.glColor3f(0.2f, .8f, .2f);
    		gl.glTranslatef(45f, 4f, 50f);
    		gl.glRotatef(-90f, 1f, 0f, 0f);
    		glu.gluCylinder(quadric, 2.25, 2.25, 1, 10, 10);
    	gl.glPopMatrix();
        
        gl.glEnable(GL2.GL_TEXTURE_2D); // Mario on the wall
        	TranMario.bind(gl);
        	gl.glBegin(GL2.GL_QUADS);
        		gl.glColor3f(1f, 1f,  1f);
            	gl.glTexCoord2f(0f,1f); gl.glVertex3f(60,  12, 26);
            	gl.glTexCoord2f(1f,1f); gl.glVertex3f(70,  12, 26);
            	gl.glTexCoord2f(1f,0f); gl.glVertex3f(70, 3, 26);
            	gl.glTexCoord2f(0f,0f); gl.glVertex3f(60, 3, 26);
            gl.glEnd();
        gl.glDisable(GL2.GL_TEXTURE_2D);
    }
}