package buildings;
import game.Building;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;

import com.jogamp.opengl.util.texture.Texture;

public class CheungBuilding extends Building{
	private static final float MAX_X=100,MAX_Z=100,BUILDING_RIGHT=26,BUILDING_LEFT=74,BUILDING_FRONT=31,BUILDING_BACK=86,
			FLOOR_HEIGHT=10,BUILDING_HEIGHT=2*FLOOR_HEIGHT,BACK_RIGHT_HEIGHT=BUILDING_HEIGHT+14,
			// important for doors
			DOOR_HEIGHT=7,DOOR_WIDTH=4,
			toLeftDoor=(BUILDING_BACK+BUILDING_FRONT)*.42f,fromLeftDoor=toLeftDoor+DOOR_WIDTH,
			toBackDoor=(BUILDING_LEFT+BUILDING_RIGHT)*.33f,fromBackDoor=toBackDoor-DOOR_WIDTH,
			// important for windows
			WINDOW_HEIGHT=3,WINDOW_WIDTH=4,FLOOR_WINDOW_HEIGHT=(FLOOR_HEIGHT-WINDOW_HEIGHT)/2,
			WINDOW_BOTTOM_HEIGHT=FLOOR_HEIGHT+FLOOR_WINDOW_HEIGHT,WINDOW_TOP_HEIGHT=BUILDING_HEIGHT-FLOOR_WINDOW_HEIGHT,
			EDGE_WINDOW_DIST=(BUILDING_BACK-BUILDING_FRONT-2*WINDOW_WIDTH)/4,
			toWindow1=BUILDING_FRONT+EDGE_WINDOW_DIST,fromWindow1=toWindow1+WINDOW_WIDTH,
			fromWindow2=BUILDING_BACK-EDGE_WINDOW_DIST,toWindow2=fromWindow2-WINDOW_WIDTH,
			
			HOURGLASS_BASE_HEIGHT=.25f,HOURGLASS_DIAMETER=7,HOURGLASS_RADIUS=HOURGLASS_DIAMETER/2,
			HOURGLASS_HEIGHT=19.5f,CONE_HEIGHT=HOURGLASS_HEIGHT/2,
			hgFrameRate=.001f,minhgFRBoundaryFactor=3f,maxHgBoundary=.8f,
			RAINBOW_BALL_BASE=6,RAINBOW_BALL_RADIUS=3,rainbowFrameRate=.01f;
	private static final int SLICES=10,STACKS=10,rToY=0,yToG=1,gToA=2,aToB=3,bToM=4,mToR=5;
	
	// solving for max sand height and diameter in upper half of hourglass
	private static final double coneVol=Math.PI/3.*Math.pow(HOURGLASS_RADIUS, 2)*CONE_HEIGHT,
			minEmptyVol=coneVol*Math.pow(1-maxHgBoundary,3),
			sandVol=coneVol-minEmptyVol;
	private static final float maxSandHeight2=(float)Math.cbrt(sandVol*3/Math.PI*Math.pow(CONE_HEIGHT/HOURGLASS_RADIUS, 2)),
			maxSandDiameter2=(float)maxSandHeight2*HOURGLASS_DIAMETER/CONE_HEIGHT;
	
	private GLUquadric quadric,textureQuadric;
	private Texture outerTexture,innerTexture,ceilingTexture,waterTexture,sandTexture,ballBaseTexture;
	private boolean fillingHourglass=true;
	private float hourglassFrame=hgFrameRate*minhgFRBoundaryFactor,
			ballColorFrame=0;
	private int colorState=rToY;
	
	public CheungBuilding(GL2 gl, GLU glu){
		quadric = glu.gluNewQuadric();
        glu.gluQuadricDrawStyle(quadric, GLU.GLU_FILL); // GLU_POINT, GLU_LINE, GLU_FILL, GLU_SILHOUETTE
        glu.gluQuadricNormals  (quadric, GLU.GLU_NONE); // GLU_NONE, GLU_FLAT, or GLU_SMOOTH
        glu.gluQuadricTexture  (quadric, false);        // use true to generate texture coordinates
        
        textureQuadric = glu.gluNewQuadric();
        glu.gluQuadricDrawStyle(textureQuadric, GLU.GLU_FILL); // GLU_POINT, GLU_LINE, GLU_FILL, GLU_SILHOUETTE
        glu.gluQuadricNormals  (textureQuadric, GLU.GLU_NONE); // GLU_NONE, GLU_FLAT, or GLU_SMOOTH
        glu.gluQuadricTexture  (textureQuadric, true);        // use true to generate texture coordinates
        
        innerTexture = setupTexture(gl, "cheungrings.jpg");
        outerTexture = setupTexture(gl, "cheungbricks.jpg"); // png's don't seem to work any more
        ceilingTexture=setupTexture(gl, "cheungceiling.gif");
        waterTexture=setupTexture(gl, "cheungwater.gif");
        sandTexture=setupTexture(gl, "cheungsand.jpg");
        ballBaseTexture=setupTexture(gl,"cheungballbase.jpg");
	}
	
