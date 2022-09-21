package edu.java.class03;

public class ClassMain03 {

    public static void main(String[] args) {
    
        Rectangle rect1 = new Rectangle();

        System.out.println("rect1 가로 : " + rect1.width);
        System.out.println("rect1 세로 : " + rect1.height);
        
        //메서드 테스트
        System.out.println("rect1 길이 : " + rect1.primeter());
        System.out.println("rect1 넓이 : " + rect1.area());

        
        System.out.println("------------------------------");
        
        Rectangle rect2 = new Rectangle(3, 4);

        System.out.println("rect1 가로 : " + rect2.width);
        System.out.println("rect1 세로 : " + rect2.height);
        
        //메서드 테스트
        System.out.println("rect1 둘레 : " + rect2.primeter());
        System.out.println("rect1 넓이 : " + rect2.area());
        
    
    }

}
