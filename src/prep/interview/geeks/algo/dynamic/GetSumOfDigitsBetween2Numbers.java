package prep.interview.geeks.algo.dynamic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mukulbudania on 8/30/17.
 */
public class GetSumOfDigitsBetween2Numbers {
    private static int dp[][][] = new int[20][180][2];

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++)
            for (int j = 0; j < 180; j++)
                for (int k = 0; k < 2; k++)
                    dp[i][j][k] = -1;
        System.out.println(getRangeDigit(123, 1024));
    }

    private static int getRangeDigit(int start,
                                     int end) {
        List<Integer> startDigits = getDigits(start - 1);
        List<Integer> endDigits = getDigits(end);
        return (getDigitSum(endDigits) - getDigitSum(startDigits));
    }

    private static int getDigitSum(List<Integer> startDigits) {
        return getDigitSum(startDigits.size() - 1, 0, 1, startDigits);
    }

    private static int getDigitSum(int index,
                                   int sum,
                                   int tight,
                                   List<Integer> startDigits) {
        if (index < 0)
            return sum;
        if (dp[index][sum][tight] != -1 && tight != 1)
            return dp[index][sum][tight];
        int k = (tight == 1) ? startDigits.get(index) : 9;
        int res = 0;
        for (int i = 0; i <= k; i++) {
            int newTight = (i == startDigits.get(index)) ? tight : 0;
            res += getDigitSum(index - 1, sum + i, newTight, startDigits);
        }
        dp[index][sum][tight] = res;
        return res;
    }

    private static List<Integer> getDigits(int val) {
        List<Integer> digits = new ArrayList<>();
        while (val > 0) {
            digits.add(val % 10);
            val = val / 10;
        }
        //Collections.reverse(digits);
        return digits;
    }
}
