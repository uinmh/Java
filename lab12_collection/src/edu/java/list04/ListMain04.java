package edu.java.list04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ListMain04 {

    @SuppressWarnings("unlikely-arg-type")
    public static void main(String[] args) {

        //User 타입 객체 선언,생성,출력
        User user = new User();
        user.setUserId("uinmh");
        user.setPassword("12345");
        System.out.print(user.getUserId() + " ");
        System.out.print(user.getPassword());
        
        System.out.println();
        //User 객체 콘솔 출력 값이 toString() 매서드 override 전/후에 달라지는지 확인.
        System.out.println(user.toString());
        
        //User 타입을 저장할 수 있는 ArrayList를 선언,생성
        List<User> users = new ArrayList<>();
        
        //for 문장을 사용(3번 반복). Scanner를 사용. 
        Scanner scan = new Scanner(System.in);
        
        for(int i = 0; i < 3; i++) {
            System.out.print("아이디를 입력하세요. >> ");
            String userid =  scan.nextLine();
            System.out.print("비밀번호를 입력하세요. >> ");
            String password =  scan.nextLine();
            User user1 = new User(userid,password);
            users.add(user1);
        }
        //콘솔창에서 입력받은 아이디와 비밀번호로 user객체를 생성하고 리스트에 추가.
        //리스트를 출력
        System.out.println(users);
        
        // 리스트 users에서 인덱스 1인 원소를 삭제, 리스트를 출력
        users.remove(1);
        
        System.out.println(users);
        
        // 리스트에서 userId가 "guest"인 User 객체를 삭제,  리스트를 출력.
        
//        for(int i = 0; i < users.size(); i++) {
//
//            if (users.get(i).getUserId().equals("guest")) { // 문자열 비교시 반드시 == 말고 equals를 써야됨.
//            users.remove(i);
//            break;
//            }
//        }

        // 2) userId가 "guest"인 User 객체를 찾아서 삭제.
        
        for (User u : users) {
            if(u.getUserId().equals("guest"));
            users.remove(u);
            break;
        }
        
        
        System.out.println(users);
        
        
        System.out.println("\n----------\n");
        ArrayList<User> list = new ArrayList<>();
        list.add(new User("guest","000"));
        list.add(new User("guest1","000"));
        list.add(new User("guest","000"));
        list.add(new User("guest2","000"));
        list.add(new User("guest","000"));
        List<User> toDelete = Arrays.asList(new User("guest", null));
        list.removeAll(toDelete);
        System.out.println(list);
        
    }

}
