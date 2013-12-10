package game;

import java.util.LinkedList;
import java.util.List;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.*;

import creatures.Robot;
import creatures.Creature;
import sketchupModels.Avatar;
import buildings.*;

public class Town {
    private List<Building> buildings = new LinkedList<Building>();
    
    public Town(GL2 gl, GLU glu) { 
        buildings.add(new WillisBuilding(gl, glu));
        buildings.add(new VallejoBuilding(gl, glu));
        buildings.add(new LiptonBuilding(gl, glu));
        buildings.add(new JossickBuilding(gl, glu));
        buildings.add(new ShippBuilding(gl, glu));
        buildings.add(new TranBuilding(gl, glu));
        buildings.add(new YangBuilding(gl, glu));
    	buildings.add(new AndersonBuilding(gl, glu));
    	buildings.add(new BaconBuilding(gl, glu));
    	buildings.add(new ChenBuilding(gl, glu));
    	buildings.add(new CheungBuilding(gl, glu));
    	buildings.add(new DiegoMBuilding(gl, glu));
    	buildings.add(new DintinoHouse(gl, glu));
    	buildings.add(new DNDBuilding(gl, glu));
    	buildings.add(new FMPBuilding(gl, glu));
    	buildings.add(new GoodeBuilding(gl, glu));
    	buildings.add(new KahaleBuilding(gl, glu));
    	buildings.add(new LaracuenteBuilding(gl, glu));
    	buildings.add(new LeiBuilding(gl, glu));
    	buildings.add(new LiangBuilding(gl, glu));
    	buildings.add(new LinnehanBuilding(gl, glu));
    	buildings.add(new LundbergBuilding(gl, glu));
    	buildings.add(new MatherBuilding(gl, glu));
    	buildings.add(new MendolaBuilding(gl, glu));
    	buildings.add(new MeuseBuilding(gl, glu));
    	buildings.add(new MidgleyBuilding(gl, glu));
    	buildings.add(new OConnorBuilding(gl,glu));
    	buildings.add(new ParkBuilding(gl, glu));
    	buildings.add(new RothBuilding(gl, glu));
    	buildings.add(new TamburiniBuilding(gl, glu));
    	buildings.add(new VentarolaBuilding(gl, glu));
    	buildings.add(new XiangBuilding(gl, glu));
    	buildings.add(new ZhangBuilding(gl, glu));
    }
    
    public void draw(GL2 gl, GLU glu, float eyeX, float eyeY, float eyeZ) {
        int error = gl.glGetError();
        if (error != GL2.GL_NO_ERROR) {
            System.out.println("OpenGL Error, probably not in any building.");
            System.out.println(glu.gluErrorString(error));
            System.exit(1);
        }
        int buildingCounter = 0;
        int buildingsPerRow = 6;
        for (Building building: buildings) {	
            //System.out.println("Drawing building " + building.getClass().getSimpleName());
            gl.glPushMatrix();
            int dx = 100*(buildingCounter%buildingsPerRow);
            int dz = 100*(buildingCounter/buildingsPerRow);
            gl.glTranslatef(dx, 0, dz);
            //building.draw(gl,  glu); // without using display lists
            building.drawWithDisplayList(gl, glu); // with display lists
            building.drawMoving(gl,  glu, eyeX-dx, eyeY, eyeZ-dz);
            gl.glPopMatrix();
            buildingCounter++;
            
            error = gl.glGetError();
            if (error != GL2.GL_NO_ERROR) {
                System.out.println("OpenGL Error, probably in building: " + building.getClass().getSimpleName());
                System.out.println(glu.gluErrorString(error));
                System.exit(1);
            }
        }  
    }
}
