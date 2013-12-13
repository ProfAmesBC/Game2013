
package game;

import java.util.ArrayList;
import java.util.List;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;

public class Dragon {
	
	private SketchupModelJAXB[] frames = new SketchupModelJAXB[10];
	private int currentFrame = 0;
	private int frameDirection = 1;
	private double x = 0; //200;
	private double z = 0;
	private double direction = 1;
	private double angle = 0;
	private int FPS;
	private int fireCounter = 0;
	private List<Fire> flames = new ArrayList<Fire>();
	
	public Dragon(GL2 gl, GLU glu, int FPS){
		frames[0] = new SketchupModelJAXB("DragonLegsUp.dae", gl, glu);
		for(int i=1; i< 10; i++){
			frames[i] = new SketchupModelJAXB("DragonLegsUpDown" + (i*10) + ".dae", gl, glu);
		}
		this.FPS = FPS;
	}
	
	private void angle(){
		angle = Math.atan(this.direction*-Math.PI*Math.cos(Math.PI*(this.x-100)/200));
	}
	
	private void spitFire(GL2 gl, GLU glu){
		flames.add(new Fire( -15, 6, -20, angle, gl, glu));
		
	}
	
	private void z(){
		z = 300+(this.direction*200*Math.sin(Math.PI*(x - 100)/200));
	}
	
	private void changeFrame(){
		if(currentFrame == 9){
			frameDirection = -1;
		}
		else if(currentFrame == 0){
			frameDirection = 1;
		}
	}
	
	public void draw(GL2 gl, GLU glu){
//		System.out.println("Dragon at: " + this.x + " " + (300+this.direction*200*Math.sin(Math.PI*(x - 100)/200)));
		gl.glPushMatrix();
			gl.glTranslated(this.x, 20, this.z);
			gl.glRotated((this.direction * 90) + Math.toDegrees(this.angle), 0, 1, 0);
			frames[this.currentFrame].draw(gl, glu);
		gl.glPopMatrix();
		
		changeFrame();
		this.currentFrame += this.frameDirection;
		this.x += this.direction * 20/60;
		
		angle();
		z();
		
		if(x <= 100){
			this.direction = 1;
		}
		
		else if(x >= 500){
			this.direction = -1;
		}
		
		fireCounter++;
		if (fireCounter == 5 * FPS){
			fireCounter = 0;
//			if(flames.size() == 0){
				spitFire(gl, glu);
//			}
		}
		gl.glPushMatrix();
			gl.glTranslated(this.x, 20, this.z);
			gl.glRotated((this.direction * 90) + 90 + + 130 + Math.toDegrees(this.angle), 0, 1, 0);
			for(Fire fire : flames){
				fire.draw(gl, glu);
			}
		gl.glPopMatrix();
	}
}