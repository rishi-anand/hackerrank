package practice;

import java.util.Arrays;

public class Codility2 {

    public static int solution(Integer[] A) {
        int indexOfMaxDeviation = -1;
        // write your code in Java SE 8
        if(null != A && A.length > 0){
            int avgValue = calculateAverage(A);
            int previousDeviation = Integer.MIN_VALUE;

            for(int i = 0; i < A.length; i++){
                if(null != A[i]) {
                    int deviation = getDeviation(A[0], avgValue);
                    if (deviation > previousDeviation) {
                        indexOfMaxDeviation = i;
                    }
                }
            }

            return indexOfMaxDeviation;

        }

        return indexOfMaxDeviation;
    }

    public static int calculateAverage(Integer[] A){
        long sumValue = Arrays.stream(A)
                            .filter(i -> null != i)
                            .mapToLong((x) -> x)
                            .sum();

        return (int) (sumValue / (long) A.length);
    }

    public static int getDeviation(int value, int avg){
        return Math.abs(value - avg);
    }

    public static void main(String[] args){
        Integer[] A = {9, null, -3, -10};
        System.out.println(solution(A));

    }
}
