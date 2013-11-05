package buildings;
// William Ames Fall 2013  Texture Demo

import game.Building;
import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;

import com.jogamp.opengl.util.texture.Texture;

public class BaconBuilding extends Building{
    private Texture candyTexture, MnMTexture, jellyBeansTexture, candyCornTexture, gummyBearTexture;
    private BaconTable baconTable;
    private GLUquadric tableQuadric; // for Candy Corn table

    public BaconBuilding(GL2 gl, GLU glu) {  	
         
         
        MnMTexture = setupTexture(gl, "baconcandy1.jpg");
        candyTexture     = setupTexture(gl, "baconcandy2.jpg");
        jellyBeansTexture = setupTexture(gl, "baconcandy3.jpg");
        candyCornTexture = setupTexture(gl, "baconcandy4.jpg");
        gummyBearTexture = setupTexture(gl, "baconcandy5.jpg");
        
        baconTable = new BaconTable(glu);
    }

    private float frames = 0;
    public void draw(GL2 gl, GLU glu) {
        ++frames;
        gl.glEnable(GL2.GL_CULL_FACE);
                gl.glEnable(GL2.GL_TEXTURE_2D);
                
                candyCornTexture.bind(gl);
                //Table
                gl.glPushMatrix();
                gl.glTranslated(50, 0, 30);
                baconTable.draw(gl, glu);
                gl.glPopMatrix();
                
            
                //Gummy Bear painting
                gummyBearTexture.bind(gl);
                gl.glBegin(GL2.GL_QUADS);
                    // cw as viewed from front, so can be seen as ccw from back
                    gl.glTexCoord2f(0f,0f); gl.glVertex3f(74,  8, 30);
                    gl.glTexCoord2f(0f,2f); gl.glVertex3f(74, 14, 30);
                    gl.glTexCoord2f(2f,2f); gl.glVertex3f(74, 14, 20);
                    gl.glTexCoord2f(2f,0f); gl.glVertex3f(74,  8, 20);
                gl.glEnd();

                //CANDY Automatic Texturing on 	FRONT WALL
                gl.glEnable(GL2.GL_TEXTURE_2D);
            	candyTexture.bind(gl);
            	gl.glEnable(GL2.GL_TEXTURE_GEN_S);
                gl.glEnable(GL2.GL_TEXTURE_GEN_T);
                	gl.glTexGeni(GL2.GL_S, GL2.GL_TEXTURE_GEN_MODE, GL2.GL_OBJECT_LINEAR);
                	gl.glTexGeni(GL2.GL_T, GL2.GL_TEXTURE_GEN_MODE, GL2.GL_OBJECT_LINEAR);
                	float[] coef_s = {.2f,0,0,0};
                	gl.glTexGenfv(GL2.GL_S, GL2.GL_OBJECT_PLANE, coef_s, 0);
                	float[] coef_t = {0,.2f,0,0};
                	gl.glTexGenfv(GL2.GL_T, GL2.GL_OBJECT_PLANE, coef_t, 0);
                	gl.glBegin(GL2.GL_QUADS);
                    	gl.glVertex3f( 25,  0, 50);
                    	gl.glVertex3f(45,  0, 50);
                    	gl.glVertex3f(45, 10, 50);
                    	gl.glVertex3f(25, 10, 50);
                    
                    	gl.glVertex3f(55,  0, 50);
                    	gl.glVertex3f(75,  0, 50);
                    	gl.glVertex3f(75, 10, 50);
                    	gl.glVertex3f(55, 10, 50);
                    
                    	gl.glVertex3f(25,  10, 50);
                    	gl.glVertex3f(75, 10, 50);
                    	gl.glVertex3f(75, 30, 50);
                    	gl.glVertex3f(25, 30, 50);
                    
                    gl.glEnd();
                gl.glDisable(GL2.GL_TEXTURE_2D);
                gl.glDisable(GL2.GL_TEXTURE_GEN_S);
                gl.glDisable(GL2.GL_TEXTURE_GEN_T);
                
                
                //Manual Texturing
                gl.glEnable(GL2.GL_TEXTURE_2D); 
                
                //BACK WALL!!
                //Left of back door
                MnMTexture.bind(gl);
                gl.glBegin(GL2.GL_QUADS);
                    // cw as viewed from front, so can be seen as ccw from back
                    gl.glTexCoord2f(0f,0f); gl.glVertex3f(25,  0, 50);
                    gl.glTexCoord2f(0f,2f); gl.glVertex3f(25, 10, 50);
                    gl.glTexCoord2f(2f,2f); gl.glVertex3f(45, 10, 50);
                    gl.glTexCoord2f(2f,0f); gl.glVertex3f(45,  0, 50);
                gl.glEnd();
                
                //Right of back door
                MnMTexture.bind(gl);
                gl.glBegin(GL2.GL_QUADS);
                    // cw as viewed from front, so can be seen as ccw from back
                    gl.glTexCoord2f(0f,0f); gl.glVertex3f(55,  0, 50);
                    gl.glTexCoord2f(0f,2f); gl.glVertex3f(55, 10, 50);
                    gl.glTexCoord2f(2f,2f); gl.glVertex3f(75, 10, 50);
                    gl.glTexCoord2f(2f,0f); gl.glVertex3f(75,  0, 50);
                gl.glEnd();
                
                //Top of back wall
                MnMTexture.bind(gl);
                gl.glBegin(GL2.GL_QUADS);
                    // cw as viewed from front, so can be seen as ccw from back
                    gl.glTexCoord2f(0f,0f); gl.glVertex3f(25,  10, 50);
                    gl.glTexCoord2f(0f,3f); gl.glVertex3f(25, 30, 50);
                    gl.glTexCoord2f(5f,3f); gl.glVertex3f(75, 30, 50);
                    gl.glTexCoord2f(5f,0f); gl.glVertex3f(75,  10, 50);
                gl.glEnd();                   
                
                //RIGHT WALL
                MnMTexture.bind(gl);
                gl.glBegin(GL2.GL_QUADS);
                    // cw as viewed from front, so can be seen as ccw from back
                    gl.glTexCoord2f(0f,0f); gl.glVertex3f(75,  0, 50);
                    gl.glTexCoord2f(0f,3f); gl.glVertex3f(75, 30, 50);
                    gl.glTexCoord2f(5f,3f); gl.glVertex3f(75, 30, 0);
                    gl.glTexCoord2f(5f,0f); gl.glVertex3f(75,  0, 0);
                gl.glEnd();                   
            	candyTexture.bind(gl);
                gl.glBegin(GL2.GL_QUADS);
                    // ccw as viewed from front
                	gl.glTexCoord2f(0f,0f); gl.glVertex3f(75, 0, 0);
                	gl.glTexCoord2f(3f,0f); gl.glVertex3f(75, 30, 0);
                    gl.glTexCoord2f(3f,2f); gl.glVertex3f(75,  30, 50);
                    gl.glTexCoord2f(0f,2f); gl.glVertex3f(75,  0, 50);
                gl.glEnd();
                
                //LEFT WALL
                candyTexture.bind(gl);
                gl.glBegin(GL2.GL_QUADS);
                    gl.glTexCoord2f(0f,0f); gl.glVertex3f(25, 0, 50);
                    gl.glTexCoord2f(0f,3f); gl.glVertex3f(25, 30, 50);
                    gl.glTexCoord2f(5f,3f); gl.glVertex3f(25, 30, 0);
                    gl.glTexCoord2f(5f,0f); gl.glVertex3f(25, 0, 0);
                gl.glEnd();                   
                MnMTexture.bind(gl);
                gl.glBegin(GL2.GL_QUADS);
                    gl.glTexCoord2f(0f,3f); gl.glVertex3f(25,  0, 50);
                    gl.glTexCoord2f(4f,3f); gl.glVertex3f(25, 0, 0);
                    gl.glTexCoord2f(4f,0f); gl.glVertex3f(25, 30, 0);
                    gl.glTexCoord2f(0f,0f); gl.glVertex3f(25,  30, 50);
                gl.glEnd();
                
                
                //BACK WALL!
                //Left of front door
                candyTexture.bind(gl);
                gl.glBegin(GL2.GL_QUADS);
                    gl.glTexCoord2f(0f,0f); gl.glVertex3f(25,  0, 0);
                    gl.glTexCoord2f(0f,2f); gl.glVertex3f(25, 10, 0);
                    gl.glTexCoord2f(2f,2f); gl.glVertex3f(45, 10, 0);
                    gl.glTexCoord2f(2f,0f); gl.glVertex3f(45,  0, 0);
                gl.glEnd();
            	MnMTexture.bind(gl);
                gl.glBegin(GL2.GL_QUADS);
                    gl.glTexCoord2f(0f,1f); gl.glVertex3f(25,  0, 0);
                    gl.glTexCoord2f(1f,1f); gl.glVertex3f(45,  0, 0);
                    gl.glTexCoord2f(1f,0f); gl.glVertex3f(45, 10, 0);
                    gl.glTexCoord2f(0f,0f); gl.glVertex3f(25, 10, 0);
                gl.glEnd();
                
                //Right of front door
                candyTexture.bind(gl);
                gl.glBegin(GL2.GL_QUADS);
                    gl.glTexCoord2f(0f,0f); gl.glVertex3f(55,  0, 0);
                    gl.glTexCoord2f(0f,2f); gl.glVertex3f(55, 10, 0);
                    gl.glTexCoord2f(2f,2f); gl.glVertex3f(75, 10, 0);
                    gl.glTexCoord2f(2f,0f); gl.glVertex3f(75,  0, 0);
                gl.glEnd();
            	MnMTexture.bind(gl);
                gl.glBegin(GL2.GL_QUADS);
                    gl.glTexCoord2f(0f,1f); gl.glVertex3f(55,  0, 0);
                    gl.glTexCoord2f(1f,1f); gl.glVertex3f(75,  0, 0);
                    gl.glTexCoord2f(1f,0f); gl.glVertex3f(75, 10, 0);
                    gl.glTexCoord2f(0f,0f); gl.glVertex3f(55, 10, 0);
                gl.glEnd();
                
                //Top of back wall
                candyTexture.bind(gl);
                gl.glBegin(GL2.GL_QUADS);
                    // cw as viewed from front, so can be seen as ccw from back
                    gl.glTexCoord2f(0f,0f); gl.glVertex3f(25,  10, 0);
                    gl.glTexCoord2f(0f,3f); gl.glVertex3f(25, 30, 0);
                    gl.glTexCoord2f(5f,3f); gl.glVertex3f(75, 30, 0);
                    gl.glTexCoord2f(5f,0f); gl.glVertex3f(75,  10, 0);
                gl.glEnd();                   
            	MnMTexture.bind(gl);
                gl.glBegin(GL2.GL_QUADS);
                    // ccw as viewed from front
                    gl.glTexCoord2f(0f,2f); gl.glVertex3f(25,  10, 0);
                    gl.glTexCoord2f(3f,2f); gl.glVertex3f(75,  10, 0);
                    gl.glTexCoord2f(3f,0f); gl.glVertex3f(75, 30, 0);
                    gl.glTexCoord2f(0f,0f); gl.glVertex3f(25, 30, 0);
                gl.glEnd();               
                
                //MNM CIELING
                MnMTexture.bind(gl);
                gl.glBegin(GL2.GL_QUADS);
            	gl.glTexCoord2f(0f, 4f); gl.glVertex3f(25,30,50);
            	gl.glTexCoord2f(4f, 4f); gl.glVertex3f(25,30,0);
            	gl.glTexCoord2f(4f, 0f); gl.glVertex3f(75,30,0);
                gl.glTexCoord2f(0f, 0f); gl.glVertex3f(75,30,50);
                gl.glEnd();
                candyTexture.bind(gl);
                gl.glBegin(GL2.GL_QUADS);
            	gl.glTexCoord2f(0f, 8f); gl.glVertex3f(25,30,50);
            	gl.glTexCoord2f(8f, 8f); gl.glVertex3f(75,30,50);
            	gl.glTexCoord2f(8f, 0f); gl.glVertex3f(75,30,0);
                gl.glTexCoord2f(0f, 0f); gl.glVertex3f(25,30,0);
                gl.glEnd();

        
        //Jelly bean plain (floor)
        jellyBeansTexture.bind(gl);
        gl.glBegin(GL2.GL_QUADS);
    	gl.glTexCoord2f(20f, 20f); gl.glVertex3f(0,0,100);
    	gl.glTexCoord2f(20f, 0f); gl.glVertex3f(100,0,100);
    	gl.glTexCoord2f(0f, 20f); gl.glVertex3f(100,0,0);
        gl.glTexCoord2f(0f, 0f); gl.glVertex3f(0,0,0);
        gl.glEnd();
            
            gl.glDisable(GL2.GL_TEXTURE_2D);
            
        gl.glDisable(GL2.GL_CULL_FACE);
   }
}