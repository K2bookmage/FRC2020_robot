
package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class IntakeJiggle extends CommandBase {
 
  private final Intake intake;
  private final Feeder feeder;
  private long endTime;

  public IntakeJiggle(Intake intake, Feeder feeder) {
    this.intake = intake;
    this.feeder = feeder;
    addRequirements(intake, feeder);
  }


  @Override
  public void initialize() {
    endTime = System.currentTimeMillis() + 1000;
    intake.extend();
  }


  @Override
  public void execute() {
    feeder.reverse();
  }


  @Override
  public void end(boolean interrupted) {
    intake.retract();
    if(feeder.isFeederOn()){
      feeder.on();
    }else{
      feeder.off();
    }
  }


  @Override
  public boolean isFinished() {
    return System.currentTimeMillis() > endTime;
  }
}
