package prep.interview.geeks.companies.facebook;

public class BinaryGap {
    public int binaryGap(int x) {
        int lastIndex = -1;
        int count = 0;
        int gap = 0;
        while (x > 0) {
            final int r = x & 1;
            if (r == 1) {
                if (lastIndex != -1) {
                    gap = Math.max(gap, count - lastIndex);
                }
                lastIndex = count;
            }
            x = x / 2;
            count++;
        }
        return gap;
    }

    public static void main(final String[] args) {
        System.out.println(new BinaryGap().binaryGap(18));
    }
}
