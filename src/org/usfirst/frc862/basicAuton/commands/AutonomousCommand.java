// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc862.basicAuton.commands;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc862.basicAuton.Robot;
import org.usfirst.frc862.basicAuton.RobotMap;

/**
 *
 */
public class AutonomousCommand extends Command {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public AutonomousCommand() {

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    
    private Timer timer = new Timer();
    private final static double RAMP_TIME = 5.0;
    private final static double TOP_SPEED = 1.0;
    
    @Override
    public synchronized void start() {
    	this.setTimeout(RAMP_TIME * 2.0);
    	timer.start();
    }
    
    @Override
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
    	if (timer.get() <= RAMP_TIME)
    		rampUp();
    	else
    		rampDown();
    }

	// Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return this.isTimedOut();
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
    	stopMotors();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    	end();
    }
    
    private double speedUp = 0;
    private double speedDown = TOP_SPEED;

    private void rampUp() {
    	RobotMap.driveTrainleftMotor.set(speedUp);
    	RobotMap.driveTrainrightMotor.set(speedUp);
    	speedUp = timer.get() / RAMP_TIME * TOP_SPEED;
		
	}

	private void rampDown() {
		RobotMap.driveTrainleftMotor.set(speedDown);
		RobotMap.driveTrainrightMotor.set(speedDown);
		speedDown = 1 / ((timer.get() - RAMP_TIME) / RAMP_TIME * TOP_SPEED);
		
	}
	
	private void stopMotors() {
		RobotMap.driveTrainleftMotor.set(0);
		RobotMap.driveTrainrightMotor.set(0);
	}
}
