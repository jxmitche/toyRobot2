package org.johnm.robot.toy.model;

import org.johnm.robot.toy.reporting.Reporter;
import org.johnm.robot.toy.validation.NullParamValidator;

public class ToyRobot {
	private Tabletop tabletop;
	private Reporter reporter;
	private Coordinates currentPosition;
	private Direction facing;
	private Turning turning;
	private Moving moving;
	private NullParamValidator nullValidator = new NullParamValidator();
	
	
	public ToyRobot(final Tabletop tabletop, final Reporter reporter) {
		nullValidator.checkNotNull(tabletop, "Tabletop");
		nullValidator.checkNotNull(reporter, "Reporter");

		this.tabletop = tabletop;
		this.reporter = reporter;
		this.turning = new Turning();
		this.moving = new Moving();
	}
	
	public void place(final Coordinates coordinates, final Direction directionToFace) {
		nullValidator.checkNotNull(coordinates, "Coordinates");
		nullValidator.checkNotNull(directionToFace, "DirectionToFace");
		
		if (tabletop.isValidPosition(coordinates)) {
			currentPosition = coordinates;
			facing = directionToFace;
		}
	}
	
	public void move() {
		if (!ignoreCommand()) {
			final Coordinates newPosition = moving.moveOneSquare(currentPosition, facing);
			
			if (tabletop.isValidPosition(newPosition)) {
				currentPosition = newPosition;
			}
		}
	}
	
	public void turn(final DirectionToTurn directionToTurn) {
		nullValidator.checkNotNull(directionToTurn, "DirectionToTurn");
		
		if (!ignoreCommand()) {
			facing = turning.turn(facing, directionToTurn);
		}
	}
	
	public void report() {
		if (!ignoreCommand()) {
			reporter.report(currentPosition, facing);
		}
	}
	
	Coordinates getCurrentPosition() {
		return currentPosition;
	}

	Direction getFacing() {
		return facing;
	}

	private boolean ignoreCommand() {
		if (currentPosition == null) {
			return true;
		}
		
		return false;
	}
}
