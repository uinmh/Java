package edu.java.variable04;

import java.util.Scanner;

public class VariableMain04 {

	public static void main(String[] args) {

		// 콘솔 창에서 숫자를 키보드로 입력 받아서 변수에 저장.
		
		// 1. Scanner 타입의 변수를 선언하고 초기화.
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("정수를 입력>>>");
		
		// 2. Scanner 객체를 사용해서 콘솔 창에서 정수를 입력받고 저장.
		int number = scanner.nextInt();
		System.out.println("number = " + number);
		
		// JAVA시험 점수(정수)를 입력하세요. (변수선언)
		// SQL 시험 점수를 입력하세요. (변수선언)
		// JSP 시험 점수를 입력하세요. (변수선언)
		// 세 과목의 총점(정수)을 계산하고 출력.
		// 세 과목의 평균(소수점)을 계산하고 출력.
		
		
		// Ctrl + Shift + F : 소스 코드 포맷팅(자동정렬)
	}

}
