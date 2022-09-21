package edu.java.loop12;

import java.util.Scanner;

public class LoopMain12 {

    public static void main(String[] args) {
   
        
        boolean run = true; // 프로그램을 계속 실행할지, 종료할지 결정할 변수.
        int balance = 0; // 은행 계좌에 잔고를 저장할 변수.
        Scanner sc = new Scanner(System.in); // 콘솔창에서 키보드로 입력받기 위한 도구.
        
        while (run) { 
            
        System.out.println("---------------------------------");
        System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
        System.out.println("---------------------------------");
        System.out.print("선택> ");
        
        int menu = sc.nextInt(); // 1 ~ 4  정수 입력
        switch (menu) {
        
        case 1: 
            System.out.println("예금 금액을 입력 해주세요.");
            int deposit = sc.nextInt();
            balance += deposit;               
            break;
            
        case 2:
            System.out.println("출금 금액을 입력 해주세요.");
            int chulguem = sc.nextInt();            
            if(chulguem > balance) {
                System.out.println("잔액이 부족 합니다.");
            }
            else{ 
                System.out.println(chulguem + "원 이 출금 되었습니다.");
                balance -= chulguem;
            }
            break;
            
        case 3:
            System.out.println("잔고는 " + balance + "원 입니다.");
            break;
        case 4: 
            run = false;
            break;
       
        default: 
            System.out.println("잘못 입력했습니다. 메뉴를 다시 선택");
        }
            
        }
        
        System.out.println("프로그램 종료");
        
    }

}
