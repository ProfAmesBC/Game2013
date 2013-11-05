package buildings;
// HW #5
// Matt D'Intino
// CS 333 Prof. Ames
// Creates vertices for cube

import game.Building;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;

import com.jogamp.opengl.util.texture.Texture;


public class DintinoHouse extends Building {
	private GLUquadric quadric; // to control properties of quadric-based objects here
	private GLUquadric sphereQuadric; // for the ball
	private Texture brickTexture;     // bricks
	private Texture woodTexture;	// outside wood
	private Texture floorTexture;	
	private Texture soccerTexture;
	private Texture starTexture;

	//floor of house
	Point3d pointA = new Point3d(25, 0, 25);
	Point3d pointB = new Point3d(75, 0, 25);
	Point3d pointC = new Point3d(75, 0, 75);
	Point3d pointD = new Point3d(25, 0, 75);

	//left wall
	Point3d pointF = new Point3d(75, 30, 25);
	Point3d pointH = new Point3d(75, 30, 75);

	//right wall
	Point3d pointI = new Point3d(25, 30, 25);
	Point3d pointJ = new Point3d(25, 30, 75);

	//front wall right
	Point3d pointK = new Point3d(40, 0, 25);
	Point3d pointL = new Point3d(40, 10, 25);
	Point3d pointM = new Point3d(25, 10, 25);

	//front wall left
	Point3d pointN = new Point3d(45, 10, 25);
	Point3d pointO = new Point3d(75, 10, 25);
	Point3d pointP = new Point3d(45, 0, 25);

	//roof 
	Point3d pointQ = new Point3d(50, 45, 25);
	Point3d pointR = new Point3d(50, 45, 75);

	//grass
	Point3d pointS = new Point3d(0,0,0);
	Point3d pointT = new Point3d(0,0,100);
	Point3d pointU = new Point3d(100,0,100);
	Point3d pointV = new Point3d(100,0,0);

	//back wall right
	Point3d pointAA = new Point3d(40, 0, 75);
	Point3d pointAB = new Point3d(40, 10, 75);
	Point3d pointAC = new Point3d(45, 10, 75);

	//back wall left
	Point3d pointAD = new Point3d(45, 0, 75);
	Point3d pointAE = new Point3d(75, 10, 75);
	Point3d pointAF = new Point3d(25, 10, 75);	

	//tv1 front
	Point3d pointAG = new Point3d(60,0,73);
	Point3d pointAH = new Point3d(65,0,73);
	Point3d pointAI = new Point3d(65,4,73);
	Point3d pointAJ = new Point3d(60,4,73);

	//tv1 right
	Point3d pointAK = new Point3d(60,0,75);
	Point3d pointAL = new Point3d(60,4,75);

	//tv1 left
	Point3d pointAM = new Point3d(65,0,75);
	Point3d pointAN = new Point3d(65,4,75);

	//tv2 front
	Point3d pointAO = new Point3d(50, 0, 73);
	Point3d pointAP = new Point3d(55, 0, 73);
	Point3d pointAQ = new Point3d(55, 4, 73);
	Point3d pointAR = new Point3d(50, 4, 73);

	//tv2 right
	Point3d pointAS = new Point3d(50,0,75);
	Point3d pointAT = new Point3d(50,4,75);

	//tv2 left
	Point3d pointAU = new Point3d(55,0,75);
	Point3d pointAV = new Point3d(55,4,75);



	public DintinoHouse(GL2 gl, GLU glu) {
		brickTexture = setupTexture(gl, "DintinoBricks.gif"); // png's don't seem to work any more
		woodTexture = setupTexture(gl, "DintinoWood.jpg");
		floorTexture = setupTexture(gl, "DintinoCloth.jpg");
		soccerTexture = setupTexture(gl, "DintinoSoccer.jpg");
		starTexture = setupTexture(gl, "DintinoStar.gif");
		quadric = glu.gluNewQuadric();
		glu.gluQuadricDrawStyle(quadric, GLU.GLU_FILL); // GLU_POINT, GLU_LINE, GLU_FILL, GLU_SILHOUETTE
		glu.gluQuadricNormals  (quadric, GLU.GLU_NONE); // GLU_NONE, GLU_FLAT, or GLU_SMOOTH
		glu.gluQuadricTexture  (quadric, false);        // use true to generate texture coordinates

		sphereQuadric = glu.gluNewQuadric();
		glu.gluQuadricDrawStyle(sphereQuadric, GLU.GLU_FILL);
		glu.gluQuadricNormals  (sphereQuadric, GLU.GLU_NONE);
		glu.gluQuadricTexture  (sphereQuadric, true); // for Signorile's head
	}

