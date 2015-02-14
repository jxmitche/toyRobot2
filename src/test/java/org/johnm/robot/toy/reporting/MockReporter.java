package org.johnm.robot.toy.reporting;

import org.johnm.robot.toy.model.Coordinates;
import org.johnm.robot.toy.model.Direction;

public class MockReporter implements Reporter {
	public Coordinates coordinates;
	public Direction facing;
	
	public void report(Coordinates coordinates, Direction facing) {
		this.coordinates = coordinates;
		this.facing = facing;
	}
}
