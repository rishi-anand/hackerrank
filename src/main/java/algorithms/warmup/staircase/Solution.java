package algorithms.warmup.staircase;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        printStaircase(n);
    }

    private static void printStaircase(int n){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = n; i > 0; i--){
            stringBuilder.append(printSpace(i - 1));
            stringBuilder.append(printHash(n - i + 1));
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder.toString());

    }

    private static String printSpace(int n){
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < n; i++){
            builder.append(" ");
        }
        return builder.toString();
    }

    private static String printHash(int n){
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < n; i++){
            builder.append("#");
        }
        return builder.toString();
    }
}
