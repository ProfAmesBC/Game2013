package buildings;
import game.Building;

import java.text.DecimalFormat;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;
import javax.swing.JTextArea;

import com.jogamp.opengl.util.texture.Texture;

public class FMPBuilding extends Building{
	private Texture brickTexture, insideWall, floorTexture,ceilingTexture, doorTexture, grassTexture, screenTexture;
	private Texture one,two,three,tableTexture;
	private int floorNumber =0;
	private JTextArea matArea= new JTextArea(4,20);
	private DecimalFormat fmt = new DecimalFormat("#0.00");

	public FMPBuilding(GL2 gl, GLU glu) {
		insideWall = setupTexture(gl, "FMPInsideWall.png");
		brickTexture     = setupTexture(gl, "FMPbricks.png"); // if this causes trouble, try bricks.gif
		floorTexture     = setupTexture(gl, "FMPfloor.jpg"); // if this causes trouble, try bricks.gif
		ceilingTexture     = setupTexture(gl, "FMPceiling.jpg"); // if this causes trouble, try bricks.gif
		doorTexture     = setupTexture(gl, "FMPdoorTexture.jpg"); // if this causes trouble, try bricks.gif
		grassTexture     = setupTexture(gl, "FMPgrass.jpg"); // if this causes trouble, try bricks.gif
		screenTexture     = setupTexture(gl, "FMPscreen.jpg"); // if this causes trouble, try bricks.gif
		one				= setupTexture(gl, "FMP1.jpg"); // if this causes trouble, try bricks.gif
		two 			= setupTexture(gl, "FMP2.jpg"); // if this causes trouble, try bricks.gif
		three			= setupTexture(gl, "FMP3.jpg"); // if this causes trouble, try bricks.gif
		tableTexture = setupTexture(gl, "FMPtable.jpg"); // if this causes trouble, try bricks.gif
	}

	private float frames = 0;
	public void draw(GL2 gl, GLU glu) {
		++frames;
		addTable(gl);
		addLeg(gl,0,0,0, matArea);
		addLeg(gl,0,0,-4,matArea);
		addLeg(gl,4,0,-4,matArea);
		addLeg(gl,4,0,0,matArea);		
		floorNumber=0;
		newFloor(gl);floorNumber++;
		newFloor(gl);floorNumber++;
		newFloor(gl);
		addField(gl);
	}
	
	@Override
	public void drawMoving(GL2 gl, GLU glu, float eyeX, float eyeY, float eyeZ) {
		addTV(gl);
	}
	
