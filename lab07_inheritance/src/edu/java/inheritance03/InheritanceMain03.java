package edu.java.inheritance03;

public class InheritanceMain03 {

    public static void main(String[] args) {

        Car sonata = new Car(100, 60);
        sonata.drive();

        HybridCar x3 = new HybridCar(50, 60, 100);

        x3.drive(); // 하위 클래스에서 override된 메서드를 호출 (이렇게되면 부모클래스껀 보이지 않게됨)

        // 다형성(polymorphism): 하나의 객체를 두 개 이상의 타입으로 부를 수 있는 것.
        Car k8 = new HybridCar(10, 10, 10);
//        HybridCar x = new Car(100,100); // 컴파일 에러
        k8.drive();
        //다형성을 적용하더라도 override 되어있는 drive() 메서드가 실행됨.
        
        //다형성은 코드의 재사용성을(reuse)을 높여줌.
        //배열/리스트를 사용. 메서드 파라미터 선언.
        //배열을 선언할 때 상위(super) 타입의 배열로 선언하면, 상위 타입은 물론, 그 하위 타입의 객체까지도 저장할 수 있음.
        Car[] cars = {sonata,x3};
        System.out.println(new Car(0, 0));
        System.out.println(new HybridCar(0, 0, 0));
    }
    public static void test(Car car) {
                // 테스트 코드 작성.
        
    }
    public static void test(HybridCar hcar) {
        
    }
    
}
