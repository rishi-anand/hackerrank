package practice.misc.tree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeLeftView {

    public class BNT {
        private int data;
        private BNT left;
        private BNT right;

        public BNT(int data){
            this.data = data;
        }
    }

    private class TreeNode {
        private BNT bnt;
        private int level;

        public TreeNode(BNT node, int level){
            this.bnt = node;
            this.level = level;
        }
    }

    private void printLeftView(BNT root){
        if(root != null){
            int level = 0;
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(new TreeNode(root, level));
        }
    }
}