	private void addTable(GL2 gl){
		gl.glEnable(GL2.GL_CULL_FACE);
		gl.glEnable(GL2.GL_TEXTURE_2D);	
		gl.glPushMatrix();		
		gl.glTranslatef(60, 0, 30);
		gl.glScalef(2, 2, 1);
		tableTexture.bind(gl);		
		//top	
		gl.glTexCoord2f(0f,2f); gl.glVertex3f(100,  0, 0);
		gl.glTexCoord2f(3f,2f); gl.glVertex3f(100,  0, 100);
		gl.glTexCoord2f(3f,0f); gl.glVertex3f(0,  0, 100);
		gl.glTexCoord2f(0f,0f); gl.glVertex3f(0,  0,0);

		gl.glBegin(GL2.GL_QUADS);
		gl.glVertex3f(-2, 2, 10);gl.glTexCoord2f(0f,2f); 	
		gl.glVertex3f( 2, 2, 10);gl.glTexCoord2f(3f,2f);
		gl.glVertex3f( 2, 2, 5);gl.glTexCoord2f(3f,0f);
		gl.glVertex3f(-2, 2, 5);gl.glTexCoord2f(0f,0f); 
		gl.glEnd();

		gl.glBegin(GL2.GL_QUADS);
		gl.glVertex3f(-2, 2, 10);gl.glTexCoord2f(0f,0f); 	
		gl.glVertex3f(-2, 2, 5);gl.glTexCoord2f(3f,0f);		
		gl.glVertex3f( 2, 2, 5);gl.glTexCoord2f(3f,2f);
		gl.glVertex3f( 2, 2, 10);gl.glTexCoord2f(0f,2f);
		gl.glEnd();
		
		gl.glPopMatrix();
		gl.glDisable(GL2.GL_CULL_FACE);		
		gl.glDisable(GL2.GL_TEXTURE_2D);
	}
	public void addLeg(GL2 gl,float x,float y,float z, JTextArea matArea){
		gl.glEnable(GL2.GL_CULL_FACE);
		gl.glEnable(GL2.GL_TEXTURE_2D);	
		gl.glPushMatrix();		
		gl.glTranslatef(60, 0, 30);
		gl.glTranslatef(x, y, z);
		tableTexture.bind(gl);		
		double[] texMat = new double[16]; // show the matrix
        gl.glGetDoublev(GL2.GL_TEXTURE_MATRIX, texMat, 0);
        matArea.setText(
                fmt.format(texMat[0]) + ",  " + fmt.format(texMat[4]) + ",  " + fmt.format(texMat[ 8]) + ",  " + fmt.format(texMat[12]) + '\n' +
                fmt.format(texMat[1]) + ",  " + fmt.format(texMat[5]) + ",  " + fmt.format(texMat[ 9]) + ",  " + fmt.format(texMat[13]) + '\n' +
                fmt.format(texMat[2]) + ",  " + fmt.format(texMat[6]) + ",  " + fmt.format(texMat[10]) + ",  " + fmt.format(texMat[14]) + '\n' +
                fmt.format(texMat[3]) + ",  " + fmt.format(texMat[7]) + ",  " + fmt.format(texMat[11]) + ",  " + fmt.format(texMat[15]));
		gl.glBegin(GL2.GL_QUADS);
		gl.glVertex3f(-2,    4, 10);
		gl.glVertex3f(-2,    0, 10);
		gl.glVertex3f(-1.8f, 0, 10);		
		gl.glVertex3f(-1.8f, 4, 10);
		gl.glEnd();
		
		gl.glBegin(GL2.GL_QUADS);
		gl.glVertex3f(-1.8f, 4, 10);	
		gl.glVertex3f(-1.8f, 0, 10);
		gl.glVertex3f(-1.8f, 0, 9.5f);		
		gl.glVertex3f(-1.8f, 4, 9.5f);
		gl.glEnd();
		
		gl.glBegin(GL2.GL_QUADS);
		gl.glVertex3f(-2,     4, 9.5f);
		gl.glVertex3f(-1.8f,  4, 9.5f);
		gl.glVertex3f(-1.8f,  0, 9.5f);		
		gl.glVertex3f(-2f,    0, 9.5f);
		gl.glEnd();
		
		gl.glBegin(GL2.GL_QUADS);
		gl.glVertex3f(-2,     4, 10f);	
		gl.glVertex3f(-2,     0, 10);		
		gl.glVertex3f(-2,     0, 9.5f);	
		gl.glVertex3f(-2,     4, 9.5f);
		gl.glEnd();	    
		gl.glPopMatrix();
		gl.glDisable(GL2.GL_CULL_FACE);		
		gl.glDisable(GL2.GL_TEXTURE_2D);
	}
	
