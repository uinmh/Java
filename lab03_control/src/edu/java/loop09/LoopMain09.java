package edu.java.loop09;

import java.util.Random;

public class LoopMain09 {

    public static void main(String[] args) {
   
    // 연습문제 4 - 3.
    // 주사위 2개를 던졌을때  나오는 눈을 눈1 눈2 형식으로 출력
    // 눈1 + 눈2의 합이 5이면 프로그램 실행을 멈춤
        
        // 난수 생성 방법 1: Random 클래스의 메서드를 사용.
        Random random = new Random();
        // random.nextInt(int a): 0이상 a미만의 정수 난수를 반환하는 점수
        // random.nextInt(int a, int b): a이상 b미만의 정수 난수를 반환하는 함수
        int x = random.nextInt(10);
        
        random.nextInt(1, 5); // 1이상 5미만의 정수 난수를 반환
        System.out.println(x);
        
        // random.nextDouble(): 0.0 이상 1.0 미만의 실수 난수를 반환하는 함수
        double y = random.nextDouble();
        
        System.out.println(y);
        
        
        
        // random.nextDouble(double a,double b) : a이상 b미만의 double 타입 난수를 반환하는 함수
        
        y = random.nextDouble(1.0, 2.0);
        System.out.println(y);
        
        
        
        while (true) {
            
            int nun1 = random.nextInt(6)+1;
            int nun2 = random.nextInt(6)+1;
            
            System.out.println("주사위의 합 = " + nun1 + "+"+ nun2 +" = " + (nun1+nun2));
            
            if (nun1 + nun2 == 5) {
             
            break; 
              
              
            }            
        }// random.nextDouble(double a) : 0.0 이상 a미만의 double타입 난수를 반환하는 함수.
        
        y = random.nextDouble(10.0);
        System.out.println(y);
        
        // 난수 생성방법 2: Math.random() 메서드를 사여ㅛㅇ    
        // Math.random() : 0.0이상 1.0a미만의 double타입 난수를 반환하는 점수.
        
          y = Math.random();
          System.out.println(y);
          
          // Math.random() 메서드를 사용해서 1부터 6까지 주사위눈 난수를 생성하려면,
          // 1이상 7 미만의 실수에서 소숫점 이하를 버리고 정수 부분만 취함.
          x  = (int) ( 6 * Math.random() + 1);
          System.out.println(x);
          
          
          System.out.println("-------------------------");
          
          // 무한 루프(반복문)을 만드는 방법
          // 1,for ( ; ; ) {...}
          // 2. while (true) {...}
          
          while (true) {
              x = (int) (6 *Math.random() + 1);
              y = (int) (6 *Math.random() + 1);
              
              System.out.println("( " + x + "," + (int)y +" )");
              if( x + y == 5) {
                  break;
              }
          }
                
          
    }

}
