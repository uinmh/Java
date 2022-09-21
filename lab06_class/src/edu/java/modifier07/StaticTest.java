package edu.java.modifier07;

public class StaticTest {

    int instanceVariable; // 인스턴스 변수
    static int staticVariable; // static 변수
    
    public void printVariables() {
        System.out.println("--- instance method ---");
        System.out.println("인스턴스 변수 = " + instanceVariable);
        System.out.println("static 변수 = " + staticVariable);
    }

    
    public static void printVariables2() {
        
        System.out.println("--- static method ---");
//        System.out.println("인스턴스 변수 = " + instanceVariable);
        // static 멤버는 static이 아닌 멤버를 사용할수 없다.
        System.out.println("static 변수 = " + staticVariable);
    }
}