	private void addTV(GL2 gl){
		gl.glEnable(GL2.GL_CULL_FACE);
		gl.glEnable(GL2.GL_TEXTURE_2D);	
		gl.glPushMatrix();		
		gl.glTranslatef(60, 4, 30);
		screenTexture.bind(gl);
		//front
		gl.glBegin(GL2.GL_QUADS);			
		gl.glVertex3f(-2,  0, 9.5f);	
		gl.glVertex3f( 2,  0, 9.5f);
		gl.glVertex3f( 2, 4, 9.5f);
		gl.glVertex3f(-2, 4, 9.5f);
		gl.glEnd();		
		two.bind(gl);
		if(Math.random()>.7)three.bind(gl);
		if(Math.random()>.5)one.bind(gl);
		gl.glBegin(GL2.GL_QUADS);				
		gl.glVertex3f(-1.8f,  .8f, 10);	
		gl.glVertex3f( 1.8f,  .8f, 10);
		gl.glVertex3f( 1.8f, 3.8f, 10);
		gl.glVertex3f(-1.8f, 3.8f, 10);
		gl.glEnd();
		//back
		screenTexture.bind(gl);
		gl.glBegin(GL2.GL_QUADS);
		gl.glVertex3f(-2,  0, 5);	
		gl.glVertex3f(-2, 4, 5);		
		gl.glVertex3f( 2, 4, 5);
		gl.glVertex3f( 2,  0, 5);
		gl.glEnd();
		//right side	
		screenTexture.bind(gl);
		gl.glBegin(GL2.GL_QUADS);
		gl.glVertex3f(-2, 0, 10);
		gl.glVertex3f(-2, 4, 10);		
		gl.glVertex3f(-2, 4, 5);
		gl.glVertex3f(-2, 0, 5);
		gl.glEnd();
		//left side
		gl.glBegin(GL2.GL_QUADS);
		gl.glVertex3f(2,  0, 10);
		gl.glVertex3f(2, 0, 5);		
		gl.glVertex3f(2, 4, 5);		
		gl.glVertex3f(2,  4, 10);
		gl.glEnd();
		//top	
		gl.glBegin(GL2.GL_QUADS);
		gl.glVertex3f(-2, 2, 10);	
		gl.glVertex3f( 2, 2, 10);
		gl.glVertex3f( 2, 2, 5);
		gl.glVertex3f(-2, 2, 5);
		gl.glEnd();

		gl.glPopMatrix();
		gl.glDisable(GL2.GL_CULL_FACE);		
		gl.glDisable(GL2.GL_TEXTURE_2D);
	}

	private void addField(GL2 gl){
		gl.glEnable(GL2.GL_CULL_FACE);
		gl.glPushMatrix();		
		gl.glEnable(GL2.GL_TEXTURE_2D);		
		//wall1
		grassTexture.bind(gl);
		gl.glBegin(GL2.GL_QUADS);
		// ccw as viewed from bot
		gl.glTexCoord2f(0f,2f); gl.glVertex3f(100,  0, 0);
		gl.glTexCoord2f(3f,2f); gl.glVertex3f(100,  0, 100);
		gl.glTexCoord2f(3f,0f); gl.glVertex3f(0,  0, 100);
		gl.glTexCoord2f(0f,0f); gl.glVertex3f(0,  0,0);

		gl.glEnd();
		gl.glBegin(GL2.GL_QUADS);
		// ccw as viewed from top
		gl.glTexCoord2f(0f,2f); gl.glVertex3f(100,  0, 0);
		gl.glTexCoord2f(0f,0f); gl.glVertex3f(0,  0,0);
		gl.glTexCoord2f(3f,0f); gl.glVertex3f(0,  0, 100);
		gl.glTexCoord2f(3f,2f); gl.glVertex3f(100,  0, 100);				
		gl.glEnd();
		
		gl.glDisable(GL2.GL_TEXTURE_2D);
		gl.glPopMatrix();
	}

