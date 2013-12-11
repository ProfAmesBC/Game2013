package Enemies;

//import java.awt.List;
import java.util.*;
import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;

public class MoveSwarm {
	private List<BasicBat> swarm;
	private List<BasicBat> swarm2;

	public MoveSwarm(GL2 gl, GLU glu) {
		swarm = new ArrayList<BasicBat>();
		swarm2 = new ArrayList<BasicBat>();
		
		for (int i = 0; i < 25; i++) {
			int j = (int) (Math.random()*20) - 10;
			int k = (int) (Math.random()*20) - 10;
			swarm.add(new BasicBat(gl, glu, 70+j, 50+k));
		}
		
		for (int i = 0; i < 25; i++) {
			int j = (int) (Math.random()*20) - 10;
			int k = (int) (Math.random()*20) - 10;
			swarm.add(new BasicBat(gl, glu, 200+j, 200+k));
		}
	}

	public MoveSwarm(List<BasicBat> swarm){
		this.swarm = swarm;
	}

	public void draw(GL2 gl, GLU glu) {
		
		for (BasicBat b: swarm) {
			b.draw2(gl, glu);
			if (b.isDead())
				swarm.remove(b);
			else {
				b.setX(b.getX()+b.getDX());
				b.setZ(b.getZ()+b.getDZ());
			}
		}
		
		for (BasicBat b: swarm2) {
			b.draw2(gl, glu);
			if (b.isDead())
				swarm2.remove(b);
			else {
				b.setX(b.getX()+b.getDX());
				b.setZ(b.getZ()+b.getDZ());
			}
		}
				
		for (BasicBat b: swarm) {
			for (BasicBat t: swarm) {
				if(b != t) {
					//calc distances
					float xdist = t.getX()-b.getX();
					float zdist = t.getZ()-b.getZ();

					//calc force
					float distancesq = (xdist*xdist + zdist*zdist);
					if (distancesq < 0.1f)
						distancesq = 0.1f;
					float force = .01f/distancesq;

					//update velocity vectors
					b.setDX(b.getDX()+(force*xdist));
					b.setDZ(b.getDZ()+(force*zdist));
					float hypotenuse = (float) Math.sqrt((float) (b.getDX()*b.getDX() + b.getDZ()*b.getDZ()));
					if (b.getDZ() == 0 && b.getDX() == 0) 
						b.setDirection(0);
					else	
						b.setDirection((float) Math.toDegrees(Math.atan2(-b.getDZ(), b.getDX())));
				}				
			}
		}
		for (BasicBat m: swarm2) {
			for (BasicBat n: swarm2) {
				if(m != n) {
					//calc distances
					float xdist = n.getX()-m.getX();
					float zdist = n.getZ()-m.getZ();

					//calc force
					float distancesq = (xdist*xdist + zdist*zdist);
					if (distancesq < 0.1f)
						distancesq = 0.1f;
					float force = .01f/distancesq;

					//update velocity vectors
					m.setDX(m.getDX()+(force*xdist));
					m.setDZ(m.getDZ()+(force*zdist));
					float hypotenuse = (float) Math.sqrt((float) (m.getDX()*m.getDX() + m.getDZ()*m.getDZ()));
					if (m.getDZ() == 0 && m.getDX() == 0) 
						m.setDirection(0);
					else	
						m.setDirection((float) Math.toDegrees(Math.atan2(-m.getDZ(), m.getDX())));
				}				
			}
		}
	}
}
