package frc.robot.autonomous;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class DefaultSequence extends SequentialCommandGroup {
 
  public DefaultSequence() {
    addCommands(
      new MoveDistance(drivetrain, 2, 0.6)
    );
    addRequirements(drivetrain);

  }
}
