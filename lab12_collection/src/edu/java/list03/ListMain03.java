package edu.java.list03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ListMain03 {

    public static void main(String[] args) {

        // 문자열들을 원소로 갖는 리스트를 생성하고 초기화.
        List<String> languages = Arrays.asList("Java", "SQL", "HTML", "CSS", "JavaScript", "Servlet", "JSP", "Spring",
                "Python");
        System.out.println(languages);

        // 리스트 languages에서 5글자 이상인 문자열들만 저장하는 리스트를 생성,출력

        List<String> five = new ArrayList<>();// 다형성

//        for (int i = 0; i < languages.size(); i++) {
//            if (languages.get(i).length() >= 5) {
//                five.add(languages.get(i));
//            }
//        }
        for (String s : languages) {
            if (s.length() >= 5) {
                five.add(s);
            }
        }
        System.out.println(five);
        
        
        //Iterator<E> 사용
        List<String> longwords = new ArrayList<>();
        
        Iterator<String> itr = languages.iterator();
        
        while(itr.hasNext()) {
            String s = itr.next();
            if(s.length() >= 5) {
                longwords.add(s);
            }
        }
        System.out.println(longwords);
        // 리스트 languages의 원소들의 글자수를 저장하는 리스트를 만들고 출력.
//        ArrayList<String> num = new ArrayList<>();
        LinkedList<Integer> num = new LinkedList<>();

//        for (int i = 0; i < languages.size(); i++) {
//            num.add(languages.get(i).length());
//        }

        for (String s : languages) {
            num.add(s.length());
        }
        System.out.println(num);

        // 정수 (1,2)들을 저장하는 리스트를 만들고 초기화

        List<Integer> genderCodes = Arrays.asList(1, 1, 2, 2, 1, 2, 2);

        // 리스트 genderCodes의 값이 1이면 male 2면 "Female"을 저장하는 리스트를 만들고 출력

        List<String> genders = new LinkedList<>();

//        for (int i = 0; i < genderCodes.size(); i++) {
//
//            if (genderCodes.get(i) == 1) {
//                gender.add("male");
//            } else {
//                gender.add("female");
//            }
//        }
        for (Integer code : genderCodes) {
//            String gender = "";
//            if (code == 1 ) {
//                gender = "male";
//            }else {
//                gender = "female";
//            }
//            genders.add(gender);
            genders.add((code == 1) ? "male" : "female");
        }
        System.out.println(genders);
    }

}
