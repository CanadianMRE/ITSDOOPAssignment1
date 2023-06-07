package project.util;

import java.util.Comparator;

import project.shapes.Shape;

public class Sorts {
	
	public static Shape[] BubbleSort(Shape[] shapeArray, Comparator<Shape> comparator) {
		for (int i = 0; i < shapeArray.length - 1; i++) {
            for (int j = 0; j < shapeArray.length - i - 1; j++) {
                if (comparator.compare(shapeArray[j], shapeArray[j + 1]) > 0) {
                    Shape temp = shapeArray[j];
                    shapeArray[j] = shapeArray[j + 1];
                    shapeArray[j + 1] = temp;
                }
            }
        }
		
		return shapeArray;
	}

	public static Shape[] SelectionSort(Shape[] shapeArray, Comparator<Shape> comparator) {
		 for (int i = 0; i < shapeArray.length - 1; i++) {
	            int minIndex = i;
	            for (int j = i + 1; j < shapeArray.length; j++) {
	                if (comparator.compare(shapeArray[j], shapeArray[minIndex]) < 0) {
	                    minIndex = j;
	                }
	            }
	            Shape temp = shapeArray[minIndex];
	            shapeArray[minIndex] = shapeArray[i];
	            shapeArray[i] = temp;
	        }
		 
		 return shapeArray;
	}

	public static Shape[] InsertionSort(Shape[] shapeArray, Comparator<Shape> comparator) {
		for (int i = 1; i < shapeArray.length; i++) {
            Shape key = shapeArray[i];
            int j = i - 1;
            while (j >= 0 && comparator.compare(shapeArray[j], key) > 0) {
            	shapeArray[j + 1] = shapeArray[j];
                j--;
            }
            shapeArray[j + 1] = key;
        }
		
		return shapeArray;
	}

	public static Shape[] MergeSort(Shape[] shapeArray, Comparator<Shape> comparator) {
		return shapeArray;
	}

	public static Shape[] QuickSort(Shape[] shapeArray, Comparator<Shape> comparator) {
		if (shapeArray.length <= 1) {
			return shapeArray;
		} else {
			Shape pivot = shapeArray[0];
			Shape[] left = {};
			Shape[] right = {};
			Shape[] pivots = {};

			for(int j = 0; j < shapeArray.length; j++) {
				int compareNum = comparator.compare(shapeArray[j], pivot);
				
				if (compareNum > 0) {
					right[right.length] = shapeArray[j];
				} else if (compareNum < 0) {
					left[left.length] = shapeArray[j];
				} else {
					pivots[pivots.length] = shapeArray[j];
				}
			}
			
			left = QuickSort(left, comparator);
			right = QuickSort(right, comparator);

			for(int j = 0; j < pivots.length; j++) {
				left[left.length] = pivots[j];
			}
			
			for(int j = 0; j < right.length; j++) {
				left[left.length] = right[j];
			}
			
			return left;
		}
	}
}
