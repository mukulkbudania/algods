package geeks.companies.facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SortedCombinations {

    public static final String SEPERATOR = ",";

    public static void main(final String[] args) {
        final ArrayList<ArrayList<Integer>> result = new SortedCombinations().combine(4, 2);
        printResult(result);
    }

    private static void printResult(final ArrayList<ArrayList<Integer>> result) {
        result.stream()
              .forEach(x -> {
                  x.stream()
                   .forEach(y -> System.out.print(y + "  "));
                  System.out.println();
              });
    }

    public ArrayList<ArrayList<Integer>> combine(final int n,
                                                 final int k) {
        final List<String> strings = new ArrayList();
        getCombinations(n, n, k, "", strings);
        final ArrayList<ArrayList<Integer>> integers = convertToIntegers(strings);
        Collections.reverse(integers);
        return integers;
    }

    private ArrayList<ArrayList<Integer>> convertToIntegers(final List<String> strings) {
        return strings.stream()
                      .map(s -> Arrays.asList(s.split(SEPERATOR))
                                       .stream()
                                       .map(Integer::parseInt)
                                       .collect(Collectors.toCollection(ArrayList::new)))
                      .collect(Collectors.toCollection(ArrayList::new));
    }

    private void getCombinations(final int N,
                                 final int n,
                                 final int k,
                                 final String x,
                                 final List<String> strings) {
        if (k == 0) {
            strings.add(x.substring(0,x.length()-1));
            return;
        }
        if (n == k) {
            addLeftOver(N, n, x, strings);
            return;
        }
        if (n < k) {
            return;
        }
        getCombinations(N, n - 1, k, x, strings);
        getCombinations(N, n - 1, k - 1, x + (N - n + 1) + SEPERATOR, strings);
    }

    private void addLeftOver(final int N,
                             int n,
                             final String x,
                             final List<String> strings) {
        final StringBuilder stringBuilder = new StringBuilder(x);
        while (n > 0) {
            stringBuilder.append(N - n + 1);
            stringBuilder.append(SEPERATOR);
            n--;
        }
        strings.add(stringBuilder.deleteCharAt(stringBuilder.length()-1).toString());
    }
}
