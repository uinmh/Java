package edu.java.exception01;

import java.util.Scanner;

// 오류(error) vs 예외(exception) 
// 오류(error)의 종류 : 
// 1. 시스템 에러 : (예) OOM (Out - Of - Memory, 메모리 부족) - 수정 불가능. 수정이 힘듬.
// 2. 컴파일 (compile) 에러 : 문법 오류. -> 반드시 수정해야함. (빨간줄)
// 3. 논리적인 오류 : 프로그램이 정상적으로 컴파일 되고 실행 / 종료가 되지만 원하는 결과가 나오지 않는 경우.
//    -> 반드시 수정. 수정 힘듦.
// 4. 예외(exception) : 프로그램 실행 중에 발생할 수 있는 비정상적인 상황 -> 반드시 수정.
// -> (1) if - else 문장
// -> (2) try - catch 문장


public class ExceptionMain01 {

    public static void main(String[] args) {
    
        String s = "";
        
        if (s == null) { // null Point excpetion 은 널인가요 아닌가요 써서...
         System.out.println("null");   
        }else {
        System.out.println("문자열의 길이 = " + s.length());
        }
        Scanner sc = new Scanner(System.in);
    
        System.out.print("x = ");
        
        int x = Integer.parseInt(sc.nextLine());
        
        System.out.print("y = ");
        
        int y = Integer.parseInt(sc.nextLine());
        
        if (y == 0) {
            System.out.println("0으로는 나눌수 없음.");
        }else {
        
        int result = x / y;
        System.out.println("몫 = " + result);
        }
    }

}
