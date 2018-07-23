/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3620.robot.commands;
//This program runs when button2 is pressed. Refer to OI.java
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team3620.robot.Robot;
import org.usfirst.frc.team3620.robot.RobotMap;
import org.usfirst.frc.team3620.robot.subsystems.WeedWackerSubsystem;

/**
 * An example command.  You can replace me with your own command.
 */
public class WeedWackerReverseMotorCommand extends Command {
	WeedWackerSubsystem mySubsystem = Robot.m_subsystem;
	public WeedWackerReverseMotorCommand() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.m_subsystem);
	}
	// Creates myTimer variable as new timer.
	Timer myTimer = new Timer();
	
	
	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		System.out.println(getClass() + " initialized, reset, and started the timer.");
		myTimer.reset();
		myTimer.start();
		
	
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		//double position = Robot.m_oi.throttle.getY();
		//Spins motor in 1 direction and speed?
		mySubsystem.spinWeedWacker(1);
		}
		
		
		
	
	

	// Make this return true when this Command no longer needs to run execute()
	@Override
	// creates isFinished method
	protected boolean isFinished() {
		// creates variable elapsedTimer as myTimer.get
		double elapsedTime = myTimer.get();
		// Refer to Subsystem java program.
		// if isFingerPresent is true returns true
		// Don't really get this. do I refer to the subsystem as (mySubsystem)?
		if (mySubsystem.isFingerPresent()) {
			return true;
		}
		
		// Below code runs if isFingerPresent is false
		// if elapsedTimer is greater than and equal to 5, then returns true
		if(elapsedTime >= 5)
		{
			// if the more than or exactly 5 seconds has passed then 
			// return true to isFinished method.
			return true;
		}
		// otherwise return false
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		//Ends the program
		System.out.println(getClass() + " end");
		// refer to mySubsystem for method of stopWeedWacker
		mySubsystem.stopWeedWacker();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		//Runs when the program is interrupted.
		System.out.println(getClass() + " interrupted");
		// refer to mySubsystem for method of stopWeedWacker
		mySubsystem.stopWeedWacker();
	}
}
