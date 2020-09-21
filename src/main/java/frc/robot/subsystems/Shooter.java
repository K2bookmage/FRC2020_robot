package frc.robot.subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase{
    private final WPI_TalonFX leftTalon;
    private final WPI_TalonFX rightTalon;
    private final WPI_VictorSRX acceleratorVictor;

    private final SpeedControllerGroup primaryGroup;
    private final DifferentialDrive differentialDrive;

    public Shooter(){
        leftTalon = MotorFactory.makeTalonFX(Constants.SHOOTER_LEFT_TALON, "shooter left talon");
        rightTalon = MotorFactory.makeTalonFX(Constants.SHOOTER_RIGHT_TALON, "shooter right talon");
        acceleratorVictor = MotorFactory.makeVictorSPX(Constants.ACCELERATOR_VICTOR, "shooter accelerator victor");

        primaryGroup = new SpeedControllerGroup(leftTalon, rightTalon);
        differentialDrive = new DifferentialDrive(primaryGroup);
    }
}