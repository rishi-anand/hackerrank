package practice.misc.tree;

import model.BinaryTreeNode;
import util.TreePrinterUtil;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeSpiralTraversal {

    public static class BTNSpiralTrav {
        private BinaryTreeNode tree;
        private int hd;

        public BTNSpiralTrav(BinaryTreeNode tree, int hd){
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
        BinaryTreeNode root = TreeInsertUtil.insertNode(7);
        TreePrinterUtil.print(root);
        int sum = maxPathSum(root);
        System.out.println(sum);
    }

    private static void printSpiral(Integer x){
        x =+ 10;
    }

    public static int maxPathSum(BinaryTreeNode root) {
        int max[] = new int[1];
        max[0] = Integer.MIN_VALUE;
        calculateSum(root, max);
        return max[0];
    }

    public static int calculateSum(BinaryTreeNode root, int[] max) {
        if (root == null)
            return 0;

        int left = calculateSum(root.getLeft(), max);
        int right = calculateSum(root.getRight(), max);

        int current = Math.max(root.getData(), Math.max(root.getData() + left, root.getData() + right));

        max[0] = Math.max(max[0], Math.max(current, left + root.getData() + right));

        return current;
    }
}
