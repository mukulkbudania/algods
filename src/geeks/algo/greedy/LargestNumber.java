package geeks.algo.greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by mukulbudania on 7/29/17.
 */
public class LargestNumber {
    public static void main(String[] args){
        String arr[] = {"3", "30", "34", "5", "9"};
        Collections.sort(Arrays.asList(arr), new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.concat(o1).compareTo(o1.concat(o2));
            }
        });
        for(int i=0;i<arr.length;i++) System.out.print(arr[i]);
    }
}
