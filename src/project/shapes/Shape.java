package project.shapes;

public abstract class Shape implements Comparable<Shape> {
	private static Shape[] shapeList = new Shape[0];
	protected double height;
	
	public Shape(double height) {
		this.height = height;
		
		Shape[] newShapeList = new Shape[shapeList.length + 1];
		
		for(int j = 0; j < shapeList.length; j++) {
			newShapeList[j] = shapeList[j];
		}
		
		newShapeList[newShapeList.length - 1] = this;
		
		shapeList = newShapeList;
	}

	public abstract double getArea();
	
	public abstract double getVolume();
	
	public int compareTo(Shape o) {
		if(this.height==o.height)  
			return 0;  
		else if(this.height>o.height)  
			return -1;  
		else  
			return 1;  
	}
	
	public static Shape[] getShapes() {
		return shapeList;
	}
}
