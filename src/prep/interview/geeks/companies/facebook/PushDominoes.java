package prep.interview.geeks.companies.facebook;

public class PushDominoes {
    public String pushDominoes(final String S) {
        final char[] A = S.toCharArray();
        final int N = A.length;
        final int[] forces = new int[N];

        // Populate forces going from left to right
        int force = 0;
        for (int i = 0; i < N; ++i) {
            if (A[i] == 'R')
                force = N;
            else if (A[i] == 'L')
                force = 0;
            else
                force = Math.max(force - 1, 0);
            forces[i] += force;
        }

        // Populate forces going from right to left
        force = 0;
        for (int i = N - 1; i >= 0; --i) {
            if (A[i] == 'L')
                force = N;
            else if (A[i] == 'R')
                force = 0;
            else
                force = Math.max(force - 1, 0);
            forces[i] -= force;
        }

        final StringBuilder ans = new StringBuilder();
        for (final int f : forces)
            ans.append(f > 0 ? 'R' : f < 0 ? 'L' : '.');
        return ans.toString();
    }
}