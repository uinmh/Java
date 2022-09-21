package edu.java.loop10;

public class LoopMain10 {

    public static void main(String[] args) {
      
        // 4x + 5y가 60 모든해를 구하세요.
        
        for(int x = 1; x <= 10; x++) { // x는 1부터 10까지 변화시키면서
            for(int y = 1; y <= 10; y++) { //y는 1부터 10까지 변화시키면서
                if (4 * x + 5 * y == 60) { // 방정식의 해가 되면
                    System.out.println("( " + x + " )" + "( " + y + " )"); // 결과 출력
                }
            }
        }
        
        
        
    }

}
