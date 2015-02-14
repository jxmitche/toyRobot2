package org.johnm.robot.toy.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class MovingTest {
	private Moving moving;
	private Coordinates currentPosition;
	private Coordinates result;
	
	@Before
	public void setup() {
		moving = new Moving();
		currentPosition = new Coordinates(1,1);
	}
	
	@Test
	public void check_NullCoordinates() {
		try {
			moving.moveOneSquare(null, Direction.EAST);
			fail("should not reach here");
		} catch (IllegalArgumentException ex) {
			assertEquals("CurrentPosition must not be null", ex.getMessage());
		}
	}
	
	@Test
	public void check_NullDirection() {
		try {
			moving.moveOneSquare(currentPosition, null);
			fail("should not reach here");
		} catch (IllegalArgumentException ex) {
			assertEquals("Facing must not be null", ex.getMessage());
		}
	}
	
	@Test
	public void check_MoveNorth() {
		result = moving.moveOneSquare(currentPosition, Direction.NORTH);
		assertEquals(1, result.getX());
		assertEquals(2, result.getY());
	}
	
	@Test
	public void check_MoveSouth() {
		result = moving.moveOneSquare(currentPosition, Direction.SOUTH);
		assertEquals(1, result.getX());
		assertEquals(0, result.getY());
	}
	
	@Test
	public void check_MoveEast() {
		result = moving.moveOneSquare(currentPosition, Direction.EAST);
		assertEquals(2, result.getX());
		assertEquals(1, result.getY());
	}
	
	@Test
	public void check_MoveWest() {
		result = moving.moveOneSquare(currentPosition, Direction.WEST);
		assertEquals(0, result.getX());
		assertEquals(1, result.getY());
	}
}
