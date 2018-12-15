package practice.graph;

import java.util.*;

public class GraphBFS {

    private static List<List<Integer>> graph;

    public static void main(String[] args){
        int v = 6;
        initialize(v);

        addEdge(0, 1);
        addEdge(0, 2);
        addEdge(1, 2);
        addEdge(2, 0);
        addEdge(2, 3);
        addEdge(3, 3);

        BFS(2);
    }

    private static void initialize(int v){
        graph = new ArrayList<List<Integer>>();
        for(int i = 0; i < v; i++){
            graph.add(new ArrayList<Integer>());
        }
    }

    private static void addEdge(int start, int end){
        graph.get(start).add(end);
    }

    private static void BFS(int src){
        List<Integer> visited = new ArrayList<Integer>();
        Stack<Integer> queue = new Stack<Integer>();

        queue.add(src);
        visited.add(src);

        while (!queue.isEmpty()){
            int a = queue.pop();
            System.out.print(a + " ");
            List<Integer> integers = graph.get(a);
            for(int i = 0; i < integers.size(); i++){
                if(!visited.contains(integers.get(i))){
                    queue.add(integers.get(i));
                    visited.add(integers.get(i));
                }
            }

        }

    }
}
