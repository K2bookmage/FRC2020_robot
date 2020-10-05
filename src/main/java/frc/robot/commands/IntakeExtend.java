package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class IntakeExtend extends CommandBase {
  
  private final Intake intake;


  public IntakeExtend(Intake intake) {
    this.intake = intake;
    addRequirements(intake);
  }


  @Override
  public void initialize() {
    intake.extend();
    intake.on();
  }


  @Override
  public void execute() {
  }


  @Override
  public void end(boolean interrupted) {
  }


  @Override
  public boolean isFinished() {
    return true;
  }
}
