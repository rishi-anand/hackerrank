package util;

import model.LinkedList;

public class LinkedListInsertUtil {

    public static LinkedList insert(int n){
        LinkedList root = new LinkedList(1);
        LinkedList rootTemp = root;
        for (int i = 2; i <= n; i++){
            LinkedList temp = new LinkedList(i);
            rootTemp.setNext(temp);
            rootTemp = temp;
        }

        return root;
    }

    public static LinkedList circular(){
        LinkedList root = new LinkedList(2);
        LinkedList l1 = new LinkedList(3);
        LinkedList l2 = new LinkedList(4);
        LinkedList l3 = new LinkedList(5);
        LinkedList l4= new LinkedList(6);
        LinkedList l5 = new LinkedList(7);
        LinkedList l6 = new LinkedList(8);
        LinkedList l7 = new LinkedList(9);

        root.setNext(l1);
        l1.setNext(l2);
        l2.setNext(l3);
        l3.setNext(l4);
        l4.setNext(l5);
        l5.setNext(l6);
        l6.setNext(l7);
        l7.setNext(l4);
        return root;
    }
}
