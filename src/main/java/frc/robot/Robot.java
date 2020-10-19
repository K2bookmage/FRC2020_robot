package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;


public class Robot extends TimedRobot {
  private Command m_autonomousCommand;

  private RobotContainer robotContainer;

 
  @Override
  public void robotInit() {
    robotContainer = new RobotContainer();
    robotContainer.retractIntake();
    robotContainer.setCoastMode();
    robotContainer.visionOn();
    robotContainer.climbOff();
    UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
  }

 
  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
  }

  
  @Override
  public void disabledInit() {
    robotContainer.setCoastMode();
  }

  @Override
  public void disabledPeriodic() {
  }

  
  @Override
  public void autonomousInit() {
    robotContainer.setBrakeMode();
    robotContainer.visionOn();
    m_autonomousCommand = m_robotContainer.getAutonomousCommand();

   
    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }

  
  @Override
  public void autonomousPeriodic() {
    robotContainer.updateShooterSpeed();
  }

  @Override
  public void teleopInit() {
    robotContainer.setBrakeMode();
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
    robotContainer.retractIntake();
    robotContainer.visionOn();
  }

  
  @Override
  public void teleopPeriodic() {
    robotContainer.updateShooterSpeed();
  }

  @Override
  public void testInit() {
    
    CommandScheduler.getInstance().cancelAll();
  }


  @Override
  public void testPeriodic() {
  }
}
