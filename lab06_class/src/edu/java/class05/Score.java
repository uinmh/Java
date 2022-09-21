package edu.java.class05;

public class Score {
    
    // field 
    
    int korean; // 국어
    int english; // 영어
    int math; // 수학

    // constructor - 기본 생성자, argument를 갖는 생성자.
    
    public Score() {
        
    }
    
    public Score(int korean, int english, int math) {
    
        this.korean = korean;
        this.english = english;
        this.math = math;
    }
    
    // 세 과목의 점수를 출력하는 메서드.
    
    public void scoreview() {
        
        System.out.println("국어 : " + this.korean);
        System.out.println("영어 : " + this.english);
        System.out.println("수학 : " + this.math);
        
    }

    // 세 과목의 총점을 리턴하는 메서드.

    
    public int scoreSum() {
        return this.korean + this.english + this.math; 
    }
    
    
    // 세 과목의 평균(소수점)을 리턴하는 메서드
    public double scoreAvg() {
        return (double)scoreSum() / 3;
    }
    
    
}
