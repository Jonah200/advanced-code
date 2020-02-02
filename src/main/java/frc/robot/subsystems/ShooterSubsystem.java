/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ShooterConstants;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import frc.robot.Constants.IndexConstants;
import frc.robot.Constants.IntakeConstants;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class ShooterSubsystem extends SubsystemBase {

  // Create the motor controllers
   private  CANSparkMax m_leftShooter;
   private CANSparkMax m_rightShooter;
   private WPI_TalonSRX m_loader;
   

  /**
   * Creates a new Shooter Subsystem
   */
  public ShooterSubsystem() {
    m_leftShooter = new CANSparkMax(ShooterConstants.kLeftShooter, MotorType.kBrushless); // :)
    m_rightShooter = new CANSparkMax(ShooterConstants.kRightShooter, MotorType.kBrushless); // ;)
    m_loader = new WPI_TalonSRX(IndexConstants.kLoader);

  }
  /**
   * Run the shooter
   */
  public void enable() {
    m_leftShooter.set(ShooterConstants.kMaxSpeedPercent);
    m_rightShooter.set(ShooterConstants.kMaxSpeedPercent);
    
  }
  public void enableLoader(){
    m_loader.set(ShooterConstants.kLoaderSpeed);
  }

  public void disableLoader(){
    m_loader.set(0);
  }

  public void reverse() {
    m_leftShooter.set(ShooterConstants.kMaxSpeedPercent * 1);
    m_rightShooter.set(ShooterConstants.kMaxSpeedPercent * 1);
    m_loader.set(IntakeConstants.kMaxSpeedPercent * 1); 
  }
  /**
   * Stop the shooter
   */
  public void disable() {
    m_leftShooter.set(0);
    m_rightShooter.set(0);
    m_loader.set(0);
    
  }

  /**
   * Does nothing....
   */
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }


}