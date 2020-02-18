/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.LoaderSubsystem;
import frc.robot.subsystems.PowerCellMovement;

public class FullSend extends CommandBase {

  // can probably be deleted once FullSendPowerCells works
  
  private final PowerCellMovement m_PowerCellMovement;
  private final LoaderSubsystem m_LoaderSubsystem;
  /**
   * Creates a new FullSend.
   */
  public FullSend(PowerCellMovement subsystem, LoaderSubsystem subsystem2) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_PowerCellMovement = subsystem;
    addRequirements(m_PowerCellMovement);
    m_LoaderSubsystem = subsystem2;
    addRequirements(m_LoaderSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}