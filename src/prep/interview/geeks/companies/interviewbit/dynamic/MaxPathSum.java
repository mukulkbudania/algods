package prep.interview.geeks.companies.interviewbit.dynamic;

/**
 * Created by mukulbudania on 8/5/17.
 */
public class MaxPathSum {
    private static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
    }
    private static class Res{
        int val;
    }
    public int maxPathSum(TreeNode a) {
        Res res = new Res();
        res.val = Integer.MIN_VALUE;
        maxPath(a, res);
        return res.val;
    }
    public int maxPath(TreeNode a, Res res){
        if(a==null){
            return 0;
        }
        int l = maxPath(a.left,res);
        int r = maxPath(a.right,res);
        int max_s = Math.max(Math.max(l,r) + a.val,a.val);
        int max_t = Math.max(l+r+a.val, max_s);
        res.val = Math.max(res.val, max_t);
        return  max_s;
    }
}
