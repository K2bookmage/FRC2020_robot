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

  SendableChooser<Command> autoChooser = new SendableChooser<Command>();
  SendableChooser<Double> speedChooser = new SendableChooser<Double>();
  
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
    turret.setDefaultCommand(new TurretCommand(turret, auxController));
    intake.setDefaultCommand(new IntakeCommand(feeder, intake, auxController));

    speedChooser.addOption("0.6", 0.6);
    speedChooser.addOption("0.7", 0.7);
    speedChooser.addDefault("0.8", 0.8);
    speedChooser.addOption("0.9", 0.9);
    speedChooser.addOption("1.0", 1.0);
    SmartDashboard.putData("Shooter Speed", speedChooser);
    autoChooser.addOption("DoubleShoot", new DoubleShoot(vision, shooter, turret, feeder, drivetrain, intake));
    autoChooser.addOption("SingleShoot", new SingleShoot(vision, shooter, turret, feeder, drivetrain, intake));
    SmartDashboard.putData("Autonomous", autoChooser);
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
    new JoystickButton(driverController, Button.kB.value).whileHeld(new ClimbReverse(extendReverse));
    new JoystickButton(driverController, Button.kX.value).whileHeld(new ClimbRetract(retract));

    //aux buttons
    new JoystickButton(auxController, Button.kBumperLeft.value).whenPressed(new IntakeExtend(intake));
    new JoystickButton(auxController, Button.kBack.value).whenPressed(new IntakeRetract(retract));
    new JoystickButton(auxController, Button.kBumperRight.value).whenPressed(new ControlPanelExtend(extend));
    new JoystickButton(auxController, Button.kStart.value).whenPressed(new ControlPanelRetract(retract));
    new JoystickButton(auxController, Button.kB.value).whenHeld(new ControlPanelTurn(turn));
    new JoystickButton(auxController, Button.kX.value).whenPressed(new ControlPanelStage1(controlPanel));
    new JoystickButton(auxController, Button.kA.value).whenHeld(new FeederReverse(feederReverse));
    new JoystickButton(auxController, Button.kY.value).whenPressed(new IntakeJiggle(intake, feeder));

  }


  
  public Command getAutonomousCommand() {
    Command cmd = autoChooser.getSelected();
    if(cmd == null){
      return new SingleShoot(vision, shooter, turret, feeder, drivetrain, intake);
    }
    return cmd;
  }

  public void setCoastMode(){
    drivetrain.setCoastMode();
    climb.setCoastMode();
  }
  public void setBrakeMode(){
    drivetrain.setBrakeMode();
    climb.setBrakeMode();
  }
  public void retractIntake(){
    intake.retract();
    intake.off();
  }
  public void climbOff(){
    climb.stop();
  }
  //TO DO
  public void updateShooterSpeed(){

  }
  public void visionOff(){
    vision.turnOffCamLeds();
  }
  public void visionOn(){
    vision.turnOnCamLeds();
  }

}
