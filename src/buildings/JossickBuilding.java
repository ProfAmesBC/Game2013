package buildings;

import game.Building;
import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;
import com.jogamp.opengl.util.texture.Texture;

public class JossickBuilding extends Building {
	private Texture panelling;
	private GLUquadric quadric;
	private Texture grass;
	private Texture tile;
	private Texture roof;
	private Texture window;
	private Texture inside;

	public JossickBuilding(GL2 gl, GLU glu) {
		quadric = glu.gluNewQuadric();
		glu.gluQuadricDrawStyle(quadric, GLU.GLU_FILL);
		glu.gluQuadricTexture(quadric, true);
		gl.glColor3d(1,0,0);
		panelling = setupTexture(gl,"Jossickwallout-0.jpg");
		grass = setupTexture(gl,"Jossickgrass.jpg");
		tile = setupTexture(gl,"Jossicktile-14-0.jpg");
		roof = setupTexture(gl,"Jossickroof-0.jpg");
		window = setupTexture(gl,"Jossickwindow-0.jpg");
		inside = setupTexture(gl, "Jossickinside-0.jpg");
	}
	public void draw(GL2 gl, GLU glu) {
		JossickDoorWall wallfront = new JossickDoorWall(
							   new JossickWall(new Point3d(10,0,10), new Point3d(40,0,10), new Point3d(40,7,10), new Point3d(10,7,10)),
							   new JossickWall(new Point3d(10,7,10), new Point3d(70,7,10),new Point3d(70,40,10), new Point3d(10,40,10)),
							   new JossickWall(new Point3d(45,0,10), new Point3d(70,0,10),new Point3d(70,7,10), new Point3d(45,7,10)));
		JossickWall wallright= new JossickWall(new Point3d(70,0,10),new Point3d(70,40,10), new Point3d(70,40,70), new Point3d(70,0,70));
		JossickWall wallback = new JossickWall(new Point3d(10,0,70), new Point3d(10,40,70), new Point3d(70,40,70), new Point3d(70,0,70));
		JossickWall wallleft = new JossickWall(new Point3d(10,0,70),new Point3d(10,40,70),new Point3d(10,40,10),new Point3d(10,0,10));
		gl.glColor3d(0,1,1);
		
		JossickWall ground = new JossickWall(new Point3d(0,0,0),new Point3d(100,0,0),new Point3d(100,0,100),new Point3d(0,0,100));
		double [] textarray = {0,2,3};
		gl.glEnable(GL2.GL_TEXTURE_2D);
			grass.bind(gl);
				ground.drawTextured(gl, glu, textarray);
		gl.glDisable(GL2.GL_TEXTURE_2D);
		
		//floor
		JossickWall floor = new JossickWall(new Point3d(10,0.1,10),new Point3d(70,0.1,10),new Point3d(70,0.1,70),new Point3d(10,0.1,70));
		gl.glEnable(GL2.GL_TEXTURE_2D);
		double [] floortexarray = {0,20,20};
		tile.bind(gl);
			floor.drawTextured(gl, glu, floortexarray);
		gl.glDisable(GL2.GL_TEXTURE_2D);
	
		//roof
		gl.glEnable(GL2.GL_TEXTURE_2D);
		double [] rooftexarray = {0,20,20};
		roof.bind(gl);
		JossickWall rightroof = new JossickWall(new Point3d(10,40,10),new Point3d(10,40,70),new Point3d(40,65,70),new Point3d(40,65,10));
		rightroof.drawTextured(gl, glu,rooftexarray);
		JossickWall leftroof = new JossickWall(new Point3d(70,40,10),new Point3d(70,40,70),new Point3d(40,65,70),new Point3d(40,65,10));
			leftroof.drawTextured(gl, glu, rooftexarray);
		gl.glDisable(GL2.GL_TEXTURE_2D);
		
		// triangle
			gl.glEnable(GL2.GL_TEXTURE_2D);
				window.bind(gl);
				gl.glBegin(GL2.GL_TRIANGLES);
				gl.glTexCoord2d(0,2); 
				gl.glVertex3d(10.0,40.0,10.0);
				gl.glTexCoord2d(3,2);
				gl.glVertex3d(40,65,10);
				gl.glTexCoord2d(3,0); 
				gl.glVertex3d(70,40,10);
				gl.glEnd();
			gl.glDisable(GL2.GL_TEXTURE_2D);
			
		//other triangle
		gl.glEnable(GL2.GL_TEXTURE_2D);
			window.bind(gl);
			gl.glBegin(GL2.GL_TRIANGLES);
			gl.glTexCoord2d(0,2); 
			gl.glVertex3d(10.0,40.0,70.0);
			gl.glTexCoord2d(3,2);
			gl.glVertex3d(40,65,70);
			gl.glTexCoord2d(3,0); 
			gl.glVertex3d(70,40,70);
			gl.glEnd();
		gl.glDisable(GL2.GL_TEXTURE_2D);
		
		gl.glEnable(GL2.GL_CULL_FACE);
		gl.glEnable(GL2.GL_TEXTURE_2D);
			panelling.bind(gl);
			gl.glEnable(GL2.GL_TEXTURE_GEN_S);
			gl.glEnable(GL2.GL_TEXTURE_GEN_T);
				gl.glTexGeni(GL2.GL_S,GL2.GL_TEXTURE_GEN_MODE,GL2.GL_OBJECT_LINEAR);
				gl.glTexGeni(GL2.GL_T,GL2.GL_TEXTURE_GEN_MODE,GL2.GL_OBJECT_LINEAR);
					double[] coef_s = {0,.5,0,0};
					double[] coef_t = {.25,0,.25,0};
					gl.glTexGendv(GL2.GL_S, GL2.GL_OBJECT_PLANE, coef_s, 0);
					gl.glTexGendv(GL2.GL_T, GL2.GL_OBJECT_PLANE, coef_t, 0);
					wallfront.draw(gl, glu);
					wallright.drawr(gl, glu);
					wallback.draw(gl, glu);
					wallleft.drawr(gl, glu);
					
					inside.bind(gl);
					wallfront.drawr(gl, glu);
					wallright.draw(gl, glu);
					wallback.drawr(gl, glu);
					wallleft.draw(gl, glu);
			gl.glDisable(GL2.GL_CULL_FACE);
			gl.glDisable(GL2.GL_TEXTURE_2D);
			gl.glDisable(GL2.GL_TEXTURE_GEN_S);
			gl.glDisable(GL2.GL_TEXTURE_GEN_T);
			JossickChair c = new JossickChair(gl,glu);
			c.draw(gl, glu, 40,40);
			c.draw(gl, glu, 45,45);
			c.draw(gl, glu, 30,30);
			c.draw(gl, glu, 60,40);
			JossickTable t = new JossickTable(gl,glu);
			t.draw(gl, glu, 60, 60);
			t.draw(gl, glu, 30, 35);
	}
}
