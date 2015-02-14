package org.johnm.robot.toy.command;

import org.johnm.robot.toy.model.ToyRobot;
import org.johnm.robot.toy.validation.NullParamValidator;

public abstract class AbstractCommand implements Command {
	protected ToyRobot robot;
	protected NullParamValidator nullValidator = new NullParamValidator();
	
	public AbstractCommand(final ToyRobot robot) {
		nullValidator.checkNotNull(robot, "Robot");
		
		this.robot = robot;
	}
	
	abstract public void execute();

}
