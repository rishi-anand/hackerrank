package thirty.days.of.code.twentyseven;

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        manualTestCase();
    }

    private static void manualTestCase(){
        System.out.println(5);

        System.out.println("4 2");
        System.out.println("3 1 3 2");

        System.out.println("5 2");
        System.out.println("-2 -5 2 -1 0");

        System.out.println("5 2");
        System.out.println("2 2 3 1 -3");

        System.out.println("6 2");
        System.out.println("-3 -4 4 -3 -4 -4");

        System.out.println("6 2");
        System.out.println("3 1 5 -5 -1 2");
    }

    private static void generateTestCaseAutomatically(){
        int totalTestCase = 5;
        String YES = "YES", NO = "NO";
        String[] testOutput = {YES, NO, YES, NO, YES};

        //System.out.println(totalTestCase);
        StringBuilder builder = new StringBuilder();
        builder.append(totalTestCase + "\n");
        int total = 4, required = 2;
        for (int i = 0; i < totalTestCase; i++){
            if(testOutput[i].equals(YES)) {
                builder.append(eachSet(total++, required++, false) + "\n");
            } else {
                builder.append(eachSet(total++, required++, true) + "\n");
            }
        }

        System.out.println(builder.toString());
    }

    private static String eachSet(int total, int required, boolean isValid){
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(total + " " + required + "\n");
        for (int i = 0; i < required; i++){
            if(isValid){
                stringBuilder.append(randInt(-5, 0));
            } else {
                stringBuilder.append(randInt(1, 5));
            }

            stringBuilder.append(" ");
        }

        for (int i = 0; i < total - required; i++){
            stringBuilder.append(randInt(-5, 5));
            stringBuilder.append(" ");
        }
        return stringBuilder.toString().trim();
    }

    public static int randInt(int min, int max) {
        int randomNum = new Random().nextInt((max - min) + 1) + min;
        return randomNum;
    }
}
