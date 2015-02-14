package org.johnm.robot.toy.model;

public class Tabletop {
	private int maxWidthPosition;
	private int maxLengthPosition;
	
	public Tabletop(final int width, final int length) {
		checkNotLessThanOne(width, "Width");
		checkNotLessThanOne(length, "Length");
		
		this.maxWidthPosition = width - 1;
		this.maxLengthPosition = length - 1;
	}

	public boolean isValidPosition(final Coordinates coordinates) {
		if (coordinates.getX() <= maxWidthPosition && coordinates.getX() >= 0 &&
			coordinates.getY() <= maxLengthPosition && coordinates.getY() >= 0) {
			return true;
		}
		
		return false;
	}
	
	private void checkNotLessThanOne(final int field, final String fieldName) {
		if (field < 1) {
			throw new IllegalArgumentException(fieldName + " must be greater than zero");
		}
	}

}
