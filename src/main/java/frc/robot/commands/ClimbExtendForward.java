package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class ClimbExtendForward extends CommandBase {
  
  private final Climb climb;

  public ClimbExtendForward(Climb climb) {
    this.climb = climb;
    addRequirements(climb);
  }

  
  @Override
  public void initialize() {
    climb.extend();
  }

  
  @Override
  public void execute() {

  }

  
  @Override
  public void end(boolean interrupted) {
    climb.stop();
  }

  
  @Override
  public boolean isFinished() {
    return false;
  }
}
