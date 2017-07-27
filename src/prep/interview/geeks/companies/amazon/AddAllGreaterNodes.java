package prep.interview.geeks.companies.amazon;

import prep.interview.geeks.ds.binarytrees.BTreeNode;
import prep.interview.geeks.ds.binarytrees.BinaryTree;

/**
 * Created by mukulbudania on 7/21/17.
 */
public class AddAllGreaterNodes {
    private static int sum;
    public static void main(String[] args){
        BinaryTree tree = BinaryTree.constructBinaryTree(new int[]{1,2,3,4,5,6},new int[]{4,2,1,3,5,6});
        addNodes(tree);
        tree.printInorder();
    }

    private static void addNodes(BinaryTree tree) {
        sum = 0;
        addNodes(tree.getRoot());
    }

    private static void addNodes(BTreeNode root) {
        if(root==null) return;
        addNodes(root.getRight());
        sum+=root.getData();
        root.setData(sum);
        addNodes(root.getLeft());
    }
}
