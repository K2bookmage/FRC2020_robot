
package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class IntakeRetract extends CommandBase {
 
  private final IntakeRetract intakeRetract;

  public IntakeRetract(Intake intake) {
    this.intake = intake;
    addRequirements(intake);
  }

 
  @Override
  public void initialize() {
    intake.retract();
    intake.off();
  }

 
  @Override
  public void execute() {
  }

  
  public void end(boolean interrupted) {
  }

  
  @Override
  public boolean isFinished() {
    return false;
  }
}
