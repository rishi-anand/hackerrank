package algorithms.implementation.between.two.sets;

import util.MathUtil;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int getTotalX(int[] a, int[] b) {
        // Complete this function
        int count = 0, multiple = 1;
        long lcm = MathUtil.getLcm(a);

        long gcd = MathUtil.getGcd(b);

        while((multiple * lcm) <= gcd){
            if(gcd % (lcm * multiple) == 0){
                count ++;
            }

            multiple++;
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = new int[n];
        for(int a_i = 0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        int[] b = new int[m];
        for(int b_i = 0; b_i < m; b_i++){
            b[b_i] = in.nextInt();
        }
        int total = getTotalX(a, b);
        System.out.println(total);
        in.close();
    }
}
