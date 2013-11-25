package game;
import java.awt.*;
import javax.swing.*;
import javax.media.opengl.*;
import javax.media.opengl.awt.GLCanvas;
import javax.media.opengl.glu.*;

import com.jogamp.opengl.util.awt.TextRenderer;

public class StatusText {
	private GLAutoDrawable drawable;
	private TextRenderer renderer;
	
	public StatusText(GLAutoDrawable drawable){
		this.drawable = drawable;
		renderer = new TextRenderer(new Font("SansSerif", Font.BOLD, 32));
	}
	public void draw(String text, int x, int y) {		        
		System.out.println("check this out:" + drawable.getWidth() + drawable.getHeight());
		renderer.beginRendering(drawable.getWidth(), drawable.getHeight());
		// optionally set the text color
		renderer.setColor(1f, 1f, 1f, 0.8f); // Note use of alpha
		renderer.draw(text, x, y);  // pixels, from lower left
		renderer.endRendering();
	}

}