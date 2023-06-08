package project.shapes;

public class Pyramid extends Shape {
    protected double side;
    
    public Pyramid(double height, double side) {
        super(height);
        this.side = side;
    }
    
    @Override
    public double getArea() {
        return Math.pow(this.side, 2);
    }
    
    @Override
    public double getVolume() {
        return (1/3)*getArea()*this.height;
    }
}