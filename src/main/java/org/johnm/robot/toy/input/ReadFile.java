package org.johnm.robot.toy.input;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.johnm.robot.toy.validation.NullParamValidator;

public class ReadFile {
	private String path;
	private NullParamValidator nullValidator = new NullParamValidator();
	
	
	public ReadFile(final String path) {
		nullValidator.checkNotNull(path, "Path");
		
		this.path = path;
	}

	public List<String> readFile() {
		final List<String> lines = new ArrayList<String>();
		Scanner sc = null; 
		
		try {
			sc = new Scanner(new File(path));
			
			while(sc.hasNextLine()) {
               final String line = sc.nextLine();
               lines.add(line);
            }
			
            sc.close();
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException("File not found" + path);
		} finally {
			if (sc != null) sc.close();
		}
		
		return lines;
	}
}
