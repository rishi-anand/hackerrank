package extra.graph;

import java.util.LinkedList;

public class GraphExample {

    static class Graph {
        int V;
        LinkedList<Integer>[] lists;

        Graph(int V){
            lists = new LinkedList[V];
        }
    }

}
