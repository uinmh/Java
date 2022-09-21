package edu.java.list01;

import java.util.ArrayList;
import java.util.Iterator;

/*
 *  Collection<E>
 *  |__ List<E>
 *      |__ArrayList<E>,LinkedList<E>,...
 *  
 *  리스트(List)의 특징:
 *  1. 값들을 저장하는 순서가 중요. - index를 가지고 있음.
 *  2. 값들을 저장할 때마다 인덱스는 자동으로 증가 - 저장 용량이 자동으로 증가됨.
 *  3. 리스트 중간에 있는 값을 삭제하면 인덱스는 자동으로 재배열됨.
 *  4. 같은 값을 여러번 저장할 수 있음. Set<E>과 다른 점.
 *  5. List<E>에서 <E>는 리스트가 저장하는 원소 (element)의 데이터 타입을 의미. - 반드시 클래스 이름만사용가능.
 *  
 *  ArrayList<E>의 특징:
 *  1.데이터 저장(add) /삭제(remove) 속도 느림.
 *  2.데이터 검색(get) 속도 빠름.
 *  3.배열(array)을 사용하는 리스트.
 *  
 *  LinkedList<E>의 특징: 
 *  1. Linked list 알고리즘을 사용한 리스트.
 *  2. 데이터를 저장/삭제 속도 빠름.
 *  3. 데이터 검색 속도 느림.
 *  
 */

public class ListMain01 {

    public static void main(String[] args) {

        // 문자열들을 저장하는 ArrayList를 선언/생성

        ArrayList<String> languages = new ArrayList<>();
        System.out.println("size = " + languages.size());
        System.out.println(languages); // toString() 메서드가 override되어 있음.
        // ArrayList의 크기(원소의 개수)

        // add(E element):리스트에 새로운 원소를 추가.

        languages.add("Java");
        System.out.println("size = " + languages.size());
        System.out.println(languages);

        languages.add("Sql");
        languages.add("HTML/CSS/JavaScript");
        languages.add("Servlet/JSP");
        languages.add("Spring");
        languages.add("Java");
        System.out.println(languages);

        // get(int index): 리스트에서 index 위치의 원소를 리턴.
        System.out.println(languages.get(0));
        System.out.println(languages.get(1));

        // remove (Object o): 리스트에서 처음 등장하는 element 1개를 삭제.

        languages.remove("Java");
        System.out.println(languages);

        // remove (int index) : 리스트에서 index 위치에 있는 원소를 삭제.
        languages.remove(0);
        System.out.println(languages);

        // 반복문을 사용한 리스트 원소 출력.
        
        
        // 1) index이용
        for (int i = 0; i < languages.size(); i++) {
            System.out.print(languages.get(i) + ",");
        }
        System.out.println();

        // 2) for - each 문장 이용
        for (String s : languages) {
            System.out.print(s + ",");
        }

        System.out.println();
        
        // 3) Iterator<E> 이용
        
        Iterator<String> itr = languages.iterator();// 리스트 원소를 순회(iterate)하는 도구를 
        
        while (itr.hasNext()) { // 리스트에서 다음 원소가 존재하면
            // next(): 현재 원소를 리턴하고 위치를 다음 위치로 이동.
            System.out.print(itr.next() + ", ");
        }
        System.out.println();
    }

}
