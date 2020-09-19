package geeks.companies.facebook;

import java.util.HashSet;
import java.util.Set;

public class MinBreaksForDictionaryWords {
    int breaks[];

    public static void main(final String[] args) {
        final Set<String> dictionary = new HashSet<>();
        dictionary.add("Cat");
        dictionary.add("Mat");
        dictionary.add("Ca");
        dictionary.add("tM");
        dictionary.add("at");
        dictionary.add("C");
        dictionary.add("Dog");
        dictionary.add("og");
        dictionary.add("Do");
        final int result = new MinBreaksForDictionaryWords().minimumBreaks(dictionary, "CatMat");
        System.out.println(result);
    }

    public int minimumBreaks(final Set<String> dic,
                             final String word) {
        breaks = new int[word.length() + 1];
        for (int i = 0; i < breaks.length; i++)
            breaks[i] = -1;

        final int result = findBreaks(dic, word, 0);
        return result;
    }

    private int findBreaks(final Set<String> dic,
                           final String word,
                           final int from) {

        if (dic.contains(word.substring(from))) {
            breaks[from] = 0;
        } else {
            final StringBuilder prefix = new StringBuilder(word.length());

            int min = Integer.MAX_VALUE;
            for (int i = from; i < word.length() - 1; i++) {
                prefix.append(word.charAt(i));
                if (dic.contains(prefix.toString())) {
                    if (breaks[i + 1] == -1)
                        breaks[i + 1] = findBreaks(dic, word, i + 1);
                    min = Math.min(min, breaks[i + 1] + 1);
                }
            }
            breaks[from] = min;
        }
        return breaks[from];
    }
}
