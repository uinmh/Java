package edu.java.String01;

import java.util.Arrays;

public class Ex01 {

    public static void main(String[] args) {

        // String 클래스의 메서드들을 사용

        // ex-1. 아래의 주민번호문자열에서 성별을 표시하는 위치의 문자만 출력.
        String ssn = "991231-1234567";
        // TODO
        System.out.println(ssn.charAt(7));

        // ex-2. 아래의 문자열 배열에서 "홍길동의 인덱스를 출력.
        // 만약에 홍길동이 배열에 없으면 배열에 없는 경우에는 -1을 출력
        String[] names = { "오쌤","홍길동", "Jhon", "Jane" };
        // TODO
        int index = -1;
        for(int i = 0; i < names.length; i++) {
            if (names[i].equals("홍길동")) {
                index = i;
                break;
            }
        }
            System.out.println(index);
        // ex-3. 아래의 문자열 배열에서 5글자 이상인 문자열 들만 출력
        String[] laguages = { "java", "sql", "JavaScript", "Phython" };
        // TODO
        for (int i = 0; i < laguages.length; i++) {
            if (laguages[i].length() >= 5) {
                System.out.println(laguages[i]);
            }
        }
        for (String s : laguages) {
            if(s.length() >= 5) {
                System.out.print(s + ",");
            }
        }
        System.out.println();
        // ex-4. 대소문자 구별없이 "est"를 포함하는 문자열들을 출력
        String[] tests = { "Test", "test", "TeSt", "테스트" };
        // TODO
        for (int i = 0; i < tests.length; i++) {
            if(tests[i].toLowerCase().contains("est")) {
                System.out.println(tests[i]);
            }
        }
        
        for (String s : tests) {
            if (s.toLowerCase().contains("est")) {
                System.out.print(s + ",");
            }
        }
        
        System.out.println();
//        System.out.println("TeSt".toLowerCase());
//      System.out.println("TeSt".toUpperCase());

     // ex-5. 아래의 "YYYY - MM - DD 형식의 날짜 문자열에서 년/월/일 정보를
        // int 타입 변수에 저장하고 출력.
          String date = "2022-09-07";
          String[] array = date.split("-"); // -> {2022, 09 , 07}
          System.out.println(array[0] + "," + array[1] + "," + array[2]);
          
          int year = Integer.parseInt(array[0]);
          int month = Integer.parseInt(array[1]);
          int day = Integer.parseInt(array[2]);
          
          System.out.println(year);
          System.out.println(month);
          System.out.println(day);
    }
    
    

}
