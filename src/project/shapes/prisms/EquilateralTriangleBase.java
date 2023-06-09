package project.shapes.prisms;

import project.shapes.Prism;

public class EquilateralTriangleBase extends Prism {


    public EquilateralTriangleBase(double height, double length) {
        super(height, length);
    }

    @Override
    public double getArea() {
        double baseArea = Math.pow(length,2) * Math.sqrt(3)/4;
        return baseArea;
    }

    @Override
    public double getVolume() {
        return getArea() * this.height;
    }

}