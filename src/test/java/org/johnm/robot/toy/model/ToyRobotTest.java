package org.johnm.robot.toy.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import org.johnm.robot.toy.reporting.MockReporter;

public class ToyRobotTest {
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
		currentPosition = new Coordinates(1,2);
		facing = Direction.EAST;
	}
	
	@Test
	public void check_NullTabletop() {
		try {
			new ToyRobot(null, reporter);
			fail("should not reach here");
		} catch (IllegalArgumentException ex) {
			assertEquals("Tabletop must not be null", ex.getMessage());
		}
	}
	
	@Test
	public void check_NullReport() {
		try {
			new ToyRobot(tabletop, null);
			fail("should not reach here");
		} catch (IllegalArgumentException ex) {
			assertEquals("Reporter must not be null", ex.getMessage());
		}
	}
	
	@Test
	public void check_NullCoordinates() {
		try {
			robot.place(null, facing);
			fail("should not reach here");
		} catch (IllegalArgumentException ex) {
			assertEquals("Coordinates must not be null", ex.getMessage());
		}
	}
	
	@Test
	public void check_NullDirection() {
		try {
			robot.place(currentPosition, null);
			fail("should not reach here");
		} catch (IllegalArgumentException ex) {
			assertEquals("DirectionToFace must not be null", ex.getMessage());
		}
	}
	
	@Test
	public void check_NullTurn() {
		try {
			robot.turn(null);
			fail("should not reach here");
		} catch (IllegalArgumentException ex) {
			assertEquals("DirectionToTurn must not be null", ex.getMessage());
		}
	}
	
	@Test
	public void check_PlaceInvalidCoordsNegative() {
		robot.place(currentPosition, facing);
		checkRobotNotMoved();
		
		currentPosition = new Coordinates(-1,-2);
		robot.place(currentPosition, facing);
		checkRobotNotMoved();
	}
	
	@Test
	public void check_PlaceInvalidCoordsNegativeX() {
		robot.place(currentPosition, facing);
		checkRobotNotMoved();
		
		currentPosition = new Coordinates(-1,2);
		robot.place(currentPosition, facing);
		checkRobotNotMoved();
	}
	
	@Test
	public void check_PlaceInvalidCoordsNegativeY() {
		robot.place(currentPosition, facing);
		checkRobotNotMoved();
		
		currentPosition = new Coordinates(1,-2);
		robot.place(currentPosition, facing);
		checkRobotNotMoved();
	}
	
	@Test
	public void check_PlaceInvalidCoordsTooBigXandY() {
		robot.place(currentPosition, facing);
		checkRobotNotMoved();
		
		currentPosition = new Coordinates(9,9);
		robot.place(currentPosition, facing);
		checkRobotNotMoved();
	}
	
	@Test
	public void check_PlaceInvalidCoordsTooBigX() {
		robot.place(currentPosition, facing);
		checkRobotNotMoved();
		
		currentPosition = new Coordinates(9,1);
		robot.place(currentPosition, facing);
		checkRobotNotMoved();
	}
	
	@Test
	public void check_PlaceInvalidCoordsTooBigY() {
		robot.place(currentPosition, facing);
		checkRobotNotMoved();
		
		currentPosition = new Coordinates(1,9);
		robot.place(currentPosition, facing);
		checkRobotNotMoved();
	}
	
	@Test
	public void check_move() {
		currentPosition = new Coordinates(1,2);
		facing = Direction.EAST;
		robot.place(currentPosition, facing);
		checkRobotPosition(1, 2, Direction.EAST);
		
		robot.move();
		
		checkRobotPosition(2, 2, Direction.EAST);
	}
	
	@Test
	public void check_moveOffBoardWest() {
		currentPosition = new Coordinates(0,1);
		facing = Direction.WEST;
		robot.place(currentPosition, facing);
		checkRobotPosition(0, 1, Direction.WEST);
		
		robot.move();
		
		checkRobotPosition(0, 1, Direction.WEST);
	}
	
	@Test
	public void check_moveOffBoardEast() {
		currentPosition = new Coordinates(4,1);
		facing = Direction.EAST;
		robot.place(currentPosition, facing);
		checkRobotPosition(4, 1, Direction.EAST);
		
		robot.move();
		
		checkRobotPosition(4, 1, Direction.EAST);
	}
	
	@Test
	public void check_moveOffBoardNorth() {
		currentPosition = new Coordinates(3,4);
		facing = Direction.NORTH;
		robot.place(currentPosition, facing);
		checkRobotPosition(3, 4, Direction.NORTH);
		
		robot.move();
		
		checkRobotPosition(3, 4, Direction.NORTH);
	}
	
	@Test
	public void check_moveOffBoardSouth() {
		currentPosition = new Coordinates(2,0);
		facing = Direction.SOUTH;
		robot.place(currentPosition, facing);
		checkRobotPosition(2, 0, Direction.SOUTH);
		
		robot.move();
		
		checkRobotPosition(2, 0, Direction.SOUTH);
	}
	
	@Test
	public void check_turnLeft() {
		currentPosition = new Coordinates(2,0);
		facing = Direction.SOUTH;
		robot.place(currentPosition, facing);
		checkRobotPosition(2, 0, Direction.SOUTH);
		
		robot.turn(DirectionToTurn.LEFT);
		
		checkRobotPosition(2, 0, Direction.EAST);
	}
	
	@Test
	public void check_turnRight() {
		currentPosition = new Coordinates(2,0);
		facing = Direction.SOUTH;
		robot.place(currentPosition, facing);
		checkRobotPosition(2, 0, Direction.SOUTH);
		
		robot.turn(DirectionToTurn.RIGHT);
		
		checkRobotPosition(2, 0, Direction.WEST);
	}
	
	@Test
	public void check_ignoreTurn() {
		robot.turn(DirectionToTurn.RIGHT);
		
		checkRobotHasNotBeenPlacedOnBoard();
	}
	
	@Test
	public void check_ignoreMove() {
		robot.move();
		
		checkRobotHasNotBeenPlacedOnBoard();
	}
	
	@Test
	public void check_ignoreReport() {
		robot.report();
		
		checkRobotHasNotBeenPlacedOnBoard();
	}
	
	@Test
	public void check_Reporting() {
		robot.place(currentPosition, facing);
		
		checkRobotPosition(1, 2, Direction.EAST);
	}
	
	@Test
	public void check_ReportingIgnore() {
		robot.report();

		assertNull(reporter.coordinates);
		assertNull(reporter.facing);
	}
	
	private void checkRobotNotMoved() {
		robot.report();

		checkRobotPosition(1, 2, Direction.EAST);
	}
	
	private void checkRobotPosition(final int x, final int y, final Direction direction) {
		robot.report();
		
		assertEquals(x, reporter.coordinates.getX());
		assertEquals(y, reporter.coordinates.getY());
		assertEquals(direction, reporter.facing);
	}
	
	private void checkRobotHasNotBeenPlacedOnBoard() {
		assertNull(robot.getCurrentPosition());
		assertNull(robot.getFacing());
	}
}
