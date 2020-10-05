package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class ClimbReverse extends CommandBase {
  
  private final ClimbReverse climbReverse;

  public ClimbReverse(Climb climb) {
    this.climb = climb;
    addRequirements(climb);
  }

  
  @Override
  public void initialize() {
    climb.reverse();
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
