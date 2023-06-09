package project.util;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

import project.shapes.Shape;

public class Sorts {
	
	
	public static boolean IsBozoSorted(Shape[] shapeArray, Comparator<Shape> comparator, boolean useComparable) {
		for (int i = 1; i < shapeArray.length; i++) {
			if (useComparable) {
				if (shapeArray[i].compareTo(shapeArray[i - 1]) < 0) {
					return false;
				}
			} else {
				if (comparator.compare(shapeArray[i], shapeArray[i - 1]) < 0) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	public static Shape[] BozoSort(Shape[] shapeArray, Comparator<Shape> comparator, boolean useComparable) {
		Random random = new Random();
		int salt = shapeArray.length;
		
		while (!IsBozoSorted(shapeArray, comparator, useComparable)) {
			int swap1 = random.nextInt(salt);
			int swap2 = random.nextInt(salt);
			
			Shape carry = shapeArray[swap1];
			
			shapeArray[swap1] = shapeArray[swap2];
			shapeArray[swap2] = carry;
		}
		
		return shapeArray;
	}
	
	public static Shape[] BubbleSort(Shape[] shapeArray, Comparator<Shape> comparator, boolean useComparable) {
	    for (int i = 0; i < shapeArray.length - 1; i++) {
            for (int j = 0; j < shapeArray.length - i - 1; j++) {
            	if (useComparable) {
            		if (shapeArray[j].compareTo(shapeArray[j + 1]) > 0) {
                        Shape temp = shapeArray[j];
                        shapeArray[j] = shapeArray[j + 1];
                        shapeArray[j + 1] = temp;
                    }
    			} else {
    				if (comparator.compare(shapeArray[j], shapeArray[j + 1]) > 0) {
                        Shape temp = shapeArray[j];
                        shapeArray[j] = shapeArray[j + 1];
                        shapeArray[j + 1] = temp;
                    }
    			}
            }
        }
		return shapeArray;
	}

	public static Shape[] SelectionSort(Shape[] shapeArray, Comparator<Shape> comparator, boolean useComparable) {
		 for (int i = 0; i < shapeArray.length - 1; i++) {
	            int minIndex = i;
	            for (int j = i + 1; j < shapeArray.length; j++) {
	            	if (useComparable) {
		                if (shapeArray[j].compareTo(shapeArray[minIndex]) < 0) {
		                    minIndex = j;
		                }
	    			} else {
		                if (comparator.compare(shapeArray[j], shapeArray[minIndex]) < 0) {
		                    minIndex = j;
		                }
	    			}
	            }
	            Shape temp = shapeArray[minIndex];
	            shapeArray[minIndex] = shapeArray[i];
	            shapeArray[i] = temp;
	        }
		 return shapeArray;
	}

	public static Shape[] InsertionSort(Shape[] shapeArray, Comparator<Shape> comparator, boolean useComparable) {
		for (int i = 1; i < shapeArray.length; i++) {
            Shape key = shapeArray[i];
            int j = i - 1;
            if (useComparable) {
            	while (j >= 0 && shapeArray[j].compareTo(key) > 0) {
                	shapeArray[j + 1] = shapeArray[j];
                    j--;
                }
			} else {
				while (j >= 0 && comparator.compare(shapeArray[j], key) > 0) {
	            	shapeArray[j + 1] = shapeArray[j];
	                j--;
	            }
			}
            
            shapeArray[j + 1] = key;
        }
		return shapeArray;
	}

	public static Shape[] MergeSort(Shape[] shapeArray, Comparator<Shape> comparator, boolean useComparable) {
		
        mergeSortHelper(shapeArray, 0, shapeArray.length - 1, comparator, useComparable);
	    
        return shapeArray;
    }

    private static void mergeSortHelper(Shape[] shapeArray, int left, int right, Comparator<Shape> comparator, boolean useComparable) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSortHelper(shapeArray, left, mid, comparator, useComparable);
            mergeSortHelper(shapeArray, mid + 1, right, comparator, useComparable);
            merge(shapeArray, left, mid, right, comparator, useComparable);
        }
    }

    private static void merge(Shape[] shapeArray, int left, int mid, int right, Comparator<Shape> comparator, boolean useComparable) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        Shape[] leftArray = new Shape[n1];
        Shape[] rightArray = new Shape[n2];

        for (int i = 0; i < n1; ++i) {
            leftArray[i] = shapeArray[left + i];
        }

        for (int j = 0; j < n2; ++j) {
            rightArray[j] = shapeArray[mid + 1 + j];
        }

        int i = 0, j = 0;
        int k = left;

        while (i < n1 && j < n2) {
        	if (useComparable) {
        		if (leftArray[i].compareTo(rightArray[j]) <= 0) {
                    shapeArray[k] = leftArray[i];
                    i++;
                } else {
                    shapeArray[k] = rightArray[j];
                    j++;
                }
			} else {
				if (comparator.compare(leftArray[i], rightArray[j]) <= 0) {
	                shapeArray[k] = leftArray[i];
	                i++;
	            } else {
	                shapeArray[k] = rightArray[j];
	                j++;
	            }
			}
            
            k++;
        }

        while (i < n1) {
            shapeArray[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            shapeArray[k] = rightArray[j];
            j++;
            k++;
        }
    }
    
	public static Shape[] QuickSort(Shape[] shapeArray, Comparator<Shape> comparator, boolean useComparable) {

		Shape[] sorted = QuickSortR(shapeArray, comparator, useComparable);
	    
	    return sorted;
	}
	
	private static Shape[] QuickSortR(Shape[] shapeArray, Comparator<Shape> comparator, boolean useComparable) {
		if (shapeArray.length <= 1) {
		    return shapeArray;
		} else {
		    Shape pivot = shapeArray[0];
		    Shape[] left = new Shape[0];
		    Shape[] right = new Shape[0];
		    Shape[] pivots = new Shape[0];

		    for (int j = 0; j < shapeArray.length; j++) {
		        int compareNum;
		        if (useComparable) {
					compareNum = shapeArray[j].compareTo(pivot);
				} else {
					compareNum = comparator.compare(shapeArray[j], pivot);
				}

		        if (compareNum > 0) {
		            right = Arrays.copyOf(right, right.length + 1);
		            right[right.length - 1] = shapeArray[j];
		        } else if (compareNum < 0) {
		            left = Arrays.copyOf(left, left.length + 1);
		            left[left.length - 1] = shapeArray[j];
		        } else {
		            pivots = Arrays.copyOf(pivots, pivots.length + 1);
		            pivots[pivots.length - 1] = shapeArray[j];
		        }
		    }

		    left = QuickSortR(left, comparator, useComparable);
		    right = QuickSortR(right, comparator, useComparable);

		    for (int j = 0; j < pivots.length; j++) {
		        left = Arrays.copyOf(left, left.length + 1);
		        left[left.length - 1] = pivots[j];
		    }

		    for (int j = 0; j < right.length; j++) {
		        left = Arrays.copyOf(left, left.length + 1);
		        left[left.length - 1] = right[j];
		    }
		    
		    return left;
		}

	}
}