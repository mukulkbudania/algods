package prep.interview.geeks.ds.binarytrees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by mukulbudania on 7/15/17.
 */
public class NextSibling {

    public static void main(String[] args) {
        BinaryTree tree = BinaryTree.constructBinaryTree(new int[]{4, 2, 5, 1, 8, 6, 3, 7, 9}, new int[]{1, 2, 4, 5, 3, 6, 8, 7, 9});
        makeRightSiblings(tree);
        tree.printPreorder();
    }

    private static void makeRightSiblings(BinaryTree tree) {
        BTreeNode root = tree.getRoot();
        Queue<BTreeNode> q = new LinkedList<BTreeNode>();
        q.add(root);
        while(!q.isEmpty()){
            BTreeNode n = q.poll();
            while(n!=null){
                if(n.getLeft() != null){
                    if(n.getRight()!=null){
                        n.getLeft().setNextSibling(n.getRight());
                    } else {
                        n.getLeft().setNextSibling(getNextSibling(n));
                    }
                    if(q.isEmpty())q.add(n.getLeft());
                }
                if(n.getRight()!=null ){
                    n.getRight().setNextSibling(getNextSibling(n));
                    if(q.isEmpty())q.add(n.getRight());
                }
                n=n.getNextSibling();
            }

        }
    }

    private static BTreeNode getNextSibling(BTreeNode n) {
        BTreeNode a = n.getNextSibling();
        while(a !=null){
            if(a.getLeft()!=null) return a.getLeft();
            if(a.getRight()!=null) return a.getRight();
            a=a.getNextSibling();
        }
        return null;
    }
}
