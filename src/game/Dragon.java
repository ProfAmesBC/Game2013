package game;

public class Dragon {
	private SketchupModelJAXB[] frames = new SketchupModelJAXB[10];
	
	public Dragon(){
		new SketchupModelJAXB("DragonLegsUp.dae", gl, glu);
	}
}
