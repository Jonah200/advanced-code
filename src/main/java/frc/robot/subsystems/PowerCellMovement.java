/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.IndexConstants;
import frc.robot.Constants.IntakeConstants;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.Constants.ShooterConstants;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class PowerCellMovement extends SubsystemBase {

  // Create the motor controllers
  private WPI_TalonSRX m_rightIndexer;
  private WPI_TalonSRX m_leftIndexer;
  private WPI_TalonSRX m_talonLowerIntake;
  private WPI_TalonSRX m_talonUpperIntake;
  private CANSparkMax m_leftShooter;
  private CANSparkMax m_rightShooter;
  private WPI_TalonSRX m_loader;
  

  /**
   * Creates a new Intake Subsystem
   */
  public PowerCellMovement() {
    m_rightIndexer = new WPI_TalonSRX(IndexConstants.kRightIndexerMotorPort);
    m_leftIndexer = new WPI_TalonSRX(IndexConstants.kLeftIndexerMotorPort);
    m_talonLowerIntake = new WPI_TalonSRX(IntakeConstants.kLowerIntakeMotorPort);
    m_talonUpperIntake = new WPI_TalonSRX(IntakeConstants.kUpperIntakeMotorPort);
    m_leftShooter = new CANSparkMax(ShooterConstants.kLeftShooter, MotorType.kBrushless); // :)
    m_rightShooter = new CANSparkMax(ShooterConstants.kRightShooter, MotorType.kBrushless); // ;)
    m_loader = new WPI_TalonSRX(IndexConstants.kLoader);

    m_rightShooter.setInverted(true);
    m_leftShooter.setInverted(false);
    m_talonUpperIntake.setInverted(true);
    m_rightIndexer.setInverted(false);
  }

  public void enableEntireSystem(){
    m_talonLowerIntake.set(IntakeConstants.kMaxSpeedPercent);
    m_talonUpperIntake.set(IntakeConstants.kMaxSpeedPercent);
    m_rightIndexer.set(IndexConstants.kRightSpeedPercent);
    m_leftIndexer.set(IndexConstants.kLeftSpeedPercent);
  }

  public void reverse(){
    m_talonLowerIntake.set(IntakeConstants.kMaxSpeedPercent * 1);
    m_talonUpperIntake.set(IntakeConstants.kMaxSpeedPercent * 1);
    m_rightIndexer.set(IndexConstants.kRightSpeedPercent * 1);
    m_leftIndexer.set(IndexConstants.kLeftSpeedPercent * 1);
  }

  public void enableIntakeAndIndexer(){
    m_talonLowerIntake.set(IntakeConstants.kMaxSpeedPercent);
    m_talonUpperIntake.set(IntakeConstants.kMaxSpeedPercent);
    m_rightIndexer.set(IndexConstants.kRightSpeedPercent);
    m_leftIndexer.set(IndexConstants.kLeftSpeedPercent);
  }

  public void disable(){
    m_talonLowerIntake.set(0);
    m_talonUpperIntake.set(0);
    m_rightIndexer.set(0);
    m_leftIndexer.set(0);

  }

  /**
   * Does nothing....
   */
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }


}
