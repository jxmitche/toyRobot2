package org.johnm.robot.toy.model;

import org.johnm.robot.toy.validation.NullParamValidator;

public class Turning {
	private NullParamValidator nullValidator = new NullParamValidator();

	public Direction turn(final Direction currentDirection, final DirectionToTurn directionToTurn) {
		nullValidator.checkNotNull(currentDirection, "CurrentDirection");
		nullValidator.checkNotNull(directionToTurn, "DirectionToTurn");
		
		if (directionToTurn.equals(DirectionToTurn.LEFT)) {
			return turnLeft(currentDirection);
		} else if (directionToTurn.equals(DirectionToTurn.RIGHT)) {
			return turnRight(currentDirection);
		} else {
			throw new IllegalArgumentException("Unknown Direction To Turn" + directionToTurn);
		}
	}
	
	Direction turnLeft(final Direction currentDirection) {
		if (currentDirection.equals(Direction.NORTH)) {
			return Direction.WEST;
		} else if (currentDirection.equals(Direction.SOUTH)) {
			return Direction.EAST;
		} else if (currentDirection.equals(Direction.EAST)) {
			return Direction.NORTH;
		} else if (currentDirection.equals(Direction.WEST)) {
			return Direction.SOUTH;
		} else {
			throw new IllegalArgumentException("Unknown Direction" + currentDirection);
		}
	}
	
	Direction turnRight(final Direction currentDirection) {
		if (currentDirection.equals(Direction.NORTH)) {
			return Direction.EAST;
		} else if (currentDirection.equals(Direction.SOUTH)) {
			return Direction.WEST;
		} else if (currentDirection.equals(Direction.EAST)) {
			return Direction.SOUTH;
		} else if (currentDirection.equals(Direction.WEST)) {
			return Direction.NORTH;
		} else {
			throw new IllegalArgumentException("Unknown Direction" + currentDirection);
		}
	}
}
