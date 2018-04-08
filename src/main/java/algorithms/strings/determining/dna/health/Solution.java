package algorithms.strings.determining.dna.health;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] genes = new String[n];
        for(int genes_i = 0; genes_i < n; genes_i++){
            genes[genes_i] = in.next();
        }
        int[] health = new int[n];
        for(int health_i = 0; health_i < n; health_i++){
            health[health_i] = in.nextInt();
        }

        int s = in.nextInt();
        for(int a0 = 0; a0 < s; a0++){
            int first = in.nextInt();
            int last = in.nextInt();
            String d = in.next();
            int value = calculateValue(genes, health, first, last, d);

            if(value < min){
                min = value;
            }

            if(value > max){
                max = value;
            }
        }
        System.out.println(min + " " + max);
        in.close();
    }

    private static int calculateValue(String[] genes, int[] health, int first, int last, String d){
        int[] visited = new int[d.length()];
        int sum = 0;
        Arrays.fill(visited, 1);
        for(int i = first; i <= last; i++){
            if(genes[i].length() == 1 && d.contains(genes[i])){
                sum = sum + health[i];
                visited[d.indexOf(genes[i])] = 0;
            }

            if(genes[i].length() > 1 && d.contains(genes[i])){
                int l = genes[i].length();

                for(int j = 0; j + l < d.length(); j++){
                    if(d.substring(j, j + l).equals(genes[i])){
                        sum = sum + health[i];
                    }
                }
            }
        }

        return sum;
    }
}