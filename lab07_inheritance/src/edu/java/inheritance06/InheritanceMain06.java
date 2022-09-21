package edu.java.inheritance06;

import java.util.Random;
import java.util.Scanner;

public class InheritanceMain06 {

    public static void main(String[] args) {

        // java.lang.Object 클래스 : 자바의 최상위 클래스
        // - > 자바의 모든 클래스 Object 클래스의 public 멤버(변수, 메서드)를 상속 받아서 사용, 재정의(Override)할 수
        // 있음.
        // - > toString(), equals(), hashCode(), .....

        T t = new T();

        System.out.println(t.getClass());
        System.out.println(t.hashCode() + " = " + Integer.toHexString(t.hashCode()));
        // Integer.toHexString(int i) : 정수 i를 16진수 문자열로 변환해서 리턴.

        // 같은내용
        System.out.println(t.toString());
        System.out.println(t);
        // println(Object x) 메서드는 argument로 전달된 객체의 toString() 메서드를 호출하고,
        // 그 객체의 toString() 메서드가 리턴해 주는 문자열들 콘솔창에 출력
        // -> Object의 toString() 메서드를 하위 클래스에서 Override하면 콘솔창 출력을 바꿀 수 있음.

        Random random = new Random();
        System.out.println(random); // Random 클래스는 Object의 toString() 메서드를 Override 하지않음.

        Scanner sc = new Scanner(System.in);
        System.out.println(sc); // Scanner 클래스는 Object의 toString() 메서드를 Override 하고있음.

        System.out.println("\n ------------------ \n");

        // point 타입 객체 생성
        Point p1 = new Point();
        System.out.println(p1);

        Point p2 = new Point(0, 0); // argument를 갖는 생성자.
        System.out.println(p2);

        System.out.println("== 결과 : " + (p1 == p2)); // 주소값이 다르니 같지가 않다.
        // == =! 연산자는 객체가 생성된 주소값(참조값)을 직접 비교.
        // 생성자를 호출할 때마다 새로운 객체가 Heap에 생성되기 때문에, 그 주소값들은 다름.
        // 서로 다른 인스턴스에 대해서 == 연산자는 항상 false를 리턴함. (서로 주소가 달라서)

        System.out.println("equals() 메서드 결과: " + p1.equals(p2));
        // Object 클래스의 equals()를 재정의 해서
        // Point 객체의 x,y 값들이 서로 같으면 true를 리턴하게 정의.

        // equals() 메서드가 재정의된 클래스 예 : java.lang.String
        String s1 = new String("안녕하세요.");
        String s2 = new String("안녕하세요.");
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));

        // 두 객체가 같은 지를 비교할 떄 그 주소 값이 아니라 객체들이 가지고 있는 멤버들의
        // 값으로 비교하고 싶을 때는 equals() 메서드를 재정의함.
        // 문자열이 같은지를 비교할 때는 절대로 비교연산자(==, !=)를 사용하지 말고,
        // equals() 메서드를 사용해서 비교!
        
        System.out.println("\n ------------------ \n");
        
        
        User user1 = new User("admin", "1234");
        
        System.out.println("ID : " + user1.getId());
        System.out.println("PM : " + user1.getPass());
        System.out.println(user1);
        
        
        User user2 = new User("admin", "admin00");
        

        System.out.println(user1.equals(user2));
        System.out.println(user1.hashCode());
        System.out.println(user2.hashCode());
        
    }

}

class T {
}

class U {
}