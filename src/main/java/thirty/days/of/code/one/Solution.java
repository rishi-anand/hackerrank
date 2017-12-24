package thirty.days.of.code.one;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        int i = 4;
        double d = 4.0;
        String s = "HackerRank ";

        Scanner scan = new Scanner(System.in);

        /* Declare second integer, double, and String variables. */
        int si = scan.nextInt();
        double ds = scan.nextDouble();

        String ss="";
        ss+=scan.nextLine();
        String sss = scan.nextLine();
        /* Read and save an integer, double, and String to your variables.*/
        // Note: If you have trouble reading the entire String, please go back and review the Tutorial closely.
        System.out.println(i + si);
        /* Print the sum of both integer variables on a new line. */
        System.out.println(d + ds);
        /* Print the sum of the double variables on a new line. */
        System.out.println(s + sss);
        /* Concatenate and print the String variables on a new line;
        	the 's' variable above should be printed first. */


        scan.close();
    }
}
