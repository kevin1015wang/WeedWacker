/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3620.robot.subsystems;

import org.usfirst.frc.team3620.robot.RobotMap;
import org.usfirst.frc.team3620.robot.commands.WeedWackerExampleCommand;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
// What is "extends?" Isn't this the Subsystem?
public class WeedWackerSubsystem extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
		// Default Commands is WeedWackerExampleCommand.java
		setDefaultCommand(new WeedWackerExampleCommand());
	}
	// Creates lastSpeed variable and sets at 0.0
	double lastSpeed = 0.0;
	// Creates lastFinger variable and sets as false
	boolean lastFinger = false;
	// Creates method spinWeedWacker? Takes speed variable?
	public void spinWeedWacker (double speed) {
		// Creates finger variable and sets as "isFingerPresent()" where did that come from?
		boolean finger = isFingerPresent();
		// if finger variable and opposite of lastFinger variable are TRUE then prints out "finger!"
		if (finger && ! lastFinger) {
			System.out.println("finger! Get away!");
		}
		// Sets lastFinger as finger variable
		lastFinger = finger;
		// if finger is true, then set speed as 0
		if (finger) {
			speed = 0;
		}
		// if speed variable isn't equal to lastSpeed variable then print the line below
		if (speed != lastSpeed) {
			System.out.println("speed changed from " + lastSpeed + " to " + speed);
			// sets lastSpeed variable as speed variable
			lastSpeed = speed;
		}
		// Don't understand this line.
		RobotMap.myMotor.set(speed);
	}
	
	public void stopWeedWacker() {
		// method of stopWeedwacker which sets spinWeedWacker method as 0
		spinWeedWacker(0);
	}
	
	public boolean isFingerPresent() {
		// creates rv variable and sets as the voltage from the (myAI) as long as it is less than 0.5
		// goes to RobotMap, consults myAI and apparently gets voltage reading from the sensor.
		boolean rv = RobotMap.myAI.getVoltage() < 0.5;
		// returns rv variable
		return rv;
	}
	
}
