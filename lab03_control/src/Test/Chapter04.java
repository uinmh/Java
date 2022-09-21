package Test;

import java.util.Random;
import java.util.Scanner;

public class Chapter04 {

    public static void main(String[] args) {

     // 1부터 10까지 자연수들의 합
        
        int sum = 0;
        for (int n = 1; n <= 10; n++) {
            sum += n; // sum = sum + n;
            System.out.println("sum = " + sum);
        }
          
        
    // 100이하의 자연수 중 3의 배수들의 합 : sum = 3 + 6 + 9 ..... + 99
        
        sum = 0;
        
        for (int n = 0; n <= 100; n += 3) {
            sum += n;            
        }
        System.out.println("3의 배수들의 합 = " + sum);

     // =============for 문 예제 (1)=================
        sum = 0;
        
        for (int n = 1; n <= 100; n++) {
            if ( n % 3  == 0) {
                sum += n;
            }
        }System.out.println("3의 배수들의 합 = " + sum);
       
     // ================while 문 예제=====================
        
        sum = 0;
        int n = 1;
        
        while (n <= 100) {
            if (n % 3 == 0) {
                sum += n;
            }
            n++;
        }
        System.out.println("3의 배수들의 합 = " + sum);
        
      // ================================================
    }
}
