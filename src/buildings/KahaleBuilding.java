package buildings;
import game.Building;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;

import com.jogamp.opengl.util.texture.Texture;


public class KahaleBuilding extends Building{
	private GLUquadric quadric;
	private Texture groundTexture, sphereTexture, tvTexture; 
	private Texture[] outerwallTexture = new Texture[11]; 
	private Texture[] innerwallTexture = new Texture[4];
	private Texture[] tableTexture = new Texture[10];
	private Texture[] tvAnimation = new Texture[11];

	public KahaleBuilding(GL2 gl, GLU glu){
		
		quadric = glu.gluNewQuadric();
        glu.gluQuadricDrawStyle(quadric, GLU.GLU_FILL); // GLU_POINT, GLU_LINE, GLU_FILL, GLU_SILHOUETTE
        glu.gluQuadricNormals  (quadric, GLU.GLU_SMOOTH); // GLU_NONE, GLU_FLAT, or GLU_SMOOTH
        glu.gluQuadricTexture  (quadric, true);        // false, or true to generate texture coordinates
        
        //LOAD IN ALL TEXTURES BELOW
		groundTexture = setupTexture(gl, "KAHALEground.gif");
		sphereTexture = setupTexture(gl, "KAHALEeye.jpg");
		tvTexture = setupTexture(gl, "KAHALEblack.jpg");
		
		tvAnimation[0] = setupTexture(gl, "KAHALEcat-1.png");
		tvAnimation[1] = setupTexture(gl, "KAHALEcat-2.png");
		tvAnimation[2] = setupTexture(gl, "KAHALEcat-3.png");
		tvAnimation[3] = setupTexture(gl, "KAHALEcat-4.png");
		tvAnimation[4] = setupTexture(gl, "KAHALEcat-5.png");
		tvAnimation[5] = setupTexture(gl, "KAHALEcat-6.png");
		tvAnimation[6] = setupTexture(gl, "KAHALEcat-7.png");
		tvAnimation[7] = setupTexture(gl, "KAHALEcat-8.png");
		tvAnimation[8] = setupTexture(gl, "KAHALEcat-9.png");
		tvAnimation[9] = setupTexture(gl, "KAHALEcat-10.png");
		tvAnimation[10] = setupTexture(gl, "KAHALEcat-11.png");
		
		tableTexture[0] = setupTexture(gl, "KAHALEspiral-1.png");
		tableTexture[1] = setupTexture(gl, "KAHALEspiral-2.png");
		tableTexture[2] = setupTexture(gl, "KAHALEspiral-3.png");
		tableTexture[3] = setupTexture(gl, "KAHALEspiral-4.png");
		tableTexture[4] = setupTexture(gl, "KAHALEspiral-5.png");
		tableTexture[5] = setupTexture(gl, "KAHALEspiral-6.png");
		tableTexture[6] = setupTexture(gl, "KAHALEspiral-7.png");
		tableTexture[7] = setupTexture(gl, "KAHALEspiral-8.png");
		tableTexture[8] = setupTexture(gl, "KAHALEspiral-9.png");
		tableTexture[9] = setupTexture(gl, "KAHALEspiral-10.png");

		innerwallTexture[0] = setupTexture(gl, "KAHALEmatrix-1.png");
		innerwallTexture[1] = setupTexture(gl, "KAHALEmatrix-2.png");
		innerwallTexture[2] = setupTexture(gl, "KAHALEmatrix-3.png");
		innerwallTexture[3] = setupTexture(gl, "KAHALEmatrix-4.png");
		outerwallTexture[0] = setupTexture(gl, "KAHALEwater-1.png");
		outerwallTexture[1] = setupTexture(gl, "KAHALEwater-2.png");
		outerwallTexture[2] = setupTexture(gl, "KAHALEwater-3.png");
		outerwallTexture[3] = setupTexture(gl, "KAHALEwater-4.png");
		outerwallTexture[4] = setupTexture(gl, "KAHALEwater-5.png");
		outerwallTexture[5] = setupTexture(gl, "KAHALEwater-6.png");
		outerwallTexture[6] = setupTexture(gl, "KAHALEwater-7.png");
		outerwallTexture[7] = setupTexture(gl, "KAHALEwater-8.png");
		outerwallTexture[8] = setupTexture(gl, "KAHALEwater-9.png");
		outerwallTexture[9] = setupTexture(gl, "KAHALEwater-10.png");
		outerwallTexture[10] = setupTexture(gl, "KAHALEwater-11.png");


	}
	
