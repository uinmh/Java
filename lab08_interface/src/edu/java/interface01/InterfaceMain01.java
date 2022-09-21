package edu.java.interface01;

// import static 문장 : static 필드, 메서드, 클래스 이름을 import할때사용
import static edu.java.interface01.DatabaseModule.DB_VERSION;


// 인터페이스(interface):
// 사용 목적 : 팀/회사 간의 분업/협업을 하기 위해서 메서드(기능)들의 프로토타입(prototype, signature)를 약속하기 위한 규약.
// 인터페이스가 가질 수 있는 멤버들 : 
// 1) public static final 필드(멤버 변수). "public static final" 은 보통 생략함
// 2) public abstract 메서드. "public abstract"는 보통 생략함.

// 인터페이스를 선언할 때는 interface 키워드를 사용.
// 인터페이스는 객체를 생성할 수 없고, 인터페이스를 "구현"하는 클래스를 정의해서 객체를 생성함.
// - 구현 클래스 : class 클래스이름 implements 인터페이스 이름 {....}
// 클래스는 단일 상속만 가능 하지만 인터페이스 구현은 개수 제한이 없음.
//

public class InterfaceMain01 {

    public static void main(String[] args) {
    
        // 인터페이스의 필드는 public static final.
        System.out.println(DB_VERSION);
        // DatabaseModule.DB_VERSION = 2;
        
        // OracleDatabaseModule 타입의 객체를 생성.
//        OracleDatabaseModule oracle = new OracleDatabaseModule();
   
        // MariaDbModule 타입의 객체를 생성 
//        MariaDbModule db = new MariaDbModule();
        
        // 다형성 : SuperType variable = new SubType();
//        DatabaseModule db = new MariaDbModule();
        DatabaseModule db = new OracleDatabaseModule();
        
        db.create(100, "가나다라");
        db.read();
    }

}
