package catsrabbits;
import java.util.*;import javax.media.opengl.GL2;import javax.media.opengl.glu.GLU;

public class RabbitGroup implements CritterGroup{
	private List<Rabbit>rabbits=new ArrayList<Rabbit>();
	
	public RabbitGroup(GL2 gl,GLU glu){
		// format: init x, init y, init z, init angle, speed, tRate, gl, glu
		rabbits.add(new Rabbit(504.02f,6.05f,118.78f,128.43f,.25f,.04f,gl,glu));
		rabbits.add(new Rabbit(288.19f,5.27f,325.67f,44.16f,.15f,.02f,gl,glu));
		rabbits.add(new Rabbit(36.56f,3.93f,61.42f,271.88f,.2f,.025f,gl,glu));
		rabbits.add(new Rabbit(471.02f,4.12f,404.13f,302.86f,.15f,.02f,gl,glu));
		rabbits.add(new Rabbit(321.76f,5.62f,247.6f,101.78f,.25f,.04f,gl,glu));
		rabbits.add(new Rabbit(189.5f,5.62f,584.72f,197.34f,.2f,.025f,gl,glu));
	}
	
	public void draw(GL2 gl,GLU glu){
		for(Rabbit rabbit:rabbits)
			rabbit.draw(gl, glu);
	}
}
