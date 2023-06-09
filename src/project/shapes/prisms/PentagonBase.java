package project.shapes.prisms;

import project.shapes.Prism;

public class PentagonBase  extends Prism {

    public PentagonBase(double height, double length) {
        super(height, length);
    }

    @Override
    public double getArea() {
        double sideLength = this.length;
        return 5 * Math.pow(sideLength, 2) * Math.tan(Math.toRadians(54)) / 4;
    }

    @Override
    public double getVolume() {
        return getArea() * this.height;
    }

}