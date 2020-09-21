package frc.robot.subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ControlPanel extends SubsystemBase{
    private final Solenoid solenoid;
    private final WPI_TalonSRX mainTalon;

    public ControlPanel(){
        solenoid = new Solenoid(Constants.CONTROLPANEL_PCM_NODE, Constants, 0);
        mainTalon = MotorFactory.makeTalonSRX(Constants.CONTROLPANEL_MAIN_TALON, "drivetrain maintalon");
}
}
