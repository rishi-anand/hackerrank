package practice.graph;

import java.util.*;

public class GraphDFS {

    private static List<Integer> visitedList = new ArrayList<Integer>();
    private static Queue<Integer> queue = new LinkedList<Integer>();

    private static List<Integer> visited;

    class Graph{

        private List<Integer>[] lists;

        Graph(int v){
            lists = new List[v];

            //initialize list
            for(int i = 0; i < lists.length; i++){
                lists[i] = new ArrayList<Integer>();
            }
        }
    }

    private void addEdge(Graph graph, int src, int dest){
        graph.lists[src].add(dest);
        graph.lists[dest].add(src);
    }

    private void printGraph(Graph graph){
        for (int i = 0; i < graph.lists.length; i++){
            System.out.println("Head : " + i);
            for(Integer v : graph.lists[i]){
                System.out.print("-->" + v);
            }
            System.out.println("\n");
        }
    }

    //solution 1
    private static int dfs(Graph graph, int src, int count){
        visited.set(src, 1);
        count++;
        for (int i = 0; i < graph.lists[src].size(); i++){
            int temp = graph.lists[src].get(i);
            if(visited.get(temp) != 1){
                count = dfs(graph, temp, count);
            }
        }
        return count;
    }

    //solution 2
    private static void BFS(Graph graph){
        Collections.fill(visitedList, 0);
        queue.add(0);

        while (!queue.isEmpty()){
            int a = queue.poll();
            System.out.println(a);
            List<Integer> integers = graph.lists[a];
            for(int i = 0; i < integers.size(); i++){
                if(!visited.contains(integers.get(i))){
                    queue.add(integers.get(i));
                    visited.add(integers.get(i));
                }
            }
        }
    }

    public static void main(String[] args){
        visited = new ArrayList<Integer>();
        Collections.fill(visited, 0);



    }
}
