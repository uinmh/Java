package edu.java.exception06;

public class ExceptionMain06 {

    public static void main(String[] args) {

        Calculator cal = new Calculator();

        try {
            int result = cal.divide(100, 0);
            //반드시 예외 처리를 해야 하는 exception을 throws한다고 선언된 메서드를
            //호출할 때는 반드시 try-catch구문을 사용하거나 throws 선언문을 메서드에 추가해야함.
            System.out.println(result);
        } catch (Exception e) {
            // TODO Auto-generated catch block
//            e.printStackTrace();
            //예외가 발생한 이유와 예외가 발생되기 까지의 코드 호출 순서를 출력해줌.
            System.out.println(e.getMessage());
        }
    System.out.println("정상 종료");
    }
    

}
