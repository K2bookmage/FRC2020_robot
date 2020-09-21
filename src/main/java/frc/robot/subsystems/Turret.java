package frc.robot.subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Turret extends SubsystemBase {
    private final WPI_TalonSPX talon;

    public Turret(){
        talon = MotorFactory.makeTalonSPX(Constants.TURRET_TALON, "turret, talon");
    }

}