package edu.java.method03;

public class MethodMain03 {

    public static void main(String[] args) {
        countdown(-1);
    }

    
    public static void countdown(int n) {
       
        if ( n < 0 ) {
            System.out.println("n 은 0 이상의 정수여야 함.");
         return;//메서드 종료
        }
        
        
        for (int i = n; i >= 0; i--) {
            System.out.println(i);
        }
    }
}
