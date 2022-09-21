package edu.java.variable04;

import java.util.Scanner;

public class Test {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // ======= name ========
        System.out.println("이름을 입력하세요.");
        String st = scanner.next();

        // ======== Java ========
        System.out.println("Java시험 점수를 입력하세요.");
        int java = scanner.nextInt();

        // ======== Sql ========
        System.out.println("Sql 시험 점수를 입력하세요.");
        int sql = scanner.nextInt();

        // ======== jsp ==========
        System.out.println("Jsp 시험 점수를 입력하세요.");
        int jsp = scanner.nextInt();
        System.out.println();

        // ====== 총 점수 와 평균 ======
        int totalScore = java + sql + jsp;
        double average = totalScore / 3.0;
        System.out.println(st + " 님의");
        System.out.println();
        System.out.println("시험의 총 점수는 " + totalScore + " 입니다.");
        System.out.println();
        System.out.println("시험의 평균 점수는 " + average + " 입니다.");

    }

}
