package frc.robot.subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase{
    private final WPI_TalonFX leftTalon;
    private final WPI_TalonFX rightTalon;
    private final WPI_VictorSRX acceleratorVictor;

    private static final double acceleratorSpeed = 0.8;

    public double shooterSpeed = 1;

    public Shooter(){
        leftTalon = MotorFactory.makeTalonFX(Constants.SHOOTER_LEFT_TALON, "shooter left talon");
        rightTalon = MotorFactory.makeTalonFX(Constants.SHOOTER_RIGHT_TALON, "shooter right talon");
        acceleratorVictor = MotorFactory.makeVictorSPX(Constants.ACCELERATOR_VICTOR, "shooter accelerator victor");
    }

   public void allOn(){
       shooterOn(shooterSpeed);
       acceleratorOn();
   }

   public void allOff(){
       shooterOff();
       acceleratorOff();
   }

   public void shooterOn(double speed){
        shooterSpeed = speed;
        leftTalon.set(-1*shooterSpeed);
        rightTalon.set(shooterSpeed);
   }

   public void shooterOff(){
       leftTalon.set(0);
       rightTalon.set(0);
   }

   public void acceleratorOn(){
       accelerator.set(ACCELERATOR_SPEED);
   }

   public void acceleratorOff(){
       accelerator.set(0);
   }

   public void setSpeed(double speed){
        shooterSpeed = speed;
   }

   public int getLeftPosition(){
       return -1*leftTalon.getSelectedSensorPosition;
   }

   public int getRightPosition(){
       return rightTalon.getSelectedSensorPosition;
   }

}