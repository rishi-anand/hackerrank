package practice.misc.tree;

import com.google.gson.Gson;
import model.BinaryTreeNode;
import util.TreeInsertUtil;
import util.TreePrinterUtil;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

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


//    public static void main(String[] args){
//        TreeClone clone = new TreeClone();
//        clone.root = TreeInsertUtil.insertNode(6);
//
//
//
//        TreePrinterUtil.print(clone.root);
//
//        BinaryTreeNode newClone = clone.root.clone3();
//        System.out.println("Clone : ");
//        TreePrinterUtil.print(newClone);
//
//        BinaryTreeNode mirror = clone.root.mirror();
//        System.out.println("Mirror : ");
//        TreePrinterUtil.print(mirror);
//
//    }

    public static void main(String[] args){
        Set<String> first = new HashSet<>();
        first.add("T1");
        first.add("T3");

        Set<String> second = new HashSet<>();
        first.add("T2");
        first.add("T3");


        first.removeAll(second);

        System.out.println(new Gson().toJson(first));



    }
}
