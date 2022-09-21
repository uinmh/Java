package edu.java.inheritance03;

public class Car {
    //field 
    private double fuel;
    private double speed;
    
    public Car(double fuel,double speed) {
        this.fuel = fuel; // 연료
        this.speed = speed; // 속력
    }
        
    public void drive() {
        System.out.println("Speed : " + speed + " fuel : " + fuel);
     }

    public double getFuel() {
        return fuel;
    }

    public double getSpeed() {
        return speed;
    }
    
}
