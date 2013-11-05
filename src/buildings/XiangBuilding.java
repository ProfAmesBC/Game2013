package buildings;
import game.Building;

import javax.media.opengl.*;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;

import com.jogamp.opengl.util.texture.*;
	 
public class XiangBuilding extends Building	{
	
	private GLUquadric quadric; // to control properties of quadric-based objects
    private GLUquadric sphereQuadric; // for Signorile's head
    private Texture brickTexture;     // bricks
    private Texture groundfloorTexture; // for the sphere
    private Texture triangleTexture;
    private Texture homefloorTexture;
    private Texture lampTexture;
    private Texture ballTexture;
    private Texture basketballTexture;
    private Texture insideWallTexture;
	    
    // draw the building and contents.  Called from the main class's display()
   	 public XiangBuilding(GL2 gl, GLU glu) {
   		   super();
           quadric = glu.gluNewQuadric();
           glu.gluQuadricDrawStyle(quadric, GLU.GLU_FILL); // GLU_POINT, GLU_LINE, GLU_FILL, GLU_SILHOUETTE
           glu.gluQuadricNormals  (quadric, GLU.GLU_NONE); // GLU_NONE, GLU_FLAT, or GLU_SMOOTH
           glu.gluQuadricTexture  (quadric, false);        // use true to generate texture coordinates

           sphereQuadric = glu.gluNewQuadric();
           glu.gluQuadricDrawStyle(sphereQuadric, GLU.GLU_FILL);
           glu.gluQuadricNormals  (sphereQuadric, GLU.GLU_NONE);
           glu.gluQuadricTexture  (sphereQuadric, true); // for Signorile's head
           
           brickTexture = setupTexture(gl, "XiangBricks.jpg");
           groundfloorTexture = setupTexture(gl, "XiangFloor.jpg");
           triangleTexture     = setupTexture(gl, "XiangRoof.jpg"); 
           homefloorTexture = setupTexture(gl,"XiangHomeFloor.jpg");
           lampTexture = setupTexture(gl,"XiangLamp.jpg");
           ballTexture = setupTexture(gl, "XiangBall.jpg");
           basketballTexture = setupTexture(gl, "XiangBasketball.jpg");
           insideWallTexture = setupTexture(gl, "XiangWall.jpg");
           // png's don't seem to work any more
       }
   	
       
       
