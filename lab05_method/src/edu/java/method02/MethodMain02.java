package edu.java.method02;

public class MethodMain02 {

    public static void main(String[] args) {
        //리턴 타입과 argument를 갖는 메서드 작성/호출 연습
        
        // add() 메서드 호출
        add(1, 2);
        double result = add(1, 2);
        
        System.out.println(result);
        
        
        
        // subtract() 메서드 호출.
        
        result = subtract(1, 2);
        System.out.println(result);
        
        // multiply() 메서드 호출.
        result = multiply(1, 2);
        System.out.println(result);
       
        // divide() 메서드 호출.
        result = divide(1, 2);
        System.out.println(result);
        
    }

    
    /**
     * 숫자 2개를 전달받아서, 두 숫자의 합을 덧셈 결과를 반환.
     * @param x double.
     * @param y double. 
     * @return x + y.
     */
    public static double add(double x, double y) {
        
        // return: (1) 메서드를 호출한 곳에 값을 변환. (2) 메서드 종료. 
        return x + y;
        
    }
    /**
     * 숫자 2개를 전달 받아서, 두 숫자의 뺄샘의 결과를 반환
     * @param x  double.
     * @param y  double.
     * @return x - y.
     */
    public static double subtract(double x, double y) {
        
        return x - y;
        
    }
    /**
     * 숫자 2개를 전달 받아서 두 숫자의 곱샘의 결과를 반환
     * @param x double.
     * @param y double.
     * @return x * y
     */
    // multiply ( x * y )
    
    public static double multiply(double x, double y) {
        
        return x * y;
 
    }
    /**
     * 숫자 2개를 전달 받아서 두 숫자의 나눗샘의 결과를 반환
     * @param x double.
     * @param y double.
     * @return x / y
     */
    // divide ( x / y)
    
    public static double divide (double x, double y) {
        
        return x / y;
        
    }
    
}
