
import  simbad.sim.*;
import javax.vecmath.Vector3d;

public class MyRobot extends Agent {
    RangeSensorBelt sonars;
    LightSensor center;
    LightSensor right;
    LightSensor left;
    iBug bug;

    public MyRobot (Vector3d position, String name)
    {
        super(position,name);
        sonars = RobotFactory.addSonarBeltSensor(this, 12);
        center=RobotFactory.addLightSensor(this);
        right=RobotFactory.addLightSensorRight(this);
        left=RobotFactory.addLightSensorLeft(this);
        bug = new iBug(this,sonars,center, right, left,false);
    }
    public void initBehavior() {}

    public void performBehavior(){
        bug.step();
    }
}
