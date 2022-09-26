package edu.java.lambda04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class LambdaMain04 {

    public static void main(String[] args) {

        // Employee를 원소로 갖는 리스트를 선언, 생성

        List<Employee> employees = Arrays.asList(
                new Employee(100, "이존규", "개발자", "개발1팀", 300),
                new Employee(101, "김지훈", "개발자", "개발2팀", 301), 
                new Employee(201, "김용훈", "개발자", "개발2팀", 302),
                new Employee(202, "김가영", "디자이너", "개발1팀", 303), 
                new Employee(301, "최은정", "디자이너", "개발2팀", 400),
                new Employee(500, "추지훈", "부사장", "인사팀", 1000)
                );
        
       double sum = 0;
        // ex 1. 모든 직원들의 정보를 출력(한줄에 한명씩) for - each

        for (Employee s : employees) {
            System.out.println(s);
        }
        System.out.println();
        
        // ex 1 - 람다 for - each
        employees.stream().forEach(System.out::println);

        // ex 2. job이 개발자인 직원들의 급여 합계를 계산하고 출력. (람다)
        sum = employees.stream()
                .filter(x -> x.getJob().equals("개발자"))
//                .mapToInt(x -> x.getSalary())
                .mapToInt(Employee::getSalary) // 메서드 참조
                .sum();
        
                
        System.out.println("개발자 급여 합계 = " + sum);
        
        

        // ex 3. dept가 "개발2팀"인 직원들의 급여 평균을 출력.
        sum = 0;
        int count = 0;
        sum = employees.stream()
                .filter(x -> x.getDept().equals("개발2팀"))
                .mapToInt(Employee::getSalary)
                .average()
//                .getAsDouble(); // Optional -> Double
//                .orElse(0); // Optional -> 정상적인값 또는 비정상일 경우 기본값.
                .orElseThrow(); // Optional -> 정상적인 값 또는 Exception

        System.out.println("개발2팀 평균 급여 = " + sum);
        System.out.println();
        
//        for (Employee e : employees) {
//            if (e.getDept().equals("개발2팀")) {
//                sum += e.getSalary();
//                count ++;
//            }
//        }
//        double mean = (double)sum / count;
//        System.out.println("eman = " + mean);
//        
//        
        // ex 4. 급여가 400이상인 직원들의 정보를 한줄씩 출력.
        
        
        
        employees.stream()
                .filter(x -> x.getSalary() >= 400)
                .forEach(System.out::println);;
        
        System.out.println("급여 400이상 직원" );
        for (Employee s : employees) {
            if(s.getSalary() >= 400) {
                System.out.println(s);
            }
        }
        
        
        
    }

}
