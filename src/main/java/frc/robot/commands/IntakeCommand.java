
package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class IntakeCommand extends CommandBase {
  
  private final Intake intake;
  private final Feeder feeder;
  private final XboxController controller;

  private int dPov;

  public IntakeCommand(Intake intake, Feeder feeder, XboxController controller) {
   this.intake = intake;
   this.feeder = feeder;
   this.controller = controller;
   addRequirements(intake);
  }

  
  @Override
  public void initialize() {
  }

 
  @Override
  public void execute() {
    dPov = controller.getPOV();
    if(dPov == 0){
      new IntakeJiggle(intake, feeder);
    }else if(dPov == 90){
      intake.on();
    }else if(dPov == 180){
      intake.off();
    }else if(dPov == 270){
      intake.reverse();
    }
  }

  
  @Override
  public void end(boolean interrupted) {
  }

  
  @Override
  public boolean isFinished() {
    return false;
  }
}
