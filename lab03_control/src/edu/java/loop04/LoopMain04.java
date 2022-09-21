package edu.java.loop04;

public class LoopMain04 {

    public static void main(String[] args) {

        // 반복문에서 break; vs continue;
        // break: 반복문 블록을 실행 중에 break를 만나면, break가 포함된 가장 가까운 반복문 블록을 종료.
        // continue: 반복문 블록을 실행 중에 continue를 만나면, continue 아래의 코드는 무시하고 그 다음 반복 과정을 계속 수행.
        
        for (int n = 1; n <= 5; n++ ) {
            System.out.println(n);
            if(n == 3) {
                break;
            }
        }
    
        for (int n = 1; n <= 5; n++) {
            if (n == 3) {
                continue;
            }
            System.out.println(n);
        }
        
    }

}

// 조건문을 통해 가위바위보 게임