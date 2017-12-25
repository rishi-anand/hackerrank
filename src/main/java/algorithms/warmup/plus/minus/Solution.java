package algorithms.warmup.plus.minus;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    private static int sampleArray[] = {-4, 3, -9, 0, 4, 1 };

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for(int arr_i=0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }

        printFraction(arr);

    }

    private static void printFraction(int arr[]){
        int length = arr.length;
        int p = 0, n = 0, z = 0;

        for(int i = 0; i < length; i++){
            if(arr[i] == 0){
                z++;
            } else if(arr[i] > 0){
                p++;
            } else {
                n++;
            }
        }

        double pp = (double) p / length;
        double np = (double) n / length;
        double zp = (double) z / length;
        System.out.println(pp);
        System.out.println(np);
        System.out.println(zp);

    }
}
