package algorithms.implementation.bon.appetit;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static String bonAppetit(int n, int k, int b, int[] ar) {
        // Complete this function
        double totalShared = 0;
        for(int i = 0; i < n; i++){
            if(i != k){
                totalShared = totalShared + ar[i];
            }
        }

        totalShared = totalShared / 2;
        if(totalShared == b){
            return "Bon Appetit";
        } else {
            return String.valueOf((int)(b - totalShared));
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int b = in.nextInt();
        String result = bonAppetit(n, k, b, ar);
        System.out.println(result);
    }
}