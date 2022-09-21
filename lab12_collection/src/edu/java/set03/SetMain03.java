package edu.java.set03;

import java.util.HashSet;
import java.util.Random;

public class SetMain03 {

    public static void main(String[] args) {

        // HashSet<E> 사용.
        // 0이상 10미만 범위의 정수 난수 5개를 저장.
        // set의 내용을 출력.

        Random ran = new Random();

        HashSet<Integer> num = new HashSet<>();

//        while (num.size() != 5) {
//
//            num.add(ran.nextInt(0, 10));
//
//        }

        while (true) {
            num.add(ran.nextInt(0, 10));// 난수를 set에 저장.
            if (num.size() == 5) { // 만약 num의 배열이 5개가 찰때까지 무한 반복
                break;
            }
        }

        System.out.println(num);
    }

}
