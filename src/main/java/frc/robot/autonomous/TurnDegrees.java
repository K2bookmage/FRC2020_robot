
package frc.robot.autonomous;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class TurnDegrees extends CommandBase {

  private static final double WHEELBASE_RADIUS = 22.25/2;
  private static final double ENCODER_UNITS_PER_DEGREE = ((24000/(Math.PI*6))*(2*Math.PI*WHEELBASE_RADIUS))/360;
  private static final double INIT_OUTPUT = .4;
  private static final double MAX_OUTPUT = .4;
  private static final double MIN_OUTPUT = 0;
  private static final double ACCELERATION_OUTPUT_PER_PERIOD = 0.05;
  private static final double DECLERATION_OUTPUT_PER_PERIOD = 0.05;
  
  private final Drivetrain drivetrain;
  private final int targetEncoderDistance;
  private final boolean isTurningRight;

  private int leftPosition;
  private int rightPosition;
  private int leftTargetPosition;
  private int rightTargetPosition;
  private double output;


  public TurnDegrees(Drivetrain drivetrain, double distanceInDegrees) {
    this.drivetrain = drivetrain;
    targetEncoderDistance = (int) (distanceInDegrees * ENCODER_UNITS_PER_DEGREE);
    isTurningRight = distanceInDegrees > 0;
    addRequirements(drivetrain);
  }


  @Override
  public void initialize() {
    updatePosition();
    if(isTurningRight){
      leftTargetPosition = leftPosition + targetEncoderDistance;
      rightTargetPosition = rightPosition - targetEncoderDistance;
      drivetrain.arcadeDrive(0,INIT_OUTPUT);
    }else{
      leftTargetPosition = leftPosition - targetEncoderDistance;
      rightTargetPosition = rightPosition + targetEncoderDistance;
      drivetrain.arcadeDrive(0,-INIT_OUTPUT);
    }
  }

  
  @Override
  public void execute() {
    updatePosition();
    if(isFinished()){
      drivetrain.arcadeDrive(0,0);
      return;
    }
    int decelOffset = calculateDecelOffset();
    int leftDecelPosition = leftTargetPosition - decelOffset;
    int rightDecelPosition = rightTargetPosition + decelOffset;
    
    if(isTurningRight){
      if(leftPosition>=leftDecelPosition || rightPosition <= rightDecelPosition){
        if(output > MIN_OUTPUT{
          output -= DECLERATION_OUTPUT_PER_PERIOD;
        }
      }else if(output < MAX_OUTPUT){
        output += ACCELERATION_OUTPUT_PER_PERIOD;
      }
    }else{
      if(leftPosition<=leftDecelPosition || rightPosition >= rightDecelPosition){
        if(output < -MIN_OUTPUT{
          output += DECLERATION_OUTPUT_PER_PERIOD;
        }
      }else if(output > -MAX_OUTPUT){
        output -= ACCELERATION_OUTPUT_PER_PERIOD;
      }
    }
    drivetrain.arcadeDrive(0,output);
  }

  
  @Override
  public void end(boolean interrupted) {
    drivetrain.arcadeDrive(0,0);
  }

  
  @Override
  public boolean isFinished() {
    return isTurningRight
      ? (leftPosition >= leftTargetPosition || rightPosition <= rightTargetPosition)
      : (leftPosition <= leftTargetPosition || rightPosition >= rightTargetPosition);
  }

  private void updatePosition(){
    leftPosition = drivetrain.getLeftPosition();
    rightPosition = drivetrain.getrigtPosition();
  }

  private int calculateDecelOffset(){
    return 20 * (isTurningRight
      ? (int) ((output - MIN_OUTPUT)/DECLERATION_OUTPUT_PER_PERIOD)
      : (int) ((output + MIN_OUTPUT)/DECLERATION_OUTPUT_PER_PERIOD));
  }
}
