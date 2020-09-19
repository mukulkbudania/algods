package geeks.companies.facebook;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Diffk2 {
    public static void main(String[] args) {
        Integer[] arr = { 5, 1, 5, 4, 1, 2 };
        System.out.println(new Diffk2().diffPossible(Arrays.asList(arr), 0));
    }

    public int diffPossible(final List<Integer> a,
                            int b) {
        int n = a.size();
        int i = 0;
        Collections.sort(a);
        while (i < n - 1) {
            int j = i + 1;
            while (j < n && (a.get(j) - a.get(i)) <= b) {
                if ((a.get(j) - a.get(i)) == b)
                    return 1;
                j++;
            }
            i++;
        }
        return 0;
    }
}
