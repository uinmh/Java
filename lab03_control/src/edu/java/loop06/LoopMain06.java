package edu.java.loop06;

public class LoopMain06 {

    public static void main(String[] args) {


        //for 반복문
        
        for (int i = 1; i <= 5; i ++) {
            System.out.println(i);
        }
            
            System.out.println("==============");
        //while 반복문
        
        int n = 1;
        while (n <= 5) {
            System.out.println(n);
            n++;
        }
        
        
        System.out.println("==============");
        
        // 10에서 1까지 내림차순으로 정리하시오
        
        // for 문
        for (n = 10; n > 0; n--) {
            System.out.print(n+" ");
        }
        
        System.out.println();
        System.out.println("==============");
        
        // while 문
        
        int j = 10;
        
        while (j > 0) {
                System.out.print(j+" ");
                j--;
                
            }
        System.out.println();
        System.out.println("==============");
        
       
        // 10 이하의 양의 홀수들을 한줄에 출력 하시오.
     
        //while 문
        
        int k = 1;
        
        while (k < 10) {
                              
            if (k % 2 == 1) {
              
                System.out.print(k+" ");    
            }
            k++;
        }
        
        System.out.println();
        System.out.println("==============");
        
        n = 1;
        
        while (n <10) {
            System.out.print(n + " ");
            n += 2;
        }
        
        System.out.println();
        System.out.println("==============");
        
        
        // for문을 사용한 사례
        for (int q = 1; q < 10; q ++) {
            
            if (q % 2 == 1) {
                
                System.out.print(q+" ");
            }
        }
        
        
        System.out.println();
        System.out.println("==============");
        
        for (n = 1; n < 10; n += 2) {
            System.out.print(n + " ");
        }
    }

    
}
