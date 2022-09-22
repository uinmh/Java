package edu.java.inner01;

public class Outer {

    //field
    private int x;
    private int y;
    //constructor
    
    public Outer(int x, int y){
        this.x = x;
        this.y = y;
        
    }
    
    //method
    @Override
    public String toString() {
        return String.format("Outer(x=%d,y=%d)",x,y);
    }
    // non-static member inner class 
    
    public class Inner {
        
        // field
        private int z;
        private int y;

        
        // constructor 
        public Inner(int z) {
            this.z = z;
        }
        // method
        
        public void printInfo() {
            System.out.println("--- Inner Class ---");
            // 내부 클래스에서는 외부 클래스의 멤버(변수, 메서드)를 사용할 수 있음!
            System.out.println("X = " + x);
            System.out.println("t = " + y);
            System.out.println("z = " + z);
            // 내부 클래스의 멤버(변수, 메서드)의 이름과 외부 클래스의 멤버 이름이 같은 경우,
            // 외부 클래스의 멤버를 접근하는 방법: OuterClassName.this.memberName
            System.out.println("Outer y = " + Outer.this.y );
        }
    }
}
