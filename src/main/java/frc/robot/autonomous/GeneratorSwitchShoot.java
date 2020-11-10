package frc.robot.autonomous;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;


public class GeneratorSwitchShoot extends SequentialCommandGroup {
  
  public GeneratorSwitchShoot(Vision vision, Shooter shooter, Turret turret, Feeder feeder, Drivetrain drivetrain, Intake intake) {
    addCommands(
      new AutoShoot(vision, shooter, turret, feeder, 2000, 0.8, 1000),
      new TurnDegrees(drivetrain, 180),
      new MoveDistance(drivetrain, 4, 0.6),
      new TurnDegrees(drivetrain, 60),
      new IntakeExtend(intake),
      new MoveDistance(drivetrain, 10, 0.6),
      new IntakeRetract(intake),
      new TurnDegrees(drivetrain, 180),
      new MoveDistance(drivetrain, 10, 0.6),
      new TurnDegrees(drivetrain, -30),
      new MoveDistance(drivetrain, 4, 0.6),
      new AutoShoot(vision, shooter, turret, feeder, 2000, 0.8, 1000)
    );
    
  }
}
