package geeks.companies.facebook;

import java.util.List;

public class FindWordInMatrix {
    public static void main(final String[] args) {
        final char[][] input = { {}, {}, {}, {}, {}, {}, {} };
        final String searchString = "hello";
        //System.out.println(new FindWordInMatrix().isStringPresent(input, searchString));
    }

    private boolean isStringPresent(final char[][] input,
                                    final List<Pair> seen,
                                    final String searchString,
                                    final Pair currentPair) {
        if (searchString.isEmpty())
            return true;
        if ((currentPair.i < 0 || currentPair.j < 0 || currentPair.i >= input.length || currentPair.j >= input[0].length))
            return false;
        if (seen.contains(currentPair))
            return false;
        seen.add(currentPair);
        final boolean goingLeft = isStringPresent(input, seen, searchString, new Pair(currentPair.i - 1, currentPair.j));
        final boolean goingLeftUp = isStringPresent(input, seen, searchString, new Pair(currentPair.i - 1, currentPair.j - 1));
        final boolean goingLeftDown = isStringPresent(input, seen, searchString, new Pair(currentPair.i - 1, currentPair.j + 1));
        final boolean goingDown = isStringPresent(input, seen, searchString, new Pair(currentPair.i, currentPair.j + 1));
        final boolean goingUp = isStringPresent(input, seen, searchString, new Pair(currentPair.i, currentPair.j - 1));
        final boolean goingRight = isStringPresent(input, seen, searchString, new Pair(currentPair.i + 1, currentPair.j));
        final boolean goingRightUp = isStringPresent(input, seen, searchString, new Pair(currentPair.i + 1, currentPair.j - 1));
        final boolean goingRightDown = isStringPresent(input, seen, searchString, new Pair(currentPair.i + 1, currentPair.j + 1));
        seen.remove(currentPair);
        return goingLeft || goingDown || goingRight || goingUp | goingLeftUp || goingLeftDown || goingRightUp || goingRightDown;
    }

    private class Pair {
        int i;
        int j;

        public Pair(final int i,
                    final int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public boolean equals(final Object o) {
            if (!(o instanceof Pair))
                return false;
            final Pair p = (Pair) o;
            return (this.i == p.i && this.j == p.j);
        }

        @Override
        public int hashCode() {
            return i * 31 + j;
        }

    }
}
