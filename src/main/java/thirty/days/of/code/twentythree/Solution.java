package thirty.days.of.code.twentythree;

import java.util.*;
import java.io.*;

class Node{
    Node left,right;
    int data;
    Node(int data){
        this.data = data;
        left = right = null;
    }
}

public class Solution {


    public static void levelOrder(Node root){
        //Below method is using Recursion
        levelOrderRecursion(root, new LinkedList<Node>());


        //Below method is using loop
        //levelOrderLoop(root);
    }

    //Solution 1: using recursion
    public static void levelOrderRecursion(Node root, Queue<Node> nodeQueue){
        //Write your code here

        System.out.print(root.data + " ");

        if(root.left != null){
            nodeQueue.add(root.left);
        }

        if(root.right != null){
            nodeQueue.add(root.right);
        }

        if(nodeQueue.size() > 0) {
            levelOrderRecursion(nodeQueue.poll(), nodeQueue);
        }
    }



    public static void levelOrderLoop(Node root) {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {

            Node tempNode = queue.poll();
            System.out.print(tempNode.data + " ");

            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }

            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
    }

    public static Node insert(Node root,int data){
        if(root==null){
            return new Node(data);
        }
        else{
            Node cur;
            if(data<=root.data){
                cur=insert(root.left,data);
                root.left=cur;
            }
            else{
                cur=insert(root.right,data);
                root.right=cur;
            }
            return root;
        }
    }

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        Node root=null;
        while(T-->0){
            int data=sc.nextInt();
            root=insert(root,data);
        }
        levelOrder(root);
    }
}
