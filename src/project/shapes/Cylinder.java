package project.shapes;

public class Cylinder extends Shape {
	protected double radius;

	public Cylinder(double height, double radius) {
		super(height);
		this.radius = radius;
	}

	@Override
	public double getArea() {
		return Math.PI * Math.pow(this.radius, 2);
	}

	@Override
	public double getVolume() {
		return getArea() * this.height;
	}
	
}
