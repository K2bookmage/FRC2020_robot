package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class FeederReverse extends CommandBase {
  private final FeederReverse feederReverse;

  public FeederReverse(Feeder feeder) {
   this.feeder = feeder;
   addrequrements(feeder);

  }
  @Override
  public void initialize() {
    feeder.reverse();
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
