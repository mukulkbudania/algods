package prep.interview.geeks.companies.facebook;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import prep.interview.geeks.companies.interviewbit.linkedlist.ListNode;

public class GreaterThanNBy3 {
    public static void main(final String[] args) {
        final List<Integer> input = Arrays.asList(1000382, 1000320, 1000573, 1000320, 1000325, 1000736, 1000320, 1000834, 1000635, 1000467, 1000320, 1000205, 1000320, 1000545);
        System.out.println(new GreaterThanNBy3().repeatedNumber(input));
    }

    public int repeatedNumber(final List<Integer> a) {
        final int n = a.size();
        if (n == 1)
            return a.get(0);
        if (n == 2)
            if ((a.get(0) == a.get(1)))
                ;
        final int[] x = new int[2];
        final int[] y = new int[2];
        x[0] = x[1] = -1;
        y[0] = y[1] = 0;
        for (int i = 0; i < n; i++) {
            if (x[0] == a.get(i)) {
                x[0] = a.get(i);
                y[0]++;
                continue;
            }
            if (a.get(i) == x[1]) {
                x[1] = a.get(i);
                y[1]++;
                continue;
            }
            if (y[0] == 0) {
                x[0] = a.get(i);
                y[0] = 1;
            } else if (y[1] == 0) {
                x[1] = a.get(i);
                y[1] = 1;
            } else {
                y[0]--;
                y[1]--;
            }
        }
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < n; i++) {
            if (a.get(i) == x[0])
                count1++;
            if (a.get(i) == x[1])
                count2++;
        }
        if (count1 > n / 3)
            return x[0];
        if (count2 > n / 3)
            return x[1];
        else
            return -1;
    }

    public ListNode reverseBetween(final ListNode a,
                                   final int m,
                                   final int n) {
        final Stack<Integer> stack = new Stack();
        ListNode listNode = a;
        int i = 0;
        while (i < m) {
            listNode = listNode.next;
            i++;
        }
        final ListNode start = listNode;
        while (i <= n) {
            stack.push(listNode.val);
            listNode = listNode.next;
            i++;
        }
        i = m;
        while (i <= n) {
            final int val = stack.pop();
            listNode.val = val;
            listNode = listNode.next;
            i++;
        }
        return a;
    }
}
