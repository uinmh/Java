package edu.java.array03;

import java.util.Random;

public class ArrayMain03 {

	public static void main(String[] args) {
	     // Random 객체를 선언, 생성.
		 // 정수 10개를 저장할수 있는 배열(scores) 선언.
		 // 배열 scores 에 0 이상 10이하의 정수 난수들 10개를 저장
	     // 배열 scores에 저장된 모든 점수들의 합계를 계산하고 출력.
	     // 배열 scores에 저장된 모든 점수들의 평균을 소수점까지 계산해서 출력 (double)
        Random random = new Random();
       
        int[] scores = new int[10]; // new 타입[원소 개수]
       
        int total = 0;
        double average = 0;

       
        for (int i = 0; i < scores.length; i++) {
           
            scores[i] = random.nextInt(11);
           
        }  
        
        for (int j : scores) {
            System.out.print(j+ " ");
        }

        for (int i = 0; i < scores.length; i++) {
                 
                    total += scores[i];              
                     
        }
        
        //for (int x : scores){
        //    total += x;          
        //  }
        
        
        for (int i = 0; i < scores.length; i++) {
        	
        	average = (double)total / scores.length;
        
        }
        
        System.out.println();
        System.out.println("총합 " + total);
        System.out.println("평균 " + average);
	
	}
	

}