	private float frames1 = 0;
	private float frames2 = 0;
	private float frames3 = 0;
	private float frames4 = 0;
	private float angle = 90;
	
	@Override 
	public void drawMoving(GL2 gl, GLU glu, float eyeX, float eyeY, float eyeZ){
	
		//DRAW INNER WALL TEXTURES OF FRONT, BACK, RIGHT LEFT, AND CEILING
		innerwallTexture[(int) frames1].bind(gl);
        gl.glBegin(GL2.GL_QUADS);
        	frontWallINSIDE(gl, glu);
        	rightWallINSIDE(gl, glu);
        	leftWallINSIDE(gl, glu);
        	backWallINSIDE(gl, glu);
        	ceilingINSIDE(gl, glu);
        gl.glEnd();

        outerwallTexture[(int) frames2].bind(gl);
    	gl.glEnable(GL2.GL_TEXTURE_GEN_S);
        gl.glEnable(GL2.GL_TEXTURE_GEN_T);
            gl.glTexGeni(GL2.GL_S, GL2.GL_TEXTURE_GEN_MODE, GL2.GL_OBJECT_LINEAR);
            gl.glTexGeni(GL2.GL_T, GL2.GL_TEXTURE_GEN_MODE, GL2.GL_OBJECT_LINEAR);
            
            //DRAW FRONT AND BACK WALLS WITH AUTO TEXTURING
            float[] coef_s1 = {0.25f,0,0,0};
            gl.glTexGenfv(GL2.GL_S, GL2.GL_OBJECT_PLANE, coef_s1, 0);
            float[] coef_t1 = {0,0.25f,0,0};
            gl.glTexGenfv(GL2.GL_T, GL2.GL_OBJECT_PLANE, coef_t1, 0);
        	gl.glBegin(GL2.GL_QUADS);
        		frontWallOUTSIDE(gl, glu);
        		backWallOUTSIDE(gl, glu);
        	gl.glEnd();
        	
        	//DRAW RIGHT AND LEFT WALL OUTSIDE WITH AUTO TEXTURE
        	float[] coef_s2 = {0,0.25f,0,0};
            gl.glTexGenfv(GL2.GL_S, GL2.GL_OBJECT_PLANE, coef_s2, 0);
            float[] coef_t2 = {0,0,0.25f,0};
            gl.glTexGenfv(GL2.GL_T, GL2.GL_OBJECT_PLANE, coef_t2, 0);
        	gl.glBegin(GL2.GL_QUADS);
	        	rightWallOUTSIDE(gl, glu);
        		leftWallOUTSIDE(gl, glu);
        	gl.glEnd();
        	
        	//DRAW CEILING OUTSIDE WITH AUTO TEXTURE
        	float[] coef_s3 = {0.25f,0,0,0};
            gl.glTexGenfv(GL2.GL_S, GL2.GL_OBJECT_PLANE, coef_s3, 0);
            float[] coef_t3 = {0,0,0.25f,0};
            gl.glTexGenfv(GL2.GL_T, GL2.GL_OBJECT_PLANE, coef_t3, 0);
        	gl.glBegin(GL2.GL_QUADS);
        		ceilingOUTSIDE(gl, glu);
        	gl.glEnd();
        	
    	gl.glDisable(GL2.GL_TEXTURE_GEN_S);
        gl.glDisable(GL2.GL_TEXTURE_GEN_T);
    	
        frames1++;
        frames2++;
        //RESET TO FIRST FRAME FOR OUTSIDE AND INSIDE WALLS
        if(frames1 > 3){frames1 = 0;}
        if(frames2 > 10){frames2 = 0;}
        
        //DRAW SPHERE IN MIDDLE OF TABLE
    	sphereTexture.bind(gl);
        gl.glPushMatrix();
	        gl.glTranslatef(50, 4, 50); // 5 feet off of ground
	        angle+=10;
	        gl.glRotatef(angle, 1f, 0.25f, 1f);
	        glu.gluSphere(quadric, 1., 10, 10);
	    gl.glPopMatrix();
	    
	    //DRAW TABLE WITH CYLINDER AND DISK
	    tableTexture[(int) frames3].bind(gl);
	    gl.glPushMatrix();
	    	gl.glTranslatef(50, 4, 50);
	    	gl.glRotatef(90, 1f, 0 ,0);
	        glu.gluDisk(quadric, 10, 1, 10, 10);
	        glu.gluCylinder(quadric, 2, 2, 4, 10, 10);
	    gl.glPopMatrix();
	    frames3++;
	    if(frames3>9){frames3=0;}
    
	    gl.glDisable(GL2.GL_TEXTURE_2D);
	    gl.glDisable(GL2.GL_CULL_FACE);

		
		gl.glEnable(GL2.GL_TEXTURE_2D);
    	//DRAW TV WITH STAND
    	tvTexture.bind(gl);
    	gl.glBegin(GL2.GL_QUADS);	
    		TV(gl, glu); //TV WALLS
    	gl.glEnd();
    	gl.glPushMatrix();
    		gl.glTranslatef(14f, 0, 50f);
    		gl.glRotatef(-90, 1f, 0, 0);
    		glu.gluCylinder(quadric, 4, 2, 4, 10, 10); //STAND
		gl.glPopMatrix();	
		gl.glDisable(GL2.GL_TEXTURE_2D);
		gl.glEnable(GL2.GL_TEXTURE_2D);
		//DRAW ANIMATION ON TV
    	tvAnimation[(int) frames4].bind(gl);
    	gl.glBegin(GL2.GL_QUADS);
    		tvAnimation(gl, glu);
    	gl.glEnd();
    gl.glDisable(GL2.GL_TEXTURE_2D);
    frames4++;
    //RESET TO BEGINNING FRAME FOR TV ANIMATION
    if(frames4>10){frames4 = 0;}
	}
	
