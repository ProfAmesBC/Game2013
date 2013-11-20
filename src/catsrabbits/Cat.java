// Diana Cheung, CS333 Class of 2013
package catsrabbits;

import javax.media.opengl.GL2;import javax.media.opengl.glu.GLU;
import game.Building;

public class Cat extends Critter{
	public Cat(float x,float y,float z,float a,float s,float tR, GL2 gl,GLU glu){
		super(x,y,z,a,s,tR,gl,glu);
		tRate=.025f;
        texture=Building.setupTexture(gl, "cheungcatfur"+(Math.random()*5)+".jpg");
	}
	
	public void drawWholeBody(GL2 gl, GLU glu){
		// TODO
	}
}
