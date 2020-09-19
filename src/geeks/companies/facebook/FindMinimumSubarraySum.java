package geeks.companies.facebook;

import java.util.Stack;

public class FindMinimumSubarraySum {
    public static void main(final String[] args) {
        final int val = new FindMinimumSubarraySum().sumSubarrayMins(new int[] { 10, 5, 3, 7, 0, 4, 5, 2, 1, 8 });
        System.out.println("Val: " + val);
    }

    public int sumSubarrayMins(final int[] A) {
        final int MOD = 1_000_000_007;

        final Stack<RepInteger> stack = new Stack();
        int ans = 0, dot = 0;
        for (int j = 0; j < A.length; ++j) {
            // Add all answers for subarrays [i, j], i <= j
            int count = 1;
            while (!stack.isEmpty() && stack.peek().val >= A[j]) {
                final RepInteger node = stack.pop();
                count += node.count;
                dot -= node.val * node.count;
            }
            stack.push(new RepInteger(A[j], count));
            dot += A[j] * count;
            ans += dot;
            ans %= MOD;
        }

        return ans;
    }
}
class RepInteger {
    int val, count;
    RepInteger(final int v, final int c) {
        val = v;
        count = c;
    }
}
