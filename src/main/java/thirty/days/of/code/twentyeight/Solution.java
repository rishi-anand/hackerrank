package thirty.days.of.code.twentyeight;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

    private static String[] sampleArray = {"riya riya@gmail.com", "julia julia@julia.me", "julia sjulia@gmail.com",
            "julia julia@gmail.com", "samantha samantha@gmail.com", "tanya tanya@gmail.com"};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        String[] infoArray = new String[n];
        for (int i = 0; i < n; i++){
            infoArray[i] = sc.nextLine();
        }

        sc.close();

        getFirstName(infoArray);
    }

    private static void getFirstName(String[] infoArray){
        List<String> namesList = new ArrayList<String>();

        for (String info : infoArray){
            if(info.contains("@gmail.com")){
                String[] names = info.split(" ");
                namesList.add(names[0]);
            }
        }

        Collections.sort(namesList);
        for (String name : namesList){
            System.out.println(name);
        }
    }
}