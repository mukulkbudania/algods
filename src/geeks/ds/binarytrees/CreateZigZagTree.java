package geeks.ds.binarytrees;

import java.util.Stack;

/**
 * Created by mukulbudania on 7/17/17.
 */
public class CreateZigZagTree {
    public static void main(String[] args){
        int a[] = new int[]{1,2,3,4,5,6};
        BinaryTree tree = createZigZagTree(a);
        tree.printInorder();

    }

    private static BinaryTree createZigZagTree(int[] a) {
        if(a.length==0)return null;
        int i=0;
        BinaryTree tree = new BinaryTree();
        BTreeNode root = new BTreeNode(a[0]);
        tree.setRoot(root);
        Stack<BTreeNode> oldStack = new Stack<BTreeNode>();
        Stack<BTreeNode> newStack = new Stack<BTreeNode>();
        oldStack.push(root);
        boolean front=true;
        while(i<a.length){
            front=!front;
            while(!oldStack.isEmpty()){
                BTreeNode node = oldStack.pop();

                i++;if(i>=a.length)break;
                BTreeNode node1 = new BTreeNode(a[i]);
                if(front)node.setLeft(node1);
                else node.setRight(node1);
                newStack.push(node1);

                i++;if(i>=a.length)break;
                BTreeNode node2 = new BTreeNode(a[i]);
                if(front)node.setRight(node2);
                else node.setLeft(node2);
                newStack.push(node2);
            }
            if(i>=a.length)break;
            oldStack=newStack;
            newStack = new Stack<BTreeNode>();
        }
        return tree;
    }
}
