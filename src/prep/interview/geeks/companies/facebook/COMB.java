package prep.interview.geeks.companies.facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class COMB {
    public static void main(final String[] args) {
        final ArrayList<ArrayList<Integer>> result = new COMB().combinationSum(new ArrayList<>(Arrays.asList(new Integer[] { 2,3,6,7 })), 7);
        for (final ArrayList<Integer> list : result) {
            for (final int a : list) {
                System.out.print(a + " ");
            }
            System.out.println();
        }
    }

    ArrayList<ArrayList<Integer>> res;

    public ArrayList<ArrayList<Integer>> combinationSum(final ArrayList<Integer> A, final int B) {

        res = new ArrayList<>();
        final ArrayList<Integer> unique = new ArrayList<>();

        if (A == null)
            return res;

        Collections.sort(A);

        unique.add(A.get(0));
        for (int i = 0; i < A.size(); i++) {
            if (i != 0 && A.get(i) != A.get(i - 1))
                unique.add(A.get(i));
        }

        combinationSum(unique, new ArrayList<>(), B, 0);

        return res;

    }


    public void combinationSum(final ArrayList<Integer> A, final ArrayList<Integer> res, final int B, final int index) {
        if (B == 0) {
            this.res.add(new ArrayList(res));
            return;
        }

        if (B < 0) {
            return;
        }

        for (int i = index; i < A.size(); i++) {
            final int num = A.get(i);
            res.add(num);
            combinationSum(A, res, B - num, i);
            res.remove(res.size() - 1);
        }

    }


}
