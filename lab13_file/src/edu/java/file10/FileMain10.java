package edu.java.file10;

public class FileMain10 {

    public static void main(String[] args) {
     // 파일, 폴더(디렉토리) 생성,삭제,관리

     // System.getProperty(Key): Java Runtime이 실행 중인 컴퓨터의 시스템 정보들을 리턴.
     // user.dir : 현재 작업 디렉토리(Current Working Directory). 프로그램이 실행되는 위치
        String cwd = System.getProperty("user.dir"); 
        System.out.println(cwd);
        
        // 절대 경로(absolute path)
        // 시스템의 루트(C:\, D:\)부터 시작해서 파일(폴더)가 있는 위치를 찾아가는 경로.
        // (예) D:\study\lab-java\lab13_file\src\edu\java\file10\FileMain10.java
        
        // 상대경로 (relative path):
        // 현재 작업 디렉토리를 기준으로 파일(폴더)가 있는 위치를 찾아가는 경로.
        // (예) src\edu\java\file10\FileMain10.java
    
        System.out.println("data\\test.txt");
    } //m

} //c
