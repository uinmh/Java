package edu.java.lambda03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class LambdaMain03 {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

        System.out.println(numbers);

        List<Integer> evens = new ArrayList<>(); // numbers에서 짝수들만 선택해서 저장한 리스트.

        List<Integer> odds = new ArrayList<>(); // numbers에서 홀수들만 선택해서 저장한 리스트

        // for - each
        for (Integer e : numbers) {
            if (e % 2 == 0) {
                evens.add(e);
            }
        }
        System.out.println(evens);

        // 스트림 방식
        List<Integer> evens2 = numbers.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());

        System.out.println("evens2 = " + evens2);

        // for - each
        for (Integer x : numbers) {
            if (x % 2 == 1) {
                odds.add(x);
            }
        }
        System.out.println("odds for-each = " + odds);

        List<Integer> odds2 = numbers.stream().filter(x -> x % 2 == 1).collect(Collectors.toList());

        System.out.println("odds Stream = " + odds2);

        // numbers에서 짝수들의 제곱을 저장하는 리스트
        List<Integer> result = numbers.stream().filter(x -> x % 2 == 0).map(x -> x * x).collect(Collectors.toList());
        System.out.println(result);

        List<Integer> result1 = numbers.stream()
                .filter(x -> x % 2 == 1)
                .map( x -> x * x)
                .collect(Collectors.toList());
        System.out.println(result1);
//        for (Integer x : numbers) {
//            if (x % 2 == 0) {
//                result.add(x * x);
//            }
//        }
//        System.out.println(result);
        
        // langs 에서 5가지이상 문자열들을 찾고 모두 소문자로 변환한 리스트
        List<String> langs = Arrays.asList("Java","Sql","Html","JavaScript","Python");
        System.out.println(langs);
       
        List<String> langslow = langs.stream()
                .filter( x -> x.length() >= 5)
//                .map ( x -> x.toLowerCase())
                .map(String::toLowerCase) // 필터를 지나간 String타입을 toLowercase로 변환.
                .collect(Collectors.toList());
        
        System.out.println("low = " + langslow);
        
        List<String> langslow2 = new ArrayList<>();
        
        for (String x : langs) {
            if(x.length() >= 5) {
                langslow2.add(x.toLowerCase());
            }
        }
        System.out.println("low2 = " + langslow2);
    }
}
