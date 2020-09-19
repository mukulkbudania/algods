package interviewbit.dynamic;

/**
 * Created by mukulbudania on 8/5/17.
 */
public class MaxPathSum {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(final int val) {
            this.val = val;
        }
    }

    private static class Res {
        int val;
    }

    public int maxPathSum(final TreeNode a) {
        final Res res = new Res();
        res.val = Integer.MIN_VALUE;
        maxPath(a, res);
        return res.val;
    }

    public int maxPath(final TreeNode a,
                       final Res res) {
        if (a == null) {
            return 0;
        }
        final int l = maxPath(a.left, res);
        final int r = maxPath(a.right, res);
        final int max_s = Math.max(Math.max(l, r) + a.val, a.val);
        final int max_t = Math.max(l + r + a.val, max_s);
        res.val = Math.max(res.val, max_t);
        return max_s;
    }

    public static void main(final String[] args) {
        final TreeNode treeNode1 = new TreeNode(1);
        final TreeNode treeNode2 = new TreeNode(2);
        final TreeNode treeNode3 = new TreeNode(3);
        final TreeNode treeNode4 = new TreeNode(4);
        final TreeNode treeNode5 = new TreeNode(6);
        final TreeNode treeNode6 = new TreeNode(8);
        final TreeNode treeNode7 = new TreeNode(9);
        final TreeNode treeNode8 = new TreeNode(12);
        final TreeNode treeNode9 = new TreeNode(2);
        final TreeNode treeNode10 = new TreeNode(-1);
        final TreeNode treeNode11 = new TreeNode(-6);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode4;
        treeNode2.left = treeNode3;
        treeNode2.right = treeNode5;
        treeNode3.left = treeNode8;
        treeNode3.right = treeNode11;
        treeNode4.left = treeNode6;
        treeNode4.right = treeNode9;
        treeNode6.left = treeNode7;
        treeNode6.right = treeNode10;
        System.out.println(new MaxPathSum().maxPathSum(treeNode1));
    }
}
