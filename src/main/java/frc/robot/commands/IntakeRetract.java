
package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class IntakeRetract extends CommandBase {
 
  private final Intake intake;
  private static long endTime;

  public IntakeRetract(Intake intake) {
    this.intake = intake;
    addRequirements(intake);
  }

 
  @Override
  public void initialize() {
    intake.retract();
    endTime = System.currentTimeMillis() + 3000;
  }

 
  @Override
  public void execute() {
  }

  
  public void end(boolean interrupted) {
    intake.off();
  }

  
  @Override
  public boolean isFinished() {
    return endTime < System.currentTimeMillis;
  }
}
