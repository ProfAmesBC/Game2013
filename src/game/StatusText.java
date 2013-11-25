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
		renderer = new TextRenderer(new Font("SansSerif", Font.BOLD, 48));
	}
	public void draw(String text) {		        
		System.out.println("check this out:" + drawable.getWidth() + drawable.getHeight());
		renderer.beginRendering(drawable.getWidth(), drawable.getHeight());
		// optionally set the text color
		renderer.setColor(0.2f, 0.2f, 1f, 0.2f); // Note use of alpha
		renderer.draw(text, 25, 250);  // pixels, from lower left
		renderer.endRendering();
	}

}