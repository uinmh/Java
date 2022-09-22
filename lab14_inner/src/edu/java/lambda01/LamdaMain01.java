package edu.java.lambda01;

public class LamdaMain01 {

    public static void main(String[] args) {
        // 인터페이스를 사용 - 인터페이스를 구현하는 클래스.
        // 1. 인터페이스를 구현하는 클래스를 별도의 Java 파일에서 정의

        Calculable adder = new Adder(); // Calculable < == 다형성 <== Adder로 안하고...

        double result = adder.calculate(1, 2);

        System.out.println(result);

        // 2. 지역 클래스(local class)
        class Subtracter implements Calculable {

            @Override
            public double calculate(double x, double y) {
                return x - y;
            }
        }
        Calculable subtracter = new Subtracter();
        result = subtracter.calculate(1, 2);
        System.out.println(result);
        
        
        
        // 3.익명 클래스 (anonymous class)
        Calculable multiplier = new Calculable() {  
            @Override
            public double calculate(double x, double y) {
                return x * y;
            }
        };
        result = multiplier.calculate(1, 2);
        System.out.println(result);
    
        // 4. 람다 표현식(Lambda expression)
//        Calculable divider = (x, y) -> { return x / y; };
        Calculable divider = (x, y) -> x / y;
        result = divider.calculate(1, 2);
        System.out.println(result);
        
        // 람다 표현식 (Lambda expression - 함수 표기법) 
        // 클래스 정의와 객체생성을 동시에 하는 익명 클래스를 간단히 작성하기 위한 문법.
        // 함수형 인터페이스(functional interface)만 람다 표현식으로 작성할 수 있음.
        // 함수형 인터페이스 : 추상 메서드를 오직 한 개만 갖는 인터페이스.
        // (param,....) -> { .... code ....} <- 기본
        // 람다 표현식의 파라미터에서는 타입을 생략해도 됨.
        // 람다 표현식의 body({....})에서 실행 문장이 하나만 있는 경우 {} 생략해도 됨/
        // 람다 표현식의 body가 return 문장만 있는 경우에는, {}와 return 키워드까지 생략.
        // 리턴값만 작성 (param,...) -> 리턴값 
        // 람다 표현식에서 파라미터 갯수가 1개인 경우 ()를 생략이 가능함.
        
        
        Printable printer1 = new Printable() {
            
            @Override
            public void print(String msg) {
                
                System.out.println(msg.toLowerCase());
                
            }
        };
        
        printer1.print("Hello Lambda!");
        
        // 람다 표현식
        
//        Printable printer2 = (msg) -> {System.out.println(msg.toUpperCase());};
        Printable printer2 = msg -> System.out.println(msg.toUpperCase());
        
        printer2.print("Hello Lambda!");
        
        
        // 메서드 참조(method reference) 1:
        // 람다 표현식에서 파라미터가 1개이고, 메서드 body의 실행 문장도 1개 뿐인데,
        // 람다 표현식의 파라미터가 실행 문장의 argument로 그대로 전달되는 경우.
//        Printable printer3 = msg -> System.out.println(msg); |
        Printable printer3 = System.out::println;      // < ---
        
        printer3.print("Hello Lambda!");
        
        
//        Mapper mapper = s -> s.length();// 문자열이 들어갔을때 문자열의 갯수를 나타냄
        Mapper mapper = String :: length;
        System.out.println(mapper.map("olleh"));
        
        
    } // m

} // c
