package catsrabbits;
// Diana Cheung, CS333 Class of 2013

import javax.media.opengl.GL2;import javax.media.opengl.glu.GLU;
import game.Building;import java.io.File;

public class Cat extends Critter{
	public Cat(float x,float y,float z,float a,float s,float tR, GL2 gl,GLU glu){
		super(x,y,z,a,s,tR,gl,glu);
		tRate=.025f;
        texture=Building.setupTexture(gl, FUR_DIRECTORY+File.separator+"cheungcatfur"+(int)(Math.random()*5)+".jpg");
	}
	
	public void drawWholeBody(GL2 gl, GLU glu){
		gl.glPushMatrix();
			gl.glEnable(GL2.GL_TEXTURE_2D);
			texture.bind(gl);
			// draw body
			gl.glDisable(GL2.GL_TEXTURE_2D);
			// TODO
		gl.glPopMatrix();
	}
	
	protected void drawBody(GL2 gl, GLU glu){
		// TODO Auto-generated method stub
		
	}
	protected void drawHead(GL2 gl, GLU glu){
		// TODO Auto-generated method stub
		
	}
	protected void drawNose(GL2 gl,GLU glu){
		// TODO Auto-generated method stub
		
	}
	protected void drawEar(GL2 gl, GLU glu){
		// TODO Auto-generated method stub
		
	}
	protected void drawFeet(GL2 gl, GLU glu) {
		// TODO Auto-generated method stub
		
	}
	protected void drawTail(GL2 gl, GLU glu) {
		// TODO Auto-generated method stub
		
	}
}
