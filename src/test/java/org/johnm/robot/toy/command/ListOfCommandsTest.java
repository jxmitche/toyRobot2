package org.johnm.robot.toy.command;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ListOfCommandsTest {
	private ListOfCommands listOfCommands;
	private List<Command> commands;
	private Command command;
	
	@Before
	public void setup() {
		commands = new ArrayList<Command>();
		listOfCommands = new ListOfCommands(commands);
		command = new MockCommand();
		commands.add(command);
	}

	@Test
	public void check_Excute() {
		listOfCommands.execute();
	}
	
	@Test
	public void check_NullParam() {
		try {
			new ListOfCommands(null);
			fail("should not reach here");
		} catch (IllegalArgumentException ex) {
			assertEquals("Commands must not be null", ex.getMessage());
		}
	}
}
