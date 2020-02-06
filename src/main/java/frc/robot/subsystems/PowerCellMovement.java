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
import frc.robot.Constants.LoaderConstants;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class PowerCellMovement extends SubsystemBase {

  // Create the motor controllers
  private WPI_TalonSRX m_rightIndexer;
  private WPI_TalonSRX m_leftIndexer;
  private WPI_TalonSRX m_talonLowerIntake;
  private WPI_TalonSRX m_talonUpperIntake;
  private WPI_TalonSRX m_loader;

  // create beam breaks
  private DigitalInput m_trasmitterBottom;
  private DigitalInput m_receiverBottom;
  private DigitalInput m_trasmitterTop;
  private DigitalInput m_receiverTop;
  /**
   * Creates a new Power cell mov
   */
  public PowerCellMovement() {
    // adding talons
    m_rightIndexer = new WPI_TalonSRX(IndexConstants.kRightIndexerMotorPort);
    m_leftIndexer = new WPI_TalonSRX(IndexConstants.kLeftIndexerMotorPort);
    m_talonLowerIntake = new WPI_TalonSRX(IntakeConstants.kLowerIntakeMotorPort);
    m_talonUpperIntake = new WPI_TalonSRX(IntakeConstants.kUpperIntakeMotorPort);
    m_loader = new WPI_TalonSRX(LoaderConstants.kLoader);
    // beam breaks 
    m_trasmitterBottom = new DigitalInput(0);
    m_receiverBottom = new DigitalInput(1);
    m_trasmitterTop = new DigitalInput(3);
    m_receiverTop = new DigitalInput(2);

   // inversing talons
    m_talonUpperIntake.setInverted(true);
    m_rightIndexer.setInverted(false);

  }

  public void enableEntireSystem(){
    m_talonLowerIntake.set(IntakeConstants.kMaxSpeedPercent);
    m_talonUpperIntake.set(IntakeConstants.kMaxSpeedPercent);
    m_rightIndexer.set(IndexConstants.kRightSpeedPercent);
    m_leftIndexer.set(IndexConstants.kLeftSpeedPercent);
    m_loader.set(LoaderConstants.kMaxSpeedPercent);
  }

  public void reverseEntireSystem(){
    m_talonLowerIntake.set(IntakeConstants.kMaxSpeedPercent * -1);
    m_talonUpperIntake.set(IntakeConstants.kMaxSpeedPercent * -1);
    m_rightIndexer.set(IndexConstants.kRightSpeedPercent * -1);
    m_leftIndexer.set(IndexConstants.kLeftSpeedPercent * -1);
    m_loader.set(LoaderConstants.kMaxSpeedPercent * -1);
  }

  public void enableIntakeAndIndexer(){
    m_talonLowerIntake.set(IntakeConstants.kMaxSpeedPercent);
    m_talonUpperIntake.set(IntakeConstants.kMaxSpeedPercent);
    m_rightIndexer.set(IndexConstants.kRightSpeedPercent);
    m_leftIndexer.set(IndexConstants.kLeftSpeedPercent);
    m_loader.set(0);
  }

  public void reverseIntakeAndIndexer(){
    m_talonLowerIntake.set(IntakeConstants.kMaxSpeedPercent * -1);
    m_talonUpperIntake.set(IntakeConstants.kMaxSpeedPercent * -1);
    m_rightIndexer.set(IndexConstants.kRightSpeedPercent * -1);
    m_leftIndexer.set(IndexConstants.kLeftSpeedPercent * -1);
    m_loader.set(0);
  }

  public void enableLoader(){
    m_loader.set(LoaderConstants.kMaxSpeedPercent);
  }

  public void disable(){
    m_talonLowerIntake.set(0);
    m_talonUpperIntake.set(0);
    m_rightIndexer.set(0);
    m_leftIndexer.set(0);
    m_loader.set(0);
  }

  public boolean isBottomTriggered(){
    // .get() returns true when the beam is complete
    return !(m_receiverBottom.get());
  }

  public boolean isTopTriggered(){
    // .get() returns true when the beam is complete
    return !(m_receiverTop.get());
  }

  /**
   * Does nothing....
   */
  @Override
  public void periodic() {
    SmartDashboard.putBoolean("emitter Bottom", m_trasmitterBottom.get());
    SmartDashboard.putBoolean("receiver Bottom", m_receiverBottom.get());
    SmartDashboard.putBoolean("emitter Top", m_trasmitterTop.get());
    SmartDashboard.putBoolean("receiver Top", m_receiverTop.get());
    // This method will be called once per scheduler run
  }


}
