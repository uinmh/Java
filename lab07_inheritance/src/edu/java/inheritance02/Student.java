package edu.java.inheritance02;


// 학생은 사람이다 -> Person : SuperClass, Student : Subclass

public class Student extends Person {

    //field
    private String level;
    private String school;
    
    public Student() {
//        super(); // superclass의 기본 생성자 호출 (생략가능)
        System.out.println("Student() 생성자 호출");
        
    }
    
    public Student(String school) {
//      super();
        // superclass의 생성자를 명시적으로 호출하지 않은 경우에는 "기본 생성자"가 자동으로 호출됨.
        this.school = school;
        System.out.println("Student(school) 생성자 호출");
    }
    
    
    public Student(String name,String school) {
        super(name);
        this.school = school;
        System.out.println("Student(name, school) 생성자 호출");
    }
    
    // getter setter
    
    public String getSchool() {
        return this.school; 
    }
    
    public void setschool(String school) {
       
        this.school = school;
    }
    
    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
    
    
    
    
}
