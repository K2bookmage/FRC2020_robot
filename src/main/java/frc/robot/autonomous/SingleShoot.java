
package frc.robot.autonomous;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;


public class SingleShoot extends SequentialCommandGroup {
  
  public SingleShoot(Vision vision, Shooter shooter, Turret turret, Feeder feeder, Drivetrain drivetrain, Intake intake) {
    addCommands(
      new TimedShoot(vision, shooter, turret, feeder, intake, 10000),
      new TurnDegrees(drivetrain, 180),
      new MoveDistance(drivetrain, 4, 0.6)
    );
  }
}
