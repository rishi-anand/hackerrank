package practice.misc.matrix;

/*
A Boolean Matrix Question
Given a boolean matrix mat[M][N] of size M X N, modify it such that if a matrix cell mat[i][j] is 1 (or true) then make all the cells of ith row and jth column as 1.

Example 1
The matrix
1 0
0 0
should be changed to following
1 1
1 0

Example 2
The matrix
0 0 0
0 0 1
should be changed to following
0 0 1
1 1 1

Example 3
The matrix
1 0 0 1
0 0 1 0
0 0 0 0
should be changed to following
1 1 1 1
1 1 1 1
1 0 1 1

*/


public class Solution {

    private static final Integer ONE = 1;

    private static int[][] arr = {
            {1, 0},
            {0, 0}
    };

    private static int[][] visited;

    static {
        visited = new int[2][2];
    }

    public static void main(String[] args){
        System.out.println("Starting...");
        convert();
        System.out.println("Done!");
    }

    private static void convert(){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length; j++){
                if(arr[i][j] == ONE && visited[i][j] != 1){
                    updateWithOne(i, j);
                }
            }
        }
    }

    private static void updateWithOne(int i, int j){
        for(int x = 0; x < arr.length; x++){
            arr[i][x] = ONE;
            visited[i][x] = 1;
        }

        for(int y = 0; y < arr.length; y++){
            arr[y][j] = ONE;
            visited[y][j] = 1;
        }
    }
}
