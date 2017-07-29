package prep.interview.geeks.ds.bst;

import prep.interview.geeks.ds.binarytrees.BTreeNode;
import prep.interview.geeks.ds.binarytrees.BinaryTree;

/**
 * Created by mukulbudania on 7/29/17.
 */
public class ArrayToBST {
    public static void main(String[] args){
        int[] a = {1,2,3,4,5,6,7,8};
        BTreeNode root = createTree(a,0,a.length-1);
        BinaryTree tree = new BinaryTree();
        tree.setRoot(root);
        tree.printPreorder();
        tree.printInorder();
    }

    private static BTreeNode createTree(int[] a, int start, int end) {
        if(start>end) return null;
        int mid = (end+start)/2;
        BTreeNode root = new BTreeNode(a[mid]);
        root.setLeft(createTree(a,start,mid-1));
        root.setRight(createTree(a, mid + 1, end));
        return root;
    }
}
