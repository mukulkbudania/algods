package prep.interview.geeks.companies.amazon;

import prep.interview.geeks.ds.binarytrees.BTreeNode;
import prep.interview.geeks.ds.binarytrees.BinaryTree;

public class BSTToDLLCircularLinkedList {
    public static void main(final String[] args) {
        final BinaryTree tree = BinaryTree.constructBinaryTree(new int[] { 1, 2, 3, 4, 5, 6 }, new int[] { 4, 2, 1, 3, 5, 6 });
        tree.setRoot(convert(tree.getRoot()));
        BTreeNode node = tree.getRoot();
        while (node != null) {
            System.out.println(node);
            node = node.getRight();
        }
    }

    private static BTreeNode convert(final BTreeNode root) {
        if (root == null)
            return null;
        final BTreeNode left = root.getLeft();
        final BTreeNode right = root.getRight();
        root.setLeft(root);
        root.setRight(root);
        final BTreeNode leftDLL = convert(left);
        final BTreeNode rightDLL = convert(right);
        final BTreeNode leftLast = leftDLL.getLeft();
        leftLast.setRight(root);
        root.setLeft(root);
        return null;
    }
}
