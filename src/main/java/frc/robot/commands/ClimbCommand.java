package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class ClimbCommand extends CommandBase {
  
  private final Climb climb;
  private final XboxController controller;
  private static double value;

  public ClimbCommand(Climb climb, XboxController controller) {
    this.climb = climb;
    this.controller = controller;
    addRequirements(climb);
  }

  
  @Override
  public void initialize() {
    
  }

  @Override
  public void execute() {
    value = controller.getRawAxis(3);
    if(value > .3){
      climb.extend();
    } else if(value < -.3){
      climb.retract();
    } else{
      climb.stop();
    }

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
