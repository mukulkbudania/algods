package prep.interview.geeks.companies.facebook;

public class TrailingImageFactorial {
    int trailingZeros(int n) {
        int count = 0;
        while (n > 0) {
            count += n / 5;
            n /= 5;
        }
        return count;

    }

    //Do binary search between k and 5k + 5.
    int getPreImage(final int K) {
        System.out.println(K);
        int low = 0;
        int high = 5 * (K + 1);
        while (low < high) {
            final int mid = (low + high) / 2;
            final int count = trailingZeros(mid);
            System.out.println("Mid: " + mid + " Count: " + count);
            if (count < K)
                low = mid + 1;
            else if (count > K)
                high = mid;
            else
                return 5;
        }
        return 0;
    }

    public static void main(final String[] args) {
        for (int i = 0; i < 180; i++) {
            System.out.println(i + " " + new TrailingImageFactorial().getPreImage(i));
        }

    }
}
