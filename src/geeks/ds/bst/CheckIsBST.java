package geeks.ds.bst;

import geeks.ds.binarytrees.BTreeNode;
import geeks.ds.binarytrees.BinaryTree;

/**
 * Created by mukulbudania on 7/17/17.
 */
public class CheckIsBST {
    public static void main(String[] args){
        BinaryTree tree = BinaryTree.constructBinaryTree(new int[]{4,2,5,1,6,3,7},new int[]{1,2,4,5,3,6,7});
        System.out.println(isBST(tree));
        BinaryTree bst = BinaryTree.constructBinaryTree(new int[]{1,2,3,4,5,6,7},new int[]{4,2,1,3,6,5,7});
        System.out.println(isBST(bst));
    }

    private static boolean isBST(BinaryTree tree) {
        return isBST(tree.getRoot(), Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isBST(BTreeNode root, int minValue, int maxValue) {
        if (root==null) return true;
        return (root.getData()<=maxValue &&
                root.getData()>=minValue &&
                isBST(root.getLeft(),minValue,root.getData()) &&
                isBST(root.getRight(), root.getData(), maxValue));
    }
}
