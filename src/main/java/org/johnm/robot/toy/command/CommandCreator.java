package org.johnm.robot.toy.command;

import org.johnm.robot.toy.model.Coordinates;
import org.johnm.robot.toy.model.Direction;
import org.johnm.robot.toy.model.DirectionToTurn;
import org.johnm.robot.toy.model.ToyRobot;
import org.johnm.robot.toy.validation.NullParamValidator;

public class CommandCreator {
	final private static String MOVE = "MOVE";
	final private static String LEFT = "LEFT";
	final private static String RIGHT = "RIGHT";
	final private static String REPORT = "REPORT";
	final private static String PLACE = "PLACE";
	final private static String NORTH = "NORTH";
	final private static String SOUTH = "SOUTH";
	final private static String EAST = "EAST";
	final private static String WEST = "WEST";
	private ToyRobot robot;
	private NullParamValidator nullValidator = new NullParamValidator();
	
	public CommandCreator(final ToyRobot robot) {
		nullValidator.checkNotNull(robot, "Robot");
		
		this.robot = robot;
	}
	
	public Command createCommand(final String commandLine) {
		if (MOVE.equals(commandLine)) {
			return new MoveCommand(robot);
		} else if (LEFT.equals(commandLine)) {
			return new TurnCommand(robot, DirectionToTurn.LEFT);
		} else if (RIGHT.equals(commandLine)) {
			return new TurnCommand(robot, DirectionToTurn.RIGHT);
		} else if (REPORT.equals(commandLine)) {
			return new ReportCommand(robot);
		} else if (commandLine.startsWith(PLACE)) {
			return parsePlaceCommand(commandLine);
		} else {
			throw new IllegalArgumentException("Unknown command line:" + commandLine);
		}
	}
	
	Command parsePlaceCommand(final String commandLine) {
		final String[] halves = commandLine.split(" ");
		
		if (halves.length == 2) {
			final String secondPartOfCommandLine = halves[1];
			final String[] parts = secondPartOfCommandLine.split(",");
			
			if (parts.length == 3) {
				final String x = parts[0];
				final String y = parts[1];
				final Coordinates coordinates = new Coordinates(Integer.valueOf(x), Integer.valueOf(y));
				
				final String directionPart = parts[2];
				final Direction direction = parseDirection(directionPart);
				
				return new PlaceCommand(robot, coordinates, direction);
			} else {
				throw new IllegalArgumentException("Place command line doesn't split into three:" + commandLine);
			}
		} else {
			throw new IllegalArgumentException("Place command line doesn't split into two:" + commandLine);
		}
	}
	
	Direction parseDirection(final String direction) {
		if (NORTH.equals(direction)) {
			return Direction.NORTH;
		} else if (SOUTH.equals(direction)) {
			return Direction.SOUTH;
		} else if (EAST.equals(direction)) {
			return Direction.EAST;
		} else if (WEST.equals(direction)) {
			return Direction.WEST;
		} else {
			throw new IllegalArgumentException("Unknown direction:" + direction);
		}
	}
}
