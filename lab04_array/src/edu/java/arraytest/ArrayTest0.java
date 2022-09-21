package edu.java.arraytest;

import java.util.Scanner;

public class ArrayTest0 {

    public static void main(String[] args) {
        boolean run = true; // 프로그램을 계속 실행할지 종료할지를 결정하기 위한 변수.
        int studentNum = 0; // 입력받은 학생수를 저장할 변수.
        int[] scores = null; // 학생들의 점수들을 저장할 배열. ( null : 아무것도없다. 아직 만들지 않겠다. 배열이 만들어지지 않음.)
        Scanner scanner = new Scanner(System.in);

        while (run) {
            // 프로그램이 가지고 있는 메뉴(기능) 보여줌.
            System.out.println("------------------------------------------------------");
            System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
            System.out.println("------------------------------------------------------");
            System.out.print("선택> ");

            int selectNo = Integer.parseInt(scanner.nextLine());
            // 콘솔창에서 문자열을 입력받아서 INT로 변환

            if (selectNo == 1) {
                // 학생수를 입력 받기.
                System.out.print("학생수> ");
                studentNum = Integer.parseInt(scanner.nextLine());
                // 입력받은 학생수 크기의 배열을 생성
                scores = new int[studentNum];
                System.out.println("scores length = " + scores.length);

            } else if (selectNo == 2) { // 점수 입력
                // 배열의 scores 길이만큼 반복하면서 점수를 입력받고, 배열에 저장.

                if (scores == null) {
                    System.out.println("학생 수를 먼저 입력 하세요...");
                    continue; // while 반복문을 처음부터 다시 시작
                }

                for (int i = 0; i < scores.length; i++) {
                    System.out.printf("scores[%d]> ", i);
                    scores[i] = Integer.parseInt(scanner.nextLine());
                }

            } else if (selectNo == 3) {
                // 배열 scores 에 저장된 모든 점수 출력.

//                for(int i=0; i<scores.length; i++) {
//                    System.out.println("scores[" + i + "]> " +scores[i] );
//                }
                if (scores == null) {
                    System.out.println("학생수를 먼저 입력 하세요.");
                    continue; // while 반복문을 처음부터 다시 시작
                }

                int count = 0;
                for (int x : scores) {
                    System.out.println("scores[" + count + "]> " + x);
                }
            } else if (selectNo == 4) {

                if (scores == null) {
                    System.out.println("학생수를 먼저 입력 하세요...");
                    continue; // while 반복문을 처음부터 다시 시작
                }

                // 최대값과 평균 찾기
                int max = 0; // 최대값 합계 저장
                int sum1 = 0;

//                for(int i=0; i<scores.length; i++) {
//                        if(scores[i]>max) {
//                            max = scores[i];
//                    }   sum1 += scores[i];
//                }

                for (int x : scores) {
                    max = (x > max) ? x : max;
                }
                int sum = 0;
                for (int x : scores) {
                    sum += x;
                }

                double average = (double) sum / scores.length;
                System.out.printf("최고 점수 : %d \n", max);
                System.out.println("평균 점수 : " + average);

            } else if (selectNo == 5) {
                run = false;
            } else {
                System.out.println("다시 입력 해주세요");
            }
        }
        System.out.println("프로그램 종료");

    }

}
