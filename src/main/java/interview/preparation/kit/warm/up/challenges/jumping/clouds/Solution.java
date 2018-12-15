package interview.preparation.kit.warm.up.challenges.jumping.clouds;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    static int jumpingOnClouds(int[] c) {
        for(int i = 0; i < c.length; i++){

        }

        return 0;
    }
    public static void main(String[] args) throws IOException {
        int[] c = new int[3];

//        int n = scanner.nextInt();
//
//        int[] c = new int[n];
//
//        String[] cItems = scanner.nextLine().split(" ");
//        for (int i = 0; i < n; i++) {
//            int cItem = Integer.parseInt(cItems[i]);
//            c[i] = cItem;
//        }

        c = new int[7];
        c = new int[]{0, 0, 1, 0, 0, 1, 0};
        System.out.println("input: "+ Arrays.toString(c));
        int result = jumpingOnClouds(c);
        System.out.println(result);

        scanner.close();
    }


}
