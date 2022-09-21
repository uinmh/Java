package edu.java.variable04;

import java.util.Scanner;

public class fl {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("시험점수입력하세요.");
        int st = scanner.nextInt();
        if (st == 1) {
            System.out.println("1층 입니다.");
        }
        else if (st == 2) {
            System.out.println("2층 입니다.");
        }
        else if (st == 3) {
            System.out.println("3층 입니다.");
        }
        else if (st == 4) {
            System.out.println("4층 입니다.");
        }
        else if (st == 5) {
            System.out.println("5층 입니다.");
        }
        else {
            System.out.println("잘못 입력 하였습니다.");
        }
    }
}
