package game;

import java.awt.AWTException;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.LinkedList;
import java.util.List;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;

public class PlayerMotion implements KeyListener, MouseMotionListener {
    private float eyeX, eyeY, eyeZ;
    private float dx, dz;
    private int width, height, xLoc, yLoc;
	private float theta, dtheta;
	private float gamma, dgamma;
    private float step = .75f;
    private boolean mouseMovement = false;
    private boolean wdown, adown, sdown, ddown, qdown, edown;
    private static List<PlayerMotionWatcher> watchers = new LinkedList<PlayerMotionWatcher>();
    private Robot robot;
    
    public PlayerMotion() {
        eyeX = 1; eyeY = 5; eyeZ = 50;
        theta = 0;
        try {
			robot = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace()
			;
		}
    }
    
    public float getEyeX() {return eyeX;} 
    public float getEyeY() {return eyeY;}
    public float getEyeZ() {return eyeZ;}
    public void setDim(int width, int height) {
    	this.width = width;
    	this.height = height;
    }
    
    // are you trying to use an observer design pattern here?
    public static void registerPlayerWatcher(PlayerMotionWatcher watcher) {
    	watchers.add(watcher);
    }
    
    // please don't damage the function of this method as my weapons code is relying on it.
    // talk to me if you want to make changes -Fiona
    
    public void notifyObservers() {
    	   for (PlayerMotionWatcher wd : watchers)
    	      wd.playerMoved(eyeX, eyeY, eyeZ, theta);
    	}
    
	@Override
	public void keyPressed(KeyEvent e) {
	    switch (e.getKeyCode()) {
        case KeyEvent.VK_A:
            adown = true;
            break;
        case KeyEvent.VK_D:
            ddown = true;
            break;
        case KeyEvent.VK_S:
            sdown = true;
            break;
        case KeyEvent.VK_W:
            wdown = true;
            break;
        case KeyEvent.VK_Q:
            qdown = true;
            break;
        case KeyEvent.VK_E:
            edown = true;
            break;
        case KeyEvent.VK_SHIFT:
        	step *= 3;
        	break;
        case KeyEvent.VK_M:
        	mouseMovement = !mouseMovement;
        	break;
	    }
	}

	@Override
	public void keyReleased(KeyEvent e) { 
		switch (e.getKeyCode()) {
        case KeyEvent.VK_A:
            adown = false;
            break;
        case KeyEvent.VK_D:
            ddown = false;
            break;
        case KeyEvent.VK_S:
            sdown = false;
            break;
        case KeyEvent.VK_W:
            wdown = false;
            break;
        case KeyEvent.VK_Q:
            qdown = false;
            break;
        case KeyEvent.VK_E:
            edown = false;
            break;
        case KeyEvent.VK_SHIFT:
        	step /= 3;
        	break;
	    }
	}

	@Override
	public void keyTyped(KeyEvent e) { }

	public void setLookAt(GL2 gl, GLU glu) {
		double moved = 0;
        double location[] = ReadZBuffer.getOGLPos(gl, glu, width/2, height/2); //what you're moving towards
        if(eyeX+dx>0 && eyeZ+dz>0 && eyeX+dx<600 && eyeZ+dz<600 && (eyeX+dx<300 || eyeZ+dz<500)) {
        	if(Math.abs(location[0]-eyeX)>Math.abs(dx)+1) {
        		eyeX +=dx;
        		moved +=dx;
        	}//if you have room to move in the x direction, move in the x direction
		
        	if(Math.abs(location[2]-eyeZ)>Math.abs(dz)+1) {
        		eyeZ +=dz;
        		moved +=dz;
        	}//ditto z
        }
		
		gl.glLoadIdentity();
        glu.gluLookAt(eyeX, eyeY, eyeZ,   // eye location
                eyeX + Math.cos(Math.toRadians(theta))*Math.cos(Math.toRadians(gamma)), eyeY + Math.sin(Math.toRadians(gamma)), eyeZ + -Math.sin(Math.toRadians(theta))*Math.cos(Math.toRadians(gamma)),   // point to look at (near middle of pyramid)
                 0, 1, 0); // the "up" direction
        if(moved!=0 || qdown || edown || dgamma!=0 || dtheta!=0) {
        	for (PlayerMotionWatcher watcher: watchers)
    			watcher.playerMoved(eyeX, eyeY, eyeZ, theta);
        }
	}
	
	public void update(GL2 gl, GLU glu) {
		dx = 0;
		dz = 0;
		if(adown) {
			dx += Math.cos(Math.toRadians(theta + 90));
        	dz += -Math.sin(Math.toRadians(theta + 90));
		}
    	if(ddown) {
    		dx += Math.cos(Math.toRadians(theta - 90));
    		dz += -Math.sin(Math.toRadians(theta - 90));
    	}
    	if(sdown) {
    		dx -= Math.cos(Math.toRadians(theta));
        	dz -= -Math.sin(Math.toRadians(theta));
    	}
    	if(wdown) {
    		dx += Math.cos(Math.toRadians(theta));
    		dz += -Math.sin(Math.toRadians(theta));
    	}
    	if(qdown) {
    		theta += 2;
    	}
    	if(edown) {
    		theta -= 2;
    	}
    	if(mouseMovement) {
    		theta += dtheta;
    		gamma += dgamma;
    		if(gamma<=-90) {gamma = -89;}
    		if(gamma>=90) {gamma = 89;}
    		robot.mouseMove(width/2+xLoc, height/2+yLoc);
    	} else {
    		gamma = 0;
    	}
    	
    	
    	dx *= step; //net x-motion
    	dz *= step; //net z-motion
    	if((wdown || sdown) && (adown || ddown)) {
    		dx /= Math.sqrt(2);
    		dz /= Math.sqrt(2);
    	}
    	
    	gl.glLoadIdentity();
    	glu.gluLookAt(eyeX, eyeY, eyeZ,   // eye location
                eyeX + dx, eyeY, eyeZ + dz,   // prospective new eye location
                 0, 1,  0); // the "up" direction
	}

	@Override
	public void mouseDragged(MouseEvent e) {}

	@Override
	public void mouseMoved(MouseEvent e) {
		if(mouseMovement) {
			dtheta = width/2 - e.getX();
			dgamma = height/2 - e.getY();
		}
	}

	public void setScreenLocation(Point locationOnScreen) {
		xLoc = locationOnScreen.x;
		yLoc = locationOnScreen.y;	
	}
}