package edu.java.inheritance09;

public class AbstractMain03 {

    public static void main(String[] args) {

        // Rectangle,circle 클레스를 구현
        // Rectangle,circle 타입의 객체에서 draw()메서드 동작 여부 테스트.

        Circle cir = new Circle("2", 3.2);
        cir.draw();

        Rectangle rec = new Rectangle("2", 3, 5);
        rec.draw();

        Shape[] shapes = { 
                new Rectangle("1", 4, 3), 
                new Circle("1", 10), 
                new Square("3", 5)
                };

        for (Shape s : shapes) {
            s.draw();
        }
    }

}
