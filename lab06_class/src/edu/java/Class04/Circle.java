package edu.java.Class04;

public class Circle {
    // 필드 - 반지름
    double radius;
    
    
    // 생성자 기본생성자 ,argument를 갖는 생성자.
    public Circle (){
        
    }
    
    public Circle (double radius) {
        
        this.radius = radius;
        
    }
    // method - 둘레(2 * 3.14 * r) , 넓이 (3.14 * r * r)
    
    public double primeter () { 
        return 2 * 3.14 * this.radius; // 2 * Math.PI * this.radius
    }
    
    public double area () {
        return 3.14 * this.radius * this.radius;// Math.PI * this.radius * this.radius
    }
}
