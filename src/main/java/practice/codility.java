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
//        int[] A = {1, 4, -1, 3,2};
//        System.out.println(solution(A));

        oddDivisorSum(5);
    }


    private static int getCoresPerSocket(int cpu, int maxSockets){
        Integer coresPerSocket = 0;
        if(cpu > 0 && maxSockets > 0){
            if(maxSockets == 1){ //if maxSocket is 1 then no. of cores per cpu should be equal to cpu count.
                return cpu;
            } else if(cpu > maxSockets){
                if(cpu % maxSockets == 0){
                    coresPerSocket = (cpu / maxSockets);
                } else {
                    while(cpu % maxSockets != 0 && maxSockets > 1){
                        maxSockets--;
                        if(cpu % maxSockets == 0){
                            coresPerSocket = (cpu / maxSockets);
                            break;
                        }
                    }
                }
            }
        }

        //When return type is 0 then no any cores will be added to cpu and cpu count of sockets will be created.
        return coresPerSocket;
    }

    private static void oddDivisorSum(int divisor){
        long sum = 0;
        int test = divisor;
        while ( test > 1){
            if((divisor % test) == 0 && test % 2 != 0){
                sum = sum + test;
            }

            test--;
        }
        System.out.println(sum + 1);
    }
}
