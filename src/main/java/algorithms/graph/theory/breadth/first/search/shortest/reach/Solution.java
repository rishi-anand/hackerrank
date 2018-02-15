package algorithms.graph.theory.breadth.first.search.shortest.reach;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    private static Queue<Integer> bfsQueue = new LinkedList<Integer>();
    private static int[] arr;


    private static LinkedList<Integer> lists[];

    private static void BFS(int src){
        String result = "";
        List<Integer> visitedList = new ArrayList<Integer>();
        //int[] ar = new int[lists.length];
        Arrays.fill(arr, -1);
        bfsQueue.add(src);
        arr[src] = 0;
        visitedList.add(src);
        int count = 0;
        while (!bfsQueue.isEmpty()){
            int a = bfsQueue.poll();
            List<Integer> integers = lists[a];
            count = count + 6;
            for(int i = 0; i < integers.size(); i++){
                if(!visitedList.contains(integers.get(i))){
                    arr[integers.get(i)] = count;
                    bfsQueue.add(integers.get(i));
                    visitedList.add(integers.get(i));
                }
            }
        }

        for(int i = 1; i < arr.length; i++){
            if(arr[i] != 0){
                result = result + arr[i] + " ";
            }
        }

        System.out.println(result);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int n = in.nextInt();
            lists = new LinkedList[n + 1];

            for(int i = 0; i < n + 1; i++){
                lists[i] = new LinkedList<Integer>();
            }

            arr = new int[n + 1];

            int m = in.nextInt();
            for(int a1 = 0; a1 < m; a1++){
                int u = in.nextInt();
                int v = in.nextInt();
                lists[u].addFirst(v);
                lists[v].addFirst(u);
            }
            int s = in.nextInt();
            BFS(s);
        }
        in.close();
    }
}
