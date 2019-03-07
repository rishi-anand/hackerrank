package practice.misc.tree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeClone {

    private class BNT {
        private int data;
        private BNT left;
        private BNT right;

        public BNT(int d) {
            data = d;
        }

        public BNT clone() {
            BNT root = new BNT(this.data);
            Queue<BNT> queue = new LinkedList<>();
            queue.offer(this);
            while (!queue.isEmpty()) {
                BNT b = queue.poll();
                if (b.left != null) {
                    root.left = new BNT(b.left.data);
                    queue.offer(b.left);
                }

                if (b.right != null) {
                    root.right = new BNT(b.right.data);
                    queue.offer(right);
                }
            }

            return root;
        }

        public BNT clone2() {

            return performClone(this, new BNT(this.data));
        }

        public BNT performClone(BNT root, BNT temp) {
            if (root == null) {
                return temp;
            }

            if (root.left != null) {
                temp.left = new BNT(root.left.data);
                root = root.left;
                performClone(root, temp);
            }

            if (root.right != null) {
                temp.right = new BNT(root.right.data);
                root = root.right;
                performClone(root, temp);
            }

            return temp;
        }

        public BNT clone3() {
            BNT bnt = new BNT(this.data);
            bnt.left = this.left.clone();
            bnt.right = this.right.clone();
            return bnt;

        }

    }
}
