package edu.java.contact.ver01;

import java.util.Scanner;

import edu.java.contact.menu.MainMenu;

public class ContactMain01 {

    // 상수
    private static final int MAX_LENGTH = 3; // 저장할 수 있는 연락처의 최대 개수(배열길이).

    // field
    private Scanner scanner = new Scanner(System.in); // 멤버 변수 선언
    // 입력도구
    private Contact[] contacts = new Contact[MAX_LENGTH];
    // 연락처들의 배열
    private int count = 0; // 배열에 저장된 연락처들의 개수

//    //기본생성자 선언
//    public ContactMain01() {
//        scanner = new Scanner(System.in);
//    }

    public static void main(String[] args) {

        System.out.println("***** 연락처 프로그램 Version 0.1 *****");

        // static이 아닌 메서드들을 호출하기 위 해서 객체를 생성할 필요가 있음.
        ContactMain01 app = new ContactMain01();

        boolean run = true; // 프로그램을 계속 실행할 지, 종료할 지를 결정하기 위한 변수.

        while (run) {

            // TODO: 1. 메인 메뉴 보여 주기
            app.showMainMenu();

            // TODO: 2. 메뉴 입력.
            int n = Integer.parseInt(app.scanner.nextLine());
            MainMenu menu = MainMenu.getValue(n);
            
            // TODO: 3. Switch-case
            switch (menu) {
            case QUIT: // 종료
                run = false;
                break;
            case SELECT_ALL: // 전체 리스트
                app.selectAllContacts();
                break;
            case SELECT_BY_INDEX: // 인덱스 검색
                app.selectContactByIndex();
                break;
            case CREATE: // 새연락처 추가
                app.insertNewContact();
                break;
            case UPDATE: // 수정기능
                app.updateContact();
                break;

            default:
                System.out.println("초기 메뉴로 돌아 갑니다.");
                System.out.println();

                // TODO: 4. run = false;

            }
        }
            System.out.println("프로그램 종료");
    } // end main

    private void updateContact() {
        // NullPointerException 또는 ArrayIndexOutOfBoundsException 발생할수 있음.
        // 수정할 인덱스 입력
        System.out.print("수정할 연락처 인덱스 >>");
        int index = Integer.parseInt(scanner.nextLine());

        if (index < 0 || index >= count) {
            System.out.println("해당 인덱스에는 수정할 연락처 정보가 없습니다.");
            return;
        }
        // 수정 전 연락처 정보 출력
        System.out.println("수정 전>>>");
        System.out.println();
        contacts[index].printContact();

        // 수정할 이름/ 전화번호 / 이메일 입력
       
            System.out.print("수정할 이름>>>");
            String name = scanner.nextLine();
            System.out.print("수정할 연락처>>>");
            String phone = scanner.nextLine();
            System.out.print("수정할 이메일>>>");
            String email = scanner.nextLine();
            // 연락처 정보 업데이트
            contacts[index].setName(name);
            contacts[index].setPhone(phone);
            contacts[index].setEmail(email);

            // 수정후 연락처 정보 출력
            System.out.println("수정 후 >>>");
            contacts[index].printContact();
        
    }

    private void selectContactByIndex() {
        // NullPointerException 또는 ArrayIndexOutOfBoundsException 발생할수 있음.
        // 검색할 인덱스 ?
        System.out.println("검색할 인덱스 >>");
        int index = Integer.parseInt(scanner.nextLine());
        // 해당 인덱스의 연락처 정보를 출력
        if (index < 0 || index >= count) {
            System.out.println("해당 인덱스에는 연락처 정보가 없습니다.");
            return;
        } else {
            contacts[index].printContact();
        }
    }

    private void selectAllContacts() {
        System.out.println("--- 연락처 전체 리스트 ---");
        // 배열 contacts에 저장된 contact 객체들을 출력.
        for (int i = 0; i < count; i++) {
            // 배열의 길이 만큼 반복하는 것이 아니라. 배열에 실제로 저장된 연락처 갯수 만큼만 반복함.
            contacts[i].printContact();
        }
    }

    private void showMainMenu() {
        System.out.println();
        System.out.println("-------------------------------------------------------");
        System.out.println("[1]전체리스트 [2]인덱스검색 [3]새연락처 [4]수정 [0]종료");
        System.out.println("-------------------------------------------------------");
        System.out.print("메뉴 선택> ");
    }

    private void insertNewContact() {
        // TODO: ArrayIndexOutOfBoundsException
        if (count >= MAX_LENGTH) {
            System.out.println();
            System.out.println("더이상 입력 할 수 없습니다.");
            System.out.println();
            return;
        } 
            // 이름. 전화번호, 이메일 입력을 받음.
            System.out.println("이름 입력 >");
            String name = scanner.nextLine();

            System.out.println("전화번호 입력 >");
            String phone = scanner.nextLine();

            System.out.println("이메일 입력 >");
            String email = scanner.nextLine();
            // contact 객체 생성.
            Contact c = new Contact(name, phone, email);
            // 배열에 추가
            contacts[count] = c;
            count++; // 배열에 저장된 연락처 개수를 1증가
        
    }
} // end class
