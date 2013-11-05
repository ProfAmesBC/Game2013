package buildings;
// William Ames Fall 2013  Texture Demo

import game.Building;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;

import com.jogamp.opengl.util.texture.Texture;

class Roof {
    private Texture roofTexture;
    //private Texture brickTexture, signorileTexture;

    private Point3d botLeft, botRight, top;

    public Roof(GL2 gl, GLU glu,  Point3d bL, Point3d bR, Point3d t) {//TODO
        top=t;
        botLeft = bL;
        botRight = bR;
        
        roofTexture = Building.setupTexture(gl, "textureroof.gif");
    }

    public Point3d getTop() {return top;}
    public Point3d getBotLeft() {return botLeft;}
    public Point3d getBotRight() {return botRight;}
    
    public void draw(GL2 gl, GLU glu) {
       
    	gl.glEnable(GL2.GL_TEXTURE_2D);
    	roofTexture.bind(gl);
        gl.glEnable(GL2.GL_TEXTURE_GEN_S);
        gl.glEnable(GL2.GL_TEXTURE_GEN_T);
            gl.glTexGeni(GL2.GL_S, GL2.GL_TEXTURE_GEN_MODE, GL2.GL_OBJECT_LINEAR);
            gl.glTexGeni(GL2.GL_T, GL2.GL_TEXTURE_GEN_MODE, GL2.GL_OBJECT_LINEAR);
            float[] coef_s = {.5f,0,.5f,0};
            gl.glTexGenfv(GL2.GL_S, GL2.GL_OBJECT_PLANE, coef_s, 0);
            float[] coef_t = {0,.25f,0,0};
            gl.glTexGenfv(GL2.GL_T, GL2.GL_OBJECT_PLANE, coef_t, 0);
            gl.glBegin(GL2.GL_TRIANGLES);
                gl.glVertex3d( botLeft.getX(),  botLeft.getY(), botLeft.getZ());
                gl.glVertex3d( botRight.getX(),  botRight.getY(), botRight.getZ());
                gl.glVertex3d( top.getX(),  top.getY(), top.getZ());
            gl.glEnd();
        gl.glDisable(GL2.GL_TEXTURE_2D);
        gl.glDisable(GL2.GL_TEXTURE_GEN_S);
        gl.glDisable(GL2.GL_TEXTURE_GEN_T);
       
        
        
   }
}

	