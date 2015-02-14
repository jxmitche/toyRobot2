package org.johnm.robot.toy.command;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import org.johnm.robot.toy.model.Coordinates;
import org.johnm.robot.toy.model.Direction;
import org.johnm.robot.toy.model.Tabletop;
import org.johnm.robot.toy.model.ToyRobot;
import org.johnm.robot.toy.reporting.MockReporter;

public class ReportCommandTest {
	private Command reportCommand;
	private ToyRobot robot;
	private Tabletop tabletop;
	private MockReporter reporter;
	private Coordinates currentPosition;
	private Direction facing;
	
	@Before
	public void setup() {
		tabletop = new Tabletop(5,5);
		reporter = new MockReporter();
		robot = new ToyRobot(tabletop, reporter);
		reportCommand = new ReportCommand(robot);
		currentPosition = new Coordinates(1,2);
		facing = Direction.EAST;
		robot.place(currentPosition, facing);
	}
	
	@Test
	public void check_report() {
		reportCommand.execute();
		
		assertEquals(1, reporter.coordinates.getX());
		assertEquals(2, reporter.coordinates.getY());
		assertEquals(Direction.EAST, reporter.facing);
	}
	
	@Test
	public void check_NullRobot() {
		try {
			new ReportCommand(null);
			fail("should not reach here");
		} catch (IllegalArgumentException ex) {
			assertEquals("Robot must not be null", ex.getMessage());
		}
	}
}
