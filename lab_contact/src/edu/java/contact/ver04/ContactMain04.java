package edu.java.contact.ver04;

import java.util.List;
import java.util.Scanner;

import edu.java.contact.menu.MainMenu;
//import edu.java.contact.ver04.Contact;

// MVC 아키텍쳐에서 View에 해당하는 클래스. UI(User Interface).
public class ContactMain04 {
    private Scanner scanner = new Scanner(System.in);
    private ContactDao dao = ContactDaoImpl.getInstance();

    public static void main(String[] args) {
      
        ContactMain04 app = new ContactMain04();
        
        System.out.println();
        
        System.out.println("***** 연락처 프로그램 Version 0.4 *****");

        boolean run = true;

        while (run) {
            try {
                int n = app.showMainMenu();
                MainMenu menu = MainMenu.getValue(n);
                switch (menu) {
                case QUIT:
                    run = false;
                    break;
                case SELECT_ALL:
                    app.select();
                    break;
                case SELECT_BY_INDEX:
                    app.selectByIndex();
                    break;
                case CREATE:
                    app.createNewContact();
                    break;
                case UPDATE:
                    app.updateContact();
                    break;
                case DELETE:
                    app.delete();
                    break;
                default:
                    System.out.println("지원하지 않는 메뉴입니다. 다시 선택하세요.");
                }
            } catch (Exception e) {
                System.out.println("잘못 입력하셨습니다.");
            }
        }
        System.out.println("프로그램 종료");
    }

    private void delete() {

        System.out.print("삭제할 연락처 인덱스 입력 >> ");
        int index = inputNumber();
        Contact delindex = dao.read(index);
        System.out.println("삭제 할 연락처 " + delindex);
        System.out.println("삭제 하시겠습니까?");
        System.out.print("[1] 예 [2] 아니요 >> ");
        int index1 = Integer.parseInt(scanner.nextLine());
        if (index1 == 1) {
            dao.delete(index);
            System.out.println("삭제 되었습니다.");
        } else {
            System.out.println("취소하셨습니다.");
        }

    }

    private void updateContact() {

        System.out.println("*** 연락처 (수정)업데이트 ***");
        System.out.println("수정할 연락처 목록 번호 >> ");
        int index = inputNumber();

        if (dao.read(index) == null) {
            System.out.println("목록에 정보가 없습니다.");
        } else {

            Contact before = dao.read(index);
            System.out.println("수정 전 : " + before);
            System.out.print("변경할 이름 >> ");
            String name = scanner.nextLine();
            System.out.print("변경할 전화번호 >> ");
            String phone = scanner.nextLine();
            System.out.print("변경할 이메일 >> ");
            String email = scanner.nextLine();

            Contact up = new Contact(name, phone, email);

            int result = dao.update(index, up);

            if (result == 1) {
                System.out.println("연락처 (수정)업데이트 성공");
            } else {
                System.out.println("연락처 (수정)업데이트 실패");
            }
        }

    }

    private void createNewContact() {

        System.out.println(" ---- 연락처 정보 등록 ----");

        System.out.print("등록할 이름 >> ");
        String name = scanner.nextLine();

        System.out.print("등록할 전화번호 >> ");
        String phone = scanner.nextLine();

        System.out.print("등록할 이메일 >> ");
        String email = scanner.nextLine();

        Contact c = new Contact(name, phone, email);

        int result = dao.create(c);
        if (result == 1) {
            System.out.println("연락처 목록 추가 성공");
        } else {
            System.out.println("연락처 목록 추가 실패");
        }

    }

    private void selectByIndex() {

        System.out.println("*** 연락처 리스트 검색*** ");
        System.out.print("검색할 연락처를 입력 해주세요 >> ");
        int index = inputNumber();
        Contact c = dao.read(index);
        if (c != null) {
            System.out.println(c);
        } else {
            System.out.println("결과 값을 찾을수 없습니다.");
        }
    }

    private void select() {

        List<Contact> contact = dao.read();
        System.out.println(" *** 연락처 목록 ***");
        for (Contact c : contact) {
            System.out.println(c);
        }
        System.out.println("********************");

    }

    private int showMainMenu() {

        System.out.println();
        System.out.println("----------------------------------------------------------------");
        System.out.println("[1]전체리스트 [2]인덱스검색 [3]새연락처 [4]수정 [5]삭제 [0]종료");
        System.out.println("----------------------------------------------------------------");
        System.out.print("메뉴 선택> ");

        return inputNumber();

    }

    private int inputNumber() {
        while (true) {
            try {
                int num = Integer.parseInt(scanner.nextLine());

                return num;
            } catch (NumberFormatException e) {
                System.out.print("정수를 입력하세요>> ");
            }
        }
    }

}
