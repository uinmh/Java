package edu.java.contact.menu;


// enum : 열거형 상수들을 정의하는 특별한 종류의 "클래스"
// -> 생성자, 매서드를 정의할 수 있음.
// -> 변수 타입, 메서드 리턴 타입, 파라미터 타입을 선언할 때 enum 이름을 사용할 수 있음.
public enum MainMenu {
    QUIT,SELECT_ALL,SELECT_BY_INDEX,CREATE,UPDATE,DELETE,UNKNOWN;
    
    public static MainMenu getValue(int n) {
        //정수 n을 enum 타입 값으로 변환해서 리턴.
        MainMenu[] menu = values();
        if(n < 0 || n > menu.length) {
            return menu[menu.length -1];
        }
        
        return menu[n];
    }
}
