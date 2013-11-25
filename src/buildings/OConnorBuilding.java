package buildings;

import game.Building;
import java.util.ArrayList;
import java.util.List;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;

import com.jogamp.opengl.util.texture.Texture;

public class OConnorBuilding extends Building {

	private List<OConnorQuad> ground;
	private List<OConnorQuad> walls;
	private List<OConnorQuad> roofPanels;
	private List<OConnorScenery> innerScenery;
	private List<OConnorScenery> outerScenery;
	private static float lotSize = 100.0f;
	private static float doorHeight = 12.0f;
	private static float doorWidth = 7.0f;
	private static float wallWidth = 40.0f;
	private static float wallHeight = 20.0f;
	private static float windowSize = 10.0f;
	private static float tvSize = 10.0f;

	private static String INTERIOR_TEXTURE = "OConnorStars.jpg",
			EXTERIOR_TEXTURE = "OConnorSiding.jpg",
			GRASS_TEXTURE = "OConnorGrass.jpg",
			FLOOR_TEXTURE = "OConnorPlank.png",
			ROOF_TEXTURE = "OConnorCedar.jpg",
			TV_SIDE_TEXTURE = "OConnorTVSide.jpg",
			TV_SHOW_TEXTURE = "OConnorTVShow.jpg";

	public OConnorBuilding(GL2 gl, GLU glu) {
		
		/*--------- SET UP TEXTURES --------------*/
		Texture interiorWall = setupTexture(gl, INTERIOR_TEXTURE);
		Texture exteriorWall = setupTexture(gl, EXTERIOR_TEXTURE);
		Texture grass = setupTexture(gl, GRASS_TEXTURE);
		Texture floor = setupTexture(gl, FLOOR_TEXTURE);
		Texture roof = setupTexture(gl, ROOF_TEXTURE);
		Texture tvSide = setupTexture(gl, TV_SIDE_TEXTURE);
		Texture tvShow = setupTexture(gl, TV_SHOW_TEXTURE);
		
		/*---------- MAKE KEY VERTICES -----------*/
		float cornerNear = lotSize/2 - wallWidth/2;
		float cornerFar = lotSize/2 + wallWidth/2;
		float doorLeft = lotSize/2 - doorWidth/2;
		float doorRight = lotSize/2 + doorWidth/2;
		float windowBottom = wallHeight/2 - windowSize/2;
		float windowTop = wallHeight/2 + windowSize/2;
		float windowLeft = lotSize/2 - windowSize/2;
		float windowRight = lotSize/2 + windowSize/2;
		
		Point3d bottomA = new Point3d(cornerNear, 0, cornerNear);
		Point3d bottomB = new Point3d(cornerNear, 0, cornerFar);
		Point3d bottomC = new Point3d(cornerFar, 0, cornerFar);
		Point3d bottomD = new Point3d(cornerFar, 0, cornerNear);
		Point3d topA = new Point3d(cornerNear, wallHeight, cornerNear);
		Point3d topB = new Point3d(cornerNear, wallHeight, cornerFar);
		Point3d topC = new Point3d(cornerFar, wallHeight, cornerFar);
		Point3d topD = new Point3d(cornerFar, wallHeight, cornerNear);
		Point3d roofBottomA = new Point3d(cornerNear - cornerNear/5, wallHeight - wallHeight/5, cornerNear - cornerNear/5);
		Point3d roofBottomB = new Point3d(cornerNear - cornerNear/5, wallHeight - wallHeight/5, cornerFar +  cornerNear/5);
		Point3d roofBottomC = new Point3d(cornerFar + cornerNear/5, wallHeight - wallHeight/5, cornerFar + cornerNear/5);
		Point3d roofBottomD = new Point3d(cornerFar + cornerNear/5, wallHeight - wallHeight/5, cornerNear - cornerNear/5);
		Point3d roofTopA = new Point3d(cornerNear + cornerNear/5, wallHeight + wallHeight/5, cornerNear + cornerNear/5);
		Point3d roofTopB = new Point3d(cornerNear + cornerNear/5, wallHeight + wallHeight/5, cornerFar -  cornerNear/5);
		Point3d roofTopC = new Point3d(cornerFar - cornerNear/5, wallHeight + wallHeight/5, cornerFar - cornerNear/5);
		Point3d roofTopD = new Point3d(cornerFar - cornerNear/5, wallHeight + wallHeight/5, cornerNear + cornerNear/5);
		ground = new ArrayList<OConnorQuad>();
		walls = new ArrayList<OConnorQuad>();
		roofPanels = new ArrayList<OConnorQuad>();
		innerScenery = new ArrayList<OConnorScenery>();
		outerScenery = new ArrayList<OConnorScenery>();

		/*------------- SET UP GROUND --------------*/
		// Make ground on left of house
		ground.add(new OConnorQuad(new Point3d(0,0,0),
				new Point3d(cornerNear,0,0),
				new Point3d(cornerNear,0,lotSize),
				new Point3d(0, 0, lotSize), false,
				grass, grass, gl, glu));

		// Make ground on right of house
		ground.add(new OConnorQuad(new Point3d(cornerFar,0,0),
				new Point3d(lotSize,0,0),
				new Point3d(lotSize,0,lotSize),
				new Point3d(cornerFar, 0, lotSize), false,
				grass, grass, gl, glu));
		
		// Make ground in front of house
		ground.add(new OConnorQuad(new Point3d(cornerNear,0,0),
				new Point3d(cornerFar,0,0),
				new Point3d(cornerFar,0,cornerNear),
				new Point3d(cornerNear, 0, cornerNear), false,
				grass, grass, gl, glu));
		
		// Make ground behind house
		ground.add(new OConnorQuad(new Point3d(cornerNear,0,cornerFar),
				new Point3d(cornerFar,0,cornerFar),
				new Point3d(cornerFar,0,lotSize),
				new Point3d(cornerNear, 0, lotSize), false,
				grass, grass, gl, glu));
		
		// Make floor in house
		ground.add(new OConnorQuad(new Point3d(cornerNear,0,cornerNear),
				new Point3d(cornerFar,0,cornerNear),
				new Point3d(cornerFar,0,cornerFar),
				new Point3d(cornerNear, 0, cornerFar), false,
				floor, floor, gl, glu));
		
		/*--------------- SET UP WALLS -----------*/
		// Add front wall right
		walls.add(new OConnorQuad(bottomD, new Point3d(doorRight, 0, cornerNear),
				new Point3d(doorRight, doorHeight, cornerNear),
				new Point3d(cornerFar, doorHeight, cornerNear), false,
				interiorWall, exteriorWall, gl, glu));
		// Add front wall left
		walls.add(new OConnorQuad(new Point3d(doorLeft, 0, cornerNear), bottomA,
				new Point3d(cornerNear, doorHeight, cornerNear),
				new Point3d(doorLeft, doorHeight, cornerNear), false,
				interiorWall, exteriorWall, gl, glu));
		// Add front wall top
		walls.add(new OConnorQuad(new Point3d(cornerFar, doorHeight, cornerNear),
				new Point3d(cornerNear, doorHeight, cornerNear), topA, topD, false,
				interiorWall, exteriorWall, gl, glu));
		// Add left wall bottom
		walls.add(new OConnorQuad(bottomA, bottomB,
				new Point3d(cornerNear, windowBottom, cornerFar),
				new Point3d(cornerNear, windowBottom, cornerNear), false,
				interiorWall, exteriorWall, gl, glu));
		// Add left wall middle left chunk
		walls.add(new OConnorQuad(new Point3d(cornerNear, windowBottom, cornerNear),
				new Point3d(cornerNear, windowBottom, windowLeft),
				new Point3d(cornerNear, windowTop, windowLeft),
				new Point3d(cornerNear, windowTop, cornerNear), false,
				interiorWall, exteriorWall, gl, glu));
		// Add left wall middle right chunk
		walls.add(new OConnorQuad(new Point3d(cornerNear, windowBottom, windowRight),
				new Point3d(cornerNear, windowBottom, cornerFar),
				new Point3d(cornerNear, windowTop, cornerFar),
				new Point3d(cornerNear, windowTop, windowRight), false,
				interiorWall, exteriorWall, gl, glu));
		// Add left wall top
		walls.add(new OConnorQuad(new Point3d(cornerNear, windowTop, cornerNear),
				new Point3d(cornerNear, windowTop, cornerFar),
				topB, topA, false,
				interiorWall, exteriorWall, gl, glu));
		// Add right wall bottom
		walls.add(new OConnorQuad(bottomC, bottomD,
				new Point3d(cornerFar, windowBottom, cornerNear),
				new Point3d(cornerFar, windowBottom, cornerFar), false,
				interiorWall, exteriorWall, gl, glu));
		// Add right wall middle left chunk
		walls.add(new OConnorQuad(new Point3d(cornerFar, windowBottom, cornerFar),
				new Point3d(cornerFar, windowBottom, windowRight),
				new Point3d(cornerFar, windowTop, windowRight),
				new Point3d(cornerFar, windowTop, cornerFar), false,
				interiorWall, exteriorWall, gl, glu));
		// Add right wall middle right chunk
		walls.add(new OConnorQuad(new Point3d(cornerFar, windowBottom, windowLeft),
				new Point3d(cornerFar, windowBottom, cornerNear),
				new Point3d(cornerFar, windowTop, cornerNear),
				new Point3d(cornerFar, windowTop, windowLeft), false,
				interiorWall, exteriorWall, gl, glu));
		// Add right wall top
		walls.add(new OConnorQuad(new Point3d(cornerFar, windowTop, cornerFar),
				new Point3d(cornerFar, windowTop, cornerNear),
				topD, topC, false,
				interiorWall, exteriorWall, gl, glu));
		// Add back wall
		walls.add(new OConnorQuad(bottomB, bottomC, topC, topB, false, interiorWall, exteriorWall, gl, glu));
		// Add top wall (so you can't see roof from inside)
		walls.add(new OConnorQuad(topD, topA, topB, topC, false, floor, floor, gl, glu));

		/*---------- SET UP ROOF ------------*/
		roofPanels.add(new OConnorQuad(roofBottomD, roofBottomA, roofTopA, roofTopD, false, roof, roof, gl, glu));
		roofPanels.add(new OConnorQuad(roofBottomA, roofBottomB, roofTopB, roofTopA, false, roof, roof, gl, glu));
		roofPanels.add(new OConnorQuad(roofBottomB, roofBottomC, roofTopC, roofTopB, false, roof, roof, gl, glu));
		roofPanels.add(new OConnorQuad(roofBottomC, roofBottomD, roofTopD, roofTopC, false, roof, roof, gl, glu));
		roofPanels.add(new OConnorQuad(roofTopD, roofTopA, roofTopB, roofTopC, false, roof, roof, gl, glu));

		/*---------- SET UP SCENERY ---------*/
		innerScenery.add(new OConnorTelevision(50, 0, cornerFar - tvSize/2, tvSize, tvSide, tvShow, gl, glu));
		innerScenery.add(new OConnorHangingLight(lotSize/2 + wallWidth/6, wallHeight, lotSize/2, 1f, 3, gl, glu));
		innerScenery.add(new OConnorHangingLight(lotSize/2 - wallWidth/6, wallHeight, lotSize/2, 1f, 3, gl, glu));
		innerScenery.add(new OConnorHangingLight(lotSize/2, wallHeight, lotSize/2 + wallWidth/6, 1f, 3, gl, glu));
		innerScenery.add(new OConnorHangingLight(lotSize/2, wallHeight, lotSize/2 - wallWidth/6, 1f, 3, gl, glu));
		
		outerScenery.add(new OConnorFloatingLight(lotSize/2, 50, lotSize/2, 2, 5, 10, 5, 7, gl, glu));
		outerScenery.add(new OConnorFloatingLight(lotSize/2, 40, lotSize/2, 3, 3, 20, -3, 5, gl, glu));
	}

	@Override
	public void drawMoving(GL2 gl, GLU glu, float eyeX, float eyeY, float eyeZ) {
		// Draw inner scenery
		for (OConnorScenery s : innerScenery) {
			s.draw(gl, glu);
		}
		// Draw out scenery
		for (OConnorScenery s: outerScenery) {
			s.draw(gl, glu);
		}
	}

	@Override
	public void draw(GL2 gl, GLU glu) {
		// TODO Auto-generated method stub
		// Draw ground
		for (OConnorQuad g : ground) {
			g.drawFront(gl, glu);
		}
		// Draw inner roof
		for (OConnorQuad r : roofPanels) {
			r.drawFront(gl, glu);
		}
		// Draw inner walls
		for (OConnorQuad w : walls) {
			w.drawFront(gl, glu);
		}
		// Draw outer walls
		for (OConnorQuad w : walls) {
			w.drawBack(gl, glu);
		}
		// Draw outer roof
		for (OConnorQuad r : roofPanels) {
			r.drawBack(gl, glu);
		}
	}
}
