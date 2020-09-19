package geeks.companies.amazon;

import geeks.ds.binarytrees.BTreeNode;
import geeks.ds.binarytrees.BinaryTree;

/**
 * Created by mukulbudania on 7/21/17.
 */
public class BSTToDLL {
    private static BTreeNode prev;
    public static void main(String[] args){
        BinaryTree tree = BinaryTree.constructBinaryTree(new int[]{1,2,3,4,5,6},new int[]{4,2,1,3,5,6});
        tree.setRoot(convert(tree.getRoot()));
        BTreeNode node = tree.getRoot();
        while(node!=null){
            System.out.println(node);
            node = node.getRight();
        }
    }

    private static BTreeNode convert(BTreeNode root) {
        if(root==null) return null;
        prev = null;
        setPrevNodes(root);
        return setNextNodes(root);
    }

    private static BTreeNode setNextNodes(BTreeNode root) {
        BTreeNode prev = root;
        while(prev.getRight()!=null){
            prev=prev.getRight();
        }

        BTreeNode current = prev.getLeft();

        while(current != null){
            current.setRight(prev);
            prev=current;
            current=current.getLeft();
        }

        return prev;
    }

    private static void setPrevNodes(BTreeNode node) {
        if(node==null) return;
        setPrevNodes(node.getLeft());
        node.setLeft(prev);
        prev=node;
        setPrevNodes(node.getRight());
    }


}
