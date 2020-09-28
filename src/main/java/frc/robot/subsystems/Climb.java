package frc.robot.subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Climb extends SubsystemBase {

    private final WPI_VictorSPX extendVictor;
    private final WPI_VictorSPX retractVictor;

    private final double EXTEND_SPEED = 1;
    private final double RETRACT_SPEED = .6;

    public Climb() {
        extendVictor = MotorFactory.makeVictorSPX(Constants.CLIMB_RIGHT_VICTOR, "climb right victor");
        retractVictor = MotorFactory.makeVictorSPX(Constants.CLIMB_LEFT_VICTOR, "climb left victor");
    }

    public extend(){
        extendVictor.set(EXTEND_SPEED);
    }

    public extendReverse(){
        extendVictor.set(-EXTEND_SPEED);
    }

    public retract(){
        retractVictor.set(-RETRACT_SPEED);
    }

    public stop(){
        extendVictor.set(0);
        retractVictor.set(0);
    }

    public setCoastMode(){
        extendVictor.setNeutralMode(NeutralMode.Coast);
        retractVictor.setNeutralMode(NeutralMode.Coast);
    }

    public setBrakeMode(){
        extendVictor.setNeutralMode(NeutralMode.Brake);
        retractVictor.setNeutralMode(NeutralMode.Brake);
    }

}