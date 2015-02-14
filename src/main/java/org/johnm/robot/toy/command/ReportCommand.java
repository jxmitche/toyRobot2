package org.johnm.robot.toy.command;

import org.johnm.robot.toy.model.ToyRobot;

public class ReportCommand extends AbstractCommand {
	
	public ReportCommand(final ToyRobot robot) {
		super(robot);
	}

	@Override
	public void execute() {
		robot.report();
	}
}
