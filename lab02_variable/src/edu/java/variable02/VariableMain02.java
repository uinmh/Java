package edu.java.variable02;

public class VariableMain02 {

	public static void main(String[] args) {

		// 문자(character): 문자1개. 작은따옴표('')를 사용.
		// 문자열(String): 큰따옴표("")를 사용.
		
		char ch = 'a';
		System.out.println(ch);
		System.out.println((int) ch); // casting: 강제 타입 변환. (문자->숫자)

		ch = 'b';
		System.out.println(ch);
		System.out.println((int) ch);
		
		ch = '한';
		System.out.println(ch);
		System.out.println((int) ch);

		String s = "한글";
		System.out.println(s);
	
	}

}
