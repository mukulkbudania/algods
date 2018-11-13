package prep.interview.geeks.algo.dynamic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mukulbudania on 8/30/17.
 */
public class KeyPadWays {
    private static Map<Character, List<Character>> charMap;

    static {
        charMap = new HashMap<>(10);
        charMap.put('1', Arrays.asList(new Character[] { '1', '2', '4' }));
        charMap.put('2', Arrays.asList(new Character[] { '1', '2', '3', '5' }));
        charMap.put('3', Arrays.asList(new Character[] { '6', '2', '3' }));
        charMap.put('4', Arrays.asList(new Character[] { '1', '5', '4', '7' }));
        charMap.put('5', Arrays.asList(new Character[] { '6', '2', '4', '8', '5' }));
        charMap.put('6', Arrays.asList(new Character[] { '6', '3', '5', '9' }));
        charMap.put('7', Arrays.asList(new Character[] { '7', '8', '4' }));
        charMap.put('8', Arrays.asList(new Character[] { '5', '7', '9', '0', '8' }));
        charMap.put('9', Arrays.asList(new Character[] { '6', '8', '9' }));
        charMap.put('0', Arrays.asList(new Character[] { '0', '8' }));
    }

    public static void main(String[] args) {
        System.out.println(new KeyPadWays().getWays(3));
    }

    public int getWays(int n) {
        int sum = 0;
        int lookup[][] = new int[10][n + 1];
        for (int i = 0; i <= 9; i++) {
            lookup[i][0] = 0;
            lookup[i][1] = 1;
            for (int j = 2; j <= n; j++)
                lookup[i][j] = -1;
        }
        for (int i = 0; i <= 9; i++) {
            sum += getWays((char) (i + '0'), n, lookup);
        }
        return sum;
    }

    private int getWays(char start,
                        int n,
                        int lookup[][]) {
        if (lookup[start - '0'][n] != -1)
            return lookup[start - '0'][n];
        int x = 0;
        for (Character c : charMap.get(start))
            x += getWays(c, n - 1, lookup);
        lookup[start - '0'][n] = x;
        return lookup[start - '0'][n];
    }
}
