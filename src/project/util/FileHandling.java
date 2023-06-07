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

			if (nextVal.matches("^[a-zA-Z]*")) {
				Double a = f.nextDouble();
				Double b = f.nextDouble();

				switch(nextVal) {
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
					case "OctagonalPrism":
						new OctagonBase(a, b);
						
						break;
					case "PentagonalPrism":
						new PentagonBase(a, b);
						
						break;
					case "SquarePrism":
						new SquareBase(a, b);
						
						break;
					case "TriangularPrism":
						new EquilateralTriangleBase(a, b);
						
						break;
					default:
						break;
				}
			} else {
				System.out.println("Malformed file. Attempting to correct.");
			}
		}
		
		System.out.println("EOF - Continuing...");
		
		f.close();
	}
}
