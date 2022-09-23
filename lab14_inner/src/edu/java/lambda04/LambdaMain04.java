package edu.java.lambda04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaMain04 {

    public static void main(String[] args) {

        // Employee를 원소로 갖는 리스트를 선언, 생성

        List<Employee> employees = Arrays.asList(new Employee(100, "이존규", "개발자", "개발1팀", 300),
                new Employee(101, "김지훈", "개발자", "개발2팀", 301), new Employee(201, "김용훈", "개발자", "개발2팀", 302),
                new Employee(202, "김가영", "디자이너", "개발1팀", 303), new Employee(301, "최은정", "디자이너", "개발2팀", 400),
                new Employee(500, "추지훈", "부사장", "인사팀", 1000));

        // ex 1. 모든 직원들의 정보를 출력(한줄에 한명씩) for - each

        for (Employee s : employees) {
            System.out.println(s);
        }

        System.out.println("\n ----------------------------\n");

        // ex 2. job이 개발자인 직원들의 급여 합계를 계산하고 출력. (람다)
        List<Integer> employees1 = employees.stream()
                .filter(x -> x.getJob().equals("개발자"))
                .map(x -> x.getSalary())
                .collect(Collectors.toList());// 개발자 직원들 리스트

        int result = 0;
        for (int x : employees1) {
            result += x;
        }
        System.out.println(result);
        
        

        // ex 3. dept가 "개발2팀"인 직원들의 급여 평균을 출력.
        result = 0;
        List<Integer> employees2 = employees.stream()
                .filter(x -> x.getDept().equals("개발2팀"))
                .map(x -> x.getSalary())
                .collect(Collectors.toList());
        for (int x : employees2) {
            result += x;
        }
        result /= employees2.size();
        System.out.println(result);
        
        
        // ex 4. 급여가 400이상인 직원들의 정보를 한줄씩 출력.
        List<Employee> employees3 = employees.stream()
                .filter(x -> x.getSalary() >= 400)
                .collect(Collectors.toList());
        
        for (Employee s : employees3) {
            System.out.println(s);
        }
    }

}
