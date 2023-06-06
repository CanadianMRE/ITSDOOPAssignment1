package project.shapes.prisms;

import project.shapes.Prism;

public class EquilateralTriangleBase extends Prism {


    public EquilateralTriangleBase(double height, double length) {
        super(height, length);
        // TODO Auto-generated constructor stub
    }

    @Override
    public double GetArea() {
        double baseArea = Math.pow(length,2) * Math.sqrt(3)/4;
        return baseArea;
    }

    @Override
    public double GetVolume() {
        return GetArea() * this.height;
    }

}