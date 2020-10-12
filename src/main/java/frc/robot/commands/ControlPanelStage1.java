package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class ControlPanelStage1 extends CommandBase {
  
  private final ControlPanel controlPanel;
  private static final int SPINS = 4;
  private static final int ENCODER_UNITS_PER_SPIN = 24,000*8;

  private static int position;
  private static int target;

  public ControlPanelStage1(ControlPanel controlPanel) {
    this.controlPanel = controlPanel;
    addRequirements(controlPanel);
  }

  
  @Override
  public void initialize() {
    position = controlPanel.getPosition();
    target = position + SPINS * ENCODER_UNITS_PER_SPIN; 
  }

  
  @Override
  public void execute() {
    position = controlPanel.getPosition();
    controlPanel.turn();
  }

  
  @Override
  public void end(boolean interrupted) {
    controlPanel.stop();
  }

  
  @Override
  public boolean isFinished() {
    return position >= target;
  }
}
