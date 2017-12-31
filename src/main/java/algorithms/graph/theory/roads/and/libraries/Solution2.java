package algorithms.graph.theory.roads.and.libraries;


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


class DisjointSet {


    private Map<Long, Node> map = new HashMap<Long, Node>();

    class Node {
        long data;
        Node parent;
        int rank;
    }

    public void makeSet(long data) {
        Node node = new Node();
        node.data = data;
        node.parent = node;
        node.rank = 0;
        map.put(data, node);
    }

    public boolean union(long data1, long data2) {
        Node node1 = map.get(data1);
        Node node2 = map.get(data2);

        Node parent1 = findSet(node1);
        Node parent2 = findSet(node2);

        //if they are part of same set do nothing
        if (parent1.data == parent2.data) {
            return false;
        }

        //else whoever's rank is higher becomes parent of other
        if (parent1.rank >= parent2.rank) {
            //increment rank only if both sets have same rank
            parent1.rank = (parent1.rank == parent2.rank) ? parent1.rank + 1 : parent1.rank;
            parent2.parent = parent1;
        } else {
            parent1.parent = parent2;
        }
        return true;
    }

    public long findSet(long data) {
        return findSet(map.get(data)).data;
    }

    private Node findSet(Node node) {
        Node parent = node.parent;
        if (parent == node) {
            return parent;
        }
        node.parent = findSet(node.parent);
        return node.parent;
    }
}




public class Solution2 {

    static long calculate(int n, int c_lib, int c_road, int[][] cities) {
        DisjointSet ds = new DisjointSet();

        for (int i = 1; i <= n; i++) {
            ds.makeSet(i);
        }

        for (int i = 0; i < cities.length; i++) {
            int[] city = cities[i];
            System.out.println("Union (" + city[0] + ","+ city[1] + ")");
            ds.union(city[0], city[1]);
        }


        Map<Long, Long> map = new HashMap<Long, Long>();
        long disJoint = ds.findSet(1);
        long disJointCount = 1;


        for (int i = 2; i <= n; i++) {
            long dis = ds.findSet(i);
            if (dis == disJoint) {
                disJointCount++;
            } else {
                map.put(disJoint, disJointCount);
                disJoint = dis;
                disJointCount = 1;
            }


            if(i == n){
                map.put(disJoint, disJointCount);
            }
        }

        return cost(map, c_lib, c_road, n);
    }

    static long cost(Map<Long, Long> map, int c_lib, int c_road, int n){
        long costLib = 0, costRoad = 0;
        for(Map.Entry<Long, Long> m : map.entrySet()){
            costLib = costLib + (m.getValue() * c_lib);
            if(m.getValue() == 1){
                costRoad = costRoad + c_lib;
            } else {
                costRoad = costRoad + (((m.getValue() - 1) * c_road) + c_lib);
            }

        }

        return (costLib > costRoad) ? costRoad : costLib;
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
            //long result = roadsAndLibraries(n, c_lib, c_road, cities);
            long result = calculate(n, c_lib, c_road, cities);
            System.out.println(result);
        }
        in.close();
    }



/*

1
10 6 2 5
1 3
3 4
2 4
1 2
2 3
8 9

*/
}

/*

1
10 6 2 5
1 3
3 4
2 4
1 2
2 3
8 9

map =  size = 6
        0 = "1" -> "4"
        1 = "5" -> "1"
        2 = "6" -> "1"
        3 = "7" -> "1"
        4 = "8" -> "2"
        5 = "10" -> "1"
        c_lib = 2
        c_road = 5
        n = 10

        */


