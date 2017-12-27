package thirty.days.of.code.twentysix;

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        String returnDate = sc.nextLine();
        String expectedDate = sc.nextLine();

        String[] returnArr = returnDate.split(" ");
        String[] expectedArr = expectedDate.split(" ");

        //same year
        if(Integer.valueOf(returnArr[2]) - Integer.valueOf(expectedArr[2]) == 0){
            //same month
            if(Integer.valueOf(returnArr[1]) - Integer.valueOf(expectedArr[1]) == 0){

                //same date as expected
                if(Integer.valueOf(returnArr[0]) - Integer.valueOf(expectedArr[0]) == 0){
                    System.out.println(0);

                    //returned on later date from expected
                } else if(Integer.valueOf(returnArr[0]) - Integer.valueOf(expectedArr[0]) > 0){
                    System.out.println(15 * (Integer.valueOf(returnArr[0]) - Integer.valueOf(expectedArr[0])));
                } else {
                    //returned before from expected
                    System.out.println(0);
                }
                //returned in month ahead of expected of month
            } else if(Integer.valueOf(returnArr[1]) - Integer.valueOf(expectedArr[1]) > 0){
                System.out.println(500 * (Integer.valueOf(returnArr[1]) - Integer.valueOf(expectedArr[1])));
            } else {
                //returned in month which is less than expected month
                System.out.println(0);
            }

            //returned in year ahead of expected of year
        } else if(Integer.valueOf(returnArr[2]) - Integer.valueOf(expectedArr[2]) > 0){
            System.out.println(10000);
        } else {
            //returned in year is less than expected year
            System.out.println(0);
        }
    }
}