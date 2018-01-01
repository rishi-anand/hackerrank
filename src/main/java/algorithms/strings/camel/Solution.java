package algorithms.strings.camel;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int camelcase(String s) {
        // Complete this function
        int count = (s.length() > 0) ? 1 : 0;
        String regEx = "([A-Z])";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(s);
        while (matcher.find())
            count++;

        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int result = camelcase(s);
        System.out.println(result);
        in.close();
    }
}