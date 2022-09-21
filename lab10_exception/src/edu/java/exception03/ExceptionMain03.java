package edu.java.exception03;

import java.util.Scanner;

public class ExceptionMain03 {

    
    private Scanner scanner = new Scanner(System.in);
    
    
    
    public static void main(String[] args) {
      
     ExceptionMain03 app = new ExceptionMain03();
   
     int x = app.inputInteger();
     
     System.out.println("x = " + x);
     
    }

    
    private int inputInteger() {
        
        int x = 0;
      
        while(true) {
            
            try {
            System.out.println("정수를 입력 하세요.");
            x = Integer.parseInt(scanner.nextLine());
            break; //반복문 종료
            
            }catch (NumberFormatException e) {
            System.out.println("입력한 문자열은 정수로 변환 불가능");
            //TODO :  입력받은 정수를 리턴.
            // Integer.parseInt(),scanner.nextline() 사용.
            // NumberFormatException 처리
            }
            
        }
        return x;
    }
    
}
