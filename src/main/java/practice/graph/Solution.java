package practice.graph;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the function below.
     */
    static long waitingTime(int[] tickets, int p) {
        try {
            long result = 0;
            int indexOfP;
            List<Integer> integers = new ArrayList<Integer>();
            for (Integer i : tickets) {
                integers.add(i);
            }

            boolean isTrue = Boolean.TRUE;
            indexOfP = p;
            //System.out.println(" while add integers: " + Arrays.toString(integers.toArray()) + ", indexOfP : " + indexOfP + ", result: " + result);
            while (isTrue) {
                if(indexOfP == 0 && integers.get(indexOfP) == 1){
                    isTrue = false;
                    result = result + 1;
                    //System.out.println("********* result : " + result);
                    return result;
                }

                int x = integers.get(0);
                //System.out.println("x : " + x + ", integers: " + Arrays.toString(integers.toArray()));
                integers.remove(0);
                //System.out.println(" remove integers: " + Arrays.toString(integers.toArray()));

                x = x - 1;
                if (x != 0) {
                    integers.add(integers.size(), x);
                    if (indexOfP == 0) {
                        indexOfP = integers.size() - 1;
                    } else {
                        indexOfP = indexOfP - 1;
                    }
                } else {
                    indexOfP = indexOfP - 1;
                }



                result++;
                //System.out.println(" while add integers: " + Arrays.toString(integers.toArray()) + ", indexOfP : " + indexOfP + ", result: " + result);
            }

            //System.out.println("result " + result);
            return result;
        } catch (Exception e){
            e.printStackTrace();
            return 0L;
        }
    }


    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = null;
        if (fileName != null) {
            bw = new BufferedWriter(new FileWriter(fileName));
        }
        else {
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        long res;
        int tickets_size = 0;
        tickets_size = Integer.parseInt(in.nextLine().trim());

        int[] tickets = new int[tickets_size];
        for(int i = 0; i < tickets_size; i++) {
            int tickets_item;
            tickets_item = Integer.parseInt(in.nextLine().trim());
            tickets[i] = tickets_item;
        }

        int p;
        p = Integer.parseInt(in.nextLine().trim());

        res = waitingTime(tickets, p);
        bw.write(String.valueOf(res));
        bw.newLine();

        bw.close();
    }
}


/*


4
5
5
2
3
3



5
2
6
3
4
5
2

 */