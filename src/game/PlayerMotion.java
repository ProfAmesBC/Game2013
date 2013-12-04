package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import java.util.List;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;

public class PlayerMotion implements KeyListener {
    private float eyeX, eyeY, eyeZ;
    private float dx, dz;
	private float theta;
    private float step = .75f;
    private boolean wdown, adown, sdown, ddown, qdown, edown;
    private static List<PlayerMotionWatcher> watchers = new LinkedList<PlayerMotionWatcher>();
    
    public PlayerMotion() {
        eyeX = -5; eyeY = 5; eyeZ = 50;
        theta = 0;
    }
    
    public float getEyeX() {return eyeX;} 
    public float getEyeY() {return eyeY;}
    public float getEyeZ() {return eyeZ;}
    
    public static void registerPlayerWatcher(PlayerMotionWatcher watcher) {
    	watchers.add(watcher);
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
	    }
	}

	@Override
	public void keyTyped(KeyEvent e) { /* not needed */ }

	public void setLookAt(GL2 gl, GLU glu) {
       
        double location[] = ReadZBuffer.getOGLPos(gl, glu, 250, 250); //what you're moving towards
		if(location[0]-eyeX>(dx + step) || (location[0]-eyeX)<(dx - step)) {eyeX +=dx;}//if you have room to move in the x direction, move in the x direction
		if(location[2]-eyeZ>(dz + step) || (location[2]-eyeZ)<(dz - step)) {eyeZ +=dz;}//ditto z
		gl.glLoadIdentity();
        glu.gluLookAt(eyeX, eyeY, eyeZ,   // eye location
                eyeX + Math.cos(Math.toRadians(theta)), eyeY, eyeZ + -Math.sin(Math.toRadians(theta)),   // point to look at (near middle of pyramid)
                 0, 1,  0); // the "up" direction
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
    	
    	dx *= step; //net x-motion
    	dz *= step; //net z-motion
    	
    	gl.glLoadIdentity();
    	glu.gluLookAt(eyeX, eyeY, eyeZ,   // eye location
                eyeX + dx, eyeY, eyeZ + dz,   // prospective new eye location
                 0, 1,  0); // the "up" direction
    	    	
    	if(adown || ddown || sdown || wdown || qdown || edown) {
    		for (PlayerMotionWatcher watcher: watchers)
    			watcher.playerMoved(eyeX, eyeY, eyeZ, theta);
    	}
	}
}