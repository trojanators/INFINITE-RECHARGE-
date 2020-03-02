/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;

public class RunIntake extends CommandBase {

  private Intake intake;  
  
  /**
   * Creates a new RunIntake.
   */
  public RunIntake(Intake m_Intake) {
    // Use addRequirements() here to declare subsystem dependencies.
    intake = m_Intake;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

   DriverStation.reportError("Intake Command running", true);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    intake.setIntakePower(.65);
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
