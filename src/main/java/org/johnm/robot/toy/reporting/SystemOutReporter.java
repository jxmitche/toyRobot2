package org.johnm.robot.toy.reporting;

import org.johnm.robot.toy.model.Coordinates;
import org.johnm.robot.toy.model.Direction;

public class SystemOutReporter implements Reporter {

	public void report(Coordinates coordinates, Direction facing) {
		System.out.println(coordinates.getX() + "," + coordinates.getY() + "," + facing);
	}

}
