package geeks.algo.dynamic.lis;

/**
 * Created by mukulbudania on 7/12/17.
 */
public class MaximumSumIncreasingSubsequence {
    public static void main(String[] args){
        int a[] = {1, 101, 2, 3, 100, 4, 5};
        System.out.println(maxSum(a));
    }

    private static int maxSum(int[] a) {
        int n = a.length;
        int[] dp = new int[n];
        dp[0]=a[0];
        int totalMax = 0;
        for(int i=1;i<n;i++){
            int max = 0;
            for(int j=0;j<i;j++){
                if(a[j]<a[i]) max=Math.max(max,dp[j]);
            }
            dp[i]=max+a[i];
            totalMax=Math.max(totalMax,dp[i]);
        }
        return totalMax;
    }
}
