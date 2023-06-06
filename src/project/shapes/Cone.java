package project.shapes;

public class Cone extends Shape {
    protected double radius;
    
    public Cone(double height, double radius) {
        super(height);
        this.radius = radius;
    }
    
    @Override
    public double GetArea() {
        return Math.PI*Math.pow(this.radius,2);
    }
    
    @Override
    public double GetVolume() {
        return (1/3)*GetArea()*this.height;
    }
}