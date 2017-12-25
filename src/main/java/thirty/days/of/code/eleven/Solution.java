package thirty.days.of.code.eleven;

import java.util.*;

public class Solution {
    public static int sampleArray[][] = {
            {1, 1, 1, 0, 0, 0},
            {0, 1, 0, 0, 0, 0},
            {1, 1, 1, 0, 0, 0},
            {0, 0, 2, 4, 4, 0},
            {0, 0, 0, 2, 0, 0},
            {0, 0, 1, 2, 4, 0},
    };

    public static int sampleArray2[][] = {
            {0, -4, -6, 0, -7, -6},
            {-1, -2, -6, -8, -3, -1},
            {-8, -4, -2, -8, -8, -6},
            {-3, -1, -2, -5, -7, -4},
            {-3, -5, -3, -6, -6, -6},
            {-3, -6, 0, -8, -6, -7},
    };


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arr[][] = new int[6][6];
        for(int i=0; i < 6; i++){
            for(int j=0; j < 6; j++){
                arr[i][j] = in.nextInt();
            }
        }

        //complete your code
        System.out.println(simple());

        //System.out.println(getLargestSumRecursion(0, 0, Integer.MIN_VALUE));


    }

    //Way 1 : simple for loop
    private static int simple(){
        int sum = Integer.MIN_VALUE;
        for(int i =0; i < 4; i++){
            for(int j = 0; j < 4; j++){

                int tmp = getSum(sampleArray, i, j);

                if(tmp >= sum){
                    sum = tmp;
                }
            }
        }
        return sum;
    }

    //Way 2 : Using recursion
    public static int getLargestSumRecursion(int i, int j, int sum){
        if(i > 3 || j > 3)
            return sum;
        int temp =  Integer.MIN_VALUE;
        temp = getSum(sampleArray, i, j);
        sum = temp > sum ? temp : sum;
        int t1 = getLargestSumRecursion(i, ++j, sum);
        int t2 = getLargestSumRecursion(++i, 0, sum);
        return t1 > t2 ? t1 : t2;
    }


    public static int getSum(int sampleArray[][], int i, int j){
        return sampleArray[i][j] + sampleArray[i][j+1] + sampleArray[i][j+2] +
                sampleArray[i+1][j+1] + sampleArray[i+2][j] + sampleArray[i+2][j+1] + sampleArray[i+2][j+2];
    }

}


/*
a[0][0]  a[0][1]  a[0][2]
a[1][0]  a[1][1]  a[1][2]
a[2][0]  a[2][1]  a[2][2]
*/
