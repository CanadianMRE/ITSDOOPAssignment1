package project.shapes.prisms;

import project.shapes.Prism;

public class OctagonBase extends Prism {
    public OctagonBase(double height, double length) {
        super(height, length);
    }

    @Override
    public double getArea() {
        double sideLength = this.length;
        return 2 * (1 + Math.sqrt(2)) * sideLength * sideLength;
    }

    @Override
    public double getVolume() {
        return getArea() * this.height;
    }

}