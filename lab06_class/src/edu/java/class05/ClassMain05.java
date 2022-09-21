package edu.java.class05;

public class ClassMain05 {

    public static void main(String[] args) {
  
        // Score 타입의 객체를 생성하고 메서드들을 테스트.
        
        Score score1 = new Score();
        System.out.println("-------------------------");
        score1.scoreview();
        System.out.println("총점 : " + score1.scoreSum());
        System.out.println("평균 : " + score1.scoreAvg());
     
        System.out.println("-------------------------");
        // student 타입의 객체 생성, 메서드를 테스트.
        
        
        
        Student student = new Student(1,"바보",98,87,90);
        student.stuview();
        System.out.println("-------------------------");
        
        Student student1 = new Student(2,"멍청이",98,87,90);
        student1.stuview();
        System.out.println("-------------------------");
        Student student2 = new Student(3,"해삼",92,83,91);
        student2.stuview();
        System.out.println("-------------------------");
        
        
        
    }

}