	private void newFloor(GL2 gl) {		
		gl.glEnable(GL2.GL_CULL_FACE);
		gl.glPushMatrix();		
		gl.glEnable(GL2.GL_TEXTURE_2D);		
		gl.glTranslatef(60, floorNumber*10, 70);
		gl.glScalef(4, 4, 4);
		//wall1
		brickTexture.bind(gl);
		gl.glBegin(GL2.GL_QUADS);
		// ccw as viewed from front
		gl.glTexCoord2f(0f,2f); gl.glVertex3f(-5,  0, 0);
		/*
		if(floorNumber ==0){
			gl.glVertex3f(-2, 0, 0);
			gl.glVertex3f(-2,  2, 0);
			gl.glVertex3f(2,  2, 0);
			gl.glVertex3f(2, 0, 0);
		} 
		 */
		gl.glTexCoord2f(3f,2f); gl.glVertex3f( 5,  0, 0);
		gl.glTexCoord2f(3f,0f); gl.glVertex3f( 5, 10, 0);
		gl.glTexCoord2f(0f,0f); gl.glVertex3f(-5, 10, 0);
		gl.glEnd();
		insideWall.bind(gl);
		gl.glBegin(GL2.GL_QUADS);
		// cw as viewed from front, so can be seen as ccw from back		
		gl.glTexCoord2f(0f,0f); gl.glVertex3f(-5,  0, 0);
		gl.glTexCoord2f(0f,1f); gl.glVertex3f(-5, 10, 0);
		gl.glTexCoord2f(1f,1f); gl.glVertex3f( 5, 10, 0);
		gl.glTexCoord2f(1f,0f); gl.glVertex3f( 5,  0, 0);							
		gl.glEnd();
		//wall1

		gl.glTranslatef(0, 0, -10);		

		//wall2		
		insideWall.bind(gl);
		gl.glBegin(GL2.GL_QUADS);
		// ccw as viewed from front
		gl.glTexCoord2f(0f,0f); gl.glVertex3f(-5,  0, 0);
		gl.glTexCoord2f(0f,1f); gl.glVertex3f( 5,  0, 0);
		gl.glTexCoord2f(1f,1f); gl.glVertex3f( 5, 10, 0);
		gl.glTexCoord2f(1f,0f); gl.glVertex3f(-5, 10, 0);
		gl.glEnd();
		brickTexture.bind(gl);
		gl.glBegin(GL2.GL_QUADS);
		// cw as viewed from front, so can be seen as ccw from back		
		gl.glTexCoord2f(0f,2f); gl.glVertex3f(-5,  0, 0);
		gl.glTexCoord2f(3f,2f); gl.glVertex3f(-5, 10, 0);
		gl.glTexCoord2f(3f,0f); gl.glVertex3f( 5, 10, 0);
		gl.glTexCoord2f(0f,0f); gl.glVertex3f( 5,  0, 0);							
		gl.glEnd();
		//wall2

		gl.glRotatef(90,90,0,0);

		//floor
		floorTexture.bind(gl);
		gl.glBegin(GL2.GL_QUADS);
		// ccw as viewed from front
		gl.glTexCoord2f(0f,2f); gl.glVertex3f(-5,  0, 0);
		gl.glTexCoord2f(3f,2f); gl.glVertex3f( 5,  0, 0);
		gl.glTexCoord2f(3f,0f); gl.glVertex3f( 5, 10f, 0);
		gl.glTexCoord2f(0f,0f); gl.glVertex3f(-5, 10f, 0);
		gl.glEnd();
		floorTexture.bind(gl);
		gl.glBegin(GL2.GL_QUADS);
		// cw as viewed from front, so can be seen as ccw from back		
		gl.glTexCoord2f(0f,0f); gl.glVertex3f(-5,  0, 0);
		gl.glTexCoord2f(0f,1f); gl.glVertex3f(-5,10, 0);
		gl.glTexCoord2f(1f,1f); gl.glVertex3f( 5, 10, 0);
		gl.glTexCoord2f(1f,0f); gl.glVertex3f( 5,  0f, 0);							
		gl.glEnd();
		//floor

		gl.glTranslatef(0, 0, -10);

		//ceiling		
		ceilingTexture.bind(gl);
		gl.glBegin(GL2.GL_QUADS);
		// ccw as viewed from front
		gl.glTexCoord2f(0f,2f); gl.glVertex3f(-5,  0, 0);
		gl.glTexCoord2f(3f,2f); gl.glVertex3f( 5,  0, 0);
		gl.glTexCoord2f(3f,0f); gl.glVertex3f( 5, 10, 0);
		gl.glTexCoord2f(0f,0f); gl.glVertex3f(-5, 10, 0);
		gl.glEnd();
		ceilingTexture.bind(gl);
		gl.glBegin(GL2.GL_QUADS);
		// cw as viewed from front, so can be seen as ccw from back		
		gl.glTexCoord2f(0f,0f); gl.glVertex3f(-5,  0, 0);
		gl.glTexCoord2f(0f,1f); gl.glVertex3f(-5, 10, 0);
		gl.glTexCoord2f(1f,1f); gl.glVertex3f( 5, 10, 0);
		gl.glTexCoord2f(1f,0f); gl.glVertex3f( 5,  0, 0);							
		gl.glEnd();
		//ceiling									
		gl.glPopMatrix();


		gl.glPushMatrix();						

		gl.glTranslatef(60, floorNumber*10, 70);
		gl.glScalef(4, 4, 4);
		//wall3		
		if(floorNumber!=0){
			brickTexture.bind(gl);
			gl.glBegin(GL2.GL_QUADS);
			gl.glTexCoord2f(0f,2f); gl.glVertex3f(-5,  10, 0);
			gl.glTexCoord2f(3f,2f); gl.glVertex3f( -5,  10, -10);
			gl.glTexCoord2f(3f,0f); gl.glVertex3f( -5, 0, -10);
			gl.glTexCoord2f(0f,0f); gl.glVertex3f(-5, 0, 0);
			gl.glEnd();
			doorTexture.bind(gl);
			gl.glBegin(GL2.GL_QUADS);
			gl.glTexCoord2f(0f,0f); gl.glVertex3f(-5,  10, 0);
			gl.glTexCoord2f(0f,1f); gl.glVertex3f(-5, 0, 0);
			gl.glTexCoord2f(1f,1f); gl.glVertex3f( -5, 0, -10);
			gl.glTexCoord2f(1f,0f); gl.glVertex3f( -5,  10, -10);							
			gl.glEnd();
			//wall3
		}
		else{
			//wall3+door		
			brickTexture.bind(gl);
			gl.glBegin(GL2.GL_QUADS);		
			gl.glTexCoord2f(0f,2f); gl.glVertex3f(-5,  10, 0);
			gl.glTexCoord2f(3f,2f); gl.glVertex3f( -5,  10, -10);
			gl.glTexCoord2f(3f,0f); gl.glVertex3f( -5, 5, -10);
			gl.glTexCoord2f(0f,0f); gl.glVertex3f(-5, 5, 0);
			gl.glEnd();		

			gl.glBegin(GL2.GL_QUADS);			
			gl.glTexCoord2f(0f,2f); gl.glVertex3f(-5,  5, 0);
			gl.glTexCoord2f(3f,2f); gl.glVertex3f( -5,  5, -3);
			gl.glTexCoord2f(3f,0f); gl.glVertex3f( -5, 0, -3);
			gl.glTexCoord2f(0f,0f); gl.glVertex3f(-5, 0, 0);
			gl.glEnd();

			gl.glBegin(GL2.GL_QUADS);			
			gl.glTexCoord2f(0f,2f); gl.glVertex3f(-5,  5, -7);
			gl.glTexCoord2f(3f,2f); gl.glVertex3f( -5,  5, -10);
			gl.glTexCoord2f(3f,0f); gl.glVertex3f( -5, 0, -10);
			gl.glTexCoord2f(0f,0f); gl.glVertex3f(-5, 0, -7);
			gl.glEnd();
			doorTexture.bind(gl);
			gl.glBegin(GL2.GL_QUADS);	
			gl.glTexCoord2f(0f,2f); gl.glVertex3f(-5,  10, 0);
			gl.glTexCoord2f(0f,0f); gl.glVertex3f(-5, 5, 0);			
			gl.glTexCoord2f(3f,0f); gl.glVertex3f( -5, 5, -10);			
			gl.glTexCoord2f(3f,2f); gl.glVertex3f( -5,  10, -10);
			gl.glEnd();	
			gl.glBegin(GL2.GL_QUADS);			
			gl.glTexCoord2f(0f,2f); gl.glVertex3f(-5,  5, 0);
			gl.glTexCoord2f(0f,0f); gl.glVertex3f(-5, 0, 0);
			gl.glTexCoord2f(3f,0f); gl.glVertex3f( -5, 0, -3);
			gl.glTexCoord2f(3f,2f); gl.glVertex3f( -5,  5, -3);				
			gl.glEnd();
			gl.glBegin(GL2.GL_QUADS);			
			gl.glTexCoord2f(0f,2f); gl.glVertex3f(-5,  5, -7);
			gl.glTexCoord2f(0f,0f); gl.glVertex3f(-5, 0, -7);
			gl.glTexCoord2f(3f,0f); gl.glVertex3f( -5, 0, -10);	
			gl.glTexCoord2f(3f,2f); gl.glVertex3f( -5,  5, -10);					
			gl.glEnd();
			//wall3+door
		}
		gl.glTranslatef(10,0,0);
		//wall4		
		//gl.glBegin(GL2.GL_QUADS); // Ames change, removed this line
		if(floorNumber!=0){
			brickTexture.bind(gl);
			gl.glBegin(GL2.GL_QUADS);
			gl.glTexCoord2f(0f,2f); gl.glVertex3f(-5,  10, 0);
			gl.glTexCoord2f(3f,2f); gl.glVertex3f( -5,  10, -10);
			gl.glTexCoord2f(3f,0f); gl.glVertex3f( -5, 0, -10);
			gl.glTexCoord2f(0f,0f); gl.glVertex3f(-5, 0, 0);
			gl.glEnd();
			brickTexture.bind(gl);
			gl.glBegin(GL2.GL_QUADS);
			gl.glTexCoord2f(0f,2f); gl.glVertex3f(-5,  10, 0);
			gl.glTexCoord2f(3f,2f); gl.glVertex3f(-5, 0, 0);
			gl.glTexCoord2f(3f,0f); gl.glVertex3f( -5, 0, -10);
			gl.glTexCoord2f(0f,0f); gl.glVertex3f( -5,  10, -10);							
			gl.glEnd();
			//wall3
		}
		else{
			//wall3+door		
			brickTexture.bind(gl);
			gl.glBegin(GL2.GL_QUADS);		
			gl.glTexCoord2f(0f,2f); gl.glVertex3f(-5,  10, 0);
			gl.glTexCoord2f(3f,2f); gl.glVertex3f( -5,  10, -10);
			gl.glTexCoord2f(3f,0f); gl.glVertex3f( -5, 5, -10);
			gl.glTexCoord2f(0f,0f); gl.glVertex3f(-5, 5, 0);
			gl.glEnd();		
			gl.glBegin(GL2.GL_QUADS);			
			gl.glTexCoord2f(0f,2f); gl.glVertex3f(-5,  5, 0);
			gl.glTexCoord2f(3f,2f); gl.glVertex3f( -5,  5, -3);
			gl.glTexCoord2f(3f,0f); gl.glVertex3f( -5, 0, -3);
			gl.glTexCoord2f(0f,0f); gl.glVertex3f(-5, 0, 0);
			gl.glEnd();
			gl.glBegin(GL2.GL_QUADS);			
			gl.glTexCoord2f(0f,2f); gl.glVertex3f(-5,  5, -7);
			gl.glTexCoord2f(3f,2f); gl.glVertex3f( -5,  5, -10);
			gl.glTexCoord2f(3f,0f); gl.glVertex3f( -5, 0, -10);
			gl.glTexCoord2f(0f,0f); gl.glVertex3f(-5, 0, -7);
			gl.glEnd();
			brickTexture.bind(gl);
			gl.glBegin(GL2.GL_QUADS);	
			gl.glTexCoord2f(0f,2f); gl.glVertex3f(-5,  10, 0);
			gl.glTexCoord2f(0f,0f); gl.glVertex3f(-5, 5, 0);			
			gl.glTexCoord2f(3f,0f); gl.glVertex3f( -5, 5, -10);			
			gl.glTexCoord2f(3f,2f); gl.glVertex3f( -5,  10, -10);
			gl.glEnd();	
			gl.glBegin(GL2.GL_QUADS);			
			gl.glTexCoord2f(0f,2f); gl.glVertex3f(-5,  5, 0);
			gl.glTexCoord2f(0f,0f); gl.glVertex3f(-5, 0, 0);
			gl.glTexCoord2f(3f,0f); gl.glVertex3f( -5, 0, -3);
			gl.glTexCoord2f(3f,2f); gl.glVertex3f( -5,  5, -3);				
			gl.glEnd();
			gl.glBegin(GL2.GL_QUADS);			
			gl.glTexCoord2f(0f,2f); gl.glVertex3f(-5,  5, -7);
			gl.glTexCoord2f(0f,0f); gl.glVertex3f(-5, 0, -7);
			gl.glTexCoord2f(3f,0f); gl.glVertex3f( -5, 0, -10);	
			gl.glTexCoord2f(3f,2f); gl.glVertex3f( -5,  5, -10);					
			gl.glEnd();
			//wall3+door
		}
		//wall4
		gl.glDisable(GL2.GL_TEXTURE_2D);
		gl.glPopMatrix();
		gl.glDisable(GL2.GL_CULL_FACE);		
	}
}

