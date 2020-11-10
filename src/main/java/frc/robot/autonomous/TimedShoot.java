package frc.robot.autonomous;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;


public class TimedShoot extends SequentialCommandGroup {
  
  public TimedShoot(Vision vision, Shooter shooter, Turret turret, Feeder feeder, Intake intake, long time) {
    addCommands(
      new AutoShoot(vision, shooter, turret, feeder, time, .8, 1000),
      new ShooterIntake(intake)
    );

  }
}
