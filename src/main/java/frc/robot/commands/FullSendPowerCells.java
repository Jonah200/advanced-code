/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.LoaderSubsystem;
import frc.robot.subsystems.PowerCellMovement;
import frc.robot.subsystems.ShooterPID;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class FullSendPowerCells extends SequentialCommandGroup {

  // runs BallToStage1 then LoaderToStage1 then LoaderToShooter then Everything until all balls have exited

  /**
   * Creates a new FullSendPowerCells.
   */
  
   /*
  private BallToStage1 m_BallToStage1;
  private Everything m_Everything;
  private LoaderToShooter m_LoaderToShooter;
  private LoaderToStage1 m_LoaderToStage1;*/

  public FullSendPowerCells(PowerCellMovement move, LoaderSubsystem loader, ShooterPID shooter) {
    // Add your commands in the super() call, e.g.
    // super(new FooCommand(), new BarCommand());
    
    super(
      new BallToStage1(move), 
      new LoaderToStage1(move), 
      //new LoaderToShooter(move, shooter), 
      new Everything(move, loader, shooter)
      );
  }

}