package edu.java.modifier01;

public class AccessTest {

    // 수식어 
    
    // 필드
    private int a;
    int b;
    protected int c;
    public int d;
    
    
    // 생성자
    public AccessTest (int a, int b, int c, int d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    
    public void printMembers() {
        System.out.println("A : " + this.a);
        System.out.println("B : " + this.b);
        System.out.println("C : " + this.c);
        System.out.println("D : " + this.d);
    }
}
