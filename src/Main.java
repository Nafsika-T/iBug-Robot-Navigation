
import java.io.IOException;
import javax.vecmath.*;
import simbad.gui.*;
import simbad.sim.*;

public class Main {

    public static void main(String[] args) throws IOException {
        EnvironmentDescription environment = new EnvironmentDescription();
        env(environment);
        MyRobot myRobot= new MyRobot(new Vector3d(5,0,-2),"Bugi");
        environment.add(myRobot);

        Simbad frame = new Simbad(environment, false);
    }


    static void env(EnvironmentDescription environment){
        environment.light1SetPosition(-5, 2, 0);
        environment.light1IsOn = true;
      //  environment.light2SetPosition(-5, 2, 0);
      //  environment.light2IsOn = false;

        environment.setWorldSize(10);
        environment.showAxis(true);

        Wall w1 = new Wall(new Vector3d(2.5, 0, 0), 5, 1, environment);
        w1.rotate90(1);
        environment.add(w1);
        Wall w2 = new Wall(new Vector3d(1.5, 0, 2.5), 2, 1, environment);
        environment.add(w2);
        Wall w3 = new Wall(new Vector3d(-2, 0, 1), 3, 1, environment);
        w3.rotate90(1);
        environment.add(w3);
        environment.add(new Box(new Vector3d(0,0,-3), new Vector3f(1,1,1),environment));

        environment.ambientLightColor = environment.white;
        environment.backgroundColor = environment.ligthgray;
        environment.archColor = environment.red;
        environment.boxColor = environment.darkgray;
        environment.wallColor = environment.blue;
        environment.floorColor = environment.white;
    }
}