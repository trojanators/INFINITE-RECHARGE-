/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.auto.arrays.NearScalePath;
import frc.robot.pathfollower.Trajectory;
import frc.robot.pathfollower.TrajectoryDriveController;
import frc.robot.subsystems.Drivetrain;

public class TestPathCommand extends CommandBase {

  private Drivetrain driveBase;
	private TrajectoryDriveController controller;
	private Trajectory trajectoryLeft;
  private Trajectory trajectoryRight;
  
  public TestPathCommand(Drivetrain drivetrain) {
    // Use addRequirements() here to declare subsystem dependencies.
    System.out.println("Starting TestAuto");
		// Get the left and right trajectories from auto.arrays
		// if the robot is on the blue side, run normally
		this.driveBase = drivetrain;
		trajectoryLeft = NearScalePath.trajectoryArray[0];
		trajectoryRight = NearScalePath.trajectoryArray[1];
		// Create a new TDC controller using the trajectories from 
		controller = new TrajectoryDriveController(trajectoryLeft, trajectoryRight, 1.0, driveBase);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    driveBase.zeroSensors();
		controller.reset();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    controller.update();
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
