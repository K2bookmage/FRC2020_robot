package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Vision extends SubsystemBase {
  
  public static final NetworkTableInstance inst = NetworkTableInstance.getDefault();
  public static final NetworkTable limelight = inst.getTable("limelight");
  
  public enum Entry{
    HORIZONTAL_OFFSET ("tx", "Vision X"),
    VERTICAL_OFFSET ("ty", "Vision Y"),
    SKEW ("ts", "Vision Skew"),
    AREA ("ta", "Vision Area"),
    VALID_TARGETS ("tv", "Vision Valid Target"),
    LATENCY ("tl", "Vision Latency"),
    HORIZONTAL_LENGTH ("thor", "Vision Horizontal Length"),
    VERTICAL_LENGTH ("tvert", "Vision Vertical Length");

    private final String label;
    private final NetworkTableEntry entry;
    private double value;

    Entry(String entryName, String entryLabel){
      label = entryLabel;
      entry = limelight.getEntry(entryName);
    }

    public void readValue(){
      value = entry.getDouble(0);
    }

    public double getValue(){
      return value;
    }

  }

  public Vision() {

  }

  @Override
  public void periodic() {
  
    for(Entry entry:Entry.values()){
      entry.readValue();
    }
  }

  public double getAsDouble(){
    return hasValidTargets()?Entry.HORIZONTAL_OFFSET.getValue():0.0;
  }

  public boolean hasValidTargets(){
    return Entry.VALID_TARGETS.getValue()>0.5;
  }

  public void turnOnCamLeds(){
    limelight.getEntry("ledMode").setNumber(3);
  }

  public void turnOffCamLeds(){
    limelight.getEntry("ledMode").setNumber(1);
  }

  public void setVisionMode(){
    limelight.getEntry("camMode").setNumber(0);
  }

  public void setCameraMode(){
    limelight.getEntry("camMode").setNumber(1);
  }


  public double getDistanceFromArea(){
    return 76.48/Math.sqrt(Entry.AREA.getValue());
  }
  
  public double getDistanceFromHorizontal(){
    return 20/Entry.HORIZONTAL_LENGTH.getValue();
  }

  public double getDistanceFromVertical(){
    return 18/Entry.VERTICAL.LENGTH.getValue();
  }

}
