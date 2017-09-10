package prep.interview.geeks.algo.dynamic;

/**
 * Created by mukulbudania on 8/30/17.
 */
public class MaxProfitWithKTransactions {
    public int maxProfit(int[] prices, int k){
        int n = prices.length;
        int dp[][] = new int[k+1][n+1];
        for(int i=0;i<=k;i++) dp[i][0]=0;
        for(int i=0;i<=n;i++) dp[0][i]=0;
        for(int i=1;i<=k;i++){
            int prevDiff = Integer.MIN_VALUE;
            for (int j=1;j<n;j++){
                prevDiff = Math.max(prevDiff,dp[i-1][j-1]-prices[j-1]);
                dp[i][j] = Math.max(dp[i][j-1],prevDiff + prices[j]);
            }
        }
        return dp[k][n-1];
    }
}
