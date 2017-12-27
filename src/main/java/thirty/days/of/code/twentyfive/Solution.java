package thirty.days.of.code.twentyfive;

import java.io.*;
import java.util.*;

public class Solution {



    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        for (int k = 0; k < l; k++){
            int n = sc.nextInt();
            System.out.println(isPrimeShort(n) ? "Prime" : "Not prime");

        }

    }

    private static boolean isPrimeLong(int n) {
        if(n % 2 == 0){
            return true;

        } else {

            for(int i = 3; i < ((n + 1) / 2) ; i++){
                if(n % i == 0){
                    return false;
                }
            }
            return true;
        }
    }

    private static boolean isPrimeShort(int n) {
        if (n < 2) {
            return false;
        }
        int sqrt = (int) Math.sqrt(n);
        for (int i = 2; i <= sqrt; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