	public void draw(GL2 gl, GLU glu) {
		// Floor - no, water!
		gl.glEnable(GL2.GL_TEXTURE_2D);
			waterTexture.bind(gl);
			gl.glBegin(GL2.GL_QUADS);
				gl.glTexCoord2f(0f,0f); gl.glVertex3f(0,0,0);
				gl.glTexCoord2f(4f,0f); gl.glVertex3f(MAX_X,0,0);
				gl.glTexCoord2f(4f,4f); gl.glVertex3f(MAX_X,0,MAX_Z);
				gl.glTexCoord2f(0f,4f); gl.glVertex3f(0,0,MAX_Z);
			gl.glEnd();
		// Ceiling
			ceilingTexture.bind(gl);
			gl.glBegin(GL2.GL_QUADS);
				gl.glTexCoord2f(0f,0f); gl.glVertex3f(BUILDING_RIGHT,BUILDING_HEIGHT,BUILDING_FRONT);
				gl.glTexCoord2f(4f,0f); gl.glVertex3f(BUILDING_LEFT,BUILDING_HEIGHT,BUILDING_FRONT);
				gl.glTexCoord2f(4f,4f); gl.glVertex3f(BUILDING_LEFT,BUILDING_HEIGHT,BUILDING_BACK);
				gl.glTexCoord2f(0f,4f); gl.glVertex3f(BUILDING_RIGHT,BACK_RIGHT_HEIGHT,BUILDING_BACK);
			gl.glEnd();
		// now, a textured brick wall !! - FRONT - no door or windows
		gl.glEnable(GL2.GL_CULL_FACE);
			outerTexture.bind(gl);
			gl.glBegin(GL2.GL_QUADS);
				gl.glTexCoord2f(0f,2f); gl.glVertex3f(BUILDING_RIGHT,BUILDING_HEIGHT,BUILDING_FRONT);
				gl.glTexCoord2f(3f,2f); gl.glVertex3f(BUILDING_LEFT,BUILDING_HEIGHT,BUILDING_FRONT);
				gl.glTexCoord2f(3f,0f); gl.glVertex3f(BUILDING_LEFT,0,BUILDING_FRONT);
				gl.glTexCoord2f(0f,0f); gl.glVertex3f(BUILDING_RIGHT,0,BUILDING_FRONT);
			gl.glEnd();
			innerTexture.bind(gl);
			gl.glBegin(GL2.GL_QUADS);
				gl.glTexCoord2f(0f,2f); gl.glVertex3f(BUILDING_RIGHT,BUILDING_HEIGHT,BUILDING_FRONT);
				gl.glTexCoord2f(0f,0f); gl.glVertex3f(BUILDING_RIGHT,0,BUILDING_FRONT);
				gl.glTexCoord2f(3f,0f); gl.glVertex3f(BUILDING_LEFT,0,BUILDING_FRONT);
				gl.glTexCoord2f(3f,2f); gl.glVertex3f(BUILDING_LEFT,BUILDING_HEIGHT,BUILDING_FRONT);
			gl.glEnd();
		//then a wall in the left, with a door and windows
			outerTexture.bind(gl);
			gl.glBegin(GL2.GL_QUADS);
				// first section
				gl.glTexCoord2f(0f,2f); gl.glVertex3f(BUILDING_LEFT,DOOR_HEIGHT,BUILDING_FRONT);
				gl.glTexCoord2f(3f,2f); gl.glVertex3f(BUILDING_LEFT,DOOR_HEIGHT,toLeftDoor);
				gl.glTexCoord2f(3f,0f); gl.glVertex3f(BUILDING_LEFT,0,toLeftDoor);
				gl.glTexCoord2f(0f,0f); gl.glVertex3f(BUILDING_LEFT,0,BUILDING_FRONT);
				// second section
				gl.glTexCoord2f(0f,2f); gl.glVertex3f(BUILDING_LEFT,DOOR_HEIGHT,fromLeftDoor);
				gl.glTexCoord2f(3f,2f); gl.glVertex3f(BUILDING_LEFT,DOOR_HEIGHT,BUILDING_BACK);
				gl.glTexCoord2f(3f,0f); gl.glVertex3f(BUILDING_LEFT,0,BUILDING_BACK);
				gl.glTexCoord2f(0f,0f); gl.glVertex3f(BUILDING_LEFT,0,fromLeftDoor);
				//mid portion
				gl.glTexCoord2f(0f,2f); gl.glVertex3f(BUILDING_LEFT,WINDOW_BOTTOM_HEIGHT,BUILDING_FRONT);
				gl.glTexCoord2f(3f,2f); gl.glVertex3f(BUILDING_LEFT,WINDOW_BOTTOM_HEIGHT,BUILDING_BACK);
				gl.glTexCoord2f(3f,0f); gl.glVertex3f(BUILDING_LEFT,DOOR_HEIGHT,BUILDING_BACK);
				gl.glTexCoord2f(0f,0f); gl.glVertex3f(BUILDING_LEFT,DOOR_HEIGHT,BUILDING_FRONT);
				// add windows
				// front section
				gl.glTexCoord2f(0f,2f); gl.glVertex3f(BUILDING_LEFT,WINDOW_BOTTOM_HEIGHT,BUILDING_FRONT);
				gl.glTexCoord2f(0f,0f); gl.glVertex3f(BUILDING_LEFT,WINDOW_TOP_HEIGHT,BUILDING_FRONT);
				gl.glTexCoord2f(3f,0f); gl.glVertex3f(BUILDING_LEFT,WINDOW_TOP_HEIGHT,toWindow1);
				gl.glTexCoord2f(3f,2f); gl.glVertex3f(BUILDING_LEFT,WINDOW_BOTTOM_HEIGHT,toWindow1);
				// mid section
				gl.glTexCoord2f(0f,2f); gl.glVertex3f(BUILDING_LEFT,WINDOW_BOTTOM_HEIGHT,fromWindow1);
				gl.glTexCoord2f(0f,0f); gl.glVertex3f(BUILDING_LEFT,WINDOW_TOP_HEIGHT,fromWindow1);
				gl.glTexCoord2f(3f,0f); gl.glVertex3f(BUILDING_LEFT,WINDOW_TOP_HEIGHT,toWindow2);
				gl.glTexCoord2f(3f,2f); gl.glVertex3f(BUILDING_LEFT,WINDOW_BOTTOM_HEIGHT,toWindow2);
				// back section
				gl.glTexCoord2f(0f,2f); gl.glVertex3f(BUILDING_LEFT,WINDOW_BOTTOM_HEIGHT,fromWindow2);
				gl.glTexCoord2f(0f,0f); gl.glVertex3f(BUILDING_LEFT,WINDOW_TOP_HEIGHT,fromWindow2);
				gl.glTexCoord2f(3f,0f); gl.glVertex3f(BUILDING_LEFT,WINDOW_TOP_HEIGHT,BUILDING_BACK);
				gl.glTexCoord2f(3f,2f); gl.glVertex3f(BUILDING_LEFT,WINDOW_BOTTOM_HEIGHT,BUILDING_BACK);
				// top section
				gl.glTexCoord2f(0f,2f); gl.glVertex3f(BUILDING_LEFT,BUILDING_HEIGHT,BUILDING_FRONT);
				gl.glTexCoord2f(3f,2f); gl.glVertex3f(BUILDING_LEFT,BUILDING_HEIGHT,BUILDING_BACK);
				gl.glTexCoord2f(3f,0f); gl.glVertex3f(BUILDING_LEFT,WINDOW_TOP_HEIGHT,BUILDING_BACK);
				gl.glTexCoord2f(0f,0f); gl.glVertex3f(BUILDING_LEFT,WINDOW_TOP_HEIGHT,BUILDING_FRONT);
			gl.glEnd();
			innerTexture.bind(gl);
			gl.glBegin(GL2.GL_QUADS);
				// first section
				gl.glTexCoord2f(0f,2f); gl.glVertex3f(BUILDING_LEFT,DOOR_HEIGHT,BUILDING_FRONT);
				gl.glTexCoord2f(0f,0f); gl.glVertex3f(BUILDING_LEFT,0,BUILDING_FRONT);
				gl.glTexCoord2f(3f,0f); gl.glVertex3f(BUILDING_LEFT,0,toLeftDoor);
				gl.glTexCoord2f(3f,2f); gl.glVertex3f(BUILDING_LEFT,DOOR_HEIGHT,toLeftDoor);
				// second section
				gl.glTexCoord2f(0f,2f); gl.glVertex3f(BUILDING_LEFT,DOOR_HEIGHT,fromLeftDoor);
				gl.glTexCoord2f(0f,0f); gl.glVertex3f(BUILDING_LEFT,0,fromLeftDoor);
				gl.glTexCoord2f(3f,0f); gl.glVertex3f(BUILDING_LEFT,0,BUILDING_BACK);
				gl.glTexCoord2f(3f,2f); gl.glVertex3f(BUILDING_LEFT,DOOR_HEIGHT,BUILDING_BACK);
				//mid portion
				gl.glTexCoord2f(0f,2f); gl.glVertex3f(BUILDING_LEFT,WINDOW_BOTTOM_HEIGHT,BUILDING_FRONT);
				gl.glTexCoord2f(0f,0f); gl.glVertex3f(BUILDING_LEFT,DOOR_HEIGHT,BUILDING_FRONT);
				gl.glTexCoord2f(3f,0f); gl.glVertex3f(BUILDING_LEFT,DOOR_HEIGHT,BUILDING_BACK);
				gl.glTexCoord2f(3f,2f); gl.glVertex3f(BUILDING_LEFT,WINDOW_BOTTOM_HEIGHT,BUILDING_BACK);
				// add windows
				// front section
				gl.glTexCoord2f(0f,2f); gl.glVertex3f(BUILDING_LEFT,WINDOW_BOTTOM_HEIGHT,BUILDING_FRONT);
				gl.glTexCoord2f(3f,2f); gl.glVertex3f(BUILDING_LEFT,WINDOW_BOTTOM_HEIGHT,toWindow1);
				gl.glTexCoord2f(3f,0f); gl.glVertex3f(BUILDING_LEFT,WINDOW_TOP_HEIGHT,toWindow1);
				gl.glTexCoord2f(0f,0f); gl.glVertex3f(BUILDING_LEFT,WINDOW_TOP_HEIGHT,BUILDING_FRONT);
				// mid section
				gl.glTexCoord2f(0f,2f); gl.glVertex3f(BUILDING_LEFT,WINDOW_BOTTOM_HEIGHT,fromWindow1);
				gl.glTexCoord2f(3f,2f); gl.glVertex3f(BUILDING_LEFT,WINDOW_BOTTOM_HEIGHT,toWindow2);
				gl.glTexCoord2f(3f,0f); gl.glVertex3f(BUILDING_LEFT,WINDOW_TOP_HEIGHT,toWindow2);
				gl.glTexCoord2f(0f,0f); gl.glVertex3f(BUILDING_LEFT,WINDOW_TOP_HEIGHT,fromWindow1);
				// back section
				gl.glTexCoord2f(0f,2f); gl.glVertex3f(BUILDING_LEFT,WINDOW_BOTTOM_HEIGHT,fromWindow2);
				gl.glTexCoord2f(3f,2f); gl.glVertex3f(BUILDING_LEFT,WINDOW_BOTTOM_HEIGHT,BUILDING_BACK);
				gl.glTexCoord2f(3f,0f); gl.glVertex3f(BUILDING_LEFT,WINDOW_TOP_HEIGHT,BUILDING_BACK);
				gl.glTexCoord2f(0f,0f); gl.glVertex3f(BUILDING_LEFT,WINDOW_TOP_HEIGHT,fromWindow2);
				// top section
				gl.glTexCoord2f(0f,2f); gl.glVertex3f(BUILDING_LEFT,BUILDING_HEIGHT,BUILDING_FRONT);
				gl.glTexCoord2f(0f,0f); gl.glVertex3f(BUILDING_LEFT,WINDOW_TOP_HEIGHT,BUILDING_FRONT);
				gl.glTexCoord2f(3f,0f); gl.glVertex3f(BUILDING_LEFT,WINDOW_TOP_HEIGHT,BUILDING_BACK);
				gl.glTexCoord2f(3f,2f); gl.glVertex3f(BUILDING_LEFT,BUILDING_HEIGHT,BUILDING_BACK);
			gl.glEnd();
		// back wall, using automatic texture generation - BACK, with a door but no windows
		gl.glEnable(GL2.GL_TEXTURE_GEN_S);
		gl.glEnable(GL2.GL_TEXTURE_GEN_T);
			outerTexture.bind(gl);
			gl.glTexGeni(GL2.GL_S, GL2.GL_TEXTURE_GEN_MODE, GL2.GL_OBJECT_LINEAR);
			gl.glTexGeni(GL2.GL_T, GL2.GL_TEXTURE_GEN_MODE, GL2.GL_OBJECT_LINEAR);
			float[] coef_s = {.38f,0,0,0};
			gl.glTexGenfv(GL2.GL_S, GL2.GL_OBJECT_PLANE, coef_s, 0);
			float[] coef_t = {0,.21f,0,0};
			gl.glTexGenfv(GL2.GL_T, GL2.GL_OBJECT_PLANE, coef_t, 0);
			gl.glBegin(GL2.GL_QUADS);
				// section 1
				gl.glVertex3f(toBackDoor,0,BUILDING_BACK);
				gl.glVertex3f(BUILDING_LEFT,0,BUILDING_BACK);
				gl.glVertex3f(BUILDING_LEFT,DOOR_HEIGHT,BUILDING_BACK);
				gl.glVertex3f(toBackDoor,DOOR_HEIGHT,BUILDING_BACK);
				// section 2
				gl.glVertex3f(BUILDING_RIGHT,0,BUILDING_BACK);
				gl.glVertex3f(fromBackDoor,0,BUILDING_BACK);
				gl.glVertex3f(fromBackDoor,DOOR_HEIGHT,BUILDING_BACK);
				gl.glVertex3f(BUILDING_RIGHT,DOOR_HEIGHT,BUILDING_BACK);
				// top section
				gl.glVertex3f(BUILDING_RIGHT,DOOR_HEIGHT,BUILDING_BACK);
				gl.glVertex3f(BUILDING_LEFT,DOOR_HEIGHT,BUILDING_BACK);
				gl.glVertex3f(BUILDING_LEFT,BUILDING_HEIGHT,BUILDING_BACK);
				gl.glVertex3f(BUILDING_RIGHT,BACK_RIGHT_HEIGHT,BUILDING_BACK);
			gl.glEnd();
			innerTexture.bind(gl);
			gl.glBegin(GL2.GL_QUADS);
				// section 1
				gl.glVertex3f(toBackDoor,0,BUILDING_BACK);
				gl.glVertex3f(toBackDoor,DOOR_HEIGHT,BUILDING_BACK);
				gl.glVertex3f(BUILDING_LEFT,DOOR_HEIGHT,BUILDING_BACK);
				gl.glVertex3f(BUILDING_LEFT,0,BUILDING_BACK);
				// section 2
				gl.glVertex3f(BUILDING_RIGHT,0,BUILDING_BACK);
				gl.glVertex3f(BUILDING_RIGHT,DOOR_HEIGHT,BUILDING_BACK);
				gl.glVertex3f(fromBackDoor,DOOR_HEIGHT,BUILDING_BACK);
				gl.glVertex3f(fromBackDoor,0,BUILDING_BACK);
				// top section
				gl.glVertex3f(BUILDING_RIGHT,DOOR_HEIGHT,BUILDING_BACK);
				gl.glVertex3f(BUILDING_RIGHT,BACK_RIGHT_HEIGHT,BUILDING_BACK);
				gl.glVertex3f(BUILDING_LEFT,BUILDING_HEIGHT,BUILDING_BACK);
				gl.glVertex3f(BUILDING_LEFT,DOOR_HEIGHT,BUILDING_BACK);
			gl.glEnd();
		// right wall - no door but windows
			outerTexture.bind(gl);
			coef_s[0]=.75f;coef_s[2]=.15f;
			gl.glTexGenfv(GL2.GL_S, GL2.GL_OBJECT_PLANE, coef_s, 0);
			coef_t[1]=.63f;
			gl.glTexGenfv(GL2.GL_T, GL2.GL_OBJECT_PLANE, coef_t, 0);
			gl.glBegin(GL2.GL_QUADS);
				// bottom section
				gl.glVertex3f(BUILDING_RIGHT,0,BUILDING_FRONT);
				gl.glVertex3f(BUILDING_RIGHT,0,BUILDING_BACK);
				gl.glVertex3f(BUILDING_RIGHT,WINDOW_BOTTOM_HEIGHT,BUILDING_BACK);
				gl.glVertex3f(BUILDING_RIGHT,WINDOW_BOTTOM_HEIGHT,BUILDING_FRONT);
				// add windows
				// front section
				gl.glVertex3f(BUILDING_RIGHT,WINDOW_BOTTOM_HEIGHT,BUILDING_FRONT);
				gl.glVertex3f(BUILDING_RIGHT,WINDOW_BOTTOM_HEIGHT,toWindow1);
				gl.glVertex3f(BUILDING_RIGHT,WINDOW_TOP_HEIGHT,toWindow1);
				gl.glVertex3f(BUILDING_RIGHT,WINDOW_TOP_HEIGHT,BUILDING_FRONT);
				// mid section
				gl.glVertex3f(BUILDING_RIGHT,WINDOW_BOTTOM_HEIGHT,fromWindow1);
				gl.glVertex3f(BUILDING_RIGHT,WINDOW_BOTTOM_HEIGHT,toWindow2);
				gl.glVertex3f(BUILDING_RIGHT,WINDOW_TOP_HEIGHT,toWindow2);
				gl.glVertex3f(BUILDING_RIGHT,WINDOW_TOP_HEIGHT,fromWindow1);
				// back section
				gl.glVertex3f(BUILDING_RIGHT,WINDOW_BOTTOM_HEIGHT,fromWindow2);
				gl.glVertex3f(BUILDING_RIGHT,WINDOW_BOTTOM_HEIGHT,BUILDING_BACK);
				gl.glVertex3f(BUILDING_RIGHT,WINDOW_TOP_HEIGHT,BUILDING_BACK);
				gl.glVertex3f(BUILDING_RIGHT,WINDOW_TOP_HEIGHT,fromWindow2);
				// top section
				gl.glVertex3f(BUILDING_RIGHT,WINDOW_TOP_HEIGHT,BUILDING_FRONT);
				gl.glVertex3f(BUILDING_RIGHT,WINDOW_TOP_HEIGHT,BUILDING_BACK);
				gl.glVertex3f(BUILDING_RIGHT,BACK_RIGHT_HEIGHT,BUILDING_BACK);
				gl.glVertex3f(BUILDING_RIGHT,BUILDING_HEIGHT,BUILDING_FRONT);
			gl.glEnd();
			innerTexture.bind(gl);
			gl.glBegin(GL2.GL_QUADS);
				// bottom section
				gl.glVertex3f(BUILDING_RIGHT,0,BUILDING_FRONT);
				gl.glVertex3f(BUILDING_RIGHT,WINDOW_BOTTOM_HEIGHT,BUILDING_FRONT);
				gl.glVertex3f(BUILDING_RIGHT,WINDOW_BOTTOM_HEIGHT,BUILDING_BACK);
				gl.glVertex3f(BUILDING_RIGHT,0,BUILDING_BACK);
				// add windows
				// front section
				gl.glVertex3f(BUILDING_RIGHT,WINDOW_BOTTOM_HEIGHT,BUILDING_FRONT);
				gl.glVertex3f(BUILDING_RIGHT,WINDOW_TOP_HEIGHT,BUILDING_FRONT);
				gl.glVertex3f(BUILDING_RIGHT,WINDOW_TOP_HEIGHT,toWindow1);
				gl.glVertex3f(BUILDING_RIGHT,WINDOW_BOTTOM_HEIGHT,toWindow1);
				// mid section
				gl.glVertex3f(BUILDING_RIGHT,WINDOW_BOTTOM_HEIGHT,fromWindow1);
				gl.glVertex3f(BUILDING_RIGHT,WINDOW_TOP_HEIGHT,fromWindow1);
				gl.glVertex3f(BUILDING_RIGHT,WINDOW_TOP_HEIGHT,toWindow2);
				gl.glVertex3f(BUILDING_RIGHT,WINDOW_BOTTOM_HEIGHT,toWindow2);
				// back section
				gl.glVertex3f(BUILDING_RIGHT,WINDOW_BOTTOM_HEIGHT,fromWindow2);
				gl.glVertex3f(BUILDING_RIGHT,WINDOW_TOP_HEIGHT,fromWindow2);
				gl.glVertex3f(BUILDING_RIGHT,WINDOW_TOP_HEIGHT,BUILDING_BACK);
				gl.glVertex3f(BUILDING_RIGHT,WINDOW_BOTTOM_HEIGHT,BUILDING_BACK);
				// top section
				gl.glVertex3f(BUILDING_RIGHT,WINDOW_TOP_HEIGHT,BUILDING_FRONT);
				gl.glVertex3f(BUILDING_RIGHT,BUILDING_HEIGHT,BUILDING_FRONT);
				gl.glVertex3f(BUILDING_RIGHT,BACK_RIGHT_HEIGHT,BUILDING_BACK);
				gl.glVertex3f(BUILDING_RIGHT,WINDOW_TOP_HEIGHT,BUILDING_BACK);
			gl.glEnd();
		gl.glDisable(GL2.GL_CULL_FACE);
		gl.glDisable(GL2.GL_TEXTURE_2D);
		gl.glDisable(GL2.GL_TEXTURE_GEN_S);
		gl.glDisable(GL2.GL_TEXTURE_GEN_T);
	}
	
