package game;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.LinkedList;
import java.util.List;

public class PlayerMotion implements KeyListener, MouseMotionListener {
    private static final float step1 = .75f, step2 = step1 * 3f;
    private static List<PlayerMotionWatcher> watchers = new LinkedList<PlayerMotionWatcher>();
    private PlayerStats stats;
    private float eyeX, eyeY, eyeZ;
    private float dx, dz;
    private int width, height, xLoc, yLoc;
    private float theta, dtheta;
    private float gamma, dgamma;
    private float step = step1;
    private boolean mouseMovement = false,mobile=true;
    private boolean wdown, adown, sdown, ddown, qdown, edown, idown, kdown;
    private boolean ndown,cdown,fdown,gdown,udown,jdown;
    private boolean jumping, falling;
    private boolean crouch,standing;
    private boolean flying,walking;
    private Robot robot;
    private final double G = 32.1740;

    private int speedCounter = 0;
    private int flyCounter =0;
    private int speedDuration = 0;
    private int flyDuration = 0;
    private boolean fly = false;
    private int flyHeight = 0;


    public PlayerMotion() {
        eyeX = 1;
        eyeY = 5;
        eyeZ = 50;
        theta = 0;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            // TODO Auto-generated catch block
            e.printStackTrace()
            ;
        }
    }
    public void setStats(PlayerStats s){stats=s;}
    public PlayerStats getStats(){return stats;}
    
    public float getEyeX() {return eyeX;} 
    public float getEyeY() {return eyeY;}
    public float getEyeZ() {return eyeZ;}
    public void setDim(int width, int height) {
            this.width = width;
            this.height = height;
    }
    
    public void setEyeX(float x) {
            eyeX=x;
    }
    
    public void notifyObservers() {
    	   for (PlayerMotionWatcher wd : watchers)
              wd.playerMoved(eyeX, eyeY, eyeZ, theta, gamma,stats);

    	}
    
    public void setEyeY(float y) {
            eyeY=y;
    }
    
    public void setEyeZ(float z) {
            eyeZ=z;
    }
    public void setMobile(boolean b){
            mobile=b;
            if(b==false){
                    adown=false;ddown=false;sdown=false;wdown=false;
                    jdown=false;
            }
    }
    
    public static void registerPlayerWatcher(PlayerMotionWatcher watcher) {
        watchers.add(watcher);
    }

    @Override
    public void keyPressed(KeyEvent e) {

            if(mobile)
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
                    case KeyEvent.VK_I:
                        idown = true;
                        break;
                    case KeyEvent.VK_K:
                        kdown = true;
                        break;
                    case KeyEvent.VK_J:
                        jdown = true;
                        break;
                    case KeyEvent.VK_N:
                        ndown = true;
                        break;
                    case KeyEvent.VK_C:
                    	cdown = true;
                    	break;
                    case KeyEvent.VK_F:
                    	fdown = true;
                    	break;
                    case KeyEvent.VK_G:
                    	gdown = true;
                    	break;     
                    case KeyEvent.VK_U:
                    	udown = true;
                    	break; 
                    case KeyEvent.VK_SHIFT:
                        step = step2;
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
            case KeyEvent.VK_I:
                idown = false;
                break;
            case KeyEvent.VK_K:
                kdown = false;
                break;
            case KeyEvent.VK_N:
                ndown = false;
                break;
            case KeyEvent.VK_C:
            	cdown = false;
            	break;
            case KeyEvent.VK_F:
            	fdown = false;
            	break;
            case KeyEvent.VK_G:
            	gdown = false;
            	break;  
            case KeyEvent.VK_U:
            	udown = false;
            	break; 
            case KeyEvent.VK_J:
            	jdown = false;
            	break; 
            case KeyEvent.VK_SHIFT:
                step = step1;
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    public void setLookAt(GL2 gl, GLU glu){
        double moved = 0;
        double location[] = ReadZBuffer.getOGLPos(gl, glu, width / 2, height / 2); //what you're moving towards
        if (mobile&&eyeX + dx > 0 && eyeZ + dz > 0 && eyeX + dx < 600 && eyeZ + dz < 600 && (eyeX + dx < 300 || eyeZ + dz < 500)) {
            if (Math.abs(location[0] - eyeX) > Math.abs(dx) + 1) {
                eyeX += dx;
                moved += dx;
            }//if you have room to move in the x direction, move in the x direction

            if (Math.abs(location[2] - eyeZ) > Math.abs(dz) + 1) {
                eyeZ += dz;
                moved += dz;
            }//ditto z
        }

        gl.glLoadIdentity();
        glu.gluLookAt(eyeX, eyeY, eyeZ,   // eye location
                eyeX + Math.cos(Math.toRadians(theta)) * Math.cos(Math.toRadians(gamma)), eyeY + Math.sin(Math.toRadians(gamma)), eyeZ + -Math.sin(Math.toRadians(theta)) * Math.cos(Math.toRadians(gamma)),   // point to look at (near middle of pyramid)
                0, 1, 0); // the "up" direction
        if (mobile&&(moved != 0 || qdown || edown || idown || kdown || dgamma != 0 || dtheta != 0)) {
        	notifyObservers();
        }
	}
	

    public void update(GL2 gl, GLU glu) {

            speedCounter++;
            flyCounter++;
            
            if(fly == true){
                        if(eyeY < flyHeight)
                                eyeY = eyeY + 1;
                        else{
                                fly = false;
                                flyCounter = 0;
                        }
                }

                if(eyeY>5 && fly == false && !flying && !jumping && !falling && flyCounter>flyDuration){
                        eyeY = eyeY-1;
                }
                
                if(speedCounter  == speedDuration){
                        step = step1;
                }

            
        dx = 0;
        dz = 0;
        //look key pressed/released
        if (adown) {
            dx += Math.cos(Math.toRadians(theta + 90));
            dz += -Math.sin(Math.toRadians(theta + 90));
        }
        if (ddown) {
            dx += Math.cos(Math.toRadians(theta - 90));
            dz += -Math.sin(Math.toRadians(theta - 90));
        }
        if (sdown) {
            dx -= Math.cos(Math.toRadians(theta));
            dz -= -Math.sin(Math.toRadians(theta));
        }
        if (wdown) {
            dx += Math.cos(Math.toRadians(theta));
            dz += -Math.sin(Math.toRadians(theta));
        }
        if (qdown) {
            theta += 2;
        }
        if (edown) {
            theta -= 2;
        }
        if (idown) {
            gamma += 2;
        }
        if (kdown) {
            gamma -= 2;
        }
        
        //jump
        if (jdown) {
            jumping = true;
        }
        if (jumping) {
            eyeY += 0.7;
        }
        if (falling) {
            eyeY -= 0.7;
        }
        if (jumping && eyeY > 10) {
            jumping = false;
            falling = true;
        }
        if (falling && eyeY <= 5) {
            eyeY = 5;
            falling = false;
        }

        if (adown || ddown || sdown || wdown || qdown || edown || idown || kdown || jdown) {

			GameSounds.footstepNoise();

        //crouch
        if (cdown){
        	crouch = true;
        }
        if (crouch){
        	eyeY -= 0.8;
        }
        if (standing){
            eyeY += 0.8;
        }
        if (crouch && eyeY < 2.5){
        	crouch = false;
        	standing = true;
        }
        if (standing && eyeY >= 5){
        	eyeY = 5;
        	standing = false;
        }
        
        //flying & walking mode
        if (fdown){
        	flying = true;
        }
        if (gdown){
        	walking = true;
        	flying = false;
        }     
        if (flying){
        	walking = false;
        	if (eyeY <130) eyeY +=1;
            if (udown){eyeY +=3;}
            if (ndown&&eyeY>15){eyeY -=4;}
        }
        if(walking){
            eyeY -= 2;
        }
        if (walking && eyeY < 5){
        	eyeY = 5;
        	walking = false;
        }
        
        //etc
        if (adown || ddown || sdown || wdown || qdown || edown || idown || kdown || ndown || cdown || gdown || fdown || udown || jdown) {

            for (PlayerMotionWatcher watcher : watchers)
                watcher.playerMoved(eyeX, eyeY, eyeZ, theta, gamma,stats);

        }
        if (mouseMovement) {
            theta += dtheta;
            gamma += dgamma;
            if (gamma <= -90) {
                gamma = -89;
            }
            if (gamma >= 90) {
                gamma = 89;
            }
            robot.mouseMove(width / 2 + xLoc, height / 2 + yLoc);
        }

        dx *= step; //net x-motion
        dz *= step; //net z-motion
        if ((wdown || sdown) && (adown || ddown)) {
            dx /= Math.sqrt(2);
            dz /= Math.sqrt(2);
        }
        }
        gl.glLoadIdentity();
        
        glu.gluLookAt(eyeX, eyeY, eyeZ,   // eye location

                eyeX + dx, eyeY, eyeZ + dz,   // prospective new eye location

                 0, 1,  0); // the "up" direction
	}
    


    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if (mouseMovement) {
            dtheta = width / 2 - e.getX();
            dgamma = height / 2 - e.getY();
        }
    }

    public void setScreenLocation(Point locationOnScreen) {
        xLoc = locationOnScreen.x;
        yLoc = locationOnScreen.y;
    }

//
//	public float getStep() {
//		return step;
//	}
//	


    public void setStep(float step, int duration) {
		this.step = step;
		this.speedDuration = this.speedDuration + duration;
		speedCounter = 0;        

    }


        public void fly(int height, int duration){
                flyDuration = duration;
                flyHeight = height;
                fly = true;
        }

    


    public float getStep() {
        return step;
    }

   
     //   eyeZ = eyeZ + i;

        public void teleport(int i) {
        	dx += (Math.cos(Math.toRadians(theta))*i);
            dz += (-Math.sin(Math.toRadians(theta))*i);
            eyeX = eyeX + dx;        
            eyeZ = eyeZ + dz;

        }

    
}

