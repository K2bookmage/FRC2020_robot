package frc.robot.autonomous;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class DoubleShoot extends SequentialCommandGroup {
 
  public DoubleShoot(Vision vision, Shooter shooter, Turret turret, Feeder feeder, Drivetrain drivetrain, Intake intake) {
    addCommands(
      new AutoShoot(vision, shooter, turret, feeder, 3000, 0.8, 1000),
      new TurnDegrees(drivetrain, 183),
      new IntakeExtend(intake),
      new MoveDistance(drivetrain, 14, 0.4),
      new IntakeQuickRetract(intake),
      new TurnDegrees(drivetrain, 183),
      new MoveDistance(drivetrain, 12, 1),
      new TimedShoot(vision, shooter, turret, feeder, intake, 10000)
    );

  }
}
