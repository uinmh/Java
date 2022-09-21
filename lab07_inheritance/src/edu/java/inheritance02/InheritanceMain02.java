package edu.java.inheritance02;

public class InheritanceMain02 {

    public static void main(String[] args) {
        
        Person p1 = new Person();
        System.out.println(p1.getName());
        
        Person p2 = new Person();
        p2.setName("장민석");
        System.out.println(p2.getName());
     
        System.out.println("\n --------- \n");
        Student s1 = new Student();
        System.out.println(s1.getLevel());
        
        Student s2 = new Student();
        s2.setLevel("3학년");
        s2.setName("장민석");
        s2.setschool("구일고");
        System.out.println(s2.getName());
        System.out.println(s2.getLevel());
        System.out.println(s2.getSchool());
        
        Student s01 = new Student();
        //subclass의 생성자를 호출하면 superclass의 생성자가 먼저 호출되고 난후 subclass의 생성자가 호출됨
        //부모 타입 객체가 먼저 생성되야 자식 타입 객체도 생성됨
        //subclass의 생성자에서 superclass의 생성자를 명시적으로 호출하는 코드가 없는 경우에는
        //superclass의 기본생성자가 자동으로 호출 됨.
        //superclass의 argument가 있는 생성자는 자동으로 호출되지 않음.
        //superclass의 argument가 있는 생성자를 사용하려면 반드시 명시적으로 호출 되어야함. 
        //Student 타입의 객체를 argument 1개를 갖는 생성자로 생성
        //super(....)를 호출하는 코드는 생성자에서 가장먼저 작성 되어야 함!
        //this의 의미 : 
        //(1) 생성된 객체의 주소 : this.field,this.method()
        //(2) overloading된 생성자 : this()
        
        //super의 의미: 
        //(1) 생성된 부모 객체의 주소 : super.field, super.method()
        //(2) superclass의 생성자 : super(),super(.....)
        
        
        
        s01.setschool("Itwill");
        System.out.println(s01.getSchool());
        Student s02 = new Student("아이티윌");
        // Student 타입의 객체를 argument 2개를 갖는 생성자로 생성.
        System.out.println("\n--------------\n");
        Student s3 = new Student("오쌤", "itwill"); 
        
    }

}
