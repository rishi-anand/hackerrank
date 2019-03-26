package practice.misc.tree;

import model.BinaryTreeNode;
import model.DoublyLinkedList;
import util.TreeInsertUtil;
import util.TreePrinterUtil;

import java.util.LinkedList;
import java.util.Queue;

public class TreeToDoublyLinkedList {
    private static BinaryTreeNode root;

    public static void main(String[] args){
        root = TreeInsertUtil.insertNode(15);
        TreePrinterUtil.print(root);

        DoublyLinkedList dll = convert(root);
        System.out.println(dll.toString());
    }

    private static DoublyLinkedList convert(BinaryTreeNode root){
        if(root == null){
            return null;
        }

        DoublyLinkedList dlRoot = null;
        Queue<BinaryTreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()){
            BinaryTreeNode temp = q.poll();
            dlRoot = new DoublyLinkedList(temp.getData());

            if(temp.getLeft() != null){
                dlRoot.setPrev(new DoublyLinkedList(temp.getLeft().getData()));
            }

            if(temp.getRight() != null){
                dlRoot.setNext(new DoublyLinkedList(temp.getRight().getData()));
            }




        }

        return dlRoot;
    }
}
