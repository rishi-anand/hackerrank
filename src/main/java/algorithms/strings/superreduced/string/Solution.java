package algorithms.strings.superreduced.string;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {



    static String super_reduced_string(String s){
        // Complete this function
        boolean global = true;

        List<Character> characters = new ArrayList<Character>();

        for(int i = 0; i < s.length(); i++){
            characters.add(s.charAt(i));
        }

        boolean reduce = true;
        while (reduce) {
            reduce = reduce(characters);
        }

        if(characters.isEmpty()){
            return "Empty String";
        }

        String returnString = "";
        for (Character character : characters){
            returnString = returnString + character;
        }

        return returnString;
    }

    private static boolean reduce(List<Character> characters){
        int initialSize = characters.size();
        for (int i = 0; i < characters.size(); i++) {
            if (i < characters.size() - 1 && characters.get(i) == characters.get(i + 1)) {
                characters.remove(i);
                characters.remove(i);
                break;
            }
        }

        return (characters.size() == initialSize) ? false : true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = super_reduced_string(s);
        System.out.println(result);
    }
}
