package org.johnm.robot.toy.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import org.johnm.robot.toy.model.Coordinates;

public class CoordinatesTest {
	private Coordinates coordinates;
	
	@Test
	public void check_Positions() {
		coordinates = new Coordinates(1,4);
		
		assertEquals(1, coordinates.getX());
		assertEquals(4, coordinates.getY());
	}
}
