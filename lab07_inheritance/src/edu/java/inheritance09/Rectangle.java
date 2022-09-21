package edu.java.inheritance09;


//직사각형
public class Rectangle extends Shape{
   
    private double width;
    private double height;
  
    //생성자.
    protected Rectangle(String type, double width, double height) {
        super(type);
        this.width = width;
        this.height = height;
    }




    @Override
    public double area() {
       
    double area = width * height; 
        
        return area;
    }

    @Override
    public double perimeter() {
        
        double perimeter = (width + height) * 2;
            
        return perimeter;
    }

  

}
