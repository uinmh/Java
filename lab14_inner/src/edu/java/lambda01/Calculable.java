package edu.java.lambda01;

@FunctionalInterface // 추상메서드가 1개인지 이상인지 검사해주는 기능 (람다)
public interface Calculable {

    double calculate(double x, double y);

}