      private float angle=0;
      public void draw(GL2 gl, GLU glu) {
        gl.glPushMatrix();
        gl.glTranslatef(50,10,70); // get to 0<=x<=100, 0<=z<=100 (just a guess)
           // glu.gluSphere(quadric,  radius, slices, stacks)
           // glu.gluCylinder (quadric, base, top, height, slices, stacks)
           // glu.gluDisk(quadric, inner radius, outer radius, slices, stacks)
           
           //Table
           gl.glColor3f(.5f, 0, .5f);
           gl.glPushMatrix();
           	   gl.glTranslatef(-5,0,-20);
               gl.glRotatef(-90f, 1f, 0f, 0f); // stand upright (Y)              
               glu.gluDisk(quadric,.5, 5, 10, 10);
            gl.glPopMatrix();
//          
          gl.glColor3f(.5f, 0, .5f);
          gl.glPushMatrix();
               	 gl.glTranslatef(-5,-10,-20);
                 gl.glRotatef(-90f, 1f, 0f, 0f); // stand upright (Y)              
                 glu.gluCylinder(quadric, .8, .8, 10, 10, 10);
          gl.glPopMatrix();
//             
          gl.glColor3f(.5f, 0, .5f);
          gl.glPushMatrix();
             	 gl.glTranslatef(-7,-10,-23);
                 gl.glRotatef(-90f, 1f, 0f, 0f); // stand upright (Y)              
                 glu.gluCylinder(quadric, .8, .8, 10, 10, 10);
          gl.glPopMatrix();
             
          //the ball on the table
           gl.glEnable(GL2.GL_TEXTURE_2D);
               ballTexture.bind(gl);
               gl.glPushMatrix();
                   gl.glTranslatef(-5,0,-20); // 5 feet off of ground
                   angle += 1;
                   gl.glRotatef(angle, 0,1,0); // spin his head
                   glu.gluSphere(sphereQuadric, 1., 10, 10);
               gl.glPopMatrix();
           gl.glDisable(GL2.GL_TEXTURE_2D);
           
           //Lamp
           gl.glEnable(GL2.GL_TEXTURE_2D);
           ballTexture.bind(gl);
           gl.glPushMatrix();
               gl.glTranslatef(5,1,-10); // 5 feet off of ground
               angle += 3;
               gl.glRotatef(angle, 0,1,0); // spin his head
               glu.gluSphere(sphereQuadric, 1., 10, 10);
           gl.glPopMatrix();
           gl.glDisable(GL2.GL_TEXTURE_2D);
           
           gl.glEnable(GL2.GL_TEXTURE_2D);
           basketballTexture.bind(gl);
           gl.glPushMatrix();
               gl.glTranslatef(5,-1,-10); // 5 feet off of ground
               angle -= 8;
               gl.glRotatef(angle, 0,1,0); // spin his head
               glu.gluSphere(sphereQuadric, 1., 10, 10);
           gl.glPopMatrix();
           gl.glDisable(GL2.GL_TEXTURE_2D);
           gl.glEnable(GL2.GL_TEXTURE_2D);
           ballTexture.bind(gl);
           gl.glPushMatrix();
               gl.glTranslatef(5,-3,-10); // 5 feet off of ground
               angle += 3;
               gl.glRotatef(angle, 0,1,0); // spin his head
               glu.gluSphere(sphereQuadric, 1., 10, 10);
           gl.glPopMatrix();
           gl.glDisable(GL2.GL_TEXTURE_2D);
           gl.glEnable(GL2.GL_TEXTURE_2D);
           basketballTexture.bind(gl);
           gl.glPushMatrix();
               gl.glTranslatef(5,-5,-10); // 5 feet off of ground
               angle -= 8;
               gl.glRotatef(angle, 0,1,0); // spin his head
               glu.gluSphere(sphereQuadric, 1., 10, 10);
           gl.glPopMatrix();
            gl.glDisable(GL2.GL_TEXTURE_2D);
            
            gl.glColor3f(.5f, 0, .5f);
            gl.glPushMatrix();
               	 gl.glTranslatef(5,-10,-10);
                   gl.glRotatef(-90f, 1f, 0f, 0f); // stand upright (Y)              
                   glu.gluCylinder(quadric, 2, 1, 4, 10, 10);
            gl.glPopMatrix();
         
    	  
    	  //front wall
            
            gl.glEnable(GL2.GL_TEXTURE_2D);
            insideWallTexture.bind(gl);
            gl.glBegin(GL2.GL_QUADS);
            gl.glTexCoord2f(0f,6f); gl.glVertex3f(-12,  -10, -8);
            gl.glTexCoord2f(2f,6f); gl.glVertex3f( -4,  -10, -8);
            gl.glTexCoord2f(2f,0f); gl.glVertex3f( -4, 10, -8);
            gl.glTexCoord2f(0f,0f); gl.glVertex3f(-12, 10, -8);
            gl.glEnd();
            gl.glBegin(GL2.GL_QUADS);
            gl.glTexCoord2f(0f,6f); gl.glVertex3f(4,  -10, -8);
            gl.glTexCoord2f(2f,6f); gl.glVertex3f( 12,  -10, -8);
            gl.glTexCoord2f(2f,0f); gl.glVertex3f( 12, 10, -8);
            gl.glTexCoord2f(0f,0f); gl.glVertex3f(4, 10, -8);
            gl.glEnd();
           
            
              gl.glEnable(GL2.GL_CULL_FACE);
              gl.glEnable(GL2.GL_TEXTURE_2D);
               brickTexture.bind(gl);
               gl.glBegin(GL2.GL_QUADS);
                   gl.glTexCoord2f(0f,6f); gl.glVertex3f(-12,  -10, -8);
                   gl.glTexCoord2f(2f,6f); gl.glVertex3f( -12,  10, -8);
                   gl.glTexCoord2f(2f,0f); gl.glVertex3f( -4, 10, -8);
                   gl.glTexCoord2f(0f,0f); gl.glVertex3f(-4, -10, -8);
               gl.glEnd();
               gl.glDisable(GL2.GL_CULL_FACE);
              
               
               
               gl.glEnable(GL2.GL_CULL_FACE);
               gl.glBegin(GL2.GL_QUADS);
               gl.glTexCoord2f(0f,6f); gl.glVertex3f(4,  -10, -8);
               gl.glTexCoord2f(2f,6f); gl.glVertex3f( 12,  -10, -8);
               gl.glTexCoord2f(2f,0f); gl.glVertex3f( 12, 10, -8);
               gl.glTexCoord2f(0f,0f); gl.glVertex3f(4, 10, -8);
               gl.glEnd();
               gl.glDisable(GL2.GL_CULL_FACE);
               
               gl.glEnable(GL2.GL_CULL_FACE);
               lampTexture.bind(gl);
               gl.glBegin(GL2.GL_QUADS);
               gl.glTexCoord2f(0f,1f); gl.glVertex3f(-4,  10/3, -8);
               gl.glTexCoord2f(1f,1f); gl.glVertex3f( 4,  10/3, -8);
               gl.glTexCoord2f(1f,0f); gl.glVertex3f( 4, 10, -8);
               gl.glTexCoord2f(0f,0f); gl.glVertex3f(-4, 10, -8);
               gl.glEnd();
               gl.glDisable(GL2.GL_TEXTURE_2D);
               gl.glDisable(GL2.GL_CULL_FACE);
         
           //back wall
         
           
           gl.glEnable(GL2.GL_TEXTURE_2D);
           insideWallTexture.bind(gl);
           gl.glBegin(GL2.GL_QUADS);
       	   gl.glTexCoord2f(0f,6f); gl.glVertex3f(-12,  -10, -32);
           gl.glTexCoord2f(2f,6f); gl.glVertex3f(-4,  -10, -32);
           gl.glTexCoord2f(2f,0f); gl.glVertex3f(-4, 10, -32);
           gl.glTexCoord2f(0f,0f); gl.glVertex3f(-12, 10, -32);
           gl.glEnd();
           gl.glBegin(GL2.GL_QUADS);
   	       gl.glTexCoord2f(0f,6f); gl.glVertex3f(4,  -10, -32);
   	       gl.glTexCoord2f(2f,6f); gl.glVertex3f(12,  -10, -32);
   	       gl.glTexCoord2f(2f,0f); gl.glVertex3f(12, 10, -32);
   	       gl.glTexCoord2f(0f,0f); gl.glVertex3f(4, 10, -32);
           gl.glEnd();
           gl.glDisable(GL2.GL_CULL_FACE);
           
           gl.glEnable(GL2.GL_CULL_FACE);
           brickTexture.bind(gl);
           gl.glBegin(GL2.GL_QUADS);
           	   gl.glTexCoord2f(0f,6f); gl.glVertex3f(-12,  -10, -32);
               gl.glTexCoord2f(2f,6f); gl.glVertex3f(-4,  -10, -32);
               gl.glTexCoord2f(2f,0f); gl.glVertex3f(-4, 10, -32);
               gl.glTexCoord2f(0f,0f); gl.glVertex3f(-12, 10, -32);
           gl.glEnd();
           
           gl.glBegin(GL2.GL_QUADS);
       	       gl.glTexCoord2f(0f,6f); gl.glVertex3f(4,  -10, -32);
       	       gl.glTexCoord2f(2f,6f); gl.glVertex3f(12,  -10, -32);
       	       gl.glTexCoord2f(2f,0f); gl.glVertex3f(12, 10, -32);
       	       gl.glTexCoord2f(0f,0f); gl.glVertex3f(4, 10, -32);
           gl.glEnd();
           
           lampTexture.bind(gl);
           gl.glBegin(GL2.GL_QUADS);
       	       gl.glTexCoord2f(0f,1f); gl.glVertex3f(-4,  10/3, -32);
       	       gl.glTexCoord2f(1f,1f); gl.glVertex3f(4,  10/3, -32);
       	       gl.glTexCoord2f(1f,0f); gl.glVertex3f(4, 10, -32);
       	       gl.glTexCoord2f(0f,0f); gl.glVertex3f(-4, 10, -32);
           gl.glEnd();
           gl.glDisable(GL2.GL_CULL_FACE);
           
           gl.glDisable(GL2.GL_TEXTURE_2D);
           
    
           
           //left and right wall
           gl.glEnable(GL2.GL_TEXTURE_2D);
           brickTexture.bind(gl);
           gl.glBegin(GL2.GL_QUADS);
               gl.glTexCoord2f(0f,6f); gl.glVertex3f(-12,  -10, -32);
               gl.glTexCoord2f(6f,6f); gl.glVertex3f(-12,  -10, -8);
               gl.glTexCoord2f(6f,0f); gl.glVertex3f(-12, 10, -8);
               gl.glTexCoord2f(0f,0f); gl.glVertex3f(-12, 10, -32);
           gl.glEnd();
           
           gl.glBegin(GL2.GL_QUADS);
      		gl.glTexCoord2f(0f,6f); gl.glVertex3f(12,  -10, -32);
      		gl.glTexCoord2f(6f,6f); gl.glVertex3f(12,  -10, -8);
      		gl.glTexCoord2f(6f,0f); gl.glVertex3f(12, 10, -8);
      		gl.glTexCoord2f(0f,0f); gl.glVertex3f(12, 10, -32);
      	   gl.glEnd();
           gl.glDisable(GL2.GL_TEXTURE_2D);
            
            //draw roof
           gl.glEnable(GL2.GL_TEXTURE_2D);
               triangleTexture.bind(gl);
               gl.glBegin(GL2.GL_TRIANGLES);
               	gl.glTexCoord2f(0f,4f);gl.glVertex3f(-12, 10, -8);
               	gl.glTexCoord2f(4f,4f);gl.glVertex3f(0, 18, -20);
               	gl.glTexCoord2f(4f,0f);gl.glVertex3f(12, 10, -8);
              gl.glEnd();
           gl.glDisable(GL2.GL_TEXTURE_2D);
           
           gl.glEnable(GL2.GL_TEXTURE_2D);
           triangleTexture.bind(gl);
           gl.glBegin(GL2.GL_TRIANGLES);
           	gl.glTexCoord2f(0f,4f);gl.glVertex3f(-12, 10, -8);
           	gl.glTexCoord2f(4f,4f);gl.glVertex3f(0, 18, -20);
           	gl.glTexCoord2f(4f,0f);gl.glVertex3f(-12, 10, -32);
          gl.glEnd();
      	  gl.glDisable(GL2.GL_TEXTURE_2D);
       
          gl.glEnable(GL2.GL_TEXTURE_2D);
          triangleTexture.bind(gl);
          gl.glBegin(GL2.GL_TRIANGLES);
       		gl.glTexCoord2f(0f,4f);gl.glVertex3f(-12, 10, -32);
       		gl.glTexCoord2f(4f,4f);gl.glVertex3f(0, 18, -20);
       		gl.glTexCoord2f(4f,0f);gl.glVertex3f(12, 10, -32);
       	  gl.glEnd();
         gl.glDisable(GL2.GL_TEXTURE_2D);
   
         gl.glEnable(GL2.GL_TEXTURE_2D);
         triangleTexture.bind(gl);
         gl.glBegin(GL2.GL_TRIANGLES);
         	gl.glTexCoord2f(0f,4f);gl.glVertex3f(12, 10, -32);
         	gl.glTexCoord2f(4f,4f);gl.glVertex3f(0, 18, -20);
         	gl.glTexCoord2f(4f,0f);gl.glVertex3f(12, 10, -8);
        gl.glEnd();
        gl.glDisable(GL2.GL_TEXTURE_2D);

        
        //Draw Home Floor
        gl.glEnable(GL2.GL_TEXTURE_2D);
        homefloorTexture.bind(gl);
        gl.glBegin(GL2.GL_QUADS);
        		gl.glTexCoord2f(6f,0f); gl.glVertex3f(12,  -10, -8);
        		gl.glTexCoord2f(6f,6f); gl.glVertex3f(-12,  -10, -8);
        		gl.glTexCoord2f(0f,6f); gl.glVertex3f(-12, -10, -32);
        		gl.glTexCoord2f(0f,0f); gl.glVertex3f(12, -10, -32);
        gl.glEnd();
        gl.glDisable(GL2.GL_TEXTURE_2D);
        
           gl.glEnable(GL2.GL_TEXTURE_2D);
           groundfloorTexture.bind(gl);
           gl.glBegin(GL2.GL_QUADS);
               	gl.glTexCoord2f(0f,4f);gl.glVertex3f(-36, -10, -8);
               	gl.glTexCoord2f(12f,4f);gl.glVertex3f(36, -10, -8);
               	gl.glTexCoord2f(12f,0f);gl.glVertex3f(36, -10, 16);
               	gl.glTexCoord2f(0f,0f);gl.glVertex3f(-36,-10,16);
           gl.glEnd();
           
           gl.glBegin(GL2.GL_QUADS);
          		gl.glTexCoord2f(0f,4f);gl.glVertex3f(-36, -10, -32);
          		gl.glTexCoord2f(4f,4f);gl.glVertex3f(-12, -10, -32);
          		gl.glTexCoord2f(4f,0f);gl.glVertex3f(-12, -10, -8);
          		gl.glTexCoord2f(0f,0f);gl.glVertex3f(-36,-10,-8);
           gl.glEnd();
           
            gl.glBegin(GL2.GL_QUADS);
     		gl.glTexCoord2f(0f,4f);gl.glVertex3f(12, -10, -32);
     		gl.glTexCoord2f(4f,4f);gl.glVertex3f(36, -10, -32);
     		gl.glTexCoord2f(4f,0f);gl.glVertex3f(36, -10, -8);
     		gl.glTexCoord2f(0f,0f);gl.glVertex3f(12,-10,-8);
     		gl.glEnd();
     		
     		gl.glBegin(GL2.GL_QUADS);
      		gl.glTexCoord2f(0f,4f);gl.glVertex3f(-36, -10, -56);
      		gl.glTexCoord2f(12f,4f);gl.glVertex3f(36, -10, -56);
      		gl.glTexCoord2f(12f,0f);gl.glVertex3f(36, -10, -32);
      		gl.glTexCoord2f(0f,0f);gl.glVertex3f(-36,-10,-32);
            gl.glEnd();
           gl.glDisable(GL2.GL_TEXTURE_2D);
         gl.glPopMatrix();
      }
      
      
	    
}
