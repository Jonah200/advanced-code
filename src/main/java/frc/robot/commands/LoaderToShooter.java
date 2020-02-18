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

public class LoaderToShooter extends CommandBase {
  // brings the ball from the loader to the 
  /**
   * Creates a new LoaderToShooter.
   */
  private final PowerCellMovement m_PowerCellMovement;
  private final LoaderSubsystem m_LoaderSubsystem;

  public LoaderToShooter(PowerCellMovement subsystem, LoaderSubsystem subsystem2) {
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
    m_LoaderSubsystem.enable();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_PowerCellMovement.disable();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return m_PowerCellMovement.isShooterBeamTriggered();
  }
}
