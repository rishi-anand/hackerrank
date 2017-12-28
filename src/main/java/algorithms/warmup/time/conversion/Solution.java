package algorithms.warmup.time.conversion;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static String timeConversion(String s) {
        // Complete this function
        String[] time = s.split(":");
        if(time[2].contains("PM")){
            if(time[0].equals("12")){
                return (time[0]) + ":"+ time[1] + ":" + time[2].substring(0, 2);
            }
            return (Integer.valueOf(time[0]) + 12) + ":"+ time[1] + ":" + time[2].substring(0, 2);
        } else {
            if(time[0].equals("12")){
                return "00" + ":"+ time[1] + ":" + time[2].substring(0, 2);
            }
            return time[0] + ":"+ time[1] + ":" + time[2].substring(0, 2);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = timeConversion(s);
        System.out.println(result);
    }
}