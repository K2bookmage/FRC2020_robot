package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class TurretCommand extends CommandBase {
  
  private final Turret turret;
  private final XboxController controller;

  public TurretCommand(Turret turret, XboxController controller) {
    this.turret = turret;
    this.controller = controller;
    addRequirements(turret);
  }

  
  @Override
  public void initialize() {
  }

  
  @Override
  public void execute() {
    double speed = -.3*controller.getRawAxis(0);
   
    if((speed<0&&turret.getPosition()>7000)||(speed>0&&turret.getPosition()<7000)){
      turret.move(0);
      return;
    }
    
    turret.move(speed);
  }

  
  @Override
  public void end(boolean interrupted) {
    turret.move(0);
  }

  
  @Override
  public boolean isFinished() {
    return false;
  }
}
