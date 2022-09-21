package edu.java.inheritance09;

public class Circle extends Shape {
    
    private double radius;
    
    protected Circle(String type, double radius) {
        
        super(type);

        this.radius = radius;
    }

    @Override
    public double area() {
      double area = radius * radius * Math.PI;
        return area;
    }

    @Override
    public double perimeter() {
      double perimeter = 2 * radius * Math.PI;
        return perimeter;
    }

}
