package edu.java.modifier05;

import edu.java.modifier06.PublicClass;
//import edu.java.modifier06.PackageClass;

// 클레스의 접근제한 수식어(access modifier)
// 1. public: 어디에나 공개된 클래스.  import 문장을 사용해서 변수 선언에 사용할 수 있는 클래스.
// 2. (package) [없는경우] : 같은 패키지에 속한 클래스들에게만 공개된 클래스.
// public class의 이름은 java 파일의 이름과 같아야 함.
// 한개의 자바 파일에서 여러개의 클래스를 정의하는것은 가능가능하지만, 
// public class는 오직 한 개만 정의할 수 있음.
// 한 개의 java 파일에서 여러개의 클래스를 정의 하면, 컴파일 후에는 각각의 class 파일들이 생성됨.
class A{}

public class ModifierMain05 {

    public static void main(String[] args) {
       
        //edu.java.modifier06.PublicClass 타입 객체 생성
        PublicClass cls = new PublicClass();
        System.out.println(cls);
        
        A a = new A();
        System.out.println(a);
        

    }

}
