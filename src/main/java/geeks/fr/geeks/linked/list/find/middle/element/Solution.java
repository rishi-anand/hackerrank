package geeks.fr.geeks.linked.list.find.middle.element;

import util.EmptyUtil;

public class Solution {

    private Node head;

    public class Node {
        private int data;
        private Node next;

        public Node(int data){
            this.data = data;
        }

        public int getData(){
            return data;
        }

        public Node getNext(){
            return next;
        }

        public void setNext(Node next){
            this.next = next;
        }
    }

    private int length(Node head){
        int length = 0;
        if(EmptyUtil.isNotNull(head)) {
            Node currentNode = head;
            while (currentNode.getNext() != null) {
                length++;
                currentNode = currentNode.getNext();
            }
        }

        return length;
    }

    private int insertInbetween(Node head){
        Node first = head;
        int j = 1;
        Node second = head;
        while (second.getNext() != null){
            first = first.getNext();
            j++;
            for(int i = 0; second.getNext() != null && i < 2; i++){
                second = second.getNext();
            }
        }

        return j;
    }

    private Node reverseLL(Node head, int index){
        Node current = head;

        for(int i = 0; i < index; i++){

        }

        return head;

    }



    public static void main(String[] args){

        Solution sol = new Solution();
        fromInput(sol);

        System.out.println(sol.insertInbetween(sol.head));

    }

    public void customInput(Solution sol){
        Node head = sol.new Node(1);
        sol.head = head;

        Node node1 = sol.new Node(2);
        head.setNext(node1);

        Node node2 = sol.new Node(3);
        node1.setNext(node2);

        Node node3 = sol.new Node(4);
        node2.setNext(node3);

//        Node node4 = sol.new Node(5);
//        node3.setNext(node4);

//        Node node5 = sol.new Node(6);
//        node4.setNext(node5);

        System.out.println(sol.insertInbetween(head));

    }

    private static void fromInput(Solution sol){
        String abc = "1 2 2 4 5 6 7 8";

        Node prev = null;
        String[] abcArr = abc.split(" ");
        for(int i = 0; i < abcArr.length; i++){
            Node node = sol.new Node(Integer.valueOf(abcArr[i]));
            if(i == 0){
                sol.head = node;
            }

            if(prev != null){
                prev.setNext(node);
                prev = node;
            } else {
                prev = node;
            }
        }
    }


}