	public void draw(GL2 gl, GLU glu) {

		// back wall, using automatic texture generation
		gl.glEnable(GL2.GL_TEXTURE_2D);
		gl.glEnable(GL2.GL_TEXTURE_GEN_S);
		gl.glEnable(GL2.GL_TEXTURE_GEN_T);
		gl.glTexGeni(GL2.GL_S, GL2.GL_TEXTURE_GEN_MODE, GL2.GL_OBJECT_LINEAR);
		gl.glTexGeni(GL2.GL_T, GL2.GL_TEXTURE_GEN_MODE, GL2.GL_OBJECT_LINEAR);
		float[] coef_s = {.5f,0,0,0};
		gl.glTexGenfv(GL2.GL_S, GL2.GL_OBJECT_PLANE, coef_s, 0);
		float[] coef_t = {0,.25f,0,0};
		gl.glTexGenfv(GL2.GL_T, GL2.GL_OBJECT_PLANE, coef_t, 0);
		gl.glEnable(GL2.GL_CULL_FACE);
		woodTexture.bind(gl);
		gl.glBegin(GL2.GL_QUADS);
		//back wall right
		gl.glVertex3d(pointD.getX(), pointD.getY(), pointD.getZ());
		gl.glVertex3d(pointAA.getX(), pointAA.getY(), pointAA.getZ());
		gl.glVertex3d(pointAB.getX(), pointAB.getY(), pointAB.getZ());
		gl.glVertex3d(pointAF.getX(), pointAF.getY(), pointAF.getZ());

		//back wall left		
		gl.glVertex3d(pointC.getX(), pointC.getY(), pointC.getZ());
		gl.glVertex3d(pointAE.getX(), pointAE.getY(), pointAE.getZ());
		gl.glVertex3d(pointAC.getX(), pointAC.getY(), pointAC.getZ());
		gl.glVertex3d(pointAD.getX(), pointAD.getY(), pointAD.getZ());

		//back wall top		
		gl.glVertex3d(pointAE.getX(), pointAE.getY(), pointAE.getZ());
		gl.glVertex3d(pointH.getX(), pointH.getY(), pointH.getZ()); //H
		gl.glVertex3d(pointJ.getX(), pointJ.getY(), pointJ.getZ());
		gl.glVertex3d(pointAF.getX(), pointAF.getY(), pointAF.getZ()); //AF
		gl.glEnd();

		brickTexture.bind(gl);
		gl.glBegin(GL2.GL_QUADS);

		//back wall top		
		gl.glVertex3d(pointAE.getX(), pointAE.getY(), pointAE.getZ());
		gl.glVertex3d(pointAF.getX(), pointAF.getY(), pointAF.getZ());
		gl.glVertex3d(pointJ.getX(), pointJ.getY(), pointJ.getZ());
		gl.glVertex3d(pointH.getX(), pointH.getY(), pointH.getZ());

		//back wall right
		gl.glVertex3d(pointD.getX(), pointD.getY(), pointD.getZ());
		gl.glVertex3d(pointAF.getX(), pointAF.getY(), pointAF.getZ()); //AF
		gl.glVertex3d(pointAB.getX(), pointAB.getY(), pointAB.getZ());
		gl.glVertex3d(pointAA.getX(), pointAA.getY(), pointAA.getZ()); //AA

		//back wall left		
		gl.glVertex3d(pointC.getX(), pointC.getY(), pointC.getZ());
		gl.glVertex3d(pointAD.getX(), pointAD.getY(), pointAD.getZ()); //AD
		gl.glVertex3d(pointAC.getX(), pointAC.getY(), pointAC.getZ());
		gl.glVertex3d(pointAE.getX(), pointAE.getY(), pointAE.getZ()); //AE

		gl.glEnd();
		gl.glDisable(GL2.GL_TEXTURE_2D);
		gl.glDisable(GL2.GL_CULL_FACE);
		gl.glDisable(GL2.GL_TEXTURE_GEN_S);
		gl.glDisable(GL2.GL_TEXTURE_GEN_T);

		//draw floor
		gl.glEnable(GL2.GL_TEXTURE_2D);
		floorTexture.bind(gl);
		gl.glBegin(GL2.GL_QUADS);
		gl.glTexCoord2f(0f, 2f); gl.glVertex3d(pointA.getX(), pointA.getY(), pointA.getZ());
		gl.glTexCoord2f(3f, 2f); gl.glVertex3d(pointB.getX(), pointB.getY(), pointB.getZ());
		gl.glTexCoord2f(3f, 0f); gl.glVertex3d(pointC.getX(), pointC.getY(), pointC.getZ());
		gl.glTexCoord2f(0f, 0f); gl.glVertex3d(pointD.getX(), pointD.getY(), pointD.getZ());
		gl.glEnd();
		gl.glDisable(GL2.GL_TEXTURE_2D);

		//draw left wall
		gl.glEnable(GL2.GL_CULL_FACE);
		gl.glEnable(GL2.GL_TEXTURE_2D);
		woodTexture.bind(gl);
		gl.glBegin(GL2.GL_QUADS);
		gl.glTexCoord2f(0f,2f); gl.glVertex3d(pointB.getX(), pointB.getY(), pointB.getZ());
		gl.glTexCoord2f(3f,2f); gl.glVertex3d(pointF.getX(), pointF.getY(), pointF.getZ());
		gl.glTexCoord2f(3f,0f); gl.glVertex3d(pointH.getX(), pointH.getY(), pointH.getZ());
		gl.glTexCoord2f(0f,0f); gl.glVertex3d(pointC.getX(), pointC.getY(), pointC.getZ());
		gl.glEnd();

		brickTexture.bind(gl);
		gl.glBegin(GL2.GL_QUADS);
		gl.glTexCoord2f(0f,2f); gl.glVertex3d(pointB.getX(), pointB.getY(), pointB.getZ());
		gl.glTexCoord2f(0f,0f); gl.glVertex3d(pointC.getX(), pointC.getY(), pointC.getZ());
		gl.glTexCoord2f(3f,0f); gl.glVertex3d(pointH.getX(), pointH.getY(), pointH.getZ());
		gl.glTexCoord2f(3f,2f); gl.glVertex3d(pointF.getX(), pointF.getY(), pointF.getZ());
		gl.glEnd();
		gl.glDisable(GL2.GL_TEXTURE_2D);
		gl.glDisable(GL2.GL_CULL_FACE);

		//draw right wall
		gl.glEnable(GL2.GL_CULL_FACE);
		gl.glEnable(GL2.GL_TEXTURE_2D);
		brickTexture.bind(gl);
		gl.glBegin(GL2.GL_QUADS);
		gl.glTexCoord2f(0f,2f); gl.glVertex3d(pointA.getX(), pointA.getY(), pointA.getZ());
		gl.glTexCoord2f(3f,2f); gl.glVertex3d(pointI.getX(), pointI.getY(), pointI.getZ());
		gl.glTexCoord2f(3f,0f); gl.glVertex3d(pointJ.getX(), pointJ.getY(), pointJ.getZ());
		gl.glTexCoord2f(0f,0f); gl.glVertex3d(pointD.getX(), pointD.getY(), pointD.getZ());
		gl.glEnd();

		woodTexture.bind(gl);
		gl.glBegin(GL2.GL_QUADS);
		gl.glTexCoord2f(0f,2f); gl.glVertex3d(pointA.getX(), pointA.getY(), pointA.getZ());
		gl.glTexCoord2f(0f,0f); gl.glVertex3d(pointD.getX(), pointD.getY(), pointD.getZ());
		gl.glTexCoord2f(3f,0f); gl.glVertex3d(pointJ.getX(), pointJ.getY(), pointJ.getZ());
		gl.glTexCoord2f(3f,2f); gl.glVertex3d(pointI.getX(), pointI.getY(), pointI.getZ());
		gl.glEnd();
		gl.glDisable(GL2.GL_TEXTURE_2D);
		gl.glDisable(GL2.GL_CULL_FACE);

		//front wall 
		gl.glEnable(GL2.GL_TEXTURE_2D);
		brickTexture.bind(gl);
		gl.glEnable(GL2.GL_TEXTURE_GEN_S);
		gl.glEnable(GL2.GL_TEXTURE_GEN_T);
		gl.glTexGeni(GL2.GL_S, GL2.GL_TEXTURE_GEN_MODE, GL2.GL_OBJECT_LINEAR);
		gl.glTexGeni(GL2.GL_T, GL2.GL_TEXTURE_GEN_MODE, GL2.GL_OBJECT_LINEAR);
		float[] coef_ss = {.5f,0,0,0};
		gl.glTexGenfv(GL2.GL_S, GL2.GL_OBJECT_PLANE, coef_ss, 0);
		float[] coef_tt = {0,.25f,0,0};
		gl.glTexGenfv(GL2.GL_T, GL2.GL_OBJECT_PLANE, coef_tt, 0);
		gl.glEnable(GL2.GL_CULL_FACE);
		gl.glBegin(GL2.GL_QUADS);

		//front wall right
		gl.glVertex3d(pointA.getX(), pointA.getY(), pointA.getZ());
		gl.glVertex3d(pointK.getX(), pointK.getY(), pointK.getZ());
		gl.glVertex3d(pointL.getX(), pointL.getY(), pointL.getZ());
		gl.glVertex3d(pointM.getX(), pointM.getY(), pointM.getZ());

		//front wall left
		gl.glVertex3d(pointP.getX(), pointP.getY(), pointP.getZ());
		gl.glVertex3d(pointB.getX(), pointB.getY(), pointB.getZ());
		gl.glVertex3d(pointO.getX(), pointO.getY(), pointO.getZ());
		gl.glVertex3d(pointN.getX(), pointN.getY(), pointN.getZ());

		//front wall top
		gl.glVertex3d(pointM.getX(), pointM.getY(), pointM.getZ());
		gl.glVertex3d(pointO.getX(), pointO.getY(), pointO.getZ());
		gl.glVertex3d(pointF.getX(), pointF.getY(), pointF.getZ());
		gl.glVertex3d(pointI.getX(), pointI.getY(), pointI.getZ());
		gl.glEnd();

		woodTexture.bind(gl);
		gl.glBegin(GL2.GL_QUADS);
		//front wall right
		gl.glVertex3d(pointA.getX(), pointA.getY(), pointA.getZ());
		gl.glVertex3d(pointM.getX(), pointM.getY(), pointM.getZ()); //m
		gl.glVertex3d(pointL.getX(), pointL.getY(), pointL.getZ());
		gl.glVertex3d(pointK.getX(), pointK.getY(), pointK.getZ()); //k

		//front wall left
		gl.glVertex3d(pointP.getX(), pointP.getY(), pointP.getZ());
		gl.glVertex3d(pointN.getX(), pointN.getY(), pointN.getZ()); //n
		gl.glVertex3d(pointO.getX(), pointO.getY(), pointO.getZ());
		gl.glVertex3d(pointB.getX(), pointB.getY(), pointB.getZ()); //b

		//front wall top
		gl.glVertex3d(pointM.getX(), pointM.getY(), pointM.getZ());
		gl.glVertex3d(pointI.getX(), pointI.getY(), pointI.getZ()); //i
		gl.glVertex3d(pointF.getX(), pointF.getY(), pointF.getZ());
		gl.glVertex3d(pointO.getX(), pointO.getY(), pointO.getZ()); //o

		gl.glEnd();
		gl.glDisable(GL2.GL_CULL_FACE);
		gl.glDisable(GL2.GL_TEXTURE_2D);
		gl.glDisable(GL2.GL_TEXTURE_GEN_S);
		gl.glDisable(GL2.GL_TEXTURE_GEN_T);

		//roof right
		gl.glBegin(GL2.GL_QUADS);
		gl.glColor3d(0.8f, 0.4f, 0.84f);
		gl.glVertex3d(pointJ.getX(), pointJ.getY(), pointJ.getZ());
		gl.glVertex3d(pointR.getX(), pointR.getY(), pointR.getZ());
		gl.glVertex3d(pointQ.getX(), pointQ.getY(), pointQ.getZ());
		gl.glVertex3d(pointI.getX(), pointI.getY(), pointI.getZ());

		//roof left
		gl.glColor3d(0.8f, 0.4f, 0.8f);
		gl.glVertex3d(pointH.getX(), pointH.getY(), pointH.getZ());
		gl.glVertex3d(pointR.getX(), pointR.getY(), pointR.getZ());
		gl.glVertex3d(pointQ.getX(), pointQ.getY(), pointQ.getZ());
		gl.glVertex3d(pointF.getX(), pointF.getY(), pointF.getZ());

		//grass
		gl.glColor3d(0.3f, 0.4f, 0.5f);
		gl.glVertex3d(pointS.getX(), pointS.getY(), pointS.getZ());
		gl.glVertex3d(pointT.getX(), pointT.getY(), pointT.getZ());
		gl.glVertex3d(pointU.getX(), pointU.getY(), pointU.getZ());
		gl.glVertex3d(pointV.getX(), pointV.getY(), pointV.getZ());
		gl.glEnd();	

		gl.glBegin(GL2.GL_TRIANGLES);
		//roof back
		gl.glColor3d(0.4f, 0.4f, 0.4f);
		gl.glVertex3d(pointJ.getX(), pointJ.getY(), pointJ.getZ());
		gl.glVertex3d(pointR.getX(), pointR.getY(), pointR.getZ());
		gl.glVertex3d(pointH.getX(), pointH.getY(), pointH.getZ());

		//roof front
		gl.glColor3d(.3f, 0.2f, 0.5f);
		gl.glVertex3d(pointF.getX(), pointF.getY(), pointF.getZ());
		gl.glVertex3d(pointQ.getX(), pointQ.getY(), pointQ.getZ());
		gl.glVertex3d(pointI.getX(), pointI.getY(), pointI.getZ());

		gl.glEnd();
		gl.glDisable(GL2.GL_TEXTURE_2D);

		//draw TV1

		//tv front
		gl.glEnable(GL2.GL_TEXTURE_2D);
		soccerTexture.bind(gl);
		gl.glBegin(GL2.GL_QUADS);
		gl.glTexCoord2f(0f,1f);gl.glVertex3d(pointAG.getX(), pointAG.getY(), pointAG.getZ());
		gl.glTexCoord2f(1f,1f);gl.glVertex3d(pointAH.getX(), pointAH.getY(), pointAH.getZ());
		gl.glTexCoord2f(1f,0f);gl.glVertex3d(pointAI.getX(), pointAI.getY(), pointAI.getZ());
		gl.glTexCoord2f(0f,0f);gl.glVertex3d(pointAJ.getX(), pointAJ.getY(), pointAJ.getZ());
		gl.glEnd();
		gl.glDisable(GL2.GL_TEXTURE_2D);


		gl.glColor3d(0f, 0f, 0f);
		gl.glBegin(GL2.GL_QUADS);
		//tv right side
		gl.glVertex3d(pointAG.getX(), pointAG.getY(), pointAG.getZ());
		gl.glVertex3d(pointAK.getX(), pointAK.getY(), pointAK.getZ());
		gl.glVertex3d(pointAL.getX(), pointAL.getY(), pointAL.getZ());
		gl.glVertex3d(pointAJ.getX(), pointAJ.getY(), pointAJ.getZ());

		//tv back
		gl.glVertex3d(pointAK.getX(), pointAK.getY(), pointAK.getZ());
		gl.glVertex3d(pointAL.getX(), pointAL.getY(), pointAL.getZ());
		gl.glVertex3d(pointAN.getX(), pointAN.getY(), pointAN.getZ());
		gl.glVertex3d(pointAM.getX(), pointAM.getY(), pointAM.getZ());

		// tv left side
		gl.glVertex3d(pointAM.getX(), pointAM.getY(), pointAM.getZ());
		gl.glVertex3d(pointAN.getX(), pointAN.getY(), pointAN.getZ());
		gl.glVertex3d(pointAI.getX(), pointAI.getY(), pointAI.getZ());
		gl.glVertex3d(pointAH.getX(), pointAH.getY(), pointAH.getZ());

		// tv top
		gl.glVertex3d(pointAI.getX(), pointAI.getY(), pointAI.getZ());
		gl.glVertex3d(pointAJ.getX(), pointAJ.getY(), pointAJ.getZ());
		gl.glVertex3d(pointAL.getX(), pointAL.getY(), pointAL.getZ());
		gl.glVertex3d(pointAN.getX(), pointAN.getY(), pointAN.getZ());

		gl.glEnd();	

		//draw TV2

		//tv2 front
		gl.glEnable(GL2.GL_TEXTURE_2D);
		starTexture.bind(gl);
		gl.glBegin(GL2.GL_QUADS);
		gl.glTexCoord2f(0f,1f);gl.glVertex3d(pointAO.getX(), pointAO.getY(), pointAO.getZ());
		gl.glTexCoord2f(1f,1f);gl.glVertex3d(pointAP.getX(), pointAP.getY(), pointAP.getZ());
		gl.glTexCoord2f(1f,0f);gl.glVertex3d(pointAQ.getX(), pointAQ.getY(), pointAQ.getZ());
		gl.glTexCoord2f(0f,0f);gl.glVertex3d(pointAR.getX(), pointAR.getY(), pointAR.getZ());
		gl.glEnd();
		gl.glDisable(GL2.GL_TEXTURE_2D);


		gl.glColor3d(0f, 0f, 0f);
		gl.glBegin(GL2.GL_QUADS);
		//tv2 right side
		gl.glVertex3d(pointAO.getX(), pointAO.getY(), pointAO.getZ());
		gl.glVertex3d(pointAS.getX(), pointAS.getY(), pointAS.getZ());
		gl.glVertex3d(pointAT.getX(), pointAT.getY(), pointAT.getZ());
		gl.glVertex3d(pointAR.getX(), pointAR.getY(), pointAR.getZ());

		//tv2 back
		gl.glVertex3d(pointAS.getX(), pointAS.getY(), pointAS.getZ());
		gl.glVertex3d(pointAT.getX(), pointAT.getY(), pointAT.getZ());
		gl.glVertex3d(pointAU.getX(), pointAU.getY(), pointAU.getZ());
		gl.glVertex3d(pointAV.getX(), pointAV.getY(), pointAV.getZ());

		// tv2 left side
		gl.glVertex3d(pointAU.getX(), pointAU.getY(), pointAU.getZ());
		gl.glVertex3d(pointAV.getX(), pointAV.getY(), pointAV.getZ());
		gl.glVertex3d(pointAQ.getX(), pointAQ.getY(), pointAQ.getZ());
		gl.glVertex3d(pointAP.getX(), pointAP.getY(), pointAP.getZ());

		// tv2 top
		gl.glVertex3d(pointAQ.getX(), pointAQ.getY(), pointAQ.getZ());
		gl.glVertex3d(pointAR.getX(), pointAR.getY(), pointAR.getZ());
		gl.glVertex3d(pointAT.getX(), pointAT.getY(), pointAT.getZ());
		gl.glVertex3d(pointAV.getX(), pointAV.getY(), pointAV.getZ());

		gl.glEnd();


		//Quadrics in house

		// Snowman
		//bottom ball
		gl.glColor3f(1,1,1); // white
		gl.glPushMatrix();
		gl.glTranslatef(60, 3, 10);
		glu.gluSphere(sphereQuadric, 3., 10, 10); // ball
		gl.glPopMatrix();

		//middle
		gl.glPushMatrix();
		gl.glTranslatef(60, 7, 10); // 5 feet off of ground
		glu.gluSphere(sphereQuadric, 2., 10, 10); // ball
		gl.glPopMatrix();

		//top
		gl.glPushMatrix();
		gl.glTranslated(60, 9.5, 10); // 5 feet off of ground
		glu.gluSphere(sphereQuadric, 1., 10, 10); // ball
		gl.glPopMatrix();




	}

}
