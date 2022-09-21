package edu.java.array06;

public class ArrayMain06 {

    public static void main(String[] args) {
        
        
        // 2차원 배열 선언과 생성
        // 타입[][] 배열이름 = new 타입[][];
        // 이때 열의 개수는 생략해도 되지만, 행의 개수는 생략하면 안됨.
        
        // 배열을 생성할 때, 행과 열의 개수 모두 결정.
        int[][] array1 = new int[2][3];
        
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array1[i].length; j++) {
                array1[i][j] = i + j ;
            }
        }
        for (int[] arr : array1) {
            for(int x : arr) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
        
        // 2. 2차원 배열을 만들때 행의 개수는 정해져 있으나 열의 개수가 결정되지 않는 경우
        
        int[][] array2 = new int[2][];
        
        array2[0] = new int[2];
        array2[0][0] = 1;
        array2[0][1] = 2;
        array2[1] = new int[3];
        array2[1][0] = 3;
        array2[1][1] = 4;
        array2[1][2] = 5;
        
        for (int[] arr: array2) {
            for(int x : arr) {
                System.out.print(x + " ");
                    
            }
        }
        System.out.println();
        System.out.println("========================");
        
        
        //정수들의 1차원 배열 2개를 원소로 갖는 2차원 배열을 선언
        //첫번째 1차원 배열에는 1,3,5,7,9를 저장하세요.
        //두번쨰 1차원 배열에는 0,2,4,6,8,10을 저장하세요.
        //2차원 배열의 내용을 출력.
        
        int[][] array3 = new int[2][];
        
        array3[0] = new int[5];

        for (int i = 0; i < array3[0].length; i++) {
        
            array3[0][i] = i*2+1;
        
        }
        
        array3[1] = new int[6];    
        
        for(int j = 0; j < array3[1].length; j++) { 
            
                
                array3[1][j] = 2 * j ;

        } 
        for (int[] arr : array3) {
            for(int x : arr) {

                System.out.print(x + " ");
                
            }
            System.out.println();
        }
    
        
        
        System.out.println("=======================");
        
        
        int[][] numbers = new int[2][];
        numbers[0] = new int [5];
        numbers[1] = new int [6];
        
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i].length; j++) {
                if ( i == 0) {
                    numbers[i][j] = 2 * j + 1;
                }else {
                    numbers[i][j] = 2 * j;
                }
            }
        }for (int[] num : numbers) {
            for(int x : num) {

                System.out.print(x + " ");
                
            }
            System.out.println();
        }
    }
}

