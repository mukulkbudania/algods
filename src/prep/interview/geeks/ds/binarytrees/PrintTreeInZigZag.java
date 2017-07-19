package prep.interview.geeks.ds.binarytrees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by mukulbudania on 7/17/17.
 */
public class PrintTreeInZigZag {
    private static final BTreeNode NULL = new BTreeNode(Integer.MIN_VALUE);

    public static void main(String[] args){
        BinaryTree tree = BinaryTree.constructBinaryTree(new int[]{4, 2, 5, 1, 8, 6, 3, 7, 9}, new int[]{1, 2, 4, 5, 3, 6, 8, 7, 9});
        printZigZag(tree);
    }

    private static void printZigZag(BinaryTree tree) {
        if(tree.getRoot()==null) return;
        Queue<BTreeNode> queue = new LinkedList<BTreeNode>();
        Stack<BTreeNode> stack = new Stack<BTreeNode>();
        queue.add(tree.getRoot());
        queue.add(NULL);
        boolean front=true;
        while(!queue.isEmpty()){
            BTreeNode node = queue.poll();
            if(node.equals(NULL)){
                if(!queue.isEmpty())queue.add(NULL);
                if(!front) while(!stack.isEmpty()) System.out.println(stack.pop());
                front=!front;continue;
            }
            if(front) System.out.println(node);
            else stack.push(node);
            if(node.getLeft()!=null)queue.add(node.getLeft());
            if(node.getRight()!=null)queue.add(node.getRight());
        }
    }
}
