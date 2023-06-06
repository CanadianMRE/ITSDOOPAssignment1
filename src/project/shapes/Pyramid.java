package project.shapes;

public class Pyramid extends Shape {
    protected double side;
    
    public Pyramid(double height, double side) {
        super(height);
        this.side = side;
    }
    
    @Override
    public double GetArea() {
        return Math.pow(this.side, 2);
    }
    
    @Override
    public double GetVolume() {
        return (1/3)*GetArea()*this.height;
    }
}