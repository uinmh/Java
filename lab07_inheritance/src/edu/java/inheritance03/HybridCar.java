package edu.java.inheritance03;

public class HybridCar extends Car {

    // field
    private int battery;

    public HybridCar(double fuel, double speed,int battery) {
        super(fuel, speed);
        this.battery = battery;
    }
    
    //메서드 override
    //상위 클래스의 메서드를 하위 클래스에서 재정의하는 것.
    //리턴 타입,메서드 이름, 파라미터 선언이 모두 같아야 함.
    //접근제한 수식어는 사위 클래스에서의 수식어보다 범위가 같거나 넓어질 수 있음.
    
    //메서드 overload
    //파라미터가 다르면 같은 이름으로 여러개의 메서드/생성자를 만드는것.
    
    @Override //애너테이션(annotation) 
    public void drive() {
        System.out.println("Speed : " + getSpeed()
                    + " fuel : " + getFuel() + 
                    " battery : " + battery);
    }
}
