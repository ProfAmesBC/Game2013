package buildings;
import game.Building;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;

import com.jogamp.opengl.util.texture.Texture;


public class MidgleyBuilding extends Building{
	private Texture grass;
	private  Texture paneling;
		    private  Texture wallpaper;
	        private  Texture bricks;
		    private  Texture carpet;
	        private Texture shingles;
	        private Texture chestwood;
	        private Texture chestwoodTop;
	        private Texture marble;
		    private Texture cross;
	        private GLUquadric quadric;
	       public MidgleyBuilding(GL2 gl, GLU glu){

	    	   grass = setupTexture(gl, "MidgleyGrass.jpg");
	    	   paneling = setupTexture(gl, "MidgleyPanelWood.jpg");
	           wallpaper  = setupTexture(gl, "MidgleyWallpaper.jpg"); // if this causes trouble, try bricks.gif
	           bricks = setupTexture(gl, "MidgleyBricks.jpg");
	           carpet  = setupTexture(gl, "MidgleyCarpet.jpg"); // if this causes trouble, try bricks.gif
	           shingles = setupTexture(gl, "MidgleyShingles2.jpg");
	           chestwood  = setupTexture(gl, "MidgleyChestWood.gif"); // if this causes trouble, try bricks.gif
	           chestwoodTop  = setupTexture(gl, "MidgleyChestWoodTop.gif"); // if this causes trouble, try bricks.gif
	           marble = setupTexture(gl, "MidgleyMantleMarble.gif");
	           //cross  = setupTexture(gl, "MidgleyCross.gif"); // if this causes trouble, try bricks.gif
	           
	           quadric = glu.gluNewQuadric();
	           glu.gluQuadricDrawStyle(quadric, GLU.GLU_FILL); // GLU_POINT, GLU_LINE, GLU_FILL, GLU_SILHOUETTE
	           glu.gluQuadricNormals  (quadric, GLU.GLU_NONE); // GLU_NONE, GLU_FLAT, or GLU_SMOOTH
	           glu.gluQuadricTexture  (quadric, true);        // true to generate texture coordinates

	       }
public void texhold(GL2 gl){
	gl.glEnable(GL2.GL_TEXTURE_2D);
	gl.glEnable(GL2.GL_TEXTURE_GEN_S);
	gl.glEnable(GL2.GL_TEXTURE_GEN_T);
    gl.glTexGeni(GL2.GL_S, GL2.GL_TEXTURE_GEN_MODE, GL2.GL_OBJECT_LINEAR);
    gl.glTexGeni(GL2.GL_T, GL2.GL_TEXTURE_GEN_MODE, GL2.GL_OBJECT_LINEAR);
    float[] coef_s = {.5f,0,0,0};
    gl.glTexGenfv(GL2.GL_S, GL2.GL_OBJECT_PLANE, coef_s, 0);
    float[] coef_t = {0,.25f,0,0};
    gl.glTexGenfv(GL2.GL_T, GL2.GL_OBJECT_PLANE, coef_t, 0);

	gl.glDisable(GL2.GL_TEXTURE_2D);
	gl.glDisable(GL2.GL_TEXTURE_GEN_S);
	gl.glDisable(GL2.GL_TEXTURE_GEN_T);
	}


	

	public void draw(GL2 gl, GLU glu){
		drawGround(gl);
		drawFrontWall(gl);
		drawBackWall(gl);
		drawRoof(gl);
		drawLeftWall(gl);
		drawRightWall(gl);
		drawCarpet(gl);
		drawDoorFrames(gl);
		drawWindowFrames(gl);
		drawFirePlace(gl);
		gl.glPushMatrix();
			gl.glTranslated(65, 0, 50);
			gl.glRotated(180, 0, 1, 0);
				drawChest(gl,glu);
		gl.glPopMatrix();
		   //window glass
        gl.glEnable(GL2.GL_BLEND);
        gl.glBlendFunc(GL2.GL_SRC_ALPHA, GL2.GL_ONE_MINUS_SRC_ALPHA);
        gl.glColor4d(.5, .5, 1, .4);

		gl.glBegin(GL2.GL_QUADS);
		gl.glVertex3d(33,4,20);
		gl.glVertex3d(37,4,20);
		gl.glVertex3d(37,10,20);
		gl.glVertex3d(33,10,20);
		

		gl.glVertex3d(63,4,20);
		gl.glVertex3d(67,4,20);
		gl.glVertex3d(67,10,20);
		gl.glVertex3d(63,10,20);

		gl.glVertex3d(33,4,80);
		gl.glVertex3d(37,4,80);
		gl.glVertex3d(37,10,80);
		gl.glVertex3d(33,10,80);
		

		gl.glVertex3d(63,4,80);
		gl.glVertex3d(67,4,80);
		gl.glVertex3d(67,10,80);
		gl.glVertex3d(63,10,80);
		
	    gl.glColor4d(1, 1, 1, 1);
		gl.glEnd();
		gl.glDisable(GL2.GL_BLEND);
	}
	
