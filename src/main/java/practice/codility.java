package practice;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class codility {

    public static int solution(int[] A) {
        // write your code in Java SE 8
        int currentValue = A[0];
        List<Integer> linkedList = new LinkedList<Integer>();
        linkedList.add(A[0]);
        boolean inProgress = true;
        while (inProgress){
            if(A[currentValue] == -1){
                inProgress = false;
            } else {
                currentValue = A[currentValue];
            }

            linkedList.add(A[currentValue]);
        }

        return linkedList.size();
    }

    public static void main(String[] args){
        int[] A = {1, 4, -1, 3,2};
        System.out.println(solution(A));
    }
}
