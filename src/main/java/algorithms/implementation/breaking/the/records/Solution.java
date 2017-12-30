package algorithms.implementation.breaking.the.records;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int[] breakingRecords(int[] score) {
        // Complete this function
        int maxCount = 0, minCount = 0;

        if(score.length > 1){
            int min = score[0], max = score[0];

            for(int i = 1; i < score.length; i++){
                if(score[i] < min){
                    min = score[i];
                    minCount++;
                }

                if(score[i] > max){
                    max = score[i];
                    maxCount++;
                }
            }
        }


        return new int[]{ maxCount, minCount };
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] score = new int[n];
        for(int score_i = 0; score_i < n; score_i++){
            score[score_i] = in.nextInt();
        }
        int[] result = breakingRecords(score);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
        }
        System.out.println("");


        in.close();
    }
}
