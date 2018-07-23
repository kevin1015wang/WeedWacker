/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3620.robot;
// creates all buttons on the joystick
import org.usfirst.frc.team3620.robot.commands.WeedWackerTimedMotorCommand;
import org.usfirst.frc.team3620.robot.commands.WeedWackerReverseMotorCommand;
import org.usfirst.frc.team3620.robot.commands.WeedWackerTenTimedMotorCommand;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);
	// Creates Joystick variable named throttle and buttons1 and 2 variable on joystick
	public Joystick throttle;
	public JoystickButton button1, button2, button3;
	
	
	public OI() {
		// Establishes Joystick "throttle" as Joystick on USB port 0
		throttle = new Joystick(0);
		// Defines button 1 as when pressed goes to WeedWackerTimedMotorCommand.java
		button1 = new JoystickButton(throttle, 1);
		button1.whenPressed(new WeedWackerTimedMotorCommand());
		// Defines button 2 as when pressed goes to WeedWackerReverseMotorCommand.java
		button2 = new JoystickButton(throttle, 2);
		button2.whenPressed(new WeedWackerReverseMotorCommand());
		// Defines button 3
		button3 = new JoystickButton(throttle, 3);
		button3.whileHeld(new WeedWackerTenTimedMotorCommand());
		
	}
	
	
	

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
}
