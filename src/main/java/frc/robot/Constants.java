/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static final int DRIVETRAIN_FRONT_RIGHT_TALON = 1;
    public static final int DRIVETRAIN_REAR_RIGHT_TALON = 2;
    public static final int DRIVETRAIN_FRONT_LEFT_TALON = 3;
    public static final int DRIVETRAIN_REAR_LEFT_TALON = 4;

    public static final int CLIMB_EXTEND_VICTOR = 1;
    public static final int CLIMB_RETRACT_VICTOR = 2;

    public static final int CONTROLPANEL_PCM_NODE = 0;
    public static final int CONTROLPANEL_MAIN_TALON = 1;

    public static final int FEEDER_LEFT_VICTOR = 1;
    public static final int FEEDER_RIGHT_VICTOR = 2;
    public static final int FEEDER_TRIGGER_VICTOR = 3;

    public static final int INTAKE_PCM_NODE = 0;
    public static final int INTAKE_VICTOR = 1;

    public static final int SHOOTER_LEFT_TALON = 1;
    public static final int SHOOTER_RIGHT_TALON = 2;
    public static final int SHOOTER_ACCELERATOR_VICTOR = 3;

    public static final int TURRET_TALON = 1;

    public static final int DRIVE_CONTROLLER_PORT = 1;
    public static final int AUX_CONTROLLER_PORT = 2;

}
