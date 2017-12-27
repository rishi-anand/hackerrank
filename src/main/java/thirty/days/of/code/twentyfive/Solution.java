package thirty.days.of.code.twentyfive;

import java.io.*;
import java.util.*;

public class Solution {



    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int[] arr = new int[l];
        for (int i = 0; i < l; i++){
            arr[i] = sc.nextInt();
        }

        for (int n : arr){
            if(n % 2 == 0){
                System.out.println("Not prime");
                continue;
            } else {
                boolean isPrime = true;
                for(int i = 3; i < ((n + 1) / 2) ; i++){
                    if(n % i == 0){
                        isPrime = false;
                        System.out.println("Not prime");
                        break;
                    }
                }

                if(isPrime){
                    System.out.println("Prime");
                }
            }
        }
    }
}
