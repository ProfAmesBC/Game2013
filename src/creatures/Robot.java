package creatures;

import java.util.LinkedList;
import java.util.List;

import game.BatsEverywhere;
import game.PlayerMotion;
import game.PlayerMotionWatcher;
import game.PlayerStats;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;

import com.jogamp.opengl.util.gl2.GLUT;

import weapons.Projectile;

public class Robot implements Creature, PlayerMotionWatcher, ProjectileWatcher{
	
	private static GLUT glut = new GLUT();

	private static List<Robot> robots = new LinkedList<Robot>();

	private static int detectionRadius = 40;
	private static double playerX = 0;
	private static double playerZ = 0;
	private double robotLocationX;
	private double robotLocationZ;
	private double eyeVectorX;
	private double eyeVectorZ;
	private double theta = 0;
	private boolean chasing = false,attacking=false;
	private static GLUquadric quadric;
	private static int displayListChasing=-1, displayListNotChasing=-1;
	private Location spawnLocation;
	
	public Robot(double startX,double startZ,GL2 gl, GLU glu){
		this.spawnLocation = new Location((float) startX,(float) 0,(float) startZ);
		this.robotLocationX = startX;
		this.robotLocationZ = startZ;
		eyeVectorX = 0.2;
		eyeVectorZ = 0.2;
		quadric = glu.gluNewQuadric();
        glu.gluQuadricDrawStyle(quadric,GLU.GLU_FILL);
        glu.gluQuadricNormals(quadric,GLU.GLU_NONE);
        glu.gluQuadricTexture(quadric,false);
		PlayerMotion.registerPlayerWatcher(this);
		Projectile.registerProjectileWatcher(this);
		robots.add(this);
	
		// create the two display lists
		if (displayListNotChasing == -1) {
            displayListNotChasing = gl.glGenLists(1);
            gl.glNewList(displayListNotChasing, GL2.GL_COMPILE);
            setupDraw(gl, glu);
            gl.glEndList();
		}
        
		if (displayListChasing == -1) {
            displayListChasing = gl.glGenLists(1);
            gl.glNewList(displayListChasing, GL2.GL_COMPILE);
                chasing = true;
                setupDraw(gl, glu);
                chasing = false;
            gl.glEndList();
		}
	}

	public void draw(GL2 gl, GLU glu) {
        gl.glPushMatrix();
            gl.glTranslated(robotLocationX,0,robotLocationZ);
            gl.glRotated(theta,0,1,0);
    		if(chasing){
    			move();
    			turn();
    			gl.glCallList(displayListChasing);
    		} else {
    		    gl.glCallList(displayListNotChasing);
    		}
        gl.glPopMatrix();
	}
	
	public void setupDraw(GL2 gl, GLU glu){
        drawHead(gl,glu);
		drawTorso(gl,glu);
		drawWheels(gl,glu);
		drawArms(gl,glu);
		drawEye(gl,glu);
		drawHat(gl,glu);
		drawHands(gl,glu);
		drawBrain(gl,glu);
	}
	
	private void drawHead(GL2 gl,GLU glu){
		gl.glColor3d(0.33,0.33,0.33);
		gl.glPushMatrix();
		gl.glTranslated(0,8,0);
		glu.gluSphere(quadric,1,20,20);
		gl.glPopMatrix();
	}
	
	private void drawTorso(GL2 gl,GLU glu){
		gl.glColor3d(0.33,0.33,0.33);
		gl.glPushMatrix();
		gl.glTranslated(0,4.3,0);
		gl.glScaled(0.7,2,0.7);
		glu.gluSphere(quadric,1.5,20,20);
		gl.glPopMatrix();
	}
	
	private void drawWheels(GL2 gl,GLU glu){
		gl.glColor3d(0.31,0.58,0.80);
		gl.glPushMatrix();
		gl.glTranslated(0.8,1,0);
		gl.glRotated(90,0,1,0);
		glut.glutSolidTorus(0.3,1,8,8);
		gl.glPopMatrix();
		gl.glPushMatrix();
		gl.glTranslated(-0.8,1,0);
		gl.glRotated(90,0,1,0);
		glut.glutSolidTorus(0.3,1,8,8);
		gl.glPopMatrix();
	}
	
