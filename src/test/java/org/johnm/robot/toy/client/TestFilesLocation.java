package org.johnm.robot.toy.client;

import java.net.URL;

public class TestFilesLocation {
	//TODO: change to use ClassLoader and place test files in /test/resources
	//public static final String TEST_DIRECTORY = "C:\\Data\\xdrive\\Personal\\jobs\\ToyRobot\\johnm-toyrobot\\testdata\\";
	public static final String TEST_DIRECTORY = "/home/jmitch/Public/xdrive/temp/";
	
	public static final String getFileName(final String filename) {
		final URL url = TestFilesLocation.class.getClassLoader().getResource(filename);
		return url.getFile();
	}
}
