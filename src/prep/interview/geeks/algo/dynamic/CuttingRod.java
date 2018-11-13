package prep.interview.geeks.algo.dynamic;

/**
 * Created by mukulbudania on 8/30/17.
 */
public class CuttingRod {
    public static void main(String[] args) {
        System.out.println(new CuttingRod().maxPrice(new int[] { 3, 5, 8, 9, 10, 17, 17, 20 }));
    }

    public int maxPrice(int[] prices) {
        int n = prices.length;
        int dp[] = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = 0;
            for (int j = 0; j < i; j++)
                dp[i] = Math.max(dp[i], dp[j] + prices[i - j - 1]);
        }
        return dp[n];
    }
}
