package practice.misc.linked.list;

import model.LinkedList;

public class MergeTwoSortedLinkedList {

    public static void main(String[] args){

    }

    private LinkedList merge(LinkedList l1, LinkedList l2){
        if(l1 == null){
            return l2;
        } else if(l2 == null){
            return l2;
        }

        LinkedList root = null;
        LinkedList result = null;
        boolean iterate = true;
        while (iterate){
            if(l1 != null && l2 != null){
                if(l1.getData() > l2.getData()){
                    if(root == null){
                        root = new LinkedList(l2.getData());
                        result = root;
                    } else {
                        LinkedList temp = new LinkedList(l2.getData());
                        root.setNext(temp);
                        root = temp;
                    }
                } else {
                    if(root == null){
                        root = new LinkedList(l1.getData());
                        result = root;
                    } else {
                        LinkedList temp = new LinkedList(l1.getData());
                        root.setNext(temp);
                        root = temp;
                    }
                }

                l1 = l1.getNext();
                l2 = l2.getNext();
            } else {
                if(l1 != null){
                    while (l1 != null){
                        LinkedList temp = new LinkedList(l1.getData());
                        root.setNext(temp);
                        root = temp;
                        l1 = l1.getNext();
                    }
                }
            }
        }
        return result;
    }
}
