package algorithms.implementation.day.of.the.programmer;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static String solve(int year){
        // Complete this function
        StringBuilder builder = new StringBuilder();
        int totalDays = 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31;
        int month = 9;

        if( year >= 1700 && year <= 1917){
            if(year % 4 == 0){
                totalDays += 1;
            }
        } else if (year == 1918){
            totalDays -= 13;

        } else if(year >= 1919){
            if(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)){
                totalDays += 1;
            }
        }

        if(Math.abs(256 - totalDays) == 0){
            totalDays = 31;
            month -= 1;
        }
        builder.append(Math.abs(256 - totalDays));
        builder.append(".0"+month+".");
        builder.append(year);
        return builder.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int year = in.nextInt();
        String result = solve(year);
        System.out.println(result);
    }
}