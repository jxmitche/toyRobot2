package org.johnm.robot.toy.client;

import java.util.ArrayList;
import java.util.List;

import org.johnm.robot.toy.command.Command;
import org.johnm.robot.toy.command.CommandCreator;
import org.johnm.robot.toy.command.ListOfCommands;
import org.johnm.robot.toy.input.ReadFile;
import org.johnm.robot.toy.model.Tabletop;
import org.johnm.robot.toy.model.ToyRobot;
import org.johnm.robot.toy.reporting.Reporter;
import org.johnm.robot.toy.validation.NullParamValidator;

public class Setup {
	private ToyRobot robot;
	private NullParamValidator nullValidator = new NullParamValidator();
	
	public Setup(final Reporter reporter) {
		nullValidator.checkNotNull(reporter, "Reporter");
		
		final Tabletop tabletop = new Tabletop(5,5);
		this.robot = new ToyRobot(tabletop, reporter);
	}
	
	public void processCommandsFromFile(final String fileName) {
		nullValidator.checkNotNull(fileName, "FileName");
		
		final List<Command> commands = new ArrayList<Command>();
		final ListOfCommands listOfCommands = new ListOfCommands(commands);
		final CommandCreator commandCreator = new CommandCreator(robot);
		
		final ReadFile readFile = new ReadFile(fileName);
		final List<String> lines = readFile.readFile();
		
		for (String commandLine :lines) {
			final Command command = commandCreator.createCommand(commandLine);
			commands.add(command);
		}
		
		listOfCommands.execute();
	}
}
