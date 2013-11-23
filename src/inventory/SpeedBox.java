package inventory;
import game.Building;
import game.PlayerMotion;
import game.PlayerMotionWatcher;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;

import com.jogamp.opengl.util.texture.Texture;

public class SpeedBox implements PowerUp,PlayerMotionWatcher{
	private Texture batTexture,ceilingTexture, brickTexture, fireTexture,eyesTexture, textureItem;	
	private float x,y,z,a,c,d;
	private float  angle;
	private  GLUquadric sphere;
	boolean grabbed = false; 
	boolean alreadyAdded = false;



	public SpeedBox(GL2 gl, GLU glu,float a, float c,float x, float y, float z) {
		
		textureItem = Building.setupTexture(gl, "textureItem.png");	
		this.sphere = glu.gluNewQuadric();
		this.x=x;
		this.y=y;
		this.z=z;		
		angle = 2;
		this.a = a;
		this.c = c;
		PlayerMotion.registerPlayerWatcher(this);
	}
	private float frames = 0;
 
	public void draw(GL2 gl, GLU glu,double T) {				
		if((x-3<a && z-3<c) && (x+5>a) && (z+5>c)) grabbed = true;		
		if(!grabbed){
			drawPowerUp(gl,glu,T);
		}
		frames++;
	}

	public double getLocationX(){
		return x;	
	}
	public double getLocationY(){
		return y;	
	}
	public double getLocationZ(){
		return z;	
	}
	public void SetLocation(int x,int y, int z){
		this.x=x;
		this.y=y;
		this.z=z;
	}
	public void setAngle(int angle){
		this.angle = angle;
	}
	public double getAngle(){
		return angle;
	}

