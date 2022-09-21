package edu.java.exception06;

// java의 예외(exception) 클래스:
// 1) 반드시 예외 처리를 해야 하는 예외 클래스
//  -> try-catch 문장 또는 throws 선언을 반드시 사용해야 하는 예외.
//  -> try-catch 문장 또는 throws 선언을 하지 않으면 컴파일 에러가 발생함.
//  (예) Exception 
// 2) 예외 처리를 하지 않아도 괜찮은 클래스(unchecked exception)
//  -> try-catch 문장 또는 throws 선언이 없어도 컴파일 에러가 발생하지 않음.
public class Calculator {

    // 예외를 던질(throws) 수 있는 메서드 선언.

    public int divide(int x, int y) throws Exception {
        if (y != 0) {

            return x / y; // 메서드를 호출한곳으로 값을 반환

        }
        // 메서드를 호출한 곳으로 예외를 던짐.
        throw new Exception("y는 0이 될수 없음.");
        // -> 메서드 선언부에 반드시 throws 선언이 있어야함.
    }

}
