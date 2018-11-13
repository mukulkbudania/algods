package prep.interview.geeks.algo.dynamic;

/**
 * Created by mukulbudania on 8/30/17.
 * Take coins loop outside.
 */
public class CoinChange {
    int getChange(int n,
                  int[] coins) {
        int dp[] = new int[n + 1];
        dp[0] = 1;
        for (int j = 0; j < coins.length; j++)
            for (int i = coins[j]; i <= n; i++)
                dp[i] += dp[i - coins[j]];
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new CoinChange().getChange(10, new int[] { 2, 3, 5, 6 }));
    }
}
