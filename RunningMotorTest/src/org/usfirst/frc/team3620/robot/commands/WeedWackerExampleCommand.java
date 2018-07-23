/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3620.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team3620.robot.Robot;
import org.usfirst.frc.team3620.robot.RobotMap;

/**
 * An example command.  You can replace me with your own command.
 */
public class WeedWackerExampleCommand extends Command {
	public WeedWackerExampleCommand() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.m_subsystem);
	}
	// Creates variable myTimer with a new timer
	Timer myTimer = new Timer();
	
	
	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		// Prints initialized and resets and starts the timer. 
		System.out.println(getClass() + " initialized");
		myTimer.reset();
		myTimer.start();
		
	
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		// Runs after initialized runs and creates variable position and defines it as the Y axis location of joystick.
		System.out.println("Running execute." );
		// Kinda confused here
		double position = Robot.m_oi.throttle.getY();
			Robot.m_subsystem.spinWeedWacker(position);
		}
		
		
		
	
	

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		//Ends the program
		System.out.println(getClass() + " end");
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		//Runs when the program is interrupted.
		System.out.println(getClass() + " interrupted");
	}
}
