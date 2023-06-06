package project.shapes;

public abstract class Shape implements Comparable<Shape> {
	private static Shape[] shapeList = {};
	protected double height;
	
	public Shape(double height) {
		this.height = height;

		shapeList[shapeList.length] = this;
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
