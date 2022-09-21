package edu.java.loop01;

public class gugudan {

    public static void main(String[] args) {

        int dan;
        int i;
        
        for (dan = 2; dan <= 9; dan++) {
            System.out.print("[" + dan + "단]\t");
        }
            System.out.println();
        for (i = 1; i <= 9; i++) {
            for (dan = 2; dan <=9; dan++) {
                System.out.print(dan + "x" + i + "=" + dan*i + "\t");
            }
            System.out.println();
        }
    
    }

}
