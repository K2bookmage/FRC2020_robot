
package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class IntakeJiggle extends CommandBase {
  private final IntakeJiggle intakeJiggle;

  public IntakeJiggle(Intake intake, Feeder feeder) {
    this.intake = intake;
    this.feeder = feeder;
    addRequirements(intake, feeder);
  }


  @Override
  public void initialize() {
  }


  @Override
  public void execute() {
  }


  @Override
  public void end(boolean interrupted) {
  }


  @Override
  public boolean isFinished() {
    return false;
  }
}
