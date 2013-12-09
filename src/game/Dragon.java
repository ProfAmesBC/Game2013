package game;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;

public class Dragon {
	
	private SketchupModelJAXB[] frames = new SketchupModelJAXB[10];
	private int currentFrame = 0;
	private int frameDirection = 1;
	private double x = 400;
	private double z = 0;
	private double direction = 1;
	private double angle = 0;
	private int FPS;
	
	public Dragon(GL2 gl, GLU glu, int FPS){
		frames[0] = new SketchupModelJAXB("DragonLegsUp.dae", gl, glu);
		for(int i=1; i< 10; i++){
			frames[i] = new SketchupModelJAXB("DragonLegsUpDown" + (i*10) + ".dae", gl, glu);
		}
		this.FPS = FPS;
		//just a comment
	}
	
	private void angle(){
		angle = Math.atan(this.direction*-Math.PI*Math.cos(Math.PI*(this.x-100)/200));
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
	}
}
