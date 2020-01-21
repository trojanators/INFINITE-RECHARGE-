/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Climb extends SubsystemBase {

  /**
   * -elevator goes up -winch pulls robot up by rope
   */

  private final WPI_TalonFX climbFx = new WPI_TalonFX(Constants.FxClimbCAN);
  private final VictorSP liftSp = new VictorSP(Constants.HookControl);

  public Climb() {

  }

  public void setRobotRaise(Double ClimbSpeed, Double LiftSpeed) {
    setClimePower(ClimbSpeed);
    setLiftPower(LiftSpeed);
  }

  public void setClimePower(Double ClimbSpeed) {
    climbFx.set(ClimbSpeed);

    setClimbSpeed(ClimbSpeed);
    setLiftSpeed(LiftSpeed);
  }

  public void setLiftPower(Double LiftSpeed) {
    liftSp.set(LiftSpeed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run

  }
}
