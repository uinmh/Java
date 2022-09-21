package edu.java.switch01;

import java.util.Scanner;

public class elevator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        
        System.out.println("올라갈 층을 입력 해주세요.");
        String flour = scanner.next();

               
        switch (flour) {
        case "1" :
            System.out.println("1층 입니다.");
            break;
        case "2" :
            System.out.println("2층 입니다.");
            break;
        case "3" :
            System.out.println("3층 입니다.");
            break;
        case "4" :
            System.out.println("4층 입니다.");
            break;
        case "5" :
            System.out.println("5층 입니다.");
            break;
        case "6" :
            System.out.println("6층 입니다.");
            break;
        case "7" :
            System.out.println("7층 입니다.");
            break;
        default:
            System.out.println("잘못 입력 하였습니다.");
        }

    }

}