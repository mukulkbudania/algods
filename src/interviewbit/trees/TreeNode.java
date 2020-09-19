package interviewbit.trees;

/**
 * Created by mukulbudania on 8/29/17.
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }

    static TreeNode newTree(){
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        t1.left=t2;t1.right=t3;
        t2.left=t4;t2.right=t5;
        t3.right=t6;
        return t1;
    }
}
