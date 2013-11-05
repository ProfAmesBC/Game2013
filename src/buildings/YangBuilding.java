package buildings;
import game.Building;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;

import com.jogamp.opengl.util.texture.Texture;

public class YangBuilding extends Building {
    private GLUquadric quadric; // to control properties of quadric-based objects
    private GLUquadric sphereQuadric; // for Signorile's head
    private Texture graniteTexture;     // bricks
    private Texture outerTexture; // for the sphere
    private Texture floorTexture;
    private DoubleSidedWall wallBack, wallRight, wallLeft, floor, ceiling;
    private DoubleSidedWall doorframeLeft, doorframeRight, doorframeTop;
    private Roof roofFront, roofBack, roofLeft, roofRight;
    private PictureFrame portrait;
    private Table table;
    private Chair chair;
    private Point3d bTopLeft, bTopRight, bBotLeft, bBotRight, fTopLeft, fTopRight, fBotLeft, fBotRight, center;
    private Point3d doorBotLeft, doorBotRight, doorTopLeft, doorTopRight;
    private final double HEIGHT = 15;
    private final double DEPTH = 25;
    private final double WIDTH = DEPTH/2;
    private final double Z_POINT = -2; //initial point for front bottom-left corner
    private Land land = null;

    public YangBuilding(GL2 gl, GLU glu) {
        land = new Land(gl, glu);
        quadric = glu.gluNewQuadric();
        glu.gluQuadricDrawStyle(quadric, GLU.GLU_FILL); // GLU_POINT, GLU_LINE, GLU_FILL, GLU_SILHOUETTE
        glu.gluQuadricNormals  (quadric, GLU.GLU_NONE); // GLU_NONE, GLU_FLAT, or GLU_SMOOTH
        glu.gluQuadricTexture  (quadric, true);        // use true to generate texture coordinates

        sphereQuadric = glu.gluNewQuadric();
        glu.gluQuadricDrawStyle(sphereQuadric, GLU.GLU_FILL);
        glu.gluQuadricNormals  (sphereQuadric, GLU.GLU_NONE);
        glu.gluQuadricTexture  (sphereQuadric, true); // for Signorile's head

        outerTexture = setupTexture(gl, "textureouter.gif");
        graniteTexture     = setupTexture(gl, "texturegranite.gif"); // png's don't seem to work any more
        floorTexture     = setupTexture(gl, "texturefloor.gif"); // png's don't seem to work any more
        
        //vertices for house frame
        bTopLeft = new Point3d(-WIDTH,HEIGHT,Z_POINT-DEPTH);
        bTopRight =  new Point3d(WIDTH,HEIGHT,Z_POINT-DEPTH);
        bBotLeft = new Point3d(-WIDTH,.001,Z_POINT-DEPTH);
        bBotRight = new Point3d(WIDTH,.001,Z_POINT-DEPTH);
        fTopLeft = new Point3d(-WIDTH,HEIGHT,Z_POINT);
        fTopRight =  new Point3d(WIDTH,HEIGHT,Z_POINT);
        fBotLeft = new Point3d(-WIDTH,.001,Z_POINT);
        fBotRight = new Point3d(WIDTH,.001,Z_POINT);
        center = new Point3d(0,HEIGHT*1.8,Z_POINT-(DEPTH/2));
        
        //front door vertices
        double doorWidth = 4; 
        double doorHeight = 7;
        doorTopLeft = new Point3d(-doorWidth/2, doorHeight,Z_POINT);
        doorTopRight = new Point3d(doorWidth/2,doorHeight,Z_POINT);
        doorBotLeft = new Point3d(-2,.001,Z_POINT);
        doorBotRight = new Point3d(2,.001,Z_POINT);  

        //house walls
        wallBack = new DoubleSidedWall(gl, glu, bBotLeft, bBotRight, bTopRight, bTopLeft, graniteTexture, outerTexture, new float[] {.3f,0,.3f,0}, new float[] {0,.3f,0,0});
        wallLeft = new DoubleSidedWall(gl, glu, fBotLeft, bBotLeft, bTopLeft, fTopLeft, graniteTexture, outerTexture, new float[] {.3f,0,.3f,0}, new float[] {0,.3f,0,0});
        wallRight = new DoubleSidedWall(gl, glu, fBotRight, bBotRight, bTopRight, fTopRight,outerTexture,  graniteTexture, new float[] {.3f,0,.3f,0}, new float[] {0,.3f,0,0});
        ceiling = new DoubleSidedWall(gl, glu, bTopLeft, bTopRight, fTopRight, fTopLeft, graniteTexture, graniteTexture, new float[] {1.3f,0f,0f,0}, new float[] {0,.5f,0,0});

        //roof
        roofFront = new Roof(gl, glu, fTopLeft, fTopRight, center);
        roofBack = new Roof(gl, glu, bTopLeft, bTopRight, center);
        roofLeft = new Roof(gl, glu, fTopLeft, bTopLeft, center);
        roofRight = new Roof(gl, glu, fTopRight, bTopRight, center);
        
        //front wall
        doorframeLeft = new DoubleSidedWall(gl, glu, fBotLeft, doorBotLeft, doorTopLeft, new Point3d(fBotLeft.getX(), doorTopLeft.getY(), fTopLeft.getZ()), outerTexture, graniteTexture, new float[] {.3f,0,.3f,0}, new float[] {0,.3f,0,0});
        doorframeRight = new DoubleSidedWall(gl, glu, doorBotRight, fBotRight, new Point3d(fBotRight.getX(), doorTopRight.getY(), fTopRight.getZ()), doorTopRight, outerTexture, graniteTexture, new float[] {.3f,0,.3f,0}, new float[] {0,.3f,0,0});
        doorframeTop = new DoubleSidedWall(gl, glu, new Point3d(fBotLeft.getX(), doorTopLeft.getY(), fTopLeft.getZ()), new Point3d(fBotRight.getX(), doorTopRight.getY(), fTopRight.getZ()), fTopRight, fTopLeft, outerTexture, graniteTexture, new float[] {.3f,0,.3f,0}, new float[] {0,.3f,0,0});
        
        //misc. furnishings
        floor = new DoubleSidedWall(gl, glu, bBotLeft, bBotRight, fBotRight, fBotLeft, floorTexture, floorTexture, new float[] {.3f,0,.3f,0}, new float[] {0,.3f,0,0});
        table = new Table(gl,glu,new Point3d(-WIDTH,0,DEPTH/.9));
        chair = new Chair(gl, glu, new Point3d(-WIDTH,0,DEPTH/.9));
        portrait = new PictureFrame(gl,glu,new Point3d(fBotLeft.getX(),fBotLeft.getY(),fBotLeft.getZ()));
    }

