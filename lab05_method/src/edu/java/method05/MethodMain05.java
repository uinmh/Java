package edu.java.method05;

public class MethodMain05 {

    public static void main(String[] args) {

        // 메서드 작성 연습.

        int[] scores = { 70, 60, 100, 50, 81, };

        int sum = sum(scores);
        System.out.println("총점 = " + sum);

        double avg = mean(scores);
        System.out.println("평균 = " + avg); // 72 

        int max = max(scores);
        System.out.println("최대값 = " + max); // 100

        int min = min(scores);
        System.out.println("최소값 = " + min); // 50

        System.out.println("분산 = " + variance(scores));
        System.out.println("표준편차 = " + standardDeviation(scores));
    }// main 

    public static int sum(int[] scores) {

        int sum = 0;

        for (int x : scores) {

            sum += x;
        }
        return sum;
    }

    public static double mean(int[] scores) {

        
         //int total  = sum(scores);
        
        
        double avg = (double) sum(scores) / scores.length;

        return avg;

    }

    public static int max(int[] scores) {

        int max = scores[0];

        for (int x : scores) {
            max = (x > max) ? x : max;
        }
        return max;
    }
    
    

    public static int min(int[] scores) {

        int min = scores[0];

        for (int x : scores) {
            min = (x < min) ? x : min;
        }
        return min;
    }
    
    public static double variance(int[] array) {
        
        // 데이터: {x1,x2,x3 ....... xn)
        // 평균: mu = (x1 + x2 + .... + xn) / n
        // 분산: var = ((x1 - mu)^2 + (x2 - mu)^2 + ..... + (xn - mu)^2) /n
        // 표준편차: std = sqrt(var)
        
        
        double mu = mean(array);
        double total = 0;
        for (int x : array) {
            total += (x - mu) * (x - mu);
        }
        double var = total / array.length;
                
        return var;
}
    public static double standardDeviation(int[] array) {
       return Math.sqrt(variance(array)); 
    }
        
}



