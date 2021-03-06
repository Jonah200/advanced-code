/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.ballmovement;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.Constants.HoodedShooterConstants;
import frc.robot.subsystems.AdjustableHoodSubsystem;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class HoodPID extends PIDCommand {
  /**
   * Creates a new HoodPID.
   */
  private AdjustableHoodSubsystem m_adjHoodSub;
  public HoodPID(AdjustableHoodSubsystem subsystem, int targetClicks) {
    super(
      // The controller that the command will use
      new PIDController(HoodedShooterConstants.kP, HoodedShooterConstants.kI, HoodedShooterConstants.kP),
      // This should return the measurement
      subsystem::getEncoderPos,
      // This should return the setpoint (can also be a constant)
      targetClicks,
      // This uses the output
      output -> subsystem.setMotorVelo(output),
      subsystem
    );
    getController().setTolerance(HoodedShooterConstants.positionTolerance);
      // Use addRequirements() here to declare subsystem dependencies.
      // Configure additional PID options by calling `getController` here.
      m_adjHoodSub = subsystem;
      addRequirements(m_adjHoodSub);
    }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return getController().atSetpoint();
  }
}
