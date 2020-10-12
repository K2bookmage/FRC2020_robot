package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class ControlPanelRetract extends CommandBase {

  private final ControlPanel controlPanel;

  public ControlPanelRetract(ControlPanel controlPanel) {
    this.controlPanel = controlPanel;
    addRequirements(controlPanel);
  }


  @Override
  public void initialize() {
    controlPanel.retract();
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
