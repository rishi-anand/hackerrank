package util;

import model.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class TreeInsertUtil {

    private static void insertNode(BinaryTreeNode root, BinaryTreeNode node){
        if(root == null){
            return;
        }

        Queue<BinaryTreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()){
            BinaryTreeNode temp = q.poll();
            if(temp.getLeft() != null){
                q.offer(temp.getLeft());
            } else {
                temp.setLeft(node);
                return;
            }

            if(temp.getRight() != null){
                q.offer(temp.getRight());
            } else {
                temp.setRight(node);
                return;
            }
        }
    }

    public static BinaryTreeNode insertNode(int count){
        BinaryTreeNode root = new BinaryTreeNode(1);
        for (int i = 2; i <= count; i++){
            insertNode(root, new BinaryTreeNode(i));
        }

        return root;
    }
}
