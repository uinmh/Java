package edu.java.datetime;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class DateTimeMain {

    public static void main(String[] args) {

        // Java 8 버전에서 새로 생긴 날짜/시간 관련 클래스
        LocalDate today = LocalDate.now();
        
        System.out.println(today);
        
        System.out.println(today.getYear());
        
        System.out.println(today.getMonth()); // month enum을 리턴
        
        System.out.println(today.getMonthValue());// 월을 숫자(int)로 리턴
        
        System.out.println(today.getDayOfMonth()); // 그 달에 몇번째 날
        
        System.out.println(today.getDayOfYear());
    
        System.out.println(today.getDayOfWeek());
    
        System.out.println(today.plusDays(30));
        System.out.println(today.minusDays(30));
        
        LocalDate date = LocalDate.of(2022, 2, 28);
    
        System.out.println(date);
        System.out.println(date.plusDays(1));
        
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        
        // Timestamp : 1970-01-01 00:00:00를 기준으로 1/1000 (1 milli-second)마다
        // 1씩 증가하는 정수(long 타입)를 기반으로 날짜/시간 정보를 저장하는 클래스.
        // (1) LocalDateTime --> Timestamp 변환
        Timestamp ts = Timestamp.valueOf(now);
        System.out.println(ts);
        System.out.println(ts.getTime());
    
        // (2) Timestamp --> LocalDateTime 변환
        LocalDateTime dt = ts.toLocalDateTime();
        System.out.println(dt);
    
    }

}
