package practice;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class LinkedList {
    public static class LinkedListNode{
        int val;
        LinkedListNode next;
        LinkedListNode(int node_value) {
            val = node_value;
            next = null;
        }
    };

    public static LinkedListNode listAdd(LinkedListNode head, LinkedListNode tail, int val){
        if(head == null) {
            head = new LinkedListNode(val);
            tail = head;
        } else {
            tail.next = new LinkedListNode(val);
            tail = tail.next;
        }
        return tail;
    }

    public static void printList(LinkedListNode head) {
        LinkedListNode iter = head;
        while(iter != null){
            System.out.print(iter.val + " ");
            iter = iter.next;
        }
    }

    /*
    For your reference:
    LinkedListNode {
        int val;
        LinkedListNode *next;
    };
    */
    static LinkedListNode removeAll(int n, LinkedListNode head){
        LinkedListNode node = head;
        LinkedListNode previous = null;
        LinkedListNode next = null;
        while(node.next != null){
            next = node.next;
            if(node.val == n){
                if(previous == null){
                    head = next;
                } else {
                    previous.next = next;
                }
            } else {
                previous = node;
            }

            node = next;
        }

        return head;

    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int size = in.nextInt();
        int i, item;
        LinkedListNode head = null, tail = null;
        for(i = 0; i < size; i++) {
            item = in.nextInt();
            tail = listAdd(head, tail, item);
            if (i == 0) {
                head = tail;
            }
        }
        head = removeAll(n, head);
        printList(head);
    }
}
