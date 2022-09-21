package edu.java.loop02;

public class LoopMain02 {

    public static void main(String[] args) {

        
        // 0 2 4 6 8 10을 한줄에 출력
            
        // 10까지 2씩 나눠서 0이 되는 수를 산출해서 나오는값
        for (int i = 0; i <= 10; i++) {
            if (i % 2 == 0) {
            System.out.println(i);
            }
        }
        System.out.println("-------");
        
        // 0~ 10까지 2씩 더해서 나열
        for (int n = 0; n <= 10; n += 2) {
            System.out.println(n);
        }
        
        System.out.println("-------");
                
        //5까지 2를 곱해서 나오는 값
        for (int n = 0; n <= 5; n++ ) {
            System.out.println(n * 2);
        }
    }

}
