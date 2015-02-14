package org.johnm.robot.toy.command;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import org.johnm.robot.toy.model.Tabletop;
import org.johnm.robot.toy.model.ToyRobot;
import org.johnm.robot.toy.reporting.MockReporter;

public class CommandCreatorTest {
	private CommandCreator creator;
	private ToyRobot robot;
	private Tabletop tabletop;
	private MockReporter reporter;
	
	@Before
	public void setup() {
		tabletop = new Tabletop(5,5);
		reporter = new MockReporter();
		robot = new ToyRobot(tabletop, reporter);
		creator = new CommandCreator(robot);
	}
	
	@Test
	public void check_Move() {
		final Command cmd = creator.createCommand("MOVE");
		assertTrue(cmd instanceof MoveCommand);
	}
	
	@Test
	public void check_Left() {
		final Command cmd = creator.createCommand("LEFT");
		assertTrue(cmd instanceof TurnCommand);
	}
	
	@Test
	public void check_right() {
		final Command cmd = creator.createCommand("RIGHT");
		assertTrue(cmd instanceof TurnCommand);
	}
	
	@Test
	public void check_report() {
		final Command cmd = creator.createCommand("REPORT");
		assertTrue(cmd instanceof ReportCommand);
	}
	
	@Test
	public void check_PlaceNorth() {
		final Command cmd = creator.createCommand("PLACE 1,2,NORTH");
		assertTrue(cmd instanceof PlaceCommand);
	}
	
	@Test
	public void check_PlaceSouth() {
		final Command cmd = creator.createCommand("PLACE 1,2,SOUTH");
		assertTrue(cmd instanceof PlaceCommand);
	}
	
	@Test
	public void check_PlaceEast() {
		final Command cmd = creator.createCommand("PLACE 1,2,EAST");
		assertTrue(cmd instanceof PlaceCommand);
	}
	
	@Test
	public void check_PlaceWest() {
		final Command cmd = creator.createCommand("PLACE 1,2,WEST");
		assertTrue(cmd instanceof PlaceCommand);
	}
}
