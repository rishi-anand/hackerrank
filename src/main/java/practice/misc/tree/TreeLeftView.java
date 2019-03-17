package practice.misc.tree;

import model.BinaryTreeNode;
import model.PrintableNode;

import java.util.LinkedList;
import java.util.Queue;

public class TreeLeftView {

    private class TreeNode {
        private BinaryTreeNode bnt;
        private int level;

        public TreeNode(BinaryTreeNode node, int level){
            this.bnt = node;
            this.level = level;
        }

        public boolean hasLeft(){
            return bnt.getLeft() != null ? true : false;
        }

        public boolean hasRight(){
            return bnt.getRight() != null ? true : false;
        }
    }

    private void printLeftView(BinaryTreeNode root){
        if(root != null){
            int level = 0;
            int leftLevel = Integer.MAX_VALUE;
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(new TreeNode(root, level));
            while (!q.isEmpty()){
                TreeNode tn = q.poll();
                if(tn.hasLeft()){
                    System.out.println(tn.bnt.getData());
                    q.offer(new TreeNode(tn.bnt.getLeft(), tn.level + 1));
                } else {
                    leftLevel = tn.level + 1;
                }

                if(tn.hasRight()){
                    q.offer(new TreeNode(tn.bnt.getRight(), tn.level + 1));
                }

            }
        }
    }
}
