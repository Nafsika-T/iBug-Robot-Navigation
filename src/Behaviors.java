
import javax.vecmath.Point3d;
import javax.vecmath.Vector3d;
import simbad.sim.Agent;
import simbad.sim.LightSensor;
import simbad.sim.RangeSensorBelt;

public class Behaviors {
    static double K1 = 5;
    static double K2 = 0.8;
    static double K3 = 1;
    static double SAFETY = 0.8;
    private static double max;
    private static boolean alignment;
    private static double vel=1;

    public Behaviors() {
        alignment = false;
        max=0.0;
        vel=1.0;
    }

    public static void stop(Agent rob) {
        rob.setTranslationalVelocity(0);
        rob.setRotationalVelocity(0);
    }

    public static void AlignmentGoal(Agent rob, LightSensor center, LightSensor right, LightSensor left) {
        if (!alignment) {
            if (right.getAverageLuminance()-left.getAverageLuminance()>0.2)
                vel=-0.8;
            else if (left.getAverageLuminance()-right.getAverageLuminance()>0.2)
                vel=0.8;
            rob.setRotationalVelocity(vel);

            double diff = Math.abs(right.getAverageLuminance() - left.getAverageLuminance());

            double c = Math.pow(center.getLux(),0.1);

            if (diff < 0.15 && right.getAverageLuminance() > 0.4 && left.getAverageLuminance() > 0.4) {
                rob.setRotationalVelocity(0);
                alignment=true;
            }
            else if (c>0.74 && diff<0.1 )
            {
                alignment=true;
            }
        }
    }

    public static boolean isAlignment() {
        return alignment;
    }

    public static void falseAlignment()
    {
        alignment= false;
    }

    public static boolean moveToGoal(Agent rob, RangeSensorBelt sonars) {
        if (sonars.getFrontQuadrantMeasurement() > 0.7) {
            rob.setTranslationalVelocity(1);
            return false;
        }
        return true;
    }

    public static void circumNavigate(Agent rob, RangeSensorBelt sonars, boolean CLOCKWISE) {
        int min;
        min = 0;
        for (int i = 1; i < sonars.getNumSensors(); i++)
            if (sonars.getMeasurement(i) < sonars.getMeasurement(min))
                min = i;
        Point3d p = Tools.getSensedPoint(rob, sonars, min);
        double d = p.distance(new Point3d(0, 0, 0));
        Vector3d v;
        v = CLOCKWISE ? new Vector3d(-p.z, 0, p.x) : new Vector3d(p.z, 0, -p.x);
        double phLin = Math.atan2(v.z, v.x);
        double phRot = Math.atan(K3 * (d - SAFETY));
        if (CLOCKWISE)
            phRot = -phRot;
        double phRef = Tools.wrapToPi(phLin + phRot);

        rob.setRotationalVelocity(K1 * phRef);
        rob.setTranslationalVelocity(K2 * Math.cos(phRef));
    }

    public static boolean LocalMax(LightSensor center)
    {
        double k=0.02;
        double c = Math.pow(center.getLux(),0.1);
        if (c + k >= max)
        {
            max = c;
            return false;
        }
        return true;
    }

    public static void zeroMax() {
        max=0.0;
    }


    public static boolean Terminate(LightSensor center, LightSensor right, LightSensor left)
    {
        double l = Math.pow(left.getLux(),0.1);
        double r = Math.pow(right.getLux(),0.1);
        double c = Math.pow(center.getLux(),0.1);

        if (c>r && c>l && c>0.785)
            return true;
        return false;
    }

}
