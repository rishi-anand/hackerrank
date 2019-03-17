package practice.misc.tree;

import model.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class TreeConnectNodes {

    static ConnectedTree root;

    public class ConnectedTree {

        public int data;
        public ConnectedTree left, right, nextRight;
        public int height;

        ConnectedTree(int d){
            data = d;
        }

        ConnectedTree(int d, int h){
            data = d;
            height = h;

        }
    }

    private static void insertNode(ConnectedTree root, ConnectedTree node){
        if(root == null){
            return;
        }

        Queue<ConnectedTree> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()){
            ConnectedTree temp = q.poll();
            if(temp.left != null){
                q.offer(temp.left);
            } else {
                temp.left = node;
                return;
            }

            if(temp.right != null){
                q.offer(temp.right);
            } else {
                temp.right = (node);
                return;
            }
        }
    }

    public static void main(String[] args){
        TreeConnectNodes t = new TreeConnectNodes();
        int count = 7;
        root = t.new ConnectedTree(1);
        for (int i = 2; i <= count; i++){
            insertNode(root, t.new ConnectedTree(i));
        }


        connectRight();
        System.out.println();
    }

    private static void connectRight(){
        Queue<ConnectedTree> q = new LinkedList<>();
        root.height = 0;
        q.offer(root);
        while (!q.isEmpty()){
            ConnectedTree left = q.poll();
            if(left.left != null){
                left.left.height = left.height + 1;
                q.offer(left.left);
            }

            if(left.right != null){
                left.right.height = left.height + 1;
                q.offer(left.right);
            }


            if(!q.isEmpty()){
                ConnectedTree right = q.peek();
                if(left.height == right.height) {
                    left.nextRight = right;
                }
            }
        }
    }
}
