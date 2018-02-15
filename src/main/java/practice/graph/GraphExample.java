package practice.graph;

import java.util.*;

public class GraphExample {

    private static Queue<Integer> bfsQueue = new LinkedList<Integer>();
    private static Stack<Integer> dfsStack = new Stack<Integer>();

    static class Graph {
        int V;
        LinkedList<Integer> lists[];
        Graph(int V){
            this.V = V;
            lists = new LinkedList[V];

            for(int i = 0; i < V ; i++){
                lists[i] = new LinkedList<Integer>();
            }
        }
    }

    static void addEdge(Graph graph, int src, int dest){
        graph.lists[src].addFirst(dest);
        graph.lists[dest].addFirst(src);
    }

    static void printGraph(Graph graph){
        for(int v = 0; v < graph.V; v++){
            System.out.println("Adjacency list of vertex "+ v);
            System.out.print("head");

            for(Integer data : graph.lists[v]){
                System.out.print(" -> " + data);
            }

            System.out.println("\n");
        }
    }

    public static void main(String[] args){
        undirected();
    }


    private static void undirected(){
        int V = 5;
        Graph graph = new Graph(V);
        addEdge(graph, 0, 1);
        addEdge(graph, 0, 4);
        addEdge(graph, 1, 2);
        addEdge(graph, 1, 3);
        addEdge(graph, 1, 4);
        addEdge(graph, 2, 3);
        addEdge(graph, 3, 4);


//        addEdge(graph,0, 1);
//        addEdge(graph,0, 2);
//        addEdge(graph,1, 2);
//        addEdge(graph,2, 0);
//        addEdge(graph,2, 3);
//        addEdge(graph,3, 3);


        System.out.println("Undirected Graph Example");
        printGraph(graph);
        BFS(graph, 0);
        DFS(graph, 0);
    }

    //solution 2
    private static void BFS(Graph graph, int src){
        List<Integer> visitedList = new ArrayList<Integer>();
        int[] ar = new int[graph.lists.length];
        Arrays.fill(ar, 0);
        bfsQueue.add(src);
        ar[src] = 0;
        visitedList.add(src);
        System.out.println("Graph BFS");
        int count = 0;
        while (!bfsQueue.isEmpty()){
            int a = bfsQueue.poll();
            System.out.println(a);
            List<Integer> integers = graph.lists[a];
            count++;
            for(int i = 0; i < integers.size(); i++){
                if(!visitedList.contains(integers.get(i))){
                    ar[integers.get(i)] = count;
                    bfsQueue.add(integers.get(i));
                    visitedList.add(integers.get(i));
                }
            }
        }
        System.out.println(Arrays.toString(ar));
    }


    //solution 2
    private static void DFS(Graph graph, int src){
        List<Integer> visitedList = new ArrayList<Integer>();
        dfsStack.add(src);
        visitedList.add(src);

        System.out.println("Graph DFS");
        while (!dfsStack.isEmpty()){
            int a = dfsStack.pop();
            System.out.println(a);
            List<Integer> integers = graph.lists[a];
            for(int i = 0; i < integers.size(); i++){
                if(!visitedList.contains(integers.get(i))){
                    dfsStack.add(integers.get(i));
                    visitedList.add(integers.get(i));
                }
            }
        }
    }
}
