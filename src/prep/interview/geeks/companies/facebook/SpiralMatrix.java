package prep.interview.geeks.companies.facebook;

/**
 * https://leetcode.com/problems/spiral-matrix-iii/
 */
public class SpiralMatrix {
    public int[][] spiralMatrixIII(final int R,
                                   final int C,
                                   int r0,
                                   int c0) {
        final int[] dr = new int[] { 0, 1, 0, -1 };
        final int[] dc = new int[] { 1, 0, -1, 0 };

        final int[][] ans = new int[R * C][2];
        int t = 0;

        ans[t++] = new int[] { r0, c0 };
        if (R * C == 1)
            return ans;

        for (int k = 1; k < 2 * (R + C); k += 2) //Total number of times direction changes.
            for (int i = 0; i < 4; ++i) {  // i: direction index
                final int dk = k + (i / 2);  // number of steps in this direction
                for (int j = 0; j < dk; ++j) {  // for each step in this direction...
                    // step in the i-th direction
                    r0 += dr[i];
                    c0 += dc[i];
                    if (0 <= r0 && r0 < R && 0 <= c0 && c0 < C) {
                        ans[t++] = new int[] { r0, c0 };
                        if (t == R * C)
                            return ans;
                    }
                }
            }

        throw null;
    }
}
