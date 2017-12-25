package algorithms.warmup.diagnoal.difference;


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static int sampleArray[][] = {
            {1, 1, 1, 0, 0, 0},
            {0, 1, 0, 0, 0, 0},
            {1, 1, 1, 0, 0, 0},
            {0, 0, 2, 4, 4, 0},
            {0, 0, 0, 2, 0, 0},
            {0, 0, 1, 2, 4, 0},
    };

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[][] = new int[n][n];
        for(int a_i=0; a_i < n; a_i++){
            for(int a_j=0; a_j < n; a_j++){
                a[a_i][a_j] = in.nextInt();
            }
        }

        int l = recurseL(a, 0, 0, n, 0);
        int r = recurseR(a, n-1, 0, n, 0);
        System.out.println(Math.abs(l - r));
    }

    private static int recurseL(int matrix[][], int i, int j, int n, int sum){
        if(i == n || j == n){
            return sum;
        }

        sum = sum + matrix[i][j];
        return recurseL(matrix, ++i, ++j, n, sum);
    }

    private static int recurseR(int matrix[][], int i, int j, int n, int sum){
        if(i < 0){
            return sum;
        }

        sum = sum + matrix[i][j];
        return recurseR(matrix, --i, ++j, n, sum);
    }
}
