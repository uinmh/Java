package edu.java.class01;



// 클레스 : 데이터 + 기능 + 생성자 == > 데이터 타입
public class User { // constructor -1

    // 객체가 가지는 속성들(데이터를 정의)

    String userId;
    String password;
    int age;
    
    // 생성자 (Constructor)
    // 객체를 메모리에 생성하고 초기화 해 주는 기능을 담당.
    // 모든 클래스는 생성자가 적어도 하나 이상은 있어야함.
    // 클래스를 작성할 떄 생성자를 하나도 정의 하지 않으면,
    // 자바 컴파일러가 기본 생성자를 자동으로 만들어 줌.
    // 클래스를 작성할때 개발자가 생성자를 정의하면, 자바 컴파일러는 기본 생성자를 자동으로 만들지 않음!
    // 생성자의 이름은 클래스의 이름과 동일. 생성자는 리턴 타입을 사용하지 않음.
    
    
    // 기본생성자 )(default constructor) - argument를 가지지 않는 생성자
    // 모든 속성들을 그 타입의 기본값으로 초기화함.
    // 숫자 타입 기본값: 0, boolean 타입 기본값: false, 참조타입 기본값: null
    public User() { // argument가 없는 경우 (void는 쓰지 않음)

        // Do nothing.
    }
    
    // argument를 갖는 생성자
    public User(String userId, String password, int age) { // constructor - 2
        
        this.userId = userId;
        this.password = password;
        this.age = age;
        
    }
    
    public User(String userId, String password) { // constructor - 3
//        this.userId = userId;
//        this.password = password;
        this(userId, password, 0); // 이때 this는 생성자 constructor - 2번을 호출
        
    }
    
    
    public User(String userId) { // constructor - 4
    
//        this.userId = userId;
//        this(userId, null,0); // constructor -2  호출
          this(userId, null); // constructor - 3 호출
    }
    
    // 생성자 오버로딩(overloading) 파라미터가 다른 생성자를 여러개 정의하는것.
    
    // this의 의미:
    // (1) 생성된 객체의 주소 : (예) this.userId, this.password, ...생성된 주소의 위치를 보여줌.
    // (2) 생성자: overloading된 다른 생성자를 사용할 때
}
