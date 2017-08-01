package prep.interview.geeks.ds.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by mukulbudania on 8/1/17.
 */
public class GenrateBinaryNumbers {
    public static void main(String[] args){
        int x = 20;
        printBinaryNumbers(x);
    }

    private static void printBinaryNumbers(int n) {
        String x = "1";
        Queue<String> q = new LinkedList<>();
        q.add(x);
        while (n-- > 0){
            String num = q.poll();
            System.out.println(num);
            q.add(num+"0");
            q.add(num+"1");
        }
    }
}
