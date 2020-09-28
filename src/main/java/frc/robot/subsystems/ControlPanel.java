package frc.robot.subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ControlPanel extends SubsystemBase{
    private final Solenoid solenoid;
    private final WPI_TalonSRX mainTalon;

    private final double TURN_SPEED = 0.4;

    public ControlPanel(){
        solenoid = new Solenoid(Constants.CONTROLPANEL_PCM_NODE, Constants, 0);
        mainTalon = MotorFactory.makeTalonSRX(Constants.CONTROLPANEL_MAIN_TALON, "drivetrain maintalon");
}

    public turn(){
        mainTalon.set(TURN_SPEED);
    }

    public turnStop(){
        mainTalon.set(0);
    }

    public extend(){
        solenoid.set(true);
    }

    public retract(){
        solenoid.set(false);
    }

    public getPosition(){
        return talon.getSelectedSensorPosition;
    }

}
