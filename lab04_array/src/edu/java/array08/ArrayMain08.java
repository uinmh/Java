package edu.java.array08;

import java.util.Random;

public class ArrayMain08 {

    public static void main(String[] args) {

        // ch. 6-2 Ex. 5 (p201)
        // 1차원 정수 배열 3개를 갖는 2차원 배열을 선언

        Random random = new Random();
        
        int[][] array = new int [3][];
        
        
        // 첫번째 배열에는 난수2개, 두번째 배열에는 난수3개, 세번째 배열에는 난수 4개
        // 난수 범위는 [70,100). 70이상 100미만
    
        for (int i = 0; i < array.length; i++) {
                
            array[i] = new int[i + 2];
                
            for(int j = 0; j < array[i].length; j++) {
                array[i][j] = random.nextInt(70,100);
            }
            
        }
        
        // 배열의 원소들을 출력
        
        for (int[]arr : array) {
            for(int x :arr) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
        
        // 2차원 배열 array의 모든 원소들의 합(sum) 계산하고 출력
        
        int sum = 0; // 모든 원소들의 합계를 저장할 변수
        int count =0; // 배열의 원소들의 개수를 저장할 변수
        for (int[]arr : array) {
            for(int x : arr) {
             
                sum += x;
                count++;
            }
            
        }
        System.out.println("총합 " + sum);
        System.out.println("count" + count);

        // 차원 배열 array의 모든 원소들의 평균을 계산(double)하고 출력
        double average = (double)sum / 9;
    
        System.out.println("평균 " + average);
        
    }   


}
