package frc.robot.subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Climb extends SubsystemBase {

    private final WPI_VictorSPX rightVictor;
    private final WPI_VictorSPX leftVictor;

    private final SpeedControllerGroup primaryGroup;

    private final DifferentialDrive differentialDrive;

    public Climb() {
        rightVictor = MotorFactory.makeVictorSPX(Constants.CLIMB_RIGHT_VICTOR, "climb right victor");
        leftVictor = MotorFactory.makeVictorSPX(Constants.CLIMB_LEFT_VICTOR, "climb left victor");

        primaryGroup = new SpeedControllerGroup(rightVictor, leftVictor);

        differentialDrive = new DifferentialDrive(primaryGroup);
    }

}