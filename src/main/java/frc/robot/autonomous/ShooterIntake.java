package frc.robot.autonomous;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;


public class ShooterIntake extends SequentialCommandGroup {
  
  public ShooterIntake() {
    addCommands(
      new IntakeExtend(intake),
      new WaitCommand(1),
      new IntakeQuickRetract(intake)
    );
  }
}
