package others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Solution {

    static int processWord(final String word, final List<String> allWords) {
        if (word.length() == 1)
            return 1;

        final Stack<String> wordsStack = new Stack<String>();
        wordsStack.add(word);

        int indexToBeDeleted = 0;

        while (!wordsStack.isEmpty()) {
            final String currentWord = wordsStack.peek();

            if (indexToBeDeleted > currentWord.length()-1) {
                break;
            }

            if (allWords.contains(currentWord)) {
                final StringBuilder wordBuilder = new StringBuilder(currentWord);
                wordBuilder.deleteCharAt(indexToBeDeleted);
                wordsStack.add(wordBuilder.toString());
            } else {
                wordsStack.pop();
                indexToBeDeleted++;
            }
        }

        return wordsStack.size();
    }

    static int longestChain(final String[] words) {
        final List<String> wordList = Arrays.asList(words);
        int max = Integer.MIN_VALUE;
        for (final String word : words) {
            final int current = processWord(word, wordList);
            if (max < current) {
                max = current;
            }
            System.out.println(current);
        }

        return max;
    }

    public static void main(final String[] args){
        final Map<String, Integer> initialMap = new HashMap<>();
        final List<String> words = new ArrayList<>();
        //longestChain(Arrays.asList(words));
    }
}
