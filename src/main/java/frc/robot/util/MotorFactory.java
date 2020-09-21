package frc.robot.util;
public class MotorFactory {

    private MotorFactory(){}

    public static WPI_TalonSRX makeTalon(int id, String name){

        WPI_TalonSRX talon = new WPI_TalonSRX(id);
        return talon;

    }
    public static WPI_VictorSPX makeVictor(int id, String name){

        WPI_VictorSPX victor = new WPI_VictorSPX(id);
        return victor;

    }
    public static WPI_TalonFX makeTalonFX(int id, String name){
        WPI_TalonFX talon = new WPI_TalonFX(id);
        return talon;

    }

}