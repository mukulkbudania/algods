package prep.interview.geeks.ds.binarytrees;

/**
 * Created by mukulbudania on 7/17/17.
 */
public class SetSuccessorNode {
    private static class SuccessorNode {
        private BTreeNode node;

        public BTreeNode getNode() {
            return node;
        }

        public void setNode(BTreeNode node) {
            this.node = node;
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = BinaryTree.constructBinaryTree(new int[]{4, 2, 5, 1, 6, 3, 7}, new int[]{1, 2, 4, 5, 3, 6, 7});
        setSuccessorNode(tree);
        tree.printInorder();
    }

    public static void setSuccessorNode(BinaryTree tree) {
        SuccessorNode successorNode = new SuccessorNode();
        setSuccessorNode(tree.getRoot(),successorNode);

    }

    private static void setSuccessorNode(BTreeNode root, SuccessorNode successorNode) {
        if(root==null) return;
        setSuccessorNode(root.getRight(),successorNode);
        root.setSuccessor(successorNode.getNode());
        successorNode.setNode(root);
        setSuccessorNode(root.getLeft(),successorNode);
    }
}
