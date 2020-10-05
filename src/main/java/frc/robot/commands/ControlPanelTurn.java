package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class ControlPanelTurn extends CommandBase {

  private final ControlPanelTurn controlPanelTurn;

  public ControlPanelTurn(Intake in take) {
   this.intake = intake;
   addRequirements(controlPanel);
  }


  @Override
  public void initialize() {
  }

 
  @Override
  public void execute() {
    intake.turn();
  }


  @Override
  public void end(boolean interrupted) {
  }


  @Override
  public boolean isFinished() {
    return false;
  }
}
