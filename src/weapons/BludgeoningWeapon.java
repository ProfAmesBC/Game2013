package weapons;

import game.PlayerMotion;
import game.PlayerMotionWatcher;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;

// make a class that holds list of all projectiles and iter thru to update - called once from main game

public class BludgeoningWeapon implements KeyListener, PlayerMotionWatcher{
	
	private float x, y, z, angle;	// where player is
	private float weaponX, weaponY, weaponZ;	// position of weapon
	private GLUquadric quadric;
	private int frames, lengthOfHit; // the counter to determine how long the weapon is being swung for
	private float reach = 5; 
	private float dist = 0;
	private GL2 gl;
	private GLU glu;
	private boolean hit;
	private PipeWeapon p;
	
	public BludgeoningWeapon(){
//		this.gl = gl;
//		this.glu = glu;
		hit = false;
				
		PlayerMotion.registerPlayerWatcher(this);
		
//		quadric = glu.gluNewQuadric();
//        glu.gluQuadricDrawStyle(quadric, GLU.GLU_FILL); // GLU_POINT, GLU_LINE, GLU_FILL, GLU_SILHOUETTE
//        glu.gluQuadricNormals  (quadric, GLU.GLU_NONE); // GLU_NONE, GLU_FLAT, or GLU_SMOOTH
//        glu.gluQuadricTexture  (quadric, false);
	}
	
	// fix this with keylistener stuff...
	public void init(GL2 gl, GLU glu){
		this.gl = gl;
		this.glu = glu;
		lengthOfHit = 25;	// duration of hit in frames
		p = new PipeWeapon(gl, glu);
		
		quadric = glu.gluNewQuadric();
        glu.gluQuadricDrawStyle(quadric, GLU.GLU_FILL); // GLU_POINT, GLU_LINE, GLU_FILL, GLU_SILHOUETTE
        glu.gluQuadricNormals  (quadric, GLU.GLU_NONE); // GLU_NONE, GLU_FLAT, or GLU_SMOOTH
        glu.gluQuadricTexture  (quadric, false);
	}
	
	public void update(GL2 gl, GLU glu){
//		weaponX = (float) (x + speed*Math.cos(Math.toRadians(angle)));
//		weaponZ = (float) (z - speed*Math.sin(Math.toRadians(angle)));
		
		if (hit){
			
			weaponX =  (float) (Math.cos(Math.toRadians(angle)));
			weaponZ = -(float) (Math.sin(Math.toRadians(angle)));
			
			if (frames < lengthOfHit/2){
				
				gl.glPushMatrix();
					gl.glTranslatef(x+weaponX * dist/5, y, z+ weaponZ * dist/5);	// draw at person
					gl.glRotatef(-90, 1, 0, 0);
					p.draw(gl, glu);
				gl.glPopMatrix();

//				weaponX++; weaponZ++;
				dist++;
				frames++;
		}
			else if (frames >= lengthOfHit/2 && frames < lengthOfHit){
				gl.glPushMatrix();
					gl.glTranslatef(x+weaponX * dist/5, y, z+ weaponZ * dist/5);	// draw at person
					gl.glRotatef(-90, 1, 0, 0);
					p.draw(gl, glu);
				gl.glPopMatrix();
				
//				weaponX--; weaponZ--;
				dist --;
				frames++;
			}
			else { 
				System.out.println("ok");
				weaponX = weaponY = weaponZ = 0;
				frames = 0;
				dist = 0;
				
				hit = false; }
		}
	}
	
//	public void update(GL2 gl, GLU glu){
//		if (hit){
//			
//			if (frames < lengthOfHit/2){
////				gl.glColor3f(1f,0f,.25f);
//				gl.glPushMatrix();
//					gl.glTranslatef(x + weaponX+10, y, z );	// draw at person
//					gl.glRotatef(-90, 1, 0, 0);
//					p.draw(gl, glu);
////					glu.gluSphere(quadric, 1, 10, 10);
//				gl.glPopMatrix();
//				weaponX++; weaponZ++;
//				frames++;
//			}
//			else if (frames >= lengthOfHit/2 && frames < lengthOfHit){
//				gl.glPushMatrix();
//					gl.glTranslatef(x + weaponX+10, y, z );	// draw at person
//					gl.glRotatef(-90, 1, 0, 0);
//					p.draw(gl, glu);
////					glu.gluSphere(quadric, 1, 10, 10);
//				gl.glPopMatrix();
//				weaponX--; weaponZ--;
//				frames++;
//			}
////			frames++;
//			else { 
//				System.out.println("ok");
//				weaponX = weaponY = weaponZ = 0;
//				frames = 0;
//				
//				hit = false; }
//		}
//	}
	
	// figure out where player is looking, also!
	@Override
	public void playerMoved(float x, float y, float z, float angle) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.angle = angle;
	}

	@Override
	public void keyTyped(KeyEvent e) {}

	// this seems like a convoluted way to do things
	// make sure only one bat at a time
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_O){	// add functionality later to toggle between weapons or to have a "current weapon"
			System.out.println("!!!!");
			hit = true;
//			weaponX = 0; weaponY = 0; weaponZ = 10;
//			weaponX = (float) (x + speed*Math.cos(Math.toRadians(angle)));
//			weaponZ = (float) (z - speed*Math.sin(Math.toRadians(angle)));
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {}
}
