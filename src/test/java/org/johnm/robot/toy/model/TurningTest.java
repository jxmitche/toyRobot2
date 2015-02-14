package org.johnm.robot.toy.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TurningTest {
	private Turning turning;
	private Direction result;

	@Before
	public void setup() {
		turning = new Turning();
	}

	@Test
	public void check_TurnLeftFromNorth() {
		result = turning.turn(Direction.NORTH, DirectionToTurn.LEFT);
		assertEquals(Direction.WEST, result);
	}

	@Test
	public void check_TurnLeftFromSouth() {
		result = turning.turn(Direction.SOUTH, DirectionToTurn.LEFT);
		assertEquals(Direction.EAST, result);
	}

	@Test
	public void check_TurnLeftFromEast() {
		result = turning.turn(Direction.EAST, DirectionToTurn.LEFT);
		assertEquals(Direction.NORTH, result);
	}

	@Test
	public void check_TurnLeftFromWest() {
		result = turning.turn(Direction.WEST, DirectionToTurn.LEFT);
		assertEquals(Direction.SOUTH, result);
	}

	@Test
	public void check_TurnRightFromNorth() {
		result = turning.turn(Direction.NORTH, DirectionToTurn.RIGHT);
		assertEquals(Direction.EAST, result);
	}

	@Test
	public void check_TurnRightFromSouth() {
		result = turning.turn(Direction.SOUTH, DirectionToTurn.RIGHT);
		assertEquals(Direction.WEST, result);
	}

	@Test
	public void check_TurnRightFromEast() {
		result = turning.turn(Direction.EAST, DirectionToTurn.RIGHT);
		assertEquals(Direction.SOUTH, result);
	}

	@Test
	public void check_TurnRightFromWest() {
		result = turning.turn(Direction.WEST, DirectionToTurn.RIGHT);
		assertEquals(Direction.NORTH, result);
	}
}
