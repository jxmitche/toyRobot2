package org.johnm.robot.toy.model;

import org.johnm.robot.toy.validation.NullParamValidator;

public class Moving {
	private NullParamValidator nullValidator = new NullParamValidator();
	
	public Coordinates moveOneSquare(final Coordinates currentPosition, final Direction facing) {
		nullValidator.checkNotNull(currentPosition, "CurrentPosition");
		nullValidator.checkNotNull(facing, "Facing");
		
		final int currentX = currentPosition.getX();
		final int currentY = currentPosition.getY();
		
		if (facing.equals(Direction.NORTH)) {
			return new Coordinates(currentX, currentY + 1);
		} else if (facing.equals(Direction.SOUTH)) {
			return new Coordinates(currentX, currentY - 1);
		} else if (facing.equals(Direction.WEST)) {
			return new Coordinates(currentX - 1, currentY);
		} else if (facing.equals(Direction.EAST)) {
			return new Coordinates(currentX + 1, currentY);
		} else {
			throw new IllegalArgumentException("Unknown Direction" + facing);
		}
	}
}
