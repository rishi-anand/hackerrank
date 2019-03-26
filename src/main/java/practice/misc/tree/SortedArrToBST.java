package practice.misc.tree;

import model.BinaryTreeNode;

public class SortedArrToBST {

    private static int[] sortedArr = {1, 2, 3, 4};

    private static BinaryTreeNode convertToTree(int[] sortedArr, int start, int end){
        if(sortedArr.length == 0){
            return null;
        } else if(start > end){
            return null;
        }

        int mid = (start + end) / 2;
        BinaryTreeNode newNode = new BinaryTreeNode(sortedArr[mid]);
        newNode.setLeft(convertToTree(sortedArr, start, mid - 1));
        newNode.setRight(convertToTree(sortedArr, mid + 1, end));
        return newNode;
    }
}
