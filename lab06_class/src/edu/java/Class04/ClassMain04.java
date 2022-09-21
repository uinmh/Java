package edu.java.Class04;

public class ClassMain04 {

    public static void main(String[] args) {
        
        
        // 기본 생성자 사용
        
        Circle circle1 = new Circle();
        
        System.out.println("1 : " + circle1 );
        System.out.println("1 반지름 : " + circle1.radius );
        System.out.println("1 둘레 : " + circle1.primeter());
        System.out.println("1 넓이 : " + circle1.area());
        
        System.out.println("---------------------");
        
        Circle circle2 = new Circle(10);
        System.out.println("2 : " + circle2 );
        System.out.println("2 반지름 : " + circle2.radius );
        System.out.println("2 둘레 : " + circle2.primeter());
        System.out.println("2 넓이 : " + circle2.area());
        
        Circle circle3 = new Circle(10);
        
        //생성자를 호출할 때마다 메모리의 다른 주소에 다른 객체가 만들어짐.
        
        System.out.println("3 : " + circle3 );
        
    
    }

}
