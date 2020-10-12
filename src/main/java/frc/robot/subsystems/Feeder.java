package frc.robot.subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Feeder extends SubsystemBase{
    private static final double FEEDER_SPEED = -0.5;
    private static final double TRIGGER_SPEED = -1;
    
    private final WPI_VictorSPX leftVictor;
    private final WPI_VictorSPX rightVictor;
    private final WPI_VictorSPX triggerVictor;

    private final SpeedControllerGroup mainGroup;

    private boolean isFeederOn;

    public Feeder(){
        leftVictor = MotorFactory.makeVictorSPX(Constants.FEEDER_LEFT_VICTOR, "feeder left victor");
        rightVictor = MotorFactory.makeVictorySPX(Constants.FEEDER_RIGHT_VICTOR, "feeder right victor");
        triggerVictor = MotorFactory.makeVictorySPX(Constatns.FEEDER_TRIGGER_VICTOR, "feeder trigger victor");

        mainGroup = new SpeedControllerGroup(leftVictor, rightVictor);
}

public void allOn(){
    feederOn();
    triggerOn();
}

public void allOff(){
    feederOff();
    triggerOff();
}

public void feederOn(){
    if(!isFeederOn){
        group.set(FEEDER_SPEED);
        isFeederOn = true;
    }
}

public void feederOff(){
    if(isFeederOn){
        group.set(0);
        isFeederOn = false;
    }
}

public void feederReverse(){
    group.set(-FEEDER_SPEED);
}

public void setSpeed(double speed){
    group.set(speed);
}

public void triggerOn(){
    trigger.set(TRIGGER_SPEED);
}

public void triggerOff(){
    trigger.set(0);
}

public boolean isFeederOn(){
    return isFeederOn;
}

}