package buildings;
import game.Building;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;

import com.jogamp.opengl.util.gl2.GLUT;
import com.jogamp.opengl.util.texture.Texture;


public class DiegoMBuilding extends Building {
	
	private GLUT glut = new GLUT();
	private Texture grass;
	private Texture outsideWall;
	private Texture insideWall;
	private Texture concrete;
	private Texture checkeredFlag;
	private Texture lavaTexture;
	private Wall firstWallA;
	private Wall firstWallB;
	private Wall firstWallC;
	private Wall slantedWallA;
	private Wall slantedWallB;
	private Wall sideWallA;
	private Wall slantedWallC;
	private Wall slantedWallD;
	private Wall slantedWallE;
	private Wall slantedWallF;
	private Wall backWall;
	private Wall backWallB;
	private Wall backWallC;
	private Wall slantedWallG;
	private Wall slantedWallH;
	private Wall slantedWallI;
	private Wall sideWallB;
	private Wall frontWallA;
	
	private Wall towerWallA;
	private Wall towerWallB;
	private Wall towerWallC;
	private Wall towerWallD;
	private Wall towerWallE;
	private Wall towerWallF;
	private HorizontalWall finishLine;
	private HorizontalWall lava;
	
	private HorizontalWall roof;
	private HorizontalWall concreteFloor;
	
	private Car redCar = new Car(-6,1.5,5,.8,.3,.1,90);
	private Car blueCar = new Car(8,1.5,10,.4,.3,.8,90);
	private Car greenCar = new Car(-7,1.5,18,.35,.79,.46,90);
	
	public DiegoMBuilding(GL2 gl, GLU glu){
		grass = setupTexture(gl,"grassTexture.jpg");
		outsideWall = setupTexture(gl,"castleBricks.jpg");
		insideWall = setupTexture(gl,"insideCastleTexture.gif");
		concrete = setupTexture(gl,"concreteTexture.jpg");
		checkeredFlag = setupTexture(gl,"finishLineTexture.jpg");
		lavaTexture = setupTexture(gl,"lava.jpg");
		firstWallA = new Wall(-10,0,0,7,20,0,outsideWall,insideWall);
		firstWallB = new Wall(-3,10,0,6,10,0,outsideWall,insideWall);
		firstWallC = new Wall(3,0,0,7,20,0,outsideWall,insideWall);
		slantedWallA = new Wall(-10,0,0,-10,20,8,insideWall,outsideWall);
		slantedWallB = new Wall(10,0,0,10,20,8,outsideWall,insideWall);
		sideWallA = new Wall(20,0,-8,10,20,0,outsideWall,insideWall);
		sideWallB = new Wall(-40,0,-16,0,20,16,insideWall,outsideWall);
		slantedWallC = new Wall(30,0,-8,10,20,-8,outsideWall,insideWall);
		slantedWallD = new Wall(40,0,0,10,20,8,outsideWall,insideWall);		
		slantedWallE = new Wall(40,0,-16,0,20,16,outsideWall,insideWall);
		
		slantedWallG = new Wall(40,0,-32,10,20,8,outsideWall,insideWall);
		slantedWallH = new Wall(50,0,-40,-10,20,8,outsideWall,insideWall);
		slantedWallI = new Wall(40,0,-48,-10,20,-8,outsideWall,insideWall);
		
		slantedWallF = new Wall(50,0,-8,-10,20,8,outsideWall,insideWall);
		
		
		backWall = new Wall(-30,0,-40,20,20,0,insideWall,outsideWall);
		backWallB = new Wall(-10,15,-40,20,20,0,insideWall,outsideWall);
		backWallC = new Wall(10,0,-40,20,20,0,insideWall,outsideWall);
		
		finishLine = new HorizontalWall(-10,0.01,-40,20,0,5,checkeredFlag,checkeredFlag);
		
		frontWallA = new Wall(-30,0,-8,10,20,0,outsideWall,insideWall);
		
		towerWallA = new Wall(-30,0,-8,-10,20,-8,insideWall,outsideWall);
		towerWallB = new Wall(-40,0,0,-10,20,8,insideWall,outsideWall);
		towerWallC = new Wall(-50,0,-8,10,20,8,insideWall,outsideWall);
		
		towerWallD = new Wall(-40,0,-32,-10,20,8,insideWall,outsideWall);
		towerWallE = new Wall(-50,0,-40,10,20,8,insideWall,outsideWall);
		towerWallF = new Wall(-40,0,-48,10,20,-8,insideWall,outsideWall);
		
		lava = new HorizontalWall(-20,0.01,-10,5,0,10,lavaTexture,lavaTexture);
		roof = new HorizontalWall(-50,20,0,100,0,48,outsideWall,insideWall);
		concreteFloor = new HorizontalWall(-10,0.01,50,20,0,50,concrete,concrete);
	}
	
	@Override
	public void draw(GL2 gl, GLU glu) {
      gl.glPushMatrix();
      gl.glTranslatef(50,0,50);
		firstWallA.draw(gl, glu);
		firstWallB.draw(gl, glu);
		firstWallC.draw(gl, glu);
		slantedWallA.draw(gl, glu);
		slantedWallB.draw(gl, glu);
		sideWallA.draw(gl, glu);
		slantedWallC.draw(gl, glu);
		slantedWallD.draw(gl, glu);
		slantedWallE.draw(gl, glu);
		slantedWallF.draw(gl,glu);
		backWall.draw(gl, glu);
		backWallB.draw(gl, glu);
		backWallC.draw(gl, glu);
		slantedWallG.draw(gl,glu);
		slantedWallH.draw(gl, glu);
		slantedWallI.draw(gl, glu);
		sideWallB.draw(gl, glu);
		frontWallA.draw(gl,glu);
		
		towerWallA.draw(gl,glu);
		towerWallB.draw(gl,glu);
		towerWallC.draw(gl,glu);
		towerWallD.draw(gl,glu);
		towerWallE.draw(gl,glu);
		towerWallF.draw(gl,glu);
		lava.draw(gl, glu);
		
		roof.draw(gl, glu);
		concreteFloor.draw(gl, glu);
		finishLine.draw(gl, glu);
		
		redCar.draw(gl, glu);
		blueCar.draw(gl, glu);
		greenCar.draw(gl, glu);
        
		
	    gl.glPushMatrix();
	    gl.glTranslatef(0,0,-20);
	    gl.glRotatef(-90,1,0,0);
	    glut.glutSolidCone(3,20,16,8);
	    gl.glPopMatrix();
		
		gl.glEnable(GL2.GL_TEXTURE_2D);
		grass.bind(gl);
        gl.glBegin(GL2.GL_QUADS);
        gl.glTexCoord2d(0,2);gl.glVertex3f(-50,0,50);
        gl.glTexCoord2d(3,2);gl.glVertex3f(50,0,50);
        gl.glTexCoord2d(3,0);gl.glVertex3f(50,0,-50);
        gl.glTexCoord2d(0,0);gl.glVertex3f(-50,0,-50);
        gl.glEnd();
        gl.glDisable(GL2.GL_TEXTURE_2D);

        int error = gl.glGetError();
        if (error != GL2.GL_NO_ERROR) {
            System.out.println("OpenGL Error: " + glu.gluErrorString(error));
            System.exit(1);
        }
      gl.glPopMatrix();
	}
}
