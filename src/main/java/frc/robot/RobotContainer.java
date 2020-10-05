package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.Command;

public class RobotContainer {
  private final Drivetrain drivetrain;
  private final Intake intake;
  private final Feeder feeder;
  private final Shooter shooter;
  private final Turret turret;
  private final ControlPanel controlPanel;
  private final Climb climb;

  private final XboxController driverController;
  private final XboxController auxController;
  
  public RobotContainer() {
    drivetrain = new Drivetrain();
    intake = new Intake();
    feeder = new Feeder();
    shooter = new Shooter();
    turret = new Turret();
    controlpanel = new ControlPanel();
    climb = new Climb();

    driverController = new XboxController(Constants.DRIVE_CONTROLLER_PORT);
    auxController = new XboxController(Constants.DRIVE_CONTROLLER_PORT);

    configureButtonBindings();

    drivetrain.setDefaultCommand(new DriveCommand(drivetrain, driverController));
    climb.setDefaultCommand(new ClimbCommand(climb, auxController));
    // turret 
    // intake

  }

  /***
 * Button names and Controller
 * kA = X
 * kB = A
 * kX = B
 * kY = Y
 * kBumperLeft = left bumper
 * kBumperRight = right bumper
 * kBack = left trigger
 * kStart = right trigger
 * kStickLeft = back
 * kStickRight = start
 * Raw Axis 0 = Left Joystick X Axis
 * Raw Axis 1 = Left Joystick Y Axis
 * Raw Axis 2 = Right Joystick X Axis
 * Raw Axis 3 = Right Joystick Y Axis
 * 11 = left stick
 * 12 = right stick 
 */
  private void configureButtonBindings() {
    //driver buttons
    // new JoystickButton(drivercontroller, Button.kBack.value).whileHeld(new JustShoot(feeder, shooter));

    new JoystickButton(driverController, Button.kA.value).whileHeld(new ClimbExtendForward(climb));

    //aux buttons
    new JoystickButton(auxController, Button.kBumperLeft.value).whenPressed(new IntakeExtend(intake));

  }


  
  public Command getAutonomousCommand() {

    return m_autoCommand;
  }
}
