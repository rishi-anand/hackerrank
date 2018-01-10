package algorithms.graph.theory.roads.and.libraries;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int[] visited;
    //static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        while(testCases-- > 0){
            int noOfCities = sc.nextInt();
            int noOfRoads = sc.nextInt();
            List<Integer>[] list = new List[noOfCities + 1];
            visited = new int[noOfCities + 1];
            Arrays.fill(visited, 0);
            for(int i = 0; i < noOfCities+1; i++){
                list[i] = new ArrayList();
            }
            int costOfLibrary = sc.nextInt();
            int costOfRoads = sc.nextInt();
            for(int t = 0; t < noOfRoads; t++){
                int t1 = sc.nextInt();
                int t2 = sc.nextInt();
                list[t1].add(t2);
                list[t2].add(t1);
            }
            System.out.println(getCost(list, costOfLibrary,costOfRoads));

        }
    }

    public static long getCost(List<Integer>[] list,int costOfLibrary, int costOfRoads){

        long sum = 0;
        int count = 0;
        for(int i = 1; i < list.length; i++){
            if(visited[i] != 1){
                count = DFS(list, i, count);
                if (costOfLibrary > costOfRoads) {
                    sum += costOfLibrary + costOfRoads * (count - 1);
                } else {
                    sum += costOfLibrary * count;
                }
                count = 0;
            }
        }
        return sum;
    }

    public static int DFS(List<Integer>[] list, int start, int count){
        visited[start] = 1;
        count++;
        for(int i = 0; i < list[start].size(); i++){
            int temp  = list[start].get(i);
            if(visited[temp] != 1){
                count = DFS(list, temp, count);
            }
        }
        return count;
    }

}