package prep.interview.geeks.algo.dynamic;

/**
 * Created by mukulbudania on 7/28/17.
 */
public class MaxNonContigousSum {
    public static void main(String[] args){
        int a[] = {1,2,3,4,5,6,7,8};
        System.out.println(maxSum(a));
    }

    private static int maxSum(int[] a) {
        if(a.length==0) return 0;
        if(a.length==1) return a[0];
        int dp[] = new int[a.length];
        dp[0] = a[0];
        dp[1] = max(a[0],a[1]);
        for(int i=2;i<a.length;i++){
            dp[i]+=max(dp[i-1],a[i]+dp[i-2]);
        }
        return dp[a.length-1];
    }

    private static int max(int i, int j) {
        return i>j?i:j;
    }
}
