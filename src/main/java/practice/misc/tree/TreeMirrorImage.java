package practice.misc.tree;

public class TreeMirrorImage {

    private class BNT {
        private int data;
        private BNT left;
        private BNT right;

        public BNT(int d) {
            data = d;
        }

        public BNT mirrorImage(){
            BNT root = new BNT(this.data);
            root.left = this.right.mirrorImage();
            root.right = this.left.mirrorImage();
            return root;
        }
    }
}
