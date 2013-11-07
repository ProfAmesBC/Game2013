package buildings;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;

public class JossickWall {
	private double height;
	private Point3d lowleft;
	private Point3d lowright;
	private Point3d upperright;
	private Point3d upperleft;
	
	public JossickWall(Point3d low, Point3d high) {
		lowleft = low;
		upperright = high;
		height = upperright.getY()-lowleft.getY();
	}
	
	public JossickWall(Point3d lowl,  Point3d lowr, Point3d highr, Point3d highl) {
		lowleft = lowl;
		lowright = lowr;
		upperright = highr;
		upperleft = highl;
	}
	
	public void draw(GL2 gl, GLU glu) {
		gl.glBegin(GL2.GL_QUADS);
			gl.glVertex3d(lowleft.getX(),lowleft.getY(),lowleft.getZ());
			gl.glVertex3d(upperleft.getX(),upperleft.getY(),upperleft.getZ());
			gl.glVertex3d(upperright.getX(),upperright.getY(),upperright.getZ());
			gl.glVertex3d(lowright.getX(),lowright.getY(),lowright.getZ());
		gl.glEnd();
	}
	
	public void drawr(GL2 gl, GLU glu) {
		gl.glBegin(GL2.GL_QUADS);
		
		gl.glVertex3d(lowright.getX(),lowright.getY(),lowright.getZ());
		gl.glVertex3d(upperright.getX(),upperright.getY(),upperright.getZ());
		gl.glVertex3d(upperleft.getX(),upperleft.getY(),upperleft.getZ());
		gl.glVertex3d(lowleft.getX(),lowleft.getY(),lowleft.getZ());
	
		gl.glEnd();
	}
	
	
	public void drawTextured(GL2 gl, GLU glu, double [] cords) {
		gl.glBegin(GL2.GL_QUADS);
			gl.glTexCoord2d(cords[0],cords[1]);
		gl.glVertex3d(lowleft.getX(),lowleft.getY(),lowleft.getZ());
			gl.glTexCoord2d(cords[1],cords[2]);
		gl.glVertex3d(lowright.getX(),lowright.getY(),lowright.getZ());
			gl.glTexCoord2d(cords[2],cords[0]);
		gl.glVertex3d(upperright.getX(),upperright.getY(),upperright.getZ());
			gl.glTexCoord2d(cords[0],cords[0]);
		gl.glVertex3d(upperleft.getX(),upperleft.getY(),upperleft.getZ());
		gl.glEnd();
	}
}
