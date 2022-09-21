package edu.java.loop11;

public class LoopMain11 {

    public static void main(String[] args) {


        for (int a = 0; a <= 4; a++) {
            System.out.println(" ");  
            for (int b =0; b <= 4; b++) {
                if (a > b) {
                    System.out.print("*");    
                }
                
            } 
            
        }
        System.out.println();
        System.out.println("--------------");
        
        for (int a = 1; a <= 4; a++) {
            for (int b =1; b <= a; b++) {
              System.out.print("*");                
            } 
            System.out.println(" ");  
        }
        
        System.out.println();
        System.out.println("--------------");
        
        
        
        for (int a = 1; a <= 4; a++) {
            int spaces = 4 - a; //a번째 줄에서 출력할 공백 갯수 
            for (int b = 1; b <= spaces; b++) { // spaces 갯수만큼 반복하면서
                System.out.print(" "); // 공백 출력
                }
            for (int c = 1; c <= a; c++ ) { // 라인 수만큼 반복하면서
                System.out.print("*"); // "*" 출력
            }
        System.out.println(); //줄바꿈
        }
        
        // ==============================================================
        
        System.out.println();
     
        for (int i = 1; i <= 4; i++) {    // 라인 수가 1 ~ 4 까지
            for(int j = 4; j >= 1; j--) { // 각 줄에서 자릿수 4 ~ 1 까지
                if( j > i ) { // 출력할 자릿수가 라인 숫자보다 크면
                    System.out.print(" ");// 공백
                }else {// 출력 위치가 라인 숫자보다 작거나 같으면
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }

}
