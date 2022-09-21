package edu.java.array07;

import java.util.Random;

public class ArrayMain07 {

    public static void main(String[] args) {
        // chapter 6-2 장 Ex 4 (p200)
        // 정수(int) 10개를 저장하는 배열 (array)
        int[] array = new int[10];
        // 배열에 0이상 10이하 정수 난수 10개를 저장. 
        // 배열의 내역을 출력
        Random random = new Random();
        
        for (int i = 0; i < array.length; i++) {
                        
                array[i] = random.nextInt(11);
         
                System.out.print(array[i] + " ");
                
        }

        System.out.println();
        // 배열에서 최댓값을 찾으세요.
        // max = array[0] 가정
        // for (array 배열의 모든 원소들)
        // if (max < array 원소):
        //     max  = array 원소
        
        int max = array[0];
        
        for (int x : array) { // 배열 array에서 원소를 하나씩 꺼내면서 
            if (max < x) { // 배열에서 꺼낸 원소 x가 max보다 ㅡ다면
                max = x; // 최대값을 더큰 값으로 설정.
            }
        }
        System.out.println("최대값 " + max);
                
        
        
        
        
        
        
        
        
        
    }
    
}


