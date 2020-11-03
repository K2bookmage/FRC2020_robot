package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class IntakeQuickRetract extends CommandBase {
  
  private final Intake intake;

  public IntakeQuickRetract(Intake intake) {
    this.intake = intake;
  }

 
  @Override
  public void initialize() {
    intake.retract();
  }

  @Override
  public void execute() {
  }

 
  @Override
  public void end(boolean interrupted) {
    intake.off();
  }


  @Override
  public boolean isFinished() {
    return true;
  }
}
