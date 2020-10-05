package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class DriveCommand extends CommandBase {
  
  private final Drivetrain drivetrain;
  private final XboxController controller;

  public DriveCommand(Drivetrain drivetrain, XboxController controller) {
    this.drivetrain = drivetrain;
    this.controller = controller;
    addRequirements(drivetrain);
  }

  
  @Override
  public void initialize() {
  }


  @Override
  public void execute() {
    double moveSpeed = -0.7*controller.getRawAxis(1);
    double rotateSpeed = -0.6*controller.getRawAxis(2);
    double currentSpeed = drivetrain.getSpeed();
    drivetrain.arcadeDrive(moveSpeed, rotateSpeed);
  }


  @Override
  public void end(boolean interrupted) {
    drivetrain.arcadeDrive(0,0);
  }

 
  @Override
  public boolean isFinished() {
    return false;
  }
}
