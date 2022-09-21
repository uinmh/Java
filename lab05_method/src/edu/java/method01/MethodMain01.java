package edu.java.method01;

public class MethodMain01 {
    
    // 메서드(method) : class안에서 정의하는 함수.(기능)
    // 프로그램에서 반복되는 기능을 코드 블록을 작성한것.  
    // 자바는 클래스 안에서만 함수를 작성 할수 있음 클래스 밖에서는 작성할 수 없음.
    // 자바는 메서드 안에서 메서드를 정의 할 수 없음!
    
    
    // argument: 인수. 메서드를 호출하는 곳에서 메서드에게 전달하는 값.
    // parameter : 매개변수. 인자. argument를 저장하기 위한 매서드의 지역 변수.
    // return value : 반환 값. 메서드가 기능을 모두 수행한 후에 메서드를 호출한 곳으로 반환하는 값.
    // 메서드는 리턴값이 있을 수도 있고, 없을 수도 있음.
    
    
    // 메서드 정의(선언) 방법 :
    
    // [단어] <== 생략해도됨.
    // [수식어] 리턴타입 메서드이름([파라미터 선언, ....]){ .... }
    // void 는 함수가 리턴하는 값이 없을떄 . 
    
    
    // main 매서드 - 프로그램 시작점.
    public static void main(String[] args) {
        //Todo Auto-generated method stub
        
        System.out.println("1"); // println() 메서드 호출
        newLine(); // newLine() 메서드 호출
        System.out.println("2");
        newLines(3); // newLines() 메서드를 호출하면서 3 을 argument로 전달
        System.out.println(3);
    }//end main

    // 함수를 정의(선언)
   
    
    
    /*
     * 콘솔에 빈줄 하나를 출력
     */
    public static void newLine() {
        System.out.println();
    }
    
    /**
     * 
     * 빈줄 n개를 출력
     * 
     * @param n 출력할 빈 줄의 개수. 양의 정수.
     */
    public static void newLines(int n) {
        for (int i = 0; i < n; i++) {
            newLine();
        }
    }
    
    
}
