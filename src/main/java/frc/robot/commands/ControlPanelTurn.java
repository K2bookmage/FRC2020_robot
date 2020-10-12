package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class ControlPanelTurn extends CommandBase {

  private final ControlPanel controlPanel;

  public ControlPanel(ControlPanel controlPanel) {
   this.controlPanel = controlPanel;
   addRequirements(controlPanel);
  }


  @Override
  public void initialize() {
    controlPanel.turn();
  }

 
  @Override
  public void execute() {
  }


  @Override
  public void end(boolean interrupted) {
    controlPanel.stop();
  }


  @Override
  public boolean isFinished() {
    return false;
  }
}
