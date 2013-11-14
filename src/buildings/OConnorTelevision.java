package buildings;
import java.util.ArrayList;
import java.util.List;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;

import com.jogamp.opengl.util.texture.Texture;

public class OConnorTelevision implements OConnorScenery {

	private List<OConnorQuad> sides;
	private OConnorQuad showQuad;
	
	public OConnorTelevision(float centerX, float bottomY, float centerZ, float size, Texture sideTexture, Texture show, GL2 gl, GLU glu) {
		
		Point3d frontBottomLeft = new Point3d(centerX - 2*size/3, bottomY, centerZ - size/3);
		Point3d frontBottomRight = new Point3d(centerX + 2*size/3, bottomY, centerZ - size/3);
		Point3d frontTopLeft = new Point3d(centerX - 2*size/3, bottomY + size, centerZ - size/3);
		Point3d frontTopRight = new Point3d(centerX + 2*size/3, bottomY + size, centerZ - size/3);
		Point3d backBottomLeft = new Point3d(centerX - 2*size/3, bottomY, centerZ + size/3);
		Point3d backBottomRight = new Point3d(centerX + 2*size/3, bottomY, centerZ + size/3);
		Point3d backTopLeft = new Point3d(centerX - 2*size/3, bottomY + size, centerZ + size/3);
		Point3d backTopRight = new Point3d(centerX + 2*size/3, bottomY + size, centerZ + size/3);
		Point3d screenBottomLeft = new Point3d(centerX - 2*size/3 + size/10, bottomY + size/10, centerZ - size/3 - 0.01f);
		Point3d screenBottomRight = new Point3d(centerX + 2*size/3 - size/10, bottomY + size/10, centerZ - size/3 - 0.01f);
		Point3d screenTopLeft = new Point3d(centerX - 2*size/3 + size/10, bottomY + size - size/10, centerZ - size/3 - 0.01f);
		Point3d screenTopRight = new Point3d(centerX + 2*size/3 - size/10, bottomY + size - size/10, centerZ - size/3 - 0.01f);
		
		this.sides = new ArrayList<OConnorQuad>();

		// Front side
		sides.add( new OConnorQuad(frontBottomLeft, frontBottomRight, frontTopRight, frontTopLeft, true, sideTexture, sideTexture, gl, glu) );
		// Back side
		sides.add( new OConnorQuad(backBottomRight, backBottomLeft, backTopLeft, backTopRight, true, sideTexture, sideTexture, gl, glu) );
		// Right side
		sides.add( new OConnorQuad(frontBottomRight, backBottomRight, backTopRight, frontTopRight, true, sideTexture, sideTexture, gl, glu) );
		// Left side
		sides.add( new OConnorQuad(backBottomLeft, frontBottomLeft, frontTopLeft, backTopLeft, true, sideTexture, sideTexture, gl, glu) );
		// Top side
		sides.add( new OConnorQuad(frontTopLeft, frontTopRight, backTopRight, backTopLeft, true, sideTexture, sideTexture, gl, glu) );
		// Bottom side
		sides.add( new OConnorQuad(backBottomLeft, backBottomRight, frontBottomRight, frontBottomLeft, true, sideTexture, sideTexture, gl, glu) );
		
		this.showQuad = new OConnorQuad(screenBottomLeft, screenBottomRight, screenTopRight, screenTopLeft, true, show, sideTexture, gl, glu);
	}

	public void draw(GL2 gl, GLU glu) {
		for (OConnorQuad s : sides) {
			s.drawFront(gl, glu);
		}
		showQuad.drawFront(gl, glu);
	}
}
