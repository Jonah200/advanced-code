/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;
import frc.robot.subsystems.*;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class LoaderToStage1 extends CommandBase {

  private final PowerCellMovement m_PowerCellMovement;

  public LoaderToStage1(PowerCellMovement subsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_PowerCellMovement = subsystem;
    addRequirements(m_PowerCellMovement);
    
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_PowerCellMovement.enableLoader();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_PowerCellMovement.disable();
    m_PowerCellMovement.stopLoader();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    // checks to see if Bottom beam break is broken
    // may need a filter
    // may need to add a timeout
    return m_PowerCellMovement.isTopTriggered();
  }
}