package buildings;
import game.Building;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;

import com.jogamp.opengl.util.texture.Texture;

public class ParkBuilding extends Building {
	private Texture ParkWoodWall;
	private Texture ParkGrass;
	private Texture ParkInsideWall;
	private Texture ParkBuildingFloor;
	private Texture ParkRoofOutside;
	private Texture ParkBasketballTexture;
	private Texture ParkBasketballNet;
	private GLUquadric quadric;
	private GLUquadric netQuadric;
	
	public ParkBuilding(GL2 gl, GLU glu) {
		ParkWoodWall = setupTexture(gl, "ParkOutsideWall.jpg");
		ParkGrass = setupTexture(gl, "ParkGrass.jpg");
		ParkInsideWall = setupTexture(gl, "ParkInsideWall.jpg");
		ParkRoofOutside = setupTexture(gl, "ParkRoof.jpg");
		ParkBuildingFloor = setupTexture(gl,"ParkHardWoodFloor.jpg");
		ParkBasketballTexture = setupTexture(gl, "ParkBasketballTexture.jpg");
		ParkBasketballNet = setupTexture(gl, "ParkBasketballNet.jpg");
		quadric = glu.gluNewQuadric();
		glu.gluQuadricDrawStyle(quadric, GLU.GLU_FILL); // GLU_POINT, GLU_LINE, GLU_FILL, GLU_SILHOUETTE
        glu.gluQuadricNormals  (quadric, GLU.GLU_NONE); // GLU_NONE, GLU_FLAT, or GLU_SMOOTH
        glu.gluQuadricTexture  (quadric, true);        // false, or true to generate texture coordinates
        netQuadric = glu.gluNewQuadric();
        glu.gluQuadricDrawStyle(netQuadric, GLU.GLU_FILL); // GLU_POINT, GLU_LINE, GLU_FILL, GLU_SILHOUETTE
        glu.gluQuadricNormals  (netQuadric, GLU.GLU_NONE); // GLU_NONE, GLU_FLAT, or GLU_SMOOTH
        glu.gluQuadricTexture  (netQuadric, true);        // false, or true to generate texture coordinates
	}
	
