package buildings;
import game.Building;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;

import com.jogamp.opengl.util.texture.Texture;

public class MatherBuilding extends Building {
	private GLUquadric quadric, quadricText;
	private Texture wood, grass, wall, carpet, brick, roof, shrub, tree;
	
	public  MatherBuilding(GL2 gl, GLU glu) {
        quadric = glu.gluNewQuadric();
        quadricText = glu.gluNewQuadric();
        glu.gluQuadricDrawStyle(quadric, GLU.GLU_FILL); // GLU_POINT, GLU_LINE, GLU_FILL, GLU_SILHOUETTE
        glu.gluQuadricNormals  (quadric, GLU.GLU_NONE); // GLU_NONE, GLU_FLAT, or GLU_SMOOTH
        glu.gluQuadricTexture  (quadric, false);        // use true to generate texture coordinates
        
        glu.gluQuadricDrawStyle(quadric, GLU.GLU_FILL); 
        glu.gluQuadricNormals  (quadric, GLU.GLU_NONE);
        glu.gluQuadricTexture (quadricText, true);

        wood = setupTexture(gl, "matherwood140.jpg");
        grass = setupTexture(gl, "mathergrass.jpg");
        wall = setupTexture(gl, "matherwood115.jpg");
        carpet = setupTexture(gl, "mathercloth102.jpg");
        brick = setupTexture(gl, "matherbrick001.jpg");
        roof = setupTexture(gl, "mathermetal003.gif");
        shrub = setupTexture(gl, "matherbush.gif");
        tree = setupTexture(gl, "mathertree.jpg");
	}    

