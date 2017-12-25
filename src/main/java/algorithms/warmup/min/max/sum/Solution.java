package algorithms.warmup.min.max.sum;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


public class Solution {

    private static int sampleArray[] = {-4, 3, -9, 0, 4, 1 };

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long[] arr = new long[5];
        for(int arr_i=0; arr_i < 5; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        calculate(arr);
    }

    //Way 1 : In single iteration
    private static void calculate(long[] arr){
        long min = Long.MAX_VALUE, max = Long.MIN_VALUE, sum = 0;
        for (int i = 0; i < arr.length; i++){
            min = (arr[i] > min) ? min : arr[i];
            max = (max > arr[i]) ? max : arr[i];
            sum = sum + arr[i];
        }

        System.out.println((sum - max) + " " + (sum - min));

    }


    //Way 2 : Sort all numbers.. first 4 sum is minimum..
    // last 4 sum is maximum
    private static long[] sort(long[] arr){
        long temp;
        for(int i = 0; i < arr.length; i++){
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        return arr;
    }

    private static long minimumSum(long arr[]){
        long sum = 0;
        for (int i = 0; i < arr.length - 1; i++){
            sum = sum + arr[i];
        }
        return sum;
    }

    private static long maximumSum(long arr[]){
        long sum = 0;
        for (int i = 1; i < arr.length; i++){
            sum = sum + arr[i];
        }
        return sum;
    }
}
