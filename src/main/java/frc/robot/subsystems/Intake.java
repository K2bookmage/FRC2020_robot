package frc.robot.subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
    private final Solenoid solenoid;
    private final WPI_VictorSPX victor;

    public Intake(){
        solenoid = new Solenoid(Constants.INTAKE_PCM_NODE, Constants, 0);
        victor = MotorFactory.makeVictorSPX(Constants.INTAKE_VICTOR, "intake victor");
    }
}