	@Override
	public void draw(GL2 gl, GLU glu) {
        gl.glEnable(GL2.GL_CULL_FACE);
	        gl.glEnable(GL2.GL_TEXTURE_2D);
	        	
	        //Constructs Ground and Adds Texture
	        	groundTexture.bind(gl);
		        gl.glBegin(GL2.GL_QUADS);
		        	gl.glTexCoord2f(0f, 0f); gl.glVertex3f(0f, 0f, 0f);
		        	gl.glTexCoord2f(0f, 100f); gl.glVertex3f(0f, 0f, 100f);
		        	gl.glTexCoord2f(100f, 100f); gl.glVertex3f(100f,0f,100f);
		        	gl.glTexCoord2f(0f, 100f); gl.glVertex3f(100f, 0f, 0f);
		        gl.glEnd();
		                
	   
	}
	private void tvAnimation(GL2 gl, GLU glu){
		gl.glTexCoord2f(0f, 0f); gl.glVertex3f(17f, 4f, 35f);		
		gl.glTexCoord2f(1f, 0f); gl.glVertex3f(17f, 4f, 65f);
		gl.glTexCoord2f(1f, 1f); gl.glVertex3f(17f, 20f, 65f);
		gl.glTexCoord2f(0f, 1f);  gl.glVertex3f(17f, 20f, 35f);
	}
	
	private void TV(GL2 gl, GLU glu){
        
        //back of tv
        gl.glVertex3f(12f, 4f, 35f);		
    	gl.glVertex3f(12f, 4f, 65f);
    	gl.glVertex3f(12f, 20f, 65f);
        gl.glVertex3f(12f, 20f, 35f);
       
        //bottom of tv
        gl.glVertex3f(12f, 4f, 35f);		
    	gl.glVertex3f(12f, 4f, 65f);
    	gl.glVertex3f(17f, 4f, 65f);
        gl.glVertex3f(17f, 4f, 35f);
        
        //top of tv
        gl.glVertex3f(12f, 20f, 35f);		
    	gl.glVertex3f(12f, 20f, 65f);
    	gl.glVertex3f(17f, 20f, 65f);
        gl.glVertex3f(17f, 20f, 35f);
        
        //side of tv close to entrance
        gl.glVertex3f(12f, 4f, 35f);
        gl.glVertex3f(17f, 4f, 35f);
        gl.glVertex3f(17f, 20f, 35f);
        gl.glVertex3f(12f, 20f, 35f);
        
        //side of tv close to exit
        gl.glVertex3f(12f, 4f, 65f);
        gl.glVertex3f(17f, 4f, 65f);
        gl.glVertex3f(17f, 20f, 65f);
        gl.glVertex3f(12f, 20f, 65f);
		
	}
	
