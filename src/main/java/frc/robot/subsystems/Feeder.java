package frc.robot.subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Feeder extends SubsystemBase{
    private final WPI_VictorSPX leftVictor;
    private final WPI_VictorSPX rightVictor;
    private final WPI_VictorSPX triggerVictor;

    private final SpeedControllerGroup mainGroup;

    private final DiufferentialDrive differentialDrive;

    public Feeder(){
        leftVictor = MotorFactory.makeVictorSPX(Constants.FEEDER_LEFT_VICTOR, "feeder left victor");
        rightVictor = MotorFactory.makeVictorySPX(Constants.FEEDER_RIGHT_VICTOR, "feeder right victor");
        triggerVictor = MotorFactory.makeVictorySPX(Constatns.FEEDER_TRIGGER_VICTOR, "feeder trigger victor");

        mainGroup = new SpeedControllerGroup(leftVictor, rightVictor);
        differentialDrive = new DifferentialDrive(mainGroup);
}

}