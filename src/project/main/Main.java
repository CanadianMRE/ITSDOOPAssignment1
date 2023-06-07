package project.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import project.util.*;
import project.shapes.*;

public class Main {
	public static void main(String[] args) {
		System.out.print(Arrays.toString(args));
		// Import all shapes from file
		if (args.length < 1) {
			return;
		}
		
		File shapeFile = new File(args[0]);
		
		try {
			FileHandling.ParseShapes(shapeFile);
		} catch (FileNotFoundException e) {
			return;
		}
		
		System.out.print(Arrays.toString(Shape.GetShapes()));
		
		// Start command prompt
		for(int j = 1; j < args.length; j++) {
			Prompter.HandleArgument(args[j]);
		}
		
	}

}
