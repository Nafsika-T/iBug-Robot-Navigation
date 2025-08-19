
import simbad.sim.Agent;
import simbad.sim.LightSensor;
import simbad.sim.RangeSensorBelt;

public class iBug {
    public enum robotState {
        AlignmentGoal, MoveToGoal, CircumNavigate, Terminate
    }

    private robotState state;
    Agent rob;
    RangeSensorBelt sonars;
    LightSensor center;
    LightSensor right;
    LightSensor left;
    boolean CLOCKWISE;

    public iBug(Agent rob, RangeSensorBelt sonars, LightSensor center, LightSensor right, LightSensor left, boolean CLOCKWISE){
        this.rob=rob;
        this.sonars=sonars;
        this.center= center;
        this.right=right;
        this.left=left;
        this.CLOCKWISE=CLOCKWISE;
        state=robotState.AlignmentGoal;
        System.out.println("Initial");
    }

    public void step() {
        if (state == robotState.AlignmentGoal) {
            Behaviors.AlignmentGoal(rob,center,right,left);
            if (Behaviors.isAlignment())
                state=robotState.MoveToGoal;
        }

        if (state==robotState.MoveToGoal){
            Behaviors.moveToGoal(rob,sonars);
            if (Behaviors.Terminate(center,right,left)) {
                state = robotState.Terminate;
            }
            else if (Behaviors.LocalMax(center)) {
                Behaviors.stop(rob);
                state = robotState.AlignmentGoal;
                Behaviors.falseAlignment();
                Behaviors.zeroMax();
            }
            else if (Behaviors.moveToGoal(rob,sonars)) {
                state = robotState.CircumNavigate;
            }
        }

        if (state==robotState.CircumNavigate) {
            Behaviors.circumNavigate(rob,sonars, true);
            if (Behaviors.LocalMax(center)) {
                Behaviors.stop(rob);
                state = robotState.AlignmentGoal;
                Behaviors.falseAlignment();
                Behaviors.zeroMax();
            }
        }

        if (state==robotState.Terminate)
        {
            Behaviors.stop(rob);
            return;
        }
       // System.out.println("state: "+ state);
    }
}
