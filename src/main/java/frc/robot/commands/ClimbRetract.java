package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class ClimbRetract extends CommandBase {
  
  private final ClimbRetract climbRetract;

  public ClimbRetract(Climb climb) {
    this.climb = climb;
    addRequirements(climb);
  }

  
  @Override
  public void initialize() {
    climb.retract();
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
