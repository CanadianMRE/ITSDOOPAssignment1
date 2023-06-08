
package project.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Comparator;


import project.shapes.*;


public class Prompter {
    public static void HandleArgument(String action) {
        // Remove leading hyphens and convert to lowercase
        action = action.replaceAll("-", "").toLowerCase();

        switch (action.charAt(0)) {
            case 'f':
                String fileName = action.substring(1);
                // Perform file handling operations with the provided file name
                File shapeFile = new File(fileName);
                try {
                    FileHandling.ParseShapes(shapeFile);
                } catch (FileNotFoundException e) {
                    System.out.println("File not found: " + fileName);
                }
                break;

            case 't':
                char compareType = action.charAt(1);
                // Perform sorting based on the compare type
                Comparator<Shape> comparator;
                switch (compareType) {
                    case 'a':
                        comparator = new AreaCompare();
                        break;
                    case 'v':
                        comparator = new VolumeCompare();
                        break;
                    default:
                        System.out.println("Invalid compare type: " + compareType);
                        return;
                }

                Shape[] shapes = Shape.GetShapes();
                if (shapes.length > 0) {
                    Arrays.sort(shapes, comparator);
                    System.out.println("Shapes sorted by " + compareType + ":");
                    for (Shape shape : shapes) {
                        System.out.println(shape);
                    }
                } else {
                    System.out.println("No shapes found.");
                }
                break;

            case 's':
                char sortType = action.charAt(1);

                shapes = Shape.GetShapes();
                if (shapes.length > 0) {

                    System.out.println("Shapes sorted using " + sortType + " sort:");
            		long startTime = System.currentTimeMillis();
                	
                    switch (sortType) {
                        case 'b':
                        	Prompter.printSortedValues(Sorts.BubbleSort(shapes, new AreaCompare()));
                            break;
                        case 's':
                        	Prompter.printSortedValues(Sorts.SelectionSort(shapes, new AreaCompare()));
                            break;
                        case 'i':
                        	Prompter.printSortedValues(Sorts.InsertionSort(shapes, new AreaCompare()));
                            break;
                        case 'm':
                        	Prompter.printSortedValues(Sorts.MergeSort(shapes, new AreaCompare()));
                            break;
                        case 'q':
                        	Prompter.printSortedValues(Sorts.QuickSort(shapes, new AreaCompare()));
                            break;
                        default:
                            System.out.println("Invalid sort type: " + sortType);
                            return;
                    }
            		
            	    long endTime = System.currentTimeMillis();
            	    long timeTaken = endTime - startTime;
            	    System.out.println("Sort Time: " + timeTaken + " milliseconds\n");
                    
                    
                } else {
                    System.out.println("No shapes found.");
                }
                break;

            default:
                System.out.println("Invalid argument: " + action);
                break;
        }
    }
    public static void printSortedValues(Shape[] sortedArray) {
    	DecimalFormat numberFormat = new DecimalFormat("#.0#");
    	
        System.out.println("First Sorted Value: " + numberFormat.format(sortedArray[0].GetArea()));

        int interval = 1000;
        for (int i = interval; i < sortedArray.length; i += interval) {
            System.out.println("Value at index " + i + ": " + numberFormat.format(sortedArray[i].GetArea()));
        }
        System.out.println("Last Sorted Value: " + numberFormat.format(sortedArray[sortedArray.length - 1].GetArea()));
    }
}