package geeks.ds.binarytrees;

/**
 * Created by mukulbudania on 7/13/17.
 */
public class BinaryTree {

    private static final class PreorderIndex {
        public int index;
        public PreorderIndex(int index){
            this.index=index;
        }
    }

    private BTreeNode root;
    public BinaryTree(){

    }

    private static BTreeNode constructBinaryTree(int[] inorder, int[] preorder, PreorderIndex index, int inOrderStart, int inorderStart) {
        for(int i=inOrderStart;i<=inorderStart;i++){
            if(preorder[index.index]==inorder[i]){
                BTreeNode node = new BTreeNode(inorder[i]);
                index.index++;
                node.setLeft(constructBinaryTree(inorder,preorder,index,inOrderStart,i-1));
                node.setRight(constructBinaryTree(inorder,preorder,index,i+1,inorderStart));
                return node;
            }
        }
        return null;
    }

    private void printInorder(BTreeNode root) {
        if(root==null)return;
        printInorder(root.getLeft());
        System.out.println(root);
        printInorder(root.getRight());

    }

    private void printPreorder(BTreeNode root) {
        if(root==null)return;
        System.out.println(root);
        printPreorder(root.getLeft());
        printPreorder(root.getRight());
    }

    private void printPostorder(BTreeNode root) {
        if(root==null)return;
        printPostorder(root.getLeft());
        printPostorder(root.getRight());
        System.out.println(root);
    }

    public BTreeNode getRoot() {
        return root;
    }

    public void setRoot(BTreeNode root) {
        this.root = root;
    }

    public static BinaryTree constructBinaryTree(int[] inorder, int[] preorder){
        BinaryTree tree = new BinaryTree();
        PreorderIndex index = new PreorderIndex(0);
        tree.setRoot(constructBinaryTree(inorder,preorder,index,0,preorder.length-1));
        return tree;
    }

    public void printInorder(){
        System.out.println("#### Print Inorder ####");
        printInorder(root);
        System.out.println("\n#### End   Inorder ####");
    }

    public void printPreorder(){
        System.out.println("#### Print Preorder ####");
        printPreorder(root);
        System.out.println("\n#### End   Preorder ####");
    }

    public void printPostorder(){
        System.out.println("#### Print Postorder ####");
        printPostorder(root);
        System.out.println("\n#### End   Postorder ####");
    }


}
