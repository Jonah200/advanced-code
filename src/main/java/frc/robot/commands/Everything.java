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
import frc.robot.subsystems.ShooterPID;

public class Everything extends CommandBase {
  /**
   * Creates a new Everything.
   */

   //runs everything to get all the balls out of the robot

  private final PowerCellMovement m_PowerCellMovement;
  private final LoaderSubsystem m_LoaderSubsystem;
  private final ShooterPID m_shooterPID;
  
  public Everything(PowerCellMovement subsystem, LoaderSubsystem subsystem2, ShooterPID subsystem3) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_PowerCellMovement = subsystem;
    addRequirements(m_PowerCellMovement);

    m_LoaderSubsystem = subsystem2;
    addRequirements(m_LoaderSubsystem);

    m_shooterPID = subsystem3;
    addRequirements(m_shooterPID);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_PowerCellMovement.enableEntireSystem();
    m_LoaderSubsystem.enable();
    m_shooterPID.enable();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_PowerCellMovement.disable();
    m_LoaderSubsystem.disable();
    m_shooterPID.disable();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    // finished when button is released 
    return true; //TODO still needs to be added this is just a place holder
  }
}
