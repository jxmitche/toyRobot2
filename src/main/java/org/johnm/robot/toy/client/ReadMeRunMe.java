package org.johnm.robot.toy.client;

import org.johnm.robot.toy.reporting.Reporter;
import org.johnm.robot.toy.reporting.SystemOutReporter;
import org.johnm.robot.toy.validation.NullParamValidator;

public class ReadMeRunMe {
	private static NullParamValidator nullValidator = new NullParamValidator();
	
	public static void main(String[] args) {
		nullValidator.checkNotNull(args, "args");
		final Reporter reporter = new SystemOutReporter();
		final Setup setup = new Setup(reporter);
		
		//take file name as first param
		final String fileName = args[0];
		setup.processCommandsFromFile(fileName);
	}
}