    public void draw(GL2 gl, GLU glu) {
      gl.glPushMatrix();
      gl.glTranslatef(0,0,100);
        // glu.gluSphere(quadric,  radius, slices, stacks)
        // glu.gluCylinder quadric, base, top, height, slices, stacks)
        // glu.gluDisk(quadric, inner radius, outer radius, slices, stacks)

    	// Corner lamp
    	gl.glPushMatrix();
    		gl.glTranslatef(12, 7, -12);
    		gl.glRotatef(90f, 1f, 0f, 0f); // stand upright on the Y
        	gl.glColor3f(0f, 0, 0f);
        	glu.gluCylinder(quadric, .75, .75, 7, 10, 10);
            gl.glColor3f(1,1,0);
            glu.gluCylinder(quadric, 2, 1, 1, 10, 10);
        gl.glPopMatrix();
        
      //tree: base
        gl.glPushMatrix();
    		gl.glTranslatef(5,3,-10);
    		gl.glRotatef(90f, 1f, 0f, 0f);
    		gl.glColor3f(0.545098f, 0.270588f, 0.0745098f);
    		glu.gluCylinder(quadric, 1, 1, 3, 10, 10);
    	gl.glPopMatrix();
    	
    	//tree: branches
    	gl.glEnable(GL2.GL_TEXTURE_2D);
    	tree.bind(gl);
    	gl.glPushMatrix();
    		gl.glTranslatef(5,33,-10);
    		gl.glRotatef(90f, 1f, 0f, 0f);
    		glu.gluCylinder(quadricText, .1, 5, 30, 10, 10);
    	gl.glPopMatrix();
    	gl.glDisable(GL2.GL_TEXTURE_2D);
    	
        // Table: 1 cylinder and a disk
        gl.glPushMatrix();
        	gl.glTranslatef(50,3,-50);
        	gl.glRotatef(90f, 1f, 0f, 0f);
        	gl.glColor3f(0.545098f, 0.270588f, 0.0745098f);
        	glu.gluCylinder(quadric, 1, 1, 3, 10, 10);
        	glu.gluDisk(quadric, .5, 5, 10, 10);
        gl.glPopMatrix();
        
        // carpet, manual texture generation 
        gl.glEnable(GL2.GL_TEXTURE_2D);
            carpet.bind(gl);
            gl.glBegin(GL2.GL_QUADS);
                gl.glTexCoord2f(0f,0f); gl.glVertex3f(10, 0, -10); // bottom left
                gl.glTexCoord2f(0f,3f); gl.glVertex3f(90, 0, -10); // bottom right
                gl.glTexCoord2f(3f,3f); gl.glVertex3f(90, 0, -90); // top right
                gl.glTexCoord2f(3f,0f); gl.glVertex3f(10, 0, -90); // top left
            gl.glEnd();
        gl.glDisable(GL2.GL_TEXTURE_2D);
        
        gl.glEnable(GL2.GL_TEXTURE_2D);
        gl.glEnable(GL2.GL_TEXTURE_GEN_S);
        gl.glEnable(GL2.GL_TEXTURE_GEN_T);
        	shrub.bind(gl);
        	gl.glTexGeni(GL2.GL_S, GL2.GL_TEXTURE_GEN_MODE, GL2.GL_OBJECT_LINEAR);
    		gl.glTexGeni(GL2.GL_T, GL2.GL_TEXTURE_GEN_MODE, GL2.GL_OBJECT_LINEAR);
    		float[] coef_s5 = {.25f,0,0,0};
    		gl.glTexGenfv(GL2.GL_S, GL2.GL_OBJECT_PLANE, coef_s5, 0);
    		float[] coef_t5 = {0,.25f,0,0};
    		gl.glTexGenfv(GL2.GL_T, GL2.GL_OBJECT_PLANE, coef_t5, 0);
        	gl.glBegin(GL2.GL_QUADS);
        		//front of hedge1
        	 	gl.glVertex3f(46, 0, 0); // bottom left
        	 	gl.glVertex3f(48, 0, 0); // bottom right
        	 	gl.glVertex3f(48, 3, 0); // top right
        	 	gl.glVertex3f(46, 3, 0); // top left
        	 gl.glEnd();
        	 gl.glBegin(GL2.GL_QUADS);
     			//front of hedge2
     	 		gl.glVertex3f(52, 0, 0); // bottom left
     	 		gl.glVertex3f(54, 0, 0); // bottom right
     	 		gl.glVertex3f(54, 3, 0); // top right
     	 		gl.glVertex3f(52, 3, 0); // top left
     	 	gl.glEnd();
  	 	gl.glDisable(GL2.GL_TEXTURE_GEN_S);
  	    gl.glDisable(GL2.GL_TEXTURE_GEN_T);
  	    gl.glDisable(GL2.GL_TEXTURE_2D);
        
        //hedges
        gl.glEnable(GL2.GL_TEXTURE_2D);
        gl.glEnable(GL2.GL_TEXTURE_GEN_S);
        gl.glEnable(GL2.GL_TEXTURE_GEN_T);
        	shrub.bind(gl);
        	gl.glTexGeni(GL2.GL_S, GL2.GL_TEXTURE_GEN_MODE, GL2.GL_OBJECT_LINEAR);
    		gl.glTexGeni(GL2.GL_T, GL2.GL_TEXTURE_GEN_MODE, GL2.GL_OBJECT_LINEAR);
    		float[] coef_s4 = {0,.25f,0,0};
    		gl.glTexGenfv(GL2.GL_S, GL2.GL_OBJECT_PLANE, coef_s4, 0);
    		float[] coef_t4 = {0,0,.25f,0};
    		gl.glTexGenfv(GL2.GL_T, GL2.GL_OBJECT_PLANE, coef_t4, 0);
        	gl.glBegin(GL2.GL_QUADS);
        		//left side of hedge1
        	 	gl.glVertex3f(46, 0, -9.9f); // bottom left
        	 	gl.glVertex3f(46, 0, 0); // bottom right
        	 	gl.glVertex3f(46, 3, 0); // top right
        	 	gl.glVertex3f(46, 3, -9.9f); // top left
        	 gl.glEnd();
        	 gl.glBegin(GL2.GL_QUADS);
     			//right side of hedge1
     	 		gl.glVertex3f(48, 0, -9.9f); // bottom left
     	 		gl.glVertex3f(48, 0, 0); // bottom right
     	 		gl.glVertex3f(48, 3, 0); // top right
     	 		gl.glVertex3f(48, 3, -9.9f); // top left
     	 	gl.glEnd();
     	 	gl.glBegin(GL2.GL_QUADS);
  				//left side of hedge2
  	 			gl.glVertex3f(52, 0, -9.9f); // bottom left
  	 			gl.glVertex3f(52, 0, 0); // bottom right
  	 			gl.glVertex3f(52, 3, 0); // top right
  	 			gl.glVertex3f(52, 3, -9.9f); // top left
  	 		gl.glEnd();
  	 		gl.glBegin(GL2.GL_QUADS);
  	 			//right side of hedge2
  	 			gl.glVertex3f(54, 0, -9.9f); // bottom left
  	 			gl.glVertex3f(54, 0, 0); // bottom right
  	 			gl.glVertex3f(54, 3, 0); // top right
  	 			gl.glVertex3f(54, 3, -9.9f); // top left
  	 		gl.glEnd();
  	 	gl.glDisable(GL2.GL_TEXTURE_GEN_S);
  	    gl.glDisable(GL2.GL_TEXTURE_GEN_T);
  	    gl.glDisable(GL2.GL_TEXTURE_2D);

        // grass, sidewalk, using automatic texture generation
        gl.glEnable(GL2.GL_TEXTURE_2D);
        gl.glEnable(GL2.GL_TEXTURE_GEN_S);
        gl.glEnable(GL2.GL_TEXTURE_GEN_T);
        	grass.bind(gl);
            gl.glTexGeni(GL2.GL_S, GL2.GL_TEXTURE_GEN_MODE, GL2.GL_OBJECT_LINEAR);
            gl.glTexGeni(GL2.GL_T, GL2.GL_TEXTURE_GEN_MODE, GL2.GL_OBJECT_LINEAR);
            float[] coef_s0 = {.5f,0,0,0};
            gl.glTexGenfv(GL2.GL_S, GL2.GL_OBJECT_PLANE, coef_s0, 0);
            float[] coef_t0 = {0,0,.5f,0};
            gl.glTexGenfv(GL2.GL_T, GL2.GL_OBJECT_PLANE, coef_t0, 0);
            gl.glBegin(GL2.GL_QUADS);
            	// front lawn left side
                gl.glVertex3f(0, 0, 0); // bottom left
                gl.glVertex3f(48, 0, 0); // bottom right
                gl.glVertex3f(48, 0, -10); // top right
                gl.glVertex3f(0, 0, -10); // top left
            gl.glEnd();
            gl.glBegin(GL2.GL_QUADS);
        		// front lawn right side
            	gl.glVertex3f(52, 0, 0); // bottom left
            	gl.glVertex3f(100, 0, 0); // bottom right
            	gl.glVertex3f(100, 0, -10); // top right
            	gl.glVertex3f(52, 0, -10); // top left
            gl.glEnd();
            brick.bind(gl);
            gl.glBegin(GL2.GL_QUADS);
            	// brick entry way
            	gl.glVertex3f(48, 0, 0); // bottom left
            	gl.glVertex3f(52, 0, 0); // bottom right
            	gl.glVertex3f(52, 0, -10); // top right
            	gl.glVertex3f(48, 0, -10); // top left
            gl.glEnd();
            grass.bind(gl);
            gl.glBegin(GL2.GL_QUADS);
            	//side left lawn
            	gl.glVertex3f(0, 0, -10); // bottom left
            	gl.glVertex3f(10, 0, -10); // bottom right
            	gl.glVertex3f(10, 0, -100); // top right
            	gl.glVertex3f(0, 0, -100); // top left
            gl.glEnd();
            gl.glBegin(GL2.GL_QUADS);
            	//side right lawn
        		gl.glVertex3f(90, 0, -10); // bottom left
        		gl.glVertex3f(100, 0, -10); // bottom right
        		gl.glVertex3f(100, 0, -100); // top right
        		gl.glVertex3f(90, 0, -100); // top left
        	gl.glEnd();
        	gl.glBegin(GL2.GL_QUADS);
        		// back lawn
          		gl.glVertex3f(10, 0, -90); // bottom left
          		gl.glVertex3f(90, 0, -90); // bottom right
          		gl.glVertex3f(90, 0, -100); // top right
          		gl.glVertex3f(10, 0, -100); // top left
          	gl.glEnd();	
          	shrub.bind(gl);
          	gl.glBegin(GL2.GL_QUADS);
          		//top of hedge1
          		gl.glVertex3f(46, 3, 0); // bottom left
          		gl.glVertex3f(48, 3, 0); // bottom right
          		gl.glVertex3f(48, 3, -9.9f); // top right
          		gl.glVertex3f(46, 3, -9.9f); // top left
          	gl.glEnd();
          	gl.glBegin(GL2.GL_QUADS);
      			//top of hedge2
      			gl.glVertex3f(52, 3, 0); // bottom left
      			gl.glVertex3f(54, 3, 0); // bottom right
      			gl.glVertex3f(54, 3, -9.9f); // top right
      			gl.glVertex3f(52, 3, -9.9f); // top left
      		gl.glEnd();	
        gl.glDisable(GL2.GL_TEXTURE_GEN_S);
        gl.glDisable(GL2.GL_TEXTURE_GEN_T);
        gl.glDisable(GL2.GL_TEXTURE_2D);
    
        // two sided, automatic, front and back wall
        gl.glEnable(GL2.GL_CULL_FACE);
        gl.glEnable(GL2.GL_TEXTURE_2D);
        	gl.glEnable(GL2.GL_TEXTURE_GEN_S);
        	gl.glEnable(GL2.GL_TEXTURE_GEN_T);
        		wood.bind(gl);
        		gl.glTexGeni(GL2.GL_S, GL2.GL_TEXTURE_GEN_MODE, GL2.GL_OBJECT_LINEAR);
        		gl.glTexGeni(GL2.GL_T, GL2.GL_TEXTURE_GEN_MODE, GL2.GL_OBJECT_LINEAR);
        		float[] coef_s1 = {.25f,0,0,0};
        		gl.glTexGenfv(GL2.GL_S, GL2.GL_OBJECT_PLANE, coef_s1, 0);
        		float[] coef_t1 = {0,.25f,0,0};
        		gl.glTexGenfv(GL2.GL_T, GL2.GL_OBJECT_PLANE, coef_t1, 0);
        		gl.glBegin(GL2.GL_QUADS);
    				// quad over the back doorway, outside
    				gl.glVertex3f(90,  7, -90); // bottom left
    				gl.glVertex3f(86,  7, -90); // bottom right 
    				gl.glVertex3f(86, 14, -90); // top right
    				gl.glVertex3f(90, 14, -90); // top left
    			gl.glEnd();
        		gl.glBegin(GL2.GL_TRIANGLES);
    				// front roof peak, outside
    				gl.glVertex3f(10,  14, -10); // bottom left
    				gl.glVertex3f(90,  14, -10); // bottom right 
    				gl.glVertex3f(50, 20, -10); // top
    			gl.glEnd();
    			gl.glBegin(GL2.GL_TRIANGLES);
					// back roof peak, outside
    				gl.glVertex3f(90,  14, -90); // bottom left
    				gl.glVertex3f(10,  14, -90); // bottom right 
    				gl.glVertex3f(50, 20, -90); // top
				gl.glEnd();
        		gl.glBegin(GL2.GL_QUADS);
        			// quad over the doorway, outside
        			gl.glVertex3f(48,  7, -10); // bottom left
        			gl.glVertex3f(52,  7, -10); // bottom right 
        			gl.glVertex3f(52, 14, -10); // top right
        			gl.glVertex3f(48, 14, -10); // top left
        		gl.glEnd();
        		gl.glBegin(GL2.GL_QUADS);
        			// the right side quad, outside
        			gl.glVertex3f(52, 0, -10); // bottom left
        			gl.glVertex3f(90, 0, -10); // bottom right
        			gl.glVertex3f(90, 14, -10); // top right
        			gl.glVertex3f(52, 14, -10); // top left
        		gl.glEnd();
        		gl.glBegin(GL2.GL_QUADS);
    				// the left side quad, outside
    				gl.glVertex3f(10, 0, -10); // bottom left
    				gl.glVertex3f(48, 0, -10); // bottom right
    				gl.glVertex3f(48, 14, -10); // top right
    				gl.glVertex3f(10, 14, -10); // top left
    			gl.glEnd();
    			gl.glBegin(GL2.GL_QUADS);
            		// back wall outside
        			gl.glVertex3f(10, 0, -90); // bottom left
        			gl.glVertex3f(10, 14, -90); // bottom right
        			gl.glVertex3f(86, 14, -90); // top right
        			gl.glVertex3f(86, 0, -90); // top left
        		gl.glEnd();
        		wall.bind(gl);
    			gl.glBegin(GL2.GL_QUADS);
    				// quad over the back doorway, inside
    				gl.glVertex3f(86,  7, -90); // bottom left
    				gl.glVertex3f(90,  7, -90); // bottom right 
    				gl.glVertex3f(90, 14, -90); // top right
    				gl.glVertex3f(86, 14, -90); // top left
    			gl.glEnd();
    			gl.glBegin(GL2.GL_TRIANGLES);
					// front roof peak, inside
					gl.glVertex3f(90,  14, -10); // bottom left
					gl.glVertex3f(10,  14, -10); // bottom right 
					gl.glVertex3f(50, 20, -10); // top
				gl.glEnd();
				gl.glBegin(GL2.GL_TRIANGLES);
					// back roof peak, inside
					gl.glVertex3f(10,  14, -90); // bottom left
					gl.glVertex3f(90,  14, -90); // bottom right 
					gl.glVertex3f(50, 20, -90); // top
				gl.glEnd();
    			gl.glBegin(GL2.GL_QUADS); 
    				// left portion of inside front wall, as you walk in
        			gl.glVertex3f(10, 0, -10); //bottom left
        			gl.glVertex3f(10, 14, -10); //bottom right
        			gl.glVertex3f(48, 14, -10); //top right 
        			gl.glVertex3f(48, 0, -10); //top left
        		gl.glEnd();
        		gl.glBegin(GL2.GL_QUADS); 
					// overhead portion of inside front wall
        			gl.glVertex3f(48,  7, -10); // bottom left
        			gl.glVertex3f(48,  14, -10); // bottom right 
        			gl.glVertex3f(52, 14, -10); // top right
        			gl.glVertex3f(52, 7, -10); // top left
    			gl.glEnd();
    			gl.glBegin(GL2.GL_QUADS); 
					// right portion of inside front wall, as you walk in
    				gl.glVertex3f(52, 0, -10); // bottom left
    				gl.glVertex3f(52, 14, -10); // bottom right
    				gl.glVertex3f(90, 14, -10); // top right
    				gl.glVertex3f(90, 0, -10); // top left
    			gl.glEnd();
    			gl.glBegin(GL2.GL_QUADS);
    				// back wall inside
        			gl.glVertex3f(10, 0, -90); // bottom left
        			gl.glVertex3f(86, 0, -90); // bottom right
        			gl.glVertex3f(86, 14, -90); // top right
        			gl.glVertex3f(10, 14, -90); // top left
        		gl.glEnd();
        	gl.glDisable(GL2.GL_TEXTURE_GEN_S);
        	gl.glDisable(GL2.GL_TEXTURE_GEN_T);
        gl.glDisable(GL2.GL_TEXTURE_2D);
        gl.glDisable(GL2.GL_CULL_FACE);
        
        // left and right wall, automatic and two-sided
        gl.glEnable(GL2.GL_CULL_FACE);
        gl.glEnable(GL2.GL_TEXTURE_2D);
        	gl.glEnable(GL2.GL_TEXTURE_GEN_S);
        	gl.glEnable(GL2.GL_TEXTURE_GEN_T);
        	wall.bind(gl);
        	gl.glTexGeni(GL2.GL_S, GL2.GL_TEXTURE_GEN_MODE, GL2.GL_OBJECT_LINEAR);
    		gl.glTexGeni(GL2.GL_T, GL2.GL_TEXTURE_GEN_MODE, GL2.GL_OBJECT_LINEAR);
    		float[] coef_s2 = {0,.25f,0,0};
    		gl.glTexGenfv(GL2.GL_S, GL2.GL_OBJECT_PLANE, coef_s2, 0);
    		float[] coef_t2 = {0,0,.25f,0};
    		gl.glTexGenfv(GL2.GL_T, GL2.GL_OBJECT_PLANE, coef_t2, 0);
        	gl.glBegin(GL2.GL_QUADS);
        		// left wall inside
            	gl.glVertex3f(10, 0, -90); // bottom left
            	gl.glVertex3f(10, 14, -90); // bottom right
            	gl.glVertex3f(10, 14, -10); // top right
            	gl.glVertex3f(10, 0, -10); // top left
            gl.glEnd();
            gl.glBegin(GL2.GL_QUADS);
    			// right wall inside
        		gl.glVertex3f(90, 0, -90); // bottom left
        		gl.glVertex3f(90, 0, -10); // bottom right
        		gl.glVertex3f(90, 14, -10); // top right
        		gl.glVertex3f(90, 14, -90); // top left
        	gl.glEnd();
        	wood.bind(gl);
            gl.glBegin(GL2.GL_QUADS);
            	// left wall outside
        		gl.glVertex3f(10, 0, -90); // bottom left
        		gl.glVertex3f(10, 0, -10); // bottom right
        		gl.glVertex3f(10, 14, -10); // top right
        		gl.glVertex3f(10, 14, -90); // top left
        	gl.glEnd();
        	gl.glBegin(GL2.GL_QUADS);
          		//right wall outside 
      			gl.glVertex3f(90, 0, -90); // bottom left
      			gl.glVertex3f(90, 14, -90); // bottom right
      			gl.glVertex3f(90, 14, -10); // top right
      			gl.glVertex3f(90, 0, -10); // top left
      		gl.glEnd();
        	gl.glDisable(GL2.GL_TEXTURE_GEN_S);
        	gl.glDisable(GL2.GL_TEXTURE_GEN_T);
        gl.glDisable(GL2.GL_TEXTURE_2D);
        gl.glDisable(GL2.GL_CULL_FACE);
        
     // left and right wall, automatic and two-sided
        gl.glEnable(GL2.GL_CULL_FACE);
        gl.glEnable(GL2.GL_TEXTURE_2D);
        	gl.glEnable(GL2.GL_TEXTURE_GEN_S);
        	gl.glEnable(GL2.GL_TEXTURE_GEN_T);
        	roof.bind(gl);
        	gl.glTexGeni(GL2.GL_S, GL2.GL_TEXTURE_GEN_MODE, GL2.GL_OBJECT_LINEAR);
    		gl.glTexGeni(GL2.GL_T, GL2.GL_TEXTURE_GEN_MODE, GL2.GL_OBJECT_LINEAR);
    		float[] coef_s3 = {.25f,0,0,0};
    		gl.glTexGenfv(GL2.GL_S, GL2.GL_OBJECT_PLANE, coef_s3, 0);
    		float[] coef_t3 = {0,0,.25f,0};
    		gl.glTexGenfv(GL2.GL_T, GL2.GL_OBJECT_PLANE, coef_t3, 0);
        	gl.glBegin(GL2.GL_QUADS);
        		// left roof
            	gl.glVertex3f(10, 14, -10); // bottom left
            	gl.glVertex3f(50, 20, -10); // bottom right
            	gl.glVertex3f(50, 20, -90); // top right
            	gl.glVertex3f(10, 14, -90); // top left
            gl.glEnd();
            gl.glBegin(GL2.GL_QUADS);
    			// right roof
        		gl.glVertex3f(50, 20, -10); // bottom left
        		gl.glVertex3f(90, 14, -10); // bottom right
        		gl.glVertex3f(90, 14, -90); // top right
        		gl.glVertex3f(50, 20, -90); // top left
        	gl.glEnd();
            wall.bind(gl);
            gl.glBegin(GL2.GL_QUADS);
            	// left ceiling
        		gl.glVertex3f(10, 14, -10); // bottom left
        		gl.glVertex3f(10, 14, -90); // bottom right
        		gl.glVertex3f(50, 20, -90); // top right
        		gl.glVertex3f(50, 20, -10); // top left
        	gl.glEnd();
        	gl.glBegin(GL2.GL_QUADS);
          		//right ceiling 
      			gl.glVertex3f(50, 20, -10); // bottom left
      			gl.glVertex3f(50, 20, -90); // bottom right
      			gl.glVertex3f(90, 14, -90); // top right
      			gl.glVertex3f(90, 14, -10); // top left
      		gl.glEnd();
        	gl.glDisable(GL2.GL_TEXTURE_GEN_S);
        	gl.glDisable(GL2.GL_TEXTURE_GEN_T);
        gl.glDisable(GL2.GL_TEXTURE_2D);
        gl.glDisable(GL2.GL_CULL_FACE);  
      gl.glPopMatrix();
    }
}
