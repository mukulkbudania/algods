package prep.interview.geeks.companies.interviewbit.trees;

/**
 * Created by mukulbudania on 8/28/17.
 */
public class ReturnKthSmallestInBST {
    static int i = 0;
    public int kthsmallest(TreeNode root, int k) {
        if(root==null || root.val==-1) return -1;
        int left = kthsmallest(root.left,k);
        if(left!=-1) return left;
        i++; if(i==k) return root.val;
        int right = kthsmallest(root.right,k);
        if(right!=-1) return right;
        return -1;
    }
    public static void main(String[] args){
        TreeNode t2 = new TreeNode(2);
        TreeNode t1 = new TreeNode(1);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(-1);
        TreeNode t5 = new TreeNode(-1);
        TreeNode t6 = new TreeNode(-1);
        TreeNode t7 = new TreeNode(-1);

        t2.left = t1;
        t2.right = t3;
        t1.left=t4;
        t1.left=t5;
        t3.left=t6;
        t3.left=t7;

        System.out.println(new ReturnKthSmallestInBST().kthsmallest(t2,3));
    }
}
