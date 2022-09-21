package edu.java.modifier04;


public class ModifierMain04 {

    public static void main(String[] args) {

    //   타입 객체    
        Member mem = new Member("ABCD", "12345");
        
        System.out.println(mem);
        System.out.println(mem.getId());
        // private 멤버는 다른 클래스에서 직접 사용할 수 없음.
        System.out.println(mem.getPass());
        mem.setPass("43210");
        System.out.println(mem.getPass());
        
        System.out.println("=======================");
        
        Member mem1 = new Member("ABC2", "3333555");
        
        System.out.println(mem1);
        System.out.println(mem1.getId());
        System.out.println(mem1.getPass());
        mem1.setPass("1232421");
        System.out.println(mem1.getPass());
        
    }

}