    public void draw(GL2 gl, GLU glu) {
        gl.glPushMatrix();
        gl.glTranslatef(0,0,100);
        // land
            land.draw(gl, glu);
        //building
            gl.glPushMatrix();
            	gl.glTranslated(60, 0, -40);
            	wallBack.draw(gl,glu);
            	wallLeft.draw(gl, glu);
            	wallRight.draw(gl,glu);
            	doorframeLeft.draw(gl,glu);
            	doorframeRight.draw(gl,glu);
            	doorframeTop.draw(gl,glu);
            	floor.draw(gl,glu);
            	ceiling.draw(gl,glu);
            	roofFront.draw(gl,glu);
            	roofBack.draw(gl,glu);
            	roofLeft.draw(gl, glu);
            	roofRight.draw(gl,glu);

            	//table
            	gl.glPushMatrix();
            		gl.glTranslated(0,0,Z_POINT-DEPTH*.4);
            		gl.glScaled(1.5,1.5,1.5);
            		table.draw(gl, glu);
            	gl.glPopMatrix();
            
            	//chair
            	
            	//leftchair
            	gl.glPushMatrix();
            	gl.glRotated(20,0,1,0);
            	gl.glTranslated(5,0,1.2);
            	gl.glPushMatrix();
            		gl.glTranslated(1,0,Z_POINT-DEPTH*.47);
            		gl.glScaled(2,1.2,2);
            		gl.glRotated(90,0,1,0);
            		chair.draw(gl, glu);
            	gl.glPopMatrix();
            	gl.glPopMatrix();
            	
            	//right chair
            	gl.glPushMatrix();
        		gl.glTranslated(7,0,Z_POINT-DEPTH*.55);
        		gl.glScaled(2,1.2,2);
        		gl.glRotated(270,0,1,0);
        		chair.draw(gl, glu);
        		gl.glPopMatrix();
        		
        		//far chair
        		gl.glPushMatrix();
        		gl.glRotated(90,0,0,1);
        		gl.glTranslated(-2.8,-4,-2);
            	gl.glPushMatrix();
        		gl.glTranslated(3,0,Z_POINT-DEPTH*.60);
        		gl.glScaled(2,1.2,2);
        		chair.draw(gl, glu);
        		gl.glPopMatrix();
        		gl.glPopMatrix();
        		
        		//near chair
        		gl.glPushMatrix();
        		gl.glRotated(45,0,1,0);
        		gl.glTranslated(8,0,9);
            	gl.glPushMatrix();
        		gl.glTranslated(4.5,0,Z_POINT-DEPTH*.4);
        		gl.glRotated(180,0,1,0);
        		gl.glScaled(2,1.2,2);
        		chair.draw(gl, glu);
        		gl.glPopMatrix();
        		gl.glPopMatrix();
            
            	//wall portrait
            	gl.glPushMatrix();
            		gl.glTranslated(-10,3,Z_POINT-DEPTH*.8);
            		gl.glRotated(90, 0, 1, 0);
            		portrait.draw(gl,glu);
            	gl.glPopMatrix();          	
            	
            gl.glPopMatrix();
        gl.glPopMatrix();
   }
}
