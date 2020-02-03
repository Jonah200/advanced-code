/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IndexerSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.PowerCellMovement;
import frc.robot.subsystems.ShooterSubsystem;
//import frc.robot.Constants.DriveConstants;
//import frc.robot.Constants.IntakeConstants;
import frc.robot.Constants.OIConstants;

// Either pass in "Button" or make it static
// Ex:  private void configureButtonBindings(Object Button) {
import static edu.wpi.first.wpilibj.XboxController.Button;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a "declarative" paradigm, very little robot logic should
 * actually be handled in the {@link Robot} periodic methods (other than the
 * scheduler calls). Instead, the structure of the robot (including subsystems,
 * commands, and button mappings) should be declared here.
 */
public class RobotContainer {

  // The robot's subsystems
  private final DriveSubsystem m_robotDrive = new DriveSubsystem();
  private final IntakeSubsystem m_intake = new IntakeSubsystem();
  private final IndexerSubsystem m_index = new IndexerSubsystem();
  private final ShooterSubsystem m_shooter = new ShooterSubsystem();
  private final PowerCellMovement m_powerCell = new PowerCellMovement();

  // The driver's controller
  XboxController m_driverController = new XboxController(OIConstants.kDriverControllerPort);
  XboxController m_operatorController = new XboxController(OIConstants.kOperatorControllerPort);
    private double lastLeftTrigger = 0;
  private double lastRightTrigger = 0;
  private double lastLeftX = 0;
  private double lastLeftY = 0;
  private double lastRightX = 0;
  private double lastRightY = 0;

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  
  public double getTriggerValue(){

    double leftTrigger = m_driverController.getRawAxis(OIConstants.leftTrigger); 
    if (leftTrigger != lastLeftTrigger) {
      System.out.println("leftTrigger changed from " + lastLeftTrigger + " to " + leftTrigger);
      leftTrigger = lastLeftTrigger;
    }
    double rightTrigger = m_driverController.getRawAxis(OIConstants.rightTrigger);
    if (rightTrigger != lastRightTrigger) {
      System.out.println("rightTrigger changed from " + lastRightTrigger + " to " + rightTrigger);
      rightTrigger = lastRightTrigger;
    }
    double leftx = m_driverController.getRawAxis(OIConstants.leftXAxis);
    if (leftx != lastLeftX) {
      System.out.println("leftx changed from " + lastLeftX +  " to " + leftx);
      lastLeftX = leftx;
    }
    double rightx = m_driverController.getRawAxis(OIConstants.rightXAxis);
    if (rightx != lastRightX) {
      System.out.println("rightX changed from " + lastRightX +  " to " + rightx);
      lastRightX = rightx;
    }

    double lefty = m_driverController.getRawAxis(OIConstants.leftYAxis);
    if (lefty != lastLeftY) {
      System.out.println("lefty changed from " + lastLeftY +  " to " + lefty);
      lastLeftY = lefty;
    }
    double righty = m_driverController.getRawAxis(OIConstants.rightYAxis);
    if (righty != lastRightY) {
      System.out.println("rightY changed from " + lastRightY +  " to " + righty);
      lastRightY = righty;
    }
   
    // System.out.println(leftTrigger + ", " + rightTrigger + ", " + leftx + ", " + lefty + ", " + rightx + ", " + righty);
    if(leftTrigger > -1.0){
      return leftTrigger;
    }else{
      return -1 * rightTrigger;
    }
  }
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    // Configure default commands
    // Set the default drive command to split-stick arcade drive
    m_robotDrive.setDefaultCommand(
        // A split-stick arcade command, with forward/backward controlled by the left
        // hand, and turning controlled by the right.
        // Left Y Axis needs to be inverted for driving forward
        new RunCommand(() -> m_robotDrive.arcadeDrive(
          -1 * getTriggerValue(),
          m_driverController.getRawAxis(OIConstants.rightXAxis)), m_robotDrive));
          
          
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by instantiating a {@link GenericHID} or one of its subclasses
   * ({@link edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then
   * passing it to a {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   * 
   * @param Button
   */
  private void configureButtonBindings() {

    // Drive at half speed when the right bumper is held
    /*
    new JoystickButton(m_driverController, Button.kBumperRight.value).whenPressed(() -> m_robotDrive.setMaxOutput(0.5))
        .whenReleased(() -> m_robotDrive.setMaxOutput(1));
    */
    
    // Run the intake & indexer when Right Bumper is held, stop when released
    new JoystickButton(m_operatorController, Button.kBumperRight.value).whenPressed(() -> m_powerCell.enableIntakeAndIndexer())
    .whenReleased(() -> m_powerCell.disable());


    // Runs entire system in reverse when pressing X button
    new JoystickButton(m_operatorController, Button.kX.value).whenPressed(() -> m_powerCell.reverse())
    .whenReleased(() -> m_powerCell.disable());

    // Runs loader when pressing Y button
    new JoystickButton(m_operatorController, Button.kBumperLeft.value).whenPressed(() -> m_shooter.enableLoader())
    .whenReleased(() -> m_shooter.disableLoader());

    //shoots the shooter when pressing the A button
    new JoystickButton(m_operatorController, Button.kA.value).whenPressed(() -> m_shooter.enable())
    .whenReleased(() -> m_shooter.disable());

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    // return m_autoCommand;

    // no auto for now, will be implemented in future builds
    return new InstantCommand();
  }
}
