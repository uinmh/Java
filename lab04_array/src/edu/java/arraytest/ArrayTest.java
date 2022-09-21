package edu.java.arraytest;

import java.util.Scanner;

public class ArrayTest {

    public static void main(String[] args) {

        boolean run = true; // 프로그램을 계속 실행할지 종료할지를 결정하기 위한 변수.
        int studentNum = 0; // 입력받은 학생수를 저장할 변수.
        int[] scores = null; // 학생들의 점수들을 저장할 배열. ( null : 아무것도없다. 아직 만들지 않겠다. 배열이 만들어지지 않음.)
        Scanner scanner = new Scanner(System.in);
        
        
        while(run) {
            //프로그램이 가지고 있는 메뉴(기능) 보여줌.
            System.out.println("------------------------------------------------------");
            System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
            System.out.println("------------------------------------------------------");
            System.out.print("선택> ");
            
            int selectNo = scanner.nextInt();
            
            if(selectNo == 1) {
                System.out.print("학생수> ");
                studentNum = scanner.nextInt();
                scores = new int[5];
                
                
            } else if(selectNo == 2) {
                for(int i=0; i<scores.length; i++) {
                    System.out.printf("점수[%d]> ",i);
                    scores[i] = scanner.nextInt();
                }
                    
            } else if(selectNo == 3) {
                for(int i=0; i<scores.length; i++) {
                    System.out.printf("점수[%d]> %d \n",i,scores[i]);
                }
            } else if(selectNo == 4) {
                int totalScore = 0;
                int sum1 = 0;
                
                for(int i=0; i<scores.length; i++) {
                        if(scores[i]>totalScore) {
                            totalScore = scores[i];
                    }   sum1 += scores[i];
                }
                double average = (double)sum1 / scores.length;
                System.out.printf("최고 점수 : %d \n",totalScore);
                System.out.println("평균 점수 : " + average);
                
            } else if(selectNo == 5) {
                run = false;
            }       
        }
        System.out.println("프로그램 종료");
        
    }

}
