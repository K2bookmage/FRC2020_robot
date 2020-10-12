package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class ControlPanelExtend extends CommandBase {
  
  private final ControlPanel controlPanel;

  public ControlPanelExtend(ControlPanel controlPanel) {
    this.controlPanel = controlPanel;
    addRequirements(controlPanel);
  }

  @Override
  public void initialize() {
    controlPanel.extend();
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
