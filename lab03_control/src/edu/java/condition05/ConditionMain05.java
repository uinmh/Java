package edu.java.condition05;

// Ctrl+Shift+0 : optimize import(import 문 최적화)
import java.util.Random;

public class ConditionMain05 {

    public static void main(String[] args) {
    
        // 1.Random 타입 변수를 선언하고, 초기화
    
        // Java 과목의 점수를 0 이상 100이하의 난수를 만들어서 저장.
        
        // SQL 과목의 점수를 0 이상 100이하의 난수를 만들어서 저장.
    
        // JSP 과목의 점수를 0 이상 100이하의 난수를 만들어서 저장.

        // 세 과목의 평균을 계산.
        
        // 모든과목의 점수가 40점 이상이고 , 평균이 60점 이상이면 "합격",
        
        // 그렇지 않으면 "불합격"
        
        Random random = new Random();
        int java = random.nextInt(101);
        int sql = random.nextInt(101);
        int jsp = random.nextInt(101);

        int totalscore = java+sql+jsp;
        double avarage = totalscore / 3.0;
        
        String Score = (java >= 40) && (sql>= 40) && (jsp>= 40) && (avarage >= 60) ? "합격" : "불합격";
        /*
         * if (java >= 40) && (sql >= 40) && (jsp >= 40) && (avarage >= 60) {
         * System.out.println("합격");
         * } else {
         *     System.out.println("불합격");
         *     } 
         */
        System.out.println("Java 점수= " + java);
        System.out.println(" sql 점수= " + sql);
        System.out.println(" jsp 점수= " + jsp);
        System.out.println("시험 평균 = " + avarage);
        System.out.println("합격 여부 = " + Score);
        
        
    }

}
