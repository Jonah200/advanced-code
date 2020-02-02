/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.IntakeConstants;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class IntakeSubsystem extends SubsystemBase {

  // Create the motor controllers
  private WPI_TalonSRX m_talonLowerIntake;
  private WPI_TalonSRX m_talonUpperIntake;

  /**
   * Creates a new Intake Subsystem
   */
  public IntakeSubsystem() {
    m_talonLowerIntake = new WPI_TalonSRX(IntakeConstants.kLowerIntakeMotorPort);
    m_talonUpperIntake = new WPI_TalonSRX(IntakeConstants.kUpperIntakeMotorPort);
    // Upper talon needs to be reveresed, artifact of mounting orientation
    m_talonUpperIntake.setInverted(true);
  }

  /**
   * Run the intake
   */
  public void enable() {
    m_talonLowerIntake.set(IntakeConstants.kMaxSpeedPercent);
    m_talonUpperIntake.set(IntakeConstants.kMaxSpeedPercent);
  }

  /**
   * Reverse the intake
   */
  public void reverse() {
    m_talonLowerIntake.set(-1 * IntakeConstants.kMaxSpeedPercent);
    m_talonUpperIntake.set(-1 * IntakeConstants.kMaxSpeedPercent);
  }

  /**
   * Stop the intake
   */
  public void disable() {
    m_talonLowerIntake.set(0);
    m_talonUpperIntake.set(0);
  }

  /**
   * Does nothing....
   */
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }


}