	public void drawGround(GL2 gl){
		  gl.glEnable(GL2.GL_TEXTURE_2D);
	        grass.bind(gl);
	       // gl.glColor4d(0,0,0,1);
	        gl.glBegin(GL2.GL_QUADS);
	        	gl.glTexCoord2d(0, 0);gl.glVertex3d(0, 0, 0);
	        	gl.glTexCoord2d(20, 0);gl.glVertex3d(100, 0, 0);
	        	gl.glTexCoord2d(20, 20);gl.glVertex3d(100, 0, 100);
	        	gl.glTexCoord2d(0, 20);gl.glVertex3d(0, 0, 100);
	        	
	        gl.glEnd();
	        gl.glDisable(GL2.GL_TEXTURE_2D);

	}
	public void drawFrontWall(GL2 gl){		
		 gl.glEnable(GL2.GL_TEXTURE_2D);
	     gl.glEnable(GL2.GL_TEXTURE_GEN_S);
	     gl.glEnable(GL2.GL_TEXTURE_GEN_T);
	         gl.glTexGeni(GL2.GL_S, GL2.GL_TEXTURE_GEN_MODE, GL2.GL_OBJECT_LINEAR);
	         gl.glTexGeni(GL2.GL_T, GL2.GL_TEXTURE_GEN_MODE, GL2.GL_OBJECT_LINEAR);
	         float[] coef_s = {.5f,0,0,0};
	         gl.glTexGenfv(GL2.GL_S, GL2.GL_OBJECT_PLANE, coef_s, 0);
	         float[] coef_t = {0,.25f,0,0};
	         gl.glTexGenfv(GL2.GL_T, GL2.GL_OBJECT_PLANE, coef_t, 0);

		     paneling.bind(gl);
	         gl.glBegin(GL2.GL_QUADS);
	          
		gl.glColor3d(1, 0, 0);
	//front wall	
		gl.glVertex3d(20,0,20);
		gl.glVertex3d(47,0,20);
		gl.glVertex3d(47,4,20);
		gl.glVertex3d(20,4,20);
		
		gl.glVertex3d(53,0,20);
		gl.glVertex3d(80,0,20);
		gl.glVertex3d(80,4,20);
		gl.glVertex3d(53,4,20);			
		
		gl.glVertex3d(20,10,20);
		gl.glVertex3d(47,10,20);
		gl.glVertex3d(47,25,20);
		gl.glVertex3d(20,25,20);
		
		gl.glVertex3d(53,10,20);
		gl.glVertex3d(80,10,20);
		gl.glVertex3d(80,25,20);
		gl.glVertex3d(53,25,20);	
		
		gl.glVertex3d(47,10,20);
		gl.glVertex3d(53,10,20);
		gl.glVertex3d(53,25,20);
		gl.glVertex3d(47,25,20);
		
		
		
		
		// window fillers
		gl.glVertex3d(20,0,20);
		gl.glVertex3d(33,0,20);
		gl.glVertex3d(33,10,20);
		gl.glVertex3d(20,10,20);
		
		gl.glVertex3d(37,0,20);
		gl.glVertex3d(47,0,20);
		gl.glVertex3d(47,10,20);
		gl.glVertex3d(37,10,20);
		
		
		// window fillers
		gl.glVertex3d(80,0,20);
		gl.glVertex3d(67,0,20);
		gl.glVertex3d(67,10,20);
		gl.glVertex3d(80,10,20);
		
		gl.glVertex3d(63,0,20);
		gl.glVertex3d(53,0,20);
		gl.glVertex3d(53,10,20);
		gl.glVertex3d(63,10,20);
		
		gl.glEnd();
		
		//'''''

		wallpaper.bind(gl);
	 gl.glBegin(GL2.GL_QUADS);
		gl.glVertex3d(20,0,21);
		gl.glVertex3d(47,0,21);
		gl.glVertex3d(47,4,21);
		gl.glVertex3d(20,4,21);
		
		gl.glVertex3d(53,0,21);
		gl.glVertex3d(80,0,21);
		gl.glVertex3d(80,4,21);
		gl.glVertex3d(53,4,21);		

		gl.glVertex3d(20,10,21);
		gl.glVertex3d(47,10,21);
		gl.glVertex3d(47,25,21);
		gl.glVertex3d(20,25,21);
		
		gl.glVertex3d(53,10,21);
		gl.glVertex3d(80,10,21);
		gl.glVertex3d(80,25,21);
		gl.glVertex3d(53,25,21);	
		
		gl.glVertex3d(47,10,21);
		gl.glVertex3d(53,10,21);
		gl.glVertex3d(53,25,21);
		gl.glVertex3d(47,25,21);
		
		
		// window fillers
		gl.glVertex3d(20,0,21);
		gl.glVertex3d(33,0,21);
		gl.glVertex3d(33,10,21);
		gl.glVertex3d(20,10,21);
		
		gl.glVertex3d(37,0,21);
		gl.glVertex3d(47,0,21);
		gl.glVertex3d(47,10,21);
		gl.glVertex3d(37,10,21);
		
		
		// window fillers
		gl.glVertex3d(80,0,21);
		gl.glVertex3d(67,0,21);
		gl.glVertex3d(67,10,21);
		gl.glVertex3d(80,10,21);
		
		gl.glVertex3d(63,0,21);
		gl.glVertex3d(53,0,21);
		gl.glVertex3d(53,10,21);
		gl.glVertex3d(63,10,21);
		
		gl.glEnd();
		
		//roof triangles
		
		paneling.bind(gl);
		gl.glBegin(GL2.GL_QUADS);
		gl.glColor3d(0, .5, .5);
		gl.glVertex3d(80,25,80);
		gl.glVertex3d(50,50,80);
		gl.glVertex3d(20,25,80);

		gl.glVertex3d(20,25,80);

		gl.glColor3d(.5, .5, 0);
		gl.glVertex3d(20,25,20);
		gl.glVertex3d(50,50,20);
		gl.glVertex3d(80,25,20);
		gl.glVertex3d(80,25,20);
		gl.glEnd();
		///''''

		wallpaper.bind(gl);
		gl.glBegin(GL2.GL_QUADS);
		gl.glVertex3d(80,25,79);
		gl.glVertex3d(50,50,79);
		gl.glVertex3d(20,25,79);

		gl.glVertex3d(20,25,79);

		gl.glColor3d(.5, .5, 0);
		gl.glVertex3d(20,25,21);
		gl.glVertex3d(50,50,21);
		gl.glVertex3d(80,25,21);
		gl.glVertex3d(80,25,21);
		gl.glEnd();


        gl.glDisable(GL2.GL_TEXTURE_2D);
        gl.glDisable(GL2.GL_TEXTURE_GEN_S);
        gl.glDisable(GL2.GL_TEXTURE_GEN_T);
        
     
		}
	public void drawBackWall(GL2 gl){
		//back wall		
		 gl.glEnable(GL2.GL_TEXTURE_2D);
	     gl.glEnable(GL2.GL_TEXTURE_GEN_S);
	     gl.glEnable(GL2.GL_TEXTURE_GEN_T);
	         gl.glTexGeni(GL2.GL_S, GL2.GL_TEXTURE_GEN_MODE, GL2.GL_OBJECT_LINEAR);
	         gl.glTexGeni(GL2.GL_T, GL2.GL_TEXTURE_GEN_MODE, GL2.GL_OBJECT_LINEAR);
	         float[] coef_s = {.5f,0,0,0};
	         gl.glTexGenfv(GL2.GL_S, GL2.GL_OBJECT_PLANE, coef_s, 0);
	         float[] coef_t = {0,.25f,0,0};
	         gl.glTexGenfv(GL2.GL_T, GL2.GL_OBJECT_PLANE, coef_t, 0);

 	paneling.bind(gl);
     gl.glBegin(GL2.GL_QUADS);
		gl.glColor3d(0, 1, 0);
		gl.glVertex3d(80,0,80);
		gl.glVertex3d(53,0,80);
		gl.glVertex3d(53,4,80);
		gl.glVertex3d(80,4,80);
		

		gl.glVertex3d(47,0,80);
		gl.glVertex3d(20,0,80);
		gl.glVertex3d(20,4,80);
		gl.glVertex3d(47,4,80);
	
		gl.glVertex3d(80,10,80);
		gl.glVertex3d(53,10,80);
		gl.glVertex3d(53,25,80);
		gl.glVertex3d(80,25,80);
		

		gl.glVertex3d(47,10,80);
		gl.glVertex3d(20,10,80);
		gl.glVertex3d(20,25,80);
		gl.glVertex3d(47,25,80);
		
		gl.glVertex3d(53,10,80);
		gl.glVertex3d(47,10,80);
		gl.glVertex3d(47,25,80);
		gl.glVertex3d(53,25,80);
		
		// window fillers
		gl.glVertex3d(20,0,80);
		gl.glVertex3d(33,0,80);
		gl.glVertex3d(33,10,80);
		gl.glVertex3d(20,10,80);
		
		gl.glVertex3d(37,0,80);
		gl.glVertex3d(47,0,80);
		gl.glVertex3d(47,10,80);
		gl.glVertex3d(37,10,80);
		
		
		// window fillers
		gl.glVertex3d(80,0,80);
		gl.glVertex3d(67,0,80);
		gl.glVertex3d(67,10,80);
		gl.glVertex3d(80,10,80);
		
		gl.glVertex3d(63,0,80);
		gl.glVertex3d(53,0,80);
		gl.glVertex3d(53,10,80);
		gl.glVertex3d(63,10,80);
		
		gl.glEnd();
//////'''''''

		wallpaper.bind(gl);
     gl.glBegin(GL2.GL_QUADS);
		gl.glVertex3d(80,0,79);
		gl.glVertex3d(53,0,79);
		gl.glVertex3d(53,4,79);
		gl.glVertex3d(80,4,79);
		

		gl.glVertex3d(47,0,79);
		gl.glVertex3d(20,0,79);
		gl.glVertex3d(20,4,79);
		gl.glVertex3d(47,4,79);
	
		
		gl.glVertex3d(80,10,79);
		gl.glVertex3d(53,10,79);
		gl.glVertex3d(53,25,79);
		gl.glVertex3d(80,25,79);
		

		gl.glVertex3d(47,10,79);
		gl.glVertex3d(20,10,79);
		gl.glVertex3d(20,25,79);
		gl.glVertex3d(47,25,79);
		
		gl.glVertex3d(53,10,79);
		gl.glVertex3d(47,10,79);
		gl.glVertex3d(47,25,79);
		gl.glVertex3d(53,25,79);
		
		// window fillers
		gl.glVertex3d(20,0,79);
		gl.glVertex3d(33,0,79);
		gl.glVertex3d(33,10,79);
		gl.glVertex3d(20,10,79);
		
		gl.glVertex3d(37,0,79);
		gl.glVertex3d(47,0,79);
		gl.glVertex3d(47,10,79);
		gl.glVertex3d(37,10,79);
		
		
		// window fillers
		gl.glVertex3d(80,0,79);
		gl.glVertex3d(67,0,79);
		gl.glVertex3d(67,10,79);
		gl.glVertex3d(80,10,79);
		
		gl.glVertex3d(63,0,79);
		gl.glVertex3d(53,0,79);
		gl.glVertex3d(53,10,79);
		gl.glVertex3d(63,10,79);
		
		gl.glEnd();
		
     gl.glDisable(GL2.GL_TEXTURE_2D);
     gl.glDisable(GL2.GL_TEXTURE_GEN_S);
     gl.glDisable(GL2.GL_TEXTURE_GEN_T);
}
    public void drawLeftWall(GL2 gl){
    	gl.glEnable(GL2.GL_TEXTURE_2D);
    	gl.glEnable(GL2.GL_TEXTURE_GEN_S);
    	gl.glEnable(GL2.GL_TEXTURE_GEN_T);
        gl.glTexGeni(GL2.GL_S, GL2.GL_TEXTURE_GEN_MODE, GL2.GL_OBJECT_LINEAR);
        gl.glTexGeni(GL2.GL_T, GL2.GL_TEXTURE_GEN_MODE, GL2.GL_OBJECT_LINEAR);
        float[] coef_s = {0,0,.5f,0};
        gl.glTexGenfv(GL2.GL_S, GL2.GL_OBJECT_PLANE, coef_s, 0);
        float[] coef_t = {0,.25f,0,0};
        gl.glTexGenfv(GL2.GL_T, GL2.GL_OBJECT_PLANE, coef_t, 0);

    	
    	
    	//left wall
    	paneling.bind(gl);
    	gl.glBegin(GL2.GL_QUADS);
    	//gl.glTexCoord2f(0f,0f);
    	gl.glVertex3d(80,0,20);
    	//gl.glTexCoord2f(0f,10f);
    	gl.glVertex3d(80,25,20);
    	//gl.glTexCoord2f(10f,10f);
    	gl.glVertex3d(80,25,80);
    	//gl.glTexCoord2f(10f,0f);
    	gl.glVertex3d(80,0,80);
    		gl.glEnd();
    	//'''''
    	wallpaper.bind(gl);

    	gl.glBegin(GL2.GL_QUADS);
    	//gl.glTexCoord2f(0f,0f);
    	gl.glVertex3d(79,0,20);
    	//gl.glTexCoord2f(0f,10f);
    	gl.glVertex3d(79,25,20);
    	//gl.glTexCoord2f(10f,10f);
    	gl.glVertex3d(79,25,80);
    	//gl.glTexCoord2f(10f,0f);
    	gl.glVertex3d(79,0,80);
    		
    	
    	gl.glEnd();

    	gl.glDisable(GL2.GL_TEXTURE_2D);
    	gl.glDisable(GL2.GL_TEXTURE_GEN_S);
    	gl.glDisable(GL2.GL_TEXTURE_GEN_T);
    }    		
    public void drawRightWall(GL2 gl){

    	//right wall

    			gl.glColor3d(0, 0, 1);
    			gl.glEnable(GL2.GL_CULL_FACE);
    	        gl.glPushMatrix();
    	        gl.glEnable(GL2.GL_TEXTURE_2D);
    	            bricks.bind(gl);
    	            gl.glBegin(GL2.GL_QUADS);
    	                // ccw as viewed from front
    	                gl.glTexCoord2f(0f,20f); gl.glVertex3d(20,0,80);
    	                gl.glTexCoord2f(30f,20f); gl.glVertex3d(20,0,20);
    	                gl.glTexCoord2f(30f,0f); gl.glVertex3d(20,25,20);
    	                gl.glTexCoord2f(0f,0f); gl.glVertex3d(20,25,80);
    	            gl.glEnd();
    	            paneling.bind(gl);
    	            gl.glBegin(GL2.GL_QUADS);
    	                // cw as viewed from front, so can be seen as ccw from back
    	                gl.glTexCoord2f(0f,0f);gl.glVertex3d(20,0,80);
    	                gl.glTexCoord2f(0f,10f);   gl.glVertex3d(20,25,80);
    	                gl.glTexCoord2f(10f,10f);gl.glVertex3d(20,25,20);
    	                gl.glTexCoord2f(10f,0f); gl.glVertex3d(20,0,20);
    	            gl.glEnd();
    	        gl.glDisable(GL2.GL_TEXTURE_2D);
    	    gl.glPopMatrix();
    	gl.glDisable(GL2.GL_CULL_FACE);
    			
    	//right inner wall
    	
    	
//    	float[] coef_s = {0,0,.5f,0};
    //gl.glTexGenfv(GL2.GL_S, GL2.GL_OBJECT_PLANE, coef_s, 0);
    	
    	gl.glEnable(GL2.GL_TEXTURE_2D);
    	gl.glEnable(GL2.GL_TEXTURE_GEN_S);
    	gl.glEnable(GL2.GL_TEXTURE_GEN_T);
        gl.glTexGeni(GL2.GL_S, GL2.GL_TEXTURE_GEN_MODE, GL2.GL_OBJECT_LINEAR);
        gl.glTexGeni(GL2.GL_T, GL2.GL_TEXTURE_GEN_MODE, GL2.GL_OBJECT_LINEAR);
        float[] coef_s = {0,0,.5f,0};
        gl.glTexGenfv(GL2.GL_S, GL2.GL_OBJECT_PLANE, coef_s, 0);
        float[] coef_t = {0,.25f,0,0};
        gl.glTexGenfv(GL2.GL_T, GL2.GL_OBJECT_PLANE, coef_t, 0);
        wallpaper.bind(gl);
    gl.glBegin(GL2.GL_QUADS);
    gl.glVertex3d(21,0,20);
    gl.glVertex3d(21,0,45);
    gl.glVertex3d(21,25,45);
    gl.glVertex3d(21,25,20);

    gl.glVertex3d(21,0,55);
    gl.glVertex3d(21,0,80);
    gl.glVertex3d(21,25,80);
    gl.glVertex3d(21,25,55);		

    gl.glVertex3d(21,5,45);
    gl.glVertex3d(21,5,55);
    gl.glVertex3d(21,25,55);
    gl.glVertex3d(21,25,45);

    	gl.glEnd();
    	
//          gl.glDisable(GL2.GL_TEXTURE_2D);
//        gl.glDisable(GL2.GL_TEXTURE_GEN_S);
      //  gl.glDisable(GL2.GL_TEXTURE_GEN_T);
    	
    	gl.glDisable(GL2.GL_TEXTURE_2D);
    	gl.glDisable(GL2.GL_TEXTURE_GEN_S);
    	gl.glDisable(GL2.GL_TEXTURE_GEN_T);
    	
    }
	public void drawRoof(GL2 gl){

	    ////////////////////roof

		
		gl.glEnable(GL2.GL_TEXTURE_2D);
			//left panel
		shingles.bind(gl);

		gl.glColor3d(1, 1, 0);
			gl.glBegin(GL2.GL_QUADS);
			gl.glTexCoord2f(0f,5f);gl.glVertex3d(80,25,80);
			gl.glTexCoord2f(5f,5f);gl.glVertex3d(80,25,20);
			gl.glTexCoord2f(5f,0f);gl.glVertex3d(50,50,20);
			gl.glTexCoord2f(0f,0f);gl.glVertex3d(50,50,80);
			
			
			//right panel
			gl.glColor3d(0, 1, 1);
			gl.glTexCoord2f(0f,5f);gl.glVertex3d(20,25,20);
			gl.glTexCoord2f(5f,5f);gl.glVertex3d(20,25,80);
			gl.glTexCoord2f(5f,0f);gl.glVertex3d(50,50,80);
			gl.glTexCoord2f(0f,0f);gl.glVertex3d(50,50,20);
			gl.glEnd();


			gl.glDisable(GL2.GL_TEXTURE_2D);
			
			gl.glEnable(GL2.GL_TEXTURE_2D);
			gl.glEnable(GL2.GL_TEXTURE_GEN_S);
			gl.glEnable(GL2.GL_TEXTURE_GEN_T);
		    gl.glTexGeni(GL2.GL_S, GL2.GL_TEXTURE_GEN_MODE, GL2.GL_OBJECT_LINEAR);
		    gl.glTexGeni(GL2.GL_T, GL2.GL_TEXTURE_GEN_MODE, GL2.GL_OBJECT_LINEAR);
		    float[] coef_s = {0,0,.5f,0};
		    gl.glTexGenfv(GL2.GL_S, GL2.GL_OBJECT_PLANE, coef_s, 0);
		    float[] coef_t = {0,.25f,0,0};
		    gl.glTexGenfv(GL2.GL_T, GL2.GL_OBJECT_PLANE, coef_t, 0);

//			....
			paneling.bind(gl);
			gl.glBegin(GL2.GL_QUADS);
			gl.glVertex3d(79,25,80);	
			gl.glVertex3d(79,25,20);
			gl.glVertex3d(49,50,20);
			gl.glVertex3d(49,50,80);


			gl.glVertex3d(21,25,20);
			gl.glVertex3d(21,25,80);
			gl.glVertex3d(50,50,80);
			gl.glVertex3d(50,50,20);
			gl.glEnd();

			gl.glDisable(GL2.GL_TEXTURE_2D);
			gl.glDisable(GL2.GL_TEXTURE_GEN_S);
			gl.glDisable(GL2.GL_TEXTURE_GEN_T);
			

	}  
	public void drawCarpet(GL2 gl){

		/////////carpet

	    gl.glEnable(GL2.GL_TEXTURE_2D);
		carpet.bind(gl);
		gl.glBegin(GL2.GL_QUADS);
			gl.glTexCoord2f(0f,0f);gl.glVertex3d(20, .1, 20);
			gl.glTexCoord2f(20f,0f);gl.glVertex3d(80, .1, 20);
			gl.glTexCoord2f(20f,20f);gl.glVertex3d(80, .1, 80);
			gl.glTexCoord2f(0f,20f);gl.glVertex3d(20, .1, 80);
		gl.glEnd();
	    gl.glDisable(GL2.GL_TEXTURE_2D);

	}
	public void drawDoorFrames(GL2 gl){

		gl.glEnable(GL2.GL_TEXTURE_2D);
		gl.glEnable(GL2.GL_TEXTURE_GEN_S);
		gl.glEnable(GL2.GL_TEXTURE_GEN_T);
	    gl.glTexGeni(GL2.GL_S, GL2.GL_TEXTURE_GEN_MODE, GL2.GL_OBJECT_LINEAR);
	    gl.glTexGeni(GL2.GL_T, GL2.GL_TEXTURE_GEN_MODE, GL2.GL_OBJECT_LINEAR);
	    float[] coef_s = {0,0,.5f,0};
	    gl.glTexGenfv(GL2.GL_S, GL2.GL_OBJECT_PLANE, coef_s, 0);
	    float[] coef_t = {0,.25f,0,0};
	    gl.glTexGenfv(GL2.GL_T, GL2.GL_OBJECT_PLANE, coef_t, 0);
	    
	    paneling.bind(gl);
	    gl.glBegin(GL2.GL_QUADS);
	    
		//Front Frame
	    
	    //right
	    gl.glVertex3d(47, 0, 20);
	    gl.glVertex3d(47, 0, 21);
	    gl.glVertex3d(47, 10, 21);
	    gl.glVertex3d(47, 10, 20);
	    
	    
	    //left
	    gl.glVertex3d(53, 0, 20);
	    gl.glVertex3d(53, 0, 21);
	    gl.glVertex3d(53, 10, 21);
	    gl.glVertex3d(53, 10, 20);
	    
	    
	    //top
	    gl.glVertex3d(47, 10, 20);
	    gl.glVertex3d(47, 10, 21);
	    gl.glVertex3d(53, 10, 21);
	    gl.glVertex3d(53, 10, 20);
	    
	    
	    
	    //Back Frame
	    
	    
	    
	    
	    //right
	    gl.glVertex3d(47, 0, 80);
	    gl.glVertex3d(47, 0, 79);
	    gl.glVertex3d(47, 10, 79);
	    gl.glVertex3d(47, 10, 80);
	    
	    
	    //left
	    gl.glVertex3d(53, 0, 80);
	    gl.glVertex3d(53, 0, 79);
	    gl.glVertex3d(53, 10, 79);
	    gl.glVertex3d(53, 10, 80);
	    
	    
	    //top
	    gl.glVertex3d(47, 10, 80);
	    gl.glVertex3d(47, 10, 79);
	    gl.glVertex3d(53, 10, 79);
	    gl.glVertex3d(53, 10, 80);
	    
	    
	    gl.glEnd();
	    
	    
		gl.glDisable(GL2.GL_TEXTURE_2D);
		gl.glDisable(GL2.GL_TEXTURE_GEN_S);
		gl.glDisable(GL2.GL_TEXTURE_GEN_T);
	}
 	public void drawChest(GL2 gl, GLU glu){		//chest
		chestwood.bind(gl);
		gl.glEnable(GL2.GL_TEXTURE_2D);
			gl.glBegin(GL2.GL_QUADS);
				
				gl.glTexCoord2f(0f,0f);gl.glVertex3d(0, 0, 0);
				gl.glTexCoord2f(5f,0f);gl.glVertex3d(3, 0, 0);
				gl.glTexCoord2f(5f,5f);gl.glVertex3d(3, 2, 0);
				gl.glTexCoord2f(0f,5f);	gl.glVertex3d(0, 2, 0);

				gl.glTexCoord2f(0f,0f);gl.glVertex3d(0, 0, 0);
				gl.glTexCoord2f(5f,0f);gl.glVertex3d(0, 0, 3);
				gl.glTexCoord2f(5f,5f);gl.glVertex3d(0, 2, 3);
				gl.glTexCoord2f(0f,5f);	gl.glVertex3d(0, 2, 0);
				
				gl.glTexCoord2f(0f,0f);gl.glVertex3d(3, 0, 0);
				gl.glTexCoord2f(5f,0f);gl.glVertex3d(3, 0, 3);
				gl.glTexCoord2f(5f,5f);gl.glVertex3d(3, 2, 3);
				gl.glTexCoord2f(0f,5f);	gl.glVertex3d(3, 2, 0);
				
				gl.glTexCoord2f(0f,0f);gl.glVertex3d(0, 0, 3);
				gl.glTexCoord2f(5f,0f);gl.glVertex3d(3, 0, 3);
				gl.glTexCoord2f(5f,5f);gl.glVertex3d(3, 2, 3);
				gl.glTexCoord2f(0f,5f);	gl.glVertex3d(0, 2, 3);
			gl.glEnd();
			 gl.glPushMatrix();
             gl.glTranslated(1.5, 2, 0);
             
             gl.glMatrixMode(GL2.GL_TEXTURE);
                 gl.glPushMatrix(); 
                     gl.glScaled(5,5,1);

                     
                      gl.glPushMatrix();
                      gl.glScaled(5,1,1);
             		chestwoodTop.bind(gl);
             		glu.gluCylinder(quadric, 1.5, 1.5, 3, 10, 10);
                   gl.glPopMatrix();
             		gl.glMatrixMode(GL2.GL_MODELVIEW);
            		chestwood.bind(gl);
             		glu.gluDisk(quadric, 0, 1.5, 10, 10);
             		 gl.glTranslated(0, 0, 3);
             		 
              		glu.gluDisk(quadric, 0, 1.5, 10, 10);
              		

 
                     gl.glMatrixMode(GL2.GL_TEXTURE);
                 gl.glPopMatrix();  // pop texture matrix
             gl.glMatrixMode(GL2.GL_MODELVIEW); // always leave the modelview matrix as current
             
         gl.glPopMatrix();
		gl.glDisable(GL2.GL_TEXTURE_2D);

		gl.glColor3d(0, 0, 0);  
		gl.glPushMatrix();
		gl.glTranslated(1.5, 2, .5);
		glu.gluCylinder(quadric, 1.51, 1.51, .2, 10, 10);
	     gl.glPopMatrix();
	 	gl.glPushMatrix();
		gl.glTranslated(1.5, 2, 2.2);
		glu.gluCylinder(quadric, 1.51, 1.51, .2, 10, 10);
	     gl.glPopMatrix();
		gl.glBegin(GL2.GL_QUADS);
		gl.glVertex3d(3.1, 1.7, 1.4);
		gl.glVertex3d(3.1, 1.7, 1.6);
		gl.glVertex3d(3.1, 2.1, 1.6);
		gl.glVertex3d(3.1, 2.1, 1.4);
		gl.glEnd();}
	public void drawFirePlace(GL2 gl){
		gl.glEnable(GL2.GL_TEXTURE_2D);
		gl.glEnable(GL2.GL_TEXTURE_GEN_S);
		gl.glEnable(GL2.GL_TEXTURE_GEN_T);
	    gl.glTexGeni(GL2.GL_S, GL2.GL_TEXTURE_GEN_MODE, GL2.GL_OBJECT_LINEAR);
	    gl.glTexGeni(GL2.GL_T, GL2.GL_TEXTURE_GEN_MODE, GL2.GL_OBJECT_LINEAR);
	    float[] coef_s = {.5f,0,.5f,0};
	    gl.glTexGenfv(GL2.GL_S, GL2.GL_OBJECT_PLANE, coef_s, 0);
	    float[] coef_t = {0,.25f,0,0};
	    gl.glTexGenfv(GL2.GL_T, GL2.GL_OBJECT_PLANE, coef_t, 0);

	    bricks.bind(gl);

        gl.glBegin(GL2.GL_QUADS);
 //right block
        gl.glVertex3d(20, 0, 45);
        gl.glVertex3d(22, 0, 45);
        gl.glVertex3d(22, 6, 45);
        gl.glVertex3d(20, 6, 45);
        
        gl.glVertex3d(22, 0, 45);
        gl.glVertex3d(22, 0, 47);
        gl.glVertex3d(22, 6, 47);
        gl.glVertex3d(22, 6, 45);
        
        gl.glVertex3d(22, 0, 47);
        gl.glVertex3d(20, 0, 47);
        gl.glVertex3d(20, 6, 47);
        gl.glVertex3d(22, 6, 47);
        
        
//left block
        gl.glVertex3d(20, 0, 55);
        gl.glVertex3d(22, 0, 55);
        gl.glVertex3d(22, 6, 55);
        gl.glVertex3d(20, 6, 55);
        
        gl.glVertex3d(22, 0, 55);
        gl.glVertex3d(22, 0, 57);
        gl.glVertex3d(22, 6, 57);
        gl.glVertex3d(22, 6, 55);
        
        gl.glVertex3d(22, 0, 57);
        gl.glVertex3d(20, 0, 57);
        gl.glVertex3d(20, 6, 57);
        gl.glVertex3d(22, 6, 57);
        
        //top block
        gl.glVertex3d(22, 5, 55);
	    gl.glVertex3d(22, 5, 47);
	    gl.glVertex3d(22, 6, 47);
	    gl.glVertex3d(22, 6, 55);
	    
        gl.glEnd();
        //Mantle
        marble.bind(gl);

        gl.glBegin(GL2.GL_QUADS);
        //mantle front
        gl.glVertex3d(22, 6, 57);
	    gl.glVertex3d(22, 6, 45);
	    gl.glVertex3d(22, 8, 45);
	    gl.glVertex3d(22, 8, 57);
	    
	    //left side
	    gl.glVertex3d(22, 6, 57);
	    gl.glVertex3d(20, 6, 57);
	    gl.glVertex3d(20, 8, 57);
	    gl.glVertex3d(22, 8, 57);
	    
	    //right side
	    gl.glVertex3d(22, 6, 45);
	    gl.glVertex3d(20, 6, 45);
	    gl.glVertex3d(20, 8, 45);
	    gl.glVertex3d(22, 8, 45);
	    
	    
	  //right block
        gl.glVertex3d(20, 0, 45);
        gl.glVertex3d(22, 0, 45);
        gl.glVertex3d(22, 8, 45);
        gl.glVertex3d(20, 8, 45);
        
        gl.glVertex3d(22, 0, 45);
        gl.glVertex3d(22, 0, 43);
        gl.glVertex3d(22, 8, 43);
        gl.glVertex3d(22, 8, 45);
        
        gl.glVertex3d(22, 0, 43);
        gl.glVertex3d(20, 0, 43);
        gl.glVertex3d(20, 8, 43);
        gl.glVertex3d(22, 8, 43);
        
        
//left block
        gl.glVertex3d(20, 0, 57);
        gl.glVertex3d(22, 0, 57);
        gl.glVertex3d(22, 8, 57);
        gl.glVertex3d(20, 8, 57);
        
        gl.glVertex3d(22, 0, 57);
        gl.glVertex3d(22, 0, 59);
        gl.glVertex3d(22, 8, 59);
        gl.glVertex3d(22, 8, 57);
       
        gl.glVertex3d(22, 0, 59);
        gl.glVertex3d(20, 0, 59);
        gl.glVertex3d(20, 8, 59);
        gl.glVertex3d(22, 8, 59);
        gl.glEnd();

		gl.glDisable(GL2.GL_TEXTURE_2D);
		gl.glDisable(GL2.GL_TEXTURE_GEN_S);
		gl.glDisable(GL2.GL_TEXTURE_GEN_T);
		
		 
		gl.glEnable(GL2.GL_TEXTURE_2D);
		gl.glEnable(GL2.GL_TEXTURE_GEN_S);
		gl.glEnable(GL2.GL_TEXTURE_GEN_T);
	    gl.glTexGeni(GL2.GL_S, GL2.GL_TEXTURE_GEN_MODE, GL2.GL_OBJECT_LINEAR);
	    gl.glTexGeni(GL2.GL_T, GL2.GL_TEXTURE_GEN_MODE, GL2.GL_OBJECT_LINEAR);
	    float[] mcoef_s = {0,0,0.5f,0};
	    gl.glTexGenfv(GL2.GL_S, GL2.GL_OBJECT_PLANE, mcoef_s, 0);
	    float[] mcoef_t = {.25f,0,0,0};
	    gl.glTexGenfv(GL2.GL_T, GL2.GL_OBJECT_PLANE, mcoef_t, 0);


	    gl.glBegin(GL2.GL_QUADS);
	    //mantle bottom
	    gl.glVertex3d(21, 6, 59);
	    gl.glVertex3d(22, 6, 59);
	    gl.glVertex3d(22, 6, 43);
	    gl.glVertex3d(21, 6, 43);
	    
	    //mantle top
	    gl.glVertex3d(21, 8, 59);
	    gl.glVertex3d(22, 8, 59);
	    gl.glVertex3d(22, 8, 43);
	    gl.glVertex3d(21, 8, 43);	    
	    gl.glEnd();
	    
	    //FirePlace Floor
	    
	    bricks.bind(gl);

        gl.glBegin(GL2.GL_QUADS);
	    gl.glVertex3d(20, .105, 55);
	    gl.glVertex3d(24, .105, 55);
	    gl.glVertex3d(24, .105, 47);
	    gl.glVertex3d(20, .105, 47);	
	    
	    
	    //extensions
	    
	    gl.glVertex3d(22, .105, 55);
	    gl.glVertex3d(24, .105, 55);
	    gl.glVertex3d(24, .105, 57);
	    gl.glVertex3d(22, .105, 57);	
	    
	    gl.glVertex3d(22, .105, 45);
	    gl.glVertex3d(24, .105, 45);
	    gl.glVertex3d(24, .105, 47);
	    gl.glVertex3d(22, .105, 47);	
	    
	    
	    //under mantle
	    gl.glVertex3d(21, 5, 59);
	    gl.glVertex3d(22, 5, 59);
	    gl.glVertex3d(22, 5, 43);
	    gl.glVertex3d(21, 5, 43);
	    
	    gl.glEnd();
	    
		gl.glDisable(GL2.GL_TEXTURE_2D);
		gl.glDisable(GL2.GL_TEXTURE_GEN_S);
		gl.glDisable(GL2.GL_TEXTURE_GEN_T); 
		
		
	}
public void drawWindowFrames(GL2 gl){
		gl.glEnable(GL2.GL_TEXTURE_2D);
		gl.glEnable(GL2.GL_TEXTURE_GEN_S);
		gl.glEnable(GL2.GL_TEXTURE_GEN_T);
	    gl.glTexGeni(GL2.GL_S, GL2.GL_TEXTURE_GEN_MODE, GL2.GL_OBJECT_LINEAR);
	    gl.glTexGeni(GL2.GL_T, GL2.GL_TEXTURE_GEN_MODE, GL2.GL_OBJECT_LINEAR);
	    float[] coef_s = {0,0,.5f,0};
	    gl.glTexGenfv(GL2.GL_S, GL2.GL_OBJECT_PLANE, coef_s, 0);
	    float[] coef_t = {0,.25f,0,0};
	    gl.glTexGenfv(GL2.GL_T, GL2.GL_OBJECT_PLANE, coef_t, 0);
	    
	    paneling.bind(gl);
	    gl.glBegin(GL2.GL_QUADS);
	    
		//Front Frames
	    
	    //rightfront
	    
	    //right
	    gl.glVertex3d(37, 4, 20);
	    gl.glVertex3d(37, 4, 21);
	    gl.glVertex3d(37, 10, 21);
	    gl.glVertex3d(37, 10, 20);
	    
	    
	    //left
	    gl.glVertex3d(33, 4, 20);
	    gl.glVertex3d(33, 4, 21);
	    gl.glVertex3d(33, 10, 21);
	    gl.glVertex3d(33, 10, 20);
	    
	    
	    //top
	    gl.glVertex3d(37, 10, 20);
	    gl.glVertex3d(37, 10, 21);
	    gl.glVertex3d(33, 10, 21);
	    gl.glVertex3d(33, 10, 20);
	    
	    //bottom
	    gl.glVertex3d(37, 4, 20);
	    gl.glVertex3d(37, 4, 21);
	    gl.glVertex3d(33, 4, 21);
	    gl.glVertex3d(33, 4, 20);
	    
	    //left front
	    
	    //right
	    gl.glVertex3d(67, 4, 20);
	    gl.glVertex3d(67, 4, 21);
	    gl.glVertex3d(67, 10, 21);
	    gl.glVertex3d(67, 10, 20);
	    
	    
	    //left
	    gl.glVertex3d(63, 4, 20);
	    gl.glVertex3d(63, 4, 21);
	    gl.glVertex3d(63, 10, 21);
	    gl.glVertex3d(63, 10, 20);
	    
	    
	    //top
	    gl.glVertex3d(67, 10, 20);
	    gl.glVertex3d(67, 10, 21);
	    gl.glVertex3d(63, 10, 21);
	    gl.glVertex3d(63, 10, 20);
	    
	    //bottom
	    gl.glVertex3d(67, 4, 20);
	    gl.glVertex3d(67, 4, 21);
	    gl.glVertex3d(63, 4, 21);
	    gl.glVertex3d(63, 4, 20);
	    
	    
	    //Back Frame
	    
	    
	    //back front
	    
	    //right
	    gl.glVertex3d(37, 4, 80);
	    gl.glVertex3d(37, 4, 79);
	    gl.glVertex3d(37, 10, 79);
	    gl.glVertex3d(37, 10, 80);
	    
	    
	    //left
	    gl.glVertex3d(33, 4, 80);
	    gl.glVertex3d(33, 4, 79);
	    gl.glVertex3d(33, 10, 79);
	    gl.glVertex3d(33, 10, 80);
	    
	    
	    //top
	    gl.glVertex3d(37, 10, 80);
	    gl.glVertex3d(37, 10, 79);
	    gl.glVertex3d(33, 10, 79);
	    gl.glVertex3d(33, 10, 80);
	    
	    //bottom
	    gl.glVertex3d(37, 4, 80);
	    gl.glVertex3d(37, 4, 79);
	    gl.glVertex3d(33, 4, 79);
	    gl.glVertex3d(33, 4, 80);
	    
	    //left front
	    
	    //right
	    gl.glVertex3d(67, 4, 80);
	    gl.glVertex3d(67, 4, 79);
	    gl.glVertex3d(67, 10, 79);
	    gl.glVertex3d(67, 10, 80);
	    
	    
	    //left
	    gl.glVertex3d(63, 4, 80);
	    gl.glVertex3d(63, 4, 79);
	    gl.glVertex3d(63, 10, 79);
	    gl.glVertex3d(63, 10, 80);
	    
	    
	    //top
	    gl.glVertex3d(67, 10, 80);
	    gl.glVertex3d(67, 10, 79);
	    gl.glVertex3d(63, 10, 79);
	    gl.glVertex3d(63, 10, 80);
	    
	    //bottom
	    gl.glVertex3d(67, 4, 80);
	    gl.glVertex3d(67, 4, 79);
	    gl.glVertex3d(63, 4, 79);
	    gl.glVertex3d(63, 4, 80);
	    
	    
	    gl.glEnd();
	    
	    
		gl.glDisable(GL2.GL_TEXTURE_2D);
		gl.glDisable(GL2.GL_TEXTURE_GEN_S);
		gl.glDisable(GL2.GL_TEXTURE_GEN_T);
	}

}
