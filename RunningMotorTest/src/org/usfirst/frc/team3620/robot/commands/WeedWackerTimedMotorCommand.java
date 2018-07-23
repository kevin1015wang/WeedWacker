/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
//This program runs when 
package org.usfirst.frc.team3620.robot.commands;
// This program runs when button1 is pressed. Refer to OI.java
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team3620.robot.Robot;
import org.usfirst.frc.team3620.robot.RobotMap;
import org.usfirst.frc.team3620.robot.subsystems.WeedWackerSubsystem;

/**
 * An example command. You can replace me with your own command.
 */
public class WeedWackerTimedMotorCommand extends Command {
	public WeedWackerTimedMotorCommand() {
		// Use requires() here to declare subsystem dependencies
		// What is this?
		requires(Robot.m_subsystem);
	}
	// Creates myTimer variable as new timer.
	Timer myTimer = new Timer();

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		System.out.println(getClass() + " initialized, reset, and started the timer");
		myTimer.reset();
		myTimer.start();

	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		// double position = Robot.m_oi.throttle.getY();
		//Spins motor in -1 direction and speed?
		Robot.m_subsystem.spinWeedWacker(-1);
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		// creates variable elapsedTimer as myTimer.get
		double elapsedTime = myTimer.get();
		// if elapsedTimer is greater than 5 seconds returns true and ends the program. Otherwise returns false and allows program to continue.
		if (Robot.m_subsystem.isFingerPresent()) {
			return true;
		}
		if (elapsedTime >= 5) {
			return true;
		}
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		System.out.println(getClass() + " ended the program");
		// What is with the m_subsystem?
		Robot.m_subsystem.stopWeedWacker();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		System.out.println(getClass() + " interrupted");
		Robot.m_subsystem.stopWeedWacker();
	}
}
