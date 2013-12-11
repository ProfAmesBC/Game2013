package game;

import java.text.DecimalFormat;

// For demonstration only, should not go in the final game

public class PlayerLogger implements PlayerMotionWatcher {
    private DecimalFormat formatter = new DecimalFormat("#,##0.0");
    private static final char degreeSymbol = '\u00B0';
	
	public PlayerLogger() {
		PlayerMotion.registerPlayerWatcher(this);
	}

	@Override
	public void playerMoved(float x, float y, float z, float angle, float y_angle,PlayerStats s) {
	    angle %= 360; // normalize to 0..359 degrees, for a human to read
        y_angle %= 360;
	    if (angle<0)
	        angle += 360;
        if (y_angle < 0) y_angle += 360;
	//	System.out.println("Player is now at location (" + formatter.format(x) + "," +
	  //                     formatter.format(y) + "," + formatter.format(z) + "), angle is " +
		//                   formatter.format(angle) + degreeSymbol + " y_angle is " +
          //      formatter.format(y_angle) + degreeSymbol);
	}
}