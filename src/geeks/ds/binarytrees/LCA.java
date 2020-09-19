package geeks.ds.binarytrees;

/**
 * Created by mukulbudania on 7/17/17.
 */
public class LCA {
    private static class LCANode{
        private BTreeNode node;

        public BTreeNode getNode() {
            return node;
        }

        public void setNode(BTreeNode node) {
            this.node = node;
        }
    }
    public static void main(String[] args){
        BinaryTree tree = BinaryTree.constructBinaryTree(new int[]{4,2,5,1,6,3,7},new int[]{1,2,4,5,3,6,7});
        int node1 = 6; int node2=7;
        System.out.println(getLCA(tree,node1, node2));
    }

    public static BTreeNode getLCA(BinaryTree tree, int node1, int node2) {
        LCANode lcaNode = new LCANode();
        getLCA(tree.getRoot(),node1,node2,lcaNode);
        return lcaNode.getNode();
    }

    private static int getLCA(BTreeNode root, int node1, int node2, LCANode lcaNode) {
        if(root==null)return 0;

        int data = (root.getData()==node1 || root.getData()==node2)?1:0;
        int left = getLCA(root.getLeft(),node1,node2,lcaNode);
        if(left==1 && data==1) {
            lcaNode.setNode(root);
            return 2;
        }
        int right = getLCA(root.getRight(),node1,node2,lcaNode);
        if(right==1 && (data==1 || left==1)){
            lcaNode.setNode(root);
            return 2;
        }
        if(data==1 || left==1 || right==1) return 1;
        return 0;
    }
}
