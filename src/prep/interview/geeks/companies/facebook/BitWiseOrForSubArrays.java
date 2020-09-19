package prep.interview.geeks.companies.facebook;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/bitwise-ors-of-subarrays/
 */
public class BitWiseOrForSubArrays {
    public int subarrayBitwiseORs(final int[] A) {
        final Set<Integer> ans = new HashSet();
        Set<Integer> cur = new HashSet();
        cur.add(0);
        for (final int x : A) {
            final Set<Integer> cur2 = new HashSet();
            for (final int y : cur)
                cur2.add(x | y);
            cur2.add(x);
            cur = cur2;
            ans.addAll(cur);
        }

        return ans.size();
    }
}