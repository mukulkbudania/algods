package prep.interview.geeks.ds.binarytrees;

/**
 * Created by mukulbudania on 7/16/17.
 */
public class MakeDLLofLeafNodes {
    private static class LeafNode{
        private BTreeNode node;

        public BTreeNode getNode() {
            return node;
        }

        public void setNode(BTreeNode node) {
            this.node = node;
        }
    }
    public static void main(String[] args){
        BinaryTree tree = BinaryTree.constructBinaryTree(new int[]{4, 2, 5, 1, 8, 6, 3, 7, 9}, new int[]{1, 2, 4, 5, 3, 6, 8, 7, 9});
        LeafNode leafNode = new LeafNode();
        makeDLLofLeafNodes(tree.getRoot(),leafNode);
        BTreeNode node = leafNode.getNode();
        while(node!=null){
            System.out.println(node);
            node=node.getLeft();
        }
    }

    /**
     * Inorder Traversal
     * Save last leafnode. When u see another leafnode.
     * Set the new leafnode as its right. Set the old leafnode as the new leafnode's left.
     * Set the new leafnode as leaf node.
     * @param root root node
     * @param leafNode leafnode wrapper
     */
    private static void makeDLLofLeafNodes(BTreeNode root, LeafNode leafNode) {
        if(root==null) return;
        makeDLLofLeafNodes(root.getLeft(),leafNode);
        if(isLeaf(root)){
            BTreeNode node = leafNode.getNode();
            if(node!=null){
                node.setRight(root);
            }
            root.setLeft(node);
            leafNode.setNode(root);
            return;
        }
        makeDLLofLeafNodes(root.getRight(),leafNode);
    }

    private static boolean isLeaf(BTreeNode root) {
        return (root.getLeft()==null && root.getRight()==null);
    }
}
