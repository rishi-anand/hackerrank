package practice.misc.tree;

import model.BinaryTreeNode;
import util.TreeInsertUtil;
import util.TreePrinterUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;

public class TreeVerticalOrderTraversal {

    public static TreeMap<Integer, ArrayList> ht = new TreeMap<>();
    public static ArrayList<Integer> al;

    public static void vertical(BinaryTreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (ht.containsKey(level)) {
            ArrayList x = ht.get(level);
            x.add(root.getData());
            ht.put(level, x);
        } else {
            al = new ArrayList<>();
            al.add(root.getData());
            ht.put(level, al);
        }
        vertical(root.getLeft(), level-1);
        vertical(root.getRight(), level+1);
    }

    private static BinaryTreeNode root;

    public static class BTNHorizontalDistance {
        private BinaryTreeNode tree;
        private int hd;

        public BTNHorizontalDistance(BinaryTreeNode tree, int hd){
            this.tree = tree;
            this.hd = hd;
        }

        public BinaryTreeNode getTree() {
            return tree;
        }

        public void setTree(BinaryTreeNode tree) {
            this.tree = tree;
        }

        public int getHd() {
            return hd;
        }

        public void setHd(int hd) {
            this.hd = hd;
        }
    }


    public static void main(String[] args){
        root = TreeInsertUtil.insertNode(15);
        TreePrinterUtil.print(root);
//        Stack<BTNHorizontalDistance> stack = printVerticalOrder();
//        System.out.println("hello: " + new Gson().toJson(stack));
        vertical(root, 0);
    }

    private static Stack<BTNHorizontalDistance> printVerticalOrder(){
        if(root == null){
            return null;
        }

        Map<Integer, List<BinaryTreeNode>> btnMap = new HashMap<>();
        Stack<BTNHorizontalDistance> stack = new Stack<>();
        Queue<BTNHorizontalDistance> q = new LinkedList<>();
        Map<Integer, List<BinaryTreeNode>> bntMap = new HashMap<>();
        q.offer(new BTNHorizontalDistance(root, 0));
        stack.push(new BTNHorizontalDistance(root, 0));
        while (!q.isEmpty()){
            BTNHorizontalDistance temp = q.poll();
            if(temp.getTree().getLeft() != null){
                q.offer(new BTNHorizontalDistance(temp.getTree().getLeft(), (temp.getHd() -1 )));
                stack.push(new BTNHorizontalDistance(temp.getTree().getLeft(), (temp.getHd() -1 )));
            }

            if(temp.getTree().getRight() != null){
                q.offer(new BTNHorizontalDistance(temp.getTree().getRight(), (temp.getHd() + 1) ));
                stack.push(new BTNHorizontalDistance(temp.getTree().getRight(), (temp.getHd() + 1)));
            }
        }

        while (!stack.isEmpty()){
            BTNHorizontalDistance temp = stack.pop();
            if(btnMap.containsKey(temp.getHd())){
                btnMap.get(temp.getHd()).add(temp.getTree());
            } else {
                List<BinaryTreeNode> nodes = new ArrayList<>();
                nodes.add(temp.getTree());
                btnMap.put(temp.getHd(), nodes);
            }
        }

        return null;
    }
}
