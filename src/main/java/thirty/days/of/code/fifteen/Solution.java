package thirty.days.of.code.fifteen;

import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}

public class Solution {

    public static  Node insert(Node head,int data) {
        //Complete this method

        if(head == null){
            //create first node
            head = new Node(data);
        } else {

            //traverse to last node and then create a new node
            // and add it's pointer to last node
            Node start = head;
            while(start.next != null) {
                start = start.next;
            }

            start.next = new Node(data);
        }

        return head;

    }


    public static void display(Node head) {
        Node start = head;
        while(start != null) {
            System.out.print(start.data + " ");
            start = start.next;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Node head = null;
        int N = sc.nextInt();

        while(N-- > 0) {
            int ele = sc.nextInt();
            head = insert(head,ele);
        }
        display(head);
        sc.close();
    }
}
