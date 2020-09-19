package geeks.companies.facebook;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class RevealCards {
    public int[] deckRevealedIncreasing(final int[] deck) {
        final int N = deck.length;
        final Deque<Integer> index = new LinkedList();
        for (int i = 0; i < N; ++i)
            index.add(i);

        final int[] ans = new int[N];
        Arrays.sort(deck);
        for (final int card : deck) {
            ans[index.pollFirst()] = card;
            if (!index.isEmpty())
                index.add(index.pollFirst());
        }

        return ans;
    }
}

