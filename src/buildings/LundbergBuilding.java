package buildings;
import game.Building;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;

import com.jogamp.opengl.util.texture.Texture;

public class LundbergBuilding extends Building {
    private GLUquadric quadric2; 
    private Texture grassTexture;     
    private Texture woodTexture;  
    private Texture blueBrickTexture;
    private Texture beigeBrickTexture;
 
    private Texture fireplace,window, fishes;
    
    
   
    // Read gif, jpg, png, or tiff file (or a few other less common ones)
    // *** MUST BE A POWER OF 2 IN EACH DIRECTION ***
 

    public LundbergBuilding(GL2 gl, GLU glu) {
    	/*
        sphereQuadric = glu.gluNewQuadric();
        glu.gluQuadricDrawStyle(sphereQuadric, GLU.GLU_FILL); // GLU_POINT, GLU_LINE, GLU_FILL, GLU_SILHOUETTE
        glu.gluQuadricNormals  (sphereQuadric, GLU.GLU_NONE); // GLU_NONE, GLU_FLAT, or GLU_SMOOTH
        glu.gluQuadricTexture  (sphereQuadric, false);        // use true to generate texture coordinates
*/
        quadric2 = glu.gluNewQuadric();
        glu.gluQuadricDrawStyle(quadric2, GLU.GLU_FILL);
        glu.gluQuadricNormals  (quadric2, GLU.GLU_NONE);
        glu.gluQuadricTexture  (quadric2, false); // for table legs

        grassTexture = setupTexture(gl,"FallGrass.jpg");
        woodTexture = setupTexture(gl,"WornWood.jpg");
        //smallBrickTexture=setupTexture(gl,"SmallBrick.jpg");
        blueBrickTexture=setupTexture(gl,"BlueBrick.jpg");
        beigeBrickTexture=setupTexture(gl,"BeigeBrick.jpg");
        window=setupTexture(gl,"window.jpg");
        fireplace=setupTexture(gl,"fireplace.jpg");
        fishes=setupTexture(gl,"aquariumTank.jpg");
    }
    

