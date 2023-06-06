package project.shapes.prisms;

import project.shapes.Prism;

public class SquareBase extends Prism {


    public SquareBase(double height, double length) {
        super(height, length);
    }

    @Override
    public double GetArea() {
        double baseArea = Math.pow(length,2);
		return baseArea;
    }

    @Override
    public double GetVolume() {
        return Math.pow(length,2) * this.height;
    }

}