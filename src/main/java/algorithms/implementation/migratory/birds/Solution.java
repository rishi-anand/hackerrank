package algorithms.implementation.migratory.birds;

import org.omg.PortableInterceptor.INACTIVE;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int migratoryBirds(int n, int[] ar) {
        // Complete this function
        Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();

        for(int i = 0; i < ar.length; i++){
            if(countMap.containsKey(ar[i])){
                int value = countMap.get(ar[i]);
                countMap.put(ar[i], ++value);
            } else {
                countMap.put(ar[i], 1);
            }
        }

        int maxValue = Integer.MIN_VALUE, maxKey = 0;
        for(Map.Entry<Integer, Integer> entry : countMap.entrySet()){
            if(entry.getValue() > maxValue){
                maxValue = entry.getValue();
                maxKey = entry.getKey();
                continue;
            }

            if(entry.getValue() == maxValue && entry.getKey() < maxKey){
                maxKey = entry.getKey();
            }
        }


        return maxKey;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int result = migratoryBirds(n, ar);
        System.out.println(result);
    }
}