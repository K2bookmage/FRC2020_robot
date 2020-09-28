package frc.robot.subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Climb extends SubsystemBase {

    private final WPI_VictorSPX rightVictor;
    private final WPI_VictorSPX leftVictor;

    private final SpeedControllerGroup primaryGroup;

    private final DifferentialDrive differentialDrive;

    private final extend = 1;
    private final retract = .6;

    public Climb() {
        rightVictor = MotorFactory.makeVictorSPX(Constants.CLIMB_RIGHT_VICTOR, "climb right victor");
        leftVictor = MotorFactory.makeVictorSPX(Constants.CLIMB_LEFT_VICTOR, "climb left victor");

        primaryGroup = new SpeedControllerGroup(rightVictor, leftVictor);

        differentialDrive = new DifferentialDrive(primaryGroup);
    }

    public extend(){
        group.set(EXTEND_SPEED);
    }

    public extendReverse(){
        group.set(-EXTEND_SPEED);
    }

    public retract(){
        group.set(-RETRACT_SPEED);
    }

    public stop(){
        group.set(0);
    }

    public setCoastMode(){
        rightVictor.setNeutralMode(NeutralMode.Coast);
        leftVictor.setNeutralMode(NeutralMode.Coast);
    }

    public setBrakeMode(){
        rightVictor.setNeutralMode(NeutralMode.Brake);
        leftVictor.setNeutralMode(NeutralMode.Brake);
    }

}