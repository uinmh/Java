package edu.java.lambda02;

import edu.java.lambda02.Calculator.Calculable;

public class LambdaMain02 {

    public static void main(String[] args) {

        Calculator adder = new Calculator(1, 2); // 덧샘

        double result = adder.calculate(new Calculable() {

            @Override
            public double calculate(double x, double y) {
                return x + y;
            }
        });

        Calculable adder1 = (x, y) -> x + y;
        result = adder1.calculate(1, 2);

        double result1 = adder.calculate((x, y) -> x + y);
        System.out.println("adder = " + result);
        System.out.println("adder = " + result1);
        System.out.println("\n-------------------\n");

        Calculator subtractor = new Calculator(1, 2); // 뺄샘

        result = subtractor.calculate((x, y) -> x - y);

        System.out.println("subtractor = " + result);
        System.out.println("\n-------------------\n");

        Calculator multiplier = new Calculator(1, 2); // 곱샘

//        result = multiplier.calculate((x, y) -> x * y);

        result = multiplier.calculate(new Calculable() {

            @Override
            public double calculate(double x, double y) {
                return x * y;
            }
        });

        System.out.println("multiplier = " + result);
        System.out.println("\n-------------------\n");

        Calculator divider = new Calculator(1, 2); // 나눗샘

        result = divider.calculate((x, y) -> x / y);

        System.out.println("divider = " + result);
        System.out.println("\n-------------------\n");

        // 두 숫자 중에서 더 크거나 같은 수를 찾는 계산기.

        Calculator greater = new Calculator(1, 2);

        // 1
        result = greater.calculate(new Calculable() {

            @Override
            public double calculate(double x, double y) {
//                if (x >= y) {
//                    return x;
//                } else {
//                    return y;
//                }
                return (x > y) ? x : y;
            }
        });
        
        // 2
        result1 = greater.calculate((x, y) -> (x >= y) ? x : y);
        System.out.println("greater = " + result);
        System.out.println("greater = " + result1);
        
        // 3
        result = greater.calculate((x, y) -> {
            if (x >= y) {
                return x;
            } else {
                return y;
            }
        });
        System.out.println("greater = " + result);
        System.out.println("\n-------------------\n");
    }

}
