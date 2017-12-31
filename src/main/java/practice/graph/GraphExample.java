package practice.graph;

import java.util.LinkedList;

public class GraphExample {

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

        System.out.println("Undirected Graph Example");
        printGraph(graph);
    }

}
