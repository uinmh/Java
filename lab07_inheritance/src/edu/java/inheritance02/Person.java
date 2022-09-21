package edu.java.inheritance02;

public class Person {

    //field 
    private String name;
    
    //생성자
    
    //1) 기본생성자 
    public Person() {
        System.out.println("Person() 생성자 호출");
    }
    //2) argument를 갖는 생성자
    
    public Person(String name) {
        this.name = name;
        System.out.println("Person(name) 생성자 호출");
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    
}
