package game;
// CS333 Fall 2013
// Initial version by Ames

import java.io.File;
import java.io.IOException;
import javax.media.opengl.*;
import javax.media.opengl.glu.GLU;
import com.jogamp.opengl.util.texture.*;

public abstract class Building
{
    private boolean first=true;
    private int displayList;
    public void drawWithDisplayList(GL2 gl, GLU glu) {
        if (first) {
            first = false;
            displayList = gl.glGenLists(1);
            gl.glNewList(displayList, GL2.GL_COMPILE_AND_EXECUTE);
                draw(gl, glu);
            gl.glEndList();
        } else {
            gl.glCallList(displayList);
        }
    }
    
    // draw the building and contents.  Called from the main class's display()
    abstract public void draw(GL2 gl, GLU glu);
    

    // Override if you have moving stuff in your room
    // Location of eye is available if needed
    public void drawMoving(GL2 gl, GLU glu, float eyeX, float eyeY, float eyeZ) {
        // some buildings might need this
    }

    private static boolean isPowerOf2(int n) {
        return n == (n & -n);
    }
    
    public static Texture setupTexture(GL2 gl, String filename, String path) {
        return setupTexture(gl, path + File.separator + filename);
    }

    // Read gif, jpg, png, or tiff file (or a few other less common ones)
    // *** MUST BE A POWER OF 2 IN EACH DIRECTION ***
    public static Texture setupTexture(GL2 gl, String filename) {
        Texture texture=null;
        try {
            System.out.println(new File(".").getAbsolutePath());
            texture = TextureIO.newTexture(new File("src" + File.separator + "textures" + File.separator + filename), true);
        } catch (IOException e) {
            System.out.println("Unable to read texture file: " + e);
            e.printStackTrace();
            System.exit(1);
        }
        // consider using ImageUtil.flipImageVertically(BufferedImage image)
        boolean flip = texture.getMustFlipVertically();
//      if (flip)
//          ImageUtil.flipImageVertically(texture);
        System.out.println("Flip: " + flip);
        texture.setTexParameteri(gl, GL2.GL_TEXTURE_MAG_FILTER,GL2.GL_LINEAR); // or GL_NEAREST
        texture.setTexParameteri(gl, GL2.GL_TEXTURE_MIN_FILTER,GL2.GL_LINEAR_MIPMAP_LINEAR); // or GL_NEAREST
        texture.setTexParameteri(gl, GL2.GL_TEXTURE_WRAP_S,GL2.GL_REPEAT); // or GL_CLAMP
        texture.setTexParameteri(gl, GL2.GL_TEXTURE_WRAP_T,GL2.GL_REPEAT); // or GL_CLAMP

        if (!isPowerOf2(texture.getImageWidth()) || !isPowerOf2(texture.getImageHeight())) {
            System.out.println(filename + " texture is not power of 2! Size is "
                               + texture.getImageWidth() + "x" + texture.getImageHeight());
            System.exit(1);
        } else {
            System.out.println(filename + " texture loaded, size is "
                               + texture.getImageWidth() + "x" + texture.getImageHeight());
        }
        return texture;
    }
}