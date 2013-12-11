package catsrabbits;
import java.util.*;import javax.media.opengl.GL2;import javax.media.opengl.glu.GLU;

public class CatGroup implements CritterGroup{
	private List<Cat>cats=new ArrayList<Cat>();
	
	public CatGroup(GL2 gl,GLU glu){
		// format: init x, init y, init z, init angle, speed, tRate, gl, glu
		cats.add(new Cat(213.25f,3.49f,492.73f,23.62f,.25f,.04f,gl,glu));
		cats.add(new Cat(117.39f,2.88f,549.33f,114.69f,.15f,.02f,gl,glu));
		cats.add(new Cat(35.14f,4.71f,287.56f,234.01f,.2f,.025f,gl,glu));
		cats.add(new Cat(458.2f,4.05f,112.93f,81.09f,.2f,.025f,gl,glu));
		cats.add(new Cat(306.18f,3.04f,6.85f,349.4f,.25f,.04f,gl,glu));
		cats.add(new Cat(544.86f,5.13f,460.12f,181.27f,.15f,.02f,gl,glu));
	}
	
	public void draw(GL2 gl,GLU glu){
		for(Cat cat:cats)
			cat.draw(gl, glu);
	}
}
