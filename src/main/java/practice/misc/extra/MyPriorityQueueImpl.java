package practice.misc.extra;

import java.util.HashSet;
import java.util.Set;

public class MyPriorityQueueImpl {

    public class PQueue {
        private Comparable[] values;
        int index;

        private Set<Integer> visited = new HashSet<>();

        public PQueue(int length){
            values = new Comparable[length];
            index = 0;
        }

        public void push(Comparable element){
            System.out.println("Adding : " + element);
            values[index] = element;
            index++;
        }

        private Comparable remove(){
            Comparable max = values[0];

            int maxIndex = 0;
            for(int i = 1; i < values.length; i++){
                if(values[i] != null && values[i].compareTo(max) > 0){
                    max = values[i];
                    maxIndex = i;
                    visited.add(i);
                }
            }

            System.out.println("Remove : " + max);
            values[maxIndex] = null;
            return max;
        }
    }

    public static void main(String[] args){
        MyPriorityQueueImpl m = new MyPriorityQueueImpl();
        PQueue pQueue = m.new PQueue(5);
        pQueue.push(34);
        pQueue.push(23);
        pQueue.push(5);
        pQueue.push(87);
        pQueue.push(32);

        pQueue.remove();
        pQueue.remove();
        pQueue.remove();
        pQueue.remove();
        pQueue.remove();



    }
}
