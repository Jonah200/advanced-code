package frc.robot.subsystems;

//import edu.wpi.first.wpilibj.ADXRS450_Gyro;
//import edu.wpi.first.wpilibj.Encoder;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
//import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;

public class DriveSubsystem extends SubsystemBase {
  // The motors on the left side of the drive.
  private WPI_TalonSRX m_talonLeft1 = new WPI_TalonSRX(DriveConstants.kLeftMotor1Port);
  private WPI_TalonSRX m_talonLeft2 = new WPI_TalonSRX(DriveConstants.kLeftMotor2Port);
                         
  // The motors on the right side of the drive.
  private WPI_TalonSRX m_talonRight1 = new WPI_TalonSRX(DriveConstants.kRightMotor1Port);
  private WPI_TalonSRX m_talonRight2 = new WPI_TalonSRX(DriveConstants.kRightMotor2Port);

  // Group them
  private final SpeedControllerGroup m_leftMotors = new SpeedControllerGroup(m_talonLeft1, m_talonLeft2);
  private final SpeedControllerGroup m_rightMotors = new SpeedControllerGroup(m_talonRight1, m_talonRight2);

  // The robot's drive
  private final DifferentialDrive m_drive = new DifferentialDrive(m_leftMotors, m_rightMotors);

  /*
  // The left-side drive encoder
  private final Encoder m_leftEncoder =
      new Encoder(DriveConstants.kLeftEncoderPorts[0], DriveConstants.kLeftEncoderPorts[1],
                  DriveConstants.kLeftEncoderReversed);

  // The right-side drive encoder
  private final Encoder m_rightEncoder =
      new Encoder(DriveConstants.kRightEncoderPorts[0], DriveConstants.kRightEncoderPorts[1],
                  DriveConstants.kRightEncoderReversed);

  // The gyro sensor
  //private final Gyro m_gyro = new ADXRS450_Gyro();
  */

  /**
   * Creates a new DriveSubsystem.
   */
  public DriveSubsystem() {
    // Sets the distance per pulse for the encoders
    //m_leftEncoder.setDistancePerPulse(DriveConstants.kEncoderDistancePerPulse);
    //m_rightEncoder.setDistancePerPulse(DriveConstants.kEncoderDistancePerPulse);

    m_talonLeft2.follow(m_talonLeft1);
    m_talonRight2.follow(m_talonRight1);

    // Practice bot is wired and mounted in a way where nothing is inverted
    // Left Axis of joystick response needs to be inverted though

    // Wooooah there - Chad implemented this for speed control on initial testing
    setMaxOutput(DriveConstants.kMaxSpeedPercent);
  }

  /**
   * Drives the robot using arcade controls.
   *
   * @param fwd the commanded forward movement
   * @param rot the commanded rotation
   */
  public void arcadeDrive(double fwd, double rot) {
    // speed limiting accomplished in Constructor
    m_drive.arcadeDrive(fwd, rot);
  }

  /**
   * Resets the drive encoders to currently read a position of 0.
   */
/*
   public void resetEncoders() {
    //m_leftEncoder.reset();
    //m_rightEncoder.reset();
  }
*/
  /**
   * Gets the average distance of the two encoders.
   *
   * @return the average of the two encoder readings
   */
  /*
  public double getAverageEncoderDistance() {
    return (m_leftEncoder.getDistance() + m_rightEncoder.getDistance()) / 2.0;
  }
*/

  /**
   * Gets the left drive encoder.
   *
   * @return the left drive encoder
   */
/*
   public Encoder getLeftEncoder() {
    return m_leftEncoder;
  }
*/
  /**
   * Gets the right drive encoder.
   *
   * @return the right drive encoder
   */
  /*
  public Encoder getRightEncoder() {
    return m_rightEncoder;
  }
*/

  /**
   * Sets the max output of the drive.  Useful for scaling the drive to drive more slowly.
   *
   * @param maxOutput the maximum output to which the drive will be constrained
   */
  public void setMaxOutput(double maxOutput) {
    m_drive.setMaxOutput(maxOutput);
  }

  /**
   * Zeroes the heading of the robot.
   */
  /*
  public void zeroHeading() {
    m_gyro.reset();
  }
  */

  /**
   * Returns the heading of the robot.
   *
   * @return the robot's heading in degrees, from 180 to 180
   */
  /*
  public double getHeading() {
    return Math.IEEEremainder(m_gyro.getAngle(), 360) * (DriveConstants.kGyroReversed ? -1.0 : 1.0);
  }
*/
  /**
   * Returns the turn rate of the robot.
   *
   * @return The turn rate of the robot, in degrees per second
   */
  /*
  public double getTurnRate() {
    return m_gyro.getRate() * (DriveConstants.kGyroReversed ? -1.0 : 1.0);
  }
  */
}