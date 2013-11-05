package buildings;
// William Ames Fall 2013  Texture Demo

import java.io.File;
import java.io.IOException;
import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;
import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.TextureIO;

class DoubleSidedWall {
    private Texture side1, side2;
    //private Texture brickTexture, signorileTexture;

    private Point3d botLeft, botRight, topLeft, topRight;
    private float[] coef_s, coef_t;
    
    private static boolean isPowerOf2(int n) { return n == (n & -n); }

    // Read gif, jpg, png, or tiff file (or a few other less common ones)
    // *** MUST BE A POWER OF 2 IN EACH DIRECTION ***
    public static Texture setupTexture(GL2 gl, String filename) {
        Texture texture=null;
        try {
            texture = TextureIO.newTexture(new File(filename), false);
        } catch (IOException e) {
            System.out.println("Unable to read texture file: " + e);
            e.printStackTrace();
            System.exit(1);
        }
        // consider using ImageUtil.flipImageVertically(BufferedImage image)
        boolean flip = texture.getMustFlipVertically();
//        if (flip)
//            ImageUtil.flipImageVertically(texture);
        System.out.println("Flip: " + flip);
        texture.setTexParameteri(gl, GL2.GL_TEXTURE_MAG_FILTER,GL2.GL_LINEAR); // or GL_NEAREST
        texture.setTexParameteri(gl, GL2.GL_TEXTURE_MIN_FILTER,GL2.GL_LINEAR); // or GL_NEAREST
        texture.setTexParameteri(gl, GL2.GL_TEXTURE_WRAP_S,GL2.GL_REPEAT); // or GL_CLAMP
        texture.setTexParameteri(gl, GL2.GL_TEXTURE_WRAP_T,GL2.GL_REPEAT); // or GL_CLAMP

        if (!isPowerOf2(texture.getImageWidth()) || !isPowerOf2(texture.getImageHeight())) {
            System.out.println(filename + " texture is not power of 2! Size is "
                               + texture.getImageWidth() + "x" + texture.getImageHeight());
            System.exit(1);
        } else {
            System.out.println(filename + " texture loaded, size is "
                               + texture.getImageWidth() + "," + texture.getImageHeight());
        }
        return texture;
    }

    public DoubleSidedWall(GL2 gl, GLU glu,  Point3d bL, Point3d bR, Point3d tR, Point3d tL, Texture t1, Texture t2, float[] s, float[] t) {//TODO
        topLeft = tL;
        topRight = tR;
        botLeft = bL;
        botRight = bR;
        
        side1 = t1;
        side2 = t2;
        
        coef_s = s;
        coef_t = t;
        
        //signorileTexture = setupTexture(gl, "texturefloor.gif");
        //brickTexture     = setupTexture(gl, "texturegranite.gif"); // if this causes trouble, try bricks.gif
    }

    public Point3d getTopLeft() {return topLeft;}
    public Point3d getTopRight() {return topRight;}
    public Point3d getBotLeft() {return botLeft;}
    public Point3d getBotRight() {return botRight;}
    
    public void draw(GL2 gl, GLU glu) {
       
    	gl.glEnable(GL2.GL_CULL_FACE);
            gl.glPushMatrix();
                gl.glEnable(GL2.GL_TEXTURE_2D);
                    //interior
                	side1.bind(gl);
                    gl.glEnable(GL2.GL_TEXTURE_GEN_S);
                    gl.glEnable(GL2.GL_TEXTURE_GEN_T);
                        gl.glTexGeni(GL2.GL_S, GL2.GL_TEXTURE_GEN_MODE, GL2.GL_OBJECT_LINEAR);
                        gl.glTexGeni(GL2.GL_T, GL2.GL_TEXTURE_GEN_MODE, GL2.GL_OBJECT_LINEAR);
                        //float[] coef_s = {.3f,0,.3f,0};
                        gl.glTexGenfv(GL2.GL_S, GL2.GL_OBJECT_PLANE, coef_s, 0);
                        //float[] coef_t = {0,.3f,0,0};
                        gl.glTexGenfv(GL2.GL_T, GL2.GL_OBJECT_PLANE, coef_t, 0);
                    gl.glBegin(GL2.GL_QUADS);
                        // ccw as viewed from front
                        //gl.glTexCoord2f(0f,2f); 
                        gl.glVertex3d(botLeft.getX(),  botLeft.getY(), botLeft.getZ());
                        //gl.glTexCoord2f(3f,2f); 
                        gl.glVertex3d(botRight.getX(),  botRight.getY(), botRight.getZ());
                        //gl.glTexCoord2f(3f,0f); 
                        gl.glVertex3d(topRight.getX(),  topRight.getY(), topRight.getZ());
                        //gl.glTexCoord2f(0f,0f); 
                        gl.glVertex3d(topLeft.getX(),  topLeft.getY(), topLeft.getZ());
                    gl.glEnd();
                    side2.bind(gl);
                    gl.glBegin(GL2.GL_QUADS);
                        // cw as viewed from front, so can be seen as ccw from back
                        //gl.glTexCoord2f(0f,0f); 
                    gl.glVertex3d(botLeft.getX(),  botLeft.getY(), botLeft.getZ());
                        //gl.glTexCoord2f(0f,1f); 
                    gl.glVertex3d(topLeft.getX(),  topLeft.getY(), topLeft.getZ());
                        //gl.glTexCoord2f(1f,1f); 
                    gl.glVertex3d(topRight.getX(),  topRight.getY(), topRight.getZ());
                        //gl.glTexCoord2f(1f,0f); 
                    gl.glVertex3d(botRight.getX(),  botRight.getY(), botRight.getZ());
                    gl.glEnd();
                    gl.glDisable(GL2.GL_TEXTURE_2D);
                    gl.glDisable(GL2.GL_TEXTURE_GEN_S);
                    gl.glDisable(GL2.GL_TEXTURE_GEN_T);
                gl.glDisable(GL2.GL_TEXTURE_2D);
            gl.glPopMatrix();
        gl.glDisable(GL2.GL_CULL_FACE);
        
        /* Automatic Texture Generation example, from Lamp class
         *         gl.glEnable(GL2.GL_TEXTURE_2D);
        brickTexture.bind(gl);
        gl.glEnable(GL2.GL_TEXTURE_GEN_S);
        gl.glEnable(GL2.GL_TEXTURE_GEN_T);
            gl.glTexGeni(GL2.GL_S, GL2.GL_TEXTURE_GEN_MODE, GL2.GL_OBJECT_LINEAR);
            gl.glTexGeni(GL2.GL_T, GL2.GL_TEXTURE_GEN_MODE, GL2.GL_OBJECT_LINEAR);
            float[] coef_s = {.5f,0,0,0};
            gl.glTexGenfv(GL2.GL_S, GL2.GL_OBJECT_PLANE, coef_s, 0);
            float[] coef_t = {0,.25f,0,0};
            gl.glTexGenfv(GL2.GL_T, GL2.GL_OBJECT_PLANE, coef_t, 0);
            gl.glBegin(GL2.GL_QUADS);
                gl.glVertex3f( 6,  0, -8);
                gl.glVertex3f(10,  0, -5);
                gl.glVertex3f(10, 10, -5);
                gl.glVertex3f( 6, 10, -8);
            gl.glEnd();
        gl.glDisable(GL2.GL_TEXTURE_2D);
        gl.glDisable(GL2.GL_TEXTURE_GEN_S);
        gl.glDisable(GL2.GL_TEXTURE_GEN_T);
         */
   }
}

	