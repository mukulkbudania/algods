package prep.interview.geeks.companies.facebook;

import java.util.ArrayList;
import java.util.Arrays;

public class RemDup {
    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<>();
        input.addAll(Arrays.asList(new Integer[] { 5000, 5000, 5000 }));
        System.out.println(new RemDup().removeDuplicates(input));
    }

    public int removeDuplicates(ArrayList<Integer> a) {
        if (a == null)
            return 0;
        if (a.size() <= 1)
            return a.size();
        int distinctCount = 1;
        int i = 1;
        int n = a.size();
        while (i < n) {
            while (i < n && a.get(i).equals(a.get(i - 1))) {
                i++;
            }
            if (i != n) {
                a.set(distinctCount++, a.get(i++));
            }
        }
        for (i = n - 1; i >= distinctCount; i--) {
            a.remove(i);
        }
        a.stream()
         .forEach(x -> System.out.print(x + " "));
        return distinctCount;
    }
}
