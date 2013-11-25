package inventory;

import game.Building;
import game.PlayerAttributes;
import game.PlayerMotion;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;

import com.jogamp.opengl.util.texture.Texture;

public class SpeedBox implements PowerUp {
	private Texture textureItem;	
	private float itemX,itemY,itemZ;
	private float playerX,playerY,playerZ;
	private float angle;
	private boolean grabbed;	
	private double T;
	private Bag bag;
	private static PlayerAttributes p;
	private int frames;
	
	public SpeedBox(GL2 gl, GLU glu,float x, float y, float z, Bag bag, PlayerAttributes p) {		
		textureItem = Building.setupTexture(gl, "textureItem.png");			
		this.itemX=x;
		this.itemY=y;
		this.itemZ=z;					
		PlayerMotion.registerPlayerWatcher(this);
		this.bag = bag;
		this.p = p;
		grabbed = false;
		frames = 0;
	}
	
	public SpeedBox() {
		// dummy constructor
	}
 
	public void draw(GL2 gl, GLU glu) {				
		frames++;
		T = T + 0.05;
		if((itemX-3<playerX && itemZ-3<playerZ) && (itemX+5>playerX) && (itemZ+5>playerZ) && grabbed == false) {
			grabbed = true;
			bag.addItem(this);			
		}
		
		if(!grabbed){
			drawPowerUp(gl,glu);
		}
	}
	public boolean grabbed(){return grabbed;}

	public double getLocationX(){
		return itemX;	
	}
	public double getLocationY(){
		return itemY;	
	}
	public double getLocationZ(){
		return itemZ;	
	}
	public void SetLocation(int x,int y, int z){
		this.itemX=x;
		this.itemY=y;
		this.itemZ=z;
	}
	public void setAngle(int angle){
		this.angle = angle;
	}
	public double getAngle(){
		return angle; 
	}

	public void use() {
		float currentSpeed = p.getStepSize();
		p.setStepSize(currentSpeed*2);
	}
	
	public String getType() {
		return "Speed";
	}
	
	public void drawPowerUp(GL2 gl, GLU glu){		
		
		gl.glEnable(GL2.GL_CULL_FACE);
		gl.glEnable(GL2.GL_TEXTURE_2D);
		gl.glPushMatrix();		
		gl.glTranslated(itemX, Math.sin(Math.toRadians(T*360+180 ))+2, itemZ);
		//gl.glRotated(Math.toRadians(15*frames), Math.toRadians(15*frames), Math.toRadians(15*frames), 1);
		//gl.glTranslated(-itemX, -(Math.sin(Math.toRadians(T*360+180 ))+2), -itemZ);
		textureItem.bind(gl);
		
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
		this.playerX = x;
		this.playerY = y;
		this.playerZ = z;
		this.angle = angle;
	}

}