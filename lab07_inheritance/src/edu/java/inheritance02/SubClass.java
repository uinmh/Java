package edu.java.inheritance02;

public class SubClass extends SuperClass{

    public SubClass() { //예시 (1)
        super(0);
        // superclass가 기본 생성자를 갖고 있지 않기 때문에,
        // 명시적으로(explicitly) superclass의 argument를 갖는 생성자를 호출해야만 함!
    }
    public SubClass(int a) { //예시 (2)
        super(a); 
    }

}
