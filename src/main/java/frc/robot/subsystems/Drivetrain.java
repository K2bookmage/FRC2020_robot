/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {
  
  private final WPI_TalonFX frontLeftTalon;
  private final WPI_TalonFX frontRightTalon;
  private final WPI_TalonFX rearLeftTalon;
  private final WPI_TalonFX rearRightTalon;

  private final SpeedControllerGroup leftGroup;
  private final SpeedControllerGroup rightGroup;

  private final DifferentialDrive differentialDrive;

  public Drivetrain() {
    frontLeftTalon = MotorFactory.makeTalonFX(Constants.DRIVETRAIN_FRONT_LEFT_TALON, "drivetrain front left talon");
    frontRightTalon = MotorFactory.makeTalonFX(Constants.DRIVETRAIN_FRONT_RIGHT_TALON, "drivetrain front right talon");
    rearLeftTalon = MotorFactory.makeTalonFX(Constants.DRIVETRAIN_REAR_LEFT_TALON, "drivetrain rear left talon");
    rearRightTalon = MotorFactory.makeTalonFX(Constants.DRIVETRAIN_REAR_RIGHT_TALON, "drivetrain rear right talon");

    leftGroup = new SpeedControllerGroup(frontLeftTalon, rearLeftTalon);
    rightGroup = new SpeedControllerGroup(frontRightTalon, rearRightTalon);

    differentialDrive = new DifferentialDrive(leftGroup, rightGroup);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
