package org.johnm.robot.toy.reporting;

import org.johnm.robot.toy.model.Coordinates;
import org.johnm.robot.toy.model.Direction;

public interface Reporter {
	void report(final Coordinates coordinates, final Direction facing);
}
