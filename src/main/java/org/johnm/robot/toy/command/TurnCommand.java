package org.johnm.robot.toy.command;

import org.johnm.robot.toy.model.DirectionToTurn;
import org.johnm.robot.toy.model.ToyRobot;

public class TurnCommand extends AbstractCommand {
	private DirectionToTurn directionToTurn;
	
	public TurnCommand(final ToyRobot robot, final DirectionToTurn directionToTurn) {
		super(robot);
		
		nullValidator.checkNotNull(directionToTurn, "DirectionToTurn");
		
		this.directionToTurn = directionToTurn;
	}

	@Override
	public void execute() {
		robot.turn(directionToTurn);
	}
}
