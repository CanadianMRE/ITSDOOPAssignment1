
package project.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Comparator;


import project.shapes.*;


public class Prompter {
	static Comparator<Shape> comparator = new AreaCompare();
	static boolean useComparable = false;
	static Character sortType = 'b';
	static File shapeFile;
	
	
	public static void handleArguments(String[] args) {
		for (int i = 0; i < args.length; i++) {
			if (!handleSingleArg(args[i])) {
				return;
			}
		}
		
		// Verify the arguments got declared
		if (shapeFile == null) {
			System.out.println("Must pass a shape file");
			return;
		}
		
		try {
			FileHandling.ParseShapes(shapeFile);
		} catch (FileNotFoundException e) {
			System.out.println("Failed to parse file");
			return;
		}

		long startTime = System.currentTimeMillis();
		
		runProgram();
		
	    long endTime = System.currentTimeMillis();
	    long timeTaken = endTime - startTime;
	    System.out.println("Sort Time: " + timeTaken + " milliseconds\n");
	}
	
	public static boolean handleSingleArg(String arg) {
		arg = arg.toLowerCase();
	    arg = arg.replaceAll("-","");

	    switch(arg.charAt(0)) {
        case 't':
            if(arg.charAt(1)=='a') {
                useComparable = false;
                comparator = new AreaCompare();
            }
            else if(arg.charAt(1)=='v'){
                useComparable = false;
                comparator = new VolumeCompare();
            }
            else if(arg.charAt(1)=='h'){
                useComparable = true;
            }
            else{
            	System.out.println("Invalid compare type (-"+ arg + ")");
                return false;
            }
            break;
        case 's':
            sortType = arg.charAt(1);
            break;
        case 'f':
            try{
                String s = arg.substring(1);
                shapeFile = new File(s);
            }
            catch(Exception e){
            	System.out.println("Invalid shape file (-"+ arg + ")");
                return false;
            }
            break;
	    default:
        	System.out.println("Invalid argument (-"+ arg + ")");
	    	return false;
        }
	    
	    return true;
	}
	
	public static void runProgram() {
		Shape[] shapes = Shape.getShapes();
		
		switch (sortType) {
		case 'b':
        	Prompter.printSortedValues(Sorts.BubbleSort(shapes, comparator, useComparable));
            break;
        case 's':
        	Prompter.printSortedValues(Sorts.SelectionSort(shapes, comparator, useComparable));
            break;
        case 'i':
        	Prompter.printSortedValues(Sorts.InsertionSort(shapes, comparator, useComparable));
            break;
        case 'm':
        	Prompter.printSortedValues(Sorts.MergeSort(shapes, comparator, useComparable));
            break;
        case 'q':
        	Prompter.printSortedValues(Sorts.QuickSort(shapes, comparator, useComparable));
            break;
        case 'z':
        	Prompter.printSortedValues(Sorts.BozoSort(shapes, comparator, useComparable));
            break;
		default:
			System.out.println("Invalid sort type: " + sortType);
		}
	}
	
	private static String formatShape(Shape shape) {
    	DecimalFormat numberFormat = new DecimalFormat("#.0#");
    	
    	if (useComparable) {
        	return numberFormat.format(shape.getHeight());
    	} else if (comparator instanceof VolumeCompare) {
        	return numberFormat.format(shape.getVolume());
    	} else {
        	return numberFormat.format(shape.getArea());
    	}
	}

    public static void printSortedValues(Shape[] sortedArray) {
    	
        System.out.println("First Sorted Value: " + formatShape(sortedArray[0]));

        int interval = 1000;
        for (int i = interval; i < sortedArray.length; i += interval) {
            System.out.println("Value at index " + i + ": " + formatShape(sortedArray[i]));
        }
        System.out.println("Last Sorted Value: " + formatShape(sortedArray[sortedArray.length - 1]));
    }
}