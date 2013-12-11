package buildings;
import game.Building;

import com.jogamp.opengl.util.texture.Texture;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;

public class ChenBuilding extends Building {
    private Texture wall;
    private Texture apple;
    private GLUquadric quadric;

    public ChenBuilding(GL2 gl,  GLU glu) {
        //this.wall = setupTexture(gl, "brick.png");
        this.wall = setupTexture(gl, "ChenWall.jpg");
        this.apple = setupTexture(gl, "ChenApple.png");
        this.quadric = glu.gluNewQuadric();
    }

    @Override
    public void draw(GL2 gl, GLU glu) {
      gl.glPushMatrix();
      gl.glTranslatef(50,0,50);
        gl.glEnable(GL2.GL_TEXTURE_2D);
        wall.bind(gl);
        gl.glDepthMask(false);
        gl.glEnable(GL2.GL_BLEND);
        gl.glBlendFunc(GL2.GL_SRC_ALPHA, GL2.GL_ONE_MINUS_SRC_ALPHA);
        gl.glColor4d(1,1,1,0.7);
        gl.glBegin(GL2.GL_QUADS);
            gl.glTexCoord2d(0, 0); gl.glVertex3d(-50, 0, 50);
            gl.glTexCoord2d(25, 0); gl.glVertex3d(50, 0, 50);
            gl.glTexCoord2d(25, 25); gl.glVertex3d(50, 0, -50);
            gl.glTexCoord2d(0, 25); gl.glVertex3d(-50, 0, -50);

            gl.glTexCoord2d(0, 3); gl.glVertex3d(-45, 90, 45);
            gl.glTexCoord2d(6, 3); gl.glVertex3d(-45, 90, -45);
            gl.glTexCoord2d(6, 0); gl.glVertex3d(-45, 0, -45);
            gl.glTexCoord2d(0, 0); gl.glVertex3d(-45, 0, 45);

            gl.glTexCoord2d(0, 3); gl.glVertex3d(45, 90, -45);
            gl.glTexCoord2d(6, 3); gl.glVertex3d(45, 90, 45);
            gl.glTexCoord2d(6, 0); gl.glVertex3d(45, 0, 45);
            gl.glTexCoord2d(0, 0); gl.glVertex3d(45, 0, -45);

            gl.glTexCoord2d(0, 3); gl.glVertex3d(-45, 90, -45);
            gl.glTexCoord2d(2, 3); gl.glVertex3d(-15, 90, -45);
            gl.glTexCoord2d(2, 0); gl.glVertex3d(-15, 0, -45);
            gl.glTexCoord2d(0, 0); gl.glVertex3d(-45, 0, -45);

            gl.glTexCoord2d(0, 3); gl.glVertex3d(15, 90, -45);
            gl.glTexCoord2d(2, 3); gl.glVertex3d(45, 90, -45);
            gl.glTexCoord2d(2, 0); gl.glVertex3d(45, 0, -45);
            gl.glTexCoord2d(0, 0); gl.glVertex3d(15, 0, -45);

            gl.glTexCoord2d(0, 2); gl.glVertex3d(-15, 90, -45);
            gl.glTexCoord2d(2, 2); gl.glVertex3d(15, 90, -45);
            gl.glTexCoord2d(2, 0); gl.glVertex3d(15, 30, -45);
            gl.glTexCoord2d(0, 0); gl.glVertex3d(-15, 30, -45);

            gl.glTexCoord2d(0, 3); gl.glVertex3d(-45, 90, 45);
            gl.glTexCoord2d(2, 3); gl.glVertex3d(-15, 90, 45);
            gl.glTexCoord2d(2, 0); gl.glVertex3d(-15, 0, 45);
            gl.glTexCoord2d(0, 0); gl.glVertex3d(-45, 0, 45);

            gl.glTexCoord2d(0, 3); gl.glVertex3d(15, 90, 45);
            gl.glTexCoord2d(2, 3); gl.glVertex3d(45, 90, 45);
            gl.glTexCoord2d(2, 0); gl.glVertex3d(45, 0, 45);
            gl.glTexCoord2d(0, 0); gl.glVertex3d(15, 0, 45);

            gl.glTexCoord2d(0, 2); gl.glVertex3d(-15, 90, 45);
            gl.glTexCoord2d(2, 2); gl.glVertex3d(15, 90, 45);
            gl.glTexCoord2d(2, 0); gl.glVertex3d(15, 30, 45);
            gl.glTexCoord2d(0, 0); gl.glVertex3d(-15, 30, 45);

            gl.glTexCoord2d(0, 3); gl.glVertex3d(-45, 90, 45);
            gl.glTexCoord2d(6, 3); gl.glVertex3d(45, 90, 45);
            gl.glTexCoord2d(6, 0); gl.glVertex3d(45, 90, -45);
            gl.glTexCoord2d(0, 0); gl.glVertex3d(-45, 90, -45);

        gl.glEnd();
        gl.glDisable(GL2.GL_BLEND);
        gl.glDepthMask(true);
        gl.glDisable(GL2.GL_TEXTURE_2D);

        gl.glEnable(GL2.GL_TEXTURE_2D);
        apple.bind(gl);
        gl.glDepthMask(false);
        gl.glEnable(GL2.GL_BLEND);
        gl.glBlendFunc(GL2.GL_SRC_ALPHA, GL2.GL_ONE_MINUS_SRC_ALPHA);
        gl.glBegin(GL2.GL_QUADS);
            gl.glTexCoord2d(0, 1); gl.glVertex3d(-10, 70, 0);
            gl.glTexCoord2d(1, 1); gl.glVertex3d(10, 70, 0);
            gl.glTexCoord2d(1, 0); gl.glVertex3d(10, 50, 0);
            gl.glTexCoord2d(0, 0); gl.glVertex3d(-10, 50, 0);
        gl.glEnd();
        gl.glDisable(GL2.GL_BLEND);
        gl.glDepthMask(true);
        gl.glDisable(GL2.GL_TEXTURE_2D);

        gl.glEnable(GL2.GL_TEXTURE_2D);
        gl.glEnable(GL2.GL_TEXTURE_GEN_S);
        gl.glEnable(GL2.GL_TEXTURE_GEN_T);
        wall.bind(gl);
        gl.glTexGeni(GL2.GL_S, GL2.GL_TEXTURE_GEN_MODE, GL2.GL_OBJECT_LINEAR);
        gl.glTexGeni(GL2.GL_T, GL2.GL_TEXTURE_GEN_MODE, GL2.GL_OBJECT_LINEAR);
        float[] s ={.1f, 0, 0, 0};
        gl.glTexGenfv(GL2.GL_S, GL2.GL_OBJECT_PLANE, s, 0);
        float[] t ={0, .1f, 0, 0};
        gl.glTexGenfv(GL2.GL_T, GL2.GL_OBJECT_PLANE, t, 0);
        gl.glPushMatrix();
        gl.glRotated(-90, 1, 0, 0);
        gl.glEnable(GL2.GL_BLEND);
        gl.glBlendFunc(GL2.GL_SRC_ALPHA, GL2.GL_ONE_MINUS_SRC_ALPHA);
        gl.glColor4d(.9,1,1,.8);
        glu.gluCylinder(quadric, 18, 18, 20, 30, 30);
        gl.glDisable(GL2.GL_BLEND);
        gl.glPopMatrix();
        gl.glDisable(GL2.GL_TEXTURE_GEN_S);
        gl.glDisable(GL2.GL_TEXTURE_GEN_T);
        gl.glDisable(GL2.GL_TEXTURE_2D);
      gl.glPopMatrix();
    }
}