	private void drawArms(GL2 gl,GLU glu){
		gl.glPushMatrix();
		gl.glTranslated(0.7,6,3.4);
		gl.glRotated(180,0,1,0);
		glut.glutSolidCone(0.3,4,8,8);
		gl.glPopMatrix();
		gl.glPushMatrix();
		gl.glTranslated(-0.7,6,3.4);
		gl.glRotated(180,0,1,0);
		glut.glutSolidCone(0.3,4,8,8);
		gl.glPopMatrix();
	}
	
	private void drawEye(GL2 gl,GLU glu){
		if(chasing){
			gl.glColor3d(0.30,0.93,0.58);
		}
		else{
			gl.glColor3d(0,0,5);
		}
		gl.glPushMatrix();
		gl.glTranslated(0,8.2,0.5);
		gl.glScaled(3.5,1,2);
		glu.gluSphere(quadric,0.3,20,20);
		gl.glPopMatrix();
	}
	
	private void drawHat(GL2 gl,GLU glu){
		gl.glColor3d(1,1,1);
		gl.glPushMatrix();
		gl.glTranslated(0,8.9,0);
		gl.glScaled(0.8,0.4,0.8);
		glu.gluSphere(quadric,1,20,20);
		gl.glPopMatrix();
	}
	
	private void drawHands(GL2 gl,GLU glu){
		if(chasing){
			gl.glColor3d(0.99,0.187,0.187);
		}
		else{
			gl.glColor3d(1,1,1);
		}
		gl.glPushMatrix();
		gl.glTranslated(0.7,6,3.4);
		gl.glRotated(180,0,1,0);
		glut.glutWireCube(0.5f);
		gl.glPopMatrix();
		gl.glPushMatrix();
		gl.glTranslated(-0.7,6,3.4);
		gl.glRotated(180,0,1,0);
		glut.glutWireCube(0.5f);
		gl.glPopMatrix();
	}
	
	private void drawBrain(GL2 gl,GLU glu){
		if(chasing){
			gl.glColor3d(0.99,0.187,0.187);
		}
		else{
			gl.glColor3d(1,1,1);
		}
		gl.glPushMatrix();
		gl.glTranslated(0,9.5,0);
		gl.glScaled(0.5,0.5,0.5);
		glut.glutWireDodecahedron();
		gl.glPopMatrix();
	}
	
	public void playerMoved(float x, float y, float z, float angle, float yAngle,PlayerStats s) {
		playerX = x;
		playerZ = z;
		double distance = Math.sqrt(Math.pow(robotLocationX-x,2) + Math.pow(robotLocationZ-z,2));
		if(distance <= detectionRadius){

			chasing = true;
			
			if(distance<=3&&!attacking){
				s.changeHealth(-2);
				attacking=true;
			}
		}
		else{
			chasing = false;
			attacking=false;
		}
	}
	
	private void turn(){
		double xV = robotLocationX-playerX;
		double zV = robotLocationZ-playerZ;
		double lengthV1 = Math.sqrt((xV*xV)+(zV*zV));
		double lengthV2 = Math.sqrt(eyeVectorX*eyeVectorX+eyeVectorZ*eyeVectorZ);
		double dotProduct = xV * eyeVectorX + zV * eyeVectorZ;
		theta+=Math.acos(dotProduct / (lengthV1*lengthV2));
	}
	
	public void move(){
		double xV = playerX-robotLocationX;
		double zV = playerZ-robotLocationZ;
		double dotProduct = xV * eyeVectorX + zV * eyeVectorZ;
		double lengthV1 = Math.sqrt((xV*xV)+(zV*zV));
		lengthV1 = lengthV1 * lengthV1;
		double constant = dotProduct / lengthV1;
		double dx = constant * xV;
		double dz = constant * zV;
		dx = Math.abs(dx);
		dz = Math.abs(dz);
		if(playerZ<robotLocationZ){
			robotLocationZ-=dz;
		}
		else{
			robotLocationZ+=dz;
		}
		if(playerX<robotLocationX){
			robotLocationX-=dx;
		}
		else{
			robotLocationX+=dx;
		}
	}

	public void projectileMoved(double x, double z) {

		if((Math.abs(robotLocationX-x) < 2) && (Math.abs(robotLocationZ-z) < 2)){
			robots.remove(this);
//			CreatureManager.addLocation(this.spawnLocation);
//			CreatureManager.addRobot();
		}
	}
	

	public static void addRobot(Robot robot){
		robots.add(robot);
	}
	
	public static void drawRobots(GL2 gl,GLU glu){
		for(Robot zombie:robots){
			zombie.draw(gl, glu);
		}
	}
}
