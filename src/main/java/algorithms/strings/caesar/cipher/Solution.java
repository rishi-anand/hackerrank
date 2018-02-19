package algorithms.strings.caesar.cipher;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {


    static String caesarCipher(String s, int k) {
        if(k > 26){
            k = k % 26;
        }

        StringBuilder builder = new StringBuilder();
        boolean isSmall = Boolean.FALSE, isCaps = Boolean.FALSE;

        int encryptCharValue = 0;

        int AValue = (int) Character.valueOf('A'); //65
        int ZValue = (int) Character.valueOf('Z'); //90
        int aValue = (int) Character.valueOf('a'); //97
        int zValue = (int) Character.valueOf('z'); //122

        for(Character c : s.toCharArray()){
            int value = (int) c;
            if(aValue <= value && value <= zValue) {
                isSmall = Boolean.TRUE;
            }
            if(AValue <= value && value <= ZValue) {
                isCaps = Boolean.TRUE;
            }

            int tempValue = value + k;

            if(isSmall){
                if(tempValue > zValue){
                    while(tempValue >= zValue) {
                        tempValue = aValue + (tempValue % zValue) - 1;
                    }
                }
            }

            if(isCaps){
                if(tempValue > ZValue){
                    while(tempValue >= ZValue) {
                        tempValue = AValue + (tempValue % ZValue) - 1;
                    }
                }
            }

            encryptCharValue = tempValue;
            if(isCaps || isSmall) {
                builder.append(Character.toString((char) encryptCharValue));
            } else {
                builder.append(c);
            }

            isSmall = isCaps = Boolean.FALSE;
            tempValue = Integer.MIN_VALUE;
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next();
        int k = in.nextInt();
        String result = caesarCipher(s, k);
        System.out.println(result);
        in.close();
    }
}