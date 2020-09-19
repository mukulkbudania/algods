package geeks.companies.facebook;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BinaryTreeWithFactors {
    public int numFactoredBinaryTrees(final int[] A) {
        final int MOD = 1_000_000_007;
        final int N = A.length;
        Arrays.sort(A);
        final long[] dp = new long[N];
        Arrays.fill(dp, 1);

        final Map<Integer, Integer> index = new HashMap();
        for (int i = 0; i < N; ++i)
            index.put(A[i], i);

        for (int i = 0; i < N; ++i)
            for (int j = 0; j < i; ++j) {
                if (A[i] % A[j] == 0) { // A[j] is left child
                    final int right = A[i] / A[j];
                    if (index.containsKey(right)) {
                        dp[i] = (dp[i] + dp[j] * dp[index.get(right)]) % MOD;
                    }
                }
            }

        long ans = 0;
        for (final long x : dp)
            ans += x;
        return (int) (ans % MOD);
    }
}
