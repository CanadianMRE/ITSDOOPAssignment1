package project.shapes;

public abstract class Prism extends Shape{
        protected double length;

        public Prism (double height, double length){
            super(height);
            this.length = length;
        }

        public abstract double GetArea();
        public abstract double GetVolume();

}