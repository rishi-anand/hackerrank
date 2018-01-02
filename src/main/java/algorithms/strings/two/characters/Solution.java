package algorithms.strings.two.characters;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int twoCharaters(String s) {
        // Complete this function
        int count = 0; char previous;
        Map<Character, Integer> characters = new HashMap<Character, Integer>();
        for(int i = 0; i < s.length(); i++){

            if(characters.containsKey(s.charAt(i))){
                characters.put(s.charAt(i), characters.get(s.charAt(i)) + 1);
            } else {
                characters.put(s.charAt(i), 1);
            }

            if(i == 0){
                previous = s.charAt(i);
            }
        }



        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int l = in.nextInt();
        String s = in.next();
        int result = twoCharaters(s);
        System.out.println(result);
        in.close();
    }
}
