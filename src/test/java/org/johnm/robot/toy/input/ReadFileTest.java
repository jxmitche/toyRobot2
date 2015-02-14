package org.johnm.robot.toy.input;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import org.johnm.robot.toy.client.TestFilesLocation;

public class ReadFileTest {
	private ReadFile readFile;
	
	@Before
	public void setup() {
		//TODO: Place test files in this directory
		readFile = new ReadFile(TestFilesLocation.TEST_DIRECTORY + "cmds.txt");
	}
	
	@Test
	public void check_file() {
		final List<String> lines = readFile.readFile();
		
		assertEquals("PLACE 1,2,NORTH", lines.get(0));
		assertEquals("MOVE", lines.get(1));
		assertEquals("LEFT", lines.get(2));
		assertEquals("RIGHT", lines.get(3));
		assertEquals("REPORT", lines.get(4));
	}
	
	@Test
	public void check_NullFileName() {
		try {
			readFile = new ReadFile(null);
			fail("should not reach here");
		} catch (IllegalArgumentException ex) {
			assertEquals("Path must not be null", ex.getMessage());
		}
	}
}
