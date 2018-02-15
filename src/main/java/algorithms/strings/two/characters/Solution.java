package algorithms.strings.two.characters;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    private static List<Character> removableChars = new ArrayList<Character>();

    static int twoCharaters(String s) {
        // Complete this function
        List<Character> characters = new ArrayList<Character>();

        for(int i = 0; i < s.length(); i++){
            characters.add(s.charAt(i));
        }

        reduce(characters, s);

        for(Character c : removableChars){
            s = s.replace(String.valueOf(c), "");
        }


        Map<Character, Integer> charactersMap = new HashMap<Character, Integer>();
        for(int i = 0; i < s.length(); i++){
            if(charactersMap.containsKey(s.charAt(i))){
                charactersMap.put(s.charAt(i), charactersMap.get(s.charAt(i)) + 1);
            } else {
                charactersMap.put(s.charAt(i), 1);
            }
        }

        int max = 0, secondMax = 0;

        for (Map.Entry<Character, Integer> entry : charactersMap.entrySet()){
            if(entry.getValue() > max){
                secondMax = max;
                max = entry.getValue();
                continue;
            }

            if(entry.getValue() > secondMax && entry.getValue() <= max){
                secondMax = entry.getValue();
                continue;
            }
        }

        return max + secondMax;
    }

    private static void reduce(List<Character> characters, String s){
        for (int i = 0; i < characters.size(); i++) {
            if (i < characters.size() - 1 && characters.get(i) == characters.get(i + 1)) {
                removableChars.add(characters.get(i));
                //s.replaceAll(String.valueOf(characters.get(i)), "");
            }
        }
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
