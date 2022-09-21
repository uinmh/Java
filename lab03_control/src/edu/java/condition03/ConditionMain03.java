package edu.java.condition03;

import java.util.Scanner;

public class ConditionMain03 {

    public static void main(String[] args) {
     
        // Scanner 타입의 변수 선언,초기화,
        // int 타입 변수에 콘솔에서 입력한 정수를 저장
        // 입력한 점수가 
        //90점 이상이면 a,
        //80점 이상이면 b, 
        //70점 이상이면 c, 
        //60점 이상이면 d, 
        //60점 미만이면 f
        
        Scanner scanner = new Scanner(System.in);
    
        System.out.println("이름을 입력하세요.");
        
        String st = scanner.next();
    
        System.out.println("시험점수를 입력하세요.");
       
        int totalscore = scanner.nextInt();
        
        if (totalscore >=90) {
            System.out.println(st + " 님의 학점은 A 학점 입니다.");
            } else if (totalscore >= 80) {
                System.out.println(st + " 님의 학점은 B 학점 입니다.");
            } else if (totalscore >= 70) {
                System.out.println(st + " 님의 학점은 C 학점 입니다.");
            } else if (totalscore >= 60) {
                System.out.println(st + " 님의 학점은 D 학점 입니다.");
            } else {
                System.out.println(st + " 님의 학점은 F 학점 입니다.");
        }
             
        
    }

}
