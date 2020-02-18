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
import frc.robot.subsystems.*;
import frc.robot.Constants.*;
import frc.robot.commands.*;


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
  //private final ShooterSubsystem m_shooter = new ShooterSubsystem();
  private final PowerCellMovement m_powerCell = new PowerCellMovement();
  private final LoaderSubsystem m_loader = new LoaderSubsystem();
  private final ShooterPID m_rightShooterPID = new ShooterPID(ShooterConstants.kRightShooter,"Right Shooter");
  private final ShooterPID m_leftShooterPID = new ShooterPID(ShooterConstants.kLeftShooter,"Left Shooter");


  // The driver's controller
  XboxController m_driverController = new XboxController(OIConstants.kDriverControllerPort);
  XboxController m_operatorController = new XboxController(OIConstants.kOperatorControllerPort);

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
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
          -1 * m_operatorController.getRawAxis(OIConstants.leftYAxis),
          m_operatorController.getRawAxis(OIConstants.rightXAxis)), m_robotDrive));
          
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

    /**
     * DRIVER CONTROLLER BINDINGS
     */
    // starts the test drive after pressed y button
    //new JoystickButton(m_driverController, Button.kY.value).whenHeld(new Reverse(m_robotDrive));  // this works
    //new JoystickButton(m_driverController, Button.kY.value).whenHeld(new TestDrive(m_robotDrive));  // this also works


    /**
     * OPERATOR CONTROLLER BINDINGS
     */
    //make button to do fullsendpowercells maybe while loop?

    // left bumper intake balls
    new JoystickButton(m_operatorController, Button.kBumperLeft.value).whenPressed(() -> m_powerCell.enableIntakeAndIndexer())
    .whenReleased(() -> m_powerCell.disable());

    
    // A button reverse balls
    new JoystickButton(m_operatorController, Button.kA.value).whenPressed(() -> m_powerCell.reverseEntireSystem())
    .whenReleased(() -> m_powerCell.disable());

    // right bumper moves loader
    new JoystickButton(m_operatorController, Button.kBumperRight.value).whenPressed(() -> m_loader.enable())
    .whenReleased(() -> m_loader.disable());

    // shooter moves on B button
    /*
    new JoystickButton(m_operatorController, Button.kY.value).whenPressed(() -> m_shooterPID.runShooterMax())
    .whenReleased(() -> m_shooterPID.stopShooter());

    new JoystickButton(m_driverController, Button.kB.value).whenPressed(new InstantCommand(m_shooterPID::enable, m_shooterPID))
    .whenReleased(new InstantCommand(m_shooterPID::disable, m_shooterPID));
    */

    new JoystickButton(m_operatorController, Button.kB.value).whenHeld(new RunShooter(m_leftShooterPID, m_rightShooterPID));
    
    // Turn off the shooter when the 'B' button is pressed
    //new JoystickButton(m_driverController, Button.kB.value)
    //    .whenPressed(new InstantCommand(m_shooter::disable, m_shooter));

// AUTOMATION TESTING

    // runs BallToStage1 when X button is pressed
    new JoystickButton(m_operatorController, Button.kX.value).whenHeld(new BallToStage1(m_powerCell));

    // runs LoaderToStage1 when Y is pressed
    //new JoystickButton(m_operatorController, Button.kY.value).whenHeld(new LoaderToStage1(m_powerCell));
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