	@Override
	public boolean checkPlayerLocation() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean addToInventory() {
		if(alreadyAdded == false && grabbed == true){			
			return true;			
		}
		else return false;

	}
	@Override
	public void use() {
		// TODO Auto-generated method stub

	}
	public void drawPowerUp(GL2 gl, GLU glu, double T){		
		gl.glEnable(GL2.GL_CULL_FACE);
		gl.glEnable(GL2.GL_TEXTURE_2D);
		gl.glTranslated(x, Math.sin(Math.toRadians(T*360+180 ))+2, z);
		//gl.glRotated(Math.toRadians(15*frames), Math.toRadians(15*frames), Math.toRadians(15*frames), 1);
		textureItem.bind(gl);
		gl.glPushMatrix();		
		//front face item
		gl.glBegin(GL2.GL_QUADS);
		gl.glTexCoord2f(0f,2f); gl.glVertex3f(-2.5f, 0, 0);
		gl.glTexCoord2f(3f,2f); gl.glVertex3f( 2.5f, 0, 0);
		gl.glTexCoord2f(3f,0f); gl.glVertex3f( 2.5f, 5, 0);
		gl.glTexCoord2f(0f,0f); gl.glVertex3f(-2.5f, 5, 0);
		gl.glEnd();		
		
		gl.glBegin(GL2.GL_QUADS);
		// cw as viewed from front, so can be seen as ccw from back		
		gl.glTexCoord2f(0f,2f); gl.glVertex3f(-2.5f, 0, 0);
		gl.glTexCoord2f(0f,0f); gl.glVertex3f(-2.5f, 5, 0);							
		gl.glTexCoord2f(3f,0f); gl.glVertex3f( 2.5f, 5, 0);
		gl.glTexCoord2f(3f,2f); gl.glVertex3f( 2.5f, 0, 0);
		gl.glEnd();	

		//backwall 		
		gl.glBegin(GL2.GL_QUADS);
		gl.glTexCoord2f(0f,2f); gl.glVertex3f(-2.5f, 0, -5);
		gl.glTexCoord2f(3f,2f); gl.glVertex3f( 2.5f, 0, -5);
		gl.glTexCoord2f(3f,0f); gl.glVertex3f( 2.5f, 5, -5);
		gl.glTexCoord2f(0f,0f); gl.glVertex3f(-2.5f, 5, -5);
		gl.glEnd();		
		gl.glBegin(GL2.GL_QUADS);// good side of quesiton mark 
		// cw as viewed from front, so can be seen as ccw from back		
		gl.glTexCoord2f(0f,0f); gl.glVertex3f(-2.5f,  0, -5);
		gl.glTexCoord2f(0f,1f); gl.glVertex3f(-2.5f, 5, -5);
		gl.glTexCoord2f(1f,1f); gl.glVertex3f( 2.5f, 5, -5);
		gl.glTexCoord2f(1f,0f); gl.glVertex3f( 2.5f,  0, -5);							
		gl.glEnd();	

		//leftwall
		gl.glBegin(GL2.GL_QUADS);
		gl.glTexCoord2f(0f,2f); gl.glVertex3f(-2.5f, 0, 0);
		gl.glTexCoord2f(3f,2f); gl.glVertex3f(-2.5f, 5, 0);
		gl.glTexCoord2f(3f,0f); gl.glVertex3f(-2.5f, 5, -5);
		gl.glTexCoord2f(0f,0f); gl.glVertex3f(-2.5f, 0, -5);
		gl.glEnd();		
		gl.glBegin(GL2.GL_QUADS);
		gl.glTexCoord2f(0f,2f); gl.glVertex3f(-2.5f, 0, 0);
		gl.glTexCoord2f(0f,0f); gl.glVertex3f(-2.5f, 0, -5);
		gl.glTexCoord2f(3f,0f); gl.glVertex3f(-2.5f, 5, -5);
		gl.glTexCoord2f(3f,2f); gl.glVertex3f(-2.5f, 5, 0);
		gl.glEnd();	

		//Rightwall
		gl.glBegin(GL2.GL_QUADS);
		gl.glTexCoord2f(0f,2f); gl.glVertex3f(2.5f, 0, 0);
		gl.glTexCoord2f(3f,2f); gl.glVertex3f(2.5f, 5, 0);
		gl.glTexCoord2f(3f,0f); gl.glVertex3f(2.5f, 5, -5);
		gl.glTexCoord2f(0f,0f); gl.glVertex3f(2.5f, 0, -5);
		gl.glEnd();		
		gl.glBegin(GL2.GL_QUADS);
		gl.glTexCoord2f(0f,2f); gl.glVertex3f(2.5f, 0, 0);
		gl.glTexCoord2f(0f,0f); gl.glVertex3f(2.5f, 0, -5);
		gl.glTexCoord2f(3f,0f); gl.glVertex3f(2.5f, 5, -5);
		gl.glTexCoord2f(3f,2f); gl.glVertex3f(2.5f, 5, 0);
		gl.glEnd();	

		//floor
		gl.glBegin(GL2.GL_QUADS);
		gl.glTexCoord2f(0f,2f); gl.glVertex3f(2.5f, 0, 0);
		gl.glTexCoord2f(3f,2f); gl.glVertex3f(2.5f, 0, -5);
		gl.glTexCoord2f(3f,0f); gl.glVertex3f(-2.5f, 0, -5);
		gl.glTexCoord2f(0f,0f); gl.glVertex3f(-2.5f, 0, 0);
		gl.glEnd();		
		gl.glBegin(GL2.GL_QUADS);
		gl.glTexCoord2f(0f,2f); gl.glVertex3f(2.5f, 0, 0);
		gl.glTexCoord2f(0f,0f); gl.glVertex3f(-2.5f, 0, 0);				
		gl.glTexCoord2f(3f,0f); gl.glVertex3f(-2.5f, 0, -5);
		gl.glTexCoord2f(3f,2f); gl.glVertex3f(2.5f, 0, -5);
		gl.glEnd();	

		//ceiling
		gl.glBegin(GL2.GL_QUADS);
		gl.glTexCoord2f(0f,2f); gl.glVertex3f(2.5f, 5, 0);
		gl.glTexCoord2f(3f,2f); gl.glVertex3f(2.5f, 5, -5);
		gl.glTexCoord2f(3f,0f); gl.glVertex3f(-2.5f, 5, -5);
		gl.glTexCoord2f(0f,0f); gl.glVertex3f(-2.5f, 5, 0);
		gl.glEnd();		
		gl.glBegin(GL2.GL_QUADS);
		gl.glTexCoord2f(0f,2f); gl.glVertex3f(2.5f, 5, 0);
		gl.glTexCoord2f(0f,0f); gl.glVertex3f(0f, 5, 0);				
		gl.glTexCoord2f(3f,0f); gl.glVertex3f(0f, 5, -5);
		gl.glTexCoord2f(3f,2f); gl.glVertex3f(2.5f, 5, -5);
		gl.glEnd();	


		gl.glPopMatrix();

		gl.glDisable(GL2.GL_CULL_FACE);		
		gl.glDisable(GL2.GL_TEXTURE_2D);
	}
	@Override	
	public void playerMoved(float x, float y, float z, float angle) {
		//GET CURRENT POSITION OF PLAYER TO USE TO MAKE BULLET
		this.a = x;
		this.d = y;
		this.c = z;
		this.angle = angle;
	}

}

