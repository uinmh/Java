package edu.java.loop08;

public class LoopMain08 {

    public static void main(String[] args) {


        // 중첩 반복문
        // 구구단 
        int dan;
        int i;
        
        
        
        for (dan = 2; dan < 10; dan++) {
            for(i = 1; i < 10; i ++) {
                System.out.println(dan + " x " + i + " = " + dan * i );
            }
            System.out.println();
        }
        
        
        
        
        for (dan = 2; dan < 10; dan++) {
            System.out.print("[" + dan + "단]\t");
        }
            System.out.println();
            for (i = 1; i < 10; i++) {
                for (dan = 2; dan <10; dan++) {
                System.out.print(dan + "x" + i + "=" + dan*i + "\t");
            }
                    System.out.println();
        }
            System.out.println();
            System.out.println("=============================");
            
            
               dan = 2;
    
           while(dan <= 9) {
             
               i = 1;
               System.out.println("[ "+ dan + "단 ]");
               
               
                while(i <= 9) {
                          
                System.out.println(dan + "x" + i + "=" + dan*i);

                i++;
            
                }
    
                dan++;
           }

           
           int x = 2;

           
           while (x < 10) {
               
               System.out.println("--- " + x + "단 ---");  
               
               int y = 1;  
            
               while(y < 10) {
            
                   System.out.println(x + "x" + y + "=" + (x*y));
                   
                   y++;
               }
               x++;
           }

           
           
           System.out.println();

           // 2단은 2x2까지 3단은 3x3까지 ----- 출력 
           
           for(int k = 2; k < 10; k++) {
               System.out.println("---- " + k + "단 ----");
               for(int j = 1; j < 10; j++) {
                   System.out.println(k + " x " + j + " = " + (k*j));
                   if(k == j) {
                       break;
                   }
               } // for (j)
           } // for (i)
   
           System.out.println(); 
           
           for(int k = 2; k < 10; k++) {
               System.out.println("---- " + k + "단 ----");
               for(int j = 1; j <= k; j++) {
                   System.out.println(k + " x " + j + " = " + (k*j));
               } // for (j)
           } // for (i)
           
           
           
           
           
           x = 2;
           
           while ( x < 10 ) {
              
               System.out.println("--- " + x + "단 ---");
               
                             
               int y = 1;
               
               while (y < 10) {
                   
                   System.out.println(x + " x " + y + " = " + (x * y));
                   if(x == y) {
                       break;
                   }
                   y++;
                }
               x++;
           }
           
           System.out.println();
    
           x = 2;
           while (x < 10) {
    
               int y = 1;
               while (y <= x) {
               
                   System.out.println(x + " x " + y + " = " + (x * y));
                   y++;
               }
               x++;
            }
           
    }
}
