package practice.misc.linked.list;

import model.LinkedList;
import util.LinkedListInsertUtil;

public class CopyDoublyArbitaryList {

    public static void main(String[] args){
        LinkedList root = LinkedListInsertUtil.circular();
        LinkedList root2 = LinkedListInsertUtil.insert(10);

        //System.out.println(lengthOfLoop(root));
        System.out.println(root2.toString());
        LinkedList nth = NthNode(root2, 2);
        System.out.println(nth.getData());
    }

    private static boolean isLoopExists(LinkedList root){
        class QueueObj {
            LinkedList node;
            int hd;

            QueueObj(LinkedList node, int hd) {
                this.node = node;
                this.hd = hd;
            }
        }

        LinkedList temp = root;
        LinkedList second = root;
        while (temp != null && temp.getNext() != null){
            temp = temp.getNext();
            second = second.getNext();
            if(second.getNext() != null){
                second = second.getNext();
            }

            if(temp.getData() == second.getData()){
                return true;
            }
        }

        return false;
    }

    private static int lengthOfLoop(LinkedList root){
        LinkedList temp = root;
        LinkedList second = root;
        Integer first = null;
        LinkedList start = null;
        while (temp != null && temp.getNext() != null){
            temp = temp.getNext();
            second = second.getNext();
            if(second.getNext() != null){
                second = second.getNext();
            }

            if(temp.getData() == second.getData()){
                first = temp.getData();
                start = temp;
                break;
            }
        }

        int count = 0;

        System.out.println("First : " + first);
        if(first != null && start != null){
            while(start != null){
                start = start.getNext();
                System.out.println("Start : " + start.getData());
                System.out.println(start.getData());
                if(start.getData() == first){
                    break;
                }

                ++count;
            }
        }
        return count;
    }

    private static LinkedList NthNode(LinkedList root, int n){
        LinkedList temp = root;
        LinkedList nth = root;

        for(int i = 0; i < n; i++){
            if(nth != null){
                nth = nth.getNext();
            } else {
                return null;
            }
        }

        while (nth != null){
            temp = temp.getNext();
            nth = nth.getNext();
        }

        return temp;
    }
}
