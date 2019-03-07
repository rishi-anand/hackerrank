package practice.misc.generate.paranthesis;

import java.util.ArrayList;
import java.util.*;

public class Solution {

    private static final String BRACKET_OPEN = "(";
    private static final String BRACKET_CLOSE = ")";

    public static void main(String[] args){
        int n = 6;
        for(String s : generateParantesis(n)){
            System.out.println(s);
        }
    }

    //((()))
    //(()())
    //()()()
    //(())()
    //()(())
//    public static List<String> generateParantesis(int n){ // n is given number of pairs
//        List<String> result = new ArrayList<>();
//        Set<String> generatedSet = new HashSet<>();
//        boolean iterate = true;
//        int count = n * 2;
//
//        while(iterate){
//            String sb = "";
//            //(((
//            if(sb.isEmpty()){
//                sb = sb + "(";
//            } else {
//                if(sb.length() > )
//            }
//        }
//        return result;
//    }

    public static List<String> generateParantesis(int n){ // n is given number of pairs
        List<String> result = new ArrayList<>();

        return result;
    }

    private static boolean isValid(String input){
        for(int i = 0; i < input.length(); i++){

        }
        return false;
    }
}
