package org.johnm.robot.toy.command;

import org.johnm.robot.toy.model.ToyRobot;

public class MoveCommand extends AbstractCommand {
	
	public MoveCommand(final ToyRobot robot) {
		super(robot);
	}
	
	@Override
	public void execute() {
		robot.move();
	}
}
