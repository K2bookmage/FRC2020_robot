package frc.robot.subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
    public static final double INTAKE_IN_SPEED = 1; 
    public static final double INTAKE_OUT_SPEED = -.3;
    
    private final Solenoid solenoid;
    private final WPI_VictorSPX victor;

    public Intake(){
        solenoid = new Solenoid(Constants.INTAKE_PCM_NODE, Constants, 0);
        victor = MotorFactory.makeVictorSPX(Constants.INTAKE_VICTOR, "intake victor");
    }

    public void extend(){
        solenoid.set(true);
    }
    public void retract(){
        solenoid.set(false);
    }

    public void on(){
        victor.set(INTAKE_IN_SPEED);
    }
    public void reverse(){
        victor.set(INTAKE_OUT_SPEED);
    }

    public void off(){
        victor.set(0);
    }

}