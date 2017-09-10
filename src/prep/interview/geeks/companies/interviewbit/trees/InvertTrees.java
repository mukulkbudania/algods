package prep.interview.geeks.companies.interviewbit.trees;

/**
 * Created by mukulbudania on 8/28/17.
 */
public class InvertTrees {
    public TreeNode invertTree(TreeNode root) {
        if (root==null) return null;
        TreeNode left = invertTree(root.right);
        root.right = invertTree(root.left);
        root.left = left;
        return root;
    }
}
