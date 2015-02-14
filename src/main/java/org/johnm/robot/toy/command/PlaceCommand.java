package org.johnm.robot.toy.command;

import org.johnm.robot.toy.model.Coordinates;
import org.johnm.robot.toy.model.Direction;
import org.johnm.robot.toy.model.ToyRobot;

public class PlaceCommand extends AbstractCommand {
	private final Coordinates coordinates;
	private final Direction directionToFace;
	
	public PlaceCommand(final ToyRobot robot, final Coordinates coordinates, final Direction directionToFace) {
		super(robot);
		
		nullValidator.checkNotNull(coordinates, "Coordinates");
		nullValidator.checkNotNull(directionToFace, "DirectionToFace");
		
		this.coordinates = coordinates;
		this.directionToFace = directionToFace;
	}

	@Override
	public void execute() {
		robot.place(coordinates, directionToFace);
	}
	
}