	private void ceilingOUTSIDE(GL2 gl, GLU glu) {
		//Construct CEILING
    	gl.glVertex3f(10f, 50f, 90f);		
    	gl.glVertex3f(90f, 50f, 90f);
    	gl.glVertex3f(90f, 50f, 10f);
        gl.glVertex3f(10f, 50f, 10f);
	}

	private void backWallOUTSIDE(GL2 gl, GLU glu) {
		//Construct BACK wall INSIDE
    	//Wall to LEFT of door
		gl.glVertex3f(10f, 0f, 90f);
		gl.glVertex3f(46f, 0f, 90f);
		gl.glVertex3f(46f, 8f, 90f);
		gl.glVertex3f(10f, 8f, 90f);
    	//Wall to RIGHT of door
		gl.glVertex3f(54f, 0f, 90f);
		gl.glVertex3f(90f, 0f, 90f);
		gl.glVertex3f(90f, 8f, 90f);
		gl.glVertex3f(54f, 8f, 90f);
    	//Wall ABOVE door
		gl.glVertex3f(10f, 8f, 90f);		
		gl.glVertex3f(90f, 8f, 90f);
		gl.glVertex3f(90f, 50f, 90f);
		gl.glVertex3f(10f, 50f, 90f);
	}

	private void leftWallOUTSIDE(GL2 gl, GLU glu) {
		//Construct LEFT wall OUTSIDE
		gl.glVertex3f(10f, 0f, 10f);		
		gl.glVertex3f(10f, 0f, 90f);
		gl.glVertex3f(10f, 50f, 90f);
		gl.glVertex3f(10f, 50f, 10f);
	}

	private void rightWallOUTSIDE(GL2 gl, GLU glu) {
		//Construct RIGHT wall OUTSIDE
		gl.glVertex3f(90f, 50f, 10f);		
		gl.glVertex3f(90f, 50f, 90f);
		gl.glVertex3f(90f, 0f, 90f);
		gl.glVertex3f(90f, 0f, 10f);
	}

	private void frontWallOUTSIDE(GL2 gl, GLU glu) {
		//Construct Front Wall OUTSIDE
    	//Wall to LEFT of door
		gl.glVertex3f(10f, 8f, 10f);
		gl.glVertex3f(46f, 8f, 10f);
		gl.glVertex3f(46f, 0f, 10f);
    	gl.glVertex3f(10f, 0f, 10f);
    	//Wall to RIGHT of door
    	gl.glVertex3f(54f, 8f, 10f);
    	gl.glVertex3f(90f, 8f, 10f);
    	gl.glVertex3f(90f, 0f, 10f);
    	gl.glVertex3f(54f, 0f, 10f);
    	//Wall ABOVE door
    	gl.glVertex3f(10f, 50f, 10f);
    	gl.glVertex3f(90f, 50f, 10f);
    	gl.glVertex3f(90f, 8f, 10f);
    	gl.glVertex3f(10f, 8f, 10f);
	}

	public void frontWallINSIDE(GL2 gl, GLU glu){
		//Construct Front Wall INSIDE
    	//Wall to LEFT of door
    	gl.glTexCoord2f(0f, 0f); gl.glVertex3f(10f, 0f, 10f);
    	gl.glTexCoord2f(2f, 0f); gl.glVertex3f(46f, 0f, 10f);
    	gl.glTexCoord2f(2f, 1f); gl.glVertex3f(46f, 8f, 10f);
    	gl.glTexCoord2f(0f, 1f); gl.glVertex3f(10f, 8f, 10f);
    	//Wall to RIGHT of door
    	gl.glTexCoord2f(0f, 0f); gl.glVertex3f(54f, 0f, 10f);
    	gl.glTexCoord2f(2f, 0f); gl.glVertex3f(90f, 0f, 10f);
    	gl.glTexCoord2f(2f, 1f); gl.glVertex3f(90f, 8f, 10f);
    	gl.glTexCoord2f(0f, 1f); gl.glVertex3f(54f, 8f, 10f);
    	//Wall ABOVE door
    	gl.glTexCoord2f(0f, 0f); gl.glVertex3f(10f, 8f, 10f);
    	gl.glTexCoord2f(5f, 0f); gl.glVertex3f(90f, 8f, 10f);
    	gl.glTexCoord2f(5f, 5f); gl.glVertex3f(90f, 50f, 10f);
    	gl.glTexCoord2f(0f, 5f); gl.glVertex3f(10f, 50f, 10f);
	}
	
