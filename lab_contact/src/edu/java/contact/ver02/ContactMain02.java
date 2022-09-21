package edu.java.contact.ver02;

import java.util.Scanner;

import edu.java.contact.menu.MainMenu;

public class ContactMain02 {

    private Scanner scanner = new Scanner(System.in);
    private ContactDaoImpl cao = ContactDaoImpl.getInstance(); // 컨트롤러 클래스. (연락처 저장,검색,수정)을 하는 클래스.

    public static void main(String[] args) {

        System.out.println("***** 연락처 프로그램 Version 0.2 *****");

        ContactMain02 app = new ContactMain02();

        boolean run = true;
        
        while (run) {
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
            default:
                System.out.println("잘못 선택 하셨습니다.");
                break;
            }

        }
        System.out.println("프로그램 종료");
    }

    private void updateContact() {

        System.out.println("*** 연락처 (수정)업데이트 ***");
        System.out.println("수정할 연락처 목록 번호 >> ");
        int index = Integer.parseInt(scanner.nextLine());

        if (!cao.isValidIndex(index)) {
            // 인덱스가 유효하지 않으면. (0보다 작거나 또는 저장된 연락처 개수보다 많다면)
            System.out.println("해당 인덱스에는 연락처 정보가 없습니다.");
            return; // 메서드 종료
        }
        Contact before = cao.read(index); // controller 메서드 사용해서 수정 전 데이터 읽어옴.
        System.out.println("수정 전: " + before);
        
        System.out.print("변경할 이름 >> ");
        String name = scanner.nextLine();
        System.out.print("변경할 전화번호 >> ");
        String phone = scanner.nextLine();
        System.out.print("변경할 이메일 >> ");
        String email = scanner.nextLine();
        int result = cao.update(index, name, phone, email);

        if (result == 1) {
            System.out.println("연락처 (수정)업데이트 성공");
        } else {
            System.out.println("연락처 (수정)업데이트 실패");
        }
    }

    private void selectByIndex() {

        System.out.println("*** 연락처 리스트 검색*** ");
        System.out.print("검색할 연락처를 입력 해주세요 >> ");
        int index = Integer.parseInt(scanner.nextLine());
        Contact c = cao.read(index);

        // if(!dao.inValidIndex(index)){
        // 인덱스가 유효하지 않으면. (0보다 작거나 또는 저장된 연락처 개수보다 많으면)
        // System.out.println("해당 목록에는 연락처 정보가 없습니다.");    
        // return; // 메서드 종료.
        //}
        
        if (c == null) {
            System.out.println("결과 값을 찾을수 없습니다.");
        } else {
            System.out.println(c);
        }
    }

    private void select() {

        Contact[] contacts = cao.read(); // controller의 메서드를 호출.
        
            System.out.println(" *** 연락처 목록 *** ");

            for (Contact c : contacts) {
                System.out.println(c);
            }
            System.out.println(" *******************");
        }

    private void createNewContact() {

        System.out.println(" ---- 연락처 정보 등록 ----");
        if (cao.getCount() == ContactDaoImpl.MAX_LENGTH) {
            System.out.println("연락처를 저장할 공간이 부족 합니다.");
            return;
        }
//        if(!cao.isMemonryAvailable()) {
//            System.out.println("새 연락처를 저장할 공간이 부족 합니다.");
//            return;
//        }
        System.out.print("등록할 이름 >> ");
        String name = scanner.nextLine();
        
        System.out.print("등록할 전화번호 >> ");
        String phone = scanner.nextLine();
        
        System.out.print("등록할 이메일 >> ");
        String email = scanner.nextLine();
        

        Contact c = new Contact(name, phone, email);

        int result = cao.creat(c);
        if (result == 1) {
            System.out.println("주소록 목록 추가 성공");
        } else {
            System.out.println("주소록 목록 추가 실패");
        }
    }

    private int showMainMenu() {
        System.out.println();
        System.out.println("------------------------------------------------------------");
        System.out.println("[1]전체리스트 [2]인덱스검색 [3]새연락처 [4]수정 [0]종료");
        System.out.println("------------------------------------------------------------");
        System.out.print("메뉴 선택> ");

        int n = Integer.parseInt(scanner.nextLine());

        return n;
    }

}
