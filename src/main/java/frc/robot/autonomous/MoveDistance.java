package frc.robot.autonomous;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class MoveDistance extends CommandBase {
  
  private static final double ENCODER_UNITS_PER_FOOT = (12*24000)/(Math.PI*6);
  private static final double INIT_OUTPUT = 0.5;
  private static double MAX_OUTPUT;
  private static final double MIN_OUTPUT = 0.2;
  private static final double ACCELERATION_OUTPUT_PER_PERIOD = 0.01;
  private static final double DECELERATION_OUTPUT_PER_PERIOD = .1;

  private final Drivetrain drivetrain;
  private final int targetEncoderDistance;
  private final boolean isMovingForward;

  private int leftPosition;
  private int rightPosition;
  private int leftTargetPosition;
  private int rightTargetPosition;
  private double output;

  private int decelOffset;
  private int leftDecelPosition;
  private int rightDecelPosition;

  public MoveDistance(Drivetrain drivetrain, double distanceInFeet, double speed) {
    this.drivetrain = drivetrain;
    MAX_OUTPUT = speed;
    addRequirements(drivetrain);
    targetEncoderDistance = (int)(distanceInFeet * ENCODER_UNITS_PER_FOOT);
    isMovingForward = distanceInFeet > 0;
  }

 
  @Override
  public void initialize() {
    updatePosition();
    decelOffset = calculateDecelOffset();
    if(isMovingForward){
      leftTargetPosition = leftPosition + targetEncoderDistance;
      rightTargetPosition = rightPosition + targetEncoderDistance;
      leftDecelPosition = leftTargetPosition - decelOffset;
      rightDecelPosition = rightTargetPosition - decelOffset;
      output = INIT_OUTPUT;
      drivetrain.arcadeDrive(output, 0);
    } else{
      leftTargetPosition = leftPosition - targetEncoderDistance;
      rightTargetPosition = rightPosition - targetEncoderDistance;
      leftDecelPosition = leftTargetPosition + decelOffset;
      rightDecelPosition = rightTargetPosition + decelOffset;
      output = -INIT_OUTPUT;
      drivetrain.arcadeDrive(output, 0);
    }
  }

  
  @Override
  public void execute() {
    updatePosition();
    if(isFinished()){
      drivetrain.arcadeDrive(0, 0);
      return;
    }
    if(isMovingForward){
      if(leftPosition >= leftDecelPosition || rightPosition >= rightDecelPosition){
        if(output > MIN_OUTPUT){
          output - = DECELERATION_OUTPUT_PER_PERIOD;
        }
      } else if(output < MAX_OUTPUT){
        output + = ACCELERATION_OUTPUT_PER_PERIOD;
      }
    } else{
      if(leftPosition <= leftDecelPosition || rightPosition <= rightDecelPosition){
        if(output < -MIN_OUTPUT){
          output + = DECELERATION_OUTPUT_PER_PERIOD;
        }
      } else if(output > -MAX_OUTPUT){
        output - = ACCELERATION_OUTPUT_PER_PERIOD;
      }
    }
    drivetrain.arcadeDrive(output, 0);
  }

  
  @Override
  public void end(boolean interrupted) {
    drivetrain.arcadeDrive(0, 0);
  }

  
  @Override
  public boolean isFinished() {
    return isMovingForward
      ?(leftPosition >= leftTargetPosition || rightPosition >= rightTargetPosition)
      :(leftPosition <= leftTargetPosition || rightPosition <= rightTargetPosition);
  }

  private int calculateDecelOffset(){
    return isMovingForward 
      ? (int) ((MAX_OUTPUT - MIN_OUTPUT) / DECELERATION_OUTPUT_PER_PERIOD)
      : (int) ((MAX_OUTPUT + MIN_OUTPUT) / DECELERATION_OUTPUT_PER_PERIOD);
  }

  private void updatePosition(){
    leftPosition = drivetrain.getLeftPosition();
    rightPosition = drivetrain.getRightPosition();
  }
}
