package catsrabbits;

import javax.media.opengl.GL2;import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;
import com.jogamp.opengl.util.texture.Texture;
import game.Building;

public class Rabbit{
	private float x,y,z,angle,speed,t=0;
	private GLUquadric textureQuadric,quadric;
	private Texture texture;
	
	public Rabbit(float x,float y,float z,float a,float s, GL2 gl, GLU glu,int col){
		this.x=x;this.y=y;this.z=z;
		angle=a;speed=s;
		
		textureQuadric = glu.gluNewQuadric();
        glu.gluQuadricDrawStyle(textureQuadric, GLU.GLU_FILL); // GLU_POINT, GLU_LINE, GLU_FILL, GLU_SILHOUETTE
        glu.gluQuadricNormals  (textureQuadric, GLU.GLU_NONE); // GLU_NONE, GLU_FLAT, or GLU_SMOOTH
        glu.gluQuadricTexture  (textureQuadric, true);        // use true to generate texture coordinates
        
        quadric = glu.gluNewQuadric();
        glu.gluQuadricDrawStyle(quadric, GLU.GLU_FILL); // GLU_POINT, GLU_LINE, GLU_FILL, GLU_SILHOUETTE
        glu.gluQuadricNormals  (quadric, GLU.GLU_NONE); // GLU_NONE, GLU_FLAT, or GLU_SMOOTH
        glu.gluQuadricTexture  (quadric, false);        // use true to generate texture coordinates
        
        texture=Building.setupTexture(gl, "cheungrabbitfur"+col+".png");
	}
	
	public float getX(){return x;}
	public float getY(){return y;}
	public float getZ(){return z;}
	public float getAngle(){return angle;}
	public float getSpeed(){return speed;}
	
	public void draw(GL2 gl, GLU glu) {
		// TODO Auto-generated method stub
		
		move();
	}
	
	private void move(){
		double radians=Math.toRadians(angle);
		x-=Math.cos(radians)*speed;
		z+=Math.sin(radians)*speed;
		
		if(t>=1f)t=0;
		else t+=.025;
	}
}
