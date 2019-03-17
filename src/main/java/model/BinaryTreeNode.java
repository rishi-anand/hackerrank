package model;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeNode implements PrintableNode {

    private int data;
    private BinaryTreeNode left;
    private BinaryTreeNode right;

    public BinaryTreeNode(int data){
        this.data = data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setLeft(BinaryTreeNode left) {
        this.left = left;
    }

    public void setRight(BinaryTreeNode right) {
        this.right = right;
    }

    public String getText(){
        return String.valueOf(data);
    }

    public int getData(){
        return data;
    }

    public BinaryTreeNode getLeft(){
        return left;
    }

    public BinaryTreeNode getRight(){
        return right;
    }

    public BinaryTreeNode clone() {
        BinaryTreeNode root = new BinaryTreeNode(this.data);
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(this);
        while (!queue.isEmpty()) {
            BinaryTreeNode b = queue.poll();
            if (b.left != null) {
                root.left = new BinaryTreeNode(b.left.data);
                queue.offer(b.left);
            }

            if (b.right != null) {
                root.right = new BinaryTreeNode(b.right.data);
                queue.offer(right);
            }
        }

        return root;
    }

    public BinaryTreeNode clone2() {
        return performClone(this, new BinaryTreeNode(this.data));
    }

    public BinaryTreeNode performClone(BinaryTreeNode root, BinaryTreeNode temp) {
        if (root == null) {
            return temp;
        }

        if (root.left != null) {
            temp.left = new BinaryTreeNode(root.left.data);
            root = root.left;
            performClone(root, temp);
        }

        if (root.right != null) {
            temp.right = new BinaryTreeNode(root.right.data);
            root = root.right;
            performClone(root, temp);
        }

        return temp;
    }

    public BinaryTreeNode clone3() {
        BinaryTreeNode bnt = new BinaryTreeNode(this.data);
        if(this.left != null){
            bnt.left = this.left.clone();
        }

        if(this.right != null){
            bnt.right = this.right.clone();
        }

        return bnt;
    }

    public BinaryTreeNode mirror() {
        BinaryTreeNode bnt = new BinaryTreeNode(this.data);

        if(this.right != null){
            bnt.left = this.right.mirror();
        }

        if(this.left != null){
            bnt.right = this.left.mirror();
        }

        return bnt;

    }
}
