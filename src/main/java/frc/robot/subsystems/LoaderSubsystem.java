/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.LoaderConstants;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;


public class LoaderSubsystem extends SubsystemBase {
  /**
   * Creates a new LoaderSubsystem.
   */

  private WPI_TalonSRX m_loader;

  public LoaderSubsystem() {
    m_loader = new WPI_TalonSRX(LoaderConstants.kLoader); 
  }

  public void enable(){
    m_loader.set(LoaderConstants.kMaxSpeedPercent);
    
  }

  public void reverse(){
    m_loader.set(LoaderConstants.kMaxSpeedPercent * -1);
  }

  public void disable(){
    m_loader.set(0);
  }

  @Override
  public void periodic() {
    
    // This method will be called once per scheduler run
  }
}