	public void draw(GL2 gl, GLU glu) {
		gl.glEnable(GL2.GL_TEXTURE_2D);
			//Grass (Ground) 100x100 plot of land
			ParkGrass.bind(gl);
			gl.glBegin(GL2.GL_QUADS);
				gl.glTexCoord2f(50f,60f); gl.glVertex3f(0, 0, 0);
				gl.glTexCoord2f(60f,60f); gl.glVertex3f(100, 0, 0);
				gl.glTexCoord2f(60f,50f); gl.glVertex3f(100, 0, 100);
				gl.glTexCoord2f(50f,50f); gl.glVertex3f(0, 0, 100);
			gl.glEnd();
			//Building Floor
			ParkBuildingFloor.bind(gl);
			gl.glBegin(GL2.GL_QUADS);
				gl.glTexCoord2f(2f,3f); gl.glVertex3f(30, (float) 0.01, 30);
				gl.glTexCoord2f(4f,3f); gl.glVertex3f(70, (float) 0.01, 30);
				gl.glTexCoord2f(4f,5f); gl.glVertex3f(70, (float) 0.01, 70);
				gl.glTexCoord2f(2f,5f); gl.glVertex3f(30, (float) 0.01, 70);
			gl.glEnd();
		gl.glDisable(GL2.GL_TEXTURE_2D);
        
		
		
		
		
		gl.glEnable(GL2.GL_TEXTURE_2D);
        gl.glEnable(GL2.GL_TEXTURE_GEN_S);
        gl.glEnable(GL2.GL_TEXTURE_GEN_T);
            gl.glTexGeni(GL2.GL_S, GL2.GL_TEXTURE_GEN_MODE, GL2.GL_OBJECT_LINEAR);
            gl.glTexGeni(GL2.GL_T, GL2.GL_TEXTURE_GEN_MODE, GL2.GL_OBJECT_LINEAR);
            float[] coef_s = {0.25f,0,0.25f,0};
            gl.glTexGenfv(GL2.GL_S, GL2.GL_OBJECT_PLANE, coef_s, 0);
            float[] coef_t = {0,0.25f,0,0};
            gl.glTexGenfv(GL2.GL_T, GL2.GL_OBJECT_PLANE, coef_t, 0);
            gl.glEnable(GL2.GL_CULL_FACE);
                gl.glEnable(GL2.GL_TEXTURE_2D);
                    ParkInsideWall.bind(gl);
                    //Front Wall Inside: Right of Door
                    gl.glBegin(GL2.GL_QUADS);
                        gl.glVertex3f(30, 0, 30);
                        gl.glVertex3f(48, 0, 30);
                        gl.glVertex3f(48, 20, 30);
                        gl.glVertex3f(30, 20, 30);
                    gl.glEnd();
                    //Front Wall Inside: Left of Door
                    gl.glBegin(GL2.GL_QUADS);
                        gl.glVertex3f(52, 0, 30);
                        gl.glVertex3f(70, 0, 30);
                        gl.glVertex3f(70, 20, 30);
                        gl.glVertex3f(52, 20, 30);
                    gl.glEnd();
                    //Front Wall Inside: Right of Door
                    gl.glBegin(GL2.GL_QUADS);
                        gl.glVertex3f(48, 7, 30);
                        gl.glVertex3f(52, 7, 30);
                        gl.glVertex3f(52, 20, 30);
                        gl.glVertex3f(48, 20, 30);
                    gl.glEnd();
                    //Right Wall Inside
                    gl.glBegin(GL2.GL_QUADS);
                		gl.glVertex3f(30, 0, 30);
                		gl.glVertex3f(30, 20, 30);
                		gl.glVertex3f(30, 20, 70);
                		gl.glVertex3f(30, 0, 70);
                	gl.glEnd();
                	//Left Wall Inside
                	gl.glBegin(GL2.GL_QUADS);
                		gl.glVertex3f(70, 0, 30);
                		gl.glVertex3f(70, 0, 70);
                		gl.glVertex3f(70, 20, 70);
                		gl.glVertex3f(70, 20, 30);
                	gl.glEnd();
                	//Back Wall Inside: Right of Door
                	gl.glBegin(GL2.GL_QUADS);
                		gl.glVertex3f(30, 0, 70);
                		gl.glVertex3f(30, 20, 70);
                		gl.glVertex3f(48, 20, 70);
                		gl.glVertex3f(48, 0, 70);
                    gl.glEnd();
                    //Back Wall Inside: Top of Door
                	gl.glBegin(GL2.GL_QUADS);
                		gl.glVertex3f(48, 7, 70);
                		gl.glVertex3f(48, 20, 70);
                		gl.glVertex3f(52, 20, 70);
                		gl.glVertex3f(52, 7, 70);
                    gl.glEnd();
                    //Back Wall Inside: Left of Door
                	gl.glBegin(GL2.GL_QUADS);
                		gl.glVertex3f(52, 0, 70);
                		gl.glVertex3f(52, 20, 70);
                		gl.glVertex3f(70, 20, 70);
                		gl.glVertex3f(70, 0, 70);
                    gl.glEnd();
                    
                    ParkRoofOutside.bind(gl);
                    //Front Roof Triangle: Inside
            		gl.glBegin(GL2.GL_TRIANGLES);
            			gl.glVertex3f(30, 20, 30);
            			gl.glVertex3f(70, 20, 30);
            			gl.glVertex3f(50, 30, 30);
            		gl.glEnd();
            		//Front Roof Triangle: Outside
            		gl.glBegin(GL2.GL_TRIANGLES);
        				gl.glVertex3f(30, 20, 30);
        				gl.glVertex3f(50, 30, 30);
        				gl.glVertex3f(70, 20, 30);
        			gl.glEnd();
            		//Back Roof Triangle: Inside
            		gl.glBegin(GL2.GL_TRIANGLES);
            			gl.glVertex3f(30, 20, 70);
            			gl.glVertex3f(70, 20, 70);
            			gl.glVertex3f(50, 30, 70);
            		gl.glEnd();
            		//Back Roof Triangle: Outside
            		gl.glBegin(GL2.GL_TRIANGLES);
        				gl.glVertex3f(30, 20, 70);
        				gl.glVertex3f(50, 30, 70);
        				gl.glVertex3f(70, 20, 70);
        			gl.glEnd();
        			//Right Roof: Inside
            		gl.glBegin(GL2.GL_QUADS);
            			gl.glVertex3f(30, 20, 30);
            			gl.glVertex3f(50, 30, 30);
            			gl.glVertex3f(50, 30, 70);
            			gl.glVertex3f(30, 20, 70);
            		gl.glEnd();
            		//Right Roof: Outside
            		gl.glBegin(GL2.GL_QUADS);
        				gl.glVertex3f(30, 20, 30);
        				gl.glVertex3f(30, 20, 70);
        				gl.glVertex3f(50, 30, 70);
        				gl.glVertex3f(50, 30, 30);
        			gl.glEnd();
            		//Left Roof: Inside
            		gl.glBegin(GL2.GL_QUADS);
            			gl.glVertex3f(50, 30, 30);
            			gl.glVertex3f(70, 20, 30);
            			gl.glVertex3f(70, 20, 70);
            			gl.glVertex3f(50, 30, 70);
            		gl.glEnd();
            		//Left Roof: Outside
            		gl.glBegin(GL2.GL_QUADS);
            			gl.glVertex3f(50, 30, 30);
            			gl.glVertex3f(50, 30, 70);
            			gl.glVertex3f(70, 20, 70);
            			gl.glVertex3f(70, 20, 30);
            		gl.glEnd();
                    
                    ParkWoodWall.bind(gl);
                    //Front Wall Outside: Right of Door
                    gl.glBegin(GL2.GL_QUADS);
                        gl.glVertex3f(30, 0, 30);
                        gl.glVertex3f(30, 20, 30);
                        gl.glVertex3f(48, 20, 30);
                        gl.glVertex3f(48, 0, 30);
                    gl.glEnd();
                   //Front Wall Outside: Left of Door
                    gl.glBegin(GL2.GL_QUADS);
                        gl.glVertex3f(52, 0, 30);
                        gl.glVertex3f(52, 20, 30);
                        gl.glVertex3f(70, 20, 30);
                        gl.glVertex3f(70, 0, 30);
                    gl.glEnd();
                   //Front Wall Outside: Top of Door
                    gl.glBegin(GL2.GL_QUADS);
                        gl.glVertex3f(48, 7, 30);
                        gl.glVertex3f(48, 20, 30);
                        gl.glVertex3f(52, 20, 30);
                        gl.glVertex3f(52, 7, 30);
                    gl.glEnd();
                    //Right Wall Outside
                    gl.glBegin(GL2.GL_QUADS);
                		gl.glVertex3f(30, 0, 30);
                		gl.glVertex3f(30, 0, 70);
                		gl.glVertex3f(30, 20, 70);
                		gl.glVertex3f(30, 20, 30);
                	gl.glEnd();
                	//Left Wall Outside
                	gl.glBegin(GL2.GL_QUADS);
                		gl.glVertex3f(70, 0, 30);
                		gl.glVertex3f(70, 20, 30);
                		gl.glVertex3f(70, 20, 70);
                		gl.glVertex3f(70, 0, 70);
                	gl.glEnd();
                	//Back Wall Outside: Right of Door
                	gl.glBegin(GL2.GL_QUADS);
                		gl.glVertex3f(30, 0, 70);
                		gl.glVertex3f(48, 0, 70);
                		gl.glVertex3f(48, 20, 70);
                		gl.glVertex3f(30, 20, 70);
                    gl.glEnd();
                    //Back Wall Outside: Left of Door
                	gl.glBegin(GL2.GL_QUADS);
                		gl.glVertex3f(52, 0, 70);
                		gl.glVertex3f(70, 0, 70);
                		gl.glVertex3f(70, 20, 70);
                		gl.glVertex3f(52, 20, 70);
                    gl.glEnd();
                    //Back Wall Outside: Top of Door
                	gl.glBegin(GL2.GL_QUADS);
                		gl.glVertex3f(48, 7, 70);
                		gl.glVertex3f(52, 7, 70);
                		gl.glVertex3f(52, 20, 70);
                		gl.glVertex3f(48, 20, 70);
                    gl.glEnd();
                gl.glDisable(GL2.GL_TEXTURE_2D);
        gl.glDisable(GL2.GL_CULL_FACE);   
        gl.glDisable(GL2.GL_TEXTURE_2D);
        gl.glDisable(GL2.GL_TEXTURE_GEN_S);
        gl.glDisable(GL2.GL_TEXTURE_GEN_T);
        
        
        
        
        
        gl.glColor3f(.5f,.2f,.2f);
        //Table Stem, cylindrical with base
        gl.glPushMatrix();
        	gl.glTranslatef(50, (float) 0.2, 50);
            gl.glRotatef(-90f, 1f, 0f, 0f); // stand upright (Y)
            glu.gluCylinder(quadric, 1., 1., 3., 20, 20);
            glu.gluDisk(quadric, 0.1, 2., 20, 20); // also to be flipped
            gl.glTranslatef(-50, (float) -0.2, -50);
        gl.glPopMatrix();
        gl.glColor3f(.6f,.3f,.3f);
        // the table top
        gl.glBegin(GL2.GL_QUADS);
        	gl.glVertex3f(47, 3.2f, 47);
        	gl.glVertex3f(47, 3.2f, 53);
        	gl.glVertex3f(53, 3.2f, 53);
        	gl.glVertex3f(53, 3.2f, 47);
        gl.glEnd();
        
        
        
        
        
        
        //BasketBall
        gl.glColor3f(1, 1, 1);
        gl.glEnable(GL2.GL_TEXTURE_2D);
        ParkBasketballTexture.bind(gl);
        	gl.glPushMatrix();
        		gl.glTranslatef(65, (float) 1.2, 35);
        		glu.gluSphere(quadric, 1, 20, 20);
        		gl.glTranslatef(-65, (float) -1.2, -35);
        	gl.glPopMatrix();
        gl.glDisable(GL2.GL_TEXTURE_2D);
        //Rim
        gl.glColor3f(1,0,0);
        gl.glPushMatrix();
			gl.glTranslatef(65, (float) 10, 31);
			gl.glRotatef(-90f, 1f, 0f, 0f); // stand upright (Y)
    		glu.gluCylinder(quadric, 1, 1, 0.25, 10, 10);
    		gl.glTranslatef(-65, (float) -10, -31);
    	gl.glPopMatrix();
    	//Net
    	gl.glColor3f(1, 1, 1);
    	gl.glEnable(GL2.GL_TEXTURE_2D);
        ParkBasketballNet.bind(gl);
        	gl.glPushMatrix();
				gl.glTranslatef(65, (float) 8.5, 31);
				gl.glRotatef(-90f, 1f, 0f, 0f); // stand upright (Y)
				glu.gluCylinder(quadric, 0.5, 1, 1.5, 10, 10);
				gl.glTranslatef(-65, (float) -8.5, -31);
			gl.glPopMatrix();
    	gl.glDisable(GL2.GL_TEXTURE_2D);
        //BackBoard
    	gl.glColor3f(0, 0, 0);
    	gl.glBegin(GL2.GL_QUADS);
    		gl.glVertex3f(62, 10, 30.1f);
    		gl.glVertex3f(68, 10, 30.1f);
    		gl.glVertex3f(68, 14, 30.1f);
    		gl.glVertex3f(62, 14, 30.1f);
    	gl.glEnd();
        
    	
        
    	
    	
        gl.glColor3f(.25f,0.6f,0.5f);
        //Side Sofa Main
        gl.glBegin(GL2.GL_QUADS);
        	gl.glVertex3f(30, 0, 44);
        	gl.glVertex3f(35, 0, 44);
        	gl.glVertex3f(35, 3, 44);
        	gl.glVertex3f(30, 3, 44);
        gl.glEnd();
        //Side Sofa Top
        gl.glBegin(GL2.GL_QUADS);
    		gl.glVertex3f(30, 3, 44);
    		gl.glVertex3f(35, 3, 44);
    		gl.glVertex3f(35, 3, 45);
    		gl.glVertex3f(30, 3, 45);
    	gl.glEnd();
    	//Side Sofa Side
        gl.glBegin(GL2.GL_QUADS);
    		gl.glVertex3f(35, 0, 44);
    		gl.glVertex3f(35, 3, 44);
    		gl.glVertex3f(35, 3, 45);
    		gl.glVertex3f(35, 0, 45);
    	gl.glEnd();
    	//Side Sofa Inside
        gl.glBegin(GL2.GL_QUADS);
    		gl.glVertex3f(30, 0, 45);
    		gl.glVertex3f(35, 0, 45);
    		gl.glVertex3f(35, 3, 45);
    		gl.glVertex3f(30, 3, 45);
    	gl.glEnd();
    	//Side Sofa Main
        gl.glBegin(GL2.GL_QUADS);
        	gl.glVertex3f(30, 0, 55);
        	gl.glVertex3f(35, 0, 55);
        	gl.glVertex3f(35, 3, 55);
        	gl.glVertex3f(30, 3, 55);
        gl.glEnd();
        //Side Sofa Top
        gl.glBegin(GL2.GL_QUADS);
    		gl.glVertex3f(30, 3, 55);
    		gl.glVertex3f(35, 3, 55);
    		gl.glVertex3f(35, 3, 56);
    		gl.glVertex3f(30, 3, 56);
    	gl.glEnd();
    	//Side Sofa Side
        gl.glBegin(GL2.GL_QUADS);
    		gl.glVertex3f(35, 0, 55);
    		gl.glVertex3f(35, 3, 55);
    		gl.glVertex3f(35, 3, 56);
    		gl.glVertex3f(35, 0, 56);
    	gl.glEnd();
    	//Side Sofa Inside
        gl.glBegin(GL2.GL_QUADS);
    		gl.glVertex3f(30, 0, 56);
    		gl.glVertex3f(35, 0, 56);
    		gl.glVertex3f(35, 3, 56);
    		gl.glVertex3f(30, 3, 56);
    	gl.glEnd();
    	gl.glColor3f(.3f, .5f, .3f);
    	//Main Sofa
    	gl.glBegin(GL2.GL_QUADS);
			gl.glVertex3f(35, 0, 45);
			gl.glVertex3f(35, 2, 45);
			gl.glVertex3f(35, 2, 55);
			gl.glVertex3f(35, 0, 55);
		gl.glEnd();
		//Main Sofa Top
    	gl.glBegin(GL2.GL_QUADS);
			gl.glVertex3f(30, 2, 45);
			gl.glVertex3f(30, 2, 55);
			gl.glVertex3f(35, 2, 55);
			gl.glVertex3f(35, 2, 45);
		gl.glEnd();

		
		
		
		
		gl.glColor3f(0f,0f,0f);
		//TV Side
        gl.glBegin(GL2.GL_QUADS);
        	gl.glVertex3f(68, 0, 45);
        	gl.glVertex3f(70, 0, 45);
        	gl.glVertex3f(70, 8, 45);
        	gl.glVertex3f(68, 8, 45);
        gl.glEnd();
        //TV Side
        gl.glBegin(GL2.GL_QUADS);
    		gl.glVertex3f(68, 0, 55);
    		gl.glVertex3f(70, 0, 55);
    		gl.glVertex3f(70, 8, 55);
    		gl.glVertex3f(68, 8, 55);
    	gl.glEnd();
    	//TV Front
    	gl.glBegin(GL2.GL_QUADS);
			gl.glVertex3f(68, 0, 45);
			gl.glVertex3f(68, 0, 55);
			gl.glVertex3f(68, 8, 55);
			gl.glVertex3f(68, 8, 45);
		gl.glEnd();
		//TV Top
		gl.glBegin(GL2.GL_QUADS);
			gl.glVertex3f(68, 8, 45);
			gl.glVertex3f(68, 8, 55);
			gl.glVertex3f(70, 8, 55);
			gl.glVertex3f(70, 8, 45);
		gl.glEnd();
		//TV Screen
		gl.glColor3f(.5f,.5f,.5f);
		gl.glBegin(GL2.GL_QUADS);
			gl.glVertex3f(67.9f, 1, 46);
			gl.glVertex3f(67.9f, 1, 54);
			gl.glVertex3f(67.9f, 7, 54);
			gl.glVertex3f(67.9f, 7, 46);
		gl.glEnd();
        gl.glColor3f(1,1,1);    
   }
}
