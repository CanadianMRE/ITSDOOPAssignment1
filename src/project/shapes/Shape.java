package project.shapes;

public abstract class Shape implements Comparable<Shape> {
	private static Shape[] shapeList = new Shape[99999999];
	protected double height;
	
	public Shape(double height) {
		this.height = height;
		
	}

	public abstract double GetArea();
	
	public abstract double GetVolume();
	
	public int compareTo(Shape o) {
		if(this.height==o.height)  
			return 0;  
		else if(this.height>o.height)  
			return 1;  
		else  
			return -1;  
	}
	
	public static Shape[] GetShapes() {
		return shapeList;
	}
}
