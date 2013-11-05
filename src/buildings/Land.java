package buildings;
// William Ames Fall 2013  Texture Demo

import java.io.File;
import java.io.IOException;
import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;
import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.TextureIO;

class Land {
    private GLUquadric quadric; // to control properties of quadric-based objects
    private GLUquadric sphereQuadric; // for Signorile's head
    private Texture landTexture;


    
    private static boolean isPowerOf2(int n) {
        return n == (n & -n);
    }

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

    public Land(GL2 gl, GLU glu) {
        quadric = glu.gluNewQuadric();
        glu.gluQuadricDrawStyle(quadric, GLU.GLU_FILL); // GLU_POINT, GLU_LINE, GLU_FILL, GLU_SILHOUETTE
        glu.gluQuadricNormals  (quadric, GLU.GLU_NONE); // GLU_NONE, GLU_FLAT, or GLU_SMOOTH
        glu.gluQuadricTexture  (quadric, true);        // use true to generate texture coordinates

        sphereQuadric = glu.gluNewQuadric();
        glu.gluQuadricDrawStyle(sphereQuadric, GLU.GLU_FILL);
        glu.gluQuadricNormals  (sphereQuadric, GLU.GLU_NONE);
        glu.gluQuadricTexture  (sphereQuadric, true); // for Signorile's head

        landTexture = setupTexture(gl, "textureland.gif"); // png's don't seem to work any more


    }

    public void draw(GL2 gl, GLU glu) {

        // dirt land plot
        gl.glEnable(GL2.GL_TEXTURE_2D);
            landTexture.bind(gl);
            gl.glBegin(GL2.GL_QUADS);
            gl.glColor3d(0, 1, 0);
                gl.glTexCoord2f(0f,2f); 
                gl.glVertex3d(0,  0, 0);
                gl.glTexCoord2f(3f,2f); 
                gl.glVertex3d( 100,  0, 0);
                gl.glTexCoord2f(3f,0f); 
                gl.glVertex3d( 100, 0, -100);
                gl.glTexCoord2f(0f,0f); 
                gl.glVertex3d(0, 0, -100);
            gl.glEnd();
        gl.glDisable(GL2.GL_TEXTURE_2D);
 
   }
}
