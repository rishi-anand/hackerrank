package thirty.days.of.code.six;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        for(int t = 0 ; t < testCase; t++) {
            String input = sc.next();

            StringBuilder even = new StringBuilder();
            StringBuilder odd = new StringBuilder();

            for (int i = 0; i < input.length(); i++) {
                if (i % 2 == 0) {
                    even.append(input.charAt(i));
                } else {
                    odd.append(input.charAt(i));
                }
            }

            System.out.println(even.toString() + " " + odd.toString());
        }

    }

}