	public void drawMoving(GL2 gl,GLU glu,float x,float y,float z){
		// hourglass
		if(fillingHourglass){
			hourglassFrame+=hgFrameRate;
			if(hourglassFrame>=maxHgBoundary)fillingHourglass=false;
		}else{
			hourglassFrame-=hgFrameRate;
			if(hourglassFrame<=hgFrameRate*minhgFRBoundaryFactor)fillingHourglass=true;
		}
		gl.glPushMatrix();
			gl.glTranslatef(MAX_X*.35f, 0, MAX_Z*.4f);
			gl.glRotatef(-90, 1, 0, 0);
			
			gl.glColor3f(.3f,.3f,.3f);
			// base of bottom half
			glu.gluCylinder(quadric, HOURGLASS_DIAMETER+1, HOURGLASS_DIAMETER+1, HOURGLASS_BASE_HEIGHT, SLICES, STACKS);
			gl.glTranslatef(0, 0, HOURGLASS_BASE_HEIGHT);
			glu.gluDisk(quadric,0,HOURGLASS_DIAMETER+1,SLICES,STACKS);
			// base of upper half
			gl.glTranslatef(0, 0, HOURGLASS_HEIGHT);
			glu.gluDisk(quadric,0,HOURGLASS_DIAMETER+1,SLICES,STACKS);
			glu.gluCylinder(quadric, HOURGLASS_DIAMETER+1, HOURGLASS_DIAMETER+1, HOURGLASS_BASE_HEIGHT, SLICES, STACKS);
			gl.glTranslatef(0, 0, -HOURGLASS_HEIGHT);
			
			// sand at bottom half
			gl.glEnable(GL2.GL_TEXTURE_2D);
				sandTexture.bind(gl);
				float sandDiameter1=HOURGLASS_DIAMETER*(1f-hourglassFrame),sandHeight1=CONE_HEIGHT*hourglassFrame;
				glu.gluCylinder(textureQuadric, HOURGLASS_DIAMETER, sandDiameter1, sandHeight1, SLICES, STACKS);
				gl.glTranslatef(0,0,sandHeight1);
				glu.gluDisk(textureQuadric, 0, sandDiameter1, SLICES, STACKS);
			gl.glDisable(GL2.GL_TEXTURE_2D);
			// empty part of bottom half
			gl.glEnable(GL2.GL_BLEND);
				gl.glBlendFunc(GL2.GL_SRC_ALPHA, GL2.GL_ONE_MINUS_SRC_ALPHA);
				gl.glColor4f(0f,.5f,1f,.25f);
				float emptyHeight1=CONE_HEIGHT-sandHeight1;
				glu.gluCylinder(quadric, sandDiameter1, 0, emptyHeight1, SLICES, STACKS);
			gl.glDisable(GL2.GL_BLEND);
			gl.glTranslatef(0,0,emptyHeight1);
			// sand at upper half
			gl.glEnable(GL2.GL_TEXTURE_2D);
				float sandDiameter2=maxSandDiameter2*(1-hourglassFrame/maxHgBoundary),
						sandHeight2=(float)(maxSandHeight2)*(1-hourglassFrame/maxHgBoundary);
				glu.gluCylinder(textureQuadric, 0, sandDiameter2, sandHeight2, SLICES, STACKS);
				gl.glTranslatef(0,0,sandHeight2);
				glu.gluDisk(textureQuadric, 0, sandDiameter2, SLICES, STACKS);
			gl.glDisable(GL2.GL_TEXTURE_2D);
			// empty part of upper half
			gl.glEnable(GL2.GL_BLEND);
				gl.glBlendFunc(GL2.GL_SRC_ALPHA, GL2.GL_ONE_MINUS_SRC_ALPHA);
				gl.glColor4f(0f,.5f,1f,.25f);
				float emptyHeight2=CONE_HEIGHT-sandHeight2;
				glu.gluCylinder(quadric, sandDiameter2, HOURGLASS_DIAMETER, emptyHeight2, SLICES, STACKS);
			gl.glDisable(GL2.GL_BLEND);
		gl.glPopMatrix();
		
		// draw a sphere that changes color continuously
		gl.glPushMatrix();
			gl.glTranslatef(MAX_X*.63f, 0, MAX_Z*.69f);
			gl.glRotatef(-90, 1, 0, 0);
			// draw supporting base
			gl.glEnable(GL2.GL_TEXTURE_2D);
				ballBaseTexture.bind(gl);
				glu.gluCylinder(textureQuadric, RAINBOW_BALL_BASE, 0, RAINBOW_BALL_RADIUS*.4f, SLICES, STACKS);
			gl.glDisable(GL2.GL_TEXTURE_2D);
			
			gl.glTranslatef(0, 0, .0003f);
			gl.glEnable(GL2.GL_BLEND);
				gl.glBlendFunc(GL2.GL_SRC_ALPHA, GL2.GL_ONE_MINUS_SRC_ALPHA);
				// obtain current ball glow color
				gl.glColor4f(ballRed(), ballGreen(), ballBlue(), .3f);
				glu.gluDisk(quadric, 1, RAINBOW_BALL_BASE*1.75f, SLICES, STACKS);
				// draw 'glowing' ball
				gl.glRotatef(90, 1, 0, 0);
				gl.glTranslatef(0, RAINBOW_BALL_RADIUS, 0);
				gl.glColor4f(ballRed(), ballGreen(), ballBlue(), 1f);
				glu.gluSphere(quadric, RAINBOW_BALL_RADIUS, SLICES, STACKS);	// actual (opaque) sphere
				gl.glColor4f(ballRed(), ballGreen(), ballBlue(), .8f);
				glu.gluSphere(quadric, RAINBOW_BALL_RADIUS+.5, SLICES, STACKS);	// most intense glow
				gl.glColor4f(ballRed(), ballGreen(), ballBlue(), .6f);
				glu.gluSphere(quadric, RAINBOW_BALL_RADIUS+1, SLICES, STACKS);
				gl.glColor4f(ballRed(), ballGreen(), ballBlue(), .4f);
				glu.gluSphere(quadric, RAINBOW_BALL_RADIUS+1.5, SLICES, STACKS);
				gl.glColor4f(ballRed(), ballGreen(), ballBlue(), .2f);
				glu.gluSphere(quadric, RAINBOW_BALL_RADIUS+2, SLICES, STACKS);	// softest glow
			gl.glDisable(GL2.GL_BLEND);
			gl.glPopMatrix();
			// update ball color
			if(colorState%2==0){
				if(ballColorFrame>=1f){
					ballColorFrame-=rainbowFrameRate;
					updateColorState();
				}else ballColorFrame+=rainbowFrameRate;
			}else{
				if(ballColorFrame<=0){
					ballColorFrame+=rainbowFrameRate;
					updateColorState();
				}else ballColorFrame-=rainbowFrameRate;
			}
	}
	private float ballRed(){
		switch(colorState){
			case rToY:
			case mToR:return 1f;
			case yToG:
			case bToM:return ballColorFrame;
			default: return 0;
		}
	}
	private float ballGreen(){
		switch(colorState){
			case yToG:
			case gToA:return 1f;
			case rToY:
			case aToB:return ballColorFrame;
			default: return 0;
		}
	}
	private float ballBlue(){
		switch(colorState){
			case aToB:
			case bToM:return 1f;
			case gToA:
			case mToR:return ballColorFrame;
			default: return 0;
		}
	}
	private void updateColorState(){
		if(colorState==mToR)colorState=rToY;
		else colorState++;
	}
}
