// 주석(Comment): 프로그램에 대한 설명을 작성.
// 주석은 컴파일할 때 제외됨.(실행되지 않는 코드)


package edu.java.intro1; // 패키지 선언문.
//자바에서의 모든 문장은 세미콜론(;)으로 끝남.


// 클래스 선언(정의)
public class AppMain1 {
	
	//main 메서드(method) : 자바 프로그램의 시작과 끝.
	public static void main(String[] args) {
		System.out.println("Hello, 자바!");	
//		for (int i = 0; i < 5; i++) {
//		    for (int j = 0; j < i; j++) {
//		        System.out.print("*");
//		    }
//		    System.out.println();
		    
		for (int a = 0; a < 7; a++) {
		    for (int b = 4; b > 0; b--) {
		        if(a < b) {
		        System.out.print(" ");
		        }else {
		            System.out.print("*");
		        }
		    }
		    System.out.println();
		}
		}
	} // end main
	
// end class


// : inline comment 

/*
 * block comment
 * 문서화 주석 (documentation comment)를 만들때 주로 사용.
 */