	public void rightWallINSIDE(GL2 gl, GLU glu){
		//Construct RIGHT wall INSIDE
		gl.glTexCoord2f(0f, 0f); gl.glVertex3f(90f, 0f, 10f);
		gl.glTexCoord2f(5f, 0f); gl.glVertex3f(90f, 0f, 90f);
		gl.glTexCoord2f(5f, 5f); gl.glVertex3f(90f, 50f, 90f);
		gl.glTexCoord2f(0f, 5f); gl.glVertex3f(90f, 50f, 10f);
	}
	
	public void leftWallINSIDE(GL2 gl, GLU glu){
		//Construct LEFT wall INSIDE
		gl.glTexCoord2f(0f, 5f); gl.glVertex3f(10f, 50f, 10f);
		gl.glTexCoord2f(5f, 5f); gl.glVertex3f(10f, 50f, 90f);
		gl.glTexCoord2f(5f, 0f); gl.glVertex3f(10f, 0f, 90f);
		gl.glTexCoord2f(0f, 0f); gl.glVertex3f(10f, 0f, 10f);
		
	}
	
	public void backWallINSIDE(GL2 gl, GLU glu){
		//Construct BACK wall INSIDE
    	//Wall to LEFT of door
		gl.glTexCoord2f(0f, 1f); gl.glVertex3f(10f, 8f, 90f);
		gl.glTexCoord2f(2f, 1f); gl.glVertex3f(46f, 8f, 90f);
		gl.glTexCoord2f(2f, 0f); gl.glVertex3f(46f, 0f, 90f);
		gl.glTexCoord2f(0f, 0f); gl.glVertex3f(10f, 0f, 90f);
		
    	//Wall to RIGHT of door
		gl.glTexCoord2f(0f, 1f); gl.glVertex3f(54f, 8f, 90f);
		gl.glTexCoord2f(2f, 1f); gl.glVertex3f(90f, 8f, 90f);
		gl.glTexCoord2f(2f, 0f); gl.glVertex3f(90f, 0f, 90f);
		gl.glTexCoord2f(0f, 0f); gl.glVertex3f(54f, 0f, 90f);
		
    	//Wall ABOVE door
		gl.glTexCoord2f(0f, 5f); gl.glVertex3f(10f, 50f, 90f);
		gl.glTexCoord2f(5f, 5f); gl.glVertex3f(90f, 50f, 90f);
		gl.glTexCoord2f(5f, 0f); gl.glVertex3f(90f, 8f, 90f);
		gl.glTexCoord2f(0f, 0f); gl.glVertex3f(10f, 8f, 90f);

	
	}
	public void ceilingINSIDE(GL2 gl, GLU glu){
		//Construct CEILING
    	gl.glTexCoord2f(0f, 0f); gl.glVertex3f(10f, 50f, 10f);
    	gl.glTexCoord2f(5f, 0f); gl.glVertex3f(90f, 50f, 10f);
    	gl.glTexCoord2f(5f, 5f); gl.glVertex3f(90f, 50f, 90f);
    	gl.glTexCoord2f(0f, 5f); gl.glVertex3f(10f, 50f, 90f);
    	//Construct FLOOR
    	/*gl.glTexCoord2f(0f, 5f); gl.glVertex3f(10f, 0, 90f);
    	gl.glTexCoord2f(5f, 5f); gl.glVertex3f(90f, 0, 90f);
    	gl.glTexCoord2f(5f, 0f); gl.glVertex3f(90f, 0, 10f);
    	gl.glTexCoord2f(0f, 0f); gl.glVertex3f(10f, 0, 10f);*/
    	
    	
    	
	}

}
