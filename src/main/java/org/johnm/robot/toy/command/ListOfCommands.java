package org.johnm.robot.toy.command;

import java.util.List;

import org.johnm.robot.toy.validation.NullParamValidator;

public class ListOfCommands implements Command {
	private NullParamValidator nullValidator = new NullParamValidator();;
	private List<Command> commands;
	
	public ListOfCommands(final List<Command> commands) {
		nullValidator.checkNotNull(commands, "Commands");
		
		this.commands = commands;
	}
	
	public void execute() {
		for (Command command : commands) {
			command.execute();
		}
	}
}
