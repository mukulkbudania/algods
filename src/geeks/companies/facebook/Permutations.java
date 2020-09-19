package geeks.companies.facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {

    public static void main(final String[] args) {
        final Integer[] inputArr = { 1, 2, 3, 4, 5 };
        final List<Integer> inputList = Arrays.asList(inputArr);
        final ArrayList<Integer> input = new ArrayList<Integer>(inputList);
        final ArrayList<ArrayList<Integer>> result = new Permutations().permute(input);
        System.out.println(result.size());
        for(final ArrayList<Integer> list: result){
            for(final int a: list){
                System.out.print(a + " ");
            }
            System.out.println();
        }
    }

    public ArrayList<ArrayList<Integer>> permute(final ArrayList<Integer> a) {
        final ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        permute(a, 0, a.size() , results);
        return results;
    }

    private void permute(final ArrayList<Integer> a,
                         final int start,
                         final int end,
                         final ArrayList<ArrayList<Integer>> results) {
        if (start == end) {
            results.add(new ArrayList<>(a));
            return;
        }

        for (int i = start; i < end; i++) {
            swap(a, start, i);
            permute(a, start + 1, end, results);
            swap(a, i, start);
        }
    }

    private void swap(final ArrayList<Integer> a,
                      final int j,
                      final int i) {
        final int temp = a.get(j);
        a.set(j, a.get(i));
        a.set(i, temp);
    }

}
