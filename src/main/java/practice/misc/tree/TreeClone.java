package practice.misc.tree;

import model.BinaryTreeNode;
import util.TreePrinterUtil;

import java.util.LinkedList;
import java.util.Queue;

public class TreeClone {

    BinaryTreeNode root;

    private void insertNode2(BinaryTreeNode root, BinaryTreeNode node){
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

    private void verticalOrderTraversal(BinaryTreeNode root){
        if(root == null){
            return;
        }


    }


    public static void main(String[] args){
        TreeClone clone = new TreeClone();
        clone.root = TreeInsertUtil.insertNode(6);



        TreePrinterUtil.print(clone.root);

        BinaryTreeNode newClone = clone.root.clone3();
        System.out.println("Clone : ");
        TreePrinterUtil.print(newClone);

        BinaryTreeNode mirror = clone.root.mirror();
        System.out.println("Mirror : ");
        TreePrinterUtil.print(mirror);

    }
}
