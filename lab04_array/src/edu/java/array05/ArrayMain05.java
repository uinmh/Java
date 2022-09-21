package edu.java.array05;

public class ArrayMain05 {

    public static void main(String[] args) {
    
        // 문자 1차원 배열
        
        String [] bts = {"정국","뷔","RM","지민","슈가","제이홉","진"};
        String [] newJeans = {"민지","하니","다니엘","해린","혜인"};
         
        // 문자열 2차원 배열
        
        String[][]  idols = {bts,newJeans};
        
        for (int i = 0; i < idols.length; i++) {
            for(int j = 0; j < idols[i].length; j++) {
             
                System.out.print(idols[i][j] + " ");
            }
            System.out.println();
        }
        
        System.out.println("=============================");
        
        
        for (String [] group : idols) {
            
            for (String member : group ) {
               
                System.out.print(member + " ");
            }
                System.out.println();
        }
    }

}
