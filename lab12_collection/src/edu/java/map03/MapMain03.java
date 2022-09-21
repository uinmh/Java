package edu.java.map03;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeMap;

public class MapMain03 {

    public static void main(String[] args) {

        String sentence = "하늘 바다 땅 하늘 땅 사람";

        // 단어(key)-빈도수(value)를 저장하기 위한 Map을 선언, 생성
        TreeMap<String, Integer> wordCounts = new TreeMap<>();

        String[] words = sentence.split(" ");

        for (String w : words) {
            Integer count = wordCounts.get(w);
            System.out.print(w + ", ");
            if (wordCounts.get(w) == null) {
                wordCounts.put(w, 1);
            } else {
                wordCounts.put(w, count + 1);
            }
        }
        System.out.println();
        System.out.println(wordCounts);

        // 그 단어가 문자열에 등장하는 횟수를 value로 하는 Map 객체를 만들고 출력.
        // 결과 : {땅=2, 바다=1, 사람=1, 하늘=2}

        HashMap<String, Integer> wordCounts2 = new HashMap<>();

        System.out.println(wordCounts2);

        for (String w : words) {
            Integer count = wordCounts.getOrDefault(w, 0);
            wordCounts2.put(w, count + 1);
            System.out.println(wordCounts2);
        }
        System.out.println(wordCounts2);
    }

}
