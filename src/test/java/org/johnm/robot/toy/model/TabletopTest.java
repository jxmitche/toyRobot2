package org.johnm.robot.toy.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import org.johnm.robot.toy.model.Coordinates;
import org.johnm.robot.toy.model.Tabletop;

public class TabletopTest {
	private Tabletop tabletop;
	private Coordinates coordinates;
	
	@Before
	public void setup() {
		tabletop = new Tabletop(5,6);
	}
	
	@Test
	public void check_WidthLessThan1() {
		try {
			new Tabletop(0, 1);
			fail("should not reach here");
		} catch (IllegalArgumentException ex) {
			assertEquals("Width must be greater than zero", ex.getMessage());
		}
	}
	
	@Test
	public void check_WidthNegative() {
		try {
			new Tabletop(-5, 1);
			fail("should not reach here");
		} catch (IllegalArgumentException ex) {
			assertEquals("Width must be greater than zero", ex.getMessage());
		}
	}
	
	@Test
	public void check_WidthAndLengthPositive() {
		tabletop = new Tabletop(1, 1);
		assertNotNull(tabletop);
	}
	
	@Test
	public void check_LengthLessThan1() {
		try {
			new Tabletop(1, 0);
			fail("should not reach here");
		} catch (IllegalArgumentException ex) {
			assertEquals("Length must be greater than zero", ex.getMessage());
		}
	}
	
	@Test
	public void check_LengthNegative() {
		try {
			new Tabletop(1, -5);
			fail("should not reach here");
		} catch (IllegalArgumentException ex) {
			assertEquals("Length must be greater than zero", ex.getMessage());
		}
	}
	
	@Test
	public void check_isValidPosition() {
		coordinates = new Coordinates(0, 0);
		assertTrue(tabletop.isValidPosition(coordinates));
		coordinates = new Coordinates(0, 5);
		assertTrue(tabletop.isValidPosition(coordinates));
		coordinates = new Coordinates(4, 0);
		assertTrue(tabletop.isValidPosition(coordinates));
		coordinates = new Coordinates(4, 5);
		assertTrue(tabletop.isValidPosition(coordinates));
		coordinates = new Coordinates(3, 2);
		assertTrue(tabletop.isValidPosition(coordinates));
		coordinates = new Coordinates(2, 3);
		assertTrue(tabletop.isValidPosition(coordinates));
		coordinates = new Coordinates(0, 6);
		assertFalse(tabletop.isValidPosition(coordinates));
		coordinates = new Coordinates(5, 0);
		assertFalse(tabletop.isValidPosition(coordinates));
		coordinates = new Coordinates(-1, 0);
		assertFalse(tabletop.isValidPosition(coordinates));
		coordinates = new Coordinates(0, -1);
		assertFalse(tabletop.isValidPosition(coordinates));
		
	}
}
