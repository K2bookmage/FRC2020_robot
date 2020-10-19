package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class AutoShoot extends CommandBase {
  
  private long SHOOT_DELAY_MILLIS;
  private static final double TURRET_SPEED = 0.13;

  private final Vision vision;
  private final Shooter shooter;
  private final Turret turret;
  private final Feeder feeder;
  
  private long shootTime;
  private long endCommandTime;
  private long delayMillis;
  private double speed;

  public AutoShoot(Vision vision, Shooter shooter, Turret turret, Feeder feeder) {
    this(vision,shooter,turret,feeder, -1, .8, 1000);
  }

  public AutoShoot(Vision vision, Shooter shooter, Turret turret, Feeder feeder, long delayMillis, double speed, long SHOOT_DELAY_MILLIS) {
    this.vision = vision;
    this.shooter = shooter;
    this.turret = turret;
    this.feeder = feeder;
    this.delayMillis = delayMillis;
    this.speed = speed;
    this.SHOOT_DELAY_MILLIS = SHOOT_DELAY_MILLIS;
    addRequirements(vision,shooter,turret);
  }
  
  @Override
  public void initialize() {
    vision.turnOnCanLeds();
    shooter.shooterOn(speed);
    shooter.acceleratorOn();
    if(delayMillis>0){
      endCommandTime = System.currentTimeMillis() + delayMillis;
    } else{
      endCommandTime = -1;
    }
    shootTime = System.currentTimeMillis() + SHOOT_DELAY_MILLIS;
  }

  
  @Override
  public void execute() {
    double leftOffset = SHOOT_DELAY_MILLIS <= 500 ? 0 : 1;
    double rightOffset = SHOOT_DELAY_MILLIS <= 500 ? -2 : -1;
    if(vision.hasValidTargets()){
      double offset = Vision.Entry.HORIZONTAL_OFFSET.getValue();
      double turretSpeed = offset>0 ? -TURRET_SPEED : TURRET_SPEED;
      if(offset>leftOffset){
        feeder.allOff();
        turret.move(turretSpeed);
      } else if(offset<rightOffset){
        feeder.allOff();
        turret.move(turretSpeed);
      } else{
        turret.move(0);
        if(System.currentTimeMillis()>shootTime){
          feeder.allOn();
        }
      }
    }
  }

  
  @Override
  public void end(boolean interrupted) {
    shooter.shooterOff();
    shooter.acceleratorOff();
    feeder.allOff();
  }

  
  @Override
  public boolean isFinished() {
    return endCommandTime>0 ? System.currentTimeMillis()>endCommandTime : false;
  }
}
