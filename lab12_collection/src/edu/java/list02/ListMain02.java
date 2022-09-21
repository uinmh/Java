package edu.java.list02;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

public class ListMain02 {

    public static void main(String[] args) {
     
        // 1. 정수를 저장하는 linkedList 변수(numbers) 선언/ 생성
        
        // 2. 생성한 리스트에 0이상 100미만 [0, 100)범위에 정수 난수 20개를 저장.
        
        // 3. 난수가 저장된 리스트 (numbers) 출력.
        
        // 4. 홀수들만 저장하는 linkedList변수 선언(odds), 객체 생성.
        
        // 5. 난수들이 저장된 리스트에서 홀수들만 리스트 odds에 저장.
        
        // 6. 리스트 odds를 출력,.
        
        // 7. 짝수 제곱들을 저장하는 Linkedlist 변수(evenSquares) 선언, 객체 생성.
        
        // 8. 난수들이 저장된 리스트 numbers에서 짝수들을 찾아서 그 제곱을 evenSquares에 저장.
        
        // 9. 리스트 evenSquares를 출력

        LinkedList<Integer> numbers = new LinkedList<>();
        
        Random random = new Random();
        
        for(int i = 0; i < 20; i++) {
            numbers.add(random.nextInt(0,100));
        }
        System.out.println(numbers);
    
        LinkedList<Integer> odds = new LinkedList<>();
        
//        for(int i = 0; i < numbers.size(); i++) {
//            if ( numbers.get(i) % 2 != 0) {
//                
//                odds.add(numbers.get(i));
//                
//            }
//        }
        for (Integer n : numbers) { // numbers의 원소들을 하나씩 반복하면서
            if(n % 2 == 1 ) { // 그 원소가 홀수이면
                odds.add(n); // 리스트 odds에 추가
            }
        }
       
        System.out.println(odds);
        
        
        
        
        LinkedList<Integer> evenSquares = new LinkedList<>();
        
        for (int i = 0; i < numbers.size(); i++) {
            int x = numbers.get(i);
            if (x % 2 == 0) {
                evenSquares.add((int) Math.pow(x , 2));
            }
        }
        
//        for (Integer n : numbers) {
//            if (n % 2 == 0) {
//                evenSquares.add((int)Math.pow(n, 2));
//            }
//        }

//          for (int i = 0; i < numbers.size(); i++) {
//              Integer x = numbers.get(i);
//              if(x % 2 == 0) {
//                  evenSquares.add(x * x);
//              }
//          }
//        
        System.out.println(evenSquares);
        
        //Iterator<E> 
        Iterator<Integer> itr = evenSquares.iterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + ", ");
        }
        System.out.println();
    }

}
