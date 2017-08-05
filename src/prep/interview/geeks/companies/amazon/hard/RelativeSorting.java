package prep.interview.geeks.companies.amazon.hard;

import java.util.*;

/**
 * Created by mukulbudania on 8/2/17.
 */
public class RelativeSorting {
    public static void main(String[] args){
        Integer a[] = {2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8};
        Integer b[] = {2, 1, 8, 3};
        sort(a,b);
        print(a);
    }

    private static void print(Integer[] a) {
        for(int x: a) {
            System.out.print(x + " ");
        }
    }

    private static void sort(Integer[] a, Integer[] b) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<b.length;i++)map.put(b[i],i);
        Collections.sort(Arrays.asList(a), new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int index1 = (map.get(o1)!=null)?map.get(o1):Integer.MAX_VALUE;
                int index2 = (map.get(o2)!=null)?map.get(o2):Integer.MAX_VALUE;
                return index1-index2;
            }
        });
    }


}
