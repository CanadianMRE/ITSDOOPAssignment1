package project.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import project.shapes.*;
import project.shapes.prisms.*;

public class FileHandling {
	public static void ParseShapes(File shapeFile) throws FileNotFoundException {
		Scanner f = new Scanner(shapeFile);
		
		while(f.hasNext()) {
			String nextVal = f.next();
			
			System.out.println(nextVal);
			
			Double a = 1.0;
			Double b = 1.0;
			
//			a = f.nextDouble();
//			b = f.nextDouble();

			switch(nextVal.toLowerCase()) {
				case "Cylinder":
					new Cylinder(a,b); 
					
					break;
				case "Cone":
					new Cone(a,b); 
					
					break;
				case "Pyramid":
					new Pyramid(a,b);
					
					break;
				case "Prisma":
					new Pyramid(a,b);
					
					break;
				case "Prismb":
					new OctagonBase(a, b);
					
					break;
				case "Prismc":
					new PentagonBase(a, b);
					
					break;
				case "Prismd":
					new SquareBase(a, b);
					
					break;
				default:
					break;
			}
		}
		
		f.close();
	}
}
