package algorithms.graph.theory.roads.and.libraries;

import practice.graph.GraphExample;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static class Graph {
        int V;
        List<Integer> lists[];
        Graph(int V){
            this.V = V;
            lists = new LinkedList[V];

            for(int i = 0; i < V ; i++){
                lists[i] = new LinkedList<Integer>();
            }

            //System.out.println("Size of lists : " + lists.length);
        }
    }


    static void addEdge(Graph graph, int src, int dest){
        try {
            graph.lists[src].add(dest);
            graph.lists[dest].add(src);
        } catch (Exception e){
            //System.out.println("Exception - src: " + src + ", dest: " + dest);
        }
    }

    static void printGraph(Graph graph){
        for(int v = 0; v < graph.V; v++){
            System.out.println("Adjacency list of vertex "+ (v + 1));
            System.out.print(v + 1);

            for(Integer data : graph.lists[v]){
                System.out.print(" -> " + ++data);
            }

            System.out.println("\n");
        }
    }

    static int roadsAndLibraries(int n, int c_lib, int c_road, int[][] cities) {
        // Complete this function
        Graph graph = convertToGraph(n, cities);
        //System.out.println("Convert to graph done");
        Set<Set<Integer>> sets = new HashSet<Set<Integer>>();
        populateSet(graph, sets);

        //System.out.println("populate done");

        int totalCity = 0, isolatedCityCost = 0;
        int costLib = 0, costRoad = 0;
        for(Set<Integer> outerSet : sets){
            totalCity = totalCity + outerSet.size();
            costLib = costLib + outerSet.size() * c_lib;
            if(outerSet.size() == 1){
                costRoad = costRoad + c_lib;
            } else {
                costRoad = costRoad + (((outerSet.size() - 1) * c_road) + c_lib);
            }

        }

        if(totalCity < n){
            isolatedCityCost = (n - totalCity) * c_lib;
        }

        return (costLib > costRoad) ? costRoad + isolatedCityCost : costLib + isolatedCityCost;
    }

    public static void populateSet(Graph graph, Set<Set<Integer>> sets){
        for(int v = 0; v < graph.V; v++){
            //System.out.println(" populateSet v : " + v);
            Set<Integer> currentSet = new HashSet<Integer>();
            currentSet.add(v + 1);
            boolean save = true;

            for(Integer data : graph.lists[v]){
                currentSet.add(++data);
            }

            if(sets.isEmpty()){
                sets.add(currentSet);
            } else {
                Iterator<Set<Integer>> it = sets.iterator();
                while (it.hasNext() && save) {
                    Set<Integer> set = it.next();
                    if(currentSet.containsAll(set) && currentSet.size() > set.size()){
                        it.remove();
                        save = false;
                        sets.add(currentSet);
                    }
                    if(set.containsAll(currentSet)){
                        save = false;
                    }
                }
            }

            if(save) {
                sets.add(currentSet);
            }
        }
    }

    public static Graph convertToGraph(int n, int[][] cities){
        Graph graph = new Graph(n);
        for(int i = 0; i < cities.length; i++){
            int[] edges = cities[i];
            addEdge(graph, --edges[0], --edges[1]);
        }

        return graph;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int n = in.nextInt();
            int m = in.nextInt();
            int c_lib = in.nextInt();
            int c_road = in.nextInt();
            int[][] cities = new int[m][2];
            for(int cities_i = 0; cities_i < m; cities_i++){
                for(int cities_j = 0; cities_j < 2; cities_j++){
                    cities[cities_i][cities_j] = in.nextInt();
                }
            }
            int result = roadsAndLibraries(n, c_lib, c_road, cities);
            System.out.println(result);
        }
        in.close();
    }
}