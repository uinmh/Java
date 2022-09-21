package edu.java.inheritance05;

// final: (자바에서의 final은) 변경할 수 없는.
// final 지역변수 : 값이 한번 초기화 되면 그 값을 변경할 수 없는 지역 변수.
// final 필드 (멤버변수): 반드시 값을 한번 초기화해야 하고, 초기화된 이후에는 값을 변경할 수 없는 필드.
// (1) final 멤버 변수는 선언과 동시에 초기화
// (2) final 멤버 변수를 초기화할 수 있는 생성자가 반드시 있어야 함.
// final 매서드 : 재정의할 수 없는 메서드. Override 할 수 없는 메서드.
// final 클래스 : 확장할 수 없는 클래스. 상속 할 수 없는 클래스.
// (예) java.lang.System, java.lang.String....


//class T extends System{} // final 클래스 System을 상속하는 클래스를 정의할 수 없다.
//class T extends String{} // 

public class InheritanceMain05 {
    
    //field 
    private static final int Max = 3; // 선언과 동시에 초기화
    
    private final int x; // 선언과 동시에 초기화하지 않은 필드
    private int y; // final이 아닌 필드는 명시적인 초기화가 필수는 아님.

//final 메서드 : 재정의할 수 없는 메서드. override 할 수 없는 메서드. 
    
class A {
    public final void test1() {
        System.out.println("A");
    }
    public void test2() {
        System.out.println("A2");
    }
}
class B extends A {
//    public final void test1() {    
//    }
    //부모(상위) 클래스의 final 메서드는 자식(하위) 클래스에서 재정의(Override)할 수 없다.
    @Override
    public void test2() {
        super.test2(); // 상위 클래스의 override 전 메서드 기능을 사용.
        // 하위 클래스에서 필요한 기능 작성.
    }
}
    public InheritanceMain05(int x) {
        this.x = x; // 반드시 생성자에서 초기화하는 코드가 있어야함!
    }
    public static void main(String[] args) {
        
      final int n = 10;
//         n = 100; // final 지역변수에는 새로운 값을 할당할 수 없음.
      
        

    }

}