    //private float angle=0;
    float frames=0;
    public void draw(GL2 gl, GLU glu) {
         //glu.gluSphere(quadric1,  radius, slices, stacks)
        // glu.gluCylinder quadric, base, top, height, slices, stacks)
        // glu.gluDisk(quadric, inner radius, outer radius, slices, stacks)

    	
        //gl.glColor3f(.5f, 0, .5f);
    	
    	///table legs
     gl.glEnable(GL2.GL_TEXTURE_2D);
    	woodTexture.bind(gl);
        gl.glPushMatrix();
            gl.glRotatef(-90f, 1f, 0f, 0f); // stand upright (Y)
            //left back leg
            gl.glTranslated(52,-82,0);
            glu.gluCylinder(quadric2, .1, .1, 3., 10, 10);
     
            //left front
            gl.glTranslated(0,-5,0);
            glu.gluCylinder(quadric2, .1, .1, 3., 10, 10);
            //right back
            gl.glTranslated(5,5,0);
            glu.gluCylinder(quadric2, .1, .1, 3., 10, 10);
            
            //right front
            gl.glTranslated(0,-5,0);
            glu.gluCylinder(quadric2, .1, .1, 3., 10, 10);
            
            
            
            //glu.gluDisk(quadric2, 1.5, 2., 10, 5); // also to be flipped
            //gl.glTranslated(0,, 0)
        gl.glPopMatrix();
        gl.glDisable(GL2.GL_TEXTURE_2D);
        
      //wood top of table
        gl.glEnable(GL2.GL_TEXTURE_2D);
        
        woodTexture.bind(gl);
        
        gl.glBegin(GL2.GL_QUADS);
            gl.glTexCoord2f(0f,2f); gl.glVertex3d(50,  3, 82);
            gl.glTexCoord2f(2f,2f); gl.glVertex3d( 58,  3, 82);
            gl.glTexCoord2f(0f,0f); gl.glVertex3d(58, 3, 88);
            gl.glTexCoord2f(2f,0f); gl.glVertex3d( 50, 3, 88);
        gl.glEnd();
    gl.glDisable(GL2.GL_TEXTURE_2D);
        
        
/*
        // the Bulb
        gl.glEnable(GL2.GL_TEXTURE_2D);
            fishesTexture.bind(gl);
            gl.glPushMatrix();
                gl.glTranslatef(0, 5, 0); // 5 feet off of ground
                angle += 4;
                gl.glRotatef(angle, 0,1,0); // spin his head
                glu.gluSphere(sphereQuadric, 1., 10, 10);
            gl.glPopMatrix();
        gl.glDisable(GL2.GL_TEXTURE_2D);
*/
        // now, a textured grass land
        gl.glEnable(GL2.GL_TEXTURE_2D);
            grassTexture.bind(gl);
            gl.glBegin(GL2.GL_QUADS);
                gl.glTexCoord2f(0f,2f); gl.glVertex3f(0,  0, 0);
                gl.glTexCoord2f(3f,2f); gl.glVertex3f( 0,  0, 100);
                gl.glTexCoord2f(3f,0f); gl.glVertex3f( 100, 0, 100);
                gl.glTexCoord2f(0f,0f); gl.glVertex3f(100, 0, 0);
            gl.glEnd();
        gl.glDisable(GL2.GL_TEXTURE_2D);
        
        //wood floor of house
        gl.glEnable(GL2.GL_TEXTURE_2D);
        
        woodTexture.bind(gl);
        
        gl.glBegin(GL2.GL_QUADS);
            gl.glTexCoord2f(0f,2f); gl.glVertex3d(40,  0.1, 90);
            gl.glTexCoord2f(3f,2f); gl.glVertex3d( 40,  0.1, 80);
            gl.glTexCoord2f(3f,0f); gl.glVertex3d( 60, 0.1, 80);
            gl.glTexCoord2f(0f,0f); gl.glVertex3d(60, 0.1, 90);
        gl.glEnd();
    gl.glDisable(GL2.GL_TEXTURE_2D);
    
    //windows
    gl.glEnable(GL2.GL_TEXTURE_2D);
    window.bind(gl);
    gl.glBegin(GL2.GL_QUADS);
        gl.glTexCoord2f(0f,1f); gl.glVertex3d(45,  5, 90.01);
        gl.glTexCoord2f(1f,1f); gl.glVertex3d( 45,  7, 90.01);
        gl.glTexCoord2f(1f,0f); gl.glVertex3d( 47,7, 90.01);
        gl.glTexCoord2f(0f,0f); gl.glVertex3d(47, 5, 90.01);
        
        gl.glTexCoord2f(0f,1f); gl.glVertex3d(54,  5, 90.01);
        gl.glTexCoord2f(1f,1f); gl.glVertex3d( 54,  7, 90.01);
        gl.glTexCoord2f(0f,1f); gl.glVertex3d( 56,7, 90.01);
        gl.glTexCoord2f(0f,0f); gl.glVertex3d(56, 5, 90.01);
    gl.glEnd();
gl.glDisable(GL2.GL_TEXTURE_2D);

//Fish Tank
gl.glEnable(GL2.GL_TEXTURE_2D);
fishes.bind(gl);
gl.glBegin(GL2.GL_QUADS);
//left tank wall
    gl.glTexCoord2f(1f,1f); gl.glVertex3d(52,  3, 87);
    gl.glTexCoord2f(1f,0f); gl.glVertex3d( 52, 6, 87);
    gl.glTexCoord2f(0f,0f); gl.glVertex3d( 52, 6, 83);
    gl.glTexCoord2f(0f,1f); gl.glVertex3d(52, 3, 83);
    //back wall
    gl.glTexCoord2f(1f,1f); gl.glVertex3d(52,  3, 83);
    gl.glTexCoord2f(1f,0f); gl.glVertex3d( 52,  6, 83);
    gl.glTexCoord2f(0f,0f); gl.glVertex3d( 56,6, 83);
    gl.glTexCoord2f(0f,1f); gl.glVertex3d(56, 3, 83);
  //front wall
    gl.glTexCoord2f(1f,1f); gl.glVertex3d(52,  3, 87);
    gl.glTexCoord2f(1f,0f); gl.glVertex3d( 52,  6, 87);
    gl.glTexCoord2f(0f,0f); gl.glVertex3d( 56,6, 87);
    gl.glTexCoord2f(0f,1f); gl.glVertex3d(56, 3, 87);
    
  //right tank wall
    gl.glTexCoord2f(1f,1f); gl.glVertex3d(56,  3, 87);
    gl.glTexCoord2f(1f,0f); gl.glVertex3d( 56, 6, 87);
    gl.glTexCoord2f(0f,0f); gl.glVertex3d( 56, 6, 83);
    gl.glTexCoord2f(0f,1f); gl.glVertex3d(56, 3, 83);
gl.glEnd();
gl.glDisable(GL2.GL_TEXTURE_2D);


//fireplace
gl.glEnable(GL2.GL_TEXTURE_2D);
fireplace.bind(gl);
gl.glBegin(GL2.GL_QUADS);
    gl.glTexCoord2f(1f,1f); gl.glVertex3d(40.1,  0, 83);
    gl.glTexCoord2f(1f,0f); gl.glVertex3d( 40.1,  5, 83);
    gl.glTexCoord2f(0f,0f); gl.glVertex3d( 40.1,5, 88);
    gl.glTexCoord2f(0f,1f); gl.glVertex3d(40.1, 0, 88);

gl.glEnd();
gl.glDisable(GL2.GL_TEXTURE_2D);
    
        //++frames;
        gl.glEnable(GL2.GL_CULL_FACE);
           // gl.glPushMatrix();
                //gl.glRotatef(frames*2, 0,1,0);
        // draw walls of house
        
        //inside walls
        gl.glEnable(GL2.GL_TEXTURE_2D);
        blueBrickTexture.bind(gl);
        gl.glBegin(GL2.GL_QUADS);
        //left side panel of house
            gl.glTexCoord2f(0f,2f); gl.glVertex3f(40,  0, 80);
            gl.glTexCoord2f(3f,2f); gl.glVertex3f( 40,  10, 80);
            gl.glTexCoord2f(3f,0f); gl.glVertex3f( 40, 10, 90);
            gl.glTexCoord2f(0f,0f); gl.glVertex3f(40, 0, 90);
            
            //right side panel of house
            gl.glTexCoord2f(0f,2f); gl.glVertex3f(60,  0, 80);
            gl.glTexCoord2f(0f,0f); gl.glVertex3f(60, 0, 90);
            gl.glTexCoord2f(3f,0f); gl.glVertex3f( 60, 10, 90);
            gl.glTexCoord2f(3f,2f); gl.glVertex3f( 60,  10, 80);
            
           /* 
          //back panel of house
            gl.glTexCoord2f(0f,0f); gl.glVertex3f(60, 0, 80);
            gl.glTexCoord2f(3f,0f); gl.glVertex3f( 60, 10, 80);
            gl.glTexCoord2f(3f,2f); gl.glVertex3f( 40,  10, 80);
            gl.glTexCoord2f(0f,2f); gl.glVertex3f(40,  0, 80);
            */
            //front panel of house;left panel of doorway
            gl.glTexCoord2f(0f,2f); gl.glVertex3f(40,  0, 90);
            gl.glTexCoord2f(3f,2f); gl.glVertex3f( 40,  10, 90);
            gl.glTexCoord2f(3f,0f); gl.glVertex3f( 49, 10, 90);
            gl.glTexCoord2f(0f,0f); gl.glVertex3f(49, 0, 90);
           
            //front panel of house;middle panel of doorway
            gl.glTexCoord2f(0f,2f); gl.glVertex3f(49,  5, 90);
            gl.glTexCoord2f(3f,2f); gl.glVertex3f( 49,  10, 90);
            gl.glTexCoord2f(3f,0f); gl.glVertex3f( 52, 10, 90);
            gl.glTexCoord2f(0f,0f); gl.glVertex3f(52, 5, 90);
            
            //front panel of house;right panel of doorway
            gl.glTexCoord2f(0f,2f); gl.glVertex3f(52,  0, 90);
            gl.glTexCoord2f(3f,2f); gl.glVertex3f( 52,  10, 90);
            gl.glTexCoord2f(3f,0f); gl.glVertex3f( 60, 10, 90);
            gl.glTexCoord2f(0f,0f); gl.glVertex3f(60, 0, 90);
            
            //BACK PANEL
            ///back panel of house;left panel of doorway
            gl.glTexCoord2f(0f,2f); gl.glVertex3f(40,  0, 80);
            gl.glTexCoord2f(0f,0f); gl.glVertex3f(49, 0, 80);
            gl.glTexCoord2f(3f,0f); gl.glVertex3f( 49, 10, 80);
            gl.glTexCoord2f(3f,2f); gl.glVertex3f( 40,  10, 80);
           
            //back panel of house;middle panel of doorway
            gl.glTexCoord2f(0f,1f); gl.glVertex3f(49,  5, 80);
            gl.glTexCoord2f(0f,0f); gl.glVertex3f(52, 5, 80);
            gl.glTexCoord2f(2f,0f); gl.glVertex3f( 52, 10, 80);
            gl.glTexCoord2f(2f,1f); gl.glVertex3f( 49,  10, 80);
            
            //back panel of house;right panel of doorway
            gl.glTexCoord2f(0f,2f); gl.glVertex3f(52,  0, 80);
            gl.glTexCoord2f(0f,0f); gl.glVertex3f(60, 0, 80);
            gl.glTexCoord2f(3f,0f); gl.glVertex3f( 60, 10, 80);
            gl.glTexCoord2f(3f,2f); gl.glVertex3f( 52,  10, 80);
            
        gl.glEnd();
        
       //inside 
        beigeBrickTexture.bind(gl);
         gl.glBegin(GL2.GL_QUADS);
                        // cw as viewed from front, so can be seen as ccw from back
        //left side panel of house
        gl.glTexCoord2f(0f,2f); gl.glVertex3f(40,  0, 80);
        gl.glTexCoord2f(0f,0f); gl.glVertex3f(40, 0, 90);
        gl.glTexCoord2f(3f,0f); gl.glVertex3f( 40, 10, 90);
        gl.glTexCoord2f(3f,2f); gl.glVertex3f( 40,  10, 80);
        
       
        
      //right side panel of house
        gl.glTexCoord2f(0f,2f); gl.glVertex3f(60,  0, 80);
        gl.glTexCoord2f(3f,2f); gl.glVertex3f( 60,  10, 80);
        gl.glTexCoord2f(3f,0f); gl.glVertex3f( 60, 10, 90);
        gl.glTexCoord2f(0f,0f); gl.glVertex3f(60, 0, 90);
        
        /*
        //back panel of house
        gl.glTexCoord2f(0f,2f); gl.glVertex3f(40,  0, 80);
        gl.glTexCoord2f(3f,2f); gl.glVertex3f( 40,  10, 80);
        gl.glTexCoord2f(3f,0f); gl.glVertex3f( 60, 10, 80);
        gl.glTexCoord2f(0f,0f); gl.glVertex3f(60, 0, 80);
        */
        
        //front panel of house;left panel of doorway
        gl.glTexCoord2f(0f,2f); gl.glVertex3f(40,  0, 90);
        gl.glTexCoord2f(0f,0f); gl.glVertex3f(49, 0, 90);
        gl.glTexCoord2f(3f,0f); gl.glVertex3f( 49, 10, 90);
        gl.glTexCoord2f(3f,2f); gl.glVertex3f( 40,  10, 90);
       
        //front panel of house;middle panel of doorway
        gl.glTexCoord2f(0f,1f); gl.glVertex3f(49,  5, 90);
        gl.glTexCoord2f(0f,0f); gl.glVertex3f(52, 5, 90);
        gl.glTexCoord2f(2f,0f); gl.glVertex3f( 52, 10, 90);
        gl.glTexCoord2f(2f,1f); gl.glVertex3f( 49,  10, 90);
        
        //front panel of house;right panel of doorway
        gl.glTexCoord2f(0f,2f); gl.glVertex3f(52,  0, 90);
        gl.glTexCoord2f(0f,0f); gl.glVertex3f(60, 0, 90);
        gl.glTexCoord2f(3f,0f); gl.glVertex3f( 60, 10, 90);
        gl.glTexCoord2f(3f,2f); gl.glVertex3f( 52,  10, 90);
        
        
        
        //BACK PANEL
        //back panel of house;left panel of doorway
        gl.glTexCoord2f(0f,2f); gl.glVertex3f(40,  0, 80);
        gl.glTexCoord2f(3f,2f); gl.glVertex3f( 40,  10, 80);
        gl.glTexCoord2f(3f,0f); gl.glVertex3f( 49, 10, 80);
        gl.glTexCoord2f(0f,0f); gl.glVertex3f(49, 0, 80);
       
        //back panel of house;middle panel of doorway
        gl.glTexCoord2f(0f,2f); gl.glVertex3f(49,  5, 80);
        gl.glTexCoord2f(3f,2f); gl.glVertex3f( 49,  10, 80);
        gl.glTexCoord2f(3f,0f); gl.glVertex3f( 52, 10, 80);
        gl.glTexCoord2f(0f,0f); gl.glVertex3f(52, 5, 80);
        
        //back panel of house;right panel of doorway
        gl.glTexCoord2f(0f,2f); gl.glVertex3f(52,  0, 80);
        gl.glTexCoord2f(3f,2f); gl.glVertex3f( 52,  10, 80);
        gl.glTexCoord2f(3f,0f); gl.glVertex3f( 60, 10, 80);
        gl.glTexCoord2f(0f,0f); gl.glVertex3f(60, 0, 80);
        gl.glEnd();
        gl.glDisable(GL2.GL_TEXTURE_2D);
        //gl.glPopMatrix();
        
        gl.glDisable(GL2.GL_CULL_FACE);
        
        
        //roof
     // another wall, using automatic texture generation
        gl.glEnable(GL2.GL_TEXTURE_2D);
        woodTexture.bind(gl);
        gl.glEnable(GL2.GL_TEXTURE_GEN_S);
        gl.glEnable(GL2.GL_TEXTURE_GEN_T);
            gl.glTexGeni(GL2.GL_S, GL2.GL_TEXTURE_GEN_MODE, GL2.GL_OBJECT_LINEAR);
            gl.glTexGeni(GL2.GL_T, GL2.GL_TEXTURE_GEN_MODE, GL2.GL_OBJECT_LINEAR);
            float[] coef_s = {.5f,0,0,0};
            gl.glTexGenfv(GL2.GL_S, GL2.GL_OBJECT_PLANE, coef_s, 0);
            float[] coef_t = {0,.25f,0,0};
            gl.glTexGenfv(GL2.GL_T, GL2.GL_OBJECT_PLANE, coef_t, 0);
            gl.glBegin(GL2.GL_TRIANGLES);
            
            //left triangle
        	 gl.glVertex3f(40,  10, 80);
        	 gl.glVertex3f(40,  10, 90);
        	 gl.glVertex3f(50,  20, 85);
        	
        //right triangle
        	 gl.glVertex3f(60,  10, 80);
        	 gl.glVertex3f(60,  10, 90);
        	 gl.glVertex3f(50,  20, 85);
        	
        //front triangle
        	 gl.glVertex3f(40,  10, 90);
        	 gl.glVertex3f(60,  10, 90);
        	 gl.glVertex3f(50,  20, 85);
        	
        	 //back triangle
        	 gl.glVertex3f(40,  10, 80);
        	 gl.glVertex3f(60,  10, 80);
        	 gl.glVertex3f(50,  20, 85);
        	 
            gl.glEnd();
        gl.glDisable(GL2.GL_TEXTURE_2D);
        gl.glDisable(GL2.GL_TEXTURE_GEN_S);
        gl.glDisable(GL2.GL_TEXTURE_GEN_T);
        
        
       /*
        gl.glEnable(GL2.GL_TEXTURE_2D);
        blueBrickTexture.bind(gl);
        gl.glBegin(GL2.GL_TRIANGLES);
        
        /*
        //left triangle
        	gl.glTexCoord2f(0f,2f); gl.glVertex3f(40,  10, 80);
        	gl.glTexCoord2f(0f,2f); gl.glVertex3f(40,  10, 90);
        	gl.glTexCoord2f(0f,0f); gl.glVertex3f(50,  15, 85);
        //right triangle
        	gl.glTexCoord2f(0f,2f); gl.glVertex3f(60,  10, 80);
        	gl.glTexCoord2f(0f,2f); gl.glVertex3f(60,  10, 90);
        	gl.glTexCoord2f(0f,0f); gl.glVertex3f(50,  15, 85);
        	
        //front triangle
        	gl.glTexCoord2f(0f,2f); gl.glVertex3f(40,  10, 90);
        	gl.glTexCoord2f(0f,2f); gl.glVertex3f(60,  10, 90);
        	gl.glTexCoord2f(0f,0f); gl.glVertex3f(50,  15, 85);
        	
        	gl.glTexCoord2f(0f,2f); gl.glVertex3f(40,  10, 80);
        	gl.glTexCoord2f(0f,2f); gl.glVertex3f(60,  10, 80);
        	gl.glTexCoord2f(0f,0f); gl.glVertex3f(50,  15, 85);
        	
        gl.glEnd();
    gl.glDisable(GL2.GL_TEXTURE_2D);
        
*/
   }